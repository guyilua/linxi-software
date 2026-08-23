#!/usr/bin/env python3
"""
软天空自动评论脚本
- 账号: 19266031421 / 123456Wq
- 评论词随机选择
- 随机帖子评论
- 间隔1-3分钟随机
"""

import hashlib
import base64
import json
import random
import time
import os
import requests
import urllib3
from Crypto.Cipher import AES

urllib3.disable_warnings()

# ==================== 常量 ====================
LOGIN_BASE = "http://rtkapi.ruansky.net/"
API_BASE = "https://rtkapi2.ruansky.net/"
AES_KEY = b"P.8CGq@Wr~Vs]!4!"

DEVICE_ID = "a1b2c3d4e5f6g7h8"
BRAND = "samsung"
MODEL = "SM-G9910"
DEVICE_NAME = f"{BRAND}_{MODEL}"
VERSION_CODE = "8730"
API_LEVEL = "33"
CHANNEL = "yingyongbao"

USERNAME = "19266031421"
PASSWORD = "123456Wq"

# 评论词列表（按场景分组，随机选取更自然）
COMMENT_WORDS = [
    # 通用资源类
    "有最新版",
    "免费辅助",
    "有辅助",
    "有资源",
    "资源不错",
    "顶一个",
    "好用",
    "收藏了",
    "感谢分享",
    "正是我需要的",
    "mark一下",
    "求更新",
    "有没有汉化版",
    "测试可用",
    "已下载",
    # 工具/软件类
    "这个工具挺实用的",
    "有没有免root版本",
    "功能很全",
    "安装包多大",
    "兼容安卓14吗",
    "有没有ios版",
    "一直用这个",
    "更新挺快的",
    # 游戏类
    "游戏资源还行",
    "有mod吗",
    "能联机吗",
    "求存档",
    "通关了回来感谢",
    # 互动类
    "楼主还在吗",
    "链接失效了吗",
    "能私信发一下吗",
    "密码是多少",
    "下载速度怎么样",
    "有没有教程",
    "新手能用吗",
    "需要root吗",
    # 短评（更像真人随手评论）
    "666",
    "牛",
    "可以的",
    "稳",
    "确实",
    "学到了",
    "不错",
    "挺好",
]

# 上次发送时间记录
LAST_SEND_FILE = "last_comment_time.json"
COMMENTED_FILE = "commented_ids.json"

# ==================== 已评论记录 ====================

def load_commented_ids() -> set:
    """加载已评论的帖子ID集合"""
    if os.path.exists(COMMENTED_FILE):
        try:
            with open(COMMENTED_FILE, 'r', encoding='utf-8') as f:
                data = json.load(f)
                return set(str(x) for x in data.get('ids', []))
        except:
            pass
    return set()

def save_commented_id(post_id: str):
    """记录已评论的帖子ID"""
    commented = load_commented_ids()
    commented.add(str(post_id))
    with open(COMMENTED_FILE, 'w', encoding='utf-8') as f:
        json.dump({'ids': list(commented)}, f, ensure_ascii=False)

# ==================== 工具方法 ====================

def md5(s: str) -> str:
    return hashlib.md5(s.encode()).hexdigest()

def unicode_escape(s: str) -> str:
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
    arr = params.copy()
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
    return "&" + "&".join(arr)

def calc_key(params_list: list) -> str:
    sorted_str = sort_and_join(params_list)
    return md5(AES_KEY.decode() + sorted_str)

def calc_key_from_map(param_map: dict) -> str:
    params = []
    for k, v in param_map.items():
        if not k.startswith("$*$"):
            params.append(f"{k}={v}")
    return calc_key(params)

def decrypt_response(resp_json: dict) -> dict:
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

# ==================== 登录 ====================

def login(username: str, password: str) -> dict:
    print(f"[*] 登录 {username} ...")
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

    if result.get("code") in (0, "0", "200"):
        data = result.get("data", {})
        print(f"[+] 登录成功! UID={data.get('uid')}")
        return data
    else:
        print(f"[-] 登录失败: {result.get('msg', '未知错误')}")
        return None

# ==================== 获取帖子列表 ====================

def get_posts_list(uid: str, token: str, mid: str = "1", page: int = 1, limit: int = 20) -> list:
    """从软天空API获取真实帖子列表"""
    # members/postsList 签名只用4个基础参数
    phone_model = get_phone_model()
    sign_params = [
        f"api_level={API_LEVEL}",
        f"channel={CHANNEL}",
        f"phone_model={phone_model}",
        f"version={VERSION_CODE}",
    ]
    for i in range(len(sign_params)):
        for j in range(i + 1, len(sign_params)):
            if sign_params[i] > sign_params[j]:
                sign_params[i], sign_params[j] = sign_params[j], sign_params[i]
    
    key = calc_key(sign_params)
    
    url = (f"{LOGIN_BASE}members/postsList"
           f"?channel={CHANNEL}&version={VERSION_CODE}&api_level={API_LEVEL}"
           f"&phone_model={phone_model}&uid={uid}&token={token}"
           f"&mid={mid}&type=release&tags=&page={page}&limit={limit}"
           f"&key={key}")
    
    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "okhttp/4.9.3"})
    result = decrypt_response(resp.json())
    
    if result.get("code") in (0, "0"):
        data = result.get("data", [])
        # data可能是list或dict包含list
        if isinstance(data, list):
            items = data
        elif isinstance(data, dict):
            items = data.get("list", [])
        else:
            items = []
        print(f"[+] API返回 {len(items)} 条帖子")
        return items
    
    print(f"[-] 获取帖子列表失败: {result.get('msg', '未知错误')}")
    return []

# ==================== 发表评论 ====================

def post_comment(uid: str, token: str, pid: str, mid: str, content: str) -> dict:
    """发表评论 - 签名只用8个固定参数（与发帖签名完全不同）"""
    print(f"[*] 评论帖子 pid={pid}: {content}")
    
    # content需要Base64编码
    content_b64 = base64.b64encode(content.encode()).decode()
    
    # 评论签名参数（仅8个，按字母顺序冒泡排序）
    sign_params = [
        f"api_level={API_LEVEL}",
        f"channel={CHANNEL}",
        "display_mode=2",
        f"phone_model={get_phone_model()}",
        f"pid={pid}",
        f"token={token}",
        f"uid={uid}",
        f"version={VERSION_CODE}",
    ]
    # 冒泡排序（字符串字典序）
    for i in range(len(sign_params)):
        for j in range(i + 1, len(sign_params)):
            if sign_params[i] > sign_params[j]:
                sign_params[i], sign_params[j] = sign_params[j], sign_params[i]
    
    key = calc_key(sign_params)
    
    # 构造请求参数（不参与签名的）
    params = get_auth_params(uid, token)
    params["mid"] = mid
    params["pid"] = pid
    params["toUser"] = "0"
    params["root_cmt_id"] = "0"
    params["reply_cmt_id"] = "0"
    params["content"] = content_b64
    params["display_mode"] = "2"
    params["device_name"] = DEVICE_NAME
    params["os_version"] = "13"
    params["key"] = key
    params["diN"] = get_din()
    
    url = API_BASE + "bbs/posts/comment"
    return api_post(url, params)

# ==================== 时间控制 ====================

def should_send() -> bool:
    """判断是否应该发送（距离上次发送超过1-3分钟的随机间隔）"""
    now = time.time()
    last_send = 0
    if os.path.exists(LAST_SEND_FILE):
        try:
            with open(LAST_SEND_FILE, 'r') as f:
                data = json.load(f)
                last_send = data.get('time', 0)
        except:
            pass
    
    interval = random.randint(60, 180)  # 1-3分钟
    if now - last_send >= interval:
        return True
    return False

def record_send():
    with open(LAST_SEND_FILE, 'w') as f:
        json.dump({'time': time.time()}, f)

# ==================== 主程序 ====================

def main():
    # 检查是否应该发送
    if not should_send():
        print("[*] 间隔未到，跳过本次")
        return
    
    # 登录
    login_data = login(USERNAME, PASSWORD)
    if not login_data:
        return
    
    uid = str(login_data.get("uid", "0"))
    token = login_data.get("token", "")
    
    # 无限翻页获取帖子，直到找到未评论的
    print("[*] 获取帖子列表...")
    commented_ids = load_commented_ids()
    uncom_posts = []
    
    # 随机选起始页（1-50），避免每次都从第1页开始
    start_page = random.randint(1, 50)
    max_pages = 50  # 单次最多翻50页
    
    for offset in range(max_pages):
        page = start_page + offset
        posts = get_posts_list(uid, token, mid="1", page=page, limit=20)
        
        if not posts:
            print(f"[*] 第{page}页无数据，停止翻页")
            break
        
        # 过滤未评论的
        for p in posts:
            pid = str(p.get("pid", p.get("id", "0")))
            if pid not in commented_ids:
                uncom_posts.append(p)
        
        print(f"[*] 第{page}页: 获取{len(posts)}条，累计未评论{len(uncom_posts)}条")
        
        # 只要有未评论的帖子，就可以停止了（避免请求太多）
        if uncom_posts:
            break
        
        time.sleep(0.5)
    
    if not uncom_posts:
        print("[-] 翻页50页仍未找到未评论的帖子，可能全部评论过了")
        return
    
    print(f"[+] 找到 {len(uncom_posts)} 条未评论帖子")
    
    # 随机选择一条未评论帖子
    post = random.choice(uncom_posts)
    pid = str(post.get("pid", post.get("id", "0")))
    mid = str(post.get("mid", "1"))
    title = post.get("title", "")
    print(f"[*] 选中帖子: {title[:50]} (pid={pid})")
    
    # 随机选择评论词
    comment = random.choice(COMMENT_WORDS)
    print(f"[*] 评论内容: {comment}")
    
    # 发表评论
    result = post_comment(uid, token, pid, mid, comment)
    code = result.get("code")
    msg = result.get("msg", "")
    
    if code in (0, "0"):
        print(f"[+] 评论成功! {msg}")
        record_send()
        save_commented_id(pid)
    else:
        print(f"[-] 评论失败: {msg}")
        print(f"    完整返回: {json.dumps(result, ensure_ascii=False)}")

if __name__ == "__main__":
    main()
