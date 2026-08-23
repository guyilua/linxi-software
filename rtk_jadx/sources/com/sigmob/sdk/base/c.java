package com.sigmob.sdk.base;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c {
    static final String a = "Set-Cookie";
    public static final String b = "Cookie";

    /* renamed from: c, reason: collision with root package name */
    private static final String f352c = "c";
    private static CookieManager d = new CookieManager();

    private static InputStream a(InputStream inputStream, String str) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        String str2 = new String(byteArrayOutputStream.toByteArray());
        if (str == null) {
            str = Charset.defaultCharset().displayName();
        }
        return new ByteArrayInputStream(str2.getBytes(str));
    }

    public static Map<String, String> a(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            sb.delete(0, sb.length());
            if (value != null && value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(";");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    public static void a(HttpURLConnection httpURLConnection, CookieManager cookieManager) {
        if (cookieManager == null || httpURLConnection == null) {
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        Log.d(f352c, "headerFields : " + headerFields.toString());
        List<String> list = headerFields.get(a);
        if (list != null) {
            for (String str : list) {
                try {
                    List<HttpCookie> parse = HttpCookie.parse(str);
                    if (parse != null) {
                        String str2 = f352c;
                        Log.d(str2, "{0} -- Reading Cookies from the response :" + httpURLConnection.getURL().toString());
                        Log.d(str2, "{0} -- Reading Cookies from the response :" + parse.get(0));
                        for (HttpCookie httpCookie : parse) {
                            Log.d(f352c, httpCookie.toString());
                            android.webkit.CookieManager.getInstance().setCookie(httpURLConnection.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                        }
                    }
                } catch (NullPointerException unused) {
                    Log.e(f352c, MessageFormat.format("{0} -- Null header for the cookie : {1}", httpURLConnection.getURL().toString(), str.toString()));
                }
            }
            if (Build.VERSION.SDK_INT >= 21) {
                android.webkit.CookieManager.getInstance().flush();
            } else {
                CookieSyncManager.getInstance().sync();
            }
        }
    }

    public WebResourceResponse a(String str, String str2, Map<String, String> map) {
        List<String> list;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(str2);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            String cookie = android.webkit.CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                for (String str3 : cookie.split(";")) {
                    httpURLConnection.addRequestProperty(b.toLowerCase(), str3.replace(" ", ""));
                }
            }
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String contentType = httpURLConnection.getContentType();
            String contentEncoding = httpURLConnection.getContentEncoding();
            InputStream inputStream = httpURLConnection.getInputStream();
            a(httpURLConnection, d);
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if ((responseCode == 301 || responseCode == 302) && (list = headerFields.get("Location")) != null && list.size() > 0) {
                return a(list.get(0), "GET", null);
            }
            if (contentType != null) {
                contentType = contentType.split(";")[0];
                if (contentType.contains("text") || contentType.contains("javascript")) {
                    if (contentType.contains("text/plain")) {
                        contentType = "text/html";
                    }
                    inputStream = a(inputStream, "UTF-8");
                    contentEncoding = "UTF-8";
                }
            } else {
                inputStream = null;
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(contentType, contentEncoding, inputStream);
            if (Build.VERSION.SDK_INT >= 21) {
                webResourceResponse.setResponseHeaders(a(headerFields));
            }
            return webResourceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
