package com.rtk.app.tool;

/* compiled from: PathEncrypTool.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q {
    public static String a(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] - 1);
        }
        return new String(bytes);
    }

    public static String b(String str) {
        return new String(u.a(str));
    }
}
