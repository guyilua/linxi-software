package com.ss.android.downloadlib;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    private static volatile g a;
    private com.ss.android.download.api.config.f b = null;

    private g() {
    }

    public static g a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    public com.ss.android.download.api.config.f b() {
        return this.b;
    }
}
