package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.i.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    protected int a;
    private final Map<String, c> b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, d> f900c;

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static final class C0112a {
        private static final a a = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, c cVar) {
        synchronized (this.b) {
            this.b.put(str, cVar);
        }
    }

    public d b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        d remove;
        synchronized (this.f900c) {
            remove = this.f900c.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (f.a(remove.f(), list)) {
            try {
                remove.e();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (remove.h() && remove.g()) {
                return remove;
            }
        }
        try {
            remove.d();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private a() {
        this.b = new HashMap();
        this.f900c = new LinkedHashMap(3);
        this.a = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.a = i;
    }

    public c a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        c remove;
        synchronized (this.b) {
            remove = this.b.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (f.a(remove.h(), list)) {
            try {
                remove.d();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (remove.f() && remove.e()) {
                return remove;
            }
        }
        try {
            remove.c();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(String str) {
        c cVar = this.b.get(str);
        if (cVar != null) {
            if (cVar.g()) {
                return true;
            }
            if (cVar.f() && cVar.e()) {
                return true;
            }
        }
        return false;
    }

    public static a a() {
        return C0112a.a;
    }
}
