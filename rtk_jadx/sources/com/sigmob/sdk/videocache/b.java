package com.sigmob.sdk.videocache;

import java.io.ByteArrayInputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements u {
    private final byte[] a;
    private ByteArrayInputStream b;

    public b(byte[] bArr) {
        this.a = bArr;
    }

    @Override // com.sigmob.sdk.videocache.u
    public int a(byte[] bArr) {
        return this.b.read(bArr, 0, bArr.length);
    }

    @Override // com.sigmob.sdk.videocache.u
    public long a() {
        return this.a.length;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.a);
        this.b = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }

    @Override // com.sigmob.sdk.videocache.u
    public void b() {
    }

    @Override // com.sigmob.sdk.videocache.u
    public String c() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v d() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return null;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String g() {
        return null;
    }
}
