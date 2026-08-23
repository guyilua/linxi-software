package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* compiled from: TEnumHelper.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ay {
    public static ax a(Class<? extends ax> cls, int i) {
        try {
            return (ax) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
