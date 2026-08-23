#!/usr/bin/env python3
"""
葫芦侠APK深度分析 - 第二阶段：提取方法代码和API细节
"""

import sys
import os
import re
from collections import defaultdict

from androguard.core.apk import APK
from androguard.core.dex import DEX

APK_PATH = "/home/work/dumate/d02d6cc798e148008169cbc91e32731c/workspace/ses_gffe5fe51acb97ffeqhVv5UIT5Dnshj/uploads/d02d6cc798e148008169cbc91e32731c/10a1ec5a-4653-4e00-8b65-0626bece7d9b.apk"
OUTPUT_DIR = "/home/work/dumate/d02d6cc798e148008169cbc91e32731c/workspace/ses_gffe5fe51acb97ffeqhVv5UIT5Dnshj/huluxia_analysis"

os.makedirs(OUTPUT_DIR, exist_ok=True)


def analyze_key_classes():
    """分析关键类的详细信息"""
    print("=" * 70)
    print("葫芦侠APK深度分析 - 第二阶段：提取方法代码")
    print("=" * 70)

    apk = APK(APK_PATH)
    all_dex = list(apk.get_all_dex())

    print(f"\n[1/4] 加载 {len(all_dex)} 个DEX文件...")

    # 收集所有类和字符串
    all_classes = {}
    all_strings = set()

    for dex_bytes in all_dex:
        dex = DEX(dex_bytes)
        for cls in dex.get_classes():
            all_classes[cls.name] = cls
            # 提取字符串
            for s in dex.strings:
                try:
                    val = s.get()
                    if val and isinstance(val, str) and len(val) > 0:
                        all_strings.add(val)
                except:
                    pass

    print(f"  总类数: {len(all_classes)}")
    print(f"  字符串常量: {len(all_strings)}")

    # 分析关键类
    target_classes = [
        'Lcom/huluxia/compressor/HlxRequestSign;',
        'Lcom/huluxia/compressor/HlxRequestSign$a;',
        'Lcom/huluxia/ui/account/LoginActivity;',
        'Lcom/huluxia/ui/account/AuthActivity;',
        'Lcom/huluxia/ui/account/AuthFragment;',
        'Lcom/huluxia/ui/bbs/topic/PublishTopicNormalFragment;',
        'Lcom/huluxia/ui/bbs/topic/PublishTopicHybridFragment;',
        'Lcom/huluxia/http/b;',  # HTTP请求类
        'Lcom/huluxia/http/c;',  # HTTP请求类
        'Lcom/huluxia/http/d;',  # HTTP请求类
    ]

    print("\n[2/4] 分析关键类...")
    with open(os.path.join(OUTPUT_DIR, "key_classes_detailed.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("关键类详细分析\n")
        f.write("=" * 80 + "\n\n")

        for class_name in target_classes:
            if class_name in all_classes:
                cls = all_classes[class_name]
                f.write(f"\n{'='*60}\n")
                f.write(f"类: {class_name}\n")
                f.write(f"{'='*60}\n\n")

                # 分析方法
                for method in cls.get_methods():
                    f.write(f"  方法: {method.name}\n")

                    # 尝试获取方法代码
                    code = method.get_code()
                    if code:
                        try:
                            # 尝试获取字节码指令
                            instructions = []
                            for ins in code.get_instructions():
                                instructions.append(f"    {ins.get_name()} {ins.get_output()}")
                            if instructions:
                                f.write("  字节码:\n")
                                for inst in instructions[:50]:  # 限制输出
                                    f.write(f"{inst}\n")
                                if len(instructions) > 50:
                                    f.write(f"    ... (共 {len(instructions)} 条指令)\n")
                        except Exception as e:
                            f.write(f"  [无法反编译: {e}]\n")
                    f.write("\n")
            else:
                f.write(f"\n[未找到类: {class_name}]\n")

    print(f"  关键类详细分析已保存")

    # 搜索签名相关字符串
    print("\n[3/4] 搜索签名/加密相关字符串...")
    sign_strings = [s for s in all_strings if any(k in s.lower() for k in
                    ['sign', 'md5', 'sha1', 'sha256', 'hmac', 'encrypt', 'secret', 'key='])]

    with open(os.path.join(OUTPUT_DIR, "sign_related.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("签名/加密相关字符串\n")
        f.write("=" * 80 + "\n\n")

        for s in sorted(set(sign_strings))[:500]:
            f.write(f"  {s}\n")

    print(f"  找到 {len(sign_strings)} 个签名相关字符串")

    # 搜索API URL模式
    print("\n[4/4] 提取API URL模式...")
    api_patterns = set()
    url_params = set()

    for s in all_strings:
        # 查找URL模式
        if s.startswith('/') and not s.startswith('//') and len(s) > 2:
            if 'ANDROID' in s or 'api' in s.lower() or any(k in s.lower() for k in
                ['login', 'post', 'user', 'account', 'bbs', 'thread', 'comment', 'create']):
                api_patterns.add(s)

        # 查找参数模式
        if '=' in s and any(k in s for k in ['_key', 'token', 'sign', 'password', 'user_id', 'cat_id', 'fid']):
            url_params.add(s)

    with open(os.path.join(OUTPUT_DIR, "api_patterns.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("API URL模式和参数\n")
        f.write("=" * 80 + "\n\n")

        f.write("API路径:\n")
        f.write("-" * 40 + "\n")
        for p in sorted(api_patterns):
            f.write(f"  {p}\n")

        f.write("\n\nURL参数模式:\n")
        f.write("-" * 40 + "\n")
        for p in sorted(url_params)[:200]:
            f.write(f"  {p}\n")

    print(f"  找到 {len(api_patterns)} 个API路径, {len(url_params)} 个参数模式")

    print("\n" + "=" * 70)
    print("第二阶段分析完成!")
    print("=" * 70)


def search_native_methods():
    """搜索native方法和加密相关类"""
    print("\n[额外] 搜索native方法...")

    apk = APK(APK_PATH)
    all_dex = list(apk.get_all_dex())

    native_methods = []
    for dex_bytes in all_dex:
        dex = DEX(dex_bytes)
        for cls in dex.get_classes():
            for method in cls.get_methods():
                if method.access_flags & 0x100:  # ACC_NATIVE
                    native_methods.append((cls.name, method.name))

    with open(os.path.join(OUTPUT_DIR, "native_methods.txt"), "w", encoding="utf-8") as f:
        f.write("=" * 80 + "\n")
        f.write("Native方法 (C/C++层)\n")
        f.write("=" * 80 + "\n\n")

        for cls_name, method_name in native_methods:
            f.write(f"  类: {cls_name}\n")
            f.write(f"  方法: {method_name}\n\n")

    print(f"  找到 {len(native_methods)} 个native方法")
    print(f"  结果已保存到: {OUTPUT_DIR}/native_methods.txt")


if __name__ == "__main__":
    analyze_key_classes()
    search_native_methods()
