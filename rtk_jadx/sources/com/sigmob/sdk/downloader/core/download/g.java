package com.sigmob.sdk.downloader.core.download;

import android.net.ConnectivityManager;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.exception.i;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g {
    private static final String b = "DownloadStrategy";

    /* renamed from: c, reason: collision with root package name */
    private static final long f534c = 1048576;
    private static final long d = 5242880;
    private static final long e = 52428800;
    private static final long f = 104857600;
    private static final Pattern g = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    Boolean a = null;
    private ConnectivityManager h = null;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private volatile String a;
        private final boolean b = false;

        public a() {
        }

        public a(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        void a(String str) {
            this.a = str;
        }

        public boolean b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj instanceof a) {
                return this.a == null ? ((a) obj).a == null : this.a.equals(((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            if (this.a == null) {
                return 0;
            }
            return this.a.hashCode();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b {
        private a.InterfaceC0041a a;
        private com.sigmob.sdk.downloader.core.breakpoint.c b;

        /* renamed from: c, reason: collision with root package name */
        private int f535c;

        protected b(a.InterfaceC0041a interfaceC0041a, int i, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
            this.a = interfaceC0041a;
            this.b = cVar;
            this.f535c = i;
        }

        public void a() {
            com.sigmob.sdk.downloader.core.breakpoint.a b = this.b.b(this.f535c);
            int d = this.a.d();
            com.sigmob.sdk.downloader.core.cause.b a = com.sigmob.sdk.downloader.g.j().g().a(d, b.a() != 0, this.b, this.a.c(com.sigmob.sdk.downloader.core.c.g));
            if (a != null) {
                throw new com.sigmob.sdk.downloader.core.exception.f(a);
            }
            if (com.sigmob.sdk.downloader.g.j().g().a(d, b.a() != 0)) {
                throw new i(d, b.a());
            }
        }
    }

    public int a(com.sigmob.sdk.downloader.f fVar, long j) {
        if (fVar.u() != null) {
            return fVar.u().intValue();
        }
        if (j < 1048576) {
            return 1;
        }
        if (j < d) {
            return 2;
        }
        if (j < e) {
            return 3;
        }
        return j < f ? 4 : 5;
    }

    public long a() {
        return 10240L;
    }

    public com.sigmob.sdk.downloader.core.cause.b a(int i, boolean z, com.sigmob.sdk.downloader.core.breakpoint.c cVar, String str) {
        String k = cVar.k();
        if (i == 412) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_PRECONDITION_FAILED;
        }
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) k) && !com.sigmob.sdk.downloader.core.c.a((CharSequence) str) && !str.equals(k)) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_ETAG_CHANGED;
        }
        if (i == 201 && z) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i == 205 && z) {
            return com.sigmob.sdk.downloader.core.cause.b.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public b a(a.InterfaceC0041a interfaceC0041a, int i, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        return new b(interfaceC0041a, i, cVar);
    }

    public void a(com.sigmob.sdk.downloader.f fVar, j jVar) {
        long length;
        com.sigmob.sdk.downloader.core.breakpoint.c e2 = jVar.e(fVar.c());
        if (e2 == null) {
            e2 = new com.sigmob.sdk.downloader.core.breakpoint.c(fVar.c(), fVar.i(), fVar.l(), fVar.d());
            if (com.sigmob.sdk.downloader.core.c.a(fVar.h())) {
                length = com.sigmob.sdk.downloader.core.c.d(fVar.h());
            } else {
                File m = fVar.m();
                if (m == null) {
                    length = 0;
                    com.sigmob.sdk.downloader.core.c.a(b, "file is not ready on valid info for task on complete state " + fVar);
                } else {
                    length = m.length();
                }
            }
            long j = length;
            e2.a(new com.sigmob.sdk.downloader.core.breakpoint.a(0L, j, j));
        }
        f.c.a(fVar, e2);
    }

    public void a(String str, com.sigmob.sdk.downloader.f fVar) {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
            fVar.g().a(str);
        }
    }

    public void a(String str, com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
            String b2 = b(str, fVar);
            if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
                synchronized (fVar) {
                    if (com.sigmob.sdk.downloader.core.c.a((CharSequence) fVar.d())) {
                        fVar.g().a(b2);
                        cVar.n().a(b2);
                    }
                }
            }
        }
    }

    public boolean a(int i, boolean z) {
        if (i == 206 || i == 200) {
            return i == 200 && z;
        }
        return true;
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar) {
        String a2 = com.sigmob.sdk.downloader.g.j().c().a(fVar.i());
        if (a2 == null) {
            return false;
        }
        fVar.g().a(a2);
        return true;
    }

    public boolean a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.breakpoint.c cVar, long j) {
        com.sigmob.sdk.downloader.core.breakpoint.g c2;
        com.sigmob.sdk.downloader.core.breakpoint.c a2;
        if (!fVar.a() || (a2 = (c2 = com.sigmob.sdk.downloader.g.j().c()).a(fVar, cVar)) == null) {
            return false;
        }
        c2.b(a2.a());
        if (a2.i() <= com.sigmob.sdk.downloader.g.j().g().a()) {
            return false;
        }
        if ((a2.k() != null && !a2.k().equals(cVar.k())) || a2.j() != j || a2.o() == null || !a2.o().exists()) {
            return false;
        }
        cVar.a(a2);
        com.sigmob.sdk.downloader.core.c.b(b, "Reuse another same info: " + cVar);
        return true;
    }

    public boolean a(boolean z) {
        if (com.sigmob.sdk.downloader.g.j().e().a()) {
            return z;
        }
        return false;
    }

    protected String b(String str, com.sigmob.sdk.downloader.f fVar) {
        if (!com.sigmob.sdk.downloader.core.c.a((CharSequence) str)) {
            return str;
        }
        String i = fVar.i();
        Matcher matcher = g.matcher(i);
        String str2 = null;
        while (matcher.find()) {
            str2 = matcher.group(1);
        }
        if (com.sigmob.sdk.downloader.core.c.a((CharSequence) str2)) {
            str2 = com.sigmob.sdk.downloader.core.c.a(i);
        }
        if (str2 != null) {
            return str2;
        }
        throw new IOException("Can't find valid filename.");
    }

    public void b() {
        if (this.a == null) {
            this.a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.c("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.a.booleanValue()) {
            if (this.h == null) {
                this.h = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().h().getSystemService("connectivity");
            }
            if (!com.sigmob.sdk.downloader.core.c.b(this.h)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void b(com.sigmob.sdk.downloader.f fVar) {
        if (this.a == null) {
            this.a = Boolean.valueOf(com.sigmob.sdk.downloader.core.c.c("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (fVar.f()) {
            if (!this.a.booleanValue()) {
                throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
            }
            if (this.h == null) {
                this.h = (ConnectivityManager) com.sigmob.sdk.downloader.g.j().h().getSystemService("connectivity");
            }
            if (com.sigmob.sdk.downloader.core.c.a(this.h)) {
                throw new com.sigmob.sdk.downloader.core.exception.d();
            }
        }
    }
}
