package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownloadService extends Service {
    private SVSD a;
    private boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<b> f14c = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ com.qq.e.comm.managers.a a;

        /* renamed from: com.qq.e.comm.DownloadService$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/rtk_apk/classes3.dex */
        class RunnableC0002a implements Runnable {
            final /* synthetic */ SVSD a;

            RunnableC0002a(SVSD svsd) {
                this.a = svsd;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.onCreate();
                while (true) {
                    b bVar = (b) DownloadService.this.f14c.poll();
                    if (bVar == null) {
                        DownloadService.this.a = this.a;
                        return;
                    }
                    this.a.onStartCommand(bVar.a, bVar.b, bVar.f15c);
                }
            }
        }

        a(com.qq.e.comm.managers.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SVSD aPKDownloadServiceDelegate = this.a.c().getPOFactory().getAPKDownloadServiceDelegate(DownloadService.this);
                if (aPKDownloadServiceDelegate == null) {
                    GDTLogger.w("DownloadService初始化异常");
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0002a(aPKDownloadServiceDelegate));
                }
            } catch (Throwable th) {
                GDTLogger.w("DownloadService初始化异常", th);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class b {
        private final Intent a;
        private final int b;

        /* renamed from: c, reason: collision with root package name */
        private final int f15c;

        private b(Intent intent, int i, int i2) {
            this.a = intent;
            this.b = i;
            this.f15c = i2;
        }

        /* synthetic */ b(Intent intent, int i, int i2, a aVar) {
            this(intent, i, i2);
        }
    }

    private boolean c(boolean z) {
        if (this.a != null) {
            return true;
        }
        com.qq.e.comm.managers.a b2 = com.qq.e.comm.managers.a.b();
        if (!b2.d()) {
            return false;
        }
        if (!z) {
            if (this.b) {
                return false;
            }
            this.b = true;
            com.qq.e.comm.managers.a.g.submit(new a(b2));
            return false;
        }
        try {
            SVSD aPKDownloadServiceDelegate = b2.c().getPOFactory().getAPKDownloadServiceDelegate(this);
            this.a = aPKDownloadServiceDelegate;
            aPKDownloadServiceDelegate.onCreate();
            return true;
        } catch (Throwable th) {
            GDTLogger.w("DownloadService初始化异常", th);
            return false;
        }
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.d("DownloadService.onBind");
        SVSD svsd = this.a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (TextUtils.isEmpty(stringExtra) || !c(true)) {
            return null;
        }
        return this.a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID"))) {
            GDTLogger.w("Service onStartCommand 出现异常");
            return 2;
        }
        if (c(false)) {
            return this.a.onStartCommand(intent, i, i2);
        }
        this.f14c.add(new b(intent, i, i2, null));
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        SVSD svsd = this.a;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
