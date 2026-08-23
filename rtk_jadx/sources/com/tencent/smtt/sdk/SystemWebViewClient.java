package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
/* loaded from: /tmp/rtk_apk/classes3.dex */
class SystemWebViewClient extends android.webkit.WebViewClient {

    /* renamed from: c, reason: collision with root package name */
    private static String f934c;
    private WebViewClient a;
    private WebView b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a extends ClientCertRequest {
        private android.webkit.ClientCertRequest a;

        public a(android.webkit.ClientCertRequest clientCertRequest) {
            this.a = clientCertRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String getHost() {
            return this.a.getHost();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public String[] getKeyTypes() {
            return this.a.getKeyTypes();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public int getPort() {
            return this.a.getPort();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public Principal[] getPrincipals() {
            return this.a.getPrincipals();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void ignore() {
            this.a.ignore();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ClientCertRequest
        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.a.proceed(privateKey, x509CertificateArr);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class b implements HttpAuthHandler {
        private android.webkit.HttpAuthHandler a;

        b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.a = httpAuthHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public void proceed(String str, String str2) {
            this.a.proceed(str, str2);
        }

        @Override // com.tencent.smtt.export.external.interfaces.HttpAuthHandler
        public boolean useHttpAuthUsernamePassword() {
            return this.a.useHttpAuthUsernamePassword();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class c implements SslErrorHandler {
        android.webkit.SslErrorHandler a;

        c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.a = sslErrorHandler;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslErrorHandler
        public void proceed() {
            this.a.proceed();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class d implements SslError {
        android.net.http.SslError a;

        d(android.net.http.SslError sslError) {
            this.a = sslError;
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean addError(int i) {
            return this.a.addError(i);
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public SslCertificate getCertificate() {
            return this.a.getCertificate();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public int getPrimaryError() {
            return this.a.getPrimaryError();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public String getUrl() {
            return this.a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.SslError
        public boolean hasError(int i) {
            return this.a.hasError(i);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class e implements WebResourceRequest {
        private String b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f935c;
        private boolean d;
        private boolean e;
        private String f;
        private Map<String, String> g;

        public e(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.b = str;
            this.f935c = z;
            this.d = z2;
            this.e = z3;
            this.f = str2;
            this.g = map;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.f;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.g;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return Uri.parse(this.b);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.e;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.f935c;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            return this.d;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class f implements WebResourceRequest {
        android.webkit.WebResourceRequest a;

        f(android.webkit.WebResourceRequest webResourceRequest) {
            this.a = webResourceRequest;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public String getMethod() {
            return this.a.getMethod();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Map<String, String> getRequestHeaders() {
            return this.a.getRequestHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public Uri getUrl() {
            return this.a.getUrl();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean hasGesture() {
            return this.a.hasGesture();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isForMainFrame() {
            return this.a.isForMainFrame();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceRequest
        public boolean isRedirect() {
            if (Build.VERSION.SDK_INT >= 24) {
                Object a = com.tencent.smtt.utils.k.a(this.a, "isRedirect");
                if (a instanceof Boolean) {
                    return ((Boolean) a).booleanValue();
                }
            }
            return false;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class g extends WebResourceResponse {
        android.webkit.WebResourceResponse a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.a = webResourceResponse;
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public InputStream getData() {
            return this.a.getData();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getEncoding() {
            return this.a.getEncoding();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getMimeType() {
            return this.a.getMimeType();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public String getReasonPhrase() {
            return this.a.getReasonPhrase();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public Map<String, String> getResponseHeaders() {
            return this.a.getResponseHeaders();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public int getStatusCode() {
            return this.a.getStatusCode();
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setData(InputStream inputStream) {
            this.a.setData(inputStream);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setEncoding(String str) {
            this.a.setEncoding(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setMimeType(String str) {
            this.a.setMimeType(str);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setResponseHeaders(Map<String, String> map) {
            this.a.setResponseHeaders(map);
        }

        @Override // com.tencent.smtt.export.external.interfaces.WebResourceResponse
        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.a = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
        this.b.a(webView);
        this.a.doUpdateVisitedHistory(this.b, str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onFormResubmission(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.a.onLoadResource(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(android.webkit.WebView webView, String str) {
        this.b.a(webView);
        this.a.onPageCommitVisible(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, String str) {
        com.tencent.smtt.utils.o a2;
        if (f934c == null && (a2 = com.tencent.smtt.utils.o.a()) != null) {
            a2.a(true);
            f934c = Boolean.toString(true);
        }
        this.b.a(webView);
        WebView webView2 = this.b;
        webView2.a++;
        this.a.onPageFinished(webView2, str);
        if (TbsConfig.APP_QZONE.equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.d();
        if (!TbsShareManager.mHasQueryed && this.b.getContext() != null && TbsShareManager.isThirdPartyApp(this.b.getContext())) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TbsShareManager.forceLoadX5FromTBSDemo(SystemWebViewClient.this.b.getContext()) || !TbsDownloader.needDownload(SystemWebViewClient.this.b.getContext(), false)) {
                        return;
                    }
                    TbsDownloader.startDownload(SystemWebViewClient.this.b.getContext());
                }
            }).start();
        }
        if (this.b.getContext() == null || TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport()) {
            return;
        }
        TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
        TbsLogReport.getInstance(this.b.getContext()).dailyReport();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
        this.b.a(webView);
        this.a.onPageStarted(this.b, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedError(this.b, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(12)
    public void onReceivedLoginRequest(android.webkit.WebView webView, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(8)
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (Build.VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(android.webkit.WebView webView, float f2, float f3) {
        this.b.a(webView);
        this.a.onScaleChanged(this.b, f2, f3);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(android.webkit.WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onTooManyRedirects(this.b, message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
        WebResourceResponse shouldInterceptRequest;
        if (Build.VERSION.SDK_INT >= 11 && (shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, str)) != null) {
            return new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        return this.a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return this.a.shouldOverrideUrlLoading(this.b, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        this.b.a(webView);
        this.a.onReceivedError(this.b, webResourceRequest != null ? new f(webResourceRequest) : null, webResourceError != null ? new com.tencent.smtt.export.external.interfaces.WebResourceError() { // from class: com.tencent.smtt.sdk.SystemWebViewClient.2
            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public CharSequence getDescription() {
                return webResourceError.getDescription();
            }

            @Override // com.tencent.smtt.export.external.interfaces.WebResourceError
            public int getErrorCode() {
                return webResourceError.getErrorCode();
            }
        } : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView r11, android.webkit.WebResourceRequest r12) {
        /*
            r10 = this;
            int r11 = android.os.Build.VERSION.SDK_INT
            r0 = 0
            r1 = 21
            if (r11 >= r1) goto L8
            return r0
        L8:
            if (r12 != 0) goto Lb
            return r0
        Lb:
            r1 = 0
            r2 = 24
            if (r11 < r2) goto L22
            java.lang.String r11 = "isRedirect"
            java.lang.Object r11 = com.tencent.smtt.utils.k.a(r12, r11)
            boolean r2 = r11 instanceof java.lang.Boolean
            if (r2 == 0) goto L22
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r1 = r11.booleanValue()
            r6 = r1
            goto L23
        L22:
            r6 = 0
        L23:
            com.tencent.smtt.sdk.SystemWebViewClient$e r11 = new com.tencent.smtt.sdk.SystemWebViewClient$e
            android.net.Uri r1 = r12.getUrl()
            java.lang.String r4 = r1.toString()
            boolean r5 = r12.isForMainFrame()
            boolean r7 = r12.hasGesture()
            java.lang.String r8 = r12.getMethod()
            java.util.Map r9 = r12.getRequestHeaders()
            r2 = r11
            r3 = r10
            r2.<init>(r4, r5, r6, r7, r8, r9)
            com.tencent.smtt.sdk.WebViewClient r12 = r10.a
            com.tencent.smtt.sdk.WebView r1 = r10.b
            com.tencent.smtt.export.external.interfaces.WebResourceResponse r11 = r12.shouldInterceptRequest(r1, r11)
            if (r11 != 0) goto L4d
            return r0
        L4d:
            android.webkit.WebResourceResponse r12 = new android.webkit.WebResourceResponse
            java.lang.String r0 = r11.getMimeType()
            java.lang.String r1 = r11.getEncoding()
            java.io.InputStream r2 = r11.getData()
            r12.<init>(r0, r1, r2)
            java.util.Map r0 = r11.getResponseHeaders()
            r12.setResponseHeaders(r0)
            int r0 = r11.getStatusCode()
            java.lang.String r11 = r11.getReasonPhrase()
            int r1 = r12.getStatusCode()
            if (r0 != r1) goto L7f
            if (r11 == 0) goto L82
            java.lang.String r1 = r12.getReasonPhrase()
            boolean r1 = r11.equals(r1)
            if (r1 != 0) goto L82
        L7f:
            r12.setStatusCodeAndReasonPhrase(r0, r11)
        L82:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.SystemWebViewClient.shouldInterceptRequest(android.webkit.WebView, android.webkit.WebResourceRequest):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        boolean z;
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.b.showDebugView(uri)) {
            return true;
        }
        this.b.a(webView);
        if (Build.VERSION.SDK_INT >= 24) {
            Object a2 = com.tencent.smtt.utils.k.a(webResourceRequest, "isRedirect");
            if (a2 instanceof Boolean) {
                z = ((Boolean) a2).booleanValue();
                return this.a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
            }
        }
        z = false;
        return this.a.shouldOverrideUrlLoading(this.b, new e(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }
}
