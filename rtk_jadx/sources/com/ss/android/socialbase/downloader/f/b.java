package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class b implements c, d, e {
    private final int a;
    private final int b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f859c = new Object();
    private final Object d = new Object();
    private a e;
    private a f;
    private a g;
    private a h;
    private a i;
    private volatile boolean j;
    private int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2) {
        i = i < 64 ? 64 : i;
        i2 = i2 < 8192 ? 8192 : i2;
        this.a = i;
        this.b = i2;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() {
        a aVar;
        a aVar2 = this.i;
        if (aVar2 != null) {
            this.i = aVar2.d;
            aVar2.d = null;
            return aVar2;
        }
        synchronized (this.d) {
            aVar = this.g;
            while (aVar == null) {
                if (!this.j) {
                    this.d.wait();
                    aVar = this.g;
                } else {
                    throw new p("read");
                }
            }
            this.i = aVar.d;
            this.h = null;
            this.g = null;
            aVar.d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() {
        synchronized (this.f859c) {
            if (!this.j) {
                a aVar = this.e;
                if (aVar == null) {
                    int i = this.k;
                    if (i < this.a) {
                        this.k = i + 1;
                        return new a(this.b);
                    }
                    do {
                        this.f859c.wait();
                        if (!this.j) {
                            aVar = this.e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.e = aVar.d;
                if (aVar == this.f) {
                    this.f = null;
                }
                aVar.d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.j = true;
        synchronized (this.f859c) {
            this.f859c.notifyAll();
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f859c) {
            a aVar2 = this.f;
            if (aVar2 == null) {
                this.f = aVar;
                this.e = aVar;
            } else {
                aVar2.d = aVar;
                this.f = aVar;
            }
            this.f859c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.d) {
            a aVar2 = this.h;
            if (aVar2 == null) {
                this.h = aVar;
                this.g = aVar;
                this.d.notify();
            } else {
                aVar2.d = aVar;
                this.h = aVar;
            }
        }
    }
}
