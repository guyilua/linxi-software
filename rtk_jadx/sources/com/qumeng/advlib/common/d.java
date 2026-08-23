package com.qumeng.advlib.common;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.ak;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    public static final String a = "https://tracelog-debug.aiclk.com";
    public static final String b = "https://logrcv.aiclk.com/trace";
    public static String d = "";
    private static long f = 0;
    public static int g = -1;
    private static long h = 0;
    public static long i = 0;
    private static int j = -1;
    private static Handler l;
    private static StringBuilder e = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    public static String f25c = "";
    private static final HandlerThread k = new HandlerThread("cpc/sdk-remote-" + f25c);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a(this.a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static Handler a() {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    HandlerThread handlerThread = k;
                    handlerThread.start();
                    l = new Handler(handlerThread.getLooper());
                }
            }
        }
        return l;
    }

    public static void b(Context context, int i2) {
        g = i2;
        long currentTimeMillis = System.currentTimeMillis();
        i = currentTimeMillis;
        long j2 = h;
        long j3 = j2 > 0 ? currentTimeMillis - j2 : -1L;
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "REPORT_TYPE");
        hashMap.put("opt_gap", j3 + "");
        hashMap.put("opt_loadId", h + "");
        hashMap.put("opt_isNormalStart", g + "");
        b(context, "LoadSdk", hashMap);
    }

    public static void c(Context context, String str, Map<String, String> map) {
        a(context, b, str, map);
    }

    public static void a(Runnable runnable) {
        Handler a2 = a();
        if (a2 != null) {
            a2.post(runnable);
        }
    }

    public static void a(Runnable runnable, long j2) {
        Handler a2 = a();
        if (a2 != null) {
            a2.postDelayed(runnable, j2);
        }
    }

    public static void b(Context context, String str, Map<String, String> map) {
        a(context, a, str, map);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("op1", "CHECK_UPDATE");
            hashMap.put("opt_reqbody", str);
            hashMap.put("opt_respbody", str2);
            hashMap.put("opt_action", str3);
            hashMap.put("opt_md5", str4 + "");
            b(context, "LoadSdk", hashMap);
        }
    }

    public static boolean b() {
        if (j == -1) {
            j = new Random().nextInt(10);
        }
        return j == 1;
    }

    public static void a(Context context, String str, String str2, long j2) {
        try {
            if (b()) {
                HashMap hashMap = new HashMap();
                hashMap.put("op1", str);
                hashMap.put("opt_download", "sdk");
                hashMap.put("opt_url", str2 + "");
                if (j2 > 0) {
                    hashMap.put("opt_block_time", j2 + "");
                }
                b(context, "Download", hashMap);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        if (context == null || !b()) {
            return;
        }
        h = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "START");
        hashMap.put("opt_loadId", h + "");
        hashMap.put("opt_isNormalStart", g + "");
        b(context, "LoadSdk", hashMap);
    }

    public static void a(Context context, String str) {
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "LOAD_ERROR");
        hashMap.put("opt_error", str);
        try {
            hashMap.put("opt_process", e.c(context));
        } catch (Throwable unused) {
        }
        b(context, "LoadSdk", hashMap);
    }

    public static void a(Context context, boolean z, boolean z2, boolean z3, long j2, long j3, Map map) {
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "SUCCESS");
        hashMap.put("opt_isRemote", (z ? 1 : 0) + "");
        hashMap.put("opt_unzip", (z2 ? 1 : 0) + "");
        hashMap.put("opt_checkonline", (z3 ? 1 : 0) + "");
        hashMap.put("opt_checkTime", j3 + "");
        hashMap.put("opt_loadId", h + "");
        hashMap.put("opt_loadTime", (System.currentTimeMillis() - j2) + "");
        hashMap.put("opt_gap", (i > 0 ? System.currentTimeMillis() - i : -1L) + "");
        hashMap.put("opt_isNormalStart", g + "");
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        b(context, "LoadSdk", hashMap);
    }

    public static void a(Context context, int i2) {
        if (context == null || !b()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("op1", "Loading");
        hashMap.put("opt_loadId", h + "");
        hashMap.put("opt_step", i2 + "");
        e.append(i2 + "-");
        hashMap.put("opt_path", e.toString());
        long currentTimeMillis = f != 0 ? System.currentTimeMillis() - f : 0L;
        f = System.currentTimeMillis();
        hashMap.put("opt_loadTime", currentTimeMillis + "");
        b(context, "LoadSdk", hashMap);
        Log.i("reportLoadsdkLoading", "step = " + i2 + " , time = " + currentTimeMillis);
    }

    public static void a(Context context, boolean z, boolean z2, boolean z3, String str, long j2, Map map) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("op1", "FAIL");
            hashMap.put("opt_isRemote", (z ? 1 : 0) + "");
            hashMap.put("opt_unzip", (z2 ? 1 : 0) + "");
            hashMap.put("opt_checkonline", (z3 ? 1 : 0) + "");
            hashMap.put("opt_checkTime", j2 + "");
            hashMap.put("opt_cause", str);
            hashMap.put("opt_loadId", h + "");
            hashMap.put("opt_gap", (i > 0 ? System.currentTimeMillis() - i : -1L) + "");
            hashMap.put("opt_isNormalStart", g + "");
            hashMap.put("opt_lyr", "android_cpc_sdk_custom");
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            b(context, "LoadSdk", hashMap);
        }
    }

    public static void a(Context context, String str, String str2, Map map, boolean z, boolean z2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("op1", str);
            hashMap.put("op2", str2);
            hashMap.put("opt_unzip", (z ? 1 : 0) + "");
            hashMap.put("opt_checkonline", (z2 ? 1 : 0) + "");
            hashMap.put("thread_name", Thread.currentThread().getName());
            if (map != null && map.size() > 0) {
                hashMap.putAll(map);
            }
            b(context, "SDKError", hashMap);
        }
    }

    private static void a(Context context, String str, String str2, Map<String, String> map) {
        a aVar = new a(a(str, (Map<String, String>) a(context, str2, map)));
        Handler a2 = a();
        if (a2 != null) {
            a2.post(aVar);
        }
    }

    private static String a(String str, Map<String, String> map) {
        return str + e.a(map);
    }

    private static Map a(Context context, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(ak.x, "Android");
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        hashMap.put("opt_bootstrap_v", f25c);
        hashMap.put("opt_lib_v", d);
        hashMap.put(ak.aH, str + "");
        if (context != null) {
            hashMap.put("opt_app_pkgid", context.getPackageName());
            hashMap.put("opt_app_vn", e.b(context));
            hashMap.put("opt_app_vc", e.a(context) + "");
        }
        hashMap.put("opt_os_version", Build.VERSION.RELEASE + "");
        if (map != null) {
            try {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    hashMap.put(key, map.get(key));
                }
            } catch (Throwable unused) {
            }
        }
        try {
            String str2 = Build.BRAND;
            if (str2 != null) {
                hashMap.put("opt_brand", str2);
            }
            String str3 = Build.MODEL;
            if (str3 != null) {
                hashMap.put("opt_model", str3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public static void a(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            URLConnection openConnection = new URL(str).openConnection();
            try {
                openConnection.connect();
                int responseCode = ((HttpURLConnection) openConnection).getResponseCode();
                if (responseCode != 200) {
                    Log.e("NetUtils", "ERROR " + String.valueOf(responseCode) + " on url \"" + str + "\"");
                }
                try {
                    ((HttpURLConnection) openConnection).disconnect();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    ((HttpURLConnection) openConnection).disconnect();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
    }
}
