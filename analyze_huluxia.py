#!/usr/bin/env python3
"""
葫芦侠APK深度分析脚本
目标：提取登录和发帖API接口
兼容androguard 4.1.4+
"""

import sys
import os
import re
import json
from collections import defaultdict

from androguard.core.apk import APK

APK_PATH = "/home/work/dumate/d02d6cc798e148008169cbc91e32731c/workspace/ses_gffe5fe51acb97ffeqhVv5UIT5Dnshj/uploads/d02d6cc798e148008169cbc91e32731c/10a1ec5a-4653-4e00-8b65-0626bece7d9b.apk"
OUTPUT_DIR = "/home/work/dumate/d02d6cc798e148008169cbc91e32731c/workspace/ses_gffe5fe51acb97ffeqhVv5UIT5Dnshj/huluxia_analysis"

os.makedirs(OUTPUT_DIR, exist_ok=True)

# 关键词列表
KEYWORDS = ["login", "post", "bbs", "thread", "account", "password", "token",
            "sign", "auth", "user", "register", "publish", "reply", "comment",
            "forum", "board", "message", "send", "submit", "create", "key",
            "secret", "md5", "sha", "encrypt", "encode", "hash"]

# HTTP相关类名
HTTP_CLASSES = ["HttpClient", "OkHttp", "Retrofit", "Volley", "HttpURLConnection",
                "HttpRequest", "HttpUtils", "Network", "Api", "Service", "Client",
                "Request", "Response", "Interceptor"]

API_DOMAIN = "api.g.huluxia.com"


def extract_strings_from_dex(dex_bytes):
    """从DEX字节中提取所有字符串"""
    strings = set()
    try:
        # 尝试使用 androguard DEX 模块
        from androguard.core.dex import DEX
        dex = DEX(dex_bytes)
        for string_item in dex.strings:
            try:
                s = string_item.get()
                if s and len(s) > 1 and isinstance(s, str):
                    strings.add(s)
            except:
                pass
    except Exception as e:
        print(f"  DEX解析错误: {e}")
        # 备用方案：直接从字节中提取
        # 查找以\x00结尾的可读字符串
        pos = 0
        while pos < len(dex_bytes):
            # 查找http://, https://, /api/, 域名等模式
            for prefix in [b'http://', b'https://', b'/api/', b'/user/', b'/bbs/',
                           b'/thread/', b'/post/', b'/login', b'/account',
                           b'api.g.huluxia.com', b'huluxia.com']:
                idx = dex_bytes.find(prefix, pos)
                if idx != -1 and idx < len(dex_bytes) - 10:
                    end = idx + 10
                    while end < len(dex_bytes) and dex_bytes[end:end+1] not in b'\x00\x01\x02\x03\x04\x05\x06\x07\x08\x09\x0a\x0b\x0c\x0d\x0e\x0f':
                        end += 1
                    try:
                        s = dex_bytes[idx:end].decode('utf-8', errors='ignore')
                        if len(s) > 3:
                            strings.add(s)
                    except:
                        pass
                    pos = idx + 1
                    break
            else:
                pos += 1
    return strings


def extract_all_strings(dex_bytes):
    """提取DEX中所有可读字符串"""
    strings = set()
    try:
        from androguard.core.dex import DEX
        dex = DEX(dex_bytes)
        for string_item in dex.strings:
            try:
                s = string_item.get()
                if s and isinstance(s, str) and len(s) > 0:
                    strings.add(s)
            except:
                pass
    except Exception as e:
        print(f"    DEX解析错误 (备用方案): {e}")
    return strings


def main():
    print("=" * 70)
    print("葫芦侠APK深度分析 - API接口提取")
    print("=" * 70)

    # 加载APK
    print("\n[1/8] 正在加载APK...")
    apk = APK(APK_PATH)
    print(f"  包名: {apk.get_package()}")
    print(f"  版本: {apk.get_androidversion_name()}")
    print(f"  版本号: {apk.get_androidversion_code()}")

    # 获取所有DEX
    all_dex = list(apk.get_all_dex())
    print(f"  共 {len(all_dex)} 个DEX文件")

    # 收集所有字符串
    print("\n[2/8] 提取所有字符串常量...")
    all_strings = set()

    for i, dex_bytes in enumerate(all_dex):
        print(f"  处理DEX {i+1}/{len(all_dex)}...")
        strings = extract_all_strings(dex_bytes)
        print(f"    提取到 {len(strings)} 个字符串")
        all_strings.update(strings)

    print(f"  总计: {len(all_strings)} 个字符串常量")

    # 筛选URL和API路径
    print("\n[3/8] 分析URL和API路径...")
    api_paths = set()
    full_urls = set()
    url_patterns = []

    for s in all_strings:
        s_lower = s.lower()

        # 检查是否包含API域名
        if API_DOMAIN in s:
            full_urls.add(s)
            url_patterns.append(("DOMAIN", s))

        # 检查完整URL
        if s.startswith(("http://", "https://")):
            full_urls.add(s)
            url_patterns.append(("URL", s))

        # 检查API路径 (以 / 开头的路径)
        if s.startswith("/") and len(s) > 2 and len(s) < 200:
            # 过滤掉文件路径，保留API风格的路径
            if not s.startswith(("/res/", "/drawable", "/layout", "/assets",
                                "/values", "/raw/", "/mipmap", "/anim",
                                "/menu/", "/xml/", "/lib/")):
                # 检查是否包含关键词或看起来像是API路径
                has_keyword = any(k in s_lower for k in KEYWORDS)
                looks_like_api = (
                    "api" in s_lower or
                    "v1" in s_lower or "v2" in s_lower or "v3" in s_lower or
                    re.search(r'/\w+(/\w+)+', s) or
                    "json" in s_lower or
                    s.count('/') >= 2
                )

                if has_keyword or looks_like_api:
                    api_paths.add((s, has_keyword))
                    url_patterns.append(("PATH", s, has_keyword))

    # 筛选登录相关
    login_items = [s for s in all_strings if "login" in s.lower() or "auth" in s.lower()
                   or "sign" in s.lower() or "token" in s.lower()]

    # 筛选发帖相关
    post_items = [s for s in all_strings if "post" in s.lower() or "publish" in s.lower()
                  or "thread" in s.lower() or "bbs" in s.lower() or "create" in s.lower()]

    # 筛选签名/加密相关
    sign_items = [s for s in all_strings if "md5" in s.lower() or "sha" in s.lower()
                  or "sign" in s.lower() or "key" in s.lower() or "secret" in s.lower()
                  or "hash" in s.lower() or "encrypt" in s.lower()]

    print(f"  完整URL: {len(full_urls)}")
    print(f"  API路径: {len(api_paths)}")
    print(f"  登录相关字符串: {len(login_items)}")
    print(f"  发帖相关字符串: {len(post_items)}")
    print(f"  签名/加密相关: {len(sign_items)}")

    # 保存URL和路径
    with open(os.path.join(OUTPUT_DIR, "api_paths.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("葫芦侠APP API路径和URL分析\n")
        f.write("=" * 80 + "\n\n")

        f.write(f"分析时间: {os.popen('date').read().strip()}\n")
        f.write(f"APK版本: {apk.get_androidversion_name()}\n")
        f.write(f"APK包名: {apk.get_package()}\n\n")

        f.write("\n" + "=" * 80 + "\n")
        f.write("一、完整URL (包含 api.g.huluxia.com)\n")
        f.write("=" * 80 + "\n")
        for url in sorted(full_urls):
            f.write(f"  {url}\n")

        f.write("\n\n" + "=" * 80 + "\n")
        f.write("二、API路径 (以 / 开头)\n")
        f.write("=" * 80 + "\n")
        for path, has_kw in sorted(api_paths, key=lambda x: (not x[1], x[0])):
            flag = "[KEYWORD]" if has_kw else ""
            f.write(f"  {path} {flag}\n")

        f.write("\n\n" + "=" * 80 + "\n")
        f.write("三、登录认证相关\n")
        f.write("=" * 80 + "\n")
        for item in sorted(set(login_items)):
            f.write(f"  {item}\n")

        f.write("\n\n" + "=" * 80 + "\n")
        f.write("四、发帖/论坛相关\n")
        f.write("=" * 80 + "\n")
        for item in sorted(set(post_items)):
            f.write(f"  {item}\n")

        f.write("\n\n" + "=" * 80 + "\n")
        f.write("五、签名/加密/密钥相关\n")
        f.write("=" * 80 + "\n")
        for item in sorted(set(sign_items)):
            f.write(f"  {item}\n")

    print(f"  API路径结果已保存到: {OUTPUT_DIR}/api_paths.txt")

    # 使用androgurad分析类结构
    print("\n[4/8] 分析类和方法...")
    all_classes_info = []

    for dex_idx, dex_bytes in enumerate(all_dex):
        try:
            from androguard.core.dex import DEX
            dex = DEX(dex_bytes)

            for cls in dex.get_classes():
                cls_name = cls.name
                methods = [m.name for m in cls.get_methods()]
                all_classes_info.append((cls_name, methods))
        except Exception as e:
            print(f"  DEX {dex_idx+1} 解析错误: {e}")

    print(f"  总计: {len(all_classes_info)} 个类")

    # 搜索关键词相关类和方法
    print("\n[5/8] 搜索关键词相关类...")
    keyword_classes = defaultdict(list)

    for cls_name, methods in all_classes_info:
        cls_lower = cls_name.lower()
        matched_keywords = []

        for keyword in KEYWORDS:
            if keyword in cls_lower:
                matched_keywords.append(keyword)

        if matched_keywords:
            keyword_classes[tuple(matched_keywords)].append((cls_name, methods))

    # 保存关键词搜索结果
    with open(os.path.join(OUTPUT_DIR, "keyword_classes.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("关键词相关类搜索\n")
        f.write("=" * 80 + "\n\n")

        for keywords, classes in sorted(keyword_classes.items(), key=lambda x: -len(x[1])):
            f.write(f"\n关键词组合: {keywords} ({len(classes)} 个类)\n")
            f.write("-" * 60 + "\n")
            for cls_name, methods in classes:
                f.write(f"\n  类: {cls_name}\n")
                # 只显示与关键词匹配的方法
                for method in methods:
                    if method and any(kw in method.lower() for kw in KEYWORDS):
                        f.write(f"    方法: {method}\n")

    print(f"  找到 {len(keyword_classes)} 个关键词组合类别")
    print(f"  关键词类结果已保存到: {OUTPUT_DIR}/keyword_classes.txt")

    # 搜索HTTP相关类
    print("\n[6/8] 搜索HTTP/网络相关类...")
    http_classes = []

    for cls_name, methods in all_classes_info:
        cls_lower = cls_name.lower()
        if any(h.lower() in cls_lower for h in HTTP_CLASSES):
            http_classes.append((cls_name, methods))

    with open(os.path.join(OUTPUT_DIR, "http_classes.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("HTTP/网络相关类\n")
        f.write("=" * 80 + "\n\n")

        for cls_name, methods in http_classes:
            f.write(f"\n类: {cls_name}\n")
            f.write("-" * 40 + "\n")
            for method in methods:
                f.write(f"  {method}\n")

    print(f"  找到 {len(http_classes)} 个HTTP相关类")
    print(f"  HTTP类结果已保存到: {OUTPUT_DIR}/http_classes.txt")

    # 深入分析关键类（通过字符串关联）
    print("\n[7/8] 深入分析关键网络请求...")

    # 查找包含特定关键词的类
    critical_classes = []
    for cls_name, methods in all_classes_info:
        cls_lower = cls_name.lower()
        score = 0
        reasons = []

        if "login" in cls_lower:
            score += 10
            reasons.append("login")
        if "account" in cls_lower:
            score += 8
            reasons.append("account")
        if "user" in cls_lower:
            score += 5
            reasons.append("user")
        if "post" in cls_lower or "publish" in cls_lower:
            score += 10
            reasons.append("post/publish")
        if "bbs" in cls_lower or "thread" in cls_lower or "forum" in cls_lower:
            score += 8
            reasons.append("bbs/forum")
        if "api" in cls_lower:
            score += 5
            reasons.append("api")
        if "http" in cls_lower or "network" in cls_lower or "client" in cls_lower:
            score += 3
            reasons.append("http/network")
        if "sign" in cls_lower or "auth" in cls_lower:
            score += 7
            reasons.append("sign/auth")
        if "huluxia" in cls_lower:
            score += 3
            reasons.append("huluxia")
        if "request" in cls_lower or "service" in cls_lower:
            score += 4
            reasons.append("request/service")

        if score >= 5:
            critical_classes.append((score, cls_name, methods, reasons))

    critical_classes.sort(reverse=True)

    with open(os.path.join(OUTPUT_DIR, "critical_classes.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("关键类深度分析 (按重要性排序)\n")
        f.write("=" * 80 + "\n\n")

        for score, cls_name, methods, reasons in critical_classes[:200]:
            f.write(f"\n{'='*70}\n")
            f.write(f"类: {cls_name}\n")
            f.write(f"相关性分数: {score} (原因: {', '.join(reasons)})\n")
            f.write(f"{'='*70}\n\n")

            f.write("方法列表:\n")
            for method in methods:
                f.write(f"  - {method if method else 'N/A'}\n")

            # 检查方法是否包含关键词
            kw_methods = [m for m in methods if m and any(kw in m.lower() for kw in KEYWORDS)]
            if kw_methods:
                f.write("\n关键词方法:\n")
                for method in kw_methods:
                    f.write(f"  * {method}\n")

            f.write("\n")

    print(f"  分析了 {len(critical_classes)} 个关键类")
    print(f"  关键类分析已保存到: {OUTPUT_DIR}/critical_classes.txt")

    # 特别提取与 com.huluxia.gametools 相关的类
    print("\n[8/8] 提取 com.huluxia.gametools 包下的类...")
    huluxia_classes = [(name, methods) for name, methods in all_classes_info
                       if "huluxia" in name.lower()]

    with open(os.path.join(OUTPUT_DIR, "huluxia_package.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("com.huluxia.gametools 包下的类\n")
        f.write("=" * 80 + "\n\n")

        for cls_name, methods in sorted(huluxia_classes, key=lambda x: x[0]):
            f.write(f"\n类: {cls_name}\n")
            f.write("-" * 60 + "\n")
            for method in methods:
                f.write(f"  {method}\n")

    print(f"  找到 {len(huluxia_classes)} 个huluxia相关类")
    print(f"  huluxia包分析已保存到: {OUTPUT_DIR}/huluxia_package.txt")

    # 生成最终摘要报告
    with open(os.path.join(OUTPUT_DIR, "summary_report.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("葫芦侠APP API接口分析报告\n")
        f.write("=" * 80 + "\n\n")

        f.write("一、APK基本信息\n")
        f.write("-" * 40 + "\n")
        f.write(f"包名: {apk.get_package()}\n")
        f.write(f"版本: {apk.get_androidversion_name()}\n")
        f.write(f"版本号: {apk.get_androidversion_code()}\n")
        f.write(f"DEX文件数: {len(all_dex)}\n")
        f.write(f"总类数: {len(all_classes_info)}\n\n")

        f.write("二、发现的关键API路径\n")
        f.write("-" * 40 + "\n")

        # 按类别整理API路径
        login_paths = [p for p, _ in api_paths if "login" in p.lower() or "auth" in p.lower()]
        post_paths = [p for p, _ in api_paths if any(kw in p.lower() for kw in ["post", "thread", "bbs", "create", "publish"])]
        user_paths = [p for p, _ in api_paths if "user" in p.lower() or "account" in p.lower()]
        other_paths = [p for p, h in api_paths if p not in login_paths + post_paths + user_paths]

        if login_paths:
            f.write("\n[登录认证API]\n")
            for p in sorted(set(login_paths)):
                f.write(f"  {p}\n")

        if post_paths:
            f.write("\n[发帖/论坛API]\n")
            for p in sorted(set(post_paths)):
                f.write(f"  {p}\n")

        if user_paths:
            f.write("\n[用户相关API]\n")
            for p in sorted(set(user_paths)):
                f.write(f"  {p}\n")

        if other_paths:
            f.write("\n[其他API路径]\n")
            for p in sorted(set(other_paths))[:100]:
                f.write(f"  {p}\n")

        f.write("\n\n三、完整URL\n")
        f.write("-" * 40 + "\n")
        for url in sorted(full_urls)[:100]:
            f.write(f"  {url}\n")

        f.write("\n\n四、关键类统计\n")
        f.write("-" * 40 + "\n")
        f.write(f"  HTTP相关类: {len(http_classes)}\n")
        f.write(f"  关键词相关类: {sum(len(v) for v in keyword_classes.values())}\n")
        f.write(f"  huluxia包类: {len(huluxia_classes)}\n")
        f.write(f"  关键类(高相关性): {len(critical_classes)}\n")

        f.write("\n\n五、重要发现\n")
        f.write("-" * 40 + "\n")

        # 提取关键发现
        important_strings = [s for s in all_strings if any(x in s.lower() for x in
            ["api.g.huluxia.com", "/user/login", "/account/login", "bbs/post",
             "thread/create", "sign=", "token=", "password", "md5", "secret"])]

        for s in sorted(set(important_strings))[:100]:
            f.write(f"  {s}\n")

    print("\n" + "=" * 70)
    print("分析完成!")
    print("=" * 70)
    print(f"输出目录: {OUTPUT_DIR}")
    print(f"\n生成的文件:")
    print(f"  1. api_paths.txt - API路径和URL")
    print(f"  2. keyword_classes.txt - 关键词相关类")
    print(f"  3. http_classes.txt - HTTP相关类")
    print(f"  4. critical_classes.txt - 关键类分析")
    print(f"  5. huluxia_package.txt - huluxia包类")
    print(f"  6. summary_report.txt - 汇总报告")
    print("=" * 70)


if __name__ == "__main__":
    main()
