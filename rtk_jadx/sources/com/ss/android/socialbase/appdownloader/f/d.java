package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d {
    private static String a;
    private static String b;

    /* renamed from: c, reason: collision with root package name */
    private static String f820c;
    private static String d;
    private static Boolean e;

    public static boolean a(Context context) {
        return context != null && c(context) == 0 && e();
    }

    public static boolean b(Context context) {
        return context != null && d(context) == 0 && f();
    }

    public static String c() {
        if (f820c == null) {
            f820c = a("getReleaseType");
        }
        return f820c;
    }

    public static String d() {
        if (d == null) {
            d = a("getBuildVersion");
        }
        return d;
    }

    public static boolean e() {
        if (e == null) {
            e = Boolean.FALSE;
            try {
                e = Boolean.valueOf("156".equals(a("ro.config.hw_optb", "0")) && "true".equals(a("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return e.booleanValue();
    }

    public static boolean f() {
        return e() && b(b(), a()) && a(Process.myUid()) == 0;
    }

    public static String g() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a() {
        if (a == null) {
            a = a("getApiVersion");
        }
        return a;
    }

    public static String b() {
        if (b == null) {
            b = a("getVersion");
        }
        return b;
    }

    public static int c(Context context) {
        if (context == null) {
            return 1;
        }
        if (b(b(), a())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int d(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static boolean b(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith(GlobalSetting.SPLASH_AD);
    }

    private static int a(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
