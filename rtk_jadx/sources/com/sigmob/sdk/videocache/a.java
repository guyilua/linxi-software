package com.sigmob.sdk.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements c {
    private volatile byte[] a;
    private volatile boolean b;

    public a() {
        this(new byte[0]);
    }

    public a(byte[] bArr) {
        this.a = (byte[]) o.a(bArr);
    }

    @Override // com.sigmob.sdk.videocache.c
    public int a(byte[] bArr, long j, int i) {
        if (j >= this.a.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.a).read(bArr, (int) j, i);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j);
    }

    @Override // com.sigmob.sdk.videocache.c
    public long a() {
        return this.a.length;
    }

    @Override // com.sigmob.sdk.videocache.c
    public void a(byte[] bArr, int i) {
        o.a(this.a);
        o.a(i >= 0 && i <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.a, this.a.length + i);
        System.arraycopy(bArr, 0, copyOf, this.a.length, i);
        this.a = copyOf;
    }

    @Override // com.sigmob.sdk.videocache.c
    public void b() {
    }

    @Override // com.sigmob.sdk.videocache.c
    public void c() {
        this.b = true;
    }

    @Override // com.sigmob.sdk.videocache.c
    public boolean d() {
        return this.b;
    }
}
