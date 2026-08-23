#!/usr/bin/env python3
"""
软天空自动发帖脚本
- 从 img.lysq.cc.cd 抓取软件帖子
- 自动登录软天空并发帖
"""

import hashlib
import base64
import json
import re
import time
import requests
import urllib3
from Crypto.Cipher import AES

urllib3.disable_warnings()

# ==================== 常量 ====================
# 登录在 rtkapi.ruansky.net(http), 发帖在 rtkapi2.ruansky.net(https)
LOGIN_BASE = "http://rtkapi.ruansky.net/"
API_BASE = "https://rtkapi2.ruansky.net/"
AES_KEY = b"P.8CGq@Wr~Vs]!4!"

# 模拟设备参数
DEVICE_ID = "a1b2c3d4e5f6g7h8"
BRAND = "samsung"
MODEL = "SM-G9910"
DEVICE_NAME = f"{BRAND}_{MODEL}"
VERSION_CODE = "8730"
API_LEVEL = "33"
CHANNEL = "yingyongbao"

SOURCE_SITE = "http://img.lysq.cc.cd"

# ==================== 工具方法 ====================

def md5(s: str) -> str:
    return hashlib.md5(s.encode()).hexdigest()

def unicode_escape(s: str) -> str:
    """对应 c0.b()"""
    result = ""
    for c in s:
        if ord(c) <= 256:
            result += "\\u00" + format(ord(c), 'x')
        else:
            result += "\\u" + format(ord(c), 'x')
    return result

def get_phone_model() -> str:
    return unicode_escape(f"{BRAND}_{MODEL}")

def get_os_info() -> str:
    return "V1__unknown"

def get_din() -> str:
    """对应 y.r()"""
    oid = DEVICE_ID
    length = len(oid)
    n = length // 8
    r = length % 8
    result = ""
    for i in range(n):
        sub = oid[i*8:(i+1)*8]
        result += sub[::-1]
    result += oid[n*8:n*8+r][::-1]
    return "2a" + result + "d9"

def sort_and_join(params: list) -> str:
    """对应 c0.e() - 排序后用&拼接"""
    arr = params.copy()
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
    return "&" + "&".join(arr)

def calc_key(params_list: list) -> str:
    """对应 t.c0(c0.e(...))"""
    sorted_str = sort_and_join(params_list)
    return md5(AES_KEY.decode() + sorted_str)

def calc_key_from_map(param_map: dict) -> str:
    """对应 t.L(map) - 排除$*$参数"""
    params = []
    for k, v in param_map.items():
        if not k.startswith("$*$"):
            params.append(f"{k}={v}")
    return calc_key(params)

def decrypt_response(resp_json: dict) -> dict:
    """解密API返回数据"""
    if not resp_json.get("validation"):
        return resp_json
    data_b64 = resp_json.get("data", "")
    iv_b64 = resp_json.get("iv", "")
    if not data_b64:
        return resp_json
    data = base64.b64decode(data_b64)
    iv = base64.b64decode(iv_b64)
    cipher = AES.new(AES_KEY, AES.MODE_CBC, iv)
    decrypted = cipher.decrypt(data)
    # NoPadding模式：去掉尾部的null字节
    text = decrypted.rstrip(b'\x00').decode('utf-8', errors='ignore').strip()
    try:
        return json.loads(text)
    except:
        return {"raw": text}

def get_common_params() -> dict:
    return {
        "channel": CHANNEL,
        "version": VERSION_CODE,
        "api_level": API_LEVEL,
        "phone_model": get_phone_model(),
        "$*$os_info": get_os_info(),
    }

def get_auth_params(uid: str, token: str) -> dict:
    params = get_common_params()
    params["uid"] = uid
    params["token"] = token
    return params

# ==================== API 调用 ====================

def api_get(base: str, path: str, params: dict) -> dict:
    url = base + path + "?"
    for k, v in params.items():
        clean_k = k.replace("$*$", "") if k.startswith("$*$") else k
        url += f"&{clean_k}={v}"
    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "okhttp/4.9.3"})
    return decrypt_response(resp.json())

def api_post(url: str, params: dict) -> dict:
    form_data = {}
    for k, v in params.items():
        clean_k = k.replace("$*$", "") if k.startswith("$*$") else k
        form_data[clean_k] = v
    resp = requests.post(url, data=form_data, verify=False, timeout=15, headers={"User-Agent": "okhttp/4.9.3"})
    return decrypt_response(resp.json())

def login(username: str, password: str) -> dict:
    print(f"[*] 正在登录 {username} ...")
    upsw = md5(password)
    phone_model = get_phone_model()

    sign_params = [
        f"channel={CHANNEL}", f"version={VERSION_CODE}", f"api_level={API_LEVEL}",
        f"phone_model={phone_model}", f"uname={username}", f"upsw={upsw}",
        f"device_id={DEVICE_ID}", f"device_name={DEVICE_NAME}",
    ]
    key = calc_key(sign_params)

    url = (f"{LOGIN_BASE}member/loginVerify"
           f"?channel={CHANNEL}&version={VERSION_CODE}&api_level={API_LEVEL}"
           f"&phone_model={phone_model}&os_info={get_os_info()}"
           f"&uname={username}&upsw={upsw}"
           f"&device_id={DEVICE_ID}&device_name={DEVICE_NAME}"
           f"&client_id=1&key={key}")

    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "okhttp/4.9.3"})
    result = decrypt_response(resp.json())

    if result.get("code") == 0 or result.get("code") == "0" or result.get("code") == "200":
        data = result.get("data", {})
        print(f"[+] 登录成功! UID={data.get('uid')}, 昵称={data.get('nickname', 'N/A')}")
        return data
    else:
        print(f"[-] 登录失败: {result.get('msg', '未知错误')}")
        print(f"    完整返回: {json.dumps(result, ensure_ascii=False)}")
        return None

def get_community_list(uid: str, token: str) -> dict:
    params = get_auth_params(uid, token)
    key = calc_key_from_map(params)
    params["key"] = key
    return api_get(API_BASE, "family/list", params)

def get_family_bbs_list(uid: str, token: str, page: int = 1) -> dict:
    params = get_auth_params(uid, token)
    params["page"] = str(page)
    key = calc_key_from_map(params)
    params["key"] = key
    return api_get(API_BASE, "family/bbs/list/posts", params)

def publish_post(uid: str, token: str, mid: str, title: str, content: str,
                 tags: str = "", pid: str = "", family_id: str = "") -> dict:
    print(f"[*] 发帖 -> 版块{mid}: {title[:40]}...")
    params = get_auth_params(uid, token)
    params["mid"] = mid
    params["$*$tags"] = tags
    params["$*$device_name"] = DEVICE_NAME
    params["$*$content"] = content
    params["$*$os_version"] = "13"
    params["$*$pid"] = pid
    params["display_mode"] = "2"
    if family_id:
        params["$*$family_id"] = family_id
    params["title"] = title
    # 先算签名（diN不参与签名，在key之后加入）
    key = calc_key_from_map(params)
    params["key"] = key
    params["diN"] = get_din()
    url = API_BASE + "bbs/posts-save"
    return api_post(url, params)

# ==================== 源站抓取 ====================

def fetch_post_list() -> list:
    """从源站获取帖子ID列表"""
    print(f"[*] 从 {SOURCE_SITE} 抓取帖子列表 ...")
    resp = requests.get(SOURCE_SITE, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
    ids = re.findall(r'software\.php\?id=(\d+)', resp.text)
    ids = list(dict.fromkeys(ids))
    print(f"[+] 找到 {len(ids)} 个帖子")
    return ids

def fetch_post_detail(post_id: str) -> dict:
    """从源站抓取帖子详情"""
    url = f"{SOURCE_SITE}/software.php?id={post_id}"
    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
    html = resp.text

    # 提取标题
    title_match = re.search(r'<title>(.*?)</title>', html)
    title = title_match.group(1) if title_match else ""
    title = re.sub(r'林夕软件库\s*-\s*', '', title).strip()

    # 提取正文 - 只抓【】开头的内容行和声明
    lines = html.split('\n')
    content_lines = []
    for line in lines:
        text = re.sub(r'<[^>]+>', '', line).strip()
        text = text.replace('&amp;', '&')
        if not text:
            continue
        # 只保留正文内容
        if (text.startswith('【') or
            text.startswith('———') or
            (text.startswith('本') and ('学习' in text or '社区' in text)) or
            text.startswith('#【')):
            content_lines.append(text)

    # 如果没抓到【】格式内容，用描述作为内容
    if not content_lines:
        desc = re.search(r'<meta name="description" content="(.*?)"', html)
        if desc:
            content_lines = [desc.group(1)]

    content = '\n'.join(content_lines) if content_lines else title

    return {
        'id': post_id,
        'title': title,
        'content': content,
    }

# ==================== 主程序 ====================

def main():
    USERNAME = "13184017302"
    PASSWORD = "123456Wq"
    MID = "1"  # 发帖版块ID

    # 1. 登录
    login_data = login(USERNAME, PASSWORD)
    if not login_data:
        return

    uid = str(login_data.get("uid", "0"))
    token = login_data.get("token", "")

    # 2. 从源站抓取帖子
    print("\n[*] 开始从源站抓取帖子 ...")
    post_ids = fetch_post_list()

    # 3. 批量发帖
    success = 0
    fail = 0
    for i, pid in enumerate(post_ids):
        print(f"\n[{i+1}/{len(post_ids)}] 处理帖子 ID={pid}")
        detail = fetch_post_detail(pid)
        print(f"    标题: {detail['title'][:50]}")

        if not detail['title'] or not detail['content']:
            print("    [-] 跳过：标题或内容为空")
            fail += 1
            continue

        result = publish_post(
            uid=uid, token=token, mid=MID,
            title=detail['title'],
            content=detail['content'],
            tags="软件分享",
        )

        code = result.get("code")
        msg = result.get("msg", "")
        if code == 0 or code == "0":
            print(f"    [+] 发帖成功: {msg}")
            success += 1
        else:
            print(f"    [-] 发帖失败: {msg}")
            fail += 1

        # 间隔60秒，软天空发帖频率限制
        if i < len(post_ids) - 1:
            print(f"    等待60秒（软天空发帖频率限制）...")
            time.sleep(60)

    print(f"\n{'='*50}")
    print(f"批量发帖完成: 成功 {success}, 失败 {fail}, 总计 {len(post_ids)}")

if __name__ == "__main__":
    main()
