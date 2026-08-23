package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: InfoPreference.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class e {
    private static final String a = "info";
    private static final String b = "ua";

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(b, str).commit();
        }
    }

    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString(b, null);
        }
        return null;
    }
}
