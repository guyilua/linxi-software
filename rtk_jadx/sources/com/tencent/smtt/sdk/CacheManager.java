package com.tencent.smtt.sdk;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        t a = t.a();
        if (a != null && a.b()) {
            return ((Boolean) a.c().c()).booleanValue();
        }
        Object a2 = com.tencent.smtt.utils.k.a("android.webkit.CacheManager", "cacheDisabled");
        if (a2 == null) {
            return false;
        }
        return ((Boolean) a2).booleanValue();
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().g();
        }
        try {
            return com.tencent.smtt.utils.k.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", (Class<?>[]) new Class[]{String.class, Map.class}, str, map);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        t a = t.a();
        if (a != null && a.b()) {
            return (File) a.c().g();
        }
        return (File) com.tencent.smtt.utils.k.a("android.webkit.CacheManager", "getCacheFileBaseDir");
    }

    public static InputStream getCacheFile(String str, boolean z) {
        t a = t.a();
        if (a == null || !a.b()) {
            return null;
        }
        return a.c().a(str, z);
    }
}
