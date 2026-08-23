package com.ss.android.socialbase.downloader.i;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    public static StringBuilder a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder b(StringBuilder sb, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            a(sb, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
            if (i < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String b(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append("\"" + str + '\"');
        sb.append(" (");
        a(sb, strArr);
        sb.append(") VALUES (");
        a(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < i - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            a(sb, str, strArr[i]).append("=?");
            if (i < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String a(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        a(sb, strArr);
        sb.append(") VALUES (");
        a(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String a(String str, String[] strArr) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            a(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        String str2 = "\"" + str + '\"';
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        b(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            a(sb, str2, strArr2);
        }
        return sb.toString();
    }
}
