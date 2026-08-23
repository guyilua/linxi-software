package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.network.g;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public final String a;
    public final g b;

    /* renamed from: c, reason: collision with root package name */
    public final int f898c;
    private long d;
    private long e;

    public d(String str, g gVar) {
        this.a = str;
        this.f898c = gVar.b();
        this.b = gVar;
    }

    public boolean a() {
        return f.c(this.f898c);
    }

    public boolean b() {
        return f.a(this.f898c, this.b.a(com.sigmob.sdk.downloader.core.c.i));
    }

    public String c() {
        return this.b.a(com.sigmob.sdk.downloader.core.c.g);
    }

    public String d() {
        return this.b.a("Content-Type");
    }

    public String e() {
        return f.b(this.b, com.sigmob.sdk.downloader.core.c.f);
    }

    public String f() {
        String b = f.b(this.b, "last-modified");
        return TextUtils.isEmpty(b) ? f.b(this.b, "Last-Modified") : b;
    }

    public String g() {
        return f.b(this.b, "Cache-Control");
    }

    public long h() {
        if (this.d <= 0) {
            this.d = f.a(this.b);
        }
        return this.d;
    }

    public boolean i() {
        if (com.ss.android.socialbase.downloader.i.a.a(8)) {
            return f.c(this.b);
        }
        return f.b(h());
    }

    public long j() {
        if (this.e <= 0) {
            if (!i()) {
                String e = e();
                if (!TextUtils.isEmpty(e)) {
                    this.e = f.b(e);
                }
            } else {
                this.e = -1L;
            }
        }
        return this.e;
    }

    public long k() {
        return f.i(g());
    }
}
