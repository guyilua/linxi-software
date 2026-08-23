package com.qumeng.advlib.open.oaid;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class c {
    private c() {
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static boolean b() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public static boolean c() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean e() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean f() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean g() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(a("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean h() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean i() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(a("ro.vivo.os.version", ""));
    }

    public static boolean j() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean a() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }
}
