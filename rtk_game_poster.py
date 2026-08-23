#!/usr/bin/env python3
"""
软天空自动发帖脚本（全部分类+智能去重）
- 从 all_posts_full.json 加载全部12745条帖子
- 自动跳过已发帖的ID
- 发新内容，不重复
- 支持全部分类：游戏/工具/音乐/视频/阅读等
"""

import hashlib
import base64
import json
import re
import time
import os
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

POSTED_FILE = "posted_ids.json"

# ==================== 已发帖记录 ====================

def load_posted_ids() -> set:
    """加载已发帖的源站ID集合"""
    if os.path.exists(POSTED_FILE):
        try:
            with open(POSTED_FILE, 'r', encoding='utf-8') as f:
                data = json.load(f)
                return set(str(x) for x in data.get('ids', []))
        except:
            pass
    return set()

def save_posted_id(post_id: str):
    """记录已发帖的源站ID"""
    posted = load_posted_ids()
    posted.add(str(post_id))
    with open(POSTED_FILE, 'w', encoding='utf-8') as f:
        json.dump({'ids': list(posted)}, f, ensure_ascii=False)

def save_posted_ids(post_ids: list):
    """批量记录已发帖的源站ID"""
    posted = load_posted_ids()
    posted.update(str(x) for x in post_ids)
    with open(POSTED_FILE, 'w', encoding='utf-8') as f:
        json.dump({'ids': list(posted)}, f, ensure_ascii=False)

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

# 软天空发帖敏感字符过滤
def sanitize_for_post(text: str) -> str:
    """过滤可能导致‘敏感字符’报错的特殊字符和 emoji"""
    # 1. 替换常见 emoji 与特殊符号
    emoji_pattern = re.compile(
        "["
        "\U0001F600-\U0001F64F"  # emoticons
        "\U0001F300-\U0001F5FF"  # symbols & pictographs
        "\U0001F680-\U0001F6FF"  # transport & map
        "\U0001F1E0-\U0001F1FF"  # flags
        "\U00002702-\U000027B0"
        "\U000024C2-\U0001F251"
        "\U0001F900-\U0001F9FF"  # supplemental symbols
        "\u2600-\u26FF"           # misc symbols
        "\u2700-\u27BF"           # dingbats
        "]+", flags=re.UNICODE
    )
    text = emoji_pattern.sub("", text)

    # 2. 替换一些高危特殊字符为安全字符
    replacements = {
        "+": " ",
        "※": "*",
        "❶": "1", "❷": "2", "❸": "3", "❹": "4", "❺": "5",
        "❻": "6", "❼": "7", "❽": "8", "❾": "9", "❿": "10",
        "①": "1", "②": "2", "③": "3", "④": "4", "⑤": "5",
        "⑥": "6", "⑦": "7", "⑧": "8", "⑨": "9", "⑩": "10",
        "【": "[", "】": "]",
        "「": "[", "」": "]",
        "『": "[", "』": "]",
        "｜": "|",
        "／": "/",
        "＼": "\\",
        "～": "~",
        "：": ":",
        "；": ";",
        "，": ",",
        "。": ".",
        "？": "?",
        "！": "!",
        "（": "(", "）": ")",
        "《": "<", "》": ">",
        "…": "...",
        "—": "-",
        "–": "-",
        "━": "-",
        "▁": "-", "▂": "-", "▃": "-", "▄": "-", "▅": "-",
        "▆": "-", "▇": "-", "█": "-",
        "∽": "~", "∼": "~",
        "⚠": "", "⚡": "", "🔴": "", "🔒": "", "❗": "",
        "★": "*", "☆": "*", "✦": "*", "✧": "*",
        "●": "*", "○": "*", "■": "*", "□": "*",
        "▲": "*", "△": "*", "▼": "*", "▽": "*",
        "♠": "", "♥": "", "♦": "", "♣": "",
        "⚖": "",  # 天平 emoji，已知触发敏感字符
    }
    for old, new in replacements.items():
        text = text.replace(old, new)

    # 3. 把连续的特殊符号行（纯分隔线）缩减为简单分隔线
    text = re.sub(r'[-=_*~#\|]{4,}', "---", text)

    # 4. 清理多余空格和空行
    text = re.sub(r'\n{3,}', "\n\n", text)
    text = text.strip()
    return text

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

    if result.get("code") in (0, "0", "200"):
        data = result.get("data", {})
        print(f"[+] 登录成功! UID={data.get('uid')}")
        return data
    else:
        print(f"[-] 登录失败: {result.get('msg', '未知错误')}")
        return {}

def upload_image(uid: str, token: str, image_url: str) -> str:
    print(f"  [>] 下载图片: {image_url}")
    try:
        resp = requests.get(image_url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
        if resp.status_code != 200:
            return ""
        img_data = resp.content
        print(f"  [+] 图片大小: {len(img_data)} bytes")
    except:
        return ""

    filename = image_url.split("/")[-1]
    if "." not in filename:
        filename += ".jpg"

    upload_url = UPLOAD_BASE + "html/filelist/uploadBbsImg"
    files = {"upfile[]": (filename, img_data, "application/octet-stream")}
    data = {
        "channel": CHANNEL, "version": VERSION_CODE, "api_level": API_LEVEL,
        "phone_model": get_phone_model(), "type": "picture",
        "uid": uid, "token": token, "level": "1",
    }

    resp = requests.post(upload_url, files=files, data=data, verify=False, timeout=30, headers={"User-Agent": "okhttp/4.9.3"})
    try:
        result = resp.json()
        if result.get("code") in (0, "0", 200, "200"):
            path = result.get("path", {})
            thumb = path.get("thumb", "")
            display_url = "http://down.ruansky.com/" + thumb
            img_tag = f"[img]{display_url}[/img]"
            print(f"  [+] 上传成功")
            return img_tag
    except:
        pass
    return ""

def publish_post(uid: str, token: str, mid: str, title: str, content: str, tags: str) -> dict:
    print(f"[*] 发帖: {title[:40]}... [mid={mid} tag={tags}]")
    params = get_auth_params(uid, token)
    params["mid"] = mid
    params["$*$tags"] = tags
    params["$*$device_name"] = DEVICE_NAME
    params["$*$content"] = content
    params["$*$os_version"] = "13"
    params["$*$pid"] = ""
    params["display_mode"] = "2"
    params["title"] = title
    key = calc_key_from_map(params)
    params["key"] = key
    params["diN"] = get_din()
    url = API_BASE + "bbs/posts-save"
    return api_post(url, params)

def fetch_post_detail(post_id: str) -> dict:
    """从源站抓取帖子详情（含截图URL和网盘链接）"""
    url = f"{SOURCE_SITE}/software.php?id={post_id}"
    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
    html = resp.text

    # 提取标题
    title_match = re.search(r'<title>(.*?)</title>', html)
    title = title_match.group(1) if title_match else ""
    title = re.sub(r'林夕软件库\s*-\s*', '', title).strip()

    # 提取内容（保留原始格式）
    desc_match = re.search(r'<p class="detail-description-text"[^>]*>(.*?)</p>', html, re.DOTALL)
    content = title
    if desc_match:
        desc_html = desc_match.group(1)
        # <br> 标签转 <br>
        desc = re.sub(r'<br\s*/?>', '<br>', desc_html)
        # 去掉其他 HTML 标签
        desc = re.sub(r'<(?!br\s*/?)[^>]+>', '', desc)
        # 解码 HTML 实体
        desc = desc.replace('&amp;', '&').replace('&lt;', '<').replace('&gt;', '>')
        # 去掉首尾空白
        desc = desc.strip()
        if desc:
            content = desc

    # 截图
    screenshots = []
    for match in re.finditer(r'src="(uploads/screenshots/[^"]+)"', html):
        img_url = f"{SOURCE_SITE}/{match.group(1)}"
        if img_url not in screenshots:
            screenshots.append(img_url)

    # 网盘链接
    download_link = ""
    dl_btn = re.search(r'href="(download\.php\?id=\d+[^"]*)"', html)
    if dl_btn:
        dl_url = f"{SOURCE_SITE}/{dl_btn.group(1)}"
        print(f"    [>] 访问下载页 ...")
        try:
            dl_resp = requests.get(dl_url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"}, allow_redirects=True)
            dl_html = dl_resp.text
            pan_link = re.search(r'id="downloadLink"[^>]*href="(https?://[^"]+)"', dl_html)
            if pan_link:
                download_link = pan_link.group(1)
            else:
                for pattern in [r'https?://pan\.baidu\.com/s/[^\s"<>]+', r'https?://pan\.quark\.cn/s/[^\s"<>]+', r'https?://www\.aliyundrive\.com/s/[^\s"<>]+']:
                    pan_match = re.search(pattern, dl_html)
                    if pan_match:
                        download_link = pan_match.group(0)
                        break
        except Exception as e:
            print(f"    [-] 获取网盘链接失败: {e}")

    return {
        'id': post_id, 'title': title, 'content': content,
        'screenshots': screenshots, 'download_link': download_link,
    }

# ==================== 分类映射 ====================

def get_mid_by_category(category_name: str) -> str:
    """根据源站分类名映射到软天空版块mid"""
    return "1"  # 全部发到资源分享

def get_tag_by_category(category_name: str) -> str:
    """根据源站分类名生成软天空标签"""
    game_keywords = ['动作冒险', '角色扮演', '模拟经营', 'steam移植', '破解游戏',
                     '策略战略', '射击游戏', '休闲益智', '恐怖丧尸', 'Switch移植',
                     '电脑端', '开放世界', '体育竞速', '射击竞技', '动作格斗']
    if category_name in game_keywords:
        return '游戏'
    if category_name in ['效率工具', '下载工具', '系统工具', '浏览器', '办公阅读']:
        return '工具'
    if category_name in ['音乐播放']:
        return '音乐'
    if category_name in ['视频剪辑', '影视播放', '动漫追番']:
        return '视频'
    if category_name in ['小说阅读', '阅读听书']:
        return '阅读'
    if category_name in ['修图美化', '图像与媒体处理']:
        return '图片'
    return '软件分享'

# ==================== 帖子管理 ====================

def load_all_posts() -> list:
    """从本地JSON加载全部帖子"""
    # 尝试多个路径（兼容定时任务环境）
    candidate_paths = [
        os.path.join(os.path.dirname(os.path.abspath(__file__)), 'all_posts_full.json'),
        'all_posts_full.json',
        os.path.join(os.getcwd(), 'all_posts_full.json'),
    ]
    
    for json_path in candidate_paths:
        if os.path.exists(json_path):
            print(f"[*] 加载数据: {json_path}")
            try:
                with open(json_path, 'r', encoding='utf-8') as f:
                    return json.load(f)
            except Exception as e:
                print(f"[-] 加载失败: {e}")
    
    print("[-] 未找到 all_posts_full.json")
    return []

def fetch_posts_from_web(need_count: int = 10) -> list:
    """从源站网页实时抓取帖子列表（降级方案）"""
    print("[*] 从源站网页抓取帖子...")
    try:
        resp = requests.get(SOURCE_SITE, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
        ids = re.findall(r'software\.php\?id=(\d+)', resp.text)
        ids = list(dict.fromkeys(ids))[:need_count]
        posts = []
        for pid in ids:
            posts.append({
                'id': int(pid),
                'title': '',
                'category_id': 1,
                'category_name': '未分类',
            })
        print(f"[+] 网页抓取 {len(posts)} 条帖子")
        return posts
    except Exception as e:
        print(f"[-] 网页抓取失败: {e}")
        return []

def fetch_posts(need_count: int = 10, game_only: bool = False) -> list:
    """获取未发帖的帖子（优先本地数据，失败则降级到网页抓取）"""
    print("[*] 从本地加载帖子...")
    all_posts = load_all_posts()
    
    # 如果本地数据加载失败，降级到网页抓取
    if not all_posts:
        print("[!] 本地数据不可用，切换到网页抓取模式")
        return fetch_posts_from_web(need_count)
    
    posted_ids = load_posted_ids()
    
    # 游戏分类列表
    game_categories = [
        '动作冒险', '角色扮演', '模拟经营', 'steam移植', '破解游戏',
        '策略战略', '射击游戏', '休闲益智', '恐怖丧尸', 'Switch移植',
        '电脑端', '开放世界', '体育竞速', '射击竞技', '动作格斗',
        '策略战棋', '恐怖生存', '18+游戏', '手机游戏', 'PC应用'
    ]
    
    # 过滤未发帖
    new_posts = []
    for post in all_posts:
        post_id = str(post['id'])
        if post_id in posted_ids:
            continue
        
        # 如果只发游戏，跳过非游戏分类
        if game_only:
            category_name = post.get('category_name', '未分类')
            if category_name not in game_categories:
                continue
        
        new_posts.append({
            'id': post['id'],
            'title': post['title'],
            'category_id': post.get('category_id', 1),
            'category_name': post.get('category_name', '未分类'),
        })
        if len(new_posts) >= need_count:
            break
    
    # 如果本地数据没有未发帖了，降级到网页抓取
    if not new_posts:
        print("[!] 本地数据全部已发完，切换到网页抓取模式")
        return fetch_posts_from_web(need_count)
    
    print(f"[+] 共找到 {len(new_posts)} 条未发帖子（总计 {len(all_posts)} 条）")
    return new_posts

def post_single(uid: str, token: str, post_info: dict, max_retry: int = 3) -> bool:
    """发单条帖子（带重试）"""
    post_id = str(post_info['id'])
    print(f"\n[*] 处理: {post_info['title'][:40]} [{post_info.get('category_name', '未分类')}]")

    for attempt in range(1, max_retry + 1):
        if attempt > 1:
            print(f"[!] 第 {attempt}/{max_retry} 次尝试...")
            time.sleep(5)

        try:
            detail = fetch_post_detail(post_id)
            
            # 网页抓不到标题时，用JSON里的标题兜底
            if not detail['title'] and post_info.get('title'):
                detail['title'] = post_info['title']
            
            if not detail['title'] or not detail['content']:
                print(f"[-] 标题或内容为空，跳过")
                save_posted_id(post_id)  # 标记为已处理，避免卡住
                return False

            # 上传截图（最多3张）
            img_tags = []
            for img_url in detail['screenshots'][:3]:
                img_tag = upload_image(uid, token, img_url)
                if img_tag:
                    img_tags.append(img_tag)
                time.sleep(1)

            # 构造内容
            content = detail['content']
            if detail['download_link']:
                content += "<br><br>下载链接：" + detail['download_link']
            if img_tags:
                content += "<br><br>" + "<br>".join(img_tags)

            # 根据分类确定mid和tags
            mid = get_mid_by_category(post_info.get('category_name', '未分类'))
            tags = get_tag_by_category(post_info.get('category_name', '未分类'))

            result = publish_post(uid, token, mid, detail['title'], content, tags)
            code = result.get("code")
            if code in (0, "0"):
                print(f"[+] 发帖成功: {result.get('msg', '')}")
                save_posted_id(post_id)
                return True
            else:
                msg = result.get('msg', '未知错误')
                print(f"[-] 发帖失败: {msg}")
                # 某些错误不需要重试
                if "封禁" in msg or "冻结" in msg or "限制" in msg:
                    print("[!] 账号被封禁/限制，停止重试")
                    save_posted_id(post_id)  # 标记为已处理
                    return False
        except Exception as e:
            print(f"[-] 异常: {e}")
    
    # 所有重试都失败，标记为已处理（跳过，不阻塞后续）
    print(f"[-] {max_retry} 次重试均失败，跳过此帖")
    save_posted_id(post_id)
    return False

def run_batch(count: int = 10, game_only: bool = False):
    """执行一批发帖（带重试和异常恢复）"""
    # 获取未发帖
    posts = fetch_posts(need_count=count, game_only=game_only)
    if not posts:
        print("[-] 没有未发帖子")
        return

    print(f"[*] 本次计划发帖: {len(posts)} 条")
    success = 0
    fail = 0
    skipped = 0

    # 只登录一次
    print("[*] 登录中...")
    login_data = login(USERNAME, PASSWORD)
    if not login_data:
        print("[-] 登录失败，退出")
        return
    uid = str(login_data.get("uid", "0"))
    token = login_data.get("token", "")

    for i, post in enumerate(posts):
        print(f"\n{'='*50}")
        print(f"[{i+1}/{len(posts)}] {post['title'][:40]}")

        try:
            if post_single(uid, token, post):
                success += 1
            else:
                fail += 1
        except Exception as e:
            print(f"[-] 未捕获异常: {e}")
            fail += 1
            # 标记为已处理，避免卡住
            save_posted_id(str(post['id']))

        # 间隔120秒（2分钟，软天空频率限制）
        if i < len(posts) - 1:
            print(f"\n    等待120秒...")
            time.sleep(120)

    print(f"\n{'='*50}")
    print(f"本批完成: 成功 {success}, 失败 {fail}, 总计 {len(posts)}")
    print(f"预计耗时: 约 {len(posts) * 2} 分钟")

if __name__ == "__main__":
    import sys
    count = int(sys.argv[1]) if len(sys.argv) > 1 else 10
    game_only = '--game' in sys.argv or '-g' in sys.argv
    run_batch(count, game_only=game_only)
