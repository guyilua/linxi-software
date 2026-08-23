package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.a;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class a implements com.sigmob.sdk.downloader.c, a.InterfaceC0045a, com.sigmob.sdk.downloader.core.listener.assist.d {

    /* renamed from: c, reason: collision with root package name */
    final com.sigmob.sdk.downloader.core.listener.assist.a f541c;

    public a() {
        this(new com.sigmob.sdk.downloader.core.listener.assist.a());
    }

    a(com.sigmob.sdk.downloader.core.listener.assist.a aVar) {
        this.f541c = aVar;
        aVar.a(this);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, int i2, Map<String, List<String>> map) {
        this.f541c.b(fVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, long j) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, int i, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        this.f541c.a(fVar, cVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
        this.f541c.a(fVar, cVar, bVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc) {
        this.f541c.a(fVar, aVar, exc);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f fVar, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void a(boolean z) {
        this.f541c.a(z);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public boolean a() {
        return this.f541c.a();
    }

    @Override // com.sigmob.sdk.downloader.c
    public final void a_(com.sigmob.sdk.downloader.f fVar) {
        this.f541c.a(fVar);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i, long j) {
        this.f541c.a(fVar, j);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f fVar, int i, Map<String, List<String>> map) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.d
    public void b(boolean z) {
        this.f541c.b(z);
    }

    @Override // com.sigmob.sdk.downloader.c
    public void c(com.sigmob.sdk.downloader.f fVar, int i, long j) {
    }
}
