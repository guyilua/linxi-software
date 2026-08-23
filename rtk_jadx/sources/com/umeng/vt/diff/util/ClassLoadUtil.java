package com.umeng.vt.diff.util;

import android.text.TextUtils;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClassLoadUtil {
    public static Class<?> findClass(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
