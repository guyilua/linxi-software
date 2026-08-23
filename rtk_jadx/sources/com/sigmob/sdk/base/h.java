package com.sigmob.sdk.base;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class h extends WebViewClient {
    static final String a = "Set-Cookie";
    static final String b = "Referer";

    /* renamed from: c, reason: collision with root package name */
    private static final String f404c = "mraid.js";
    private static final String d = "mraid2.js";
    private static final String e = "Cookie";
    private CookieManager f = new CookieManager();
    private boolean g = false;
    private boolean h = false;
    private String i;

    public static WebResourceResponse a(Uri uri) {
        if (!uri.getScheme().startsWith(k.y)) {
            return null;
        }
        try {
            File file = new File(uri.getPath());
            if (file.exists()) {
                return new WebResourceResponse("text/html", "utf-8", new FileInputStream(file));
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static File a(WebResourceResponse webResourceResponse, String str) {
        try {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (b.a(str)) {
                return null;
            }
            File file = new File(com.sigmob.sdk.base.utils.e.c(), lastPathSegment);
            FileUtil.writeToCache(webResourceResponse.getData(), file.getAbsolutePath());
            return file;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, CookieManager cookieManager) {
        if (cookieManager == null || httpURLConnection == null) {
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        SigmobLog.d("headerFields : " + headerFields.toString());
        List<String> list = headerFields.get(a);
        if (list != null) {
            for (String str : list) {
                try {
                    List<HttpCookie> parse = HttpCookie.parse(str);
                    if (parse != null) {
                        SigmobLog.d("{0} -- Reading Cookies from the response :" + httpURLConnection.getURL().toString());
                        SigmobLog.d("{0} -- Reading Cookies from the response :" + parse.get(0));
                        for (HttpCookie httpCookie : parse) {
                            SigmobLog.d(httpCookie.toString());
                            android.webkit.CookieManager.getInstance().setCookie(httpURLConnection.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                        }
                    }
                } catch (NullPointerException unused) {
                    SigmobLog.e(MessageFormat.format("{0} -- Null header for the cookie : {1}", httpURLConnection.getURL().toString(), str.toString()));
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                android.webkit.CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(String str) {
        Uri parse = Uri.parse(str.toLowerCase(Locale.US));
        return f404c.equals(parse.getLastPathSegment()) || d.equals(parse.getLastPathSegment());
    }

    private WebResourceResponse c(String str) {
        Uri parse;
        String host;
        String lastPathSegment;
        try {
            parse = Uri.parse(str);
            host = parse.getHost();
            lastPathSegment = parse.getLastPathSegment();
        } catch (Throwable th) {
            SigmobLog.e("useWebResourceCache ", th);
        }
        if (host != null && !a(str) && parse.getScheme().startsWith("http") && !host.equals("127.0.0.1") && TextUtils.isEmpty(parse.getQueryParameter("no-cache")) && (lastPathSegment.endsWith(".js") || lastPathSegment.endsWith(".css"))) {
            File file = new File(com.sigmob.sdk.base.utils.e.c(), lastPathSegment);
            String str2 = lastPathSegment.endsWith(".js") ? "text/javascript" : lastPathSegment.endsWith(".css") ? "text/css" : null;
            if (file.exists()) {
                WebResourceResponse webResourceResponse = new WebResourceResponse(str2, "UTF-8", new FileInputStream(file));
                HashMap hashMap = new HashMap();
                hashMap.put("Cache-Control", "no-store");
                if (Build.VERSION.SDK_INT >= 21) {
                    webResourceResponse.setResponseHeaders(hashMap);
                }
                return webResourceResponse;
            }
            return null;
        }
        return null;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(String str) {
        try {
            Uri parse = Uri.parse(str);
            this.i = parse.getScheme() + "://" + parse.getHost() + "/" + parse.getPath();
        } catch (Throwable unused) {
        }
    }

    public void b(boolean z) {
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    @SuppressLint({"NewApi"})
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponse;
        File a2;
        try {
            webResourceResponse = a(webResourceRequest.getUrl());
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
        } catch (Throwable unused) {
            webResourceResponse = null;
        }
        if (this.h && (webResourceResponse = c(webResourceRequest.getUrl().toString())) != null) {
            return webResourceResponse;
        }
        if ((this.g || (this.h && !b.a(webResourceRequest.getUrl().toString()))) && !a(webResourceRequest.getUrl().toString())) {
            webResourceResponse = b.a(webResourceRequest.getUrl().toString(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
        }
        if (webResourceResponse == null) {
            webResourceResponse = super.shouldInterceptRequest(webView, webResourceRequest);
        }
        if (this.h && webResourceResponse != null && (a2 = a(webResourceResponse, webResourceRequest.getUrl().toString())) != null && a2.exists()) {
            try {
                return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), new FileInputStream(a2));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponse;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse webResourceResponse;
        File a2;
        try {
            webResourceResponse = a(Uri.parse(str));
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
        } catch (Throwable unused) {
            webResourceResponse = null;
        }
        if (this.h && (webResourceResponse = c(str)) != null) {
            return webResourceResponse;
        }
        if ((this.g || (this.h && !b.a(str))) && !a(str)) {
            webResourceResponse = b.a(str, "GET", null);
        }
        if (webResourceResponse == null) {
            webResourceResponse = super.shouldInterceptRequest(webView, str);
        }
        if (this.h && webResourceResponse != null && (a2 = a(webResourceResponse, str)) != null && a2.exists()) {
            try {
                return new WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), new FileInputStream(a2));
            } catch (FileNotFoundException unused2) {
            }
        }
        return webResourceResponse;
    }
}
