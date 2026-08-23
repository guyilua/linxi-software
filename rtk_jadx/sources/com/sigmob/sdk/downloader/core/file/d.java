package com.sigmob.sdk.downloader.core.file;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private static final String n = "MultiPointOutputStream";
    private static final ExecutorService o = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload file io", false));
    final SparseArray<com.sigmob.sdk.downloader.core.file.a> a;
    final SparseArray<AtomicLong> b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicLong f538c;
    final AtomicLong d;
    boolean e;
    volatile Future f;
    volatile Thread g;
    final SparseArray<Thread> h;
    IOException i;
    ArrayList<Integer> j;
    List<Integer> k;
    final a l;
    a m;
    private final int p;
    private final int q;
    private final int r;
    private final com.sigmob.sdk.downloader.core.breakpoint.c s;
    private final f t;
    private final j u;
    private final boolean v;
    private final boolean w;
    private final Runnable x;
    private String y;
    private volatile boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        boolean a;
        List<Integer> b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        List<Integer> f539c = new ArrayList();

        a() {
        }

        boolean a() {
            return this.a || this.f539c.size() > 0;
        }
    }

    public d(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar) {
        this(fVar, cVar, jVar, null);
    }

    d(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, j jVar, Runnable runnable) {
        this.a = new SparseArray<>();
        this.b = new SparseArray<>();
        this.f538c = new AtomicLong();
        this.d = new AtomicLong();
        this.e = false;
        this.h = new SparseArray<>();
        this.l = new a();
        this.m = new a();
        this.z = true;
        this.t = fVar;
        this.p = fVar.p();
        this.q = fVar.q();
        this.r = fVar.r();
        this.s = cVar;
        this.u = jVar;
        this.v = g.j().e().a();
        this.w = g.j().f().b(fVar);
        this.j = new ArrayList<>();
        if (runnable == null) {
            this.x = new Runnable() { // from class: com.sigmob.sdk.downloader.core.file.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.g();
                }
            };
        } else {
            this.x = runnable;
        }
        File m = fVar.m();
        if (m != null) {
            this.y = m.getAbsolutePath();
        }
    }

    private void m() {
        if (this.y != null || this.t.m() == null) {
            return;
        }
        this.y = this.t.m().getAbsolutePath();
    }

    public void a() {
        o.execute(new Runnable() { // from class: com.sigmob.sdk.downloader.core.file.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
    }

    public synchronized void a(int i) {
        String str;
        String str2;
        this.j.add(Integer.valueOf(i));
        try {
            IOException iOException = this.i;
            if (iOException != null) {
                throw iOException;
            }
            if (this.f == null || this.f.isDone()) {
                if (this.f == null) {
                    str = n;
                    str2 = "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.t.c() + "] block[" + i + "]";
                } else {
                    str = n;
                    str2 = "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.f.isDone() + "] task[" + this.t.c() + "] block[" + i + "]";
                }
                com.sigmob.sdk.downloader.core.c.b(str, str2);
            } else {
                AtomicLong atomicLong = this.b.get(i);
                if (atomicLong != null && atomicLong.get() > 0) {
                    a(this.l);
                    a(this.l.a, i);
                }
            }
        } finally {
            c(i);
        }
    }

    public synchronized void a(int i, byte[] bArr, int i2) {
        if (this.e) {
            return;
        }
        e(i).a(bArr, 0, i2);
        long j = i2;
        this.f538c.addAndGet(j);
        this.b.get(i).addAndGet(j);
        d();
    }

    void a(long j) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j));
    }

    void a(StatFs statFs, long j) {
        long a2 = com.sigmob.sdk.downloader.core.c.a(statFs);
        if (a2 < j) {
            throw new com.sigmob.sdk.downloader.core.exception.e(j, a2);
        }
    }

    void a(a aVar) {
        aVar.f539c.clear();
        int size = new HashSet((List) this.j.clone()).size();
        if (size != this.k.size()) {
            com.sigmob.sdk.downloader.core.c.b(n, "task[" + this.t.c() + "] current need fetching block count " + this.k.size() + " is not equal to no more stream block count " + size);
            aVar.a = false;
        } else {
            com.sigmob.sdk.downloader.core.c.b(n, "task[" + this.t.c() + "] current need fetching block count " + this.k.size() + " is equal to no more stream block count " + size);
            aVar.a = true;
        }
        SparseArray<com.sigmob.sdk.downloader.core.file.a> clone = this.a.clone();
        int size2 = clone.size();
        for (int i = 0; i < size2; i++) {
            int keyAt = clone.keyAt(i);
            if (this.j.contains(Integer.valueOf(keyAt)) && !aVar.b.contains(Integer.valueOf(keyAt))) {
                aVar.b.add(Integer.valueOf(keyAt));
                aVar.f539c.add(Integer.valueOf(keyAt));
            }
        }
    }

    void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    public void a(List<Integer> list) {
        this.k = list;
    }

    void a(boolean z, int i) {
        if (this.f == null || this.f.isDone()) {
            return;
        }
        if (!z) {
            this.h.put(i, Thread.currentThread());
        }
        if (this.g == null) {
            while (!c()) {
                a(25L);
            }
        }
        a(this.g);
        if (!z) {
            e();
            return;
        }
        a(this.g);
        try {
            this.f.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public synchronized void b() {
        List<Integer> list = this.k;
        if (list == null) {
            return;
        }
        if (this.e) {
            return;
        }
        this.e = true;
        this.j.addAll(list);
        try {
            if (this.f538c.get() <= 0) {
                return;
            }
            if (this.f != null && !this.f.isDone()) {
                m();
                g.j().f().a().a(this.y);
                try {
                    a(true, -1);
                    g.j().f().a().b(this.y);
                } catch (Throwable th) {
                    g.j().f().a().b(this.y);
                    throw th;
                }
            }
            for (Integer num : this.k) {
                try {
                    c(num.intValue());
                } catch (IOException e) {
                    com.sigmob.sdk.downloader.core.c.b(n, "OutputStream close failed task[" + this.t.c() + "] block[" + num + "]" + e);
                }
            }
            this.u.a(this.t.c(), com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
            return;
        } finally {
            for (Integer num2 : this.k) {
                try {
                    c(num2.intValue());
                } catch (IOException e2) {
                    com.sigmob.sdk.downloader.core.c.b(n, "OutputStream close failed task[" + this.t.c() + "] block[" + num2 + "]" + e2);
                }
            }
            this.u.a(this.t.c(), com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
        }
    }

    public void b(int i) {
        com.sigmob.sdk.downloader.core.breakpoint.a b = this.s.b(i);
        if (b.d() == -1 || com.sigmob.sdk.downloader.core.c.a(b.a(), b.d())) {
            return;
        }
        throw new IOException("The current offset on block-info isn't update correct, " + b.a() + " != " + b.d() + " on " + i);
    }

    synchronized void c(int i) {
        com.sigmob.sdk.downloader.core.file.a aVar = this.a.get(i);
        if (aVar != null) {
            aVar.a();
            synchronized (this.b) {
                this.a.remove(i);
                this.b.remove(i);
            }
            com.sigmob.sdk.downloader.core.c.b(n, "OutputStream close task[" + this.t.c() + "] block[" + i + "]");
        }
    }

    boolean c() {
        return this.g != null;
    }

    void d() {
        IOException iOException = this.i;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f == null) {
            synchronized (this.x) {
                if (this.f == null) {
                    this.f = f();
                }
            }
        }
    }

    public void d(int i) {
        this.j.add(Integer.valueOf(i));
    }

    synchronized com.sigmob.sdk.downloader.core.file.a e(int i) {
        com.sigmob.sdk.downloader.core.file.a aVar;
        Uri h;
        aVar = this.a.get(i);
        if (aVar == null) {
            boolean b = com.sigmob.sdk.downloader.core.c.b(this.t.h());
            if (b) {
                File m = this.t.m();
                if (m == null) {
                    throw new FileNotFoundException("Filename is not ready!");
                }
                File l = this.t.l();
                if (!l.exists() && !l.mkdirs()) {
                    throw new IOException("Create parent folder failed!");
                }
                if (m.createNewFile()) {
                    com.sigmob.sdk.downloader.core.c.b(n, "Create new file: " + m.getName());
                }
                h = Uri.fromFile(m);
            } else {
                h = this.t.h();
            }
            com.sigmob.sdk.downloader.core.file.a a2 = g.j().e().a(g.j().h(), h, this.p);
            if (this.v) {
                long c2 = this.s.b(i).c();
                if (c2 > 0) {
                    a2.a(c2);
                    com.sigmob.sdk.downloader.core.c.b(n, "Create output stream write from (" + this.t.c() + ") block(" + i + ") " + c2);
                }
            }
            if (this.z) {
                this.u.f(this.t.c());
            }
            if (!this.s.b() && this.z && this.w) {
                long j = this.s.j();
                if (b) {
                    File m2 = this.t.m();
                    long length = j - m2.length();
                    if (length > 0) {
                        a(new StatFs(m2.getAbsolutePath()), length);
                    }
                }
                a2.b(j);
            }
            synchronized (this.b) {
                this.a.put(i, a2);
                this.b.put(i, new AtomicLong());
            }
            this.z = false;
            aVar = a2;
        }
        return aVar;
    }

    void e() {
        LockSupport.park();
    }

    Future f() {
        return o.submit(this.x);
    }

    void g() {
        try {
            h();
        } catch (IOException e) {
            this.i = e;
            com.sigmob.sdk.downloader.core.c.a(n, "Sync to breakpoint-store for task[" + this.t.c() + "] failed with cause: " + e);
        }
    }

    void h() {
        com.sigmob.sdk.downloader.core.c.b(n, "OutputStream start flush looper task[" + this.t.c() + "] with syncBufferIntervalMills[" + this.r + "] syncBufferSize[" + this.q + "]");
        this.g = Thread.currentThread();
        long j = (long) this.r;
        l();
        while (true) {
            a(j);
            a(this.m);
            if (this.m.a()) {
                com.sigmob.sdk.downloader.core.c.b(n, "runSync state change isNoMoreStream[" + this.m.a + "] newNoMoreStreamBlockList[" + this.m.f539c + "]");
                if (this.f538c.get() > 0) {
                    l();
                }
                for (Integer num : this.m.f539c) {
                    Thread thread = this.h.get(num.intValue());
                    this.h.remove(num.intValue());
                    if (thread != null) {
                        a(thread);
                    }
                }
                if (this.m.a) {
                    break;
                }
            } else {
                if (!i()) {
                    j = j();
                    if (j <= 0) {
                        l();
                    }
                }
                j = this.r;
            }
        }
        int size = this.h.size();
        for (int i = 0; i < size; i++) {
            Thread valueAt = this.h.valueAt(i);
            if (valueAt != null) {
                a(valueAt);
            }
        }
        this.h.clear();
        com.sigmob.sdk.downloader.core.c.b(n, "OutputStream stop flush looper task[" + this.t.c() + "]");
    }

    boolean i() {
        return this.f538c.get() < ((long) this.q);
    }

    long j() {
        return this.r - (k() - this.d.get());
    }

    long k() {
        return SystemClock.uptimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[Catch: all -> 0x00da, TryCatch #1 {, blocks: (B:4:0x0003, B:9:0x0014, B:11:0x002a, B:19:0x005b, B:21:0x0061, B:23:0x00c9, B:24:0x00d8, B:17:0x0040), top: B:3:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void l() {
        /*
            r12 = this;
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r0 = r12.b
            monitor-enter(r0)
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r1 = r12.b     // Catch: java.lang.Throwable -> Lda
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Lda
            android.util.SparseArray r2 = new android.util.SparseArray     // Catch: java.lang.Throwable -> Lda
            r2.<init>(r1)     // Catch: java.lang.Throwable -> Lda
            r3 = 0
            r4 = 0
        L10:
            r5 = 0
            if (r4 >= r1) goto L58
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r7 = r12.b     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            int r7 = r7.keyAt(r4)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r8 = r12.b     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            java.lang.Object r8 = r8.get(r7)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            java.util.concurrent.atomic.AtomicLong r8 = (java.util.concurrent.atomic.AtomicLong) r8     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            long r8 = r8.get()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 <= 0) goto L3c
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            r2.put(r7, r8)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            android.util.SparseArray<com.sigmob.sdk.downloader.core.file.a> r8 = r12.a     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            java.lang.Object r7 = r8.get(r7)     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.core.file.a r7 = (com.sigmob.sdk.downloader.core.file.a) r7     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
            r7.b()     // Catch: java.io.IOException -> L3f java.lang.Throwable -> Lda
        L3c:
            int r4 = r4 + 1
            goto L10
        L3f:
            r1 = move-exception
            java.lang.String r4 = "MultiPointOutputStream"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lda
            r7.<init>()     // Catch: java.lang.Throwable -> Lda
            java.lang.String r8 = "OutputStream flush and sync data to filesystem failed "
            r7.append(r8)     // Catch: java.lang.Throwable -> Lda
            r7.append(r1)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r1 = r7.toString()     // Catch: java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.core.c.a(r4, r1)     // Catch: java.lang.Throwable -> Lda
            r1 = 0
            goto L59
        L58:
            r1 = 1
        L59:
            if (r1 == 0) goto Ld8
            int r1 = r2.size()     // Catch: java.lang.Throwable -> Lda
        L5f:
            if (r3 >= r1) goto Lc9
            int r4 = r2.keyAt(r3)     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r7 = r2.valueAt(r3)     // Catch: java.lang.Throwable -> Lda
            java.lang.Long r7 = (java.lang.Long) r7     // Catch: java.lang.Throwable -> Lda
            long r7 = r7.longValue()     // Catch: java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.core.breakpoint.j r9 = r12.u     // Catch: java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.core.breakpoint.c r10 = r12.s     // Catch: java.lang.Throwable -> Lda
            r9.a(r10, r4, r7)     // Catch: java.lang.Throwable -> Lda
            long r5 = r5 + r7
            android.util.SparseArray<java.util.concurrent.atomic.AtomicLong> r9 = r12.b     // Catch: java.lang.Throwable -> Lda
            java.lang.Object r9 = r9.get(r4)     // Catch: java.lang.Throwable -> Lda
            java.util.concurrent.atomic.AtomicLong r9 = (java.util.concurrent.atomic.AtomicLong) r9     // Catch: java.lang.Throwable -> Lda
            long r10 = -r7
            r9.addAndGet(r10)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r9 = "MultiPointOutputStream"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lda
            r10.<init>()     // Catch: java.lang.Throwable -> Lda
            java.lang.String r11 = "OutputStream sync success ("
            r10.append(r11)     // Catch: java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.f r11 = r12.t     // Catch: java.lang.Throwable -> Lda
            int r11 = r11.c()     // Catch: java.lang.Throwable -> Lda
            r10.append(r11)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r11 = ") block("
            r10.append(r11)     // Catch: java.lang.Throwable -> Lda
            r10.append(r4)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r11 = ")  syncLength("
            r10.append(r11)     // Catch: java.lang.Throwable -> Lda
            r10.append(r7)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r7 = ") currentOffset("
            r10.append(r7)     // Catch: java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.core.breakpoint.c r7 = r12.s     // Catch: java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.core.breakpoint.a r4 = r7.b(r4)     // Catch: java.lang.Throwable -> Lda
            long r7 = r4.a()     // Catch: java.lang.Throwable -> Lda
            r10.append(r7)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r4 = ")"
            r10.append(r4)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r4 = r10.toString()     // Catch: java.lang.Throwable -> Lda
            com.sigmob.sdk.downloader.core.c.b(r9, r4)     // Catch: java.lang.Throwable -> Lda
            int r3 = r3 + 1
            goto L5f
        Lc9:
            java.util.concurrent.atomic.AtomicLong r1 = r12.f538c     // Catch: java.lang.Throwable -> Lda
            long r2 = -r5
            r1.addAndGet(r2)     // Catch: java.lang.Throwable -> Lda
            java.util.concurrent.atomic.AtomicLong r1 = r12.d     // Catch: java.lang.Throwable -> Lda
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> Lda
            r1.set(r2)     // Catch: java.lang.Throwable -> Lda
        Ld8:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lda
            return
        Lda:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lda
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.file.d.l():void");
    }
}
