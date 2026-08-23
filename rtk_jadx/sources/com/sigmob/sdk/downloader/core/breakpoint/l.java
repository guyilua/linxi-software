package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.sqlite.SQLiteDatabase;
import com.sigmob.sdk.downloader.core.breakpoint.m;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l implements j, m.a {
    private static final String a = "RemitStoreOnSQLite";
    private final n b;

    /* renamed from: c, reason: collision with root package name */
    private final i f506c;
    private final e d;
    private final j e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.b = new n(this);
        this.f506c = iVar;
        this.e = iVar.b;
        this.d = iVar.a;
    }

    l(n nVar, i iVar, j jVar, e eVar) {
        this.b = nVar;
        this.f506c = iVar;
        this.e = jVar;
        this.d = eVar;
    }

    public static void j(int i) {
        g c2 = com.sigmob.sdk.downloader.g.j().c();
        if (c2 instanceof l) {
            ((l) c2).b.a = Math.max(0, i);
        } else {
            throw new IllegalStateException("The current store is " + c2 + " not RemitStoreOnSQLite!");
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int i) {
        return this.f506c.a(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) {
        return this.b.a(fVar.c()) ? this.e.a(fVar) : this.f506c.a(fVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        return this.f506c.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.f506c.a(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.e.a(i, aVar, exc);
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            this.b.d(i);
        } else {
            this.b.c(i);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i, long j) {
        if (this.b.a(cVar.a())) {
            this.e.a(cVar, i, j);
        } else {
            this.f506c.a(cVar, i, j);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void a(List<Integer> list) {
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                h(it.next().intValue());
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return false;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) {
        return this.b.a(cVar.a()) ? this.e.a(cVar) : this.f506c.a(cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public int b(com.sigmob.sdk.downloader.f fVar) {
        return this.f506c.b(fVar);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public void b(int i) {
        this.e.b(i);
        this.b.d(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int i) {
        return this.f506c.c(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int i) {
        this.f506c.d(i);
        this.b.b(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int i) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int i) {
        return this.f506c.f(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int i) {
        return this.f506c.g(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void h(int i) {
        this.d.c(i);
        c a2 = this.e.a(i);
        if (a2 == null || a2.m() == null || a2.i() <= 0) {
            return;
        }
        this.d.a(a2);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.m.a
    public void i(int i) {
        this.d.c(i);
    }
}
