package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    public static String a = null;
    public static String b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f821c = null;
    private static String d = "";
    private static String e;
    private static String f;
    private static String g;
    private static Boolean h;

    public static boolean a() {
        return a("EMUI") || a("MAGICUI");
    }

    public static boolean b() {
        return a("MAGICUI");
    }

    public static boolean c() {
        return a("MIUI");
    }

    public static boolean d() {
        return a("VIVO");
    }

    public static boolean e() {
        r();
        return a(a);
    }

    public static boolean f() {
        return a("FLYME");
    }

    public static boolean g() {
        return a("SAMSUNG");
    }

    public static String h() {
        if (e == null) {
            a("");
        }
        return e;
    }

    public static String i() {
        if (f == null) {
            a("");
        }
        return f;
    }

    public static String j() {
        if (f821c == null) {
            a("");
        }
        return f821c;
    }

    @NonNull
    public static String k() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    @NonNull
    public static String l() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean m() {
        s();
        return "V10".equals(g);
    }

    public static boolean n() {
        s();
        return "V11".equals(g);
    }

    public static boolean o() {
        s();
        return "V12".equals(g);
    }

    public static boolean p() {
        if (h == null) {
            h = Boolean.valueOf(d.g().equals("harmony"));
        }
        return h.booleanValue();
    }

    public static boolean q() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor");
    }

    private static void r() {
        if (TextUtils.isEmpty(a)) {
            com.ss.android.socialbase.downloader.downloader.c.G();
            a = com.ss.android.socialbase.downloader.constants.e.b;
            d = "ro.build.version." + com.ss.android.socialbase.downloader.constants.e.f843c + "rom";
            b = "com." + com.ss.android.socialbase.downloader.constants.e.f843c + ".market";
        }
    }

    private static void s() {
        if (g == null) {
            try {
                g = d("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = g;
            if (str == null) {
                str = "";
            }
            g = str;
        }
    }

    public static boolean a(String str) {
        r();
        String str2 = e;
        if (str2 != null) {
            return str2.equals(str);
        }
        String d2 = d("ro.miui.ui.version.name");
        f = d2;
        if (!TextUtils.isEmpty(d2)) {
            e = "MIUI";
            f821c = "com.xiaomi.market";
            g = f;
        } else {
            String d3 = d("ro.build.version.emui");
            f = d3;
            if (!TextUtils.isEmpty(d3)) {
                String str3 = q() ? "MAGICUI" : "EMUI";
                e = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    f821c = "com.hihonor.appmarket";
                } else {
                    f821c = "com.huawei.appmarket";
                }
            } else {
                String d4 = d("ro.build.version.magic");
                f = d4;
                if (!TextUtils.isEmpty(d4)) {
                    e = "MAGICUI";
                    f821c = "com.hihonor.appmarket";
                } else {
                    String d5 = d(d);
                    f = d5;
                    if (!TextUtils.isEmpty(d5)) {
                        e = a;
                        if (g.a(b) >= 0) {
                            f821c = b;
                        } else {
                            f821c = "com.heytap.market";
                        }
                    } else {
                        String d6 = d("ro.vivo.os.version");
                        f = d6;
                        if (!TextUtils.isEmpty(d6)) {
                            e = "VIVO";
                            f821c = "com.bbk.appstore";
                        } else {
                            String d7 = d("ro.smartisan.version");
                            f = d7;
                            if (!TextUtils.isEmpty(d7)) {
                                e = "SMARTISAN";
                                f821c = "com.smartisanos.appstore";
                            } else {
                                String d8 = d("ro.gn.sv.version");
                                f = d8;
                                if (!TextUtils.isEmpty(d8)) {
                                    e = "QIONEE";
                                    f821c = "com.gionee.aora.market";
                                } else {
                                    String d9 = d("ro.lenovo.lvp.version");
                                    f = d9;
                                    if (!TextUtils.isEmpty(d9)) {
                                        e = "LENOVO";
                                        f821c = "com.lenovo.leos.appstore";
                                    } else if (k().toUpperCase().contains("SAMSUNG")) {
                                        e = "SAMSUNG";
                                        f821c = "com.sec.android.app.samsungapps";
                                    } else if (k().toUpperCase().contains("ZTE")) {
                                        e = "ZTE";
                                        f821c = "zte.com.market";
                                    } else if (k().toUpperCase().contains("NUBIA")) {
                                        e = "NUBIA";
                                        f821c = "cn.nubia.neostore";
                                    } else if (l().toUpperCase().contains("FLYME")) {
                                        e = "FLYME";
                                        f821c = "com.meizu.mstore";
                                        f = l();
                                    } else if (k().toUpperCase().contains("ONEPLUS")) {
                                        e = "ONEPLUS";
                                        f = d("ro.rom.version");
                                        if (g.a(b) >= 0) {
                                            f821c = b;
                                        } else {
                                            f821c = "com.heytap.market";
                                        }
                                    } else {
                                        e = k().toUpperCase();
                                        f821c = "";
                                        f = "";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return e.equals(str);
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            com.ss.android.socialbase.downloader.i.f.a(bufferedReader);
            return readLine;
        } catch (Throwable unused2) {
            com.ss.android.socialbase.downloader.i.f.a(bufferedReader);
            return null;
        }
    }

    public static String c(String str) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static String d(String str) {
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return c(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return b(str);
    }
}
