package com.sigmob.sdk.archives;

import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class c extends InputStream {
    private static final int b = 255;
    private byte[] a = new byte[1];

    /* renamed from: c, reason: collision with root package name */
    private long f341c = 0;

    private void b(long j) {
        if (j != -1) {
            this.f341c += j;
        }
    }

    public abstract a a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        b(i);
    }

    protected void a(long j) {
        this.f341c -= j;
    }

    public boolean a(a aVar) {
        return true;
    }

    @Deprecated
    public int b() {
        return (int) this.f341c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long c() {
        return this.f341c;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.a, 0, 1) == -1) {
            return -1;
        }
        return this.a[0] & 255;
    }
}
