package com.rtk.app.c;

import java.lang.reflect.Method;

/* compiled from: SystemProperties.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    static Method a;

    static {
        try {
            a = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String a(String str) {
        try {
            Method method = a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
