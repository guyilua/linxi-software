#!/usr/bin/env python3
"""
B站专栏自动发布脚本
- 从源站（林夕软件库）抓取帖子内容
- 上传截图到B站图床
- 自动发布B站专栏（图文混排）
- 每天限发1篇（Lv1-3账号限制）
"""

import requests
import re
import json
import time
import os
import sys
import urllib3

urllib3.disable_warnings()

# ==================== 配置 ====================

SESSDATA = "583fead1%2C1802957518%2C278f0%2A81"
BILI_JCT = "093e9a30af12f12ce4d44ae523529eed"
DEDEUSERID = "3493280356501810"
BUVID3 = "ACAAF52F-4051-E2CE-A7F3-303B46C86E4D85119infoc"

SOURCE_SITE = "http://img.lysq.cc.cd"
POSTED_FILE = "posted_ids_bili.json"

COOKIE_STR = f"SESSDATA={SESSDATA}; bili_jct={BILI_JCT}; DedeUserID={DEDEUSERID}; buvid3={BUVID3}"
HEADERS = {
    "Cookie": COOKIE_STR,
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
    "Referer": "https://member.bilibili.com/article-text/home",
}

# ==================== 已发记录 ====================

def load_posted_ids() -> set:
    if os.path.exists(POSTED_FILE):
        try:
            with open(POSTED_FILE, 'r', encoding='utf-8') as f:
                data = json.load(f)
                return set(str(x) for x in data.get('ids', []))
        except:
            pass
    return set()

def save_posted_id(post_id: str):
    posted = load_posted_ids()
    posted.add(str(post_id))
    with open(POSTED_FILE, 'w', encoding='utf-8') as f:
        json.dump({'ids': list(posted)}, f, ensure_ascii=False)

# ==================== 源站抓取 ====================

def fetch_post_list() -> list:
    """从源站首页抓取帖子ID列表"""
    resp = requests.get(SOURCE_SITE, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
    ids = re.findall(r'software\.php\?id=(\d+)', resp.text)
    return list(dict.fromkeys(ids))  # 去保序去重

def fetch_post_detail(post_id: str) -> dict:
    """抓取帖子详情"""
    url = f"{SOURCE_SITE}/software.php?id={post_id}"
    resp = requests.get(url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
    html = resp.text

    # 标题
    title_match = re.search(r'<title>(.*?)</title>', html)
    title = title_match.group(1) if title_match else ""
    title = re.sub(r'林夕软件库\s*-\s*', '', title).strip()

    # 正文内容
    desc_match = re.search(r'<p class="detail-description-text"[^>]*>(.*?)</p>', html, re.DOTALL)
    content = ""
    if desc_match:
        content = re.sub(r'<br\s*/?>', '\n', desc_match.group(1))
        content = re.sub(r'<[^>]+>', '', content)
        content = content.replace('&amp;', '&').replace('&nbsp;', ' ').strip()

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
        try:
            dl_resp = requests.get(dl_url, verify=False, timeout=15, 
                                   headers={"User-Agent": "Mozilla/5.0"}, allow_redirects=True)
            for pattern in [r'https?://pan\.baidu\.com/s/[^\s"<>]+', r'https?://pan\.quark\.cn/s/[^\s"<>]+']:
                match = re.search(pattern, dl_resp.text)
                if match:
                    download_link = match.group(0)
                    break
        except:
            pass

    return {
        'id': post_id,
        'title': title,
        'content': content,
        'screenshots': screenshots,
        'download_link': download_link,
    }

# ==================== B站API ====================

def upload_image_bili(image_url: str) -> str:
    """上传图片到B站图床，返回B站图片URL"""
    print(f"  [>] 下载图片: {image_url}")
    try:
        resp = requests.get(image_url, verify=False, timeout=15, headers={"User-Agent": "Mozilla/5.0"})
        if resp.status_code != 200 or len(resp.content) < 100:
            print(f"  [-] 图片下载失败: status={resp.status_code}")
            return ""
        print(f"  [+] 图片大小: {len(resp.content)} bytes")
    except Exception as e:
        print(f"  [-] 图片下载异常: {e}")
        return ""

    # 上传到B站专栏图床
    upload_url = "https://api.bilibili.com/x/article/creative/article/upcover"
    files = {"binary": ("image.jpg", resp.content, "image/jpeg")}
    data = {"csrf": BILI_JCT}

    try:
        r = requests.post(upload_url, files=files, data=data, headers=HEADERS, verify=False, timeout=30)
        result = r.json()
        if result.get("code") == 0:
            url = result.get("data", {}).get("url", "")
            if url:
                print(f"  [+] B站上传成功: {url[:80]}...")
                return url
        else:
            print(f"  [-] 上传失败: {result.get('message')}")
    except Exception as e:
        print(f"  [-] 上传异常: {e}")
    return ""

def publish_article(title: str, content: str, img_urls: list) -> dict:
    """发布B站专栏文章"""
    print(f"[*] 发布专栏: {title[:50]}...")

    # 构造Quill Delta格式内容
    delta_ops = []
    
    # 标题
    delta_ops.append({"insert": title})
    delta_ops.append({"insert": "\n", "attributes": {"header": 1}})
    
    # 正文
    for line in content.split('\n'):
        line = line.strip()
        if line:
            delta_ops.append({"insert": line})
            delta_ops.append({"insert": "\n"})
    
    # 图片
    for img_url in img_urls:
        delta_ops.append({"insert": {"image": img_url}})
        delta_ops.append({"insert": "\n"})

    content_json = json.dumps(delta_ops, ensure_ascii=False)
    
    # 字数统计
    words = sum(len(line.strip()) for line in content.split('\n'))

    # 发布数据
    publish_data = {
        "title": title,
        "content": content_json,
        "category": "0",
        "list_id": "0",
        "tid": "0",
        "reprint": "0",
        "tags": "",
        "origin_url": "",
        "words": str(words),
        "category_id": "0",
        "csrf": BILI_JCT,
    }

    # 直接发布（submit会自动创建草稿+发布）
    url = "https://api.bilibili.com/x/article/creative/article/submit"
    try:
        r = requests.post(url, data=publish_data, headers=HEADERS, verify=False, timeout=30)
        result = r.json()
        print(f"[DEBUG] B站返回: code={result.get('code')}, msg={result.get('message')}")
        if result.get("code") == 0:
            data = result.get("data", {})
            print(f"[+] 发布成功! 文章ID={data.get('aid')}")
            print(f"    预览: {data.get('view_url')}")
            return result
        else:
            print(f"[-] 发布失败: {result.get('message')}")
            return result
    except Exception as e:
        print(f"[-] 请求异常: {e}")
        return {"code": -1, "message": str(e)}

# ==================== 主程序 ====================

def run_batch(count: int = 1):
    """批量发布"""
    print(f"=== B站专栏自动发布 (数量={count}) ===\n")

    # 获取帖子列表
    post_ids = fetch_post_list()
    posted = load_posted_ids()
    new_ids = [pid for pid in post_ids if pid not in posted]

    print(f"源站帖子总数: {len(post_ids)}")
    print(f"已发: {len(posted)}, 待发: {len(new_ids)}\n")

    if not new_ids:
        print("[-] 没有新帖子可发")
        return

    success_count = 0
    for pid in new_ids[:count]:
        print(f"\n{'='*60}")
        print(f"处理帖子 ID={pid}")

        # 抓取详情
        detail = fetch_post_detail(pid)
        if not detail['title']:
            print(f"[-] 标题为空，跳过")
            save_posted_id(pid)  # 标记为已处理，避免重复
            continue
        if not detail['content']:
            print(f"[-] 内容为空，跳过")
            save_posted_id(pid)
            continue

        print(f"标题: {detail['title'][:50]}")
        print(f"内容长度: {len(detail['content'])} 字")
        print(f"截图: {len(detail['screenshots'])} 张")
        print(f"网盘链接: {'有' if detail['download_link'] else '无'}")

        # 上传截图到B站
        bili_img_urls = []
        for img_url in detail['screenshots'][:5]:  # 最多5张图
            bili_url = upload_image_bili(img_url)
            if bili_url:
                bili_img_urls.append(bili_url)
            time.sleep(2)  # 上传间隔

        # 构造专栏内容
        content = detail['content']
        if detail['download_link']:
            content += f"\n\n下载链接：{detail['download_link']}"

        # 发布
        result = publish_article(detail['title'], content, bili_img_urls)

        if result.get("code") == 0:
            print("[+] 发布成功!")
            save_posted_id(pid)
            success_count += 1
        else:
            print(f"[-] 发布失败: {result.get('message')}")
            # 如果是频率限制，停止
            if result.get("code") == 37109:
                print("[!] 每日发布上限，停止")
                break
            # 其他错误也跳过
            save_posted_id(pid)

        time.sleep(5)

    print(f"\n{'='*60}")
    print(f"完成: 成功 {success_count}/{count}")

def main():
    count = int(sys.argv[1]) if len(sys.argv) > 1 else 1
    run_batch(count)

if __name__ == "__main__":
    main()
