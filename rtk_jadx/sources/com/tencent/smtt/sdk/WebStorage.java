package com.tencent.smtt.sdk;

import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebStorage {
    private static WebStorage a;

    @Deprecated
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    private static synchronized WebStorage a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (a == null) {
                a = new WebStorage();
            }
            webStorage = a;
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return a();
    }

    public void deleteAllData() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().n();
        } else {
            android.webkit.WebStorage.getInstance().deleteAllData();
        }
    }

    public void deleteOrigin(String str) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().e(str);
        } else {
            android.webkit.WebStorage.getInstance().deleteOrigin(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().a(valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getOrigins(valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().b(str, valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getQuotaForOrigin(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().a(str, valueCallback);
        } else {
            android.webkit.WebStorage.getInstance().getUsageForOrigin(str, valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().a(str, j);
        } else {
            android.webkit.WebStorage.getInstance().setQuotaForOrigin(str, j);
        }
    }
}
