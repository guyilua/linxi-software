package com.tencent.smtt.sdk;

import android.R;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.sdk.WebView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
class SystemWebChromeClient extends android.webkit.WebChromeClient {
    private WebView a;
    private WebChromeClient b;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements IX5WebChromeClient.CustomViewCallback {
        WebChromeClient.CustomViewCallback a;

        b(WebChromeClient.CustomViewCallback customViewCallback) {
            this.a = customViewCallback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback
        public void onCustomViewHidden() {
            this.a.onCustomViewHidden();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements GeolocationPermissionsCallback {
        GeolocationPermissions.Callback a;

        c(GeolocationPermissions.Callback callback) {
            this.a = callback;
        }

        @Override // com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback
        public void invoke(String str, boolean z, boolean z2) {
            this.a.invoke(str, z, z2);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class d implements JsPromptResult {
        android.webkit.JsPromptResult a;

        d(android.webkit.JsPromptResult jsPromptResult) {
            this.a = jsPromptResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.a.confirm();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsPromptResult
        public void confirm(String str) {
            this.a.confirm(str);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class e implements JsResult {
        android.webkit.JsResult a;

        e(android.webkit.JsResult jsResult) {
            this.a = jsResult;
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void cancel() {
            this.a.cancel();
        }

        @Override // com.tencent.smtt.export.external.interfaces.JsResult
        public void confirm() {
            this.a.confirm();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements WebStorage.QuotaUpdater {
        WebStorage.QuotaUpdater a;

        f(WebStorage.QuotaUpdater quotaUpdater) {
            this.a = quotaUpdater;
        }

        @Override // com.tencent.smtt.sdk.WebStorage.QuotaUpdater
        public void updateQuota(long j) {
            this.a.updateQuota(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemWebChromeClient(WebView webView, WebChromeClient webChromeClient) {
        this.a = webView;
        this.b = webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = this.b.getDefaultVideoPoster();
        if (defaultVideoPoster != null) {
            return defaultVideoPoster;
        }
        try {
            return Build.VERSION.SDK_INT >= 24 ? BitmapFactory.decodeResource(this.a.getResources(), R.drawable.ic_media_play) : defaultVideoPoster;
        } catch (Exception unused) {
            return defaultVideoPoster;
        }
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public View getVideoLoadingProgressView() {
        return this.b.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(final android.webkit.ValueCallback<String[]> valueCallback) {
        this.b.getVisitedHistory(new ValueCallback<String[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.1
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String[] strArr) {
                valueCallback.onReceiveValue(strArr);
            }
        });
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(android.webkit.WebView webView) {
        this.a.a(webView);
        this.b.onCloseWindow(this.a);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(new a(consoleMessage));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(android.webkit.WebView webView, boolean z, boolean z2, final Message message) {
        WebView webView2 = this.a;
        webView2.getClass();
        final WebView.WebViewTransport webViewTransport = new WebView.WebViewTransport();
        Message obtain = Message.obtain(message.getTarget(), new Runnable() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.2
            @Override // java.lang.Runnable
            public void run() {
                WebView webView3 = webViewTransport.getWebView();
                if (webView3 != null) {
                    ((WebView.WebViewTransport) message.obj).setWebView(webView3.b());
                }
                message.sendToTarget();
            }
        });
        obtain.obj = webViewTransport;
        return this.b.onCreateWindow(this.a, z, z2, obtain);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.b.onGeolocationPermissionsShowPrompt(str, new c(callback));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.a.a(webView);
        return this.b.onJsAlert(this.a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.a.a(webView);
        return this.b.onJsBeforeUnload(this.a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, android.webkit.JsResult jsResult) {
        this.a.a(webView);
        return this.b.onJsConfirm(this.a, str, str2, new e(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, android.webkit.JsPromptResult jsPromptResult) {
        this.a.a(webView);
        return this.b.onJsPrompt(this.a, str, str2, str3, new d(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i) {
        this.a.a(webView);
        this.b.onProgressChanged(this.a, i);
    }

    @TargetApi(7)
    @Deprecated
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j, j2, new f(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(android.webkit.WebView webView, Bitmap bitmap) {
        this.a.a(webView);
        this.b.onReceivedIcon(this.a, bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView webView, String str) {
        this.a.a(webView);
        this.b.onReceivedTitle(this.a, str);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, String str, boolean z) {
        this.a.a(webView);
        this.b.onReceivedTouchIconUrl(this.a, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(android.webkit.WebView webView) {
        this.a.a(webView);
        this.b.onRequestFocus(this.a);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(7)
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, new b(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, final android.webkit.ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        ValueCallback<Uri[]> valueCallback2 = new ValueCallback<Uri[]>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.4
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri[] uriArr) {
                valueCallback.onReceiveValue(uriArr);
            }
        };
        WebChromeClient.FileChooserParams fileChooserParams2 = new WebChromeClient.FileChooserParams() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.5
            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public Intent createIntent() {
                return fileChooserParams.createIntent();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String[] getAcceptTypes() {
                return fileChooserParams.getAcceptTypes();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public String getFilenameHint() {
                return fileChooserParams.getFilenameHint();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public int getMode() {
                return fileChooserParams.getMode();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public CharSequence getTitle() {
                return fileChooserParams.getTitle();
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
            public boolean isCaptureEnabled() {
                return fileChooserParams.isCaptureEnabled();
            }
        };
        this.a.a(webView);
        return this.b.onShowFileChooser(this.a, valueCallback2, fileChooserParams2);
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback) {
        openFileChooser(valueCallback, null, null);
    }

    public void setupAutoFill(Message message) {
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        this.b.onConsoleMessage(new a(str, str2, i));
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(14)
    @Deprecated
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i, new b(customViewCallback));
    }

    public void openFileChooser(android.webkit.ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    public void openFileChooser(final android.webkit.ValueCallback<Uri> valueCallback, String str, String str2) {
        this.b.openFileChooser(new ValueCallback<Uri>() { // from class: com.tencent.smtt.sdk.SystemWebChromeClient.3
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Uri uri) {
                valueCallback.onReceiveValue(uri);
            }
        }, str, str2);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private static class a implements com.tencent.smtt.export.external.interfaces.ConsoleMessage {
        private ConsoleMessage.MessageLevel a;
        private String b;

        /* renamed from: c, reason: collision with root package name */
        private String f933c;
        private int d;

        a(android.webkit.ConsoleMessage consoleMessage) {
            this.a = ConsoleMessage.MessageLevel.valueOf(consoleMessage.messageLevel().name());
            this.b = consoleMessage.message();
            this.f933c = consoleMessage.sourceId();
            this.d = consoleMessage.lineNumber();
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public int lineNumber() {
            return this.d;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String message() {
            return this.b;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public ConsoleMessage.MessageLevel messageLevel() {
            return this.a;
        }

        @Override // com.tencent.smtt.export.external.interfaces.ConsoleMessage
        public String sourceId() {
            return this.f933c;
        }

        a(String str, String str2, int i) {
            this.a = ConsoleMessage.MessageLevel.LOG;
            this.b = str;
            this.f933c = str2;
            this.d = i;
        }
    }
}
