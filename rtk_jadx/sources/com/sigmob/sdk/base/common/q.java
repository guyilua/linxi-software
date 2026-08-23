package com.sigmob.sdk.base.common;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.ResponseHeader;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q extends AsyncTask<String, Void, HashMap<String, String>> {
    private static final int a = 10;
    private final a b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, Throwable th);
    }

    private q(a aVar) {
        this.b = aVar;
    }

    public static String a(String str) {
        if (!str.toLowerCase().contains(".apk")) {
            return null;
        }
        String b = b(str);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String c2 = c(str);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        return c2;
    }

    private static String a(String str, HttpURLConnection httpURLConnection) {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode < 200 || responseCode >= 400) {
            return null;
        }
        try {
            return URLUtil.guessFileName(str, httpURLConnection.getHeaderField(com.sigmob.sdk.downloader.core.c.j), null);
        } catch (IllegalArgumentException unused) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str);
            throw new URISyntaxException(str, "Unable to parse invalid URL");
        } catch (NullPointerException e) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str);
            throw e;
        }
    }

    public static void a(String str, a aVar) {
        try {
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                new q(aVar).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), str);
            } else {
                aVar.a(a2, str);
            }
        } catch (Throwable th) {
            aVar.a("Failed to resolve url", th);
        }
    }

    public static String b(String str) {
        try {
            Matcher matcher = Pattern.compile("(fsname=)(.*?apk)", 2).matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str) {
        try {
            Matcher matcher = Pattern.compile("[\\w\\.]+\\.apk", 2).matcher(str);
            if (matcher.find()) {
                return matcher.group(0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String d(String str) {
        String str2 = null;
        while (str != null) {
            try {
                str2 = str;
                str = e(str);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                return str;
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r4 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String e(java.lang.String r4) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L38
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L38
            java.net.URLConnection r4 = r1.openConnection()     // Catch: java.lang.Throwable -> L38
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch: java.lang.Throwable -> L38
            r1 = 0
            r4.setInstanceFollowRedirects(r1)     // Catch: java.lang.Throwable -> L36
            com.czhj.sdk.common.network.ResponseHeader r1 = com.czhj.sdk.common.network.ResponseHeader.USER_AGENT     // Catch: java.lang.Throwable -> L36
            java.lang.String r1 = r1.getKey()     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = com.czhj.sdk.common.network.Networking.getUserAgent()     // Catch: java.lang.Throwable -> L36
            r4.addRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L36
            int r1 = r4.getResponseCode()     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = "Location"
            java.lang.String r2 = r4.getHeaderField(r2)     // Catch: java.lang.Throwable -> L36
            r3 = 300(0x12c, float:4.2E-43)
            if (r1 < r3) goto L30
            r3 = 400(0x190, float:5.6E-43)
            if (r1 >= r3) goto L30
            r0 = r2
        L30:
            if (r4 == 0) goto L42
        L32:
            r4.disconnect()
            goto L42
        L36:
            r1 = move-exception
            goto L3a
        L38:
            r1 = move-exception
            r4 = r0
        L3a:
            java.lang.String r2 = "resolveRedirectLocation fail"
            com.czhj.sdk.logger.SigmobLog.e(r2, r1)     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L42
            goto L32
        L42:
            return r0
        L43:
            r0 = move-exception
            if (r4 == 0) goto L49
            r4.disconnect()
        L49:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.q.e(java.lang.String):java.lang.String");
    }

    private String f(String str) {
        HttpURLConnection httpURLConnection;
        String str2;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (TextUtils.isEmpty(null)) {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.addRequestProperty(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
                    String a2 = a(str, httpURLConnection);
                    if (a2 == null) {
                        if (!TextUtils.isEmpty(str)) {
                            String[] split = Uri.parse(str).getPath().split("/");
                            if (split.length > 1) {
                                a2 = split[split.length - 1];
                            }
                            if (TextUtils.isEmpty(a2) || !a2.toLowerCase().endsWith(".apk")) {
                                str2 = Md5Util.md5(str) + ".apk";
                            }
                        }
                        str2 = null;
                    } else if (a2.contains("fsname=")) {
                        str2 = b(str);
                    } else if (a2.contains(".apk")) {
                        str2 = c(a2);
                    } else {
                        httpURLConnection2 = httpURLConnection;
                        str2 = a2;
                    }
                    httpURLConnection2 = httpURLConnection;
                } catch (Throwable th) {
                    th = th;
                    try {
                        SigmobLog.e("getDownloadUrlFilename", th);
                    } finally {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                }
            } else {
                str2 = a(str);
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public HashMap<String, String> doInBackground(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            String str = strArr[0];
            try {
                str = d(str);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
            hashMap.put("url", str);
            hashMap.put("fileName", f(str));
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(HashMap<String, String> hashMap) {
        String str;
        String str2 = null;
        if (hashMap != null) {
            str2 = hashMap.get("fileName");
            str = hashMap.get("url");
        } else {
            str = null;
        }
        this.b.a(str2, str);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.b.a("Task for resolving url was cancelled", (Throwable) null);
    }
}
