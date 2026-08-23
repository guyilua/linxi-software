package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PreferenceWrapper {
    private static final String DEFAULT_PREFERENCE = "umeng_general_config";

    private PreferenceWrapper() {
    }

    public static SharedPreferences getDefault(Context context) {
        if (context != null) {
            return context.getSharedPreferences("umeng_general_config", 0);
        }
        return null;
    }

    public static SharedPreferences getInstance(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
