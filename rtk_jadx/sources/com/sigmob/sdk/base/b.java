package com.sigmob.sdk.base;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class b {
    static c a;

    static {
        try {
            if (l.a().V()) {
                a = new d();
            }
        } catch (Throwable unused) {
        }
        if (a == null) {
            a = new c();
        }
    }

    public static WebResourceResponse a(Uri uri) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WebResourceResponse a(String str, String str2, Map<String, String> map) {
        if ((!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) || str2.equals("POST")) {
            return null;
        }
        try {
            c cVar = a;
            if (cVar != null) {
                return cVar.a(str, str2, map);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean a(String str) {
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            String lastPathSegment = parse.getLastPathSegment();
            if (host == null || h.a(str) || !parse.getScheme().startsWith("http") || host.equals("localhost") || host.equals("127.0.0.1") || !TextUtils.isEmpty(parse.getQueryParameter("no-cache"))) {
                return true;
            }
            if (lastPathSegment.endsWith(".js")) {
                return false;
            }
            return !lastPathSegment.endsWith(".css");
        } catch (Throwable unused) {
            return false;
        }
    }
}
