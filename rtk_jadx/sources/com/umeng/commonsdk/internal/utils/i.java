package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: UMInternalUtils.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class i {
    private static final String a = "um_pri";
    private static final String b = "um_common_strength";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1095c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f1095c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f1095c, str).commit();
    }
}
