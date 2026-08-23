package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.Context;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i implements j {

    /* renamed from: c, reason: collision with root package name */
    private static final String f505c = "BreakpointStoreOnSQLite";
    protected final e a;
    protected final h b;

    public i(Context context) {
        e eVar = new e(context.getApplicationContext());
        this.a = eVar;
        this.b = new h(eVar.b(), eVar.a(), eVar.c());
    }

    i(e eVar, h hVar) {
        this.a = eVar;
        this.b = hVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int i) {
        return this.b.a(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) {
        c a = this.b.a(fVar);
        this.a.a(a);
        return a;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        return this.b.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.b.a(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.b.a(i, aVar, exc);
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.a.c(i);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i, long j) {
        this.b.a(cVar, i, j);
        this.a.a(cVar, i, cVar.b(i).a());
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) {
        boolean a = this.b.a(cVar);
        this.a.b(cVar);
        String m = cVar.m();
        com.sigmob.sdk.downloader.core.c.b(f505c, "update " + cVar);
        if (cVar.d() && m != null) {
            this.a.a(cVar.l(), m);
        }
        return a;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f fVar) {
        return this.b.b(fVar);
    }

    void b() {
        this.a.close();
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void b(int i) {
        this.b.b(i);
        this.a.c(i);
    }

    public j c() {
        return new l(this);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int i) {
        return this.b.c(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int i) {
        this.b.d(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int i) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int i) {
        if (!this.b.f(i)) {
            return false;
        }
        this.a.a(i);
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int i) {
        if (!this.b.g(i)) {
            return false;
        }
        this.a.b(i);
        return true;
    }
}
