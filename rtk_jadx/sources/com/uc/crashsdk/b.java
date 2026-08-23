package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static String G = null;
    private static int H = 0;
    private static boolean I = false;
    private static boolean J = false;
    private static boolean K = true;
    private static RandomAccessFile L = null;
    private static boolean M = false;
    private static String O = null;
    private static boolean P = false;
    private static volatile Object[] Q = null;
    public static boolean a = false;
    public static boolean b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f999c = false;
    public static boolean d = false;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    static final /* synthetic */ boolean i = true;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    private static String r = null;
    private static String s = null;
    private static String t = null;
    private static String u = null;
    private static String v = null;
    private static boolean w = false;
    private static boolean x = false;
    private static volatile boolean y = false;
    private static boolean z = false;
    public static final Object e = new Object();
    private static final Object F = new Object();
    private static final Object N = new Object();
    private static Runnable R = new com.uc.crashsdk.a.e(101);
    private static boolean S = false;
    private static long T = 0;
    private static final Object U = new Object();
    private static long V = 0;
    private static boolean W = false;
    private static boolean X = false;
    private static boolean Y = false;
    private static long Z = 0;
    private static final WeakHashMap<Activity, Integer> aa = new WeakHashMap<>();
    private static boolean ab = false;
    private static String ac = null;
    private static boolean ad = false;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static final Object ai = new Object();
    private static PendingIntent aj = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A() {
        String str;
        if (!d || (str = ac) == null) {
            return;
        }
        JNIBridge.set(129, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String B() {
        String str = ac;
        return str == null ? "" : str;
    }

    public static boolean C() {
        if (!ad) {
            if (!com.uc.crashsdk.a.g.a(a.a) && a.a.equals(e.h())) {
                ae = true;
                if (d) {
                    JNIBridge.set(2, true);
                }
            }
            ad = true;
        }
        return ae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void D() {
        af = true;
        if (d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean E() {
        return af;
    }

    public static int F() {
        boolean R2 = R();
        return q() ? R2 ? 3 : 6 : p() ? R2 ? 2 : 5 : R2 ? 4 : 1;
    }

    public static int G() {
        boolean S2 = S();
        boolean T2 = T();
        boolean U2 = U();
        if (q()) {
            if (S2) {
                return 12;
            }
            if (T2) {
                return 14;
            }
            return U2 ? 16 : 98;
        }
        if (!p()) {
            return 1;
        }
        if (S2) {
            return 11;
        }
        if (T2) {
            return 13;
        }
        return U2 ? 15 : 97;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void H() {
        if (d) {
            JNIBridge.nativeSet(27, H, "12", null);
            JNIBridge.set(30, K);
        }
    }

    public static boolean I() {
        if (!ah) {
            synchronized (ai) {
                if (!ah) {
                    ag = ab();
                    ah = true;
                }
            }
        }
        return ag;
    }

    public static void J() {
        if (e.E() || I() || aj != null || g.h() < 0) {
            return;
        }
        try {
            Context a2 = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            aj = PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K() {
        if (aj == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, aj);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean L() {
        ab = true;
        return true;
    }

    private static String N() {
        if (j == null) {
            j = c("ss");
        }
        return j;
    }

    private static String O() {
        if (l == null) {
            l = c("ctn");
        }
        return l;
    }

    private static String P() {
        if (m == null) {
            m = c("cta");
        }
        return m;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:13|(9:17|18|(1:24)|25|26|(1:28)|30|31|32)|35|18|(2:20|24)|25|26|(0)|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #0 {all -> 0x0075, blocks: (B:26:0x006b, B:28:0x0071), top: B:25:0x006b, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void Q() {
        /*
            boolean r0 = com.uc.crashsdk.b.y
            if (r0 != 0) goto L80
            boolean r0 = com.uc.crashsdk.b.x
            if (r0 == 0) goto La
            goto L80
        La:
            java.lang.Object r0 = com.uc.crashsdk.b.F
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.b.y     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7d
            return
        L13:
            java.lang.String r1 = com.uc.crashsdk.g.U()     // Catch: java.lang.Throwable -> L7d
            d(r1)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r1 = m()     // Catch: java.lang.Throwable -> L7d
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7d
            java.lang.String r3 = b()     // Catch: java.lang.Throwable -> L7d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L7d
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L7d
            java.lang.String r4 = O()     // Catch: java.lang.Throwable -> L7d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r4 = "f"
            boolean r4 = r4.equals(r1)     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.z = r4     // Catch: java.lang.Throwable -> L7d
            java.lang.String r4 = "b"
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.A = r1     // Catch: java.lang.Throwable -> L7d
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.C = r1     // Catch: java.lang.Throwable -> L7d
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.D = r1     // Catch: java.lang.Throwable -> L7d
            boolean r2 = com.uc.crashsdk.b.C     // Catch: java.lang.Throwable -> L7d
            r3 = 1
            if (r2 != 0) goto L56
            if (r1 == 0) goto L54
            goto L56
        L54:
            r1 = 0
            goto L57
        L56:
            r1 = 1
        L57:
            com.uc.crashsdk.b.B = r1     // Catch: java.lang.Throwable -> L7d
            if (r1 != 0) goto L6b
            boolean r1 = com.uc.crashsdk.b.z     // Catch: java.lang.Throwable -> L7d
            if (r1 != 0) goto L63
            boolean r1 = com.uc.crashsdk.b.A     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L6b
        L63:
            boolean r1 = o()     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.E = r1     // Catch: java.lang.Throwable -> L7d
            com.uc.crashsdk.b.B = r1     // Catch: java.lang.Throwable -> L7d
        L6b:
            boolean r1 = w()     // Catch: java.lang.Throwable -> L75
            if (r1 == 0) goto L79
            W()     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r1 = move-exception
            com.uc.crashsdk.a.g.a(r1)     // Catch: java.lang.Throwable -> L7d
        L79:
            com.uc.crashsdk.b.y = r3     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7d
            return
        L7d:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7d
            throw r1
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.Q():void");
    }

    private static boolean R() {
        Q();
        return B;
    }

    private static boolean S() {
        Q();
        return C;
    }

    private static boolean T() {
        Q();
        return D;
    }

    private static boolean U() {
        Q();
        return E;
    }

    private static void V() {
        if (d) {
            JNIBridge.set(26, w);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0041 -> B:13:0x0044). Please report as a decompilation issue!!! */
    private static void W() {
        if (!S) {
            S = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            try {
                new File(O()).delete();
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                if (d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(P()).delete();
                }
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
        }
        Object[] Y2 = Y();
        if (!Y2[0].equals(O) && Q == null) {
            a(Y2);
        } else {
            P = true;
            X();
        }
    }

    private static void X() {
        if (!com.uc.crashsdk.a.f.b(R)) {
            com.uc.crashsdk.a.f.a(1, R);
            return;
        }
        Object[] objArr = Q;
        if (objArr == null || !Y()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(R);
            com.uc.crashsdk.a.f.a(1, R);
        }
    }

    private static Object[] Y() {
        synchronized (U) {
            long j2 = V + 1;
            V = j2;
            if (w) {
                return new Object[]{"e", Long.valueOf(j2)};
            }
            if (y()) {
                return new Object[]{"f", Long.valueOf(V)};
            }
            return new Object[]{"b", Long.valueOf(V)};
        }
    }

    private static Object Z() {
        Method declaredMethod;
        Object a2;
        Object a3 = a((Application) com.uc.crashsdk.a.g.a(), (Class<?>) Application.class, "mLoadedApk");
        if (a3 != null && (a2 = a(a3, (Class<?>) null, "mActivityThread")) != null) {
            return a2;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        String str = G;
        if (str != null) {
            return str;
        }
        String h2 = e.h();
        if (com.uc.crashsdk.a.g.a(h2)) {
            G = "LLUN";
        } else {
            int i2 = 0;
            if (h2.length() > 48) {
                int length = h2.length() - 48;
                h2 = h2.substring(0, 48);
                i2 = length;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = h2.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b2 = bytes[length2];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 >= 48 && b2 <= 57) {
                    sb.append((char) b2);
                } else {
                    sb.append('2');
                }
            }
            if (i2 > 0) {
                sb.append(String.valueOf(i2));
            }
            G = sb.toString();
        }
        return G;
    }

    private static boolean aa() {
        String a2 = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), 512, false);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        return a2.contains("/bg_non_interactive") || a2.contains("/background");
    }

    private static boolean ab() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    private static String c(String str) {
        return g.U() + a() + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        if (u == null) {
            u = c("bati");
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e() {
        if (v == null) {
            v = c("hdr");
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        if (p == null) {
            p = g.U() + "up";
        }
        return p;
    }

    public static String g() {
        if (q == null) {
            q = g.U() + "authu";
        }
        return q;
    }

    public static String h() {
        if (r == null) {
            r = g.U() + "statu";
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        if (s == null) {
            s = g.U() + "poli";
        }
        return s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j() {
        if (t == null) {
            t = g.U() + "ver";
        }
        return t;
    }

    public static String k() {
        return g.U() + "bvu";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l() {
        return g.U() + "fds";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        return com.uc.crashsdk.a.g.a(new File(N()), 8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n() {
        return x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o() {
        if (!I) {
            if (d) {
                J = JNIBridge.cmd(15) == 1;
            } else {
                J = new File(P()).exists();
            }
            I = true;
        }
        return J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p() {
        Q();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q() {
        Q();
        return A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        return w;
    }

    public static void s() {
        boolean z2;
        d(g.U());
        x = true;
        z = false;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {"up", "authu", "statu", "poli"};
        File[] listFiles = new File(g.U()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 7) {
                        z2 = false;
                        break;
                    } else {
                        if (name.endsWith(strArr[i2])) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        }
                        if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                }
                if (z2) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        W();
    }

    public static void t() {
        if (w) {
            return;
        }
        w = true;
        if (I() || e.t()) {
            return;
        }
        d(g.U());
        V();
        W();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u() {
        return d(g.U());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v() {
        return d(g.V());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w() {
        return W || !aa();
    }

    public static boolean x() {
        return X || !aa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y() {
        return X && !w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void z() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        if (k == null) {
            k = c("ctj");
        }
        return k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        if (n == null) {
            n = c("st");
        }
        return n;
    }

    private static boolean d(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static void b(boolean z2) {
        if (e.t()) {
            return;
        }
        if (z2 && w) {
            if (g.M()) {
                Log.v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            w = false;
            V();
        }
        boolean z3 = e.E() || I();
        long currentTimeMillis = System.currentTimeMillis();
        if (W && !X && z2) {
            long j2 = Z;
            if (j2 != 0 && !z3 && currentTimeMillis - j2 > 1800000) {
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
            }
        }
        Z = currentTimeMillis;
        X = z2;
        if (z2) {
            W = true;
        }
        if (d) {
            JNIBridge.nativeSetForeground(z2);
        }
        if (w || z3) {
            return;
        }
        Q();
        W();
        if (z2) {
            a.a(false);
            if (!Y) {
                e.A();
                Y = true;
            }
        }
        if (!M) {
            X();
        }
        e.c(z2);
    }

    public static boolean c(int i2) {
        return (i2 & H) != 0;
    }

    public static void a(boolean z2) {
        K = z2;
        if (d) {
            JNIBridge.set(30, z2);
        }
    }

    public static String a(String str) {
        return "debug.crs." + str;
    }

    private static void a(Object[] objArr) {
        Q = objArr;
        synchronized (N) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < T) {
                com.uc.crashsdk.a.a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(T)));
                return;
            }
            T = longValue;
            String N2 = N();
            if (d) {
                RandomAccessFile randomAccessFile = L;
                if (randomAccessFile != null) {
                    com.uc.crashsdk.a.g.a(randomAccessFile);
                    L = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(N2, str, M);
                M = false;
                if (!nativeChangeState) {
                    com.uc.crashsdk.a.a.b("write state failed: " + str);
                }
            } else {
                RandomAccessFile randomAccessFile2 = L;
                if (randomAccessFile2 == null || M) {
                    if (randomAccessFile2 != null) {
                        com.uc.crashsdk.a.g.a(randomAccessFile2);
                        L = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(N2, "rw");
                        L = randomAccessFile3;
                        randomAccessFile3.seek(0L);
                        M = false;
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                try {
                    L.write(str.getBytes());
                    L.seek(0L);
                } catch (Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            O = str;
            Q = null;
        }
    }

    public static void b(int i2) {
        H = i2;
        H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        com.uc.crashsdk.a.a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (o == null) {
            o = c("rt");
        }
        File file = new File(o);
        long j2 = -1;
        try {
            j2 = Long.parseLong(com.uc.crashsdk.a.g.d(file));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        boolean z2 = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (g.h() >= 0 && (j2 <= 0 || currentTimeMillis - j2 > g.h())) {
            d(g.U());
            com.uc.crashsdk.a.g.a(file, String.valueOf(currentTimeMillis));
            z2 = true;
        }
        com.uc.crashsdk.a.a.a("lastTime: " + j2 + ", currentTime: " + currentTimeMillis + ", needRestart: " + z2);
        if (z2) {
            try {
                d.a(true);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            K();
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (!g.J()) {
                return true;
            }
            z();
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void a(int i2) {
        Object a2;
        Activity activity;
        int i3;
        boolean z2 = false;
        boolean z3 = true;
        switch (i2) {
            case 100:
                Object Z2 = Z();
                if (Z2 == null || (a2 = a(Z2, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    Iterator it = ((Map) a2).entrySet().iterator();
                    boolean z4 = false;
                    while (it.hasNext()) {
                        Object value = ((Map.Entry) it.next()).getValue();
                        if (value != null && (activity = (Activity) a(value, (Class<?>) null, "activity")) != null) {
                            boolean booleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                            boolean booleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                            WeakHashMap<Activity, Integer> weakHashMap = aa;
                            synchronized (weakHashMap) {
                                if (booleanValue || booleanValue2) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                    z4 = true;
                                }
                                weakHashMap.put(activity, Integer.valueOf(i3));
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        b(z4);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 101:
                try {
                    if (new File(N()).exists()) {
                        z3 = false;
                    }
                    M = z3;
                    if (z3 || P) {
                        a(Y());
                        P = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new File(P()));
                    return;
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (C()) {
                    e.B();
                    return;
                }
                return;
            default:
                if (!i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) {
        FileChannel fileChannel;
        boolean z2;
        synchronized (obj) {
            FileChannel fileChannel2 = null;
            r1 = null;
            FileLock lock = null;
            FileChannel fileChannel3 = null;
            boolean z3 = false;
            if (d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                try {
                    boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                    try {
                        z2 = eVar.a();
                        return z2;
                    } finally {
                        if (nativeLockFile) {
                            JNIBridge.nativeLockFile(nativeOpenFile, false);
                        }
                    }
                } finally {
                    JNIBridge.nativeCloseFile(nativeOpenFile);
                }
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            try {
                try {
                    fileChannel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Throwable th) {
                    th = th;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            } catch (Exception e3) {
                try {
                    com.uc.crashsdk.a.g.a(e3);
                    fileChannel = null;
                } catch (Exception e4) {
                    e = e4;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    z2 = z3;
                    return z2;
                }
            }
            if (fileChannel != null) {
                try {
                    try {
                        lock = fileChannel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            fileChannel2 = fileChannel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel2);
                            z2 = z3;
                            return z2;
                        }
                    }
                } catch (Throwable th2) {
                    fileChannel3 = fileChannel;
                    th = th2;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            }
            try {
                z3 = eVar.a();
                com.uc.crashsdk.a.g.a(fileChannel);
                z2 = z3;
                return z2;
            } finally {
                if (lock != null) {
                    try {
                        lock.release();
                    } catch (Exception e7) {
                        com.uc.crashsdk.a.g.a(e7);
                    }
                }
            }
        }
    }
}
