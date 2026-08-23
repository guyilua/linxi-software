package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.core.listener.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e extends com.sigmob.sdk.downloader.core.listener.b implements Runnable {
    static final int e = 0;
    private static final Executor g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.sigmob.sdk.downloader.core.c.a("FileDownload DynamicSerial", false));
    private static final String i = "DownloadSerialQueue";
    volatile boolean a;
    volatile boolean b;

    /* renamed from: c, reason: collision with root package name */
    volatile boolean f546c;
    volatile f d;
    com.sigmob.sdk.downloader.core.listener.f f;
    private final ArrayList<f> h;

    public e() {
        this(null);
    }

    public e(c cVar) {
        this(cVar, new ArrayList());
    }

    e(c cVar, ArrayList<f> arrayList) {
        this.a = false;
        this.b = false;
        this.f546c = false;
        this.f = new f.a().a(this).a(cVar).a();
        this.h = arrayList;
    }

    public synchronized void a() {
        if (this.f546c) {
            com.sigmob.sdk.downloader.core.c.a(i, "require pause this queue(remain " + this.h.size() + "), butit has already been paused");
            return;
        }
        this.f546c = true;
        if (this.d != null) {
            this.d.E();
            this.h.add(0, this.d);
            this.d = null;
        }
    }

    public void a(c cVar) {
        this.f = new f.a().a(this).a(cVar).a();
    }

    @Override // com.sigmob.sdk.downloader.c
    public synchronized void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar != com.sigmob.sdk.downloader.core.cause.a.CANCELED && fVar == this.d) {
            this.d = null;
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a_(f fVar) {
        this.d = fVar;
    }

    public synchronized void b() {
        if (this.f546c) {
            this.f546c = false;
            if (!this.h.isEmpty() && !this.b) {
                this.b = true;
                f();
            }
            return;
        }
        com.sigmob.sdk.downloader.core.c.a(i, "require resume this queue(remain " + this.h.size() + "), but it is still running");
    }

    public synchronized void b(f fVar) {
        this.h.add(fVar);
        Collections.sort(this.h);
        if (!this.f546c && !this.b) {
            this.b = true;
            f();
        }
    }

    public int c() {
        if (this.d != null) {
            return this.d.c();
        }
        return 0;
    }

    public int d() {
        return this.h.size();
    }

    public synchronized f[] e() {
        f[] fVarArr;
        this.a = true;
        if (this.d != null) {
            this.d.E();
        }
        fVarArr = new f[this.h.size()];
        this.h.toArray(fVarArr);
        this.h.clear();
        return fVarArr;
    }

    void f() {
        g.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        f remove;
        while (!this.a) {
            synchronized (this) {
                if (!this.h.isEmpty() && !this.f546c) {
                    remove = this.h.remove(0);
                }
                this.d = null;
                this.b = false;
                return;
            }
            remove.c(this.f);
        }
    }
}
