package com.sigmob.sdk.archives.utils;

import java.io.UnsupportedEncodingException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private a() {
    }

    public static String a(com.sigmob.sdk.archives.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.c() ? 'd' : '-');
        String l = Long.toString(aVar.b());
        stringBuffer.append(' ');
        for (int i = 7; i > l.length(); i--) {
            stringBuffer.append(' ');
        }
        stringBuffer.append(l);
        stringBuffer.append(' ');
        stringBuffer.append(aVar.a());
        return stringBuffer.toString();
    }

    public static String a(byte[] bArr) {
        try {
            return new String(bArr, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean a(String str, byte[] bArr) {
        return a(str, bArr, 0, bArr.length);
    }

    public static boolean a(String str, byte[] bArr, int i, int i2) {
        try {
            byte[] bytes = str.getBytes("ASCII");
            return a(bytes, 0, bytes.length, bArr, i, i2, false);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return a(bArr, i, i2, bArr2, i3, i4, false);
    }

    public static boolean a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4, boolean z) {
        int i5 = i2 < i4 ? i2 : i4;
        for (int i6 = 0; i6 < i5; i6++) {
            if (bArr[i + i6] != bArr2[i3 + i6]) {
                return false;
            }
        }
        if (i2 == i4) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (i2 > i4) {
            while (i4 < i2) {
                if (bArr[i + i4] != 0) {
                    return false;
                }
                i4++;
            }
        } else {
            while (i2 < i4) {
                if (bArr2[i3 + i2] != 0) {
                    return false;
                }
                i2++;
            }
        }
        return true;
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2, 0, bArr2.length, false);
    }

    public static boolean a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, 0, bArr.length, bArr2, 0, bArr2.length, z);
    }

    public static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean b(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return a(bArr, i, i2, bArr2, i3, i4, true);
    }
}
