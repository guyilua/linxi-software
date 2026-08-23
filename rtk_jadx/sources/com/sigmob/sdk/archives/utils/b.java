package com.sigmob.sdk.archives.utils;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends FilterInputStream {
    private long a;

    public b(InputStream inputStream) {
        super(inputStream);
    }

    public long a() {
        return this.a;
    }

    protected final void a(long j) {
        if (j != -1) {
            this.a += j;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            a(1L);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (read >= 0) {
            a(read);
        }
        return read;
    }
}
