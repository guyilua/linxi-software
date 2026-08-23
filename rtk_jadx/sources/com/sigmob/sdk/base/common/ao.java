package com.sigmob.sdk.base.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.ResponseHeader;
import com.czhj.sdk.logger.SigmobLog;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ao extends AsyncTask<String, Void, String> {
    private static final int a = 10;
    private final a b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a(String str);

        void a(String str, Throwable th);
    }

    private ao(a aVar) {
        this.b = aVar;
    }

    private static String a(String str, HttpURLConnection httpURLConnection) {
        URI uri = new URI(str);
        int responseCode = httpURLConnection.getResponseCode();
        String headerField = httpURLConnection.getHeaderField("Location");
        if (responseCode < 300 || responseCode >= 400) {
            return null;
        }
        try {
            return uri.resolve(headerField).toString();
        } catch (IllegalArgumentException unused) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str + "\n redirectUrl=" + headerField);
            throw new URISyntaxException(headerField, "Unable to parse invalid URL");
        } catch (Throwable th) {
            SigmobLog.e("Invalid URL redirection. baseUrl=" + str + "\n redirectUrl=" + headerField);
            throw th;
        }
    }

    public static void a(String str, a aVar) {
        try {
            new ao(aVar).executeOnExecutor(ThreadPoolFactory.BackgroundThreadPool.getInstance().getExecutorService(), str);
        } catch (Throwable th) {
            aVar.a("Failed to resolve url", th);
        }
    }

    private String b(String str) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.addRequestProperty(ResponseHeader.USER_AGENT.getKey(), Networking.getUserAgent());
                String a2 = a(str, httpURLConnection2);
                if (httpURLConnection2 != null) {
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                            SigmobLog.d("IOException when closing httpUrlConnection. Ignoring.");
                        }
                    }
                    httpURLConnection2.disconnect();
                }
                return a2;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable unused2) {
                            SigmobLog.d("IOException when closing httpUrlConnection. Ignoring.");
                        }
                    }
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(String... strArr) {
        String str = null;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        try {
            String str2 = strArr[0];
            while (true) {
                String str3 = str;
                str = str2;
                if (str == null) {
                    return str3;
                }
                try {
                    if (!am.OPEN_WITH_BROWSER.a(Uri.parse(str), 0)) {
                        return str;
                    }
                    str2 = b(str);
                } catch (Throwable th) {
                    str = str3;
                    th = th;
                    SigmobLog.w(th.getMessage());
                    return str;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        if (isCancelled() || str == null) {
            onCancelled();
        } else {
            this.b.a(str);
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.b.a("Task for resolving url was cancelled", null);
    }
}
