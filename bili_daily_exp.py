#!/usr/bin/env python3
"""
B站每日经验自动获取脚本
- 登录经验 (+5)
- 观看视频 (+5)
- 分享视频 (+5)
- 投币 (+10) — 暂时跳过（账号封禁中）
"""

import requests
import json
import time
import os
import sys
import urllib3
from datetime import datetime

urllib3.disable_warnings()

# ==================== 配置 ====================
SESSDATA = "583fead1%2C1802957518%2C278f0%2A81"
BILI_JCT = "093e9a30af12f12ce4d44ae523529eed"
DEDEUSERID = "3493280356501810"
BUVID3 = "ACAAF52F-4051-E2CE-A7F3-303B46C86E4D85119infoc"

COOKIE_STR = f"SESSDATA={SESSDATA}; bili_jct={BILI_JCT}; DedeUserID={DEDEUSERID}; buvid3={BUVID3}"
HEADERS = {
    "Cookie": COOKIE_STR,
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36",
    "Referer": "https://www.bilibili.com",
}

LOG_FILE = "bili_exp_log.txt"

def log(msg):
    line = f"[{datetime.now().strftime('%Y-%m-%d %H:%M:%S')}] {msg}"
    print(line)
    with open(LOG_FILE, 'a', encoding='utf-8') as f:
        f.write(line + '\n')

# ==================== 获取经验状态 ====================

def get_exp_status():
    """获取当前经验任务完成状态"""
    try:
        resp = requests.get(
            "https://api.bilibili.com/x/member/web/exp/reward",
            headers=HEADERS, verify=False, timeout=15
        )
        result = resp.json()
        if result.get("code") == 0:
            data = result["data"]
            return {
                "login": data.get("login", False),
                "watch": data.get("watch", False),
                "coins": data.get("coins", 0),
                "share": data.get("share", False),
            }
    except Exception as e:
        log(f"获取经验状态失败: {e}")
    return None

def get_account_info():
    """获取账号等级和经验"""
    try:
        resp = requests.get(
            "https://api.bilibili.com/x/web-interface/nav",
            headers=HEADERS, verify=False, timeout=15
        )
        result = resp.json()
        if result.get("code") == 0:
            data = result["data"]
            return {
                "level": data.get("level_info", {}).get("current_level", 0),
                "current_exp": data.get("level_info", {}).get("current_exp", 0),
                "next_exp": data.get("level_info", {}).get("next_exp", 0),
                "coins": data.get("money", 0),
            }
    except Exception as e:
        log(f"获取账号信息失败: {e}")
    return None

def get_coins_balance():
    """获取硬币余额"""
    try:
        resp = requests.get(
            "https://api.bilibili.com/x/web-interface/nav",
            headers=HEADERS, verify=False, timeout=15
        )
        result = resp.json()
        if result.get("code") == 0:
            return result["data"].get("money", 0)
    except:
        pass
    return 0

# ==================== 完成任务 ====================

def do_watch_video(bvid: str, cid: int) -> bool:
    """观看视频获取经验"""
    try:
        # 调用播放API
        url = "https://api.bilibili.com/x/click-interface/web/heartbeat"
        data = {
            "bvid": bvid,
            "cid": str(cid),
            "played_time": "0",
            "play_type": "1",
            "realtime": "0",
            "start_ts": str(int(time.time())),
            "type": "3",
            "csrf": BILI_JCT,
        }
        resp = requests.post(url, data=data, headers=HEADERS, verify=False, timeout=15)
        result = resp.json()
        log(f"  观看视频 [{bvid}]: code={result.get('code')}")
        return result.get("code") == 0
    except Exception as e:
        log(f"  观看视频失败: {e}")
        return False

def do_share_video(bvid: str) -> bool:
    """分享视频获取经验"""
    try:
        url = "https://api.bilibili.com/x/web-interface/share/add"
        data = {"bvid": bvid, "csrf": BILI_JCT}
        resp = requests.post(url, data=data, headers=HEADERS, verify=False, timeout=15)
        result = resp.json()
        log(f"  分享视频 [{bvid}]: code={result.get('code')}")
        return result.get("code") == 0
    except Exception as e:
        log(f"  分享视频失败: {e}")
        return False

def do_coin_video(bvid: str, num: int = 1) -> bool:
    """投币获取经验（暂时跳过，账号封禁中）"""
    log(f"  投币 [{bvid}]: 跳过（账号封禁中，无法投币）")
    return False

# ==================== 获取视频列表 ====================

def get_recommended_videos(count: int = 5) -> list:
    """获取推荐视频列表"""
    try:
        resp = requests.get(
            "https://api.bilibili.com/x/web-interface/index/top/rcmd",
            headers=HEADERS, verify=False, timeout=15
        )
        result = resp.json()
        if result.get("code") == 0:
            items = result.get("data", {}).get("item", [])
            videos = []
            for item in items:
                bvid = item.get("bvid", "")
                cid = item.get("cid", "")
                if bvid and cid:
                    videos.append({"bvid": bvid, "cid": cid, "title": item.get("title", "")})
                if len(videos) >= count:
                    break
            return videos
    except Exception as e:
        log(f"获取推荐视频失败: {e}")
    return []

# ==================== 主程序 ====================

def run_daily_tasks():
    """执行每日经验任务"""
    log("=" * 60)
    log("开始执行每日经验任务")
    
    # 1. 获取账号信息
    info = get_account_info()
    if info:
        log(f"当前等级: Lv{info['level']}, 经验: {info['current_exp']}/{info['next_exp']}, 硬币: {info['coins']}")
        remaining = info['next_exp'] - info['current_exp']
        log(f"距离Lv{info['level']+1}还需: {remaining} 经验")
    
    # 2. 获取经验任务状态
    status = get_exp_status()
    if not status:
        log("获取经验状态失败，退出")
        return False
    
    log(f"当前任务状态: 登录={status['login']}, 看视频={status['watch']}, 投币={status['coins']}/10, 分享={status['share']}")
    
    # 检查是否所有任务都已完成
    all_done = status["login"] and status["watch"] and status["share"]
    if all_done:
        log("今日任务已全部完成，无需操作")
        return True
    
    # 3. 获取视频列表
    videos = get_recommended_videos(5)
    if not videos:
        log("无法获取推荐视频，退出")
        return False
    
    log(f"获取到 {len(videos)} 个推荐视频")
    
    # 4. 观看视频（如果没有完成）
    if not status["watch"]:
        log("执行任务: 观看视频 (+5经验)")
        for i, video in enumerate(videos):
            log(f"  尝试观看: [{video['bvid']}] {video['title'][:30]}...")
            if do_watch_video(video["bvid"], video["cid"]):
                time.sleep(3)
                # 再检查状态
                new_status = get_exp_status()
                if new_status and new_status["watch"]:
                    log("  观看视频任务完成!")
                    break
            time.sleep(2)
    else:
        log("观看视频任务已完成，跳过")
    
    # 5. 分享视频（如果没有完成）
    if not status["share"]:
        log("执行任务: 分享视频 (+5经验)")
        for i, video in enumerate(videos):
            if do_share_video(video["bvid"]):
                time.sleep(2)
                # 再检查状态
                new_status = get_exp_status()
                if new_status and new_status["share"]:
                    log("  分享视频任务完成!")
                    break
            time.sleep(1)
    else:
        log("分享视频任务已完成，跳过")
    
    # 6. 投币（暂时跳过，封禁中）
    log("执行任务: 投币 (+10经验)")
    log("  跳过：账号封禁中，无法投币")
    
    # 7. 最终检查
    final_status = get_exp_status()
    if final_status:
        log(f"最终状态: 登录={final_status['login']}, 看视频={final_status['watch']}, 投币={final_status['coins']}/10, 分享={final_status['share']}")
    
    # 8. 再次获取账号信息
    final_info = get_account_info()
    if final_info:
        remaining = final_info['next_exp'] - final_info['current_exp']
        log(f"当前等级: Lv{final_info['level']}, 经验: {final_info['current_exp']}/{final_info['next_exp']}")
        log(f"距离Lv{final_info['level']+1}还需: {remaining} 经验")
    
    log("每日经验任务执行完毕")
    log("=" * 60)
    return True

if __name__ == "__main__":
    run_daily_tasks()
