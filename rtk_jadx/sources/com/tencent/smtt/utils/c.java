package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: DataReader.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c implements Closeable {
    private final RandomAccessFile a;
    private final File b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f974c;
    private boolean d;

    public c(String str) {
        this(new File(str));
    }

    public void a(boolean z) {
        this.d = z;
    }

    public final int b() {
        int readInt = this.a.readInt();
        if (!this.d) {
            return readInt;
        }
        return ((readInt & (-16777216)) >>> 24) | ((readInt & 255) << 24) | ((65280 & readInt) << 8) | ((16711680 & readInt) >>> 8);
    }

    public final long c() {
        if (this.d) {
            this.a.readFully(this.f974c, 0, 8);
            byte[] bArr = this.f974c;
            return (bArr[0] & 255) | (bArr[7] << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8);
        }
        return this.a.readLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public c(File file) {
        this.f974c = new byte[8];
        this.b = file;
        this.a = new RandomAccessFile(file, "r");
    }

    public void a(long j) {
        this.a.seek(j);
    }

    public final int a(byte[] bArr) {
        return this.a.read(bArr);
    }

    public final int a(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        int read = this.a.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return read;
    }

    public final short a() {
        short readShort = this.a.readShort();
        if (!this.d) {
            return readShort;
        }
        return (short) (((readShort & 65280) >>> 8) | ((readShort & 255) << 8));
    }
}
