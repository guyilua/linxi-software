package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.f;
import java.io.File;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public enum a {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        CANCELED,
        UNKNOWN
    }

    public static a a(String str, String str2, String str3) {
        return b(d(str, str2, str3));
    }

    public static boolean a(f fVar) {
        return g.j().a().c(fVar) != null;
    }

    public static a b(f fVar) {
        a d = d(fVar);
        a aVar = a.COMPLETED;
        if (d == aVar) {
            return aVar;
        }
        com.sigmob.sdk.downloader.core.dispatcher.b a2 = g.j().a();
        return a2.f(fVar) ? a.PENDING : a2.d(fVar) ? a.RUNNING : a2.e(fVar) ? a.CANCELED : d;
    }

    public static boolean b(String str, String str2, String str3) {
        return c(d(str, str2, str3));
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c c(String str, String str2, String str3) {
        return e(d(str, str2, str3));
    }

    public static boolean c(f fVar) {
        return d(fVar) == a.COMPLETED;
    }

    public static f d(String str, String str2, String str3) {
        return new f.a(str, str2, str3).a();
    }

    public static a d(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.g c2 = g.j().c();
        com.sigmob.sdk.downloader.core.breakpoint.c a2 = c2.a(fVar.c());
        String d = fVar.d();
        File l = fVar.l();
        File n = fVar.n();
        if (a2 != null) {
            if (!a2.b() && a2.j() <= 0) {
                return a.UNKNOWN;
            }
            if (n != null && n.equals(a2.o()) && n.exists() && a2.i() == a2.j()) {
                return a.COMPLETED;
            }
            if (d == null && a2.o() != null && a2.o().exists()) {
                return a.IDLE;
            }
            if (n != null && n.equals(a2.o()) && n.exists()) {
                return a.IDLE;
            }
        } else {
            if (c2.a() || c2.c(fVar.c())) {
                return a.UNKNOWN;
            }
            if (n != null && n.exists()) {
                return a.COMPLETED;
            }
            String a3 = c2.a(fVar.i());
            if (a3 != null && new File(l, a3).exists()) {
                return a.COMPLETED;
            }
        }
        return a.UNKNOWN;
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c e(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.g c2 = g.j().c();
        com.sigmob.sdk.downloader.core.breakpoint.c a2 = c2.a(c2.b(fVar));
        if (a2 == null) {
            return null;
        }
        return a2.p();
    }
}
