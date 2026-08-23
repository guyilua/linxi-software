import sys
sys.path.insert(0, '/tmp/.pip-global/lib/python3.12/site-packages')

import logging
logging.disable(logging.CRITICAL)

import re
import os

# Try different androguard APIs
try:
    from androguard.core.apk import APK
    print("Using androguard.core.apk.APK")
except Exception as e:
    print(f"Failed to import APK: {e}")
    try:
        from androguard.core.bytecodes.apk import APK
        print("Using androguard.core.bytecodes.apk.APK")
    except Exception as e2:
        print(f"Failed to import bytecodes.apk: {e2}")
        raise

APK_PATH = "/home/work/dumate/d02d6cc798e148008169cbc91e32731c/workspace/ses_gffe5fe51acb97ffeqhVv5UIT5Dnshj/uploads/d02d6cc798e148008169cbc91e32731c/10a1ec5a-4653-4e00-8b65-0626bece7d9b.apk"
OUTPUT_PATH = "/tmp/huluxia_api.txt"

# Keywords to search for in strings
KEYWORDS = [
    'http', 'api.', 'huluxia', 'bbs', 'post', 'login', 'token', 'auth', 'thread', 'forum', 'upload', 'image'
]

# Keywords for filename search
API_FILE_KEYWORDS = ['api', 'network', 'http', 'request', 'service', 'rest', 'url', 'endpoint', 'retrofit', 'okhttp']

print(f"Analyzing APK: {APK_PATH}")
print(f"APK size: {os.path.getsize(APK_PATH)} bytes")

# Open APK
a = APK(APK_PATH)

# Collect results
all_strings = set()
url_strings = set()
keyword_matches = {k: set() for k in KEYWORDS}
api_files = set()

# Extract strings from all DEX files
for dex_idx, dex_bytes in enumerate(a.get_all_dex()):
    print(f"\n--- Processing DEX {dex_idx} ---")
    
    # Use DEX parser to get strings
    try:
        from androguard.core.dex import DEX
        d = DEX(dex_bytes)
    except Exception:
        try:
            from androguard.core.bytecodes.dvm import DalvikVMFormat
            d = DalvikVMFormat(dex_bytes)
        except Exception:
            print(f"Could not parse DEX {dex_idx}, trying raw extraction...")
            # Fallback: extract strings from raw bytes
            # Strings in DEX are length-prefixed UTF-8 or MUTF-8
            raw_strings = re.findall(br'[\x20-\x7e]{4,}', dex_bytes)
            for s in raw_strings:
                try:
                    decoded = s.decode('utf-8', errors='ignore')
                    if decoded and len(decoded) >= 4:
                        all_strings.add(decoded)
                except:
                    pass
            continue
    
    # Get strings from string table
    try:
        strings = d.get_strings()
        print(f"DEX {dex_idx}: found {len(strings)} strings")
        for s in strings:
            if isinstance(s, bytes):
                try:
                    decoded = s.decode('utf-8', errors='ignore')
                except:
                    continue
            else:
                decoded = str(s)
            
            if len(decoded) >= 3:
                all_strings.add(decoded)
    except Exception as e:
        print(f"Error getting strings from DEX {dex_idx}: {e}")

print(f"\nTotal unique strings extracted: {len(all_strings)}")

# Analyze strings
for s in all_strings:
    s_lower = s.lower()
    
    # Check for URLs
    if s.startswith('http://') or s.startswith('https://') or s.startswith('ws://') or s.startswith('wss://'):
        url_strings.add(s)
    
    # Check keywords
    for kw in KEYWORDS:
        if kw.lower() in s_lower:
            keyword_matches[kw].add(s)

# Search for API-related filenames in the APK
print("\n--- Searching for API-related files in APK ---")
try:
    from zipfile import ZipFile
    with ZipFile(APK_PATH, 'r') as zf:
        for name in zf.namelist():
            name_lower = name.lower()
            for kw in API_FILE_KEYWORDS:
                if kw in name_lower:
                    api_files.add(name)
                    break
except Exception as e:
    print(f"Error listing APK files: {e}")

# Also search for potential API class names in strings
api_classes = set()
for s in all_strings:
    s_lower = s.lower()
    # Look for class names containing API keywords
    if any(kw in s_lower for kw in API_FILE_KEYWORDS):
        if '/' in s or '.' in s:
            api_classes.add(s)

# Write results
with open(OUTPUT_PATH, 'w', encoding='utf-8') as f:
    f.write("=" * 80 + "\n")
    f.write("HULUXIA APK API ANALYSIS REPORT\n")
    f.write("=" * 80 + "\n\n")
    
    f.write(f"APK: {APK_PATH}\n")
    f.write(f"Total unique strings: {len(all_strings)}\n\n")
    
    # URLs
    f.write("-" * 80 + "\n")
    f.write("ALL URLS FOUND (HTTP/HTTPS/WS)\n")
    f.write("-" * 80 + "\n")
    for url in sorted(url_strings):
        f.write(url + "\n")
    f.write(f"\nTotal URLs: {len(url_strings)}\n\n")
    
    # Keyword matches
    f.write("-" * 80 + "\n")
    f.write("KEYWORD MATCHES IN STRINGS\n")
    f.write("-" * 80 + "\n")
    for kw in KEYWORDS:
        matches = keyword_matches[kw]
        if matches:
            f.write(f"\n[{kw.upper()}] ({len(matches)} matches):\n")
            for s in sorted(matches, key=len)[:200]:  # Limit per keyword
                f.write(f"  {s}\n")
        else:
            f.write(f"\n[{kw.upper()}] No matches found\n")
    
    # API-related files
    f.write("\n" + "=" * 80 + "\n")
    f.write("API-RELATED FILES IN APK\n")
    f.write("=" * 80 + "\n")
    for fname in sorted(api_files):
        f.write(fname + "\n")
    f.write(f"\nTotal API-related files: {len(api_files)}\n\n")
    
    # API-related class names in strings
    f.write("=" * 80 + "\n")
    f.write("API-RELATED CLASS/TYPE NAMES IN STRINGS\n")
    f.write("=" * 80 + "\n")
    for c in sorted(api_classes, key=len)[:300]:
        f.write(c + "\n")
    f.write(f"\nTotal API-related class names: {len(api_classes)}\n")

print(f"\nResults saved to: {OUTPUT_PATH}")
print(f"Total URLs found: {len(url_strings)}")
print(f"Total API-related files: {len(api_files)}")

# Print summary to console
print("\n" + "=" * 80)
print("URLS FOUND:")
print("=" * 80)
for url in sorted(url_strings):
    print(url)

print("\n" + "=" * 80)
print("HULUXIA-RELATED STRINGS:")
print("=" * 80)
for s in sorted(keyword_matches['huluxia'], key=len)[:50]:
    print(s)

print("\n" + "=" * 80)
print("API-RELATED FILES:")
print("=" * 80)
for fname in sorted(api_files)[:30]:
    print(fname)
