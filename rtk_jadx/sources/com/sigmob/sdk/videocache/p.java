package com.sigmob.sdk.videocache;

import com.czhj.sdk.logger.SigmobLog;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class p {
    private static final int a = 1;
    private final u b;

    /* renamed from: c, reason: collision with root package name */
    private final c f671c;
    private volatile Thread g;
    private volatile boolean h;
    private final Object d = new Object();
    private final Object e = new Object();
    private volatile int i = -1;
    private final AtomicInteger f = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p.this.e();
        }
    }

    public p(u uVar, c cVar) {
        this.b = (u) o.a(uVar);
        this.f671c = (c) o.a(cVar);
    }

    private void b() {
        int i = this.f.get();
        if (i < 1) {
            return;
        }
        this.f.set(0);
        throw new q("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    private synchronized void c() {
        boolean z = (this.g == null || this.g.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.h && !this.f671c.d() && !z) {
            SigmobLog.d("Thread create ,current thread num :" + Thread.activeCount());
            this.g = new Thread(new a(), "Source reader for " + this.b);
            this.g.start();
        }
    }

    private void c(Throwable th) {
        a(th);
    }

    private void d() {
        synchronized (this.d) {
            try {
                try {
                    this.d.wait(1000L);
                } catch (InterruptedException e) {
                    throw new q("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long j = -1;
        long j2 = 0;
        try {
            j2 = this.f671c.a();
            this.b.a(j2);
            j = this.b.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = this.b.a(bArr);
                if (a2 == -1) {
                    g();
                    f();
                    i();
                    b(j2, j);
                    synchronized (this.d) {
                        this.d.notifyAll();
                    }
                    return;
                }
                synchronized (this.e) {
                    if (h()) {
                        SigmobLog.d("SourceReaderRunnable停止从服务器下载视频数据");
                        i();
                        b(j2, j);
                        synchronized (this.d) {
                            this.d.notifyAll();
                        }
                        return;
                    }
                    this.f671c.a(bArr, a2);
                }
                j2 += a2;
                b(j2, j);
            }
        } catch (Throwable th) {
            try {
                this.f.incrementAndGet();
                b(th);
                c(th);
                i();
                b(j2, j);
                synchronized (this.d) {
                    this.d.notifyAll();
                }
            } catch (Throwable th2) {
                i();
                b(j2, j);
                synchronized (this.d) {
                    this.d.notifyAll();
                    throw th2;
                }
            }
        }
    }

    private void f() {
        this.i = 100;
        a(this.i);
    }

    private void g() {
        synchronized (this.e) {
            if (!h() && this.f671c.a() == this.b.a()) {
                this.f671c.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.h;
    }

    private void i() {
        try {
            this.b.b();
        } catch (q e) {
            b(new q("Error closing source " + this.b, e));
        }
    }

    public int a(byte[] bArr, long j, int i) {
        r.a(bArr, j, i);
        while (!this.f671c.d() && this.f671c.a() < i + j && !this.h) {
            c();
            d();
            b();
        }
        int a2 = this.f671c.a(bArr, j, i);
        if (this.f671c.d() && this.i != 100) {
            this.i = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.e) {
            SigmobLog.d("Shutdown proxy for " + this.b);
            try {
                this.h = true;
                if (this.g != null) {
                    this.g.interrupt();
                }
                this.f671c.b();
            } catch (q e) {
                b(e);
            }
        }
    }

    protected void a(int i) {
    }

    protected void a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((((float) j) / ((float) j2)) * 100.0f);
        boolean z = i != this.i;
        if ((j2 >= 0) && z) {
            a(i);
        }
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Throwable th) {
    }

    protected final void b(Throwable th) {
        if (th instanceof l) {
            SigmobLog.d("ProxyCache is interrupted");
        } else {
            SigmobLog.e("ProxyCache error", th);
        }
    }
}
