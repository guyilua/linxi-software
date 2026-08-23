package com.sigmob.sdk.downloader.core.listener.assist;

import android.util.SparseArray;
import com.sigmob.sdk.downloader.core.listener.assist.b.c;
import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b<T extends c> implements d {
    InterfaceC0046b a;
    private a b;

    /* renamed from: c, reason: collision with root package name */
    private final e<T> f543c;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        boolean a(f fVar, int i, long j, c cVar);

        boolean a(f fVar, int i, c cVar);

        boolean a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z, c cVar2);

        boolean a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, c cVar);
    }

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0046b {
        void a(f fVar, int i, com.sigmob.sdk.downloader.core.breakpoint.a aVar);

        void a(f fVar, long j);

        void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z, c cVar2);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, c cVar);

        void d(f fVar, int i, long j);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c implements e.a {
        com.sigmob.sdk.downloader.core.breakpoint.c a;
        long b;

        /* renamed from: c, reason: collision with root package name */
        SparseArray<Long> f544c;
        private final int d;

        public c(int i) {
            this.d = i;
        }

        public long a(int i) {
            return this.f544c.get(i).longValue();
        }

        SparseArray<Long> a() {
            return this.f544c;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.a = cVar;
            this.b = cVar.i();
            SparseArray<Long> sparseArray = new SparseArray<>();
            int g = cVar.g();
            for (int i = 0; i < g; i++) {
                sparseArray.put(i, Long.valueOf(cVar.b(i).a()));
            }
            this.f544c = sparseArray;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int b() {
            return this.d;
        }

        public long c() {
            return this.b;
        }

        public SparseArray<Long> d() {
            return this.f544c.clone();
        }

        public com.sigmob.sdk.downloader.core.breakpoint.c e() {
            return this.a;
        }
    }

    public b(e.b<T> bVar) {
        this.f543c = new e<>(bVar);
    }

    b(e<T> eVar) {
        this.f543c = eVar;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(InterfaceC0046b interfaceC0046b) {
        this.a = interfaceC0046b;
    }

    public void a(f fVar, int i) {
        InterfaceC0046b interfaceC0046b;
        T b = this.f543c.b(fVar, fVar.y());
        if (b == null) {
            return;
        }
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, i, b)) && (interfaceC0046b = this.a) != null) {
            interfaceC0046b.a(fVar, i, b.a.b(i));
        }
    }

    public void a(f fVar, int i, long j) {
        InterfaceC0046b interfaceC0046b;
        T b = this.f543c.b(fVar, fVar.y());
        if (b == null) {
            return;
        }
        long longValue = b.f544c.get(i).longValue() + j;
        b.f544c.put(i, Long.valueOf(longValue));
        b.b += j;
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, i, j, b)) && (interfaceC0046b = this.a) != null) {
            interfaceC0046b.d(fVar, i, longValue);
            this.a.a(fVar, b.b);
        }
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z) {
        InterfaceC0046b interfaceC0046b;
        T a2 = this.f543c.a(fVar, cVar);
        a aVar = this.b;
        if ((aVar == null || !aVar.a(fVar, cVar, z, a2)) && (interfaceC0046b = this.a) != null) {
            interfaceC0046b.a(fVar, cVar, z, a2);
        }
    }

    public synchronized void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        T c2 = this.f543c.c(fVar, fVar.y());
        a aVar2 = this.b;
        if (aVar2 == null || !aVar2.a(fVar, aVar, exc, c2)) {
            InterfaceC0046b interfaceC0046b = this.a;
            if (interfaceC0046b != null) {
                interfaceC0046b.a(fVar, aVar, exc, c2);
            }
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.f543c.a(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f543c.a();
    }

    public a b() {
        return this.b;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        this.f543c.b(z);
    }
}
