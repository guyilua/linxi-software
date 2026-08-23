import paramiko
import sys

host = "85.137.246.205"
username = "root"
password = "ZGo0ir43Nu3B"

commands = [
    'mysql -e "USE lxrjk; DESCRIBE category_mapping;"',
    'mysql -e "USE lxrjk; SELECT * FROM category_mapping LIMIT 10;"',
    'mysql -e "USE lxrjk; SELECT cm.category_id, c.name, COUNT(*) FROM category_mapping cm JOIN categories c ON cm.category_id=c.id GROUP BY cm.category_id ORDER BY COUNT(*) DESC;"',
    'mysql -e "USE lxrjk; SELECT COUNT(*) FROM category_mapping WHERE category_id IN (SELECT id FROM categories WHERE parent_id=9);"',
    'mysql -e "USE lxrjk; SELECT cm.software_id, s.title, cm.category_id FROM category_mapping cm JOIN software s ON cm.software_id=s.id JOIN categories c ON cm.category_id=c.id WHERE c.parent_id=9 ORDER BY s.id DESC LIMIT 20;"'
]

try:
    client = paramiko.SSHClient()
    client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
    client.connect(host, username=username, password=password, timeout=30)

    for i, cmd in enumerate(commands, 1):
        print(f"\n{'='*80}")
        print(f"命令 {i}: {cmd}")
        print(f"{'='*80}")
        stdin, stdout, stderr = client.exec_command(cmd, timeout=60)
        out = stdout.read().decode('utf-8', errors='replace').strip()
        err = stderr.read().decode('utf-8', errors='replace').strip()
        if out:
            print(out)
        if err:
            print("[STDERR]", err, file=sys.stderr)

    client.close()
    print("\n所有命令执行完成。")
except Exception as e:
    print(f"连接或执行失败: {e}", file=sys.stderr)
    sys.exit(1)
