package com.tencent.smtt.sdk;

import android.content.Context;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebViewDatabase {
    private static WebViewDatabase a;
    private Context b;

    protected WebViewDatabase(Context context) {
        this.b = context;
    }

    private static synchronized WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (a == null) {
                a = new WebViewDatabase(context);
            }
            webViewDatabase = a;
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        return a(context);
    }

    public void clearFormData() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().g(this.b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
        }
    }

    public void clearHttpAuthUsernamePassword() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().e(this.b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().c(this.b);
        } else {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
        }
    }

    public boolean hasFormData() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().f(this.b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
    }

    public boolean hasHttpAuthUsernamePassword() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().d(this.b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            return a2.c().b(this.b);
        }
        return android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
    }
}
