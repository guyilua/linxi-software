package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    public static volatile boolean a = false;
    private static final String b = "b";
    private static long g = -1;
    private static volatile b h;

    /* renamed from: c, reason: collision with root package name */
    private final k f904c = k.a();
    private final AtomicInteger d = new AtomicInteger();
    private final a e = new a(com.ss.android.socialbase.downloader.h.e.a());
    private long f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            b.this.f();
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private b() {
    }

    public static b a() {
        if (h == null) {
            synchronized (b.class) {
                if (h == null) {
                    h = new b();
                }
            }
        }
        return h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.O());
    }

    public void b() {
        try {
            com.ss.android.socialbase.downloader.c.a.c(b, "startSampling: mSamplingCounter = " + this.d);
            if (this.d.getAndIncrement() == 0) {
                this.e.a();
                this.f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            com.ss.android.socialbase.downloader.c.a.c(b, "stopSampling: mSamplingCounter = " + this.d);
            if (this.d.decrementAndGet() == 0) {
                this.e.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    protected void f() {
        long mobileRxBytes;
        try {
            e();
            if (a) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = g;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f904c.a(j2, uptimeMillis - this.f);
                    this.f = uptimeMillis;
                }
            }
            g = mobileRxBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void g() {
        f();
        g = -1L;
    }
}
