#!/usr/bin/env python3
"""
定时任务入口：自动抓取未发帖的游戏帖子并发送
用法: python3 rtk_scheduler.py <count>
"""
import sys
from rtk_game_poster import run_batch

if __name__ == "__main__":
    count = int(sys.argv[1]) if len(sys.argv) > 1 else 10
    game_only = '--game' in sys.argv
    run_batch(count, game_only=game_only)
