#!/usr/bin/env python3
"""
软天空发帖测试 - 带图片上传
从源站抓取帖子+截图，上传图片到软天空后发帖
"""

import hashlib
import base64
import json
import re
import time
import io
import requests
import urllib3
from Crypto.Cipher import AES

urllib3.disable_warnings()

# ==================== 常量 ====================
LOGIN_BASE = "http://rtkapi.ruansky.net/"
API_BASE = "https://rtkapi2.ruansky.net/"
UPLOAD_BASE = "http://down.ruansky.com/"
AES_KEY = b"P.8CGq@Wr~Vs]!4!"

DEVICE_ID = "a1b2c3d4e5f6g7h8"
BRAND = "samsung"
MODEL = "SM-G9910"
DEVICE_NAME = f"{BRAND}_{MODEL}"
VERSION_CODE = "8730"
API_LEVEL = "33"
CHANNEL = "yingyongbao"

SOURCE_SITE = "http://img.lysq.cc.cd"
USERNAME = "13184017302"
PASSWORD = "123456Wq"
MID = "1"

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

# ==================== 登录 ====================

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

    if result.get("code") in (0, "0", "200"):
        data = result.get("data", {})
        print(f"[+] 登录成功! UID={data.get('uid')}")
        return data
    else:
        print(f"[-] 登录失败: {result.get('msg', '未知错误')}")
        return None

# ==================== 图片上传 ====================

def upload_image(uid: str, token: str, image_url: str) -> str:
    """上传图片到软天空，返回 [img]url[/img] 标签"""
    print(f"  [>] 下载图片: {image_url}")
    try:
        resp = requests.get(image_url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
        if resp.status_code != 200:
            print(f"  [-] 下载失败: HTTP {resp.status_code}")
            return ""
        img_data = resp.content
        print(f"  [+] 图片大小: {len(img_data)} bytes")
    except Exception as e:
        print(f"  [-] 下载异常: {e}")
        return ""

    # 从URL提取文件名
    filename = image_url.split("/")[-1]
    # 确保有扩展名
    if "." not in filename:
        filename += ".jpg"

    upload_url = UPLOAD_BASE + "html/filelist/uploadBbsImg"

    # multipart表单
    files = {
        "upfile[]": (filename, img_data, "application/octet-stream"),
    }
    data = {
        "channel": CHANNEL,
        "version": VERSION_CODE,
        "api_level": API_LEVEL,
        "phone_model": get_phone_model(),
        "type": "picture",
        "uid": uid,
        "token": token,
        "level": "1",
    }

    print(f"  [>] 上传到软天空 ...")
    resp = requests.post(
        upload_url, files=files, data=data, verify=False, timeout=30,
        headers={"User-Agent": "okhttp/4.9.3"}
    )
    print(f"  [>] 上传响应: {resp.text[:500]}")

    try:
        result = resp.json()
        if result.get("code") in (0, "0", 200, "200"):
            path = result.get("path", {})
            url = path.get("url", "")
            thumb = path.get("thumb", "")
            img_tag = f"[img]{url}{thumb}[/img]"
            print(f"  [+] 上传成功: {img_tag}")
            return img_tag
        else:
            print(f"  [-] 上传失败: {result.get('msg', '未知错误')}")
            return ""
    except Exception as e:
        print(f"  [-] 解析响应异常: {e}")
        return ""

# ==================== 发帖 ====================

def publish_post(uid: str, token: str, mid: str, title: str, content: str,
                 tags: str = "", pid: str = "", family_id: str = "") -> dict:
    print(f"[*] 发帖 -> 版块{mid}: {title[:40]}...")
    params = {
        "channel": CHANNEL,
        "version": VERSION_CODE,
        "api_level": API_LEVEL,
        "phone_model": get_phone_model(),
        "$*$os_info": get_os_info(),
        "uid": uid,
        "token": token,
        "mid": mid,
        "$*$tags": tags,
        "$*$device_name": DEVICE_NAME,
        "$*$content": content,
        "$*$os_version": "13",
        "$*$pid": pid,
        "display_mode": "2",
        "title": title,
    }
    if family_id:
        params["$*$family_id"] = family_id

    key = calc_key_from_map(params)
    params["key"] = key
    params["diN"] = get_din()

    url = API_BASE + "bbs/posts-save"
    form_data = {}
    for k, v in params.items():
        clean_k = k.replace("$*$", "") if k.startswith("$*$") else k
        form_data[clean_k] = v

    resp = requests.post(url, data=form_data, verify=False, timeout=15, headers={"User-Agent": "okhttp/4.9.3"})
    return decrypt_response(resp.json())

# ==================== 源站抓取 ====================

def fetch_post_with_images(post_id: str) -> dict:
    """从源站抓取帖子详情和截图"""
    url = f"{SOURCE_SITE}/software.php?id={post_id}"
    print(f"[*] 抓取源站帖子: {url}")
    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
    html = resp.text

    # 标题
    title_match = re.search(r'<title>(.*?)</title>', html)
    title = title_match.group(1) if title_match else ""
    title = re.sub(r'林夕软件库\s*-\s*', '', title).strip()

    # 正文内容
    lines = html.split('\n')
    content_lines = []
    for line in lines:
        text = re.sub(r'<[^>]+>', '', line).strip()
        text = text.replace('&amp;', '&')
        if not text:
            continue
        if (text.startswith('\u3010') or
            text.startswith('\u2014\u2014\u2014') or
            (text.startswith('\u672c') and ('\u5b66\u4e60' in text or '\u793e\u533a' in text)) or
            text.startswith('#\u3010')):
            content_lines.append(text)

    if not content_lines:
        desc = re.search(r'<meta name="description" content="(.*?)"', html)
        if desc:
            content_lines = [desc.group(1)]

    content = '\n'.join(content_lines) if content_lines else title

    # 提取截图URL（完整路径）
    screenshots = []
    for match in re.finditer(r'src="(uploads/screenshots/[^"]+)"', html):
        img_url = f"{SOURCE_SITE}/{match.group(1)}"
        if img_url not in screenshots:
            screenshots.append(img_url)

    print(f"  [+] 标题: {title[:50]}")
    print(f"  [+] 截图数量: {len(screenshots)}")

    return {
        'id': post_id,
        'title': title,
        'content': content,
        'screenshots': screenshots,
    }

# ==================== 主程序 ====================

def main():
    # 1. 登录
    login_data = login(USERNAME, PASSWORD)
    if not login_data:
        return

    uid = str(login_data.get("uid", "0"))
    token = login_data.get("token", "")

    # 2. 抓取源站帖子（取第一个）
    post = fetch_post_with_images("17769")

    if not post['title']:
        print("[-] 标题为空，退出")
        return

    # 3. 上传截图到软天空
    img_tags = []
    for img_url in post['screenshots']:
        img_tag = upload_image(uid, token, img_url)
        if img_tag:
            img_tags.append(img_tag)
        time.sleep(1)  # 上传间隔

    # 4. 构造帖子内容（正文 + 图片）
    content = post['content']
    if img_tags:
        content += "\n\n" + "\n".join(img_tags)

    print(f"\n[*] 最终帖子内容（前200字）:")
    print(content[:200])

    # 5. 发帖
    result = publish_post(
        uid=uid, token=token, mid=MID,
        title=post['title'],
        content=content,
        tags="软件分享",
    )

    code = result.get("code")
    msg = result.get("msg", "")
    if code in (0, "0"):
        print(f"\n[+] 发帖成功! {msg}")
        print(f"    帖子ID: {result.get('data', {}).get('id', 'N/A')}")
    else:
        print(f"\n[-] 发帖失败: {msg}")
        print(f"    完整返回: {json.dumps(result, ensure_ascii=False)}")

if __name__ == "__main__":
    main()
