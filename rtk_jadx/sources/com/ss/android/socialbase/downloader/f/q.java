package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q {
    final String a;
    final String b;

    /* renamed from: c, reason: collision with root package name */
    final String f865c;
    final boolean d;
    private final List<m> e;
    private int f;
    private boolean g;
    private int h;
    private String i;
    private final AtomicLong j;

    public q(String str, boolean z) {
        this.e = new ArrayList();
        this.j = new AtomicLong();
        this.a = str;
        this.d = z;
        this.b = null;
        this.f865c = null;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String e() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("_");
            String str = this.b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.d);
            this.i = sb.toString();
        }
        return this.i;
    }

    public synchronized void b(m mVar) {
        try {
            this.e.remove(mVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        this.g = false;
    }

    public synchronized boolean d() {
        return this.g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return e().equals(((q) obj).e());
        }
        return false;
    }

    public int hashCode() {
        if (this.h == 0) {
            this.h = e().hashCode();
        }
        return this.h;
    }

    public String toString() {
        return "UrlRecord{url='" + this.a + "', ip='" + this.b + "', ipFamily='" + this.f865c + "', isMainUrl=" + this.d + ", failedTimes=" + this.f + ", isCurrentFailed=" + this.g + '}';
    }

    public synchronized void b() {
        this.f++;
        this.g = true;
    }

    public synchronized void a(m mVar) {
        this.e.add(mVar);
    }

    public q(String str, String str2) {
        this.e = new ArrayList();
        this.j = new AtomicLong();
        this.a = str;
        this.d = false;
        this.b = str2;
        this.f865c = a(str2);
    }

    public synchronized int a() {
        return this.e.size();
    }

    public void a(long j) {
        this.j.addAndGet(j);
    }
}
