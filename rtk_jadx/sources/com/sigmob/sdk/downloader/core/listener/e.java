package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.b;
import com.sigmob.sdk.downloader.core.listener.assist.c;
import com.sigmob.sdk.downloader.core.listener.assist.e;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class e extends d implements c.a {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements e.b<c.b> {
        private a() {
        }

        @Override // com.sigmob.sdk.downloader.core.listener.assist.e.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.b b(int i) {
            return new c.b(i);
        }
    }

    public e() {
        this(new com.sigmob.sdk.downloader.core.listener.assist.c());
    }

    private e(com.sigmob.sdk.downloader.core.listener.assist.c cVar) {
        super(new com.sigmob.sdk.downloader.core.listener.assist.b(new a()));
        cVar.a(this);
        a(cVar);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0046b
    public final void a(com.sigmob.sdk.downloader.f fVar, int i, com.sigmob.sdk.downloader.core.breakpoint.a aVar) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0046b
    public final void a(com.sigmob.sdk.downloader.f fVar, long j) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0046b
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, boolean z, b.c cVar2) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0046b
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, b.c cVar) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.b.InterfaceC0046b
    public final void d(com.sigmob.sdk.downloader.f fVar, int i, long j) {
    }
}
