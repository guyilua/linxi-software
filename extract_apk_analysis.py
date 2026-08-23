#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
APK关键文件提取与URL/JS代码分析脚本
"""

import zipfile
import re
import json
import sys
from urllib.parse import urljoin

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
    urls = set()
    
    # 完整HTTP(S) URL
    http_pattern = r'https?://[^\s\'"<>()\]\}]+'
    urls.update(re.findall(http_pattern, content))
    
    # 协议相对URL
    protocol_relative = r'(?<!\w)//[^\s\'"<>()\]\}]+'
    urls.update(re.findall(protocol_relative, content))
    
    # API/接口路径模式
    api_patterns = [
        r'["\']/(?:api|api2|api3|v1|v2|v3)/[^\s\'"<>()]+',
        r'["\']/[^\s\'"<>()]*(?:login|auth|user|bbs|post|forum|upload|comment)[^\s\'"<>()]*',
        r'["\']/[^\s\'"<>()]*\.php(?:\?[^\s\'"<>()]*)?',
        r'["\']/[^\s\'"<>()]*\.json',
        r'["\']/[^\s\'"<>()]*\.html?',
    ]
    
    for pattern in api_patterns:
        matches = re.findall(pattern, content)
        urls.update(m.strip('\'"') for m in matches)
    
    return sorted(urls, key=lambda x: x.lower())

def filter_priority_urls(urls):
    """过滤出高优先级URL"""
    keywords = ['api', 'login', 'post', 'bbs', 'auth', 'user', 'upload', 'forum', 'comment']
    return [u for u in urls if any(k in u.lower() for k in keywords)]

def extract_js_snippets(content):
    """提取关键JavaScript代码片段"""
    snippets = []
    
    # 网络请求相关模式 (更全面的匹配)
    patterns = [
        # AJAX/Fetch
        (r'\$\.ajax\s*\(\s*\{[^}]+\}\s*\)', "jQuery.ajax"),
        (r'\$\.post\s*\(\s*["\'][^"\']+["\']\s*,[^)]+\)', "jQuery.post"),
        (r'\$\.get\s*\(\s*["\'][^"\']+["\']\s*,[^)]+\)', "jQuery.get"),
        (r'\$\.getJSON\s*\([^)]+\)', "jQuery.getJSON"),
        (r'fetch\s*\(\s*["\'][^"\']+["\']\s*,\s*\{[^}]+\}\s*\)', "fetch API"),
        (r'fetch\s*\(\s*["\'][^"\']+["\']\s*\)', "fetch API (GET)"),
        
        # XMLHttpRequest
        (r'new\s+XMLHttpRequest\s*\(\s*\)', "new XMLHttpRequest"),
        (r'xhr\.open\s*\(\s*["\'][^"\']+["\']\s*,\s*["\'][^"\']+["\']\s*\)', "xhr.open"),
        (r'xhr\.send\s*\([^)]*\)', "xhr.send"),
        
        # 常见API封装
        (r'api\.[a-zA-Z_]+\s*\([^)]*\)', "api.method call"),
        (r'\.request\s*\(\s*\{[^}]+\}\s*\)', ".request call"),
        (r'axios\.[a-z]+\s*\(\s*["\'][^"\']+["\']\s*\)', "axios request"),
        
        # URL/路径定义
        (r'(?:url|path|href|src)\s*[:=]\s*["\'][^"\']*(?:api|login|bbs|post)[^"\']*["\']', "URL/Path定义"),
        
        # API主机配置
        (r'(?:apiHost|baseUrl|serverUrl|host|domain)\s*[:=]\s*["\'][^"\']+["\']', "API Host配置"),
        
        # 回调函数
        (r'(?:success|error|complete|done|fail)\s*[:=]\s*function\s*\([^)]*\)\s*\{[^}]+\}', "Callback函数"),
        
        # 数据发送
        (r'data\s*[:=]\s*\{[^}]+\}', "Data对象"),
        (r'JSON\.stringify\s*\([^)]+\)', "JSON.stringify"),
        
        # 登录认证相关
        (r'(?:token|session|cookie|auth|password|username)\s*[:=]\s*["\']?[^,;\s]+', "Auth相关"),
    ]
    
    for pattern, desc in patterns:
        matches = re.findall(pattern, content, re.IGNORECASE)
        for m in matches[:15]:  # 每个模式最多取15条
            snippets.append((desc, m))
    
    return snippets

def extract_api_endpoints(content):
    """专门提取API端点"""
    endpoints = set()
    
    # 匹配常见的API定义模式
    patterns = [
        r'["\']((?:/[^/]+)+/?)["\']\s*[:=]\s*["\']((?:/[^/]+)+/?)["\']',
        r'(?:url|path|endpoint)\s*[:=]\s*["\']((?:/[^/\s]+)+/?)["\']',
        r'["\']((?:/api|/v\d|/login|/auth|/user|/bbs|/post|/forum)[^"\']*)["\']',
    ]
    
    for pattern in patterns:
        matches = re.findall(pattern, content, re.IGNORECASE)
        for match in matches:
            if isinstance(match, tuple):
                endpoints.update(match)
            else:
                endpoints.add(match)
    
    return sorted(endpoints)

def main():
    print("=" * 80)
    print("APK关键文件提取与URL/JS代码分析报告")
    print("=" * 80)
    print(f"APK路径: {APK_PATH}")
    print(f"目标文件数: {len(TARGET_FILES)}")
    print()
    
    all_urls = []
    all_priority_urls = []
    
    for idx, file_path in enumerate(TARGET_FILES, 1):
        print("=" * 80)
        print(f"[{idx}] 文件: {file_path}")
        print("=" * 80)
        
        content = read_apk_file(APK_PATH, file_path)
        
        if content is None:
            print("[⚠️  状态] 文件不存在于APK中")
            print()
            continue
        
        print(f"[✅ 状态] 文件读取成功 (大小: {len(content)} 字符)")
        print()
        
        # 1. 提取所有URL
        urls = extract_urls(content)
        priority_urls = filter_priority_urls(urls)
        all_urls.extend(urls)
        all_priority_urls.extend(priority_urls)
        
        print("--- 高优先级URL (含api/login/post/bbs/auth等) ---")
        if priority_urls:
            for url in priority_urls:
                print(f"  • {url}")
        else:
            print("  (未找到高优先级URL)")
        print()
        
        # 2. 提取API端点
        endpoints = extract_api_endpoints(content)
        print("--- API端点/API路径 ---")
        if endpoints:
            for ep in endpoints:
                print(f"  • {ep}")
        else:
            print("  (未找到API端点)")
        print()
        
        # 3. 提取关键JS代码片段
        snippets = extract_js_snippets(content)
        
        print("--- 关键JavaScript代码片段 (网络请求相关) ---")
        if snippets:
            seen = set()
            count = 0
            for desc, snippet in snippets:
                key = f"{desc}:{snippet}"
                if key not in seen and count < 40:
                    seen.add(key)
                    count += 1
                    snippet_preview = snippet[:250]
                    print(f"  [{desc}]")
                    print(f"    {snippet_preview}")
                    if len(snippet) > 250:
                        print(f"    ... (截断，共{len(snippet)}字符)")
                    print()
        else:
            print("  (未找到关键JS代码片段)")
        
        # 4. 显示文件前800字符预览
        print("--- 文件内容预览 (前800字符) ---")
        preview = content[:800].replace('\n', ' ')
        print(f"  {preview}...")
        print()
    
    # 汇总
    print("=" * 80)
    print("汇总统计")
    print("=" * 80)
    print(f"总共提取到 {len(set(all_urls))} 个唯一URL")
    print(f"其中高优先级URL: {len(set(all_priority_urls))} 个")
    print()
    print("--- 所有高优先级URL汇总 ---")
    for url in sorted(set(all_priority_urls)):
        print(f"  • {url}")
    
    print()
    print("=" * 80)
    print("分析完成")
    print("=" * 80)

if __name__ == "__main__":
    main()
