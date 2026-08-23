package com.uc.crashsdk;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.uc.crashsdk.a.h;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProGuard */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class f {
    static final /* synthetic */ boolean a = true;
    private static final Map<String, SparseIntArray> b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f1005c = new Object();
    private static final SparseArray<String> d = new SparseArray<>();
    private static final Object e = new Object();
    private static boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i) {
        a(i, 1);
    }

    private static boolean b(int i, int i2) {
        try {
            b.u();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            String c2 = c(i);
            if (c2 == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            File file = new File(b.c());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                if (a2 == null) {
                    a2 = new StringBuffer();
                }
                a2.append("[");
                a2.append(e.h());
                a2.append("]\n");
            }
            a(a2, c2, a(a2, c2) + i2);
            return a(file, a2);
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
            return false;
        }
    }

    private static boolean c(String str) {
        SparseIntArray sparseIntArray = b.get(str);
        if (sparseIntArray == null) {
            return false;
        }
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            d.a(str, keyAt, sparseIntArray.get(keyAt));
        }
        return true;
    }

    private static char[] d() {
        char[] cArr = null;
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    break;
                }
            }
        }
        return cArr;
    }

    private static void e() {
        SparseArray<String> sparseArray = d;
        synchronized (sparseArray) {
            if (sparseArray.size() != 0) {
                return;
            }
            sparseArray.put(100, "start_pv");
            sparseArray.put(102, "start_hpv");
            sparseArray.put(1, "all_all");
            sparseArray.put(2, "all_fg");
            sparseArray.put(101, "all_bg");
            sparseArray.put(3, "java_fg");
            sparseArray.put(4, "java_bg");
            sparseArray.put(7, "native_fg");
            sparseArray.put(8, "native_bg");
            sparseArray.put(27, "native_anr_fg");
            sparseArray.put(28, "native_anr_bg");
            sparseArray.put(9, "native_ok");
            sparseArray.put(10, "unexp_anr");
            sparseArray.put(29, "unexp_lowmem");
            sparseArray.put(30, "unexp_killed");
            sparseArray.put(31, "unexp_exit");
            sparseArray.put(32, "unexp_restart");
            sparseArray.put(11, "unexp_fg");
            sparseArray.put(12, "unexp_bg");
            sparseArray.put(40, "anr_fg");
            sparseArray.put(41, "anr_bg");
            sparseArray.put(42, "anr_cr_fg");
            sparseArray.put(43, "anr_cr_bg");
            sparseArray.put(13, "log_up_succ");
            sparseArray.put(14, "log_up_fail");
            sparseArray.put(15, "log_empty");
            sparseArray.put(200, "log_tmp");
            sparseArray.put(16, "log_abd_all");
            sparseArray.put(22, "log_abd_builtin");
            sparseArray.put(23, "log_abd_custom");
            sparseArray.put(17, "log_large");
            sparseArray.put(18, "log_up_all");
            sparseArray.put(19, "log_up_bytes");
            sparseArray.put(20, "log_up_crash");
            sparseArray.put(21, "log_up_custom");
            sparseArray.put(24, "log_zipped");
            sparseArray.put(201, "log_enced");
            sparseArray.put(25, "log_renamed");
            sparseArray.put(26, "log_safe_skip");
        }
    }

    private static File[] f() {
        File[] listFiles = new File(g.U()).listFiles();
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.getPath().endsWith(".st")) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, int i2) {
        if (i2 == 0) {
            com.uc.crashsdk.a.a.b("Add stat for type " + i + " with count 0!");
            return;
        }
        a(b.c(), new com.uc.crashsdk.a.e(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:8:0x0008, B:10:0x000c, B:12:0x000e, B:14:0x0016, B:16:0x0018, B:18:0x0020, B:20:0x002a, B:23:0x004a, B:24:0x004d, B:25:0x0054, B:27:0x0031, B:29:0x0037, B:31:0x0042), top: B:7:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(boolean r3) {
        /*
            boolean r0 = com.uc.crashsdk.f.f
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.Object r0 = com.uc.crashsdk.f.e
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.f.f     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        Le:
            java.lang.String r1 = "crash detail"
            boolean r3 = com.uc.crashsdk.a.h.a(r3, r1)     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L18
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L18:
            r3 = 0
            boolean r1 = com.uc.crashsdk.b.p()     // Catch: java.lang.Throwable -> L56
            r2 = 1
            if (r1 == 0) goto L31
            r3 = 2
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.o()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 42
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
        L2f:
            r3 = 1
            goto L48
        L31:
            boolean r1 = com.uc.crashsdk.b.q()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L48
            r3 = 101(0x65, float:1.42E-43)
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            boolean r3 = com.uc.crashsdk.b.o()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L2f
            r3 = 43
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            goto L2f
        L48:
            if (r3 == 0) goto L4d
            a(r2, r2)     // Catch: java.lang.Throwable -> L56
        L4d:
            r3 = 100
            a(r3, r2)     // Catch: java.lang.Throwable -> L56
            com.uc.crashsdk.f.f = r2     // Catch: java.lang.Throwable -> L56
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            return
        L56:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L56
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.f.d(boolean):void");
    }

    private static String c(int i) {
        String str;
        e();
        SparseArray<String> sparseArray = d;
        synchronized (sparseArray) {
            str = sparseArray.get(i);
        }
        return str;
    }

    private static StringBuffer a(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        if (!file.exists()) {
            return null;
        }
        char[] d2 = d();
        if (d2 == null) {
            com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                fileReader = new FileReader(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            int read = fileReader.read(d2);
            if (read > 0) {
                fileReader2 = null;
                stringBuffer.append(d2, 0, read);
            }
            com.uc.crashsdk.a.g.a(fileReader);
        } catch (Exception e3) {
            e = e3;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileReader2);
            return stringBuffer;
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            com.uc.crashsdk.a.g.a(fileReader2);
            throw th;
        }
        return stringBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z) {
        if (g.O() && !b.I()) {
            e.j();
            if (!h.e()) {
                h.a(z);
            }
            if (b.C()) {
                d(z);
                a(b.c(), z);
                h.b(z);
            }
        }
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            return 0;
        }
        int indexOf2 = stringBuffer.indexOf("=", indexOf + str.length());
        if (indexOf2 < 0) {
            com.uc.crashsdk.a.a.b(str + " line not contain '='!");
            return 0;
        }
        int i = indexOf2 + 1;
        int indexOf3 = stringBuffer.indexOf(UMCustomLogInfoBuilder.LINE_SEP, i);
        if (indexOf3 < 0) {
            indexOf3 = stringBuffer.length();
        }
        try {
            int parseInt = Integer.parseInt(stringBuffer.substring(i, indexOf3));
            if (parseInt < 0) {
                return 0;
            }
            return parseInt;
        } catch (NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    private static boolean b(String str) {
        e();
        synchronized (d) {
            File file = new File(str);
            StringBuffer a2 = a(file);
            if (com.uc.crashsdk.a.g.a(a2)) {
                return false;
            }
            int indexOf = a2.indexOf("[");
            if (indexOf < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name start!", null);
                return false;
            }
            int i = indexOf + 1;
            int indexOf2 = a2.indexOf("]", i);
            if (indexOf2 < 0) {
                com.uc.crashsdk.a.a.a("crashsdk", "Can not found process name end!", null);
                return false;
            }
            String substring = a2.substring(i, indexOf2);
            int i2 = 0;
            boolean z = false;
            while (true) {
                try {
                    SparseArray<String> sparseArray = d;
                    if (i2 >= sparseArray.size()) {
                        break;
                    }
                    int keyAt = sparseArray.keyAt(i2);
                    String str2 = sparseArray.get(keyAt);
                    int a3 = a(a2, str2);
                    if (a3 > 0) {
                        h.a(substring, keyAt, a3);
                        Map<String, SparseIntArray> map = b;
                        synchronized (map) {
                            SparseIntArray sparseIntArray = map.get(substring);
                            if (sparseIntArray == null) {
                                sparseIntArray = new SparseIntArray();
                                map.put(substring, sparseIntArray);
                            }
                            sparseIntArray.put(keyAt, sparseIntArray.get(keyAt, 0) + a3);
                        }
                        a(a2, str2, 0);
                        z = true;
                    }
                    i2++;
                } finally {
                    if (z) {
                        a(file, a2);
                    }
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(700), 3000L);
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int indexOf = stringBuffer.indexOf(str);
        if (indexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(i);
                stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                return;
            }
            return;
        }
        int indexOf2 = stringBuffer.indexOf(UMCustomLogInfoBuilder.LINE_SEP, indexOf);
        if (indexOf2 < 0) {
            indexOf2 = stringBuffer.length();
        }
        stringBuffer.replace(indexOf, indexOf2, str + "=" + String.valueOf(i));
    }

    private static boolean a(File file, StringBuffer stringBuffer) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String stringBuffer2 = stringBuffer.toString();
            fileWriter.write(stringBuffer2, 0, stringBuffer2.length());
            com.uc.crashsdk.a.g.a(fileWriter);
            return true;
        } catch (Exception e3) {
            e = e3;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(e);
            com.uc.crashsdk.a.g.a(fileWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            com.uc.crashsdk.a.g.a(fileWriter2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static int a(boolean z) {
        int i;
        Map<String, SparseIntArray> map = b;
        synchronized (map) {
            try {
                if (z) {
                    String h = e.h();
                    boolean c2 = c(h);
                    map.remove(h);
                    i = c2;
                } else {
                    Iterator<String> it = map.keySet().iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        if (c(it.next())) {
                            i2++;
                        }
                    }
                    b.clear();
                    i = i2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        return b.a(f1005c, str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str, boolean z) {
        if (h.a(z, "crash detail report")) {
            return false;
        }
        return a(str, new com.uc.crashsdk.a.e(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        File[] f2 = f();
        if (f2 == null) {
            return 0;
        }
        int i = 0;
        for (File file : f2) {
            if (a(file.getAbsolutePath(), false)) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(boolean z) {
        int size;
        Map<String, SparseIntArray> map = b;
        synchronized (map) {
            try {
                if (z) {
                    String h = e.h();
                    if (map.containsKey(h)) {
                        map.remove(h);
                        size = 1;
                    } else {
                        size = 0;
                    }
                } else {
                    size = map.size();
                    map.clear();
                }
            } finally {
            }
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new Object[]{str}));
    }

    public static boolean a(int i, Object[] objArr) {
        switch (i) {
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA /* 751 */:
                if (a || objArr != null) {
                    return b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                throw new AssertionError();
            case TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA /* 752 */:
                if (a || objArr != null) {
                    return b((String) objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file = new File((String) objArr[0]);
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b() {
        File[] f2 = f();
        if (f2 == null) {
            return 0;
        }
        int i = 0;
        for (File file : f2) {
            if (a(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    public static void b(int i) {
        if (i != 700) {
            return;
        }
        d(false);
    }
}
