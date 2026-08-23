#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
APK关键文件提取与URL/JS代码分析脚本
"""

import zipfile
import re
import sys

APK_PATH = "/home/work/dumate/d02d6cc798e148008169cbc91e32731c/workspace/ses_gffe5fe51acb97ffeqhVv5UIT5Dnshj/uploads/d02d6cc798e148008169cbc91e32731c/3727ab6a-d649-41f2-bda9-717318232a7b.apk"
TARGET_FILES = [
    "assets/widget/html/common/login.html",
    "assets/widget/html/bbs/create.html",
    "assets/widget/script/api.js",
    "assets/dist/api.min.js.sec",
    "assets/widget/html/bbs/forum.html",
]

def read_apk_file(apk_path, internal_path):
    """从APK中读取指定内部文件内容"""
    try:
        with zipfile.ZipFile(apk_path, 'r') as z:
            if internal_path in z.namelist():
                return z.read(internal_path).decode('utf-8', errors='replace')
            else:
                return None
    except Exception as e:
        print(f"[错误] 读取 {internal_path} 失败: {e}", file=sys.stderr)
        return None

def extract_urls(content):
    """提取文本中的所有URL"""
    # 匹配常见URL格式
    url_patterns = [
        r'https?://[^\s\'"<>()]+',
        r'//[^\s\'"<>()]+',
        r'[a-zA-Z0-9_-]+\.[a-zA-Z]{2,}/[^\s\'"<>()]*',
        r'api/[a-zA-Z0-9_-]+',
        r'/[a-zA-Z0-9_/-]+\.php',
        r'/[a-zA-Z0-9_/-]+\.html?',
        r'/[a-zA-Z0-9_/-]+\.js',
        r'/[a-zA-Z0-9_/-]+\.json',
    ]
    urls = set()
    for pattern in url_patterns:
        matches = re.findall(pattern, content)
        urls.update(matches)
    return sorted(urls, key=lambda x: x.lower())

def filter_priority_urls(urls):
    """过滤出高优先级URL（包含api, login, post, bbs）"""
    keywords = ['api', 'login', 'post', 'bbs', 'auth', 'user', 'upload', 'forum']
    return [u for u in urls if any(k in u.lower() for k in keywords)]

def extract_js_snippets(content, file_path):
    """提取关键JavaScript代码片段（网络请求相关）"""
    snippets = []
    
    # 网络请求相关模式
    patterns = [
        (r'\$.ajax\s*\([^)]*\)', "jQuery AJAX请求"),
        (r'\$\.post\s*\([^)]*\)', "jQuery POST请求"),
        (r'\$\.get\s*\([^)]*\)', "jQuery GET请求"),
        (r'fetch\s*\([^)]*\)', "Fetch API请求"),
        (r'XMLHttpRequest\s*\([^)]*\)', "XMLHttpRequest"),
        (r'new\s+XMLHttpRequest', "new XMLHttpRequest"),
        (r'\$\.ajaxSetup\s*\([^)]*\)', "AJAX配置"),
        (r'api\.\w+\s*\([^)]*\)', "API调用"),
        (r'\.request\s*\([^)]*\)', "request调用"),
        (r'axios\.[a-z]+\s*\([^)]*\)', "axios请求"),
        (r'function\s+\w*[aA]pi\w*\s*\([^)]*\)', "API相关函数"),
        (r'url\s*[:=]\s*["\'][^"\']+["\']', "URL定义"),
        (r'path\s*[:=]\s*["\'][^"\']+["\']', "路径定义"),
        (r'apiHost\s*[:=]\s*["\'][^"\']+["\']', "API Host"),
        (r'baseUrl\s*[:=]\s*["\'][^"\']+["\']', "Base URL"),
        (r'serverUrl\s*[:=]\s*["\'][^"\']+["\']', "Server URL"),
    ]
    
    for pattern, desc in patterns:
        matches = re.findall(pattern, content)
        for m in matches[:10]:  # 每个模式最多取10条
            snippets.append((desc, m))
    
    return snippets

def main():
    print("="*80)
    print("APK关键文件提取与URL/JS代码分析报告")
    print("="*80)
    print(f"APK路径: {APK_PATH}")
    print(f"目标文件数: {len(TARGET_FILES)}")
    print()
    
    for idx, file_path in enumerate(TARGET_FILES, 1):
        print("="*80)
        print(f"[{idx}] 文件: {file_path}")
        print("="*80)
        
        content = read_apk_file(APK_PATH, file_path)
        
        if content is None:
            print("[⚠️ 状态] 文件不存在于APK中")
            print()
            continue
        
        print(f"[✅ 状态] 文件读取成功 (大小: {len(content)} 字符)")
        print()
        
        # 1. 提取所有URL
        urls = extract_urls(content)
        priority_urls = filter_priority_urls(urls)
        
        print("--- 高优先级URL (含api/login/post/bbs) ---")
        if priority_urls:
            for url in priority_urls:
                print(f"  • {url}")
        else:
            print("  (未找到高优先级URL)")
        print()
        
        print("--- 全部URL ---")
        if urls:
            for url in urls[:30]:  # 最多显示30个
                print(f"  • {url}")
            if len(urls) > 30:
                print(f"  ... (还有 {len(urls)-30} 个URL未显示)")
        else:
            print("  (未找到URL)")
        print()
        
        # 2. 提取关键JS代码片段
        snippets = extract_js_snippets(content, file_path)
        
        print("--- 关键JavaScript代码片段 (网络请求相关) ---")
        if snippets:
            seen = set()
            for desc, snippet in snippets:
                key = f"{desc}:{snippet}"
                if key not in seen and len(seen) < 50:
                    seen.add(key)
                    snippet_preview = snippet[:200]
                    print(f"  [{desc}]")
                    print(f"    {snippet_preview}")
                    print()
        else:
            print("  (未找到关键JS代码片段)")
        
        # 3. 显示文件前500字符预览
        print("--- 文件内容预览 (前500字符) ---")
        preview = content[:500].replace('\n', ' ')
        print(f"  {preview}...")
        print()
    
    print("="*80)
    print("分析完成")
    print("="*80)

if __name__ == "__main__":
    main()
