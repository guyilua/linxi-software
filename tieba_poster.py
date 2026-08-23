#!/usr/bin/env python3
"""
百度贴吧自动发帖脚本
- 基于贴吧公开API
- 需要BDUSS和STOKEN（从浏览器Cookie获取）
- 支持文本发帖+图片上传
"""

import requests
import re
import json
import time
import urllib3
from urllib.parse import urlencode, quote

urllib3.disable_warnings()

# ==================== 配置 ====================
# 从浏览器Cookie获取（需要完整Cookie才能通过验证）：
# 1. 打开 tieba.baidu.com 登录
# 2. F12 -> Application -> Cookies -> tieba.baidu.com
# 3. 复制以下所有字段的值
BAIDUID = "AD166CB6AE66BDEF6DB5F98B32713791:FG=1"
BDUSS = "GhrZ2dFamYtb3U2UmdpekNzUGZzQjdxSjRZUmdvSXRORGsxakJlWUZjNk1ySzlxRVFBQUFBJCQAAAAAAQAAAAEAAABJGnuiAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIwfiGqMH4hqd"
STOKEN = "504ae9c0e1d89f855aa04f50e6b2c08f680eddd1dd89622dc1297e70e15a8833"
TIEBAUID = "cee2d6fef22cb5ba6fd71b32"
PTOKEN = "d4062736bc4073df81294dbc41d0b142"
UBI = "fi_PncwhpxZ%7ETaJc%7EJ057xBfXscZqWqqUrJ"

# 组装完整Cookie
def get_full_cookie():
    return f"BAIDUID={BAIDUID}; BDUSS={BDUSS}; STOKEN={STOKEN}; TIEBAUID={TIEBAUID}; PTOKEN={PTOKEN}; UBI={UBI}"

# 默认发到的吧名（如"安卓吧"）
DEFAULT_KW = "安卓吧"

# ==================== 工具方法 ====================

def get_tbs() -> str:
    """获取tbs参数（防CSRF，有效期约24小时）"""
    url = "https://tieba.baidu.com/dc/common/tbs"
    headers = {
        "Cookie": get_full_cookie(),
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
        "Referer": "https://tieba.baidu.com/",
        "Accept": "application/json, text/javascript, */*; q=0.01",
        "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8",
        "X-Requested-With": "XMLHttpRequest",
    }
    try:
        resp = requests.get(url, headers=headers, verify=False, timeout=15)
        data = resp.json()
        if data.get("is_login") == 1:
            return data.get("tbs", "")
    except Exception as e:
        print(f"[-] 获取tbs失败: {e}")
    return ""

def get_fid(kw: str) -> str:
    """获取吧的fid"""
    url = f"https://tieba.baidu.com/f/commit/share/fnameShareApi?fname={kw}&ie=utf-8"
    try:
        resp = requests.get(url, verify=False, timeout=15)
        data = resp.json()
        if data.get("no") == 0:
            return str(data["data"].get("fid", ""))
    except Exception as e:
        print(f"[-] 获取fid失败: {e}")
    return ""

def upload_image_tieba(image_path: str) -> str:
    """上传图片到贴吧图床，返回图片URL"""
    upload_url = "https://tieba.baidu.com/c/p/img?save=Y&auto_size=1&cs=app"
    
    headers = {
        "Cookie": get_full_cookie(),
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
        "Referer": "https://tieba.baidu.com/",
    }
    
    try:
        with open(image_path, 'rb') as f:
            files = {'file': f}
            resp = requests.post(upload_url, files=files, headers=headers, verify=False, timeout=30)
            result = resp.json()
            if result.get("error") == "":
                return result.get("pic_url", "")
    except Exception as e:
        print(f"[-] 上传图片失败: {e}")
    return ""

def post_thread(kw: str, title: str, content: str, fid: str = "", img_url: str = "") -> dict:
    """在指定吧发主题帖
    
    Args:
        kw: 吧名（如"安卓吧"）
        title: 帖子标题
        content: 帖子内容（纯文本，换行用\n）
        fid: 吧的FID（可选，不传会自动获取）
        img_url: 图片URL（可选，已上传到贴吧图床的图片）
    """
    # 1. 获取tbs
    tbs = get_tbs()
    if not tbs:
        return {"error": "获取tbs失败，请检查Cookie是否有效"}
    
    # 2. 获取fid
    if not fid:
        fid = get_fid(kw)
    if not fid:
        return {"error": f"获取吧'{kw}'的fid失败"}
    
    # 3. 构造发帖数据
    post_content = content
    if img_url:
        post_content += f"\n\n[img]{img_url}[/img]"
    
    data = {
        "BDUSS": BDUSS,
        "kw": kw,
        "fid": fid,
        "title": title,
        "content": post_content,
        "tbs": tbs,
        "is_login": 1,
        "src": "3",
        "anonymous": 0,
        "new_vcode": 1,
        "tag": "11",
        "geetest_success_token": "",
        "vcode": "",
        "vcodeMd5": "",
    }
    
    # 4. 发POST请求
    url = "https://tieba.baidu.com/f/commit/thread/add"
    headers = {
        "Cookie": get_full_cookie(),
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
        "Referer": f"https://tieba.baidu.com/f?kw={quote(kw, safe='')}",
        "Content-Type": "application/x-www-form-urlencoded",
        "X-Requested-With": "XMLHttpRequest",
        "Accept": "application/json, text/javascript, */*; q=0.01",
        "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8",
    }
    
    try:
        resp = requests.post(url, data=urlencode(data), headers=headers, verify=False, timeout=30)
        result = resp.json()
        
        # 解析返回结果
        if result.get("err_code") == 0 or result.get("no") == 0:
            return {"success": True, "msg": "发帖成功", "tid": result.get("data", {}).get("tid", "")}
        else:
            return {"success": False, "msg": result.get("err_msg", result.get("error", result.get("no", "未知错误")))}
    except Exception as e:
        return {"success": False, "msg": f"请求异常: {e}"}

# ==================== 主程序 ====================

def main():
    """示例：发一条帖子"""
    if not BDUSS or not STOKEN:
        print("[-] 请先配置BDUSS和STOKEN")
        print("[*] 获取方法：")
        print("    1. 浏览器打开 tieba.baidu.com 并登录")
        print("    2. 按F12打开开发者工具")
        print("    3. Application -> Cookies -> tieba.baidu.com")
        print("    4. 复制 BDUSS, STOKEN, BAIDUID, TIEBAUID, PTOKEN, UBI")
        return
    
    # 示例发帖
    title = "【分享】Weather天气雷达解锁版 - 精准天气监测工具"
    content = """雷达实时捕捉云图，精准预判短时降雨大风

【资源名称】Weather&Radar Pro
【资源版本】2026.16.1
【资源大小】53.44M
【资源系统】安卓

【资源介绍】Weather&Radar Pro是专业天气工具，搭载实时气象雷达，支持小时、14天预报，可查看湿度、气压、紫外线、日出月相等详细气象数据。

下载链接：https://pan.quark.cn/s/087d06d860fa"""
    
    result = post_thread(DEFAULT_KW, title, content)
    
    if result.get("success"):
        print(f"[+] 发帖成功! 帖子ID: {result.get('tid')}")
    else:
        print(f"[-] 发帖失败: {result.get('msg')}")

if __name__ == "__main__":
    main()
