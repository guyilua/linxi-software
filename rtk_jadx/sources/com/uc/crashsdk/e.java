package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e implements Thread.UncaughtExceptionHandler {
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();
    static final /* synthetic */ boolean a = true;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f1001c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final Object o = new Object();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final ArrayList<String> r = new ArrayList<>();
    private static int s = 0;
    private static String t = null;
    private static boolean u = false;
    private static String v = null;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static boolean ac = false;
    private static ParcelFileDescriptor ad = null;
    private static boolean ae = false;
    private static boolean af = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class b implements Comparator<File> {
        private b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int unused = e.C = intent.getIntExtra("level", -1);
                int unused2 = e.D = intent.getIntExtra("scale", -1);
                int unused3 = e.E = intent.getIntExtra("voltage", -1);
                int unused4 = e.F = intent.getIntExtra("health", -1);
                int unused5 = e.G = intent.getIntExtra("plugged", -1);
                int unused6 = e.H = intent.getIntExtra("status", -1);
                int unused7 = e.I = intent.getIntExtra("temperature", -1);
                String unused8 = e.J = intent.getStringExtra("technology");
                if (e.I() >= 2) {
                    e.J();
                    e.K();
                    return;
                }
                return;
            }
            if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                boolean unused9 = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                e.J();
            } else if ("android.intent.action.ANR".equals(action)) {
                try {
                    e.d(context);
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                }
            }
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    public e() {
        try {
            L();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (ac || com.uc.crashsdk.b.I()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void B() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE), 7000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x003f, code lost:
    
        if ((java.lang.System.currentTimeMillis() % 3) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (r0 == 1) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void C() {
        /*
            int r0 = com.uc.crashsdk.g.L()
            r1 = 4
            r2 = 3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L13
            if (r0 == r2) goto L13
            if (r0 != r1) goto Lf
            goto L13
        Lf:
            if (r0 != r3) goto L43
        L11:
            r3 = 0
            goto L43
        L13:
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 < r6) goto L43
            r6 = 25
            if (r5 > r6) goto L43
            if (r0 != 0) goto L21
            r5 = 0
            goto L22
        L21:
            r5 = 1
        L22:
            r6 = 0
            if (r0 != r2) goto L34
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 10
            long r8 = r8 % r10
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L33
            r5 = 1
            goto L34
        L33:
            r5 = 0
        L34:
            if (r0 != r1) goto L42
            long r0 = java.lang.System.currentTimeMillis()
            r8 = 3
            long r0 = r0 % r8
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L11
            goto L43
        L42:
            r3 = r5
        L43:
            if (r3 != 0) goto L4c
            java.lang.String r0 = "crashsdk"
            java.lang.String r1 = "SIG 3 is disabled by settings"
            com.uc.crashsdk.a.a.a(r0, r1)
        L4c:
            boolean r0 = com.uc.crashsdk.b.I()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 == r2) goto L68
            if (r3 == 0) goto L68
            r1 = 2
            com.uc.crashsdk.a.e r2 = new com.uc.crashsdk.a.e
            r3 = 413(0x19d, float:5.79E-43)
            r2.<init>(r3)
            com.uc.crashsdk.a.f.a(r1, r2)
            goto L69
        L68:
            r4 = r3
        L69:
            r1 = 7
            long r2 = (long) r0
            r0 = 0
            com.uc.crashsdk.JNIBridge.nativeCmd(r1, r2, r0, r0)
            if (r4 == 0) goto L76
            r0 = 8
            com.uc.crashsdk.JNIBridge.cmd(r0)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.C():void");
    }

    public static ParcelFileDescriptor D() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        ParcelFileDescriptor parcelFileDescriptor = ad;
        if (parcelFileDescriptor != null) {
            return parcelFileDescriptor;
        }
        int cmd = (int) JNIBridge.cmd(14);
        if (cmd == -1) {
            return null;
        }
        ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
        ad = adoptFd;
        ae = true;
        return adoptFd;
    }

    public static boolean E() {
        return af;
    }

    public static void F() {
        String V2 = g.V();
        File file = new File(V2);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + V2);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    static /* synthetic */ boolean H() {
        return N();
    }

    static /* synthetic */ int I() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    static /* synthetic */ void J() {
        StringBuilder X2;
        if (com.uc.crashsdk.b.d && (X2 = X()) != null) {
            JNIBridge.set(125, X2.toString());
        }
        L = true;
        Y();
    }

    static /* synthetic */ int K() {
        M = 0;
        return 0;
    }

    private void L() {
        int G2 = g.G();
        for (int i2 = 0; i2 < G2; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private void M() {
        Iterator<FileInputStream> it = this.e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.e.clear();
    }

    private static boolean N() {
        if (g.N()) {
            return true;
        }
        return a();
    }

    private static String O() {
        return g.e() + "_";
    }

    private static String P() {
        return com.uc.crashsdk.b.y() ? "fg" : "bg";
    }

    private static byte[] Q() {
        byte[] bArr = null;
        int i2 = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String R() {
        return (!com.uc.crashsdk.b.C() || d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    private static void S() {
        String str;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String str2 = "-";
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            str = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(":") + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            k = str;
                            l = str2;
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = str;
        l = str2;
    }

    private static String T() {
        return g.U() + "bytes";
    }

    private static boolean U() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void V() {
        if (O || com.uc.crashsdk.b.C() || com.uc.crashsdk.b.I()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void W() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(TbsListener.ErrorCode.INFO_SDKINIT_IS_SYS_FORCED), 1000L);
    }

    private static StringBuilder X() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("scale: ");
            sb.append(D);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            int i2 = G;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            int i3 = H;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("voltage: ");
            sb.append(E);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("temperature: ");
            sb.append(I);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("technology: ");
            sb.append(J);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append("battery low: ");
            sb.append(K);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Y() {
        if (com.uc.crashsdk.b.f999c && L && com.uc.crashsdk.a.f991c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    private static boolean Z() {
        return com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing();
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (g(com.uc.crashsdk.b.a("logs")) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    private static void aa() {
        String W2 = g.W();
        File file = new File(W2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new b((byte) 0));
                    int length = listFiles.length - 150;
                    int i2 = length < 0 ? 0 : length;
                    long currentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < listFiles.length) {
                        File file2 = listFiles[i3];
                        boolean z2 = i3 < i2;
                        if (!z2 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i4++;
                            i5 = 0;
                        } catch (Throwable th) {
                            i5++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i5 >= 3) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i4 + " logs in " + W2);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b() {
        if (g == -1) {
            g = g(com.uc.crashsdk.b.a("local"));
        }
        return g;
    }

    public static String d(boolean z2) {
        return z2 ? "https://errlogos.umeng.com/upload" : "https://errlog.umeng.com/upload";
    }

    private static String j(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), m(), P(), str);
    }

    private static String k(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int indexOf = str.indexOf(0);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    private static String l(String str) {
        String a2 = com.uc.crashsdk.a.b.a(str, g.w(), g.v());
        if (!str.equals(a2)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r7.endsWith(r3) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        if (r7.indexOf(".log", r7.lastIndexOf(95)) != r7.lastIndexOf(".log")) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean[] m(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.g.v()
            boolean r1 = com.uc.crashsdk.g.x()
            r2 = 0
            if (r0 != 0) goto Ld
            if (r1 == 0) goto L6d
        Ld:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L6b
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L1e
            goto L6b
        L1e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L27
            r3 = 0
        L27:
            r4 = 0
        L28:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L34
            int r4 = r4 + 1
            int r3 = r3 + 1
        L34:
            if (r3 >= 0) goto L28
            r3 = 8
            if (r4 == r3) goto L3b
            goto L6b
        L3b:
            java.lang.String r3 = com.uc.crashsdk.g.w()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L54
            boolean r0 = com.uc.crashsdk.a.g.a(r3)
            if (r0 != 0) goto L6b
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L5a
            goto L6b
        L54:
            boolean r3 = com.uc.crashsdk.a.g.a(r3)
            if (r3 == 0) goto L5c
        L5a:
            r0 = 0
            goto L6d
        L5c:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L6d
            goto L5a
        L6b:
            r0 = 0
            r1 = 0
        L6d:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.m(java.lang.String):boolean[]");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|4|(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|54|(0)|25|26|27|29|30|31|32) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:6|(3:9|(1:11)(17:12|13|14|(13:48|49|18|(1:47)(1:21)|22|(1:24)|25|26|27|29|30|31|32)(1:16)|17|18|(0)|47|22|(0)|25|26|27|29|30|31|32)|7)|53)|26|27|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00dc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00dd, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e2, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e5, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        r1 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ed, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:6:0x0033, B:7:0x0041, B:9:0x0047, B:11:0x0051, B:13:0x0056, B:49:0x0068, B:18:0x0078, B:22:0x0083, B:24:0x00ae, B:31:0x00d5, B:32:0x00e8, B:43:0x00ea, B:44:0x00ed, B:39:0x00e5, B:52:0x0072), top: B:3:0x0005, inners: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean n(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ae A[Catch: all -> 0x0106, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d3, B:23:0x00ee, B:24:0x00de, B:37:0x00fa, B:40:0x0104, B:44:0x0033, B:46:0x003b, B:47:0x0044, B:49:0x004c, B:51:0x0054, B:53:0x005c, B:58:0x006a, B:60:0x0074, B:62:0x0081, B:64:0x008b, B:65:0x0096, B:67:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a0 A[Catch: all -> 0x0106, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:12:0x00ae, B:17:0x00d3, B:23:0x00ee, B:24:0x00de, B:37:0x00fa, B:40:0x0104, B:44:0x0033, B:46:0x003b, B:47:0x0044, B:49:0x004c, B:51:0x0054, B:53:0x005c, B:58:0x006a, B:60:0x0074, B:62:0x0081, B:64:0x008b, B:65:0x0096, B:67:0x00a0), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean o(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    private static Map<String, Integer> p(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] split = str2.split(":", 3);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!com.uc.crashsdk.a.g.a(trim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(split[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i2));
                }
            }
        }
        return hashMap;
    }

    private static void q(String str) {
        if (g.q()) {
            try {
                aa();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.W());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String r(String str) {
        return String.format("$^%s^$", str);
    }

    public static void s() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t() {
        return f1001c.get() || Z();
    }

    public static Throwable u() {
        return U;
    }

    public static int v() {
        if (com.uc.crashsdk.b.F() == 5) {
            return Z;
        }
        return 100;
    }

    public static void w() {
        long o2 = g.o();
        if (o2 < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.F() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, o2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void x() {
        if (com.uc.crashsdk.b.f999c && com.uc.crashsdk.a.f991c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean y() {
        synchronized (Y) {
            Runnable runnable = X;
            if (runnable == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(runnable);
            X = null;
            return true;
        }
    }

    public static void z() {
        if (g.q()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), 10000L);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String i2 = i((String) null);
        i = i2;
        return i2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:30|(2:32|33)|34|35|36|(1:40)|41|(1:45)|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0141, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0142, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad A[Catch: all -> 0x00d1, TRY_LEAVE, TryCatch #1 {all -> 0x00d1, blocks: (B:28:0x0098, B:30:0x00ad), top: B:27:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:36:0x00d8, B:38:0x00de, B:40:0x00e6, B:41:0x010c, B:43:0x0112, B:45:0x011a), top: B:35:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:36:0x00d8, B:38:0x00de, B:40:0x00e6, B:41:0x010c, B:43:0x0112, B:45:0x011a), top: B:35:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    private static long g(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    private static String h(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String i(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", O(), g.R(), g.T(), h(Build.MODEL), h(Build.VERSION.RELEASE), str);
    }

    public static void r() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        i = null;
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String a2 = a(Process.myPid());
        m = a2;
        return a2;
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        }
        if (i2 != 452) {
            if (a) {
                return false;
            }
            throw new AssertionError();
        }
        if (!a && objArr == null) {
            throw new AssertionError();
        }
        String str = (String) objArr[0];
        d dVar = (d) objArr[1];
        return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.a), Long.valueOf(dVar.b), Integer.valueOf(dVar.f1003c), Integer.valueOf(dVar.d)).getBytes());
    }

    private static void c(OutputStream outputStream) {
        if (com.uc.crashsdk.b.d) {
            String l2 = com.uc.crashsdk.b.l();
            h = false;
            if (1 == JNIBridge.cmd(17, l2)) {
                File file = new File(l2);
                try {
                    byte[] e = com.uc.crashsdk.a.g.e(file);
                    if (e != null) {
                        outputStream.write(e);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        File[] fileArr = null;
        int i2 = TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
        try {
            i2 = g.H();
            fileArr = new File("/proc/self/fd").listFiles();
            if (fileArr != null) {
                outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), Integer.valueOf(i2)).getBytes("UTF-8"));
            } else {
                outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        if (fileArr != null) {
            try {
                if (fileArr.length >= i2) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArr) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                        }
                    } catch (Throwable th4) {
                        a(th4, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th5) {
                a(th5, outputStream);
            }
        }
        a(outputStream);
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(k)) {
            S();
        }
        return k;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void d(java.io.OutputStream r12) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = 0
            int r3 = com.uc.crashsdk.g.I()     // Catch: java.lang.Throwable -> L1c
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "/proc/self/task"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1a
            java.io.File[] r2 = r4.listFiles()     // Catch: java.lang.Throwable -> L1a
            if (r2 != 0) goto L16
            return
        L16:
            int r4 = r2.length     // Catch: java.lang.Throwable -> L1a
            if (r4 >= r3) goto L23
            return
        L1a:
            r4 = move-exception
            goto L1f
        L1c:
            r4 = move-exception
            r3 = 300(0x12c, float:4.2E-43)
        L1f:
            com.uc.crashsdk.a.g.a(r4)
            r4 = 0
        L23:
            if (r2 != 0) goto L26
            return
        L26:
            java.lang.String r5 = "threads info:\n"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r5)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = "threads count: %d, dump limit: %d.\n"
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L8e
            r8[r1] = r4     // Catch: java.lang.Throwable -> L8e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L8e
            r4 = 1
            r8[r4] = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = java.lang.String.format(r5, r6, r8)     // Catch: java.lang.Throwable -> L8e
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = " tid     name\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r3)     // Catch: java.lang.Throwable -> L8e
            int r3 = r2.length     // Catch: java.lang.Throwable -> L8e
            r5 = 0
        L59:
            if (r5 >= r3) goto L92
            r6 = r2[r5]     // Catch: java.lang.Throwable -> L8e
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L8e
            java.lang.String r9 = r6.getPath()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "comm"
            r8.<init>(r9, r10)     // Catch: java.lang.Throwable -> L8e
            r9 = 128(0x80, float:1.8E-43)
            java.lang.String r8 = com.uc.crashsdk.a.g.a(r8, r9, r1)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r8 = k(r8)     // Catch: java.lang.Throwable -> L8e
            java.util.Locale r9 = java.util.Locale.US     // Catch: java.lang.Throwable -> L8e
            java.lang.String r10 = "%5s %s\n"
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> L8e
            r11[r1] = r6     // Catch: java.lang.Throwable -> L8e
            r11[r4] = r8     // Catch: java.lang.Throwable -> L8e
            java.lang.String r6 = java.lang.String.format(r9, r10, r11)     // Catch: java.lang.Throwable -> L8e
            byte[] r6 = r6.getBytes(r0)     // Catch: java.lang.Throwable -> L8e
            r12.write(r6)     // Catch: java.lang.Throwable -> L8e
            int r5 = r5 + 1
            goto L59
        L8e:
            r0 = move-exception
            a(r0, r12)
        L92:
            a(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.d(java.io.OutputStream):void");
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static String k() {
        if (com.uc.crashsdk.a.g.a(w)) {
            synchronized (y) {
                w = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.f(), x, true);
            }
        }
        return w;
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.F() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.f991c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Y();
                x();
                return;
            case 402:
                Object obj = Y;
                synchronized (obj) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.n()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.d()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!c(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.o(), g.p());
                    if (nativeGenerateUnexpLog != 0) {
                        f.a(11);
                        if ((nativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i3 = 30;
                        } else if ((nativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i3 = 31;
                        } else if ((nativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                            Z = 106;
                            i3 = 32;
                        } else {
                            if ((nativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                Z = 103;
                                f.a(10);
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                Z = 107;
                                f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        f.a(i3);
                        a(true);
                    }
                    synchronized (obj) {
                        X = null;
                    }
                    return;
                }
            case 403:
                aa();
                return;
            case 404:
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder X2 = X();
                String d2 = com.uc.crashsdk.b.d();
                if (X2 != null) {
                    com.uc.crashsdk.a.g.a(new File(d2), X2.toString());
                    return;
                }
                return;
            case 406:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case TbsListener.ErrorCode.INFO_CAN_NOT_DISABLED_BY_CRASH /* 408 */:
                synchronized (ab) {
                    if (!ac && g.O() && com.uc.crashsdk.b.w()) {
                        com.uc.crashsdk.b.p();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.C()) {
                            B();
                        }
                        if (g.O()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE /* 409 */:
                b(false, false);
                return;
            case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE /* 410 */:
                a(false, true);
                return;
            case TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_FINAL_REASON /* 411 */:
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(28, c(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, c(LogType.ANR_TYPE));
                    return;
                }
                return;
            case TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX /* 412 */:
                if (!R && com.uc.crashsdk.b.y() && g.K()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.y() && g.K()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case TbsListener.ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX /* 413 */:
                JNIBridge.cmd(8);
                return;
            case TbsListener.ErrorCode.INFO_SDKINIT_IS_SYS_FORCED /* 414 */:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        W();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case TbsListener.ErrorCode.INFO_INITX5_FALSE_DEFAULT /* 415 */:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                long longValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= longValue) {
                    h.g();
                    f.a(100);
                    b(true, true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
            case 416:
                break;
        }
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a extends OutputStream {
        private final long a;
        private final OutputStream b;

        /* renamed from: c, reason: collision with root package name */
        private int f1002c = 0;
        private int d = 0;
        private boolean e = false;

        a(long j, OutputStream outputStream) {
            this.a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int a(byte[] r7, int r8, int r9) {
            /*
                r6 = this;
                int r0 = r6.d
                int r0 = r0 + r9
                r6.d = r0
                boolean r0 = r6.e
                if (r0 == 0) goto Lb
                r7 = 0
                return r7
            Lb:
                int r0 = com.uc.crashsdk.g.y()
                if (r0 <= 0) goto L19
                int r1 = r6.f1002c
                int r2 = r1 + r9
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r9
            L1a:
                int r1 = r6.f1002c
                int r1 = r1 + r0
                r6.f1002c = r1
                long r1 = r6.a
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r7, r8, r0)
                r6.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r6.b
                r1.write(r7, r8, r0)
            L35:
                if (r0 >= r9) goto L3a
                r7 = 1
                r6.e = r7
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientWriteData(this.a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (e.h && e.H()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.f1002c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (e.h && e.H()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        final void a() {
            try {
                if (this.d - this.f1002c > 0) {
                    a(UMCustomLogInfoBuilder.LINE_SEP);
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.f1002c), Integer.valueOf(g.y()), Integer.valueOf(this.d - this.f1002c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (e.h && e.H() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        final void a(String str) {
            if (e.h && e.H()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }
    }

    private static void f(OutputStream outputStream) {
        String m2;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (af) {
                m2 = r("LASTVER");
            } else {
                m2 = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", m2).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = r;
            synchronized (arrayList) {
                if (t != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", t).getBytes("UTF-8"));
                }
                if (s > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(s)).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", Boolean.valueOf(u)).getBytes("UTF-8"));
            String str = v;
            if (str != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", str).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProGuard */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class d {
        long a;
        long b;

        /* renamed from: c, reason: collision with root package name */
        int f1003c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.a = 0L;
            this.b = 0L;
            this.f1003c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    public static void l() {
        if (af) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_FINAL_REASON), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return d;
    }

    public static void o() {
        String str;
        Throwable th;
        if (com.uc.crashsdk.a.g.a(B)) {
            String str2 = null;
            try {
                File file = new File(g.U() + "unique");
                if (file.exists()) {
                    str = com.uc.crashsdk.a.g.a(file, 48, false);
                    try {
                        if (str != null) {
                            try {
                                if (str.length() == 36) {
                                    str2 = str.replaceAll("[^0-9a-zA-Z-]", "-");
                                }
                            } catch (Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                            }
                        }
                        str2 = str;
                    } catch (Throwable th2) {
                        th = th2;
                        com.uc.crashsdk.a.g.a(th);
                        str2 = str;
                        B = str2;
                    }
                }
                if (com.uc.crashsdk.a.g.a(str2)) {
                    com.uc.crashsdk.b.D();
                    str2 = UUID.randomUUID().toString();
                    if (!com.uc.crashsdk.a.g.a(str2)) {
                        com.uc.crashsdk.a.g.a(file, str2.getBytes());
                    }
                }
            } catch (Throwable th3) {
                str = str2;
                th = th3;
            }
            B = str2;
        }
    }

    public static String p() {
        return B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q() {
        O = false;
        if (!com.uc.crashsdk.b.y()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (U()) {
            return;
        }
        N = 0;
        W();
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        String str4;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), m()).getBytes("UTF-8"));
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                S();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.y() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.R(), g.S(), g.T(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str5 = "0";
            String str6 = "";
            if (com.uc.crashsdk.b.d) {
                String nativeGet = JNIBridge.nativeGet(1, 0L, null);
                str4 = JNIBridge.nativeGet(2, 0L, null);
                str5 = nativeGet;
            } else {
                str4 = "";
            }
            outputStream.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.2.0.4", str5, "210105150455", str4, "release").getBytes("UTF-8"));
            if (str != null) {
                str6 = str;
            }
            outputStream.write(("Report Name: " + str6.substring(str6.lastIndexOf(47) + 1) + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (af) {
                str3 = r("UUID");
            } else {
                str3 = B;
            }
            outputStream.write(String.format("UUID: %s\n", str3).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String B2 = com.uc.crashsdk.b.B();
            if (com.uc.crashsdk.a.g.a(B2)) {
                B2 = "(none)";
            }
            outputStream.write(("Activity: " + B2 + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (af) {
                h = false;
                outputStream.write(r("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        return a(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == myPid) {
                O = true;
                if (N()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && com.uc.crashsdk.b.d) {
            V();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(boolean z2) {
        File[] listFiles;
        try {
            if (com.uc.crashsdk.b.v() && (listFiles = new File(g.V()).listFiles()) != null) {
                int l2 = g.l();
                int m2 = g.m();
                if (listFiles.length < Math.min(l2, m2)) {
                    return;
                }
                Object[] objArr = 0;
                int i2 = 0;
                int i3 = 0;
                for (File file : listFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < l2) ? 0 : (i2 - l2) + 1;
                int i5 = (z2 || i3 < m2) ? 0 : (i3 - m2) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(listFiles, new b(objArr == true ? 1 : 0));
                int i6 = i4;
                int i7 = i5;
                for (File file2 : listFiles) {
                    boolean b2 = b(file2);
                    if (b2 && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    } else if (!b2 && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void n() {
        b = System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void e(java.io.OutputStream r11) {
        /*
            java.lang.String r0 = "UTF-8"
            boolean r1 = com.uc.crashsdk.b.d
            if (r1 != 0) goto L7
            return
        L7:
            java.lang.String r1 = "solib build id:\n"
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> L11
            r11.write(r1)     // Catch: java.lang.Throwable -> L11
            goto L15
        L11:
            r1 = move-exception
            a(r1, r11)
        L15:
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lc3
            r2.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> Lc3
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r5 = "/proc/self/maps"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lc3
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lc3
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lbf
            r5 = 512(0x200, float:7.17E-43)
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> Lbf
        L2e:
            java.lang.String r1 = r4.readLine()     // Catch: java.lang.Throwable -> Lbd
            if (r1 == 0) goto Lb9
            java.lang.String r5 = ".so"
            boolean r5 = r1.endsWith(r5)     // Catch: java.lang.Throwable -> Lbd
            if (r5 == 0) goto L2e
            r5 = 47
            int r5 = r1.indexOf(r5)     // Catch: java.lang.Throwable -> Lbd
            r6 = -1
            if (r5 == r6) goto L2e
            java.lang.String r1 = r1.substring(r5)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = "/data/"
            boolean r5 = r1.contains(r5)     // Catch: java.lang.Throwable -> Lbd
            r6 = 0
            r7 = 1
            if (r5 != 0) goto L5e
            java.lang.String r5 = com.uc.crashsdk.a.a     // Catch: java.lang.Throwable -> Lbd
            boolean r5 = r1.contains(r5)     // Catch: java.lang.Throwable -> Lbd
            if (r5 == 0) goto L5c
            goto L5e
        L5c:
            r5 = 0
            goto L5f
        L5e:
            r5 = 1
        L5f:
            if (r5 == 0) goto L2e
            boolean r5 = r2.contains(r1)     // Catch: java.lang.Throwable -> Lbd
            if (r5 != 0) goto L2e
            r2.add(r1)     // Catch: java.lang.Throwable -> Lbd
            boolean r5 = com.uc.crashsdk.e.af     // Catch: java.lang.Throwable -> Lbd
            r8 = 2
            if (r5 == 0) goto L9b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r5.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r9 = "SOBUILDID"
            java.lang.String r10 = "$^%s`%s^$"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L96
            r8[r6] = r9     // Catch: java.lang.Throwable -> L96
            r8[r7] = r1     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = java.lang.String.format(r10, r8)     // Catch: java.lang.Throwable -> L96
            r5.append(r1)     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = "\n"
            r5.append(r1)     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L96
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> L96
            r11.write(r1)     // Catch: java.lang.Throwable -> L96
            goto L2e
        L96:
            r1 = move-exception
            a(r1, r11)     // Catch: java.lang.Throwable -> Lbd
            goto L2e
        L9b:
            r5 = 3
            r9 = 0
            java.lang.String r5 = com.uc.crashsdk.JNIBridge.nativeGet(r5, r9, r1)     // Catch: java.lang.Throwable -> Lbd
            java.util.Locale r9 = java.util.Locale.US     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r10 = "%s: %s\n"
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> Lbd
            r8[r6] = r1     // Catch: java.lang.Throwable -> Lbd
            r8[r7] = r5     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r1 = java.lang.String.format(r9, r10, r8)     // Catch: java.lang.Throwable -> Lbd
            byte[] r1 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> Lbd
            r11.write(r1)     // Catch: java.lang.Throwable -> Lbd
            goto L2e
        Lb9:
            com.uc.crashsdk.a.g.a(r3)
            goto Lcb
        Lbd:
            r0 = move-exception
            goto Lc1
        Lbf:
            r0 = move-exception
            r4 = r1
        Lc1:
            r1 = r3
            goto Lc5
        Lc3:
            r0 = move-exception
            r4 = r1
        Lc5:
            a(r0, r11)     // Catch: java.lang.Throwable -> Ld2
            com.uc.crashsdk.a.g.a(r1)
        Lcb:
            com.uc.crashsdk.a.g.a(r4)
            a(r11)
            return
        Ld2:
            r11 = move-exception
            com.uc.crashsdk.a.g.a(r1)
            com.uc.crashsdk.a.g.a(r4)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e(java.io.OutputStream):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        if (af) {
            return true;
        }
        try {
            return o(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static boolean d(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !g.K() : z2 && g.K()) {
            z3 = false;
        }
        if (z3) {
            com.uc.crashsdk.a.e eVar = S;
            if (com.uc.crashsdk.a.f.b(eVar)) {
                com.uc.crashsdk.a.f.a(eVar);
            }
            com.uc.crashsdk.a.f.a(0, eVar, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
    
        r3.write(r4.getBytes("UTF-8"));
        r3.write(com.umeng.umcrash.UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r8, java.lang.String r9) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L79
            r1 = 26
            java.lang.String r2 = "ps"
            if (r0 < r1) goto Lf
            java.lang.String r0 = "-ef"
            java.lang.String[] r0 = new java.lang.String[]{r2, r0}     // Catch: java.lang.Throwable -> L79
            goto L13
        Lf:
            java.lang.String[] r0 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L79
        L13:
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L79
            java.lang.Process r0 = r1.exec(r0)     // Catch: java.lang.Throwable -> L79
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L79
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L79
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Throwable -> L79
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L79
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L79
            boolean r0 = com.uc.crashsdk.a.g.b(r8)     // Catch: java.lang.Throwable -> L79
            boolean r2 = com.uc.crashsdk.a.g.b(r9)     // Catch: java.lang.Throwable -> L79
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L79
            r3.<init>()     // Catch: java.lang.Throwable -> L79
        L36:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L79
            java.lang.String r5 = "UTF-8"
            if (r4 == 0) goto L74
            r6 = 1
            if (r0 == 0) goto L47
            boolean r7 = r4.contains(r8)     // Catch: java.lang.Throwable -> L79
            if (r7 != 0) goto L61
        L47:
            if (r2 == 0) goto L50
            boolean r7 = r4.contains(r9)     // Catch: java.lang.Throwable -> L79
            if (r7 == 0) goto L50
            goto L61
        L50:
            r7 = 47
            int r7 = r4.indexOf(r7)     // Catch: java.lang.Throwable -> L79
            if (r7 >= 0) goto L60
            r7 = 46
            int r7 = r4.indexOf(r7)     // Catch: java.lang.Throwable -> L79
            if (r7 > 0) goto L61
        L60:
            r6 = 0
        L61:
            if (r6 == 0) goto L36
            byte[] r4 = r4.getBytes(r5)     // Catch: java.lang.Throwable -> L79
            r3.write(r4)     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = "\n"
            byte[] r4 = r4.getBytes(r5)     // Catch: java.lang.Throwable -> L79
            r3.write(r4)     // Catch: java.lang.Throwable -> L79
            goto L36
        L74:
            java.lang.String r8 = r3.toString(r5)     // Catch: java.lang.Throwable -> L79
            return r8
        L79:
            r8 = move-exception
            com.uc.crashsdk.a.g.a(r8)
            java.lang.String r8 = "exception exists."
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    public static int e(boolean z2) {
        int b2;
        if (z2) {
            b2 = f.a(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            b2 = f.b();
        }
        int b3 = f.b(z2);
        return b3 > b2 ? b3 : b2;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return com.uc.crashsdk.a.g.a(str) ? file.getPath() : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder e(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(statFs, new Object[0]);
                if (invoke != null && (invoke instanceof Long)) {
                    return ((Long) invoke).longValue();
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (invoke2 == null || !(invoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) invoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
        }
        try {
            if (g.n() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                return;
            }
            int n2 = g.n();
            bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.d.ar, "-b", "main", "-v", "threadtime", "-t", String.valueOf(n2)}).getInputStream()));
            if (bufferedReader == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                return;
            }
            h = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    i2++;
                    if (i3 < n2 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                        i3++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th3) {
                        a(th3, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
            h = true;
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
            return;
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
            return;
        } finally {
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", m()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(OutputStream outputStream, String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a2 = com.uc.crashsdk.a.b.a(str);
            if (a2 == null) {
                a2 = "file: '" + str + "' not found or decode failed!";
            }
            int length = a2.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(a2.getBytes("UTF-8"), 0, i2);
                    outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                    a(outputStream);
                    return i2;
                }
            }
            if (i2 < a2.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(a2.length() - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i2) {
        try {
            String a2 = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(a2) ? k(a2) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((r("LOG_END") + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(43:1|2|3|4|(2:317|318)|6|(1:8)(1:316)|9|(51:10|11|(1:13)|15|(2:17|18)|23|24|25|26|27|28|(1:30)|32|(1:36)|38|39|41|42|43|44|45|47|48|(2:270|271)|50|51|52|53|54|55|56|57|58|59|60|61|(4:63|64|65|66)|70|71|72|73|74|76|77|78|79|(1:81)(2:242|(1:244))|82|83|84|85)|(4:87|88|89|90)(3:191|192|(8:199|200|201|202|203|204|205|(39:207|208|209|210|212|213|214|215|216|93|94|95|96|(3:98|99|100)(7:168|169|(1:171)|172|(1:174)|175|(4:177|(1:179)(1:183)|180|181))|101|102|103|104|105|(4:107|108|109|110)|114|115|116|117|118|119|(4:121|122|123|124)|128|129|130|(1:132)|133|134|(1:136)|137|138|(1:140)(1:145)|141|142)(32:229|92|93|94|95|96|(0)(0)|101|102|103|104|105|(0)|114|115|116|117|118|119|(0)|128|129|130|(0)|133|134|(0)|137|138|(0)(0)|141|142)))|91|92|93|94|95|96|(0)(0)|101|102|103|104|105|(0)|114|115|116|117|118|119|(0)|128|129|130|(0)|133|134|(0)|137|138|(0)(0)|141|142|(2:(0)|(1:152))) */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x04ac, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x04ad, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x046e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0470, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0443, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0445, code lost:
    
        a(r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0439, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x043b, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0414, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0416, code lost:
    
        a(r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0345, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0346, code lost:
    
        a(r0, r14);
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x041d A[Catch: all -> 0x047c, TRY_LEAVE, TryCatch #21 {all -> 0x047c, blocks: (B:15:0x0040, B:294:0x0090, B:287:0x00f6, B:285:0x0104, B:43:0x0107, B:279:0x0119, B:263:0x0180, B:58:0x0183, B:61:0x0192, B:63:0x0196, B:66:0x01aa, B:69:0x01a7, B:256:0x01b2, B:72:0x01b5, B:249:0x01cc, B:82:0x01fb, B:85:0x020c, B:87:0x0210, B:90:0x0224, B:93:0x0338, B:96:0x0349, B:101:0x0404, B:105:0x0419, B:107:0x041d, B:110:0x0432, B:113:0x042f, B:160:0x043b, B:119:0x0448, B:121:0x044c, B:124:0x0461, B:127:0x045e, B:128:0x0464, B:151:0x0470, B:156:0x0445, B:164:0x0416, B:167:0x0363, B:187:0x0346, B:190:0x0221, B:223:0x0335, B:241:0x0209, B:246:0x01f8, B:252:0x01be, B:260:0x018f, B:266:0x015f, B:269:0x0139, B:275:0x0124, B:282:0x0110, B:291:0x00e9, B:22:0x004f, B:311:0x003d, B:89:0x0212, B:271:0x011e, B:65:0x0198, B:26:0x0093, B:32:0x00bf, B:34:0x00c5, B:36:0x00cf, B:289:0x00bc, B:28:0x009c, B:30:0x00ad, B:130:0x046a, B:109:0x0420, B:71:0x01ac, B:39:0x00ec, B:79:0x01cf, B:81:0x01d3, B:242:0x01e5, B:244:0x01eb, B:52:0x0129, B:115:0x0435, B:74:0x01b8, B:11:0x0032, B:13:0x0036, B:57:0x0162, B:118:0x043f, B:42:0x00f9, B:95:0x033b, B:84:0x01fe, B:77:0x01c1, B:60:0x0189, B:18:0x0049, B:45:0x010a, B:24:0x0052, B:104:0x0410, B:48:0x0113, B:123:0x044f, B:55:0x013d), top: B:10:0x0032, inners: #0, #2, #6, #7, #10, #11, #13, #15, #16, #17, #18, #20, #22, #23, #26, #27, #28, #29, #30, #31, #32, #33, #34, #35, #36, #38, #40 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x044c A[Catch: all -> 0x047c, TRY_LEAVE, TryCatch #21 {all -> 0x047c, blocks: (B:15:0x0040, B:294:0x0090, B:287:0x00f6, B:285:0x0104, B:43:0x0107, B:279:0x0119, B:263:0x0180, B:58:0x0183, B:61:0x0192, B:63:0x0196, B:66:0x01aa, B:69:0x01a7, B:256:0x01b2, B:72:0x01b5, B:249:0x01cc, B:82:0x01fb, B:85:0x020c, B:87:0x0210, B:90:0x0224, B:93:0x0338, B:96:0x0349, B:101:0x0404, B:105:0x0419, B:107:0x041d, B:110:0x0432, B:113:0x042f, B:160:0x043b, B:119:0x0448, B:121:0x044c, B:124:0x0461, B:127:0x045e, B:128:0x0464, B:151:0x0470, B:156:0x0445, B:164:0x0416, B:167:0x0363, B:187:0x0346, B:190:0x0221, B:223:0x0335, B:241:0x0209, B:246:0x01f8, B:252:0x01be, B:260:0x018f, B:266:0x015f, B:269:0x0139, B:275:0x0124, B:282:0x0110, B:291:0x00e9, B:22:0x004f, B:311:0x003d, B:89:0x0212, B:271:0x011e, B:65:0x0198, B:26:0x0093, B:32:0x00bf, B:34:0x00c5, B:36:0x00cf, B:289:0x00bc, B:28:0x009c, B:30:0x00ad, B:130:0x046a, B:109:0x0420, B:71:0x01ac, B:39:0x00ec, B:79:0x01cf, B:81:0x01d3, B:242:0x01e5, B:244:0x01eb, B:52:0x0129, B:115:0x0435, B:74:0x01b8, B:11:0x0032, B:13:0x0036, B:57:0x0162, B:118:0x043f, B:42:0x00f9, B:95:0x033b, B:84:0x01fe, B:77:0x01c1, B:60:0x0189, B:18:0x0049, B:45:0x010a, B:24:0x0052, B:104:0x0410, B:48:0x0113, B:123:0x044f, B:55:0x013d), top: B:10:0x0032, inners: #0, #2, #6, #7, #10, #11, #13, #15, #16, #17, #18, #20, #22, #23, #26, #27, #28, #29, #30, #31, #32, #33, #34, #35, #36, #38, #40 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x049b A[Catch: all -> 0x04ac, TryCatch #9 {all -> 0x04ac, blocks: (B:138:0x0497, B:140:0x049b, B:141:0x04a6), top: B:137:0x0497 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0368 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x048a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x034d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.lang.Throwable r23, java.lang.String r24, long r25, boolean r27) {
        /*
            Method dump skipped, instructions count: 1216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] Q2 = Q();
                if (Q2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        try {
                            int read = dataInputStream.read(Q2);
                            if (read == -1) {
                                break loop0;
                            }
                            i4 += read;
                            int i6 = i2 - i3;
                            if (read <= i6 + 32) {
                                i6 = read;
                            }
                            if (i6 > 0 && !z2) {
                                outputStream.write(Q2, 0, i6);
                                i3 += i6;
                            }
                            if (!z2) {
                                if (i6 < read || i3 >= i2) {
                                    z2 = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i5 = i3;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                                i3 = i5;
                                a(outputStream);
                                return i3;
                            } finally {
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z2) {
        try {
            boolean z3 = g.r() && com.uc.crashsdk.b.C() && !d;
            if (!z3) {
                z3 = g.s();
            }
            if (z3) {
                if (z2) {
                    String k2 = k();
                    if (com.uc.crashsdk.a.g.a(k2)) {
                        return;
                    }
                    j();
                    a(k2, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf <= 0 || (indexOf = name.indexOf(46, lastIndexOf)) <= 0) {
            return false;
        }
        String substring = name.substring(lastIndexOf + 1, indexOf);
        return LogType.JAVA_TYPE.equals(substring) || "ucebujava".equals(substring) || LogType.NATIVE_TYPE.equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || LogType.ANR_TYPE.equals(substring);
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = l(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    public static void b(String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(Context context) {
        if (g.K()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TbsListener.ErrorCode.INFO_CAN_NOT_USE_X5_TBS_NOTAVAILABLE), i2 * 1000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(boolean z2, boolean z3) {
        int i2;
        if (z3 && !ac) {
            f.d(false);
        }
        if (z2) {
            boolean a2 = f.a(com.uc.crashsdk.b.c(), false);
            h.i();
            i2 = a2;
        } else {
            int a3 = f.a();
            h.i();
            i2 = a3;
        }
        return z3 ? f.a(z2) : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        int lastIndexOf;
        int indexOf;
        int i2;
        int indexOf2;
        File file;
        byte[] e;
        if (!g.x() || (lastIndexOf = str.lastIndexOf(47)) <= 0 || (indexOf = str.indexOf(95, lastIndexOf)) <= lastIndexOf || (indexOf2 = str.indexOf(95, (i2 = indexOf + 1))) <= indexOf) {
            return str;
        }
        String d2 = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(lastIndexOf + 1, indexOf) + str.substring(i2, indexOf2));
        if (d2 == null || (e = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || e.length <= 0) {
            return str;
        }
        byte[] bArr = null;
        try {
            bArr = com.uc.crashsdk.a.c.b(e, d2.substring(0, 16).getBytes());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        if (bArr == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + ".tmp");
        if (!com.uc.crashsdk.a.g.a(file2, bArr)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        file.delete();
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02f2 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0067, B:28:0x03bd, B:29:0x006d, B:31:0x007b, B:33:0x008d, B:34:0x00ae, B:36:0x00be, B:40:0x00cb, B:45:0x00f7, B:50:0x00e9, B:66:0x01c4, B:68:0x01d8, B:70:0x01dc, B:71:0x01de, B:73:0x01e3, B:74:0x01e5, B:75:0x01ea, B:79:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:87:0x023e, B:89:0x025d, B:90:0x0270, B:92:0x0282, B:94:0x0290, B:95:0x02a1, B:96:0x02e3, B:100:0x02f2, B:104:0x02fe, B:108:0x030d, B:110:0x031b, B:112:0x0328, B:114:0x032f, B:117:0x033c, B:119:0x0348, B:121:0x0362, B:122:0x0367, B:124:0x0377, B:125:0x0384, B:130:0x03ae, B:132:0x03d1, B:134:0x03d8, B:136:0x03df, B:138:0x03e6, B:140:0x03ed, B:142:0x03f4, B:147:0x0406, B:149:0x040d, B:151:0x0414, B:153:0x041b, B:154:0x03ff, B:155:0x037e, B:156:0x03a1, B:158:0x03a6, B:162:0x02a7, B:164:0x02ad, B:167:0x02b5, B:169:0x02b9, B:171:0x02cd, B:173:0x02d1, B:176:0x01f4, B:178:0x0202, B:180:0x0208, B:183:0x01c1, B:190:0x0423), top: B:4:0x000a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0348 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0067, B:28:0x03bd, B:29:0x006d, B:31:0x007b, B:33:0x008d, B:34:0x00ae, B:36:0x00be, B:40:0x00cb, B:45:0x00f7, B:50:0x00e9, B:66:0x01c4, B:68:0x01d8, B:70:0x01dc, B:71:0x01de, B:73:0x01e3, B:74:0x01e5, B:75:0x01ea, B:79:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:87:0x023e, B:89:0x025d, B:90:0x0270, B:92:0x0282, B:94:0x0290, B:95:0x02a1, B:96:0x02e3, B:100:0x02f2, B:104:0x02fe, B:108:0x030d, B:110:0x031b, B:112:0x0328, B:114:0x032f, B:117:0x033c, B:119:0x0348, B:121:0x0362, B:122:0x0367, B:124:0x0377, B:125:0x0384, B:130:0x03ae, B:132:0x03d1, B:134:0x03d8, B:136:0x03df, B:138:0x03e6, B:140:0x03ed, B:142:0x03f4, B:147:0x0406, B:149:0x040d, B:151:0x0414, B:153:0x041b, B:154:0x03ff, B:155:0x037e, B:156:0x03a1, B:158:0x03a6, B:162:0x02a7, B:164:0x02ad, B:167:0x02b5, B:169:0x02b9, B:171:0x02cd, B:173:0x02d1, B:176:0x01f4, B:178:0x0202, B:180:0x0208, B:183:0x01c1, B:190:0x0423), top: B:4:0x000a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03a1 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0067, B:28:0x03bd, B:29:0x006d, B:31:0x007b, B:33:0x008d, B:34:0x00ae, B:36:0x00be, B:40:0x00cb, B:45:0x00f7, B:50:0x00e9, B:66:0x01c4, B:68:0x01d8, B:70:0x01dc, B:71:0x01de, B:73:0x01e3, B:74:0x01e5, B:75:0x01ea, B:79:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:87:0x023e, B:89:0x025d, B:90:0x0270, B:92:0x0282, B:94:0x0290, B:95:0x02a1, B:96:0x02e3, B:100:0x02f2, B:104:0x02fe, B:108:0x030d, B:110:0x031b, B:112:0x0328, B:114:0x032f, B:117:0x033c, B:119:0x0348, B:121:0x0362, B:122:0x0367, B:124:0x0377, B:125:0x0384, B:130:0x03ae, B:132:0x03d1, B:134:0x03d8, B:136:0x03df, B:138:0x03e6, B:140:0x03ed, B:142:0x03f4, B:147:0x0406, B:149:0x040d, B:151:0x0414, B:153:0x041b, B:154:0x03ff, B:155:0x037e, B:156:0x03a1, B:158:0x03a6, B:162:0x02a7, B:164:0x02ad, B:167:0x02b5, B:169:0x02b9, B:171:0x02cd, B:173:0x02d1, B:176:0x01f4, B:178:0x0202, B:180:0x0208, B:183:0x01c1, B:190:0x0423), top: B:4:0x000a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d8 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0067, B:28:0x03bd, B:29:0x006d, B:31:0x007b, B:33:0x008d, B:34:0x00ae, B:36:0x00be, B:40:0x00cb, B:45:0x00f7, B:50:0x00e9, B:66:0x01c4, B:68:0x01d8, B:70:0x01dc, B:71:0x01de, B:73:0x01e3, B:74:0x01e5, B:75:0x01ea, B:79:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:87:0x023e, B:89:0x025d, B:90:0x0270, B:92:0x0282, B:94:0x0290, B:95:0x02a1, B:96:0x02e3, B:100:0x02f2, B:104:0x02fe, B:108:0x030d, B:110:0x031b, B:112:0x0328, B:114:0x032f, B:117:0x033c, B:119:0x0348, B:121:0x0362, B:122:0x0367, B:124:0x0377, B:125:0x0384, B:130:0x03ae, B:132:0x03d1, B:134:0x03d8, B:136:0x03df, B:138:0x03e6, B:140:0x03ed, B:142:0x03f4, B:147:0x0406, B:149:0x040d, B:151:0x0414, B:153:0x041b, B:154:0x03ff, B:155:0x037e, B:156:0x03a1, B:158:0x03a6, B:162:0x02a7, B:164:0x02ad, B:167:0x02b5, B:169:0x02b9, B:171:0x02cd, B:173:0x02d1, B:176:0x01f4, B:178:0x0202, B:180:0x0208, B:183:0x01c1, B:190:0x0423), top: B:4:0x000a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020d A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0067, B:28:0x03bd, B:29:0x006d, B:31:0x007b, B:33:0x008d, B:34:0x00ae, B:36:0x00be, B:40:0x00cb, B:45:0x00f7, B:50:0x00e9, B:66:0x01c4, B:68:0x01d8, B:70:0x01dc, B:71:0x01de, B:73:0x01e3, B:74:0x01e5, B:75:0x01ea, B:79:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:87:0x023e, B:89:0x025d, B:90:0x0270, B:92:0x0282, B:94:0x0290, B:95:0x02a1, B:96:0x02e3, B:100:0x02f2, B:104:0x02fe, B:108:0x030d, B:110:0x031b, B:112:0x0328, B:114:0x032f, B:117:0x033c, B:119:0x0348, B:121:0x0362, B:122:0x0367, B:124:0x0377, B:125:0x0384, B:130:0x03ae, B:132:0x03d1, B:134:0x03d8, B:136:0x03df, B:138:0x03e6, B:140:0x03ed, B:142:0x03f4, B:147:0x0406, B:149:0x040d, B:151:0x0414, B:153:0x041b, B:154:0x03ff, B:155:0x037e, B:156:0x03a1, B:158:0x03a6, B:162:0x02a7, B:164:0x02ad, B:167:0x02b5, B:169:0x02b9, B:171:0x02cd, B:173:0x02d1, B:176:0x01f4, B:178:0x0202, B:180:0x0208, B:183:0x01c1, B:190:0x0423), top: B:4:0x000a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0223 A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:5:0x000a, B:7:0x0010, B:9:0x001f, B:16:0x0034, B:18:0x003a, B:19:0x004d, B:21:0x005d, B:23:0x0067, B:28:0x03bd, B:29:0x006d, B:31:0x007b, B:33:0x008d, B:34:0x00ae, B:36:0x00be, B:40:0x00cb, B:45:0x00f7, B:50:0x00e9, B:66:0x01c4, B:68:0x01d8, B:70:0x01dc, B:71:0x01de, B:73:0x01e3, B:74:0x01e5, B:75:0x01ea, B:79:0x020d, B:82:0x0223, B:84:0x0229, B:86:0x0232, B:87:0x023e, B:89:0x025d, B:90:0x0270, B:92:0x0282, B:94:0x0290, B:95:0x02a1, B:96:0x02e3, B:100:0x02f2, B:104:0x02fe, B:108:0x030d, B:110:0x031b, B:112:0x0328, B:114:0x032f, B:117:0x033c, B:119:0x0348, B:121:0x0362, B:122:0x0367, B:124:0x0377, B:125:0x0384, B:130:0x03ae, B:132:0x03d1, B:134:0x03d8, B:136:0x03df, B:138:0x03e6, B:140:0x03ed, B:142:0x03f4, B:147:0x0406, B:149:0x040d, B:151:0x0414, B:153:0x041b, B:154:0x03ff, B:155:0x037e, B:156:0x03a1, B:158:0x03a6, B:162:0x02a7, B:164:0x02ad, B:167:0x02b5, B:169:0x02b9, B:171:0x02cd, B:173:0x02d1, B:176:0x01f4, B:178:0x0202, B:180:0x0208, B:183:0x01c1, B:190:0x0423), top: B:4:0x000a, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 1099
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            String k2 = k();
            if (com.uc.crashsdk.a.g.a(k2)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            Object obj = n;
            synchronized (obj) {
                if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{k2, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        com.uc.crashsdk.a.g.a(e);
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean z2;
        FileChannel fileChannel;
        Exception e;
        synchronized (o) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            ?? r5 = 0;
            r5 = null;
            FileLock lock = null;
            z2 = false;
            try {
                try {
                    try {
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        r5 = file;
                        com.uc.crashsdk.a.g.a((Closeable) r5);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        fileChannel = null;
                    } catch (Exception e4) {
                        fileChannel = null;
                        e = e4;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(fileChannel);
                        return z2;
                    }
                }
                if (fileChannel != null) {
                    try {
                        lock = fileChannel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            return z2;
                        }
                    }
                }
                try {
                    z2 = eVar.a();
                    com.uc.crashsdk.a.g.a(fileChannel);
                } finally {
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z2;
    }

    private static boolean a(String str, d dVar) {
        String a2 = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (a2 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.f1003c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.a = parseLong;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        boolean a2;
        if (f1001c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = af || com.uc.crashsdk.b.I();
        if (!z3 && !com.uc.crashsdk.a.d.d()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!c(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (Z()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String str3 = g.V() + j(str);
        ?? r11 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            long nativeClientCreateConnection = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(str3, "custom", str, r11) : 0L;
            if (nativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j3 = nativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (p) {
            z2 = r11;
            a2 = a(str3, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (a2 && !z3) {
            b(h(), str, z2);
        }
        if (j3 != 0) {
            JNIBridge.nativeClientCloseConnection(j3);
        }
        if (!a2) {
            return false;
        }
        if (!z3) {
            q(str3);
        }
        if (!z3) {
            str3 = a(l(str3));
        }
        b(str3, str);
        if (!z2 || z3) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, String str2, boolean z2) {
        if (!n(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    private static void a(a aVar, String str, long j2) {
        String nativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (af || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith("/") || nativeDumpThreads.indexOf(10) >= 0) {
                str2 = nativeDumpThreads;
            } else {
                if (!new File(nativeDumpThreads).exists()) {
                    str2 = "Can not found " + nativeDumpThreads;
                }
                String str3 = str2;
                str2 = nativeDumpThreads;
                nativeDumpThreads = str3;
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (nativeDumpThreads != null) {
            try {
                aVar.write(nativeDumpThreads.getBytes("UTF-8"));
                aVar.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str2 != null && !af) {
            b(aVar, str2, LogType.ANR);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r18, long r19, java.lang.StringBuffer r21, java.lang.String r22, long r23, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.util.ArrayList<java.lang.String> r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    public static void a(String str, boolean z2) {
        if (z2) {
            x = str;
            return;
        }
        synchronized (y) {
            w = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.f(), str + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    public static void a(Context context) {
        try {
            if (U()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(1:205)|(3:237|238|(15:241|242|243|(1:210)|211|212|213|214|(1:216)|217|(1:221)|222|(1:225)|227|(2:229|230)(1:231)))|207|(1:210)|211|212|213|214|(0)|217|(2:219|221)|222|(1:225)|227|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:330|(3:362|363|(15:366|367|368|(1:335)|336|337|338|339|(1:341)|342|(1:346)|347|(1:350)|352|(2:354|355)(1:356)))|332|(1:335)|336|337|338|339|(0)|342|(2:344|346)|347|(1:350)|352|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:378|(3:410|411|(15:414|415|416|(1:383)|384|385|386|387|(1:389)|390|(1:394)|395|(1:398)|400|(2:402|403)(1:404)))|380|(1:383)|384|385|386|387|(0)|390|(2:392|394)|395|(1:398)|400|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(15:77|(3:109|110|(15:113|114|115|(1:82)|83|84|85|86|(1:88)|89|(1:93)|94|(1:97)|99|(2:101|102)(1:103)))|79|(1:82)|83|84|85|86|(0)|89|(2:91|93)|94|(1:97)|99|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:151|(1:155)|(3:187|188|(15:191|192|193|(1:160)|161|162|164|165|(1:167)|168|(1:172)|173|(1:176)|178|(2:180|181)(1:182)))|157|(1:160)|161|162|164|165|(0)|168|(2:170|172)|173|(1:176)|178|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:491|492|(2:494|(1:496))|(3:528|529|(16:532|533|534|535|(1:501)|502|503|504|505|(0)|508|(2:510|512)|513|(1:516)|518|(0)(0)))|498|(0)|502|503|504|505|(0)|508|(0)|513|(0)|518|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:11|(6:14|15|16|17|(1:19)(1:67)|12)|72|20|(3:53|54|(15:57|58|59|(1:25)|26|27|28|29|(1:31)|32|(1:36)|37|(1:40)|42|(2:44|45)(1:47)))|22|(1:25)|26|27|28|29|(0)|32|(2:34|36)|37|(1:40)|42|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:435|436|(1:438)|440|(1:444)|(3:476|477|(16:480|481|482|483|(1:449)|450|451|452|453|(1:455)|456|(1:460)|461|(1:464)|466|(2:468|469)(1:470)))|446|(1:449)|450|451|452|453|(0)|456|(2:458|460)|461|(1:464)|466|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(35:123|(1:125)|126|(1:128)|129|130|131|132|133|134|135|(1:546)|139|140|141|142|(9:319|320|321|322|(1:324)(1:428)|325|327|328|(15:330|(3:362|363|(15:366|367|368|(1:335)|336|337|338|339|(1:341)|342|(1:346)|347|(1:350)|352|(2:354|355)(1:356)))|332|(1:335)|336|337|338|339|(0)|342|(2:344|346)|347|(1:350)|352|(0)(0))(2:376|(15:378|(3:410|411|(15:414|415|416|(1:383)|384|385|386|387|(1:389)|390|(1:394)|395|(1:398)|400|(2:402|403)(1:404)))|380|(1:383)|384|385|386|387|(0)|390|(2:392|394)|395|(1:398)|400|(0)(0))(1:424)))(5:(1:145)|146|(1:148)(1:318)|149|(16:151|(1:155)|(3:187|188|(15:191|192|193|(1:160)|161|162|164|165|(1:167)|168|(1:172)|173|(1:176)|178|(2:180|181)(1:182)))|157|(1:160)|161|162|164|165|(0)|168|(2:170|172)|173|(1:176)|178|(0)(0))(1:(15:(1:205)|(3:237|238|(15:241|242|243|(1:210)|211|212|213|214|(1:216)|217|(1:221)|222|(1:225)|227|(2:229|230)(1:231)))|207|(1:210)|211|212|213|214|(0)|217|(2:219|221)|222|(1:225)|227|(0)(0))))|251|(6:256|(1:258)|259|260|261|262)|267|(1:271)|(3:303|304|(16:307|308|309|310|(1:276)|277|278|279|280|(1:282)|283|(1:287)|288|(1:291)|293|(2:295|296)(1:297)))|273|(1:276)|277|278|279|280|(0)|283|(2:285|287)|288|(1:291)|293|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0132, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0133, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00fa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00fb, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0399, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x039a, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0361, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0362, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0414, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0415, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x03dc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x03dd, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0511, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0512, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x04d9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x04da, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x0280, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0281, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0248, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0249, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x02fb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x02fc, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x02c3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x02c4, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:471:0x05c2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x05c3, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x058a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:475:0x058b, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0079, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x007a, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0358 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0382 A[Catch: all -> 0x0399, TryCatch #44 {all -> 0x0399, blocks: (B:165:0x0366, B:168:0x0371, B:170:0x0382, B:172:0x0386, B:173:0x0389, B:176:0x0391), top: B:164:0x0366 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x038f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03fd A[Catch: all -> 0x0414, TryCatch #42 {all -> 0x0414, blocks: (B:214:0x03e1, B:217:0x03ec, B:219:0x03fd, B:221:0x0401, B:222:0x0404, B:225:0x040c), top: B:213:0x03e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x040a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0458 A[Catch: all -> 0x0526, TryCatch #3 {all -> 0x0526, blocks: (B:251:0x0428, B:254:0x043a, B:256:0x0440, B:258:0x0458, B:259:0x045b, B:262:0x0489, B:266:0x0486, B:151:0x032c, B:261:0x0480), top: B:142:0x01f1, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x04fa A[Catch: all -> 0x0511, TryCatch #41 {all -> 0x0511, blocks: (B:280:0x04de, B:283:0x04e9, B:285:0x04fa, B:287:0x04fe, B:288:0x0501, B:291:0x0509), top: B:279:0x04de }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0507 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x023f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0269 A[Catch: all -> 0x0280, TryCatch #21 {all -> 0x0280, blocks: (B:339:0x024d, B:342:0x0258, B:344:0x0269, B:346:0x026d, B:347:0x0270, B:350:0x0278), top: B:338:0x024d }] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0276 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a A[Catch: all -> 0x00b1, TryCatch #10 {all -> 0x00b1, blocks: (B:29:0x007e, B:32:0x0089, B:34:0x009a, B:36:0x009e, B:37:0x00a1, B:40:0x00a9), top: B:28:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:356:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x02ba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x02e4 A[Catch: all -> 0x02fb, TryCatch #20 {all -> 0x02fb, blocks: (B:387:0x02c8, B:390:0x02d3, B:392:0x02e4, B:394:0x02e8, B:395:0x02eb, B:398:0x02f3), top: B:386:0x02c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x02f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:404:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x0581 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x05ab A[Catch: all -> 0x05c2, TryCatch #23 {all -> 0x05c2, blocks: (B:453:0x058f, B:456:0x059a, B:458:0x05ab, B:460:0x05af, B:461:0x05b2, B:464:0x05ba), top: B:452:0x058f }] */
    /* JADX WARN: Removed duplicated region for block: B:463:0x05b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:468:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:470:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0602 A[ADDED_TO_REGION, DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:507:0x061a A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:510:0x062c A[Catch: all -> 0x0643, DONT_GENERATE, FINALLY_INSNS, TryCatch #25 {all -> 0x0643, blocks: (B:505:0x0610, B:508:0x061b, B:510:0x062c, B:512:0x0630, B:513:0x0633, B:516:0x063b), top: B:504:0x0610 }] */
    /* JADX WARN: Removed duplicated region for block: B:515:0x0639 A[ADDED_TO_REGION, DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0650 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:522:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011b A[Catch: all -> 0x0132, TryCatch #11 {all -> 0x0132, blocks: (B:86:0x00ff, B:89:0x010a, B:91:0x011b, B:93:0x011f, B:94:0x0122, B:97:0x012a), top: B:85:0x00ff }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0128 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r20, java.lang.Throwable r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 1624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (g.Q()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TbsListener.ErrorCode.INFO_INITX5_FALSE_DEFAULT, new Object[]{Long.valueOf(timeInMillis2)}), j2 <= 3600000 ? 1000 + j2 : 3600000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z2 = true;
                    i3 = 0;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (ae) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ad != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ad = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int nativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        af = nativeCmd != -1;
        return fd == -1 || nativeCmd != -1;
    }
}
