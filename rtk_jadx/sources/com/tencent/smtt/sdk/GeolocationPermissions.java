package com.tencent.smtt.sdk;

import java.util.Set;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GeolocationPermissions {
    private static GeolocationPermissions a;

    private static synchronized GeolocationPermissions a() {
        GeolocationPermissions geolocationPermissions;
        synchronized (GeolocationPermissions.class) {
            if (a == null) {
                a = new GeolocationPermissions();
            }
            geolocationPermissions = a;
        }
        return geolocationPermissions;
    }

    public static GeolocationPermissions getInstance() {
        return a();
    }

    public void allow(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().g(str);
        } else {
            android.webkit.GeolocationPermissions.getInstance().allow(str);
        }
    }

    public void clear(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().f(str);
        } else {
            android.webkit.GeolocationPermissions.getInstance().clear(str);
        }
    }

    public void clearAll() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().o();
        } else {
            android.webkit.GeolocationPermissions.getInstance().clearAll();
        }
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().c(str, valueCallback);
        } else {
            android.webkit.GeolocationPermissions.getInstance().getAllowed(str, valueCallback);
        }
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b(valueCallback);
        } else {
            android.webkit.GeolocationPermissions.getInstance().getOrigins(valueCallback);
        }
    }
}
