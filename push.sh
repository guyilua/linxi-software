#!/bin/bash
# 林夕软件库 GitHub 推送脚本
# 用法: cd 到解压后的目录，运行 bash push.sh

echo "=== 林夕软件库 GitHub 推送脚本 ==="
echo ""
echo "提示: GitHub已禁用密码认证，请先生成 Personal Access Token"
echo ""
echo "1. 浏览器打开: https://github.com/settings/tokens/new"
echo "2. Note填: linxi-software"
echo "3. 勾选 'repo' (全选)"
echo "4. 点 Generate token，复制生成的 token"
echo ""
read -p "是否已准备好Token? (y/n): " ready

if [ "$ready" != "y" ]; then
    echo "请先生成Token后再运行此脚本"
    exit 1
fi

echo ""
echo "正在初始化git仓库..."
git init
git add .
git commit -m "init: 林夕软件库 - 精选软件资源分享"
git branch -M main
git remote add origin https://github.com/guyilua/linxi-software.git

echo ""
echo "正在推送..."
echo "提示: 输入密码时请粘贴你的 Personal Access Token (不是登录密码)"
git push -u origin main

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ 推送成功!"
    echo "仓库地址: https://github.com/guyilua/linxi-software"
    echo ""
    echo "接下来请开启GitHub Actions自动更新:"
    echo "1. 打开 https://github.com/guyilua/linxi-software/settings/actions"
    echo "2. 勾选 'Read and write permissions'"
    echo "3. 点 Save"
else
    echo ""
    echo "❌ 推送失败，请检查:"
    echo "- Token是否正确复制"
    echo "- 仓库是否存在"
fi
