package com.sigmob.sdk.base;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class d extends c {

    /* renamed from: c, reason: collision with root package name */
    private OkHttpClient.Builder f399c;
    private OkHttpClient d;

    public d() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            this.f399c = builder;
            builder.connectionPool(new ConnectionPool());
            OkHttpClient.Builder builder2 = this.f399c;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            builder2.connectTimeout(5000L, timeUnit);
            this.f399c.readTimeout(5000L, timeUnit);
            this.f399c.writeTimeout(5000L, timeUnit);
            this.d = this.f399c.build();
        } catch (Throwable unused) {
        }
    }

    @Override // com.sigmob.sdk.base.c
    public WebResourceResponse a(String str, String str2, Map<String, String> map) {
        if ((!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) || str2.equals("POST")) {
            return null;
        }
        try {
            String host = Uri.parse(str).getHost();
            if (host != null && !host.equals("127.0.0.1") && !host.equals("localhost")) {
                Request.Builder url = new Request.Builder().url(str);
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        url.addHeader(entry.getKey(), entry.getValue());
                    }
                }
                String cookie = CookieManager.getInstance().getCookie(str);
                if (!TextUtils.isEmpty(cookie)) {
                    for (String str3 : cookie.split(";")) {
                        url.addHeader(c.b.toLowerCase(), str3.replace(" ", ""));
                    }
                }
                Response execute = this.d.newCall(url.build()).execute();
                return new WebResourceResponse(execute.body().contentType().type() + "/" + execute.body().contentType().subtype(), execute.header("content-encoding", "utf-8"), execute.body().byteStream());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return super.a(str, str2, map);
        }
    }
}
