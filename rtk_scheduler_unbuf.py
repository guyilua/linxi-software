#!/usr/bin/env python3
import sys
import os
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

# 强制无缓冲输出
sys.stdout = open(sys.stdout.fileno(), mode='w', buffering=1)
sys.stderr = open(sys.stderr.fileno(), mode='w', buffering=1)

from rtk_game_poster import run_batch

if __name__ == "__main__":
    count = int(sys.argv[1]) if len(sys.argv) > 1 else 10
    game_only = '--game' in sys.argv
    run_batch(count, game_only=game_only)
