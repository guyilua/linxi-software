package com.ss.android.downloadlib.b;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.a.a;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements a.InterfaceC0086a {
    private long a;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static e a = new e();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
    public void b() {
        this.a = System.currentTimeMillis();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0086a
    public void c() {
    }

    private e() {
        this.a = 0L;
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static e a() {
        return a.a;
    }

    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        a(dVar, k.j().optInt("check_an_result_delay", 1200) > 0 ? r0 : 1200);
    }

    public void a(final d dVar, final long j) {
        if (dVar == null) {
            return;
        }
        com.ss.android.downloadlib.e.a().a(new Runnable() { // from class: com.ss.android.downloadlib.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.ss.android.socialbase.downloader.a.a.a().c() && System.currentTimeMillis() - e.this.a > j) {
                    dVar.a(false);
                } else {
                    dVar.a(true);
                }
            }
        }, j);
    }

    public void a(d dVar) {
        a(dVar, 5000L);
    }
}
