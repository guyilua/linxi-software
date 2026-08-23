package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: ApplicationLayerUtil.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a {

    /* compiled from: ApplicationLayerUtil.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class C0130a {
        public String a;
        public String b;
    }

    public static long a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            ULog.e("getAppFirstInstallTime" + e.getMessage());
            return 0L;
        }
    }

    public static long b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            ULog.e("getAppLastUpdateTime:" + e.getMessage());
            return 0L;
        }
    }

    public static void b(Context context) {
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            ULog.e("getAppInstaller:" + e.getMessage());
            return null;
        }
    }

    public static int d(Context context, String str) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getPackageInfo(str, 0).applicationInfo;
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            UMCrashManager.reportCrash(context, e);
            ULog.e("getAppUid:" + e.getMessage());
            return 0;
        }
    }

    public static DisplayMetrics e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static List<InputMethodInfo> f(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    public static List<C0130a> g(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        C0130a c0130a = new C0130a();
                        c0130a.a = str;
                        c0130a.b = e(context, str);
                        arrayList.add(c0130a);
                    }
                }
            }
        } catch (Exception e) {
            ULog.e("getAppList:" + e.getMessage());
        }
        return arrayList;
    }

    public static ActivityManager.MemoryInfo h(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String i(Context context) {
        if (context == null) {
        }
        return null;
    }

    public static String j(Context context) {
        return null;
    }

    private static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (Exception e) {
            ULog.e("getLabel:" + e.getMessage());
            return null;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static boolean a() {
        return g.a();
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static float a(Context context) {
        if (context == null) {
            return com.sigmob.sdk.base.blurkit.c.d;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e) {
            ULog.e("getFontSize:" + e.getMessage());
            return com.sigmob.sdk.base.blurkit.c.d;
        }
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static long c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String d() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : HelperUtils.getUmengMD5(obj);
        } catch (Exception e) {
            ULog.e("getHostName:" + e.getMessage());
            return null;
        }
    }
}
