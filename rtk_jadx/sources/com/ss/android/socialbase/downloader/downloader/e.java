package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private static String b = "ResponseHandler";
    private long A;
    private long B;
    private long C;
    private long D;

    /* renamed from: c, reason: collision with root package name */
    private final DownloadInfo f854c;
    private final String d;
    private final com.ss.android.socialbase.downloader.model.b e;
    private final com.ss.android.socialbase.downloader.network.i f;
    private j g;
    private com.ss.android.socialbase.downloader.impls.k h;
    private t i;
    private com.ss.android.socialbase.downloader.model.e j;
    private BaseException k;
    private volatile boolean l;
    private volatile boolean m;
    private final com.ss.android.socialbase.downloader.h.f n;
    private long o;
    private long p;
    private volatile long q;
    private volatile long r;
    private final boolean s;
    private final com.ss.android.socialbase.downloader.g.a t;
    private final com.ss.android.socialbase.downloader.a.a u;
    private final boolean v;
    private final long w;
    private final long x;
    private final boolean y;
    private boolean z;
    boolean a = false;
    private volatile long E = 0;
    private volatile long F = 0;

    public e(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.i iVar, com.ss.android.socialbase.downloader.model.b bVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.f854c = downloadInfo;
        this.d = str;
        j y = c.y();
        this.g = y;
        if (y instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) y;
            this.h = dVar.a();
            this.i = dVar.f();
        }
        this.f = iVar;
        this.e = bVar;
        this.n = fVar;
        long n = bVar.n();
        this.o = n;
        this.p = n;
        if (bVar.d()) {
            this.r = bVar.q();
        } else {
            this.r = bVar.c(false);
        }
        this.q = bVar.p();
        this.u = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.t = a;
        boolean z = a.a("sync_strategy", 0) == 1;
        this.v = z;
        if (z) {
            long a2 = a.a("sync_interval_ms_fg", 5000);
            long a3 = a.a("sync_interval_ms_bg", 1000);
            this.w = Math.max(a2, 500L);
            this.x = Math.max(a3, 500L);
        } else {
            this.w = 0L;
            this.x = 0L;
        }
        this.y = a.b("monitor_rw") == 1;
        this.s = com.ss.android.socialbase.downloader.i.a.a(65536);
    }

    private boolean b(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    private boolean f() {
        return this.l || this.m;
    }

    private void g() {
        ExecutorService l;
        if (this.f == null || (l = c.l()) == null) {
            return;
        }
        l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f.d();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void h() {
        boolean z;
        long nanoTime = this.y ? System.nanoTime() : 0L;
        try {
            this.j.a();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.f854c.updateRealDownloadTime(true);
            boolean z2 = this.f854c.getChunkCount() > 1;
            m a = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b());
            if (z2) {
                a(this.i);
                if (a != null) {
                    a.c(this.f854c);
                } else {
                    this.i.a(this.f854c.getId(), this.f854c.getCurBytes());
                }
            } else if (a != null) {
                a.c(this.f854c);
            } else {
                this.i.a(this.e.k(), this.o);
            }
            this.E = this.o;
        }
        if (this.y) {
            this.C += System.nanoTime() - nanoTime;
        }
    }

    public void b() {
        if (this.l) {
            return;
        }
        this.l = true;
        g();
    }

    public void c() {
        if (this.m) {
            return;
        }
        synchronized (this.n) {
            this.m = true;
        }
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0480 A[Catch: all -> 0x04e0, TRY_LEAVE, TryCatch #1 {all -> 0x04e0, blocks: (B:190:0x02ec, B:221:0x0363, B:223:0x0369, B:225:0x036c, B:257:0x045f, B:258:0x0461, B:147:0x0467, B:149:0x0480, B:183:0x04d4, B:185:0x04da, B:186:0x04dd, B:187:0x04df), top: B:8:0x0028, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04da A[Catch: all -> 0x04e0, TryCatch #1 {all -> 0x04e0, blocks: (B:190:0x02ec, B:221:0x0363, B:223:0x0369, B:225:0x036c, B:257:0x045f, B:258:0x0461, B:147:0x0467, B:149:0x0480, B:183:0x04d4, B:185:0x04da, B:186:0x04dd, B:187:0x04df), top: B:8:0x0028, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0363 A[Catch: all -> 0x04e0, TRY_ENTER, TryCatch #1 {all -> 0x04e0, blocks: (B:190:0x02ec, B:221:0x0363, B:223:0x0369, B:225:0x036c, B:257:0x045f, B:258:0x0461, B:147:0x0467, B:149:0x0480, B:183:0x04d4, B:185:0x04da, B:186:0x04dd, B:187:0x04df), top: B:8:0x0028, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03ee  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v19, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 1390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.e.d():void");
    }

    public long e() {
        return this.E;
    }

    public long a() {
        return this.o;
    }

    public void a(long j, long j2, long j3) {
        this.o = j;
        this.p = j;
        this.q = j2;
        this.r = j3;
    }

    public void a(long j, long j2) {
        this.q = j;
        this.r = j2;
    }

    private com.ss.android.socialbase.downloader.e.b a(InputStream inputStream) {
        int I = c.I();
        if (this.t.a("rw_concurrent", 0) == 1 && this.f854c.getChunkCount() == 1 && this.f854c.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(inputStream, I, this.t.a("rw_concurrent_max_buffer_count", 4));
                this.z = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.e.c cVar = new com.ss.android.socialbase.downloader.e.c(inputStream, I);
        this.z = false;
        return cVar;
    }

    private void a(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.F;
        if (this.v) {
            if (j <= (this.u.b() ? this.w : this.x)) {
                return;
            }
        } else {
            long j2 = this.o - this.E;
            if (!z && !b(j2, j)) {
                return;
            }
        }
        h();
        this.F = uptimeMillis;
    }

    private void a(j jVar) {
        com.ss.android.socialbase.downloader.model.b bVar;
        com.ss.android.socialbase.downloader.model.b bVar2;
        if (jVar == null) {
            return;
        }
        m mVar = null;
        boolean z = jVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z && (mVar = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b())) == null) {
            return;
        }
        m mVar2 = mVar;
        if (this.e.d()) {
            bVar = this.e.e();
        } else {
            bVar = this.e;
        }
        com.ss.android.socialbase.downloader.model.b bVar3 = bVar;
        if (bVar3 != null) {
            bVar3.b(this.o);
            if (z && mVar2 != null) {
                mVar2.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
                jVar.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
            }
            if (bVar2.h()) {
                boolean z2 = false;
                if (bVar2.i()) {
                    long j = bVar2.j();
                    if (j > this.o) {
                        if (z && mVar2 != null) {
                            mVar2.a(bVar2.k(), bVar2.b(), j);
                        } else {
                            jVar.a(bVar2.k(), bVar2.b(), j);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && mVar2 != null) {
                    mVar2.a(bVar2.k(), bVar2.b(), this.o);
                    return;
                } else {
                    jVar.a(bVar2.k(), bVar2.b(), this.o);
                    return;
                }
            }
            return;
        }
        if (this.e.d()) {
            if (z && mVar2 != null) {
                mVar2.a(this.e.k(), this.e.s(), this.o);
            } else {
                jVar.a(this.e.k(), this.e.s(), this.o);
            }
        }
    }
}
