package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.interceptor.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f implements Runnable {
    private static final ExecutorService h = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Cancel Block", false));
    private static final String i = "DownloadChain";
    long e;
    volatile Thread f;
    private final int j;
    private final com.sigmob.sdk.downloader.f k;
    private final com.sigmob.sdk.downloader.core.breakpoint.c l;
    private final d m;
    private long n;
    private volatile com.sigmob.sdk.downloader.core.connection.a o;
    private final j q;
    final List<c.a> a = new ArrayList();
    final List<c.b> b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    int f533c = 0;
    int d = 0;
    final AtomicBoolean g = new AtomicBoolean(false);
    private final Runnable r = new Runnable() { // from class: com.sigmob.sdk.downloader.core.download.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.m();
        }
    };
    private final com.sigmob.sdk.downloader.core.dispatcher.a p = com.sigmob.sdk.downloader.g.j().b();

    private f(int i2, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, d dVar, j jVar) {
        this.j = i2;
        this.k = fVar;
        this.m = dVar;
        this.l = cVar;
        this.q = jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a(int i2, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, d dVar, j jVar) {
        return new f(i2, fVar, cVar, dVar, jVar);
    }

    public long a() {
        return this.n;
    }

    public void a(long j) {
        this.n = j;
    }

    public synchronized void a(com.sigmob.sdk.downloader.core.connection.a aVar) {
        this.o = aVar;
    }

    public void a(String str) {
        this.m.a(str);
    }

    public void b() {
        if (this.g.get() || this.f == null) {
            return;
        }
        this.f.interrupt();
    }

    public void b(long j) {
        this.e += j;
    }

    public com.sigmob.sdk.downloader.f c() {
        return this.k;
    }

    public com.sigmob.sdk.downloader.core.breakpoint.c d() {
        return this.l;
    }

    public int e() {
        return this.j;
    }

    public d f() {
        return this.m;
    }

    public com.sigmob.sdk.downloader.core.file.d g() {
        return this.m.a();
    }

    public synchronized com.sigmob.sdk.downloader.core.connection.a h() {
        return this.o;
    }

    public synchronized com.sigmob.sdk.downloader.core.connection.a i() {
        if (this.m.k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        if (this.o == null) {
            String b = this.m.b();
            if (b == null) {
                b = this.l.l();
            }
            com.sigmob.sdk.downloader.core.c.b(i, "create connection on url: " + b);
            this.o = com.sigmob.sdk.downloader.g.j().d().a(b);
        }
        return this.o;
    }

    public void j() {
        if (this.e == 0) {
            return;
        }
        this.p.a().b(this.k, this.j, this.e);
        this.e = 0L;
    }

    void k() {
        com.sigmob.sdk.downloader.core.dispatcher.a b = com.sigmob.sdk.downloader.g.j().b();
        com.sigmob.sdk.downloader.core.interceptor.d dVar = new com.sigmob.sdk.downloader.core.interceptor.d();
        com.sigmob.sdk.downloader.core.interceptor.a aVar = new com.sigmob.sdk.downloader.core.interceptor.a();
        this.a.add(dVar);
        this.a.add(aVar);
        this.a.add(new com.sigmob.sdk.downloader.core.interceptor.connect.b());
        this.a.add(new com.sigmob.sdk.downloader.core.interceptor.connect.a());
        this.f533c = 0;
        a.InterfaceC0041a n = n();
        if (this.m.k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        b.a().a(this.k, this.j, a());
        com.sigmob.sdk.downloader.core.interceptor.b bVar = new com.sigmob.sdk.downloader.core.interceptor.b(this.j, n.e(), g(), this.k);
        this.b.add(dVar);
        this.b.add(aVar);
        this.b.add(bVar);
        this.d = 0;
        b.a().c(this.k, this.j, o());
    }

    public void l() {
        this.f533c = 1;
        m();
    }

    public synchronized void m() {
        if (this.o != null) {
            this.o.b();
            com.sigmob.sdk.downloader.core.c.b(i, "release connection " + this.o + " task[" + this.k.c() + "] block[" + this.j + "]");
        }
        this.o = null;
    }

    public a.InterfaceC0041a n() {
        if (this.m.k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        List<c.a> list = this.a;
        int i2 = this.f533c;
        this.f533c = i2 + 1;
        return list.get(i2).a(this);
    }

    public long o() {
        if (this.m.k()) {
            throw com.sigmob.sdk.downloader.core.exception.c.a;
        }
        List<c.b> list = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        return list.get(i2).b(this);
    }

    public long p() {
        if (this.d == this.b.size()) {
            this.d--;
        }
        return o();
    }

    boolean q() {
        return this.g.get();
    }

    public j r() {
        return this.q;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (q()) {
            throw new IllegalAccessError("The chain has been finished!");
        }
        this.f = Thread.currentThread();
        try {
            k();
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.g.set(true);
            s();
            throw th;
        }
        this.g.set(true);
        s();
    }

    void s() {
        h.execute(this.r);
    }
}
