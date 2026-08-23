package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: UMProbe.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class j {
    public static final String a = "UM_PROBE_DATA";
    public static final String b = "_dsk_s";

    /* renamed from: c, reason: collision with root package name */
    public static final String f1096c = "_thm_z";
    public static final String d = "_gdf_r";
    private static Object e = new Object();

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.j.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = j.c();
                    strArr[1] = j.a();
                    strArr[2] = j.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    j.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (e) {
                jSONObject.put(b, sharedPreferences.getString(b, ""));
                jSONObject.put(f1096c, sharedPreferences.getString(f1096c, ""));
                jSONObject.put(d, sharedPreferences.getString(d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return;
        }
        synchronized (e) {
            sharedPreferences.edit().putString(b, strArr[0]).putString(f1096c, strArr[1]).putString(d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "/proc/diskstats"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L34
        Ld:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = "mtd"
            java.lang.String r3 = "sda"
            java.lang.String r4 = "mmcblk"
            if (r0 == 0) goto L30
            boolean r5 = r0.contains(r4)     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto L21
            r2 = r4
            goto L37
        L21:
            boolean r4 = r0.contains(r3)     // Catch: java.lang.Throwable -> L33
            if (r4 == 0) goto L29
            r2 = r3
            goto L37
        L29:
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto Ld
            goto L37
        L30:
            java.lang.String r2 = "unknown"
            goto L37
        L33:
            r0 = r1
        L34:
            java.lang.String r2 = "noper"
            r1 = r0
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Throwable -> L3c
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.j.c():java.lang.String");
    }

    public static String b() {
        int i;
        try {
            i = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "goldfish" : i < 0 ? "noper" : "unknown";
    }

    public static int a(String str, String str2) {
        int i;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i;
        try {
            i = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i = -1;
        }
        return i > 0 ? "thermal_zone" : i < 0 ? "noper" : "unknown";
    }
}
