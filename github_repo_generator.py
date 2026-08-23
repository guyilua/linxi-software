#!/usr/bin/env python3
"""
GitHub仓库内容生成器
从all_posts_full.json读取全部12745条帖子数据
合并data.json中的完整数据（下载链接、正文、截图）
按分类组织生成README和分类索引页
"""

import json
import os
import re
from datetime import datetime

REPO_DIR = os.path.dirname(os.path.abspath(__file__))
POSTS_DB = "all_posts_full.json"
FULL_DATA = "data.json"


def log(msg):
    print(f"[{datetime.now().strftime('%H:%M:%S')}] {msg}")


def load_database():
    """加载帖子数据库，合并完整数据"""
    # 加载全部基础数据（12745条）
    log(f"加载 {POSTS_DB}...")
    with open(POSTS_DB, 'r', encoding='utf-8') as f:
        raw_posts = json.load(f)
    log(f"基础数据: {len(raw_posts)} 条")

    # 加载完整数据（下载链接、正文等）
    full_cache = {}
    if os.path.exists(FULL_DATA):
        log(f"加载 {FULL_DATA}...")
        with open(FULL_DATA, 'r', encoding='utf-8') as f:
            for post in json.load(f):
                full_cache[str(post.get("id", ""))] = post
        log(f"完整数据缓存: {len(full_cache)} 条")

    # 合并数据
    posts = []
    for post in raw_posts:
        pid = str(post.get("id", ""))

        # 基础数据
        merged = {
            "id": pid,
            "title": post.get("title", ""),
            "category": post.get("category_name", "未分类"),
        }

        # 如果有完整缓存，合并进去
        if pid in full_cache:
            cache = full_cache[pid]
            merged["content"] = cache.get("content", "")
            merged["screenshots"] = cache.get("screenshots", [])
            merged["download_link"] = cache.get("download_link", "")
            merged["source_url"] = cache.get("source_url", "")
        else:
            # 构造源站链接
            merged["source_url"] = f"http://img.lysq.cc.cd/software.php?id={pid}"
            merged["content"] = ""
            merged["screenshots"] = []
            merged["download_link"] = ""

        posts.append(merged)

    # 按ID倒序排列（最新的在前）
    posts.sort(key=lambda x: int(x["id"]), reverse=True)

    log(f"合并完成: {len(posts)} 条")
    has_dl = sum(1 for p in posts if p.get("download_link"))
    log(f"其中有下载链接: {has_dl} 条")

    return posts


def generate_readme(posts):
    """生成主 README.md"""
    log("生成 README.md...")

    # 分类统计
    categories = {}
    for post in posts:
        cat = post.get("category", "未分类")
        categories.setdefault(cat, []).append(post)

    # 排序：按分类内帖子数量从多到少
    sorted_cats = sorted(categories.items(), key=lambda x: -len(x[1]))

    content = f"""# 林夕软件库 - 精选软件资源分享

> 每日更新优质软件、游戏、工具资源，所有资源均经过测试，提供网盘高速下载。
> 
> **共收录 {len(posts)} 款软件**

## 关于

林夕软件库致力于分享**精品软件、实用工具、破解应用**，涵盖：

- Android 应用（破解版、去广告、解锁会员）
- PC 软件（绿色版、便携版、专业版）
- 在线工具（视频下载、格式转换、AI工具）
- 游戏（单机、模拟器、修改版）

**网站地址**: [http://img.lysq.cc.cd](http://img.lysq.cc.cd)

---

## 分类索引

"""

    # 生成分类索引表格
    content += "| 分类 | 数量 | 查看 |\n"
    content += "|------|------|------|\n"
    for cat_name, cat_posts in sorted_cats:
        safe = cat_name.replace("/", "-").replace("\\", "-")
        content += f"| {cat_name} | {len(cat_posts)} 款 | [查看](categories/{safe}.md) |\n"

    content += f"""
---

## 最新软件列表（前200条）

| 编号 | 软件名称 | 分类 | 下载 |
|------|----------|------|------|
"""

    # 显示最新的200条
    for post in posts[:200]:
        title = post.get("title", "")
        category = post.get("category", "未分类")
        post_id = post.get("id", "")
        dl = post.get("download_link", "")

        # 截断标题
        display_title = title[:45] + "..." if len(title) > 45 else title

        if dl:
            download = f"[下载]({dl})"
        else:
            # 没有直链就用源站链接
            src = post.get("source_url", "#")
            download = f"[源站]({src})"

        content += f"| {post_id} | {display_title} | {category} | {download} |\n"

    content += f"""
> 共收录 **{len(posts)}** 款软件，[查看完整分类索引 →](categories/)

---

## 使用指南

1. 在上方列表或分类索引中找到需要的软件
2. 点击 **下载** 链接获取网盘地址
3. 根据网盘提示输入提取码（如有）
4. 下载安装即可使用

---

## 免责声明

本仓库仅作**软件资源索引**，所有软件版权归原作者或开发商所有。
- 破解软件仅供学习研究，请于 24 小时内删除
- 商业用途请购买正版
- 如有侵权请联系删除

**本站不对软件安全性做任何担保，请自行判断风险。**

---

*最后更新: {datetime.now().strftime('%Y-%m-%d %H:%M:%S')}*

*林夕软件库 公益分享*
"""

    return content


def generate_category_page(cat_name, cat_posts):
    """生成分类详情页"""
    # 文件名安全化
    safe_name = cat_name.replace("/", "-").replace("\\", "-")

    content = f"""# {cat_name}

> 共 {len(cat_posts)} 款软件

[返回主页](../README.md)

---

| 编号 | 软件名称 | 下载 |
|------|----------|------|
"""

    for post in cat_posts:
        title = post.get("title", "")
        post_id = post.get("id", "")
        dl = post.get("download_link", "")

        display_title = title[:50] + "..." if len(title) > 50 else title

        if dl:
            download = f"[下载]({dl})"
        else:
            src = post.get("source_url", "#")
            download = f"[源站]({src})"

        content += f"| {post_id} | {display_title} | {download} |\n"

    content += "\n---\n\n*林夕软件库 公益分享*\n"

    return safe_name, content


def main():
    log("开始生成 GitHub 仓库内容...")

    # 加载数据
    posts = load_database()

    # 创建目录
    categories_dir = os.path.join(REPO_DIR, "categories")
    os.makedirs(categories_dir, exist_ok=True)

    # 生成README
    readme = generate_readme(posts)
    readme_path = os.path.join(REPO_DIR, "README.md")
    with open(readme_path, 'w', encoding='utf-8') as f:
        f.write(readme)
    log(f"README.md 已生成 ({len(readme)} 字符)")

    # 生成分类页
    categories = {}
    for post in posts:
        cat = post.get("category", "未分类")
        categories.setdefault(cat, []).append(post)

    cat_count = 0
    for cat_name, cat_posts in sorted(categories.items(), key=lambda x: -len(x[1])):
        safe_name, page_content = generate_category_page(cat_name, cat_posts)
        filepath = os.path.join(categories_dir, f"{safe_name}.md")
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(page_content)
        cat_count += 1

    log(f"分类页已生成: {cat_count} 个")
    log(f"软件总数: {len(posts)} 款")
    log("完成!")


if __name__ == "__main__":
    main()
