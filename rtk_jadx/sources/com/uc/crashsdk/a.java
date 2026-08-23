package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.uc.crashsdk.export.LogType;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {
    public static String a = "";
    public static String b = "";
    static final /* synthetic */ boolean d = true;
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;

    /* renamed from: c, reason: collision with root package name */
    static boolean f991c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    public static String a() {
        String str = h;
        return str != null ? str : o() ? h : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b() {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            for (String str : f) {
                String str2 = e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.m()));
        com.uc.crashsdk.a.b.a(b.e(), sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (e) {
            for (String str : f) {
                JNIBridge.nativeAddHeaderInfo(str, e.get(str));
            }
        }
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (k) {
            for (String str : l) {
                Object[] objArr = k.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), intValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (String str : l) {
                if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (q) {
            for (String str : r) {
                Object[] objArr = q.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & intValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, intValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j() {
        String sb;
        synchronized (q) {
            StringBuilder sb2 = new StringBuilder();
            List<String> list = r;
            synchronized (list) {
                boolean z2 = true;
                for (String str : list) {
                    if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb2.append("`");
                        }
                        sb2.append(str);
                        z2 = false;
                    }
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & intValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, intValue, intValue2) != 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        if (!G) {
            String a2 = com.uc.crashsdk.a.b.a(b.j());
            g = a2;
            G = true;
            if (a2 == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (H) {
            if (b.d) {
                JNIBridge.set(128, g);
            }
        } else {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.d || !b.g) {
                String format = String.format(Locale.US, "%s/%s/%s", g.R(), g.S(), g.T());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.p());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + format);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }

    private static StringBuilder b(String str, boolean z2) {
        String a2;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            try {
                if (objArr == null) {
                    a2 = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    if (callable != null) {
                        a2 = (String) callable.call();
                    } else {
                        a2 = d.a(str, z2);
                    }
                }
                if (a2 != null) {
                    sb.append(a2);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    public static void a(String str, String str2) {
        Map<String, String> map = e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f.add(str);
            }
            map.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] split = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            for (String str2 : f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    String str3 = e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static int b(String str, String str2) {
        int i2;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr != null) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= intValue) {
                    list.remove(0);
                }
                list.add(str2);
                r0 = LogType.isForJava(intValue2) ? LogType.addType(0, 16) : 0;
                if (!b.d) {
                    if (LogType.isForNative(intValue2)) {
                        r0 = LogType.addType(r0, 1);
                    }
                    if (LogType.isForANR(intValue2)) {
                        r0 = LogType.addType(r0, LogType.ANR);
                    }
                }
                i2 = r0;
                r0 = intValue2;
            } else {
                i2 = 0;
            }
            if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(r0)) {
                    i2 = LogType.addType(i2, 1);
                }
                if (LogType.isForANR(r0)) {
                    i2 = LogType.addType(i2, LogType.ANR);
                }
            }
        }
        return i2;
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int i3;
        int i4;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = k;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i4 = ((Integer) hashMap.get(str)[0]).intValue();
                i3 = LogType.addType(i4, i2);
            } else {
                i3 = i2;
                i4 = 0;
            }
            if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                int i5 = m;
                if (i5 >= 10) {
                    i3 = LogType.removeType(i3, 16);
                } else {
                    m = i5 + 1;
                }
            }
            if (LogType.isForNative(i3) && !LogType.isForNative(i4)) {
                int i6 = n;
                if (i6 >= 10) {
                    i3 = LogType.removeType(i3, 1);
                } else {
                    n = i6 + 1;
                }
            }
            if (LogType.isForUnexp(i3) && !LogType.isForUnexp(i4)) {
                int i7 = o;
                if (i7 >= 10) {
                    i3 = LogType.removeType(i3, 256);
                } else {
                    o = i7 + 1;
                }
            }
            if (LogType.isForANR(i3) && !LogType.isForANR(i4)) {
                int i8 = p;
                if (i8 >= 10) {
                    i3 = LogType.removeType(i3, LogType.ANR);
                } else {
                    p = i8 + 1;
                }
            }
            if ((1048849 & i3) == 0) {
                z5 = false;
            } else {
                if (i4 == 0) {
                    l.add(str);
                }
                z5 = true;
            }
            if (!z5) {
                return i3;
            }
            if (b.d && (1048833 & i2) != 0) {
                int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                if (!LogType.isForNative(nativeAddDumpFile)) {
                    i3 = LogType.removeType(i3, 1);
                }
                if (!LogType.isForUnexp(nativeAddDumpFile)) {
                    i3 = LogType.removeType(i3, 256);
                }
                if (!LogType.isForANR(nativeAddDumpFile)) {
                    i3 = LogType.removeType(i3, LogType.ANR);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(3:34|35|(4:37|38|39|24))(3:9|10|(2:33|24))|12|13|15|16|(2:19|17)|20|21|23|24|5) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008d, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        com.uc.crashsdk.e.a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(java.io.OutputStream r11, java.lang.String r12, java.lang.String r13, java.util.ArrayList<java.lang.String> r14) {
        /*
            java.util.HashMap<java.lang.String, java.lang.Object[]> r0 = com.uc.crashsdk.a.A
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.B     // Catch: java.lang.Throwable -> Ld1
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Ld1
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r2 == 0) goto La9
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Ld1
            java.util.HashMap<java.lang.String, java.lang.Object[]> r3 = com.uc.crashsdk.a.A     // Catch: java.lang.Throwable -> Ld1
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> Ld1
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> Ld1
            r4 = 0
            r5 = r3[r4]     // Catch: java.lang.Throwable -> Ld1
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> Ld1
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> Ld1
            r6 = 1
            r7 = r3[r6]     // Catch: java.lang.Throwable -> Ld1
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Throwable -> Ld1
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> Ld1
            r8 = 2
            r3 = r3[r8]     // Catch: java.lang.Throwable -> Ld1
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> Ld1
            if (r14 != 0) goto L3d
            boolean r7 = com.uc.crashsdk.export.LogType.isForJava(r7)     // Catch: java.lang.Throwable -> Ld1
            if (r7 != 0) goto L43
            goto L9
        L3d:
            boolean r7 = a(r14, r2)     // Catch: java.lang.Throwable -> Ld1
            if (r7 == 0) goto L9
        L43:
            java.util.Locale r7 = java.util.Locale.US     // Catch: java.lang.Throwable -> L68
            java.lang.String r9 = "%s (%d/%d)\n"
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L68
            r10[r4] = r2     // Catch: java.lang.Throwable -> L68
            int r2 = r3.size()     // Catch: java.lang.Throwable -> L68
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L68
            r10[r6] = r2     // Catch: java.lang.Throwable -> L68
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L68
            r10[r8] = r2     // Catch: java.lang.Throwable -> L68
            java.lang.String r2 = java.lang.String.format(r7, r9, r10)     // Catch: java.lang.Throwable -> L68
            byte[] r2 = r2.getBytes(r12)     // Catch: java.lang.Throwable -> L68
            r11.write(r2)     // Catch: java.lang.Throwable -> L68
            goto L6c
        L68:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r11)     // Catch: java.lang.Throwable -> Ld1
        L6c:
            java.util.Iterator r2 = r3.iterator()     // Catch: java.lang.Throwable -> L8d
        L70:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L8d
            if (r3 == 0) goto L91
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L8d
            byte[] r3 = r3.getBytes(r12)     // Catch: java.lang.Throwable -> L8d
            r11.write(r3)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r3 = "\n"
            byte[] r3 = r3.getBytes(r12)     // Catch: java.lang.Throwable -> L8d
            r11.write(r3)     // Catch: java.lang.Throwable -> L8d
            goto L70
        L8d:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r11)     // Catch: java.lang.Throwable -> Ld1
        L91:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r12)     // Catch: java.lang.Throwable -> La3
            r11.write(r2)     // Catch: java.lang.Throwable -> La3
            byte[] r2 = r13.getBytes(r12)     // Catch: java.lang.Throwable -> La3
            r11.write(r2)     // Catch: java.lang.Throwable -> La3
            goto L9
        La3:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r11)     // Catch: java.lang.Throwable -> Ld1
            goto L9
        La9:
            if (r14 == 0) goto Lcf
            boolean r12 = com.uc.crashsdk.e.E()     // Catch: java.lang.Throwable -> Ld1
            if (r12 == 0) goto Lcf
            java.util.Iterator r12 = r14.iterator()     // Catch: java.lang.Throwable -> Ld1
        Lb5:
            boolean r13 = r12.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r13 == 0) goto Lcf
            java.lang.Object r13 = r12.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> Ld1
            java.util.List<java.lang.String> r14 = com.uc.crashsdk.a.B     // Catch: java.lang.Throwable -> Ld1
            boolean r14 = a(r14, r13)     // Catch: java.lang.Throwable -> Ld1
            if (r14 != 0) goto Lb5
            java.lang.String r14 = "CUSTOMCACHEDINFO"
            com.uc.crashsdk.e.a(r11, r14, r13)     // Catch: java.lang.Throwable -> Ld1
            goto Lb5
        Lcf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            return
        Ld1:
            r11 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:12:0x0025, B:69:0x002f, B:22:0x0045, B:24:0x0050, B:15:0x003e), top: B:11:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b0 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:33:0x007f, B:37:0x009b, B:39:0x00a3, B:57:0x00b0, B:59:0x00b5), top: B:32:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r18, java.lang.String r19, java.util.ArrayList<java.lang.String> r20) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            int intValue = ((Integer) objArr[0]).intValue();
            List list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(intValue)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        HashMap<String, Object[]> hashMap = k;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            String str2 = (String) objArr[1];
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str2;
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(booleanValue ? 1 : 0);
            if (!booleanValue2) {
                i2 = 0;
            }
            objArr2[3] = Integer.valueOf(i2);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d0 A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5 A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed A[Catch: all -> 0x015a, DONT_GENERATE, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ef A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:22:0x005d, B:25:0x0047, B:28:0x004c, B:29:0x0057, B:30:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:42:0x009a, B:43:0x00a1, B:45:0x00a9, B:47:0x00af, B:49:0x00b3, B:50:0x00b8, B:51:0x00be, B:53:0x00c6, B:55:0x00cc, B:57:0x00d0, B:58:0x00d5, B:59:0x00db, B:63:0x00ed, B:65:0x00ef, B:67:0x00f3, B:69:0x00f9, B:71:0x0105, B:73:0x010b, B:75:0x0112, B:76:0x0117, B:78:0x011d, B:80:0x0123, B:81:0x0128, B:83:0x012e, B:85:0x0134, B:86:0x013c, B:87:0x0158, B:91:0x00e5, B:97:0x007c, B:100:0x0081, B:101:0x008b, B:104:0x0092), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r16, int r17, java.util.concurrent.Callable<java.lang.String> r18, long r19, int r21) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:7|(2:8|9)|(3:35|36|(4:39|40|41|17)(1:38))(3:11|12|(4:14|15|16|17)(1:18))|19|(1:21)(1:34)|(1:33)(1:25)|26|27|29|17|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r10, java.lang.String r11, java.lang.String r12, java.util.ArrayList<java.lang.String> r13) {
        /*
            java.util.HashMap<java.lang.String, java.lang.Object[]> r0 = com.uc.crashsdk.a.q
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.r     // Catch: java.lang.Throwable -> Ld1
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Ld1
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r2 == 0) goto La9
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Ld1
            java.util.HashMap<java.lang.String, java.lang.Object[]> r3 = com.uc.crashsdk.a.q     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> L8d
            r4 = 0
            r5 = r3[r4]     // Catch: java.lang.Throwable -> L8d
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L8d
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L8d
            if (r13 != 0) goto L2f
            boolean r5 = com.uc.crashsdk.export.LogType.isForJava(r5)     // Catch: java.lang.Throwable -> L8d
            if (r5 != 0) goto L36
            goto L9
        L2f:
            boolean r5 = a(r13, r2)     // Catch: java.lang.Throwable -> L8d
            if (r5 != 0) goto L36
            goto L9
        L36:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r5.<init>()     // Catch: java.lang.Throwable -> L8d
            r5.append(r2)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = "\n"
            r5.append(r6)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L8d
            byte[] r5 = r5.getBytes(r11)     // Catch: java.lang.Throwable -> L8d
            r10.write(r5)     // Catch: java.lang.Throwable -> L8d
            r5 = 2
            r5 = r3[r5]     // Catch: java.lang.Throwable -> L8d
            java.lang.Long r5 = (java.lang.Long) r5     // Catch: java.lang.Throwable -> L8d
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L8d
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L6b
            r7 = 3
            r3 = r3[r7]     // Catch: java.lang.Throwable -> L8d
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L8d
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = com.uc.crashsdk.JNIBridge.nativeGetCallbackInfo(r2, r5, r3, r4)     // Catch: java.lang.Throwable -> L8d
            goto L73
        L6b:
            java.lang.StringBuilder r2 = b(r2, r4)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8d
        L73:
            if (r2 == 0) goto L83
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L8d
            if (r3 <= 0) goto L83
            byte[] r2 = r2.getBytes(r11)     // Catch: java.lang.Throwable -> L8d
            r10.write(r2)     // Catch: java.lang.Throwable -> L8d
            goto L91
        L83:
            java.lang.String r2 = "(data is null)\n"
            byte[] r2 = r2.getBytes(r11)     // Catch: java.lang.Throwable -> L8d
            r10.write(r2)     // Catch: java.lang.Throwable -> L8d
            goto L91
        L8d:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r10)     // Catch: java.lang.Throwable -> Ld1
        L91:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r11)     // Catch: java.lang.Throwable -> La3
            r10.write(r2)     // Catch: java.lang.Throwable -> La3
            byte[] r2 = r12.getBytes(r11)     // Catch: java.lang.Throwable -> La3
            r10.write(r2)     // Catch: java.lang.Throwable -> La3
            goto L9
        La3:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r10)     // Catch: java.lang.Throwable -> Ld1
            goto L9
        La9:
            if (r13 == 0) goto Lcf
            boolean r11 = com.uc.crashsdk.e.E()     // Catch: java.lang.Throwable -> Ld1
            if (r11 == 0) goto Lcf
            java.util.Iterator r11 = r13.iterator()     // Catch: java.lang.Throwable -> Ld1
        Lb5:
            boolean r12 = r11.hasNext()     // Catch: java.lang.Throwable -> Ld1
            if (r12 == 0) goto Lcf
            java.lang.Object r12 = r11.next()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> Ld1
            java.util.List<java.lang.String> r13 = com.uc.crashsdk.a.r     // Catch: java.lang.Throwable -> Ld1
            boolean r13 = a(r13, r12)     // Catch: java.lang.Throwable -> Ld1
            if (r13 != 0) goto Lb5
            java.lang.String r13 = "CUSTOMCALLBACKINFO"
            com.uc.crashsdk.e.a(r10, r13, r12)     // Catch: java.lang.Throwable -> Ld1
            goto Lb5
        Lcf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            return
        Ld1:
            r10 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld1
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, boolean z2) {
        String sb;
        HashMap<String, Object[]> hashMap = q;
        synchronized (hashMap) {
            Object[] objArr = hashMap.get(str);
            long longValue = ((Long) objArr[2]).longValue();
            if (longValue != 0) {
                sb = JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z2);
            } else {
                sb = b(str, z2).toString();
            }
        }
        return sb;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = y;
        synchronized (sparseArray) {
            int id = (int) thread.getId();
            if (sparseArray.get(id) == null) {
                z.add(Integer.valueOf(id));
            }
            sparseArray.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ca A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00c3, B:32:0x00ca, B:33:0x00d3, B:35:0x00d8, B:37:0x00dc, B:38:0x00e5), top: B:29:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:30:0x00c3, B:32:0x00ca, B:33:0x00d3, B:35:0x00d8, B:37:0x00dc, B:38:0x00e5), top: B:29:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    public static int a(String str, int i2, int i3) {
        int i4;
        int i5;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                i5 = ((Integer) hashMap.get(str)[1]).intValue();
                i4 = LogType.addType(i5, i3);
            } else {
                i4 = i3;
                i5 = 0;
            }
            if (LogType.isForJava(i4) && !LogType.isForJava(i5)) {
                int i6 = C;
                if (i6 >= 8) {
                    i4 = LogType.removeType(i4, 16);
                } else {
                    C = i6 + 1;
                }
            }
            if (LogType.isForNative(i4) && !LogType.isForNative(i5)) {
                int i7 = D;
                if (i7 >= 8) {
                    i4 = LogType.removeType(i4, 1);
                } else {
                    D = i7 + 1;
                }
            }
            if (LogType.isForANR(i4) && !LogType.isForANR(i5)) {
                int i8 = E;
                if (i8 >= 8) {
                    i4 = LogType.removeType(i4, LogType.ANR);
                } else {
                    E = i8 + 1;
                }
            }
            if ((1048849 & i4) == 0) {
                z2 = false;
            } else {
                if (i5 == 0) {
                    B.add(str);
                }
                z2 = true;
            }
            if (!z2) {
                return i4;
            }
            if (b.d && (i3 & 1048577) != 0) {
                int nativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, i4);
                if (!LogType.isForNative(nativeCreateCachedInfo)) {
                    i4 = LogType.removeType(i4, 1);
                }
                if (!LogType.isForANR(nativeCreateCachedInfo)) {
                    i4 = LogType.removeType(i4, LogType.ANR);
                }
            }
            hashMap.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), new ArrayList()});
            return i4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(int i2, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        int i3 = 0;
        i3 = 0;
        if (LogType.isForNative(i2) || LogType.isForANR(i2)) {
            if (b.d) {
                synchronized (y) {
                    JNIBridge.nativeCmd(4, i2, str, null);
                }
                boolean isForNative = LogType.isForNative(i2);
                i3 = isForNative;
                if (LogType.isForANR(i2)) {
                    i3 = (isForNative ? 1 : 0) | LogType.ANR;
                }
            } else {
                com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            }
        }
        if (!LogType.isForJava(i2)) {
            return i3;
        }
        a(str, Thread.currentThread());
        return i3 | 16;
    }

    public static boolean a(boolean z2) {
        int E2;
        if (!b.f999c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.E() || b.I()) {
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.f.a(F);
            E2 = 0;
        } else {
            if (!b.y()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.E() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            E2 = g.E() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, E2);
        return true;
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (b.d && f991c) {
                JNIBridge.nativeCmd(11, g.E(), String.valueOf(g.F()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i2 != 202) {
            if (!d) {
                throw new AssertionError();
            }
            return;
        }
        p();
        Locale locale = Locale.US;
        String format = String.format(locale, "%s/%s/%s", g.R(), g.S(), g.T());
        g = m();
        if (b.d) {
            JNIBridge.set(128, g);
        }
        boolean z2 = !format.equals(g);
        if (z2) {
            com.uc.crashsdk.a.b.a(b.j(), format);
        }
        if (z2 && g.u()) {
            com.uc.crashsdk.a.a.a("crashsdk", String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", g, format));
            b.s();
        }
    }
}
