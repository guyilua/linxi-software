package com.sigmob.sdk.downloader.core.breakpoint;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    private final long a;
    private final long b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicLong f496c;

    public a(long j, long j2) {
        this(j, j2, 0L);
    }

    public a(long j, long j2, long j3) {
        if (j < 0 || ((j2 < 0 && j2 != -1) || j3 < 0)) {
            throw new IllegalArgumentException();
        }
        this.a = j;
        this.b = j2;
        this.f496c = new AtomicLong(j3);
    }

    public long a() {
        return this.f496c.get();
    }

    public void a(long j) {
        this.f496c.addAndGet(j);
    }

    public long b() {
        return this.a;
    }

    public long c() {
        return this.a + this.f496c.get();
    }

    public long d() {
        return this.b;
    }

    public long e() {
        long j = this.b;
        if (j == -1) {
            return -1L;
        }
        return (this.a + j) - 1;
    }

    public void f() {
        this.f496c.set(0L);
    }

    public a g() {
        return new a(this.a, this.b, this.f496c.get());
    }

    public String toString() {
        return "[" + this.a + ", " + e() + ")-current:" + this.f496c;
    }
}
