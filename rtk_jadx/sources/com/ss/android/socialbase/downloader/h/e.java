package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class e implements Handler.Callback {
    private volatile Handler a = new Handler(a.a, this);

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static final Looper a;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            a = handlerThread.getLooper();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        long a();
    }

    public static Looper a() {
        return a.a;
    }

    public void b() {
        Handler handler = this.a;
        if (handler == null) {
            return;
        }
        this.a = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            b bVar = (b) message.obj;
            long a2 = bVar.a();
            if (a2 <= 0) {
                return true;
            }
            a(bVar, a2);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void a(b bVar, long j) {
        Handler handler = this.a;
        if (handler == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = bVar;
        handler.sendMessageDelayed(obtain, j);
    }
}
