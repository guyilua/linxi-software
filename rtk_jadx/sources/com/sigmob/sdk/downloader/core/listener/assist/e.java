package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.e.a;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e<T extends a> implements d {
    volatile T a;
    final SparseArray<T> b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private Boolean f545c;
    private final b<T> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar);

        int b();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b<T extends a> {
        T b(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b<T> bVar) {
        this.d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T b2 = this.d.b(fVar.c());
        synchronized (this) {
            if (this.a == null) {
                this.a = b2;
            } else {
                this.b.put(fVar.c(), b2);
            }
            if (cVar != null) {
                b2.a(cVar);
            }
        }
        return b2;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.f545c = Boolean.valueOf(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        Boolean bool = this.f545c;
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T b(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T t;
        int c2 = fVar.c();
        synchronized (this) {
            t = (this.a == null || this.a.b() != c2) ? null : this.a;
        }
        if (t == null) {
            t = this.b.get(c2);
        }
        return (t == null && a()) ? a(fVar, cVar) : t;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        if (this.f545c == null) {
            this.f545c = Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T c(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        T t;
        int c2 = fVar.c();
        synchronized (this) {
            if (this.a == null || this.a.b() != c2) {
                t = this.b.get(c2);
                this.b.remove(c2);
            } else {
                t = this.a;
                this.a = null;
            }
        }
        if (t == null) {
            t = this.d.b(c2);
            if (cVar != null) {
                t.a(cVar);
            }
        }
        return t;
    }
}
