package c.d.a;

import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: FileTypeJudge.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class b {
    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    private static String b(String str) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[28];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            fileInputStream.read(bArr, 0, 28);
            try {
                fileInputStream.close();
                return a(bArr);
            } catch (IOException e2) {
                e2.printStackTrace();
                throw e2;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            throw e;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    throw e4;
                }
            }
            throw th;
        }
    }

    public static a c(String str) {
        String b = b(str);
        if (b != null && b.length() != 0) {
            String upperCase = b.toUpperCase();
            for (a aVar : a.values()) {
                if (upperCase.startsWith(aVar.b())) {
                    return aVar;
                }
            }
        }
        return null;
    }
}
