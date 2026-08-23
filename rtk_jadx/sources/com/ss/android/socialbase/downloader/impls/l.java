package com.ss.android.socialbase.downloader.impls;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {
    private static volatile com.ss.android.socialbase.downloader.downloader.m a;
    private static volatile com.ss.android.socialbase.downloader.downloader.m b;

    public static com.ss.android.socialbase.downloader.downloader.m a(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.c.T()) {
            if (b == null) {
                synchronized (l.class) {
                    if (b == null) {
                        b = com.ss.android.socialbase.downloader.downloader.c.U().b();
                    }
                }
            }
            return b;
        }
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }
}
