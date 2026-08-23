package com.umeng.commonsdk.config;

/* compiled from: BitUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    public static boolean a(int i, int i2) {
        return i2 >= 0 && i2 <= 31 && (i & (1 << i2)) != 0;
    }

    public static boolean a(long j, int i) {
        return i >= 0 && i <= 63 && (j & (1 << i)) != 0;
    }

    public static int b(int i, int i2) {
        return i | (1 << i2);
    }

    public static long b(long j, int i) {
        return (i < 0 || i > 63) ? j : j | (1 << i);
    }

    public static int c(int i, int i2) {
        return i & (~(1 << i2));
    }

    public static long c(long j, int i) {
        return (i < 0 || i > 63) ? j : j & (~(1 << i));
    }
}
