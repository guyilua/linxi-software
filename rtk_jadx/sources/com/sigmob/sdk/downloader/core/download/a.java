package com.sigmob.sdk.downloader.core.download;

import android.net.Uri;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    boolean a;
    boolean b;

    /* renamed from: c, reason: collision with root package name */
    boolean f528c;
    private boolean d;
    private final com.sigmob.sdk.downloader.f e;
    private final com.sigmob.sdk.downloader.core.breakpoint.c f;
    private final long g;

    public a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j) {
        this.e = fVar;
        this.f = cVar;
        this.g = j;
    }

    public boolean a() {
        return this.d;
    }

    public com.sigmob.sdk.downloader.core.cause.b b() {
        if (!this.b) {
            return com.sigmob.sdk.downloader.core.cause.b.INFO_DIRTY;
        }
        if (!this.a) {
            return com.sigmob.sdk.downloader.core.cause.b.FILE_NOT_EXIST;
        }
        if (!this.f528c) {
            return com.sigmob.sdk.downloader.core.cause.b.OUTPUT_STREAM_NOT_SUPPORT;
        }
        throw new IllegalStateException("No cause find with dirty: " + this.d);
    }

    public boolean c() {
        int g = this.f.g();
        if (g <= 0 || this.f.b() || this.f.o() == null) {
            return false;
        }
        if (!this.f.o().equals(this.e.m()) || this.f.o().length() > this.f.j()) {
            return false;
        }
        if (this.g > 0 && this.f.j() != this.g) {
            return false;
        }
        for (int i = 0; i < g; i++) {
            if (this.f.b(i).d() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        if (com.sigmob.sdk.downloader.g.j().e().a()) {
            return true;
        }
        return this.f.g() == 1 && !com.sigmob.sdk.downloader.g.j().f().b(this.e);
    }

    public boolean e() {
        Uri h = this.e.h();
        if (com.sigmob.sdk.downloader.core.c.a(h)) {
            return com.sigmob.sdk.downloader.core.c.d(h) > 0;
        }
        File m = this.e.m();
        return m != null && m.exists();
    }

    public void f() {
        this.a = e();
        this.b = c();
        boolean d = d();
        this.f528c = d;
        this.d = (this.b && this.a && d) ? false : true;
    }

    public String toString() {
        return "fileExist[" + this.a + "] infoRight[" + this.b + "] outputStreamSupport[" + this.f528c + "] " + super.toString();
    }
}
