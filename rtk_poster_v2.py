#!/usr/bin/env python3
"""
软天空自动发帖脚本（带图片上传+自动分类）
- 从 img.lysq.cc.cd 抓取软件帖子和截图
- 自动登录软天空，上传图片后发帖
- 支持根据标题关键词自动分类到不同版块
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
# 图片上传在 down.ruansky.com(http)
LOGIN_BASE = "http://rtkapi.ruansky.net/"
API_BASE = "https://rtkapi2.ruansky.net/"
UPLOAD_BASE = "http://down.ruansky.com/"
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

# ==================== 分类映射 ====================

def get_category_by_title(title: str) -> dict:
    """根据标题关键词自动匹配版块 mid 和标签"""
    title_lower = title.lower()
    keywords = {
        "游戏": "4", "手游": "4", "单机": "4", "网游": "4", "王者荣耀": "4", "原神": "4",
        "辅助": "5", "外挂": "5", "脚本": "5", "修改器": "5",
        "音乐": "6", "听歌": "6", "音频": "6", "铃声": "6", "播放器": "6", "MP3": "6",
        "视频": "7", "影视": "7", "电影": "7", "追剧": "7", "电视": "7", "直播": "7",
        "图片": "8", "壁纸": "8", "头像": "8", "P图": "8", "修图": "8", "美图": "8",
        "阅读": "9", "小说": "9", "漫画": "9", "电子书": "9", "追书": "9",
        "办公": "10", "文档": "10", "表格": "10", "WPS": "10", "PDF": "10", "办公": "10",
        "系统": "11", "工具": "11", "优化": "11", "清理": "11", "Root": "11", "刷机": "11",
        "美化": "12", "主题": "12", "桌面": "12", "图标": "12", "壁纸": "12", "锁屏": "12",
        "安全": "13", "杀毒": "13", "防盗": "13", "隐私": "13", "防护": "13",
        "学习": "14", "教育": "14", "考试": "14", "题库": "14", "英语": "14", "单词": "14",
        "社交": "15", "聊天": "15", "通讯": "15", "交友": "15", "微信": "15", "QQ": "15",
        "生活": "16", "购物": "16", "外卖": "16", "出行": "16", "旅游": "16", "天气": "16",
        "理财": "17", "记账": "17", "银行": "17", "炒股": "17", "投资": "17",
        "健康": "18", "运动": "18", "健身": "18", "医疗": "18", "减肥": "18", "跑步": "18",
        "儿童": "19", "育儿": "19", "宝宝": "19", "早教": "19", "儿歌": "19",
        "新闻": "20", "资讯": "20", "头条": "20", "RSS": "20", "阅读器": "20",
        "导航": "21", "地图": "21", "定位": "21", "GPS": "21", "公交": "21", "地铁": "21",
        "输入法": "22", "键盘": "22", "手写": "22", "语音输入": "22", "打字": "22",
        "浏览器": "23", "上网": "23", "网页": "23", "Chrome": "23", "Firefox": "23",
        "下载": "24", "迅雷": "24", "网盘": "24", "磁力": "24", "BT": "24", "种子": "24",
        "压缩": "25", "解压": "25", "RAR": "25", "ZIP": "25", "7z": "25",
        "翻译": "26", "词典": "26", "语言": "26", "英语": "26", "日语": "26",
        "计算": "27", "计算器": "27", "数学": "27", "公式": "27", "科学计算": "27",
        "天气": "28", "日历": "28", "时钟": "28", "闹钟": "28", "万年历": "28",
        "股票": "29", "基金": "29", "投资": "29", "期货": "29", "行情": "29",
        "彩票": "30", "投注": "30", "竞彩": "30",
    }

    tag_names = {
        "1": "软件分享", "4": "游戏", "5": "辅助工具", "6": "音乐", "7": "视频",
        "8": "图片", "9": "阅读", "10": "办公", "11": "系统工具", "12": "美化",
        "13": "安全", "14": "学习教育", "15": "社交", "16": "生活", "17": "理财",
        "18": "健康", "19": "儿童", "20": "新闻", "21": "导航", "22": "输入法",
        "23": "浏览器", "24": "下载", "25": "压缩", "26": "翻译", "27": "计算",
        "28": "天气", "29": "股票", "30": "彩票",
    }

    for keyword, mid in keywords.items():
        if keyword in title_lower:
            return {"mid": mid, "tags": tag_names.get(mid, "软件分享")}

    # 默认：资源分享
    return {"mid": "1", "tags": "软件分享"}

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

    if result.get("code") in (0, "0", "200"):
        data = result.get("data", {})
        print(f"[+] 登录成功! UID={data.get('uid')}, 昵称={data.get('nickname', 'N/A')}")
        return data
    else:
        print(f"[-] 登录失败: {result.get('msg', '未知错误')}")
        print(f"    完整返回: {json.dumps(result, ensure_ascii=False)}")
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

    filename = image_url.split("/")[-1]
    if "." not in filename:
        filename += ".jpg"

    upload_url = UPLOAD_BASE + "html/filelist/uploadBbsImg"

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

    try:
        result = resp.json()
        if result.get("code") in (0, "0", 200, "200"):
            path = result.get("path", {})
            url = path.get("url", "")
            thumb = path.get("thumb", "")
            # 阿里云CDN域名 aliyun.bbs-img.zsdown.com 从外部访问404
            # 需替换为 http://down.ruansky.com/ 前缀拼接
            display_url = "http://down.ruansky.com/" + thumb
            img_tag = f"[img]{display_url}[/img]"
            print(f"  [+] 上传成功: {img_tag}")
            return img_tag
        else:
            print(f"  [-] 上传失败: {result.get('msg', '未知错误')}")
            return ""
    except Exception as e:
        print(f"  [-] 解析响应异常: {e}")
        return ""

def upload_images(uid: str, token: str, image_urls: list) -> list:
    """批量上传图片，返回 [img]标签列表"""
    img_tags = []
    for img_url in image_urls:
        img_tag = upload_image(uid, token, img_url)
        if img_tag:
            img_tags.append(img_tag)
        time.sleep(1)
    return img_tags

# ==================== 发帖 ====================

def publish_post(uid: str, token: str, mid: str, title: str, content: str,
                 tags: str = "", pid: str = "", family_id: str = "") -> dict:
    print(f"[*] 发帖 -> 版块mid={mid}: {title[:40]}...")
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
    """从源站抓取帖子详情（含截图URL和网盘链接）
    
    只从 detail-description-text 段落提取内容，不再从全页面乱抓标签。
    过滤掉免责声明、下载地址、分割线等垃圾行。
    """
    url = f"{SOURCE_SITE}/software.php?id={post_id}"
    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
    html = resp.text

    # 提取标题
    title_match = re.search(r'<title>(.*?)</title>', html)
    title = title_match.group(1) if title_match else ""
    title = re.sub(r'林夕软件库\s*-\s*', '', title).strip()

    # 只从 detail-description-text 段落提取内容
    # 这个段落里用 <br> 做换行，每行是一段信息
    desc_match = re.search(r'<p class="detail-description-text"[^>]*>(.*?)</p>', html, re.DOTALL)
    content = title  # 默认用标题兜底
    if desc_match:
        desc_html = desc_match.group(1)
        # 1. <br> 标签换成 <br>（软天空用 <br> 做换行，保留）
        desc = re.sub(r'<br\s*/?>', '<br>', desc_html)
        # 2. 去掉其他 HTML 标签，保留 <br>
        desc = re.sub(r'<(?!br\s*/?)[^>]+>', '', desc)
        # 3. 解码 HTML 实体
        desc = desc.replace('&amp;', '&').replace('&lt;', '<').replace('&gt;', '>')
        # 4. 去掉首尾空白
        desc = desc.strip()

        if desc:
            # 按 <br> 拆分（软天空的换行符）
            lines = desc.split('<br>')
            seen = set()
            cleaned = []
            for line in lines:
                line = line.strip()
                if not line:
                    continue

                # 过滤垃圾行：先去掉空格再匹配关键词（源站常插空格防爬）
                line_no_space = line.replace(' ', '').replace('\t', '').replace('\u3000', '')
                skip_keywords = [
                    '免责声明', '版权争议', '本人所发布', '一切后果', '一切学习',
                    '禁止转载', '禁止商用', '下载地址', '更多软件',
                ]
                if any(kw in line_no_space for kw in skip_keywords):
                    continue

                # 过滤全是破折号 / 横线 / 特殊符号的行
                if re.match(r'^[\s\-\—\━\▁\▂\▃\▄\▅\▆\▇\█\―\−\─\∽\…\～\⚠\⚡\🔴\🔒\❗\★\☆\✦\✧\●\○\■\□\▲\△\▼\▽\♠\♥\♦\♣]*$', line):
                    continue

                # 过滤以破折号/横线开头的行（分割线装饰）
                if re.match(r'^[\s\-\—\━\▁\▂\▃\▄\▅\▆\▇\█\―\−\─\∽\…\～]+', line):
                    continue

                # 去重（去掉空格后比较，防空格防爬）
                if line_no_space in seen:
                    continue
                seen.add(line_no_space)
                cleaned.append(line)

            content = '<br><br>'.join(cleaned) if cleaned else title

    # 提取截图 URL
    screenshots = []
    for match in re.finditer(r'src="(uploads/screenshots/[^"]+)"', html):
        img_url = f"{SOURCE_SITE}/{match.group(1)}"
        if img_url not in screenshots:
            screenshots.append(img_url)

    # 提取下载按钮的 href，访问下载页获取网盘链接
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
        'id': post_id,
        'title': title,
        'content': content,
        'screenshots': screenshots,
        'download_link': download_link,
    }

# ==================== 主程序 ====================

def main():
    USERNAME = "13184017302"
    PASSWORD = "123456Wq"

    # 1. 登录
    login_data = login(USERNAME, PASSWORD)
    if not login_data:
        return

    uid = str(login_data.get("uid", "0"))
    token = login_data.get("token", "")

    # 2. 从源站抓取帖子
    print("\n[*] 开始从源站抓取帖子 ...")
    post_ids = fetch_post_list()

    # 3. 批量发帖（自动分类）
    success = 0
    fail = 0
    for i, pid in enumerate(post_ids):
        print(f"\n[{i+1}/{len(post_ids)}] 处理帖子 ID={pid}")
        detail = fetch_post_detail(pid)
        print(f"    标题: {detail['title'][:50]}")
        print(f"    截图: {len(detail['screenshots'])} 张")
        print(f"    网盘: {detail['download_link'][:60] if detail['download_link'] else '未找到'}...")

        if not detail['title'] or not detail['content']:
            print("    [-] 跳过：标题或内容为空")
            fail += 1
            continue

        # 自动分类：根据标题关键词匹配版块
        category = get_category_by_title(detail['title'])
        mid = category['mid']
        tags = category['tags']
        print(f"    [+] 自动分类 -> mid={mid} ({tags})")

        # 上传截图到软天空
        img_tags = []
        if detail['screenshots']:
            print(f"    [*] 开始上传 {len(detail['screenshots'])} 张截图 ...")
            img_tags = upload_images(uid, token, detail['screenshots'])

        # 构造帖子内容（正文 + 网盘链接 + 截图）
        content = detail['content']
        if detail['download_link']:
            content += "<br><br>" + "下载链接：" + detail['download_link']
        if img_tags:
            content += "<br><br>" + "<br>".join(img_tags)

        result = publish_post(
            uid=uid, token=token, mid=mid,
            title=detail['title'],
            content=content,
            tags=tags,
        )

        code = result.get("code")
        msg = result.get("msg", "")
        if code in (0, "0"):
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
