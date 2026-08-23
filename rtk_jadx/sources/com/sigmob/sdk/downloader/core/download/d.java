package com.sigmob.sdk.downloader.core.download;

import com.sigmob.sdk.downloader.core.exception.i;
import java.io.IOException;
import java.net.SocketException;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private String a;
    private final com.sigmob.sdk.downloader.core.file.d b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f531c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile IOException i;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a extends d {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(IOException iOException) {
            super(null);
            c(iOException);
        }
    }

    private d() {
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.sigmob.sdk.downloader.core.file.d dVar) {
        this.b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.sigmob.sdk.downloader.core.file.d a() {
        com.sigmob.sdk.downloader.core.file.d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException();
    }

    public void a(IOException iOException) {
        this.f531c = true;
        this.i = iOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.a;
    }

    public void b(IOException iOException) {
        this.e = true;
        this.i = iOException;
    }

    public void c(IOException iOException) {
        this.f = true;
        this.i = iOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f531c;
    }

    public void d(IOException iOException) {
        this.h = true;
        this.i = iOException;
    }

    public boolean d() {
        return this.d;
    }

    public void e(IOException iOException) {
        if (d()) {
            return;
        }
        if (iOException instanceof com.sigmob.sdk.downloader.core.exception.f) {
            a(iOException);
            return;
        }
        if (iOException instanceof i) {
            b(iOException);
            return;
        }
        if (iOException == com.sigmob.sdk.downloader.core.exception.b.a) {
            m();
            return;
        }
        if (iOException instanceof com.sigmob.sdk.downloader.core.exception.e) {
            d(iOException);
            return;
        }
        if (iOException != com.sigmob.sdk.downloader.core.exception.c.a) {
            c(iOException);
            if (iOException instanceof SocketException) {
                return;
            }
            com.sigmob.sdk.downloader.core.c.b("DownloadCache", "catch unknown error " + iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IOException i() {
        return this.i;
    }

    com.sigmob.sdk.downloader.core.cause.b j() {
        return ((com.sigmob.sdk.downloader.core.exception.f) this.i).a();
    }

    public boolean k() {
        return this.f531c || this.d || this.e || this.f || this.g || this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.d = true;
    }

    public void m() {
        this.g = true;
    }
}
