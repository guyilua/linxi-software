package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.util.SparseArray;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.ak;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h {
    static final /* synthetic */ boolean a = true;
    private static final Object b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f997c = new HashMap();
    private static int d = 0;
    private static final Map<String, a> e = new HashMap();
    private static final Object f = new Object();
    private static final Object g = new Object();
    private static final SparseArray<String> h = new SparseArray<>();
    private static boolean i = false;
    private static boolean j = false;
    private static final Object k = new Object();
    private static String l = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        long a = 0;
        int b = 0;

        /* renamed from: c, reason: collision with root package name */
        Map<String, String> f998c = new HashMap();
        private String d;
        private boolean e;
        private boolean f;

        a(String str, boolean z, boolean z2) {
            this.e = false;
            this.f = false;
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        private long d(String str) {
            return g.c(a(str));
        }

        final void a(String str, String str2) {
            this.f998c.put(str, str2);
        }

        final String b(String str) {
            String a = a(str);
            return a == null ? "" : a;
        }

        final boolean c(String str) {
            if (g.a(str)) {
                return false;
            }
            String str2 = null;
            long j = 0;
            HashMap hashMap = new HashMap();
            Map c2 = h.c(str);
            int i = 0;
            for (String str3 : c2.keySet()) {
                String str4 = (String) c2.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals("up")) {
                    j = g.c(str4);
                } else if (this.e && str3.equals("pid")) {
                    i = (int) g.c(str4);
                } else {
                    hashMap.put(str3, str4);
                }
            }
            String str5 = this.d;
            if (str5 != null && !str5.equals(str2)) {
                return false;
            }
            this.a = j;
            this.b = i;
            this.d = str2;
            this.f998c = hashMap;
            return true;
        }

        final void a(String str, long j) {
            long d = d(str) + j;
            if (d <= 100) {
                j = d < 0 ? 0L : d;
            }
            a(str, String.valueOf(j));
        }

        final boolean a(a aVar) {
            if (!this.f) {
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "WaItem '%s' is not mergable!", this.d), null);
                return false;
            }
            for (String str : aVar.f998c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, aVar.a(str));
                } else {
                    long d = aVar.d(str);
                    if (d == 0) {
                        a(str, aVar.a(str));
                    } else if (d < 100) {
                        a(str, d);
                    }
                }
            }
            return true;
        }

        final String a(String str) {
            return this.f998c.get(str);
        }

        final String a(boolean z, boolean z2, boolean z3) {
            if (this.d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                h.b(sb, "lt", "uc");
                h.b(sb, "pre", com.uc.crashsdk.g.e());
                h.b(sb, "pkg", com.uc.crashsdk.a.a);
                h.b(sb, "rom", Build.VERSION.RELEASE);
                h.b(sb, "brd", Build.BRAND);
                h.b(sb, "model", Build.MODEL);
                h.a(sb, "sdk", Build.VERSION.SDK_INT);
                h.b(sb, ak.w, com.uc.crashsdk.e.e());
                h.b(sb, "hdw", com.uc.crashsdk.e.f());
                long k = h.k();
                h.a(sb, "ram", k);
                h.b(sb, "aram", h.a(k));
                h.b(sb, "cver", "3.2.0.4");
                h.b(sb, "cseq", "210105150455");
                h.b(sb, "ctag", "release");
                h.b(sb, "aver", com.uc.crashsdk.a.a());
                h.b(sb, "ver", com.uc.crashsdk.g.R());
                h.b(sb, "sver", com.uc.crashsdk.g.S());
                h.b(sb, "seq", com.uc.crashsdk.g.T());
                h.b(sb, "grd", com.uc.crashsdk.b.x() ? "fg" : "bg");
                h.b(sb, ak.x, "android");
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
            h.b(sb, "lt", this.d);
            h.a(sb, this.f998c);
            if (this.e && !z2) {
                long j = this.a;
                if (j != 0) {
                    h.b(sb, "up", String.valueOf(j));
                }
                if (z3) {
                    h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(Process.myPid())));
                } else {
                    int i = this.b;
                    if (i != 0) {
                        h.b(sb, "pid", String.format(Locale.US, "%d", Integer.valueOf(i)));
                    }
                }
            }
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            return sb.toString();
        }
    }

    static /* synthetic */ String a(long j2) {
        if (j2 < 524288) {
            return "512M";
        }
        return String.format(Locale.US, "%dG", Long.valueOf(((j2 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) + 512) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    static /* synthetic */ Map c(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] split = str2.split("=", 3);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static void d() {
        b(2, 2000L);
        a(1, 70000L);
    }

    public static boolean e() {
        return j;
    }

    public static void f() {
        b(1, 2000L);
    }

    public static void g() {
        b(3, 0L);
    }

    public static void h() {
        b(4, 0L);
    }

    public static void i() {
        if (com.uc.crashsdk.g.O()) {
            f.a(1, new e(303));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] j() {
        return new byte[]{Byte.MAX_VALUE, 100, 110, 31};
    }

    static /* synthetic */ long k() {
        return n();
    }

    private static String l() {
        return com.uc.crashsdk.g.U() + "pv.wa";
    }

    private static String m() {
        return com.uc.crashsdk.g.U() + "cdt.wa";
    }

    private static long n() {
        Iterator<String> it = g.a(new File("/proc/meminfo"), 2).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next.contains("MemTotal:")) {
                try {
                    return Long.parseLong(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    g.a(e2);
                }
            }
        }
        return 0L;
    }

    private static String o() {
        if (g.a(l)) {
            synchronized (k) {
                l = g.a(com.uc.crashsdk.b.h(), com.uc.crashsdk.g.P() ? "https://errlogos.umeng.com/api/crashsdk/logcollect" : "https://errlog.umeng.com/api/crashsdk/logcollect", true);
            }
        }
        return l;
    }

    static /* synthetic */ void a(StringBuilder sb, String str, long j2) {
        b(sb, str, String.valueOf(j2));
    }

    public static void b() {
        a(2, 0L);
    }

    public static void c() {
        a(3, 0L);
    }

    private static void b(int i2, long j2) {
        if (com.uc.crashsdk.g.O()) {
            f.a(1, new e(AdEventType.VIDEO_PAGE_OPEN, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    private static boolean d(String str) {
        File file = new File(str);
        Iterator<a> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            a next = it.next();
            String a2 = next.a("prc");
            if (!g.a(a2)) {
                Map<String, a> map = e;
                a aVar = map.get(a2);
                if (aVar != null) {
                    aVar.a(next);
                } else {
                    map.put(a2, next);
                }
            }
        }
        Map<String, a> map2 = e;
        boolean b2 = b(com.uc.crashsdk.e.p(), a((Iterable<a>) map2.values(), true, false).toString());
        g.b(file);
        if (b2 || g.a(file, a((Iterable<a>) map2.values(), false, true).toString())) {
            map2.clear();
        }
        return true;
    }

    static /* synthetic */ void a(StringBuilder sb, Map map) {
        for (String str : map.keySet()) {
            b(sb, str, (String) map.get(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        synchronized (b) {
            File file = new File(l());
            a aVar = new a("pv", true, true);
            String c2 = g.c(file);
            if (!g.a(c2)) {
                aVar.c(c2);
            }
            aVar.a(str, 1L);
            aVar.a("aujv", 1L);
            g.a(file, aVar.a(false, false, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(int i2, Object[] objArr) {
        switch (i2) {
            case 351:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                if (intValue == 1) {
                    if (j) {
                        return false;
                    }
                    j = true;
                }
                File file = new File(str);
                ArrayList<a> a2 = a(file, "crp", 100);
                if (intValue != 4) {
                    a aVar = new a("crp", false, false);
                    if (intValue == 1) {
                        aVar.a("et", String.valueOf(com.uc.crashsdk.b.F()));
                        aVar.a("ete", String.valueOf(com.uc.crashsdk.b.G()));
                    } else if (intValue == 3) {
                        aVar.a("et", "1");
                        aVar.a("ete", "1");
                    } else if (intValue == 2) {
                        aVar.a("hpv", "1");
                    }
                    aVar.a("prc", com.uc.crashsdk.e.h());
                    aVar.a("imp", com.uc.crashsdk.b.C() ? "1" : "0");
                    a(aVar);
                    a2.add(0, aVar);
                }
                if (!a2.isEmpty()) {
                    boolean b2 = b(com.uc.crashsdk.e.p(), a((Iterable<a>) a2, true, false).toString());
                    g.b(file);
                    if (!b2) {
                        g.a(file, a((Iterable<a>) a2, false, true).toString());
                    }
                }
                return true;
            case 352:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 353:
                if (a || objArr != null) {
                    return b((String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                }
                throw new AssertionError();
            case 354:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                boolean b3 = b(com.uc.crashsdk.e.p(), a((Iterable<a>) a(file2, "cst", 30), true, false).toString());
                if (b3) {
                    g.b(file2);
                }
                return b3;
            default:
                return false;
        }
    }

    public static void a() {
        a(0, com.uc.crashsdk.b.E() ? 700000L : 70000L);
    }

    private static void a(int i2, long j2) {
        if (com.uc.crashsdk.b.C()) {
            f.a(0, new e(302, new Object[]{Integer.valueOf(i2)}), j2);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            String str3 = "c_" + str.replaceAll("[^0-9a-zA-Z-_]", "-");
            String replaceAll = g.a(str2) ? "" : str2.replaceAll("[`=]", "-");
            Map<String, String> map = f997c;
            synchronized (map) {
                if (map.get(str3) == null) {
                    int i2 = d;
                    if (i2 >= 20) {
                        return false;
                    }
                    d = i2 + 1;
                }
                map.put(str3, replaceAll);
                return true;
            }
        } catch (Throwable th) {
            g.a(th);
            return false;
        }
    }

    public static void b(boolean z) {
        if (a(z, "crash detail upload")) {
            return;
        }
        String str = com.uc.crashsdk.g.U() + "dt.wa";
        com.uc.crashsdk.b.a(f, str, new e(352, new Object[]{str}));
        String m = m();
        com.uc.crashsdk.b.a(g, m, new e(354, new Object[]{m}));
    }

    private static boolean b(String str, String str2, boolean z, boolean z2) {
        a aVar;
        File file = new File(m());
        ArrayList<a> a2 = a(file, "cst", 30);
        String str3 = str + str2;
        Iterator<a> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (str3.equals(aVar.b("prc") + aVar.b("typ"))) {
                break;
            }
        }
        if (aVar == null) {
            aVar = new a("cst", false, true);
            aVar.a("prc", str);
            aVar.a("typ", str2);
            a(aVar);
            a2.add(aVar);
        }
        aVar.a("cnt", 1L);
        if (z) {
            aVar.a("lim", 1L);
        }
        if (z2) {
            aVar.a("syu", 1L);
        }
        return g.a(file, a((Iterable<a>) a2, false, false).toString());
    }

    private static void a(a aVar) {
        Map<String, String> map = f997c;
        synchronized (map) {
            for (String str : map.keySet()) {
                aVar.a(str, f997c.get(str));
            }
        }
    }

    public static void a(boolean z) {
        a(1, z);
    }

    public static boolean a(boolean z, String str) {
        if (!com.uc.crashsdk.b.d || z || !JNIBridge.nativeIsCrashing()) {
            return false;
        }
        com.uc.crashsdk.a.a.b("crashsdk", "Native is crashing, skip stat for " + str);
        return true;
    }

    private static void a(int i2, boolean z) {
        if (a(z, "crash rate")) {
            return;
        }
        String str = com.uc.crashsdk.g.U() + "cr.wa";
        com.uc.crashsdk.b.a(b, str, new e(351, new Object[]{str, Integer.valueOf(i2)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean b(java.lang.String r9, java.lang.String r10) {
        /*
            boolean r0 = com.uc.crashsdk.a.g.a(r10)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            byte[] r10 = r10.getBytes()
            r0 = 16
            r2 = 8
            r3 = 0
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3b
            byte[] r4 = com.uc.crashsdk.a.c.a()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.c.a(r0, r3, r4)     // Catch: java.lang.Throwable -> L3b
            r4 = 4
            byte[] r5 = j()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.c.a(r0, r4, r5)     // Catch: java.lang.Throwable -> L3b
            byte[] r4 = com.uc.crashsdk.a.f()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.c.a(r0, r2, r4)     // Catch: java.lang.Throwable -> L3b
            r4 = 12
            byte[] r5 = com.uc.crashsdk.a.d.c()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.c.a(r0, r4, r5)     // Catch: java.lang.Throwable -> L3b
            byte[] r0 = com.uc.crashsdk.a.c.a(r10, r0)     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L3f
            r10 = r0
            r0 = 1
            goto L40
        L3b:
            r0 = move-exception
            com.uc.crashsdk.a.g.a(r0)
        L3f:
            r0 = 0
        L40:
            if (r9 != 0) goto L44
            java.lang.String r9 = "unknown"
        L44:
            boolean r4 = com.uc.crashsdk.g.P()
            if (r4 == 0) goto L4d
            java.lang.String r4 = "4ea4e41a3993"
            goto L4f
        L4d:
            java.lang.String r4 = "28ef1713347d"
        L4f:
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r9)
            r6.append(r5)
            java.lang.String r7 = "AppChk#2014"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = com.uc.crashsdk.a.g.d(r6)
            if (r6 != 0) goto L76
            r9 = 0
            goto Lba
        L76:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = o()
            r7.append(r8)
            java.lang.String r8 = "?chk="
            r7.append(r8)
            int r8 = r6.length()
            int r8 = r8 - r2
            int r2 = r6.length()
            java.lang.String r2 = r6.substring(r8, r2)
            r7.append(r2)
            java.lang.String r2 = "&vno="
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = "&uuid="
            r7.append(r2)
            r7.append(r9)
            java.lang.String r9 = "&app="
            r7.append(r9)
            r7.append(r4)
            if (r0 == 0) goto Lb6
            java.lang.String r9 = "&enc=aes"
            r7.append(r9)
        Lb6:
            java.lang.String r9 = r7.toString()
        Lba:
            if (r9 != 0) goto Lbd
            return r3
        Lbd:
            byte[] r9 = com.uc.crashsdk.a.c.a(r9, r10)
            if (r9 != 0) goto Lc4
            return r3
        Lc4:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9)
            java.lang.String r9 = "retcode=0"
            boolean r9 = r10.contains(r9)
            if (r9 == 0) goto Ld2
            return r1
        Ld2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.b(java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
    
        if (r3 == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af A[Catch: all -> 0x00cb, TryCatch #0 {, blocks: (B:19:0x001d, B:21:0x0028, B:23:0x002c, B:24:0x00c9, B:27:0x002e, B:29:0x0038, B:31:0x0040, B:33:0x005a, B:35:0x005f, B:42:0x0070, B:43:0x0077, B:44:0x008b, B:46:0x0097, B:50:0x00af, B:51:0x00c2, B:52:0x00a5, B:57:0x0083), top: B:18:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.h.a(int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        synchronized (k) {
            l = str;
            b.a(com.uc.crashsdk.b.h(), l + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    private static StringBuilder a(Iterable<a> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (a aVar : iterable) {
            if (z3) {
                sb.append(aVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(aVar.a(false, z, z2));
            }
        }
        return sb;
    }

    public static void a(String str, int i2, int i3) {
        if (com.uc.crashsdk.g.O()) {
            synchronized (f) {
                Map<String, a> map = e;
                a aVar = map.get(str);
                if (aVar == null) {
                    aVar = new a("cst", false, true);
                    map.put(str, aVar);
                    a(aVar);
                }
                SparseArray<String> sparseArray = h;
                synchronized (sparseArray) {
                    if (sparseArray.size() == 0) {
                        a(100, "pv");
                        a(102, "hpv");
                        a(1, "all");
                        a(2, "afg");
                        a(101, "abg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(32, "urs");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(40, "anf");
                        a(41, "anb");
                        a(42, "ancf");
                        a(43, "ancb");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(200, "ltf");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(201, "lec");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = sparseArray.get(i2);
                if (str2 == null) {
                    com.uc.crashsdk.a.a.a("crashsdk", "map key is not set with: " + i2, null);
                }
                aVar.a("prc", str);
                if (str2 != null) {
                    aVar.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    public static boolean a(String str, String str2, boolean z, boolean z2) {
        if (!com.uc.crashsdk.g.O()) {
            return false;
        }
        return com.uc.crashsdk.b.a(g, m(), new e(353, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}));
    }

    private static void a(int i2, String str) {
        h.put(i2, str);
    }

    private static ArrayList<a> a(File file, String str, int i2) {
        ArrayList<String> a2 = g.a(file, i2);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String> it = a2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            a aVar = new a(str, false, false);
            if (aVar.c(next)) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
