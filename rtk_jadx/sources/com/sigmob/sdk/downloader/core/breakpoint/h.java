package com.sigmob.sdk.downloader.core.breakpoint;

import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h implements j {
    public static final int a = 1;
    private final SparseArray<c> b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, String> f504c;
    private final k d;
    private final SparseArray<com.sigmob.sdk.downloader.core.a> e;
    private final List<Integer> f;
    private final List<Integer> g;

    public h() {
        this(new SparseArray(), new ArrayList(), new HashMap());
    }

    public h(SparseArray<c> sparseArray, List<Integer> list, HashMap<String, String> hashMap) {
        this.e = new SparseArray<>();
        this.b = sparseArray;
        this.g = list;
        this.f504c = hashMap;
        this.d = new k();
        int size = sparseArray.size();
        this.f = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.f.add(Integer.valueOf(sparseArray.valueAt(i).a));
        }
        Collections.sort(this.f);
    }

    h(SparseArray<c> sparseArray, List<Integer> list, HashMap<String, String> hashMap, SparseArray<com.sigmob.sdk.downloader.core.a> sparseArray2, List<Integer> list2, k kVar) {
        this.e = sparseArray2;
        this.g = list;
        this.b = sparseArray;
        this.f504c = hashMap;
        this.f = list2;
        this.d = kVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(int i) {
        return this.b.get(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar) {
        int c2 = fVar.c();
        c cVar = new c(c2, fVar.i(), fVar.l(), fVar.d());
        synchronized (this) {
            this.b.put(c2, cVar);
            this.e.remove(c2);
        }
        return cVar;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public c a(com.sigmob.sdk.downloader.f fVar, c cVar) {
        SparseArray<c> clone;
        synchronized (this) {
            clone = this.b.clone();
        }
        int size = clone.size();
        for (int i = 0; i < size; i++) {
            c valueAt = clone.valueAt(i);
            if (valueAt != cVar && valueAt.a(fVar)) {
                return valueAt;
            }
        }
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public String a(String str) {
        return this.f504c.get(str);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(int i, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        if (aVar == com.sigmob.sdk.downloader.core.cause.a.COMPLETED) {
            b(i);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void a(c cVar, int i, long j) {
        c cVar2 = this.b.get(cVar.a);
        if (cVar != cVar2) {
            throw new IOException("Info not on store!");
        }
        cVar2.b(i).a(j);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a() {
        return true;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean a(c cVar) {
        String m = cVar.m();
        if (cVar.d() && m != null) {
            this.f504c.put(cVar.l(), m);
        }
        c cVar2 = this.b.get(cVar.a);
        if (cVar2 == null) {
            return false;
        }
        if (cVar2 == cVar) {
            return true;
        }
        synchronized (this) {
            this.b.put(cVar.a, cVar.p());
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
    
        r1 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    synchronized int b() {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            r2 = 0
        L4:
            java.util.List<java.lang.Integer> r3 = r5.f     // Catch: java.lang.Throwable -> L5f
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L5f
            r4 = 1
            if (r1 >= r3) goto L2e
            java.util.List<java.lang.Integer> r3 = r5.f     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L5f
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L5f
            if (r3 != 0) goto L1a
            int r0 = r2 + 1
            goto L2f
        L1a:
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L5f
            if (r2 != 0) goto L24
            if (r3 == r4) goto L2a
            r0 = 1
            goto L2e
        L24:
            int r2 = r2 + 1
            if (r3 == r2) goto L2a
            r0 = r2
            goto L2f
        L2a:
            int r1 = r1 + 1
            r2 = r3
            goto L4
        L2e:
            r1 = 0
        L2f:
            if (r0 != 0) goto L53
            java.util.List<java.lang.Integer> r0 = r5.f     // Catch: java.lang.Throwable -> L5f
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L3a
            goto L54
        L3a:
            java.util.List<java.lang.Integer> r0 = r5.f     // Catch: java.lang.Throwable -> L5f
            int r1 = r0.size()     // Catch: java.lang.Throwable -> L5f
            int r1 = r1 - r4
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L5f
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L5f
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L5f
            int r4 = r4 + r0
            java.util.List<java.lang.Integer> r0 = r5.f     // Catch: java.lang.Throwable -> L5f
            int r1 = r0.size()     // Catch: java.lang.Throwable -> L5f
            goto L54
        L53:
            r4 = r0
        L54:
            java.util.List<java.lang.Integer> r0 = r5.f     // Catch: java.lang.Throwable -> L5f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L5f
            r0.add(r1, r2)     // Catch: java.lang.Throwable -> L5f
            monitor-exit(r5)
            return r4
        L5f:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.downloader.core.breakpoint.h.b():int");
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public synchronized int b(com.sigmob.sdk.downloader.f fVar) {
        Integer a2 = this.d.a(fVar);
        if (a2 != null) {
            return a2.intValue();
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            c valueAt = this.b.valueAt(i);
            if (valueAt != null && valueAt.a(fVar)) {
                return valueAt.a;
            }
        }
        int size2 = this.e.size();
        for (int i2 = 0; i2 < size2; i2++) {
            com.sigmob.sdk.downloader.core.a valueAt2 = this.e.valueAt(i2);
            if (valueAt2 != null && valueAt2.a(fVar)) {
                return valueAt2.c();
            }
        }
        int b = b();
        this.e.put(b, fVar.d(b));
        this.d.a(fVar, b);
        return b;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public synchronized void b(int i) {
        this.b.remove(i);
        if (this.e.get(i) == null) {
            this.f.remove(Integer.valueOf(i));
        }
        this.d.a(i);
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.g
    public boolean c(int i) {
        return this.g.contains(Integer.valueOf(i));
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public void d(int i) {
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public c e(int i) {
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean f(int i) {
        if (this.g.contains(Integer.valueOf(i))) {
            return false;
        }
        synchronized (this.g) {
            if (this.g.contains(Integer.valueOf(i))) {
                return false;
            }
            this.g.add(Integer.valueOf(i));
            return true;
        }
    }

    @Override // com.sigmob.sdk.downloader.core.breakpoint.j
    public boolean g(int i) {
        boolean remove;
        synchronized (this.g) {
            remove = this.g.remove(Integer.valueOf(i));
        }
        return remove;
    }
}
