package com.sigmob.sdk.downloader;

import android.os.SystemClock;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k {
    long a;
    long b;

    /* renamed from: c, reason: collision with root package name */
    long f553c;
    long d;
    long e;
    long f;

    private static String a(long j, boolean z) {
        return com.sigmob.sdk.downloader.core.c.a(j, z) + "/s";
    }

    public synchronized void a() {
        this.a = 0L;
        this.b = 0L;
        this.f553c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }

    public synchronized void a(long j) {
        if (this.a == 0) {
            long b = b();
            this.a = b;
            this.d = b;
        }
        this.b += j;
        this.f += j;
    }

    long b() {
        return SystemClock.uptimeMillis();
    }

    public synchronized void c() {
        long b = b();
        long j = this.b;
        long max = Math.max(1L, b - this.a);
        this.b = 0L;
        this.a = b;
        this.f553c = (((float) j) / ((float) max)) * 1000.0f;
    }

    public long d() {
        c();
        return this.f553c;
    }

    public synchronized long e() {
        long b = b() - this.a;
        if (b < 1000) {
            long j = this.f553c;
            if (j != 0) {
                return j;
            }
        }
        if (this.f553c == 0 && b < 500) {
            return 0L;
        }
        return d();
    }

    public synchronized long f() {
        long j;
        j = this.e;
        if (j == 0) {
            j = b();
        }
        return (((float) this.f) / ((float) Math.max(1L, j - this.d))) * 1000.0f;
    }

    public synchronized void g() {
        this.e = b();
    }

    public String h() {
        return m();
    }

    public String i() {
        return a(e(), true);
    }

    public String j() {
        return a(this.f553c, true);
    }

    public synchronized long k() {
        return b() - this.a;
    }

    public String l() {
        return a(d(), false);
    }

    public String m() {
        return a(d(), true);
    }

    public String n() {
        return o();
    }

    public String o() {
        return a(f(), true);
    }
}
