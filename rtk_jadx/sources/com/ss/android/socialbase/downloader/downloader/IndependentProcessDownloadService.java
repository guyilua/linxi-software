package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(this);
        if (c.U() == null) {
            c.a(new v());
        }
        o A = c.A();
        this.a = A;
        A.a(new WeakReference(this));
    }
}
