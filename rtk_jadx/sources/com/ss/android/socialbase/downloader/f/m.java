package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class m implements Runnable {
    private Thread A;
    private volatile boolean B;
    private int C;
    private int D;
    private int E;
    private long F;
    private int G;
    private boolean H;
    private BaseException I;
    private boolean J;
    private boolean K;
    private com.ss.android.socialbase.downloader.i.e L;
    volatile i a;
    q b;

    /* renamed from: c, reason: collision with root package name */
    final int f864c;
    volatile long d;
    volatile long e;
    volatile long f;
    volatile long g;
    String h;
    String i;
    String j;
    private final f k;
    private final c l;
    private final DownloadInfo m;
    private final com.ss.android.socialbase.downloader.g.a n;
    private com.ss.android.socialbase.downloader.network.i o;
    private com.ss.android.socialbase.downloader.model.d p;
    private long r;
    private volatile long s;
    private volatile long t;
    private volatile long v;
    private Future w;
    private volatile boolean x;
    private volatile boolean y;
    private volatile boolean z;
    private final List<i> q = new ArrayList();
    private volatile long u = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(DownloadInfo downloadInfo, k kVar, c cVar, q qVar, int i) {
        this.m = downloadInfo;
        this.k = kVar;
        this.l = cVar;
        this.n = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.b = qVar;
        this.f864c = i;
    }

    private boolean a(i iVar) {
        k();
        while (true) {
            try {
                b(iVar);
                d(iVar);
                i();
                return true;
            } catch (j e) {
                this.I = e;
                throw e;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download: e = " + th + ", threadIndex = " + this.f864c + ", reconnect = " + this.y + ", closed = " + this.x);
                    if (this.x) {
                        return false;
                    }
                    if (this.y) {
                        this.y = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        if (this.z) {
                            this.z = false;
                            throw new j(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e2 = null;
                        if (th instanceof BaseException) {
                            e2 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a((Throwable) th, "download");
                            } catch (BaseException e3) {
                                e2 = e3;
                            }
                        }
                        if (e2 == null || !a(iVar, e2)) {
                            return false;
                        }
                    }
                } finally {
                    i();
                }
            }
        }
        return false;
    }

    private void b(i iVar) {
        c(iVar);
        this.k.a(this, iVar, this.b, this.p);
        this.b.c();
    }

    private void c(i iVar) {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.i a;
        try {
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.e = 0L;
                    this.d = currentTimeMillis;
                    this.r = iVar.e();
                    this.t = iVar.f();
                    if (this.t > 0 && this.r > this.t) {
                        throw new j(6, "createConn, ".concat(String.valueOf(iVar)));
                    }
                    this.L = new com.ss.android.socialbase.downloader.i.e();
                    List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.f.a(this.m.getExtraHeaders(), this.m.geteTag(), this.r, this.t);
                    a2.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.g())));
                    a2.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.f864c)));
                    com.ss.android.socialbase.downloader.i.f.a(a2, this.m);
                    com.ss.android.socialbase.downloader.i.f.b(a2, this.m);
                    str = this.b.a;
                    if (this.H && !TextUtils.isEmpty(str) && str.startsWith(BaseConstants.SCHEME_HTTPS)) {
                        str = str.replaceFirst(BaseConstants.SCHEME_HTTPS, "http");
                    }
                    str2 = this.b.b;
                    com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.f864c);
                    this.h = str;
                    this.i = str2;
                    a = com.ss.android.socialbase.downloader.downloader.c.a(this.m.isNeedDefaultHttpServiceBackUp(), this.m.getMaxBytes(), str, str2, a2, 0, currentTimeMillis - this.F > 3000 && this.n.b("monitor_download_connect") > 0, this.m);
                } catch (BaseException e) {
                    throw e;
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.f.a(th, "createConn");
            }
            if (a != null) {
                this.o = a;
                this.p = new com.ss.android.socialbase.downloader.model.d(str, a);
                if (!this.x) {
                    if (a instanceof com.ss.android.socialbase.downloader.network.a) {
                        this.j = ((com.ss.android.socialbase.downloader.network.a) a).e();
                    }
                    Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.j + ", threadIndex = " + this.f864c);
                    this.e = System.currentTimeMillis();
                    return;
                }
                throw new p("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        } catch (Throwable th2) {
            this.e = System.currentTimeMillis();
            throw th2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:123:0x0155
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Removed duplicated region for block: B:221:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0357  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(com.ss.android.socialbase.downloader.f.i r32) {
        /*
            Method dump skipped, instructions count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.m.d(com.ss.android.socialbase.downloader.f.i):void");
    }

    private void i() {
        this.F = this.d;
        this.d = -1L;
        this.e = -1L;
        this.f = -1L;
        this.g = -1L;
        j();
    }

    private void j() {
        com.ss.android.socialbase.downloader.network.i iVar = this.o;
        if (iVar != null) {
            try {
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "closeConnection: thread = " + this.f864c);
                iVar.d();
                iVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    private void k() {
        this.H = false;
        l();
    }

    private void l() {
        this.D = this.b.d ? this.m.getRetryCount() : this.m.getBackUpUrlRetryCount();
        this.E = 0;
    }

    private long m() {
        long j = this.s;
        this.s = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    public void e() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "close: threadIndex = " + this.f864c);
        synchronized (this) {
            this.x = true;
            this.B = true;
        }
        j();
        Future future = this.w;
        if (future != null) {
            this.w = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void f() {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        return this.r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
    
        r5.a = null;
        r2 = r5.k;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.m.run():void");
    }

    public long b() {
        long c2;
        synchronized (this.k) {
            c2 = this.v + c();
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.J = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(long j) {
        long j2 = this.u;
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (j2 < 0 || eVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.f864c);
        eVar.a(j2, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(q qVar) {
        int i = this.G;
        if (i >= 30) {
            return false;
        }
        this.G = i + 1;
        q qVar2 = this.b;
        if (qVar2 != null) {
            qVar2.b(this);
        }
        qVar.a(this);
        this.b = qVar;
        l();
        return true;
    }

    private boolean a(i iVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.E + ", retryCount = " + this.D);
        this.I = baseException;
        this.b.b();
        this.k.a(this, this.b, iVar, baseException, this.E, this.D);
        int i = this.E;
        if (i < this.D) {
            this.E = i + 1;
            return true;
        }
        if (a(baseException)) {
            return true;
        }
        this.k.a(this, this.b, iVar, baseException);
        return false;
    }

    public long c() {
        synchronized (this.k) {
            long j = this.u;
            long j2 = this.r;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    private boolean a(BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.i.f.c(baseException)) {
            return false;
        }
        String str = this.b.a;
        if (TextUtils.isEmpty(str) || !str.startsWith(BaseConstants.SCHEME_HTTPS) || !this.m.isNeedHttpsToHttpRetry() || this.H) {
            return false;
        }
        this.H = true;
        l();
        return true;
    }

    public void c(boolean z) {
        this.K = z;
    }

    private a a(c cVar, InputStream inputStream) {
        int i;
        a b = cVar.b();
        try {
            i = inputStream.read(b.a);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i != -1) {
                b.f858c = i;
                if (i == -1) {
                    cVar.a(b);
                }
                return b;
            }
            throw new BaseException(1073, "probe");
        } catch (Throwable th2) {
            th = th2;
            if (i == -1) {
                cVar.a(b);
            }
            throw th;
        }
    }

    public boolean a(long j) {
        long j2 = this.t;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.s = j;
        this.B = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        q qVar = this.b;
        try {
            synchronized (this.k) {
                long c2 = c();
                if (c2 > 0) {
                    this.v += c2;
                    qVar.a(c2);
                }
                this.u = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "reconnect: threadIndex = " + this.f864c);
        synchronized (this) {
            this.z = z;
            this.y = true;
            this.B = true;
        }
        j();
        Thread thread = this.A;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.f864c);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future future) {
        this.w = future;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long a(long j, long j2) {
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (eVar == null) {
            return -1L;
        }
        return eVar.b(j, j2);
    }

    public long d() {
        return this.u;
    }
}
