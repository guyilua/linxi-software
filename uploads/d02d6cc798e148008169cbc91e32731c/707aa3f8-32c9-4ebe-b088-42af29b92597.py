#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Discuz! 论坛自动发帖脚本 - 林夕软件库引流
支持 3DM (bbs.3dmgame.com)，架构可扩展至其他Discuz!论坛

功能:
- 从数据库获取电脑游戏分类的软件列表
- 抓取软件详情（标题、简介、截图）
- 上传截图到论坛附件
- 发布新主题帖
- 状态记录防重复
- 登录状态/权限预检
- 低频随机间隔，风控友好

依赖: pip3 install requests Pillow
用法: python3 discuz_poster.py
"""

import requests
import json
import re
import time
import random
import os
import sys
import subprocess
import urllib3
import base64
import io
from datetime import datetime
from urllib.parse import urlencode
from PIL import Image

urllib3.disable_warnings()

# ==================== 论坛配置 ====================
# 新增Discuz!论坛只需在此添加配置
FORUMS = {
    '3dm': {
        'name': '3DM论坛',
        'domain': 'https://bbs.3dmgame.com',
        'fid': 192,
        'typeid': 51925,           # 主题分类: 资源
        'encoding': 'utf-8',
        'cookie_file': os.path.join(os.path.dirname(os.path.abspath(__file__)), '3dm_cookie.txt'),
        'cookie_pre': 'uchome_2132_',
        'upload_type': 'swfupload',  # swfupload | ajax
    },
    # 游侠网待注册后配置
    # 'ali213': {
    #     'name': '游侠网论坛',
    #     'domain': 'https://game.ali213.net',
    #     'fid': 46,
    #     'typeid': 0,
    #     'encoding': 'utf-8',
    #     'cookie_file': os.path.join(os.path.dirname(os.path.abspath(__file__)), 'ali213_cookie.txt'),
    #     'cookie_pre': 'B78R_',
    #     'upload_type': 'swfupload',
    # },
}

# ==================== 软件库配置 ====================
SOURCE_SITE = "http://img.lysq.cc.cd"
BROWSER_UA = ('Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 '
              '(KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36')

# 数据库
DB_SSH_HOST = "85.137.246.205"
DB_SSH_USER = "root"
DB_SSH_PASS = "ZGo0ir43Nu3B"
DB_NAME = "lxrjk"
DB_USER = "lxrjk"
DB_PASS = "linxilua"
PC_GAME_CATEGORIES = "9,41,42,43,44,45,46,47,48,49,50"

# 发帖控制
DAILY_MAX = 2               # 每日最多发帖数（每个论坛）
POST_INTERVAL_MIN = 600     # 发帖最小间隔（秒）= 10分钟（Discuz!自身要求30秒，这里更保守）
POST_INTERVAL_MAX = 1800    # 发帖最大间隔（秒）= 30分钟
MAX_SCREENSHOTS = 3         # 每帖最大截图数

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))


# ==================== 工具函数 ====================

def log(msg, level='INFO'):
    ts = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
    line = f"[{ts}] [{level}] {msg}"
    print(line)
    log_file = os.path.join(SCRIPT_DIR, 'discuz_poster.log')
    try:
        with open(log_file, 'a', encoding='utf-8') as f:
            f.write(line + '\n')
    except:
        pass


def load_cookie(cookie_file):
    if not os.path.exists(cookie_file):
        log(f"Cookie文件不存在: {cookie_file}", 'ERROR')
        return None
    with open(cookie_file, 'r', encoding='utf-8') as f:
        return f.read().strip()


def load_state():
    state_file = os.path.join(SCRIPT_DIR, 'discuz_state.json')
    if os.path.exists(state_file):
        try:
            with open(state_file, 'r', encoding='utf-8') as f:
                return json.load(f)
        except:
            pass
    return {'posted': {}, 'daily_count': {}, 'last_post_time': 0}


def save_state(state):
    state_file = os.path.join(SCRIPT_DIR, 'discuz_state.json')
    with open(state_file, 'w', encoding='utf-8') as f:
        json.dump(state, f, ensure_ascii=False, indent=2)


def can_post_today(state, forum_key):
    today = datetime.now().strftime('%Y-%m-%d')
    key = f"{forum_key}_{today}"
    count = state.get('daily_count', {}).get(key, 0)
    if count >= DAILY_MAX:
        log(f"[{forum_key}] 今日已发帖 {count} 条，达到上限 {DAILY_MAX}")
        return False
    last = state.get('last_post_time', 0)
    elapsed = time.time() - last
    if last > 0 and elapsed < POST_INTERVAL_MIN:
        wait = POST_INTERVAL_MIN - elapsed
        log(f"距上次发帖仅 {elapsed:.0f} 秒，需等待 {wait:.0f} 秒")
        return False
    return True


def wait_random_interval():
    wait = random.randint(POST_INTERVAL_MIN, POST_INTERVAL_MAX)
    log(f"等待 {wait} 秒后继续...")
    time.sleep(wait)


# ==================== 数据库查询 ====================

def ssh_mysql(sql, timeout=20):
    subprocess.run("apt-get install -y expect > /dev/null 2>&1",
                   shell=True, capture_output=True)
    sql_b64 = base64.b64encode(sql.encode("utf-8")).decode("ascii")
    remote_cmd = (
        f"echo {sql_b64} | base64 -d | "
        f"mysql -u{DB_USER} -p{DB_PASS} {DB_NAME} -N 2>/dev/null"
    )
    script = (
        f'set timeout {timeout}; '
        f'spawn ssh -o StrictHostKeyChecking=no {DB_SSH_USER}@{DB_SSH_HOST} "{remote_cmd}"; '
        f'expect "password:"; '
        f'send "{DB_SSH_PASS}\\r"; '
        f'expect eof'
    )
    try:
        result = subprocess.run(
            ['expect', '-c', script],
            capture_output=True, text=True, timeout=timeout + 15
        )
        return result.stdout
    except subprocess.TimeoutExpired:
        return ""


def get_pc_game_list(limit=20):
    sql = (
        f"SELECT id, title FROM software "
        f"WHERE category_id IN ({PC_GAME_CATEGORIES}) "
        f"ORDER BY id DESC LIMIT {limit}"
    )
    output = ssh_mysql(sql)
    games = []
    for line in output.split('\n'):
        line = line.strip()
        if not line or '\t' not in line:
            continue
        parts = line.split('\t', 1)
        if len(parts) == 2 and parts[0].isdigit():
            games.append({'id': int(parts[0]), 'title': parts[1]})
    return games


# ==================== 软件库抓取 ====================

HEADERS = {'User-Agent': BROWSER_UA}


def fetch_software_detail(software_id):
    url = f"{SOURCE_SITE}/software.php?id={software_id}"
    try:
        resp = requests.get(url, verify=False, timeout=15, headers=HEADERS)
        resp.encoding = 'utf-8'
        html = resp.text
    except Exception as e:
        log(f"  抓取详情页失败: {e}", 'ERROR')
        return None

    detail = {'id': software_id}

    m = re.search(r'<h1[^>]*class="detail-title"[^>]*>(.*?)</h1>', html, re.DOTALL)
    if m:
        detail['title'] = re.sub(r'<[^>]+>', '', m.group(1)).strip()
    else:
        m = re.search(r'<title>(.*?)</title>', html)
        detail['title'] = re.sub(r'林夕软件库\s*-\s*', '', m.group(1)).strip() if m else ''

    screenshots = []
    for m in re.finditer(r'screenshot-slide[^>]*>.*?<img\s+src="([^"]+)"', html, re.DOTALL):
        src = m.group(1)
        if not src.startswith('http'):
            src = f"{SOURCE_SITE}/{src}"
        if src not in screenshots:
            screenshots.append(src)
    detail['screenshots'] = screenshots

    desc = ''
    m = re.search(r'<p[^>]*class="detail-description-text"[^>]*>(.*?)</p>', html, re.DOTALL)
    if m:
        raw = m.group(1)
        raw = re.sub(r'<br\s*/?>', '\n', raw)
        raw = re.sub(r'<[^>]+>', '', raw)
        raw = raw.replace('&amp;', '&').replace('&lt;', '<').replace('&gt;', '>').replace('&nbsp;', ' ')
        lines = []
        for line in raw.split('\n'):
            line = line.strip()
            if not line:
                continue
            if '学习' in line and '目的' in line:
                break
            if '社区无关' in line or '版权争议' in line:
                continue
            if line == '⚠':
                continue
            lines.append(line)
        desc = '\n'.join(lines)
    detail['description'] = desc

    info = {}
    for field in ['资源名称', '资源版本', '资源大小', '资源系统', '资源介绍']:
        pattern = r'【' + r'\s*'.join(list(field)) + r'】\s*(.+?)(?:\n|$)'
        m = re.search(pattern, desc)
        if m:
            info[field] = m.group(1).strip()
    detail['info'] = info
    detail['url'] = url
    return detail


# ==================== Discuz! 论坛客户端 ====================

class DiscuzClient:
    """Discuz! X3.x 论坛客户端，支持3DM等标准Discuz!论坛"""

    def __init__(self, forum_key, config):
        self.key = forum_key
        self.cfg = config
        self.domain = config['domain'].rstrip('/')
        self.fid = config['fid']
        self.typeid = config.get('typeid', 0)
        self.encoding = config.get('encoding', 'utf-8')
        self.upload_type = config.get('upload_type', 'swfupload')

        cookie_str = load_cookie(config['cookie_file'])
        if not cookie_str:
            raise ValueError(f"无法加载Cookie: {config['cookie_file']}")

        self.session = requests.Session()
        self.session.headers.update({
            'User-Agent': BROWSER_UA,
            'Cookie': cookie_str,
        })
        self.formhash = None
        self.uid = None
        self.upload_hash = None
        self.logged_in = False

    def _get(self, path, **kwargs):
        url = path if path.startswith('http') else f"{self.domain}/{path.lstrip('/')}"
        kwargs.setdefault('verify', False)
        kwargs.setdefault('timeout', 15)
        r = self.session.get(url, **kwargs)
        r.encoding = self.encoding
        return r

    def _post(self, path, **kwargs):
        url = path if path.startswith('http') else f"{self.domain}/{path.lstrip('/')}"
        kwargs.setdefault('verify', False)
        kwargs.setdefault('timeout', 20)
        r = self.session.post(url, **kwargs)
        r.encoding = self.encoding
        return r

    def check_login(self):
        """检查登录状态并获取formhash"""
        r = self._get(f'forum.php?mod=forumdisplay&fid={self.fid}')
        html = r.text

        # 检查是否有退出链接（已登录标志）
        if 'action=logout' not in html:
            log(f"[{self.key}] Cookie可能已过期，未找到退出链接", 'ERROR')
            return False

        # 获取formhash
        m = re.search(r'name="formhash"\s+value="([a-f0-9]+)"', html)
        if not m:
            m = re.search(r'formhash=([a-f0-9]+)', html)
        if m:
            self.formhash = m.group(1)
        else:
            log(f"[{self.key}] 未找到formhash", 'ERROR')
            return False

        # 获取uid和hash（用于上传）
        m = re.search(r"discuz_uid\s*=\s*'(\d+)'", html)
        if m:
            self.uid = m.group(1)
        m = re.search(r"cookiepre\s*=\s*'([^']+)'", html)
        if m:
            self.cookie_pre = m.group(1)

        self.logged_in = True
        log(f"[{self.key}] 登录正常, formhash={self.formhash}, uid={self.uid}")
        return True

    def _init_post_page(self):
        """访问发帖页面，获取上传hash等必要参数"""
        r = self._get(
            f'forum.php?mod=post&action=newthread&fid={self.fid}',
            headers={'Referer': f'{self.domain}/forum.php?mod=forumdisplay&fid={self.fid}'}
        )
        html = r.text

        # 检查权限
        for kw in ['没有权限', '您需要登录', '积分不够', '升级用户组', '禁止访问']:
            if kw in html:
                return False, f"发帖受限: {kw}"

        # 检查验证码
        m = re.search(r'seccodecheck\s*=\s*parseInt\([\'"](\d+)[\'"]\)', html)
        if m and m.group(1) != '0':
            return False, "需要验证码，无法自动发帖"

        # 更新formhash（发帖页的可能不同）
        m = re.search(r'name="formhash"\s+value="([a-f0-9]+)"', html)
        if m:
            self.formhash = m.group(1)

        # 获取上传hash
        m = re.search(r'name="hash"\s+value="([a-f0-9]+)"', html)
        if m:
            self.upload_hash = m.group(1)

        # 获取posttime
        m = re.search(r'name="posttime"\s+value="(\d+)"', html)
        self.posttime = m.group(1) if m else str(int(time.time()))

        return True, html

    def _compress_image(self, img_data, max_size=600, max_bytes=90*1024):
        """压缩图片到论坛可接受的大小：3DM新用户组限制约100KB/张"""
        try:
            img = Image.open(io.BytesIO(img_data))
            if img.mode in ('RGBA', 'P', 'LA'):
                img = img.convert('RGB')
            if max(img.size) > max_size:
                ratio = max_size / max(img.size)
                new_size = (int(img.size[0]*ratio), int(img.size[1]*ratio))
                img = img.resize(new_size, Image.LANCZOS)
            quality = 80
            while quality >= 30:
                buf = io.BytesIO()
                img.save(buf, format='JPEG', quality=quality)
                data = buf.getvalue()
                if len(data) <= max_bytes:
                    return data
                quality -= 10
            img = img.resize((int(img.size[0]*0.7), int(img.size[1]*0.7)), Image.LANCZOS)
            buf = io.BytesIO()
            img.save(buf, format='JPEG', quality=30)
            return buf.getvalue()
        except Exception as e:
            log(f"  图片压缩失败: {e}", 'WARN')
            return img_data

    def upload_image(self, image_url):
        """
        上传图片到论坛。3DM新用户附件上传受限(-11)，
        但支持[img]网络图片标签，因此直接使用源站URL即可。
        返回 {aid, url} —— aid为空，url为远程图片地址
        """
        try:
            # 验证图片可访问
            img_resp = requests.head(image_url, timeout=10, headers=HEADERS, verify=False, allow_redirects=True)
            if img_resp.status_code != 200:
                # HEAD失败试GET
                img_resp = requests.get(image_url, timeout=10, headers=HEADERS, verify=False, stream=True)
                if img_resp.status_code != 200:
                    log(f"  截图不可访问({img_resp.status_code}): {image_url}", 'WARN')
                    return None
                img_resp.close()
            log(f"  网络图片可用: {image_url[:60]}...")
            return {'aid': '', 'url': image_url}
        except Exception as e:
            log(f"  图片验证失败: {e}", 'WARN')
            return None

    def post_thread(self, title, message, images=None):
        """
        发布新主题帖
        返回: (success, tid, message)
        """
        ok, result = self._init_post_page()
        if not ok:
            return False, 0, result

        # 构建图片BBCode（远程图片用[img]标签，附件用[attach]）
        img_bbcode = ''
        if images:
            for img in images:
                if img.get('url'):
                    img_bbcode += f'\n[img]{img["url"]}[/img]\n'
                elif img.get('aid'):
                    img_bbcode += f'\n[attach]{img["aid"]}[/attach]\n'

        # 构建POST数据
        post_data = {
            'formhash': self.formhash,
            'posttime': self.posttime,
            'wysiwyg': '1',
            'subject': title,
            'message': message + img_bbcode,
            'save': '',
            'topicsubmit': 'yes',
            'noticeauthor': '',
            'noticeauthormsg': '',
            'allownoticeauthor': '1',
            'readperm': '',
            'price': '',
            'usesig': '1',
            'tags': '',
        }

        if self.typeid:
            post_data['typeid'] = str(self.typeid)

        # 发帖
        post_url = f'forum.php?mod=post&action=newthread&fid={self.fid}&extra=&topicsubmit=yes'

        try:
            r = self._post(
                post_url,
                data=post_data,
                headers={
                    'Referer': f'{self.domain}/forum.php?mod=post&action=newthread&fid={self.fid}',
                    'Origin': self.domain,
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                allow_redirects=False
            )

            # Discuz! 发帖成功返回200，页面中包含tid和跳转
            html = r.text

            # 方式1: 从setthreadcover的AJAX URL中提取tid
            tid_m = re.search(r'tid=(\d+)', html)
            if tid_m and '主题已发布' in html:
                tid = tid_m.group(1)
                return True, tid, f"发帖成功! tid={tid}"

            # 方式2: 从跳转URL提取tid
            tid_m = re.search(r'thread-(\d+)-', html)
            if tid_m and ('已发布' in html or '成功' in html):
                tid = tid_m.group(1)
                return True, tid, f"发帖成功! tid={tid}"

            # 方式3: 检查Location头
            loc = r.headers.get('Location', '')
            tid_m = re.search(r'thread-(\d+)-', loc) or re.search(r'tid=(\d+)', loc)
            if tid_m:
                tid = tid_m.group(1)
                return True, tid, f"发帖成功! tid={tid}"

            # 检查错误信息
            error_msgs = []
            m = re.search(r'id="messagetext"[^>]*>(.*?)</(?:div|p|span)>', html, re.DOTALL)
            if m:
                text = re.sub(r'<[^>]+>', '', m.group(1)).strip()
                if text:
                    error_msgs.append(text)

            for pat in [r'class="[^"]*alert_error[^"]*"[^>]*>(.*?)</(?:div|p)>',
                        r'class="[^"]*messagetext[^"]*"[^>]*>(.*?)</(?:div|p)>']:
                for m in re.finditer(pat, html, re.DOTALL):
                    text = re.sub(r'<[^>]+>', '', m.group(1)).strip()
                    if text and len(text) < 200:
                        error_msgs.append(text)

            if error_msgs:
                return False, 0, f"发帖被拒: {' | '.join(error_msgs[:2])}"

            # 检查是否需要审核
            if '审核' in html:
                return True, 0, "帖子已提交，等待审核"

            return False, 0, f"发帖失败: 未知响应"

        except Exception as e:
            return False, 0, f"发帖异常: {e}"


# ==================== 内容生成 ====================

def build_post_content(detail):
    """构建Discuz!论坛帖子标题和内容（BBCode格式）"""
    title = detail.get('title', '').strip()
    info = detail.get('info', {})
    desc = detail.get('description', '')

    game_name = info.get('资源名称', title)
    post_title = game_name[:60]

    parts = []

    # 元信息行
    meta = []
    if info.get('资源版本'):
        meta.append(f"版本：{info['资源版本']}")
    if info.get('资源大小'):
        meta.append(f"大小：{info['资源大小']}")
    if info.get('资源系统'):
        meta.append(f"系统：{info['资源系统']}")
    if meta:
        parts.append('[b]' + ' | '.join(meta) + '[/b]')
        parts.append('')

    # 简介
    intro = info.get('资源介绍', '')
    if not intro and desc:
        lines = []
        for line in desc.split('\n'):
            line = line.strip()
            if not line:
                continue
            if re.match(r'【[^】]*】', line):
                after = re.sub(r'^【[^】]*】\s*', '', line)
                if len(after) > 10:
                    lines.append(after)
                continue
            if len(line) > 15:
                lines.append(line)
        intro = '\n'.join(lines)

    if intro:
        if len(intro) > 800:
            intro = intro[:800] + '...'
        parts.append(intro)

    # 品牌引导
    parts.append('')
    parts.append('─' * 30)
    parts.append('资源来自[b]林夕软件库[/b]，更多PC游戏资源可百度搜索「林夕软件库」获取。')

    post_content = '\n'.join(parts)
    return post_title, post_content


# ==================== 主流程 ====================

def process_forum(forum_key, config, games, state):
    """处理单个论坛的发帖"""
    log(f"\n{'='*50}")
    log(f"开始处理论坛: {config['name']} ({forum_key})")

    cookie_str = load_cookie(config['cookie_file'])
    if not cookie_str:
        log(f"跳过 {config['name']}: Cookie文件不存在", 'WARN')
        return

    try:
        client = DiscuzClient(forum_key, config)
    except ValueError as e:
        log(f"跳过 {config['name']}: {e}", 'WARN')
        return

    # 检查登录
    if not client.check_login():
        log(f"跳过 {config['name']}: 登录失败", 'ERROR')
        return

    # 检查今日配额
    if not can_post_today(state, forum_key):
        return

    today = datetime.now().strftime('%Y-%m-%d')
    count_key = f"{forum_key}_{today}"
    success_count = state.get('daily_count', {}).get(count_key, 0)
    posted_ids = set(str(k) for k in state.get('posted', {}).keys())

    for game in games:
        if success_count >= DAILY_MAX:
            log(f"[{forum_key}] 已达每日上限，停止")
            break

        gid = game['id']
        state_key = f"{forum_key}_{gid}"

        if state_key in posted_ids:
            continue

        log(f"\n--- [{config['name']}] 处理: [{gid}] {game['title']} ---")

        # 抓取详情
        detail = fetch_software_detail(gid)
        if not detail or not detail.get('title'):
            log(f"  抓取详情失败，跳过", 'WARN')
            continue

        # 构建内容
        post_title, post_content = build_post_content(detail)
        log(f"  标题: {post_title}")

        # 上传截图
        screenshots = detail.get('screenshots', [])[:MAX_SCREENSHOTS]
        uploaded_imgs = []
        for i, shot_url in enumerate(screenshots):
            log(f"  上传截图 {i+1}/{len(screenshots)}...")
            img_info = client.upload_image(shot_url)
            if img_info:
                uploaded_imgs.append(img_info)
            time.sleep(random.uniform(1, 3))

        log(f"  成功上传 {len(uploaded_imgs)}/{len(screenshots)} 张截图")

        # 发帖
        log(f"  正在发布到{config['name']}...")
        success, tid, msg = client.post_thread(post_title, post_content, uploaded_imgs)
        log(f"  结果: {msg}")

        if success:
            state.setdefault('posted', {})[state_key] = {
                'software_id': gid,
                'title': detail['title'],
                'tid': tid,
                'time': datetime.now().strftime('%Y-%m-%d %H:%M:%S'),
                'forum': forum_key,
            }
            state['daily_count'][count_key] = success_count + 1
            state['last_post_time'] = time.time()
            save_state(state)
            success_count += 1

            thread_url = f"{config['domain']}/thread-{tid}-1-1.html" if tid else ''
            log(f"  ✓ 发帖成功! {thread_url}")

            if success_count < DAILY_MAX:
                wait_random_interval()
        else:
            # 严重错误（权限/封禁）则终止
            if any(kw in msg for kw in ['权限', '封禁', '禁止', '登录失败']):
                log(f"  严重错误，终止本论坛发帖", 'ERROR')
                break
            time.sleep(random.uniform(30, 60))

    log(f"[{config['name']}] 本次完成，今日发帖 {success_count} 条")


def main():
    log("=" * 50)
    log("Discuz!论坛自动发帖脚本启动")
    log(f"配置了 {len(FORUMS)} 个论坛: {', '.join(FORUMS.keys())}")

    state = load_state()

    # 获取游戏列表
    log("从数据库获取电脑游戏列表...")
    games = get_pc_game_list(limit=30)
    log(f"获取到 {len(games)} 个游戏")

    if not games:
        log("未获取到游戏列表，退出", 'ERROR')
        sys.exit(1)

    # 逐个论坛处理
    for forum_key, config in FORUMS.items():
        process_forum(forum_key, config, games, state)

    save_state(state)
    log("\n所有论坛处理完成")


if __name__ == '__main__':
    main()
