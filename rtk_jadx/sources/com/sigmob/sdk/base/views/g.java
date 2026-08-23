package com.sigmob.sdk.base.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class g extends WebView {
    private static boolean a = false;
    private APKStatusBroadcastReceiver b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<o.a> f467c;
    private BaseAdUnit d;
    private WebViewClient e;
    private Set<String> f;
    private Map<String, String> g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a {
        public a() {
        }

        @JavascriptInterface
        public int cancelDownloadTask() {
            if (g.this.d == null || g.this.d.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.c(g.this.getContext(), g.this.d);
        }

        @JavascriptInterface
        public int getApKDownloadProcess() {
            g.this.a();
            if (g.this.getContext() == null || g.this.d == null) {
                return -1;
            }
            long[] d = g.this.d.getApkDownloadType() != 0 ? com.sigmob.sdk.base.common.n.d(g.this.getContext(), g.this.d) : com.sigmob.sdk.base.common.p.a(g.this.getContext(), g.this.d.getDownloadId());
            int i = (int) d[2];
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        return i != 8 ? -1 : 100;
                    }
                    return -2;
                }
                long j = d[0];
                long j2 = d[1];
                if (j2 != 0 && j != 0) {
                    return (int) ((j * 100) / j2);
                }
            }
            return 0;
        }

        @JavascriptInterface
        public int getApKDownloadType() {
            if (g.this.d != null) {
                return g.this.d.getApkDownloadType();
            }
            return -1;
        }

        @JavascriptInterface
        public int pauseDownload() {
            if (g.this.d == null || g.this.d.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.a(g.this.getContext(), g.this.d);
        }

        @JavascriptInterface
        public int resumeDownload() {
            if (g.this.d == null || g.this.d.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.b(g.this.getContext(), g.this.d);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class b {
        private BaseAdUnit b;

        b(BaseAdUnit baseAdUnit) {
            this.b = baseAdUnit;
        }

        @JavascriptInterface
        public boolean canInstall(String str) {
            if (this.b == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.b.getApkName())) {
                    str = this.b.getApkName();
                } else if (TextUtils.isEmpty(this.b.getApkMd5())) {
                    str = "";
                } else {
                    str = this.b.getApkMd5() + ".apk";
                }
            }
            return this.b.canInstall(str);
        }

        @JavascriptInterface
        public boolean canOpen(String str) {
            if (!TextUtils.isEmpty(str)) {
                return com.sigmob.sdk.base.common.u.a(com.sigmob.sdk.b.e(), str);
            }
            BaseAdUnit baseAdUnit = this.b;
            if (baseAdUnit == null) {
                return false;
            }
            return baseAdUnit.canOpen();
        }

        @JavascriptInterface
        public int getInteractionType() {
            if (g.this.d != null) {
                return g.this.d.getInteractionType();
            }
            return 0;
        }

        @JavascriptInterface
        public int getSubInteractionType() {
            if (g.this.d != null) {
                return g.this.d.getsubInteractionType();
            }
            return 0;
        }

        @JavascriptInterface
        public void hideSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.base.views.g.b.2
                @Override // java.lang.Runnable
                public void run() {
                    Activity c2 = com.sigmob.sdk.base.utils.f.c(g.this);
                    if (c2 != null) {
                        com.sigmob.sdk.videoplayer.d.f((Context) c2);
                    }
                }
            });
        }

        @JavascriptInterface
        public boolean isOpenListReport() {
            return (com.sigmob.sdk.base.l.a().O().isEmpty() || com.sigmob.sdk.base.services.b.a()) ? false : true;
        }

        @JavascriptInterface
        public void onOpenListReport() {
            com.sigmob.sdk.base.services.b.c();
        }

        @JavascriptInterface
        public void showSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.base.views.g.b.1
                @Override // java.lang.Runnable
                public void run() {
                    Activity c2 = com.sigmob.sdk.base.utils.f.c(g.this);
                    if (c2 != null) {
                        com.sigmob.sdk.videoplayer.d.h((Context) c2);
                    }
                }
            });
        }
    }

    public g(Context context) {
        super(context);
        this.f = new HashSet();
        this.g = new HashMap();
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        a(getSettings());
        if (!a) {
            b(getContext());
            a = true;
        }
        resumeTimers();
        a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00f4 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x0007, B:9:0x002a, B:11:0x0030, B:12:0x0034, B:14:0x0064, B:15:0x0079, B:16:0x00ea, B:17:0x00ee, B:19:0x00f4, B:22:0x0105, B:28:0x007d, B:30:0x00bf), top: B:5:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L7
            return
        L7:
            java.lang.String r0 = "/app_webview"
            java.lang.String r1 = "/app_hws_webview"
            java.lang.String r2 = "/webview_data.lock"
            java.io.File r3 = r8.getDataDir()     // Catch: java.lang.Exception -> L109
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Exception -> L109
            java.util.HashSet r4 = new java.util.HashSet     // Catch: java.lang.Exception -> L109
            r4.<init>()     // Catch: java.lang.Exception -> L109
            java.lang.String r5 = android.app.Application.getProcessName()     // Catch: java.lang.Exception -> L109
            java.lang.String r6 = r8.getPackageName()     // Catch: java.lang.Exception -> L109
            boolean r6 = android.text.TextUtils.equals(r6, r5)     // Catch: java.lang.Exception -> L109
            java.lang.String r7 = "_"
            if (r6 != 0) goto L7d
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L109
            if (r6 == 0) goto L34
            java.lang.String r5 = r8.getPackageName()     // Catch: java.lang.Exception -> L109
        L34:
            android.webkit.WebView.setDataDirectorySuffix(r5)     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r8.<init>()     // Catch: java.lang.Exception -> L109
            r8.append(r7)     // Catch: java.lang.Exception -> L109
            r8.append(r5)     // Catch: java.lang.Exception -> L109
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r5.<init>()     // Catch: java.lang.Exception -> L109
            r5.append(r3)     // Catch: java.lang.Exception -> L109
            r5.append(r0)     // Catch: java.lang.Exception -> L109
            r5.append(r8)     // Catch: java.lang.Exception -> L109
            r5.append(r2)     // Catch: java.lang.Exception -> L109
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L109
            r4.add(r0)     // Catch: java.lang.Exception -> L109
            boolean r0 = com.czhj.sdk.common.utils.RomUtils.isHuawei()     // Catch: java.lang.Exception -> L109
            if (r0 == 0) goto Lea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r0.<init>()     // Catch: java.lang.Exception -> L109
            r0.append(r3)     // Catch: java.lang.Exception -> L109
            r0.append(r1)     // Catch: java.lang.Exception -> L109
            r0.append(r8)     // Catch: java.lang.Exception -> L109
            r0.append(r2)     // Catch: java.lang.Exception -> L109
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L109
        L79:
            r4.add(r8)     // Catch: java.lang.Exception -> L109
            goto Lea
        L7d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r8.<init>()     // Catch: java.lang.Exception -> L109
            r8.append(r7)     // Catch: java.lang.Exception -> L109
            r8.append(r5)     // Catch: java.lang.Exception -> L109
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r5.<init>()     // Catch: java.lang.Exception -> L109
            r5.append(r3)     // Catch: java.lang.Exception -> L109
            r5.append(r0)     // Catch: java.lang.Exception -> L109
            r5.append(r2)     // Catch: java.lang.Exception -> L109
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L109
            r4.add(r5)     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r5.<init>()     // Catch: java.lang.Exception -> L109
            r5.append(r3)     // Catch: java.lang.Exception -> L109
            r5.append(r0)     // Catch: java.lang.Exception -> L109
            r5.append(r8)     // Catch: java.lang.Exception -> L109
            r5.append(r2)     // Catch: java.lang.Exception -> L109
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Exception -> L109
            r4.add(r0)     // Catch: java.lang.Exception -> L109
            boolean r0 = com.czhj.sdk.common.utils.RomUtils.isHuawei()     // Catch: java.lang.Exception -> L109
            if (r0 == 0) goto Lea
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r0.<init>()     // Catch: java.lang.Exception -> L109
            r0.append(r3)     // Catch: java.lang.Exception -> L109
            r0.append(r1)     // Catch: java.lang.Exception -> L109
            r0.append(r2)     // Catch: java.lang.Exception -> L109
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L109
            r4.add(r0)     // Catch: java.lang.Exception -> L109
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L109
            r0.<init>()     // Catch: java.lang.Exception -> L109
            r0.append(r3)     // Catch: java.lang.Exception -> L109
            r0.append(r1)     // Catch: java.lang.Exception -> L109
            r0.append(r8)     // Catch: java.lang.Exception -> L109
            r0.append(r2)     // Catch: java.lang.Exception -> L109
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L109
            goto L79
        Lea:
            java.util.Iterator r8 = r4.iterator()     // Catch: java.lang.Exception -> L109
        Lee:
            boolean r0 = r8.hasNext()     // Catch: java.lang.Exception -> L109
            if (r0 == 0) goto L10d
            java.lang.Object r0 = r8.next()     // Catch: java.lang.Exception -> L109
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L109
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L109
            r1.<init>(r0)     // Catch: java.lang.Exception -> L109
            boolean r0 = r1.exists()     // Catch: java.lang.Exception -> L109
            if (r0 == 0) goto Lee
            a(r1)     // Catch: java.lang.Exception -> L109
            goto L10d
        L109:
            r8 = move-exception
            r8.printStackTrace()
        L10d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.g.a(android.content.Context):void");
    }

    private void a(WebSettings webSettings) {
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.k.C, 2)));
            methodBuilder.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.k.E, 2)));
            methodBuilder2.addParam(Boolean.TYPE, Boolean.TRUE);
            methodBuilder2.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setCacheMode(-1);
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowContentAccess(true);
        if (i < 16) {
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (i >= 26) {
            webSettings.setSafeBrowsingEnabled(false);
        }
        if (i >= 21) {
            webSettings.setMixedContentMode(0);
        }
        addJavascriptInterface(new a(), "sigandroidapk");
    }

    public static void a(WebView webView) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, com.sigmob.sdk.base.f.a().i());
        }
    }

    @TargetApi(28)
    private static void a(File file) {
        try {
            FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (tryLock != null) {
                tryLock.close();
            } else {
                a(file, file.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
            a(file, file.exists() ? file.delete() : false);
        }
    }

    private static void a(File file, boolean z) {
        if (z) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void b(Context context) {
        if (Build.VERSION.SDK_INT == 19) {
            WebView webView = new WebView(context.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.type = 2005;
            layoutParams.flags = 16777240;
            layoutParams.format = -2;
            layoutParams.gravity = 8388659;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.addView(webView, layoutParams);
            }
        }
    }

    public static void d() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (com.sigmob.sdk.base.f.a().i()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        if (Build.VERSION.SDK_INT < 21) {
            cookieManager.removeSessionCookie();
            cookieManager.removeAllCookie();
        } else {
            cookieManager.removeSessionCookies(null);
            cookieManager.removeAllCookies(null);
            cookieManager.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o.a getListener() {
        WeakReference<o.a> weakReference = this.f467c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void a() {
        if (this.d == null || this.b != null) {
            return;
        }
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new o.a() { // from class: com.sigmob.sdk.base.views.g.1
            @Override // com.sigmob.sdk.base.common.o.a
            public void a(boolean z) {
                o.a listener = g.this.getListener();
                if (listener != null) {
                    listener.a(z);
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void a(boolean z, long j) {
                o.a listener = g.this.getListener();
                if (listener != null) {
                    listener.b(z, j);
                } else if (z) {
                    g.this.e();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void b(boolean z) {
                o.a listener = g.this.getListener();
                if (listener != null) {
                    listener.b(z);
                } else if (z) {
                    g.this.i();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void b(boolean z, long j) {
                o.a listener = g.this.getListener();
                if (listener != null) {
                    listener.b(z, j);
                } else if (z) {
                    g.this.h();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void c(boolean z, long j) {
                o.a listener = g.this.getListener();
                if (listener != null) {
                    listener.c(z, j);
                }
                g.this.g();
            }
        }, this.d.getUuid());
        this.b = aPKStatusBroadcastReceiver;
        aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void a(o.a aVar) {
        this.f467c = new WeakReference<>(aVar);
    }

    void a(String str, ValueCallback valueCallback) {
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        if (str.startsWith("bridge")) {
            str = str.replaceFirst("bridge", StringUtil.decode(StringUtil.s));
        }
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str, valueCallback);
            return;
        }
        loadUrl("javascript:" + str);
    }

    public void a(boolean z) {
        WebSettings settings;
        WebSettings.PluginState pluginState;
        if (Build.VERSION.SDK_INT >= 18) {
            return;
        }
        if (z) {
            settings = getSettings();
            pluginState = WebSettings.PluginState.ON;
        } else {
            settings = getSettings();
            pluginState = WebSettings.PluginState.OFF;
        }
        settings.setPluginState(pluginState);
    }

    @Override // android.webkit.WebView
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
        this.f.add(str);
    }

    public void b() {
        com.sigmob.sdk.base.utils.f.a(this);
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.b;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.b = null;
        }
        setWebViewClient(null);
        removeAllViews();
        Iterator<String> it = this.f.iterator();
        while (it.hasNext()) {
            removeJavascriptInterface(it.next());
        }
        this.f.clear();
        setWebChromeClient(null);
        loadUrl("");
        this.d = null;
    }

    public void b(boolean z) {
        if (z) {
            stopLoading();
            loadUrl("");
        }
        onPause();
    }

    public void c() {
        setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.views.g.2
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                SigmobLog.i(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                SigmobLog.i(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                SigmobLog.i(str2);
                jsResult.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                SigmobLog.i(str2);
                jsPromptResult.confirm();
                return true;
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        b();
        SigmobLog.d(" BaseWebView destroy called ");
        super.destroy();
    }

    void e() {
        a("bridge.notifyApkDownloadStartEvent();", (ValueCallback) null);
    }

    void f() {
        a("bridge.notifyApkDownloadFailEvent();", (ValueCallback) null);
    }

    void g() {
        a("bridge.notifyApkDownloadPauseEvent();", (ValueCallback) null);
    }

    void h() {
        a("bridge.notifyApkDownloadEndEvent();", (ValueCallback) null);
    }

    void i() {
        a("bridge.notifyApkDownloadInstalledEvent();", (ValueCallback) null);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        String url = StringUtil.getUrl(str);
        this.g.put("Referer", "");
        BaseAdUnit baseAdUnit = this.d;
        if (baseAdUnit != null && baseAdUnit.isDisablexRequestWith()) {
            this.g.put("X-Requested-With", "");
        }
        loadUrl(url, this.g);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAdUnit(BaseAdUnit baseAdUnit) {
        this.d = baseAdUnit;
        if (baseAdUnit != null) {
            addJavascriptInterface(new b(baseAdUnit), "sigandroidh5");
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.e = webViewClient;
        super.setWebViewClient(webViewClient);
    }
}
