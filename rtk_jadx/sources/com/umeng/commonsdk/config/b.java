package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CollectController.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b implements f {
    private static Map<String, Boolean> a = new HashMap();
    private static Object b = new Object();

    /* compiled from: CollectController.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.a;
    }

    public void a() {
        synchronized (b) {
            a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (b) {
            if (!a.containsKey(str)) {
                return true;
            }
            return a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                Map<String, Boolean> map = a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
