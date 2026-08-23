package com.ss.android.a;

import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a implements b {
    private final RandomAccessFile a;

    public a(File file) {
        this.a = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.a.b
    public long a() {
        return this.a.length();
    }

    @Override // com.ss.android.a.b
    public void b() {
        this.a.close();
    }

    @Override // com.ss.android.a.b
    public int a(byte[] bArr, int i, int i2) {
        return this.a.read(bArr, i, i2);
    }

    @Override // com.ss.android.a.b
    public void a(long j, long j2) {
        this.a.seek(j);
    }
}
