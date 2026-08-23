package com.sigmob.sdk.videocache.file;

import com.sigmob.sdk.videocache.q;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements com.sigmob.sdk.videocache.c {
    private static final String b = ".download";
    public File a;

    /* renamed from: c, reason: collision with root package name */
    private final a f662c;
    private RandomAccessFile d;

    public b(File file) {
        this(file, new i());
    }

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f662c = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + b);
            }
            this.a = file2;
            this.d = new RandomAccessFile(this.a, exists ? "r" : "rw");
        } catch (IOException e) {
            throw new q("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(b);
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.d.seek(j);
        } catch (IOException e) {
            throw new q(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.d.read(bArr, 0, i);
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized long a() {
        try {
        } catch (IOException e) {
            throw new q("Error reading length of file " + this.a, e);
        }
        return (int) this.d.length();
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new q("Error append cache: cache file " + this.a + " is completed!");
            }
            this.d.seek(a());
            this.d.write(bArr, 0, i);
        } catch (IOException e) {
            throw new q(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.d, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void b() {
        try {
            this.d.close();
            this.f662c.a(this.a);
        } catch (IOException e) {
            throw new q("Error closing file " + this.a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.a.getParentFile(), this.a.getName().substring(0, this.a.getName().length() - 9));
        if (!this.a.renameTo(file)) {
            throw new q("Error renaming file " + this.a + " to " + file + " for completion!");
        }
        this.a = file;
        try {
            this.d = new RandomAccessFile(this.a, "r");
            this.f662c.a(this.a);
        } catch (IOException e) {
            throw new q("Error opening " + this.a + " as disc cache", e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized boolean d() {
        return !a(this.a);
    }

    public File e() {
        return this.a;
    }
}
