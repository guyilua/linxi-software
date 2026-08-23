package com.rtk.app.tool;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: SharedPreferencesUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class v {
    public static String a = "commentImgWidth";
    public static String b = "ritchEditWidth";

    /* renamed from: c, reason: collision with root package name */
    public static String f333c = "PostContent";
    public static String d = "PostTitle";
    public static String e = "SearchPostOrUserHistoryValue";
    public static String f = "Home5FragmentBeanValue";
    public static String g = "SearchUpSrcValue";
    public static String h = "CommentShowValue";
    public static String i = "DeletePostLineFeed";
    public static String j = "nightOriginalVALUE";
    public static String k = "PostDeletePostVideoVolume";
    public static String l = "UpLoadCurrentApkPath";
    public static String m = "UpLoadCurrentZipApkPath";

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("ZSSING", 0).getBoolean(str, false);
    }

    public static int b(Context context, String str) {
        return context.getSharedPreferences("ZSSING", 0).getInt(str, 0);
    }

    public static Long c(Context context, String str) {
        return Long.valueOf(context.getSharedPreferences("ZSSING", 0).getLong(str, 0L));
    }

    public static String d(Context context, String str) {
        return context.getSharedPreferences("ZSSING", 0).getString(str, null);
    }

    public static void e(Context context, String str, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("ZSSING", 0).edit();
        edit.putBoolean(str, bool.booleanValue());
        edit.commit();
    }

    public static void f(Context context, String str, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("ZSSING", 0).edit();
        edit.putInt(str, i2);
        edit.commit();
    }

    public static void g(Context context, String str, Long l2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("ZSSING", 0).edit();
        edit.putLong(str, l2.longValue());
        edit.commit();
    }

    public static synchronized void h(Context context, String str, String str2) {
        synchronized (v.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ZSSING", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }
}
