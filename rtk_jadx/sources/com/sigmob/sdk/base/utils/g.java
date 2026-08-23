package com.sigmob.sdk.base.utils;

import android.content.SharedPreferences;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class g {
    private static String a = "com.wind.Settings";

    private g() {
    }

    public static int a(String str, int i) {
        return com.sigmob.sdk.b.e().getSharedPreferences(a, 4).getInt(str, i);
    }

    public static SharedPreferences a() {
        return com.sigmob.sdk.b.e().getSharedPreferences(a, 4);
    }

    public static SharedPreferences a(String str) {
        return com.sigmob.sdk.b.e().getSharedPreferences(str, 4);
    }

    public static String a(String str, String str2) {
        return com.sigmob.sdk.b.e().getSharedPreferences(a, 4).getString(str, str2);
    }
}
