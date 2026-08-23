package com.sigmob.sdk.downloader.core.listener.assist;

import com.sigmob.sdk.downloader.core.listener.assist.e;
import com.sigmob.sdk.downloader.f;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements d, e.b<b> {
    private final e<b> a;
    private InterfaceC0045a b;

    /* renamed from: com.sigmob.sdk.downloader.core.listener.assist.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface InterfaceC0045a {
        void a(f fVar, int i, long j, long j2);

        void a(f fVar, long j, long j2);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, b bVar);

        void a(f fVar, com.sigmob.sdk.downloader.core.cause.b bVar);

        void a(f fVar, b bVar);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements e.a {
        final int a;
        Boolean b;

        /* renamed from: c, reason: collision with root package name */
        Boolean f542c;
        volatile Boolean d;
        int e;
        long f;
        final AtomicLong g = new AtomicLong();

        b(int i) {
            this.a = i;
        }

        public long a() {
            return this.f;
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.e = cVar.g();
            this.f = cVar.j();
            this.g.set(cVar.i());
            if (this.b == null) {
                this.b = Boolean.FALSE;
            }
            if (this.f542c == null) {
                this.f542c = Boolean.valueOf(this.g.get() > 0);
            }
            if (this.d == null) {
                this.d = Boolean.TRUE;
            }
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.a
        public int b() {
            return this.a;
        }
    }

    public a() {
        this.a = new e<>(this);
    }

    a(e<b> eVar) {
        this.a = eVar;
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b b(int i) {
        return new b(i);
    }

    public void a(InterfaceC0045a interfaceC0045a) {
        this.b = interfaceC0045a;
    }

    public void a(f fVar) {
        b a = this.a.a(fVar, null);
        InterfaceC0045a interfaceC0045a = this.b;
        if (interfaceC0045a != null) {
            interfaceC0045a.a(fVar, a);
        }
    }

    public void a(f fVar, long j) {
        b b2 = this.a.b(fVar, fVar.y());
        if (b2 == null) {
            return;
        }
        b2.g.addAndGet(j);
        InterfaceC0045a interfaceC0045a = this.b;
        if (interfaceC0045a != null) {
            interfaceC0045a.a(fVar, b2.g.get(), b2.f);
        }
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        b b2 = this.a.b(fVar, cVar);
        if (b2 == null) {
            return;
        }
        b2.a(cVar);
        Boolean bool = Boolean.TRUE;
        b2.b = bool;
        b2.f542c = bool;
        b2.d = bool;
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        InterfaceC0045a interfaceC0045a;
        b b2 = this.a.b(fVar, cVar);
        if (b2 == null) {
            return;
        }
        b2.a(cVar);
        if (b2.b.booleanValue() && (interfaceC0045a = this.b) != null) {
            interfaceC0045a.a(fVar, bVar);
        }
        Boolean bool = Boolean.TRUE;
        b2.b = bool;
        b2.f542c = Boolean.FALSE;
        b2.d = bool;
    }

    public void a(f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        b c2 = this.a.c(fVar, fVar.y());
        InterfaceC0045a interfaceC0045a = this.b;
        if (interfaceC0045a != null) {
            interfaceC0045a.a(fVar, aVar, exc, c2);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.a.a(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.a.a();
    }

    public void b(f fVar) {
        b b2 = this.a.b(fVar, fVar.y());
        if (b2 == null) {
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (bool.equals(b2.f542c) && bool.equals(b2.d)) {
            b2.d = Boolean.FALSE;
        }
        InterfaceC0045a interfaceC0045a = this.b;
        if (interfaceC0045a != null) {
            interfaceC0045a.a(fVar, b2.e, b2.g.get(), b2.f);
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        this.a.b(z);
    }
}
