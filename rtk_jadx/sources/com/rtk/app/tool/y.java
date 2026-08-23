package com.rtk.app.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.LinearLayout;
import c.d.a.d;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.bean.HomeAdBean;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.QqLoginBean;
import com.rtk.app.bean.WxLoginBean;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MyApplication;
import com.rtk.app.main.login.LoginActivity;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: StaticValue.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class y {
    private static String A = null;
    private static String B = null;
    private static int D = 0;
    private static final HashMap<String, String> G;
    private static Home5ImfromationBean H = null;
    public static boolean a = false;
    public static boolean b = true;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f335c = false;
    public static String d = "http://rtkapi.ruansky.net/";
    public static String e = "https://rtkapi2.ruansky.net/";
    public static HomeAdBean o;
    public static String[] f = {"bIS1dEpwM4K1b3GxbT6zeXGvd3u6Mn6meD9>", "bIS1dEpwM4K1b3GxbT67bHmjZX:4ZX5vcnW1Mx>>", "bIS1dEpwM4K1b3GxbT67bHm5bXGwfX:2Mn6meD9>", "bIS1dEpwM4K1b3GxbT67bHm5bXGwfX:2MnOwcT9>"};
    public static String g = "address/address";
    public static String h = "address/test";
    public static String i = "http://down.ruansky.com/";
    public static String j = "http://video.upload.ruansky.com/";
    public static String k = "html/file/appsUploadApk";
    public static String l = "html/filelist/concatDataBag";
    public static String m = "html/filelist/uploadVideoNew";
    public static String n = "members/createVideo";
    private static String p = "";
    public static int q = 3;
    public static int r = 2;
    private static String s = "";
    private static String t = null;
    private static String u = null;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static int y = 0;
    private static boolean z = true;
    public static int C = 20;
    public static String E = "请检查您的网络";
    private static int F = 0;

    /* compiled from: StaticValue.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class a implements Runnable {
        final /* synthetic */ LinearLayout a;
        final /* synthetic */ Context b;

        a(LinearLayout linearLayout, Context context) {
            this.a = linearLayout;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = y.y = (this.a.getMeasuredWidth() - this.a.getPaddingLeft()) + this.a.getPaddingRight();
            v.f(this.b, v.a, y.y);
        }
    }

    /* compiled from: StaticValue.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class b implements Runnable {
        final /* synthetic */ RichEditText a;
        final /* synthetic */ Context b;

        b(RichEditText richEditText, Context context) {
            this.a = richEditText;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = y.D = (this.a.getMeasuredWidth() - this.a.getPaddingLeft()) + this.a.getPaddingRight();
            v.f(this.b, v.b, y.D);
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        G = hashMap;
        Context b2 = MyApplication.b();
        hashMap.put("channel", m(b2, b2.getPackageName()));
        hashMap.put("version", i(b2));
        hashMap.put(ak.aj, g());
        hashMap.put("phone_model", T());
        hashMap.put(z("os_info"), y());
    }

    public static boolean A() {
        H = (Home5ImfromationBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(v.d(MyApplication.b(), v.f), Home5ImfromationBean.class);
        if (d.d() && !c0.q(MainActivity.p.getData().getQqLogin().getOpenid())) {
            c0.u("StaticValue", "绑定过QQ");
            return true;
        }
        Home5ImfromationBean home5ImfromationBean = H;
        if (home5ImfromationBean != null && home5ImfromationBean.getData().getWxLogin() != null && !c0.q(H.getData().getWxLogin().getUnionid())) {
            c0.u("StaticValue", "绑定过qq");
            return true;
        }
        return false;
    }

    public static boolean B() {
        H = (Home5ImfromationBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(v.d(MyApplication.b(), v.f), Home5ImfromationBean.class);
        try {
            if (d.d() && (!c0.q(MainActivity.p.getData().getQqLogin().getOpenid()) || !c0.q(MainActivity.p.getData().getWxLogin().getUnionid()))) {
                StringBuilder sb = new StringBuilder();
                sb.append("1绑定过QQ、微信   ");
                sb.append(d.d());
                sb.append("   ");
                sb.append(!c0.q(MainActivity.p.getData().getQqLogin().getOpenid()));
                sb.append("  ");
                sb.append(!c0.q(MainActivity.p.getData().getWxLogin().getUnionid()));
                c0.u("StaticValue", sb.toString());
                return true;
            }
            Home5ImfromationBean home5ImfromationBean = H;
            if (home5ImfromationBean == null || ((home5ImfromationBean.getData().getQqLogin() == null || c0.q(H.getData().getQqLogin().getOpenid())) && (H.getData().getWxLogin() == null || c0.q(H.getData().getWxLogin().getUnionid())))) {
                return false;
            }
            c0.u("StaticValue", "2绑定过QQ、微信");
            return true;
        } catch (Exception e2) {
            c0.u("StaticValue", "获取账户状态有异常" + e2.toString());
            return false;
        }
    }

    public static String C(Context context) {
        File file = new File(context.getExternalFilesDir(null) + "/");
        if (c0.q(p) && context != null) {
            p = file.getAbsolutePath();
        }
        File file2 = new File(p + "/apk/");
        File file3 = new File(p + "/zip/");
        File file4 = new File(p + "/picture/");
        File file5 = new File(p + "/files/outapk/");
        if (!file.exists() || !file2.exists() || !file3.exists() || !file4.exists() || !file5.exists()) {
            file.mkdirs();
            file2.mkdirs();
            file3.mkdirs();
            file4.mkdirs();
            file5.mkdirs();
        }
        return p;
    }

    public static String D() {
        return Build.VERSION.RELEASE;
    }

    private static String E() {
        String a2 = com.rtk.app.c.c.a("ro.build.version.sep");
        if (TextUtils.isEmpty(a2)) {
            return a2;
        }
        String a3 = com.rtk.app.c.c.a("ro.build.version.sem");
        try {
            if (Integer.parseInt(a2) >= 100000) {
                return "V1_One UI_" + a2 + "_" + a3;
            }
            return "V1_Samsung Experience_" + a2 + "_" + a3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean F() {
        return z;
    }

    public static String G(Context context) {
        LoginBean loginBean = MainActivity.p;
        if (loginBean != null && loginBean.getData() != null && !c0.q(MainActivity.p.getData().getToken())) {
            A = MainActivity.p.getData().getToken();
        } else {
            e(context);
            MainActivity.p = null;
            ((Activity) context).startActivityForResult(new Intent(context, (Class<?>) LoginActivity.class), 1);
            f.a(context, "请先登录", f.a.f);
            c0.u("StaticValue", "获取Token");
        }
        return A;
    }

    public static String H() {
        LoginBean loginBean = MainActivity.p;
        return (loginBean == null || loginBean.getData() == null || c0.q(MainActivity.p.getData().getToken())) ? "" : MainActivity.p.getData().getToken();
    }

    public static int I(Context context) {
        LoginBean loginBean = MainActivity.p;
        if (loginBean != null && loginBean.getData() != null && MainActivity.p.getData().getUid() != 0) {
            return MainActivity.p.getData().getUid();
        }
        e(context);
        MainActivity.p = null;
        ((Activity) context).startActivityForResult(new Intent(context, (Class<?>) LoginActivity.class), 1);
        f.a(context, "请先登录！", f.a.f);
        c0.u("StaticValue", "获取Uid");
        return 0;
    }

    public static String J(Context context) {
        if (!x(context)) {
            return "";
        }
        return "&uid=" + K() + "&token=" + H();
    }

    public static String K() {
        LoginBean loginBean = MainActivity.p;
        if (loginBean == null || loginBean.getData() == null || MainActivity.p.getData().getUid() == 0) {
            return "0";
        }
        return "" + MainActivity.p.getData().getUid();
    }

    public static boolean L() {
        H = (Home5ImfromationBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(v.d(MyApplication.b(), v.f), Home5ImfromationBean.class);
        try {
            if (d.d() && !c0.q(MainActivity.p.getData().getWxLogin().getUnionid())) {
                c0.u("StaticValue", "绑定过微信");
                return true;
            }
            Home5ImfromationBean home5ImfromationBean = H;
            if (home5ImfromationBean == null || home5ImfromationBean.getData().getWxLogin() == null || c0.q(H.getData().getWxLogin().getUnionid())) {
                return false;
            }
            c0.u("StaticValue", "绑定过微信");
            return true;
        } catch (Exception e2) {
            c0.u("StaticValue", "获取账户状态有异常" + e2.toString());
            return false;
        }
    }

    public static synchronized int M(Context context) {
        int i2;
        synchronized (y.class) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (x == 0) {
                x = windowManager.getDefaultDisplay().getWidth();
            }
            i2 = x;
        }
        return i2;
    }

    public static boolean N() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int O(Context context, LinearLayout linearLayout) {
        if (y == 0) {
            y = v.b(context, v.a);
        }
        linearLayout.post(new a(linearLayout, context));
        return y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int P(Context context, RichEditText richEditText) {
        if (D == 0) {
            D = v.b(context, v.b);
        }
        richEditText.post(new b(richEditText, context));
        return D;
    }

    public static boolean Q(String str, String str2, String str3) {
        String d2 = v.d(MyApplication.b(), v.f);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (H == null) {
            H = (Home5ImfromationBean) create.fromJson(d2, Home5ImfromationBean.class);
        }
        QqLoginBean qqLoginBean = new QqLoginBean();
        qqLoginBean.setOpenid(str);
        qqLoginBean.setQ_face(str2);
        qqLoginBean.setQ_nickname(str3);
        H.getData().setQqLogin(qqLoginBean);
        v.h(MyApplication.b(), v.f, create.toJson(H));
        return true;
    }

    public static boolean R(String str, String str2, String str3) {
        String d2 = v.d(MyApplication.b(), v.f);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (H == null) {
            H = (Home5ImfromationBean) create.fromJson(d2, Home5ImfromationBean.class);
        }
        WxLoginBean wxLoginBean = new WxLoginBean();
        wxLoginBean.setUnionid(str);
        wxLoginBean.setW_face(str2);
        wxLoginBean.setW_nickname(str3);
        H.getData().setWxLogin(wxLoginBean);
        v.h(MyApplication.b(), v.f, create.toJson(H));
        return true;
    }

    public static void S(boolean z2, s sVar) {
        c0.u("StaticValue", " isDay " + z + " themeIsDay " + z2);
        if (z != z2) {
            z = z2;
            Context context = MainActivity.o;
            if (context != null) {
                ((Activity) context).recreate();
                if (sVar != null) {
                    sVar.a(new String[0]);
                }
            }
        }
    }

    public static String T() {
        return c0.b(Build.BRAND + "_" + Build.MODEL);
    }

    public static void e(Context context) {
        v.h(context, "userPsw", "");
        v.h(context, "userInformation", "");
        v.h(context, v.f, "");
    }

    public static int f(Context context) {
        if (v == 0) {
            v = (int) (context.getResources().getDisplayMetrics().density + 0.5f);
        }
        return v;
    }

    public static String g() {
        return Build.VERSION.SDK;
    }

    public static int h() {
        int i2 = Build.VERSION.SDK_INT;
        F = i2;
        return i2;
    }

    public static synchronized String i(Context context) {
        String str;
        synchronized (y.class) {
            int i2 = 0;
            if (c0.q(s)) {
                try {
                    i2 = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                    Log.i("TAG", "本软件的版本号。。" + i2);
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
                s = i2 + "";
            }
            str = s;
        }
        return str;
    }

    public static boolean j() {
        LoginBean loginBean = MainActivity.p;
        return (loginBean == null || loginBean.getData() == null || MainActivity.p.getData().getAuthority() == null) ? false : true;
    }

    public static HashMap<String, String> k() {
        return new HashMap<>(G);
    }

    public static HashMap<String, String> l() {
        HashMap<String, String> k2 = k();
        k2.put("uid", K());
        k2.put("token", H());
        return k2;
    }

    public static synchronized String m(Context context, String str) {
        String str2;
        synchronized (y.class) {
            try {
                t = context.getPackageManager().getApplicationInfo(str, 128).metaData.getString("UMENG_CHANNEL");
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            str2 = t;
        }
        return str2;
    }

    public static String n() {
        return "1";
    }

    public static String o(Context context) {
        if (c0.q(B)) {
            B = Settings.System.getString(context.getContentResolver(), "android_id");
        }
        return B;
    }

    public static synchronized String p(Context context) {
        String str;
        synchronized (y.class) {
            str = Build.BRAND + "_" + Build.MODEL;
        }
        return str;
    }

    public static synchronized int q() {
        int size;
        synchronized (y.class) {
            size = com.rtk.app.tool.g.c.e(MyApplication.b()).c(com.rtk.app.tool.DownLoadTool.q.b, com.rtk.app.tool.DownLoadTool.q.e).size();
            w = size;
        }
        return size;
    }

    public static String r(Context context) {
        String o2 = o(context);
        int length = o2.length();
        int i2 = length / 8;
        int i3 = length % 8;
        String str = "";
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i4 * 8;
            i4++;
            str = str + new StringBuffer(o2.substring(i5, i4 * 8)).reverse().toString();
        }
        int i6 = i2 * 8;
        return "2a" + (str + new StringBuffer(o2.substring(i6, i3 + i6)).reverse().toString()) + "d9";
    }

    public static List<String> s(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map == null) {
            return arrayList;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!key.startsWith("$*$")) {
                arrayList.add(key + "=" + value);
            }
        }
        return arrayList;
    }

    public static String t(Context context) {
        return "";
    }

    public static String u(Context context) {
        if (c0.q(u)) {
            u = "?channel=" + m(context, context.getPackageName()) + "&version=" + i(context) + "&api_level=" + g() + "&phone_model=" + T() + "&os_info=" + y();
        }
        return u;
    }

    public static List<String> v(Context context, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].startsWith("$*$")) {
                arrayList.add(strArr[i2].replaceFirst("$*$", ""));
            } else {
                arrayList.add(strArr[i2]);
            }
        }
        arrayList.add("channel=" + m(MyApplication.b(), MyApplication.b().getPackageName()));
        arrayList.add("version=" + i(MyApplication.b()));
        arrayList.add("api_level=" + g());
        arrayList.add("phone_model=" + T());
        return arrayList;
    }

    public static String w(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        sb.append("?");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.startsWith("$*$")) {
                key = key.replace("$*$", "");
            }
            sb.append("&");
            sb.append(key);
            sb.append("=");
            sb.append(value);
        }
        return sb.toString();
    }

    public static boolean x(Context context) {
        c0.u("StaticValue", new Gson().toJson(MainActivity.p));
        LoginBean loginBean = MainActivity.p;
        return (loginBean == null || loginBean.getData() == null || MainActivity.p.getData().getUid() == 0 || c0.q(MainActivity.p.getData().getToken())) ? false : true;
    }

    public static String y() {
        try {
            String a2 = com.rtk.app.c.c.a("hw_sc.build.platform.version");
            if (!TextUtils.isEmpty(a2)) {
                return "V1__HarmonyOS__" + a2;
            }
            String a3 = com.rtk.app.c.c.a("ro.build.version.magic");
            if (!TextUtils.isEmpty(a3)) {
                return "V1__MagicOS__" + a3;
            }
            String a4 = com.rtk.app.c.c.a("ro.build.version.emui");
            if (!TextUtils.isEmpty(a4)) {
                return "V1__EmotionUI__" + a4;
            }
            String a5 = com.rtk.app.c.c.a("ro.mi.os.version.incremental");
            String a6 = com.rtk.app.c.c.a("ro.miui.ui.version.code");
            String a7 = com.rtk.app.c.c.a("ro.build.version.incremental");
            if (!TextUtils.isEmpty(a5)) {
                return "V1__HyperOS__" + a5 + "__" + a7 + "__" + a6;
            }
            if (!TextUtils.isEmpty(a6)) {
                return "V1__MIUI__" + a7 + "__" + a6;
            }
            String a8 = com.rtk.app.c.c.a("ro.vivo.os.build.display.id");
            if (!TextUtils.isEmpty(a8)) {
                String a9 = com.rtk.app.c.c.a("ro.vivo.os.version");
                if (a8.contains("Origin")) {
                    return "V1__OriginOS__" + a8 + "__" + a9;
                }
                if (a8.contains("Funtouch")) {
                    return "V1__FuntouchOS__" + a8 + "__" + a9;
                }
            }
            String a10 = com.rtk.app.c.c.a("ro.build.version.opporom");
            if (!TextUtils.isEmpty(a10)) {
                return "V1__ColorOS__" + a10;
            }
            String a11 = com.rtk.app.c.c.a("ro.build.version.oplusrom");
            if (!TextUtils.isEmpty(a11)) {
                return "V1__ColorOS__" + a11;
            }
            String a12 = com.rtk.app.c.c.a("ro.build.version.realmeui");
            if (!TextUtils.isEmpty(a12)) {
                return "V1__realmeUI__" + a12;
            }
            String a13 = com.rtk.app.c.c.a("ro.build.nubia.rom.name");
            if (!TextUtils.isEmpty(a13)) {
                return "V1__nubiaUI__" + a13 + "__" + com.rtk.app.c.c.a("ro.build.nubia.rom.code");
            }
            String a14 = com.rtk.app.c.c.a("ro.build.display.id");
            if (!TextUtils.isEmpty(a14)) {
                String lowerCase = a14.toLowerCase();
                if (lowerCase.contains("flyme")) {
                    return "V1__Flyme__" + a14;
                }
                if (lowerCase.contains("myos")) {
                    return "V1__MyOS__" + a14;
                }
            }
            String E2 = E();
            return !TextUtils.isEmpty(E2) ? E2 : "V1__unknown";
        } catch (Exception e2) {
            c0.r("StaticValue", e2.getMessage());
            return "V1__unknown";
        }
    }

    public static String z(String str) {
        return "$*$" + str;
    }
}
