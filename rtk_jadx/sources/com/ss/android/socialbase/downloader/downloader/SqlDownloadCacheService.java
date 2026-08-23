package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SqlDownloadCacheService extends Service {
    private static final String a = SqlDownloadCacheService.class.getSimpleName();

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(a, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        t tVar;
        j y = c.y();
        if (y instanceof com.ss.android.socialbase.downloader.impls.d) {
            tVar = ((com.ss.android.socialbase.downloader.impls.d) y).f();
        } else {
            tVar = y instanceof t ? (t) y : null;
        }
        if (tVar instanceof IBinder) {
            return (IBinder) tVar;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (c.j()) {
            return 2;
        }
        return onStartCommand;
    }
}
