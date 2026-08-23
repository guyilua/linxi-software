#!/usr/bin/env python3
"""测试定时任务执行环境"""
import os
import sys

print(f"当前目录: {os.getcwd()}")
print(f"脚本路径: {os.path.abspath(__file__)}")
print(f"目录内容:")
for f in os.listdir('.'):
    size = os.path.getsize(f) if os.path.isfile(f) else 'dir'
    print(f"  {f}: {size}")

# 检查 all_posts_full.json
json_path = os.path.join(os.path.dirname(__file__), 'all_posts_full.json')
print(f"\nall_posts_full.json 路径: {json_path}")
print(f"是否存在: {os.path.exists(json_path)}")
if os.path.exists(json_path):
    print(f"大小: {os.path.getsize(json_path)}")
