package com.tencent.smtt.sdk;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class URLUtil {
    public static String composeSearchUrl(String str, String str2, String str3) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().a(str, str2, str3);
        }
        return android.webkit.URLUtil.composeSearchUrl(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().a(bArr);
        }
        return android.webkit.URLUtil.decode(bArr);
    }

    public static final String guessFileName(String str, String str2, String str3) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().b(str, str2, str3);
        }
        return android.webkit.URLUtil.guessFileName(str, str2, str3);
    }

    public static String guessUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().m(str);
        }
        return android.webkit.URLUtil.guessUrl(str);
    }

    public static boolean isAboutUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().q(str);
        }
        return android.webkit.URLUtil.isAboutUrl(str);
    }

    public static boolean isAssetUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().n(str);
        }
        return android.webkit.URLUtil.isAssetUrl(str);
    }

    public static boolean isContentUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().w(str);
        }
        return android.webkit.URLUtil.isContentUrl(str);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().o(str);
        }
        return android.webkit.URLUtil.isCookielessProxyUrl(str);
    }

    public static boolean isDataUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().r(str);
        }
        return android.webkit.URLUtil.isDataUrl(str);
    }

    public static boolean isFileUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().p(str);
        }
        return android.webkit.URLUtil.isFileUrl(str);
    }

    public static boolean isHttpUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().t(str);
        }
        return android.webkit.URLUtil.isHttpUrl(str);
    }

    public static boolean isHttpsUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().u(str);
        }
        return android.webkit.URLUtil.isHttpsUrl(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().s(str);
        }
        return android.webkit.URLUtil.isJavaScriptUrl(str);
    }

    public static boolean isNetworkUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().v(str);
        }
        return android.webkit.URLUtil.isNetworkUrl(str);
    }

    public static boolean isValidUrl(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().x(str);
        }
        return android.webkit.URLUtil.isValidUrl(str);
    }

    public static String stripAnchor(String str) {
        t a = t.a();
        if (a != null && a.b()) {
            return a.c().y(str);
        }
        return android.webkit.URLUtil.stripAnchor(str);
    }
}
