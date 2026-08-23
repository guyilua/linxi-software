package com.uc.crashsdk.a;

import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    static final /* synthetic */ boolean a = true;
    private static boolean b = true;
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g;
    private static String i;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f993c = new Object();
    private static final Object h = new Object();

    public static void a() {
        f.a(0, new e(TbsListener.ErrorCode.INFO_CODE_MINIQB), com.uc.crashsdk.b.E() ? 900000L : 90000L);
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] c() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean d() {
        if (!com.uc.crashsdk.e.E() && !com.uc.crashsdk.b.I()) {
            a(true);
            return b;
        }
        return true;
    }

    private static String e() {
        if (g.a(i)) {
            synchronized (h) {
                i = g.a(com.uc.crashsdk.b.g(), (com.uc.crashsdk.g.P() ? "https://errlogos.umeng.com" : "https://errlog.umeng.com") + "/api/crashsdk/validate", true);
            }
        }
        return i;
    }

    private static String f() {
        byte[] bArr;
        String e2;
        byte[] a2;
        byte[] bArr2;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.a);
        a(sb, UMModuleRegister.PROCESS, com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.2.0.4");
        a(sb, "ctag", "release");
        a(sb, "inter", com.uc.crashsdk.g.P() ? "true" : "false");
        a(sb, ak.x, "android");
        String sb2 = sb.toString();
        byte[] bArr3 = new byte[16];
        c.a(bArr3, 0, h.j());
        c.a(bArr3, 4, c.a());
        c.a(bArr3, 8, c());
        c.a(bArr3, 12, com.uc.crashsdk.a.f());
        try {
            bArr = c.a(sb2.getBytes(), bArr3, true);
        } catch (Throwable th) {
            g.a(th);
            bArr = null;
        }
        if (bArr == null || (e2 = e()) == null || (a2 = c.a(e2, bArr)) == null) {
            return null;
        }
        try {
            bArr2 = c.a(a2, bArr3, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            return new String(bArr2);
        }
        return null;
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (f993c) {
            g = null;
            a(!com.uc.crashsdk.b.C());
            if (g.b(g)) {
                h.a(g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(boolean r12) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.d.a(boolean):boolean");
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        return sb;
    }
}
