package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownloadService extends Service {
    private static final String b = DownloadService.class.getSimpleName();
    protected o a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = b;
        StringBuilder sb = new StringBuilder("onBind downloadServiceHandler != null:");
        sb.append(this.a != null);
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        o oVar = this.a;
        if (oVar != null) {
            return oVar.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(this);
        o z = c.z();
        this.a = z;
        z.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(b, "Service onDestroy");
        }
        o oVar = this.a;
        if (oVar != null) {
            oVar.d();
            this.a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(b, "DownloadService onStartCommand");
        }
        this.a.c();
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    o oVar = DownloadService.this.a;
                    if (oVar != null) {
                        oVar.a(intent, i, i2);
                    }
                }
            });
        }
        return c.j() ? 2 : 3;
    }
}
