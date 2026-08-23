package com.rtk.app.c;

import android.text.TextUtils;
import com.rtk.app.tool.c0;

/* compiled from: JSONUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private static void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                sb.append('\t');
            } catch (Exception e) {
                c0.u("JSONUtil", e.getMessage());
                return;
            }
        }
    }

    public static String b(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    char c2 = 0;
                    boolean z = false;
                    int i2 = 0;
                    while (i < str.length()) {
                        char charAt = str.charAt(i);
                        if (charAt == '\"') {
                            if (c2 != '\\') {
                                z = !z;
                            }
                            sb.append(charAt);
                        } else if (charAt != ',') {
                            if (charAt != '{') {
                                if (charAt != '}') {
                                    switch (charAt) {
                                        case '[':
                                            break;
                                        case '\\':
                                            break;
                                        case ']':
                                            break;
                                        default:
                                            sb.append(charAt);
                                            break;
                                    }
                                }
                                if (!z) {
                                    sb.append('\n');
                                    i2--;
                                    a(sb, i2);
                                }
                                sb.append(charAt);
                            }
                            sb.append(charAt);
                            if (!z) {
                                sb.append('\n');
                                i2++;
                                a(sb, i2);
                            }
                        } else {
                            sb.append(charAt);
                            if (c2 != '\\' && !z) {
                                sb.append('\n');
                                a(sb, i2);
                            }
                        }
                        i++;
                        c2 = charAt;
                    }
                    return sb.toString();
                }
            } catch (Exception e) {
                c0.u("JSONUtil", e.getMessage());
            }
        }
        return "";
    }

    public static boolean c(String str) {
        return TextUtils.isEmpty(str) || TextUtils.equals("0", str);
    }
}
