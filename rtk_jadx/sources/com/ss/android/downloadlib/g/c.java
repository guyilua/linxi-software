package com.ss.android.downloadlib.g;

import java.lang.ref.SoftReference;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c<P, R> implements Runnable {
    private P a;
    private R b;

    /* renamed from: c, reason: collision with root package name */
    private int f777c;
    private SoftReference<a<P, R>> d;
    private c<?, P> e;
    private c<R, ?> f;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    private c(int i, a<P, R> aVar, P p) {
        this.f777c = i;
        this.d = new SoftReference<>(aVar);
        this.a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        return new c<>(2, aVar, p);
    }

    private R b() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        if (this.f777c == 0 && !m.b()) {
            com.ss.android.downloadlib.h.a().b().post(this);
            return;
        }
        if (this.f777c == 1 && m.b()) {
            com.ss.android.downloadlib.e.a().a(this);
            return;
        }
        if (this.f777c == 2 && m.b()) {
            com.ss.android.downloadlib.e.a().b(this);
            return;
        }
        if (this.a == null && (cVar = this.e) != null) {
            this.a = cVar.b();
        }
        a<P, R> aVar = this.d.get();
        if (aVar == null) {
            return;
        }
        this.b = aVar.a(this.a);
        c<R, ?> cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i, a<R, NR> aVar) {
        c cVar = (c<R, ?>) new c(i, aVar, null);
        this.f = cVar;
        cVar.e = this;
        return cVar;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        return a(0, aVar);
    }

    public void a() {
        c<?, P> cVar = this.e;
        if (cVar != null) {
            cVar.a();
        } else {
            run();
        }
    }
}
