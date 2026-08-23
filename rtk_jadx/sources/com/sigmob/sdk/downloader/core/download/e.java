package com.sigmob.sdk.downloader.core.download;

import android.os.SystemClock;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends com.sigmob.sdk.downloader.core.b implements Comparable<e> {
    static final int b = 3;
    private static final ExecutorService j = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload Block", false));
    private static final String k = "DownloadCall";

    /* renamed from: c, reason: collision with root package name */
    public final com.sigmob.sdk.downloader.f f532c;
    public final boolean d;
    final ArrayList<f> e;
    volatile d f;
    volatile boolean g;
    volatile boolean h;
    volatile Thread i;
    private final j l;

    private e(com.sigmob.sdk.downloader.f fVar, boolean z, j jVar) {
        this(fVar, z, new ArrayList(), jVar);
    }

    e(com.sigmob.sdk.downloader.f fVar, boolean z, ArrayList<f> arrayList, j jVar) {
        super("download call: " + fVar.c());
        this.f532c = fVar;
        this.d = z;
        this.e = arrayList;
        this.l = jVar;
    }

    public static e a(com.sigmob.sdk.downloader.f fVar, boolean z, j jVar) {
        return new e(fVar, z, jVar);
    }

    private void a(d dVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.CANCELED) {
            throw new IllegalAccessError("can't recognize cancelled on here");
        }
        synchronized (this) {
            if (this.g) {
                return;
            }
            this.h = true;
            this.l.a(this.f532c.c(), aVar, exc);
            if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
                this.l.g(this.f532c.c());
                com.sigmob.sdk.downloader.g.j().f().a(dVar.a(), this.f532c);
            }
            com.sigmob.sdk.downloader.g.j().b().a().a(this.f532c, aVar, exc);
        }
    }

    private void h() {
        this.l.d(this.f532c.c());
        com.sigmob.sdk.downloader.g.j().b().a().a_(this.f532c);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        return eVar.f() - f();
    }

    a a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j2) {
        return new a(this.f532c, cVar, j2);
    }

    d a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new d(com.sigmob.sdk.downloader.g.j().f().a(this.f532c, cVar, this.l));
    }

    Future<?> a(f fVar) {
        return j.submit(fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0163 A[EDGE_INSN: B:36:0x0163->B:37:0x0163 BREAK  A[LOOP:0: B:2:0x0013->B:60:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[LOOP:0: B:2:0x0013->B:60:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0163 A[EDGE_INSN: B:64:0x0163->B:37:0x0163 BREAK  A[LOOP:0: B:2:0x0013->B:60:?], SYNTHETIC] */
    @Override // com.sigmob.sdk.downloader.core.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.download.e.a():void");
    }

    void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, b bVar, com.sigmob.sdk.downloader.core.cause.b bVar2) {
        com.sigmob.sdk.downloader.core.c.a(this.f532c, cVar, bVar.e(), bVar.d());
        com.sigmob.sdk.downloader.g.j().b().a().a(this.f532c, cVar, bVar2);
    }

    void a(d dVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        int g = cVar.g();
        ArrayList arrayList = new ArrayList(cVar.g());
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < g; i++) {
            com.sigmob.sdk.downloader.core.breakpoint.a b2 = cVar.b(i);
            if (!com.sigmob.sdk.downloader.core.c.a(b2.a(), b2.d())) {
                com.sigmob.sdk.downloader.core.c.a(b2);
                f a = f.a(i, this.f532c, cVar, dVar, this.l);
                arrayList.add(a);
                arrayList2.add(Integer.valueOf(a.e()));
            }
        }
        if (this.g) {
            return;
        }
        dVar.a().a(arrayList2);
        a(arrayList);
    }

    @Override // com.sigmob.sdk.downloader.core.b
    protected void a(InterruptedException interruptedException) {
    }

    void a(List<f> list) {
        ArrayList arrayList = new ArrayList(list.size());
        try {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            this.e.addAll(list);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Future future = (Future) it2.next();
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException | ExecutionException unused) {
                    }
                }
            }
        } finally {
        }
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar) {
        return this.f532c.equals(fVar);
    }

    b b(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new b(this.f532c, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.b
    protected void b() {
        com.sigmob.sdk.downloader.g.j().a().c(this);
        com.sigmob.sdk.downloader.core.c.b(k, "call is finished " + this.f532c.c());
    }

    void c(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        f.c.a(this.f532c, cVar);
    }

    public boolean c() {
        synchronized (this) {
            if (this.g) {
                return true;
            }
            if (this.h) {
                return false;
            }
            this.g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            com.sigmob.sdk.downloader.g.j().a().b(this);
            d dVar = this.f;
            if (dVar != null) {
                dVar.l();
            }
            Object[] array = this.e.toArray();
            if (array != null && array.length != 0) {
                for (Object obj : array) {
                    if (obj instanceof f) {
                        ((f) obj).b();
                    }
                }
            } else if (this.i != null) {
                com.sigmob.sdk.downloader.core.c.b(k, "interrupt thread with cancel operation because of chains are not running " + this.f532c.c());
                this.i.interrupt();
            }
            if (dVar != null) {
                dVar.a().a();
            }
            com.sigmob.sdk.downloader.core.c.b(k, "cancel task " + this.f532c.c() + " consume: " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms");
            return true;
        }
    }

    public boolean d() {
        return this.g;
    }

    public boolean e() {
        return this.h;
    }

    int f() {
        return this.f532c.G();
    }

    public File g() {
        return this.f532c.m();
    }
}
