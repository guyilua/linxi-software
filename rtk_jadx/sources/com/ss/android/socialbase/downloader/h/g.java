package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    private Object a = new Object();
    private Queue<b> b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    private a f871c;
    private Handler d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class a extends HandlerThread {
        a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.d = new Handler(looper);
            }
            while (!g.this.b.isEmpty()) {
                b bVar = (b) g.this.b.poll();
                if (bVar != null) {
                    g.this.d.postDelayed(bVar.a, bVar.b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b {
        public Runnable a;
        public long b;

        public b(Runnable runnable, long j) {
            this.a = runnable;
            this.b = j;
        }
    }

    public g(String str) {
        this.f871c = new a(str);
    }

    public void b() {
        this.f871c.quit();
    }

    public void a() {
        this.f871c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j) {
        if (this.d == null) {
            synchronized (this.a) {
                if (this.d == null) {
                    this.b.add(new b(runnable, j));
                    return;
                }
            }
        }
        this.d.postDelayed(runnable, j);
    }
}
