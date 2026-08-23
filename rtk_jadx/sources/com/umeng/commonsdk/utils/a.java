package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: CountDownTimer.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class a {
    private static final int e = 1;
    private final long a;
    private final long b;

    /* renamed from: c, reason: collision with root package name */
    private long f1122c;
    private HandlerThread f;
    private Handler g;
    private boolean d = false;
    private Handler.Callback h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.d) {
                    return true;
                }
                long elapsedRealtime = a.this.f1122c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f != null) {
                        a.this.f.quit();
                    }
                } else if (elapsedRealtime < a.this.b) {
                    a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + a.this.b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += a.this.b;
                    }
                    a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j, long j2) {
        this.a = j;
        this.b = j2;
        if (!d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f = handlerThread;
            handlerThread.start();
            this.g = new Handler(this.f.getLooper(), this.h);
            return;
        }
        this.g = new Handler(this.h);
    }

    public abstract void a(long j);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.d = true;
        this.g.removeMessages(1);
    }

    public final synchronized a b() {
        this.d = false;
        if (this.a <= 0) {
            c();
            return this;
        }
        this.f1122c = SystemClock.elapsedRealtime() + this.a;
        Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
