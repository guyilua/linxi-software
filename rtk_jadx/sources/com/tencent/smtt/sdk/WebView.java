package com.tencent.smtt.sdk;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";
    int a;
    private final String b;
    private boolean e;
    private IX5WebViewBase f;
    private a g;
    private WebSettings h;
    private Context i;
    private boolean k;
    public WebViewCallbackClient mWebViewCallbackClient;
    private WebViewClient n;
    private WebChromeClient o;
    private final int q;
    private final int r;
    private final int s;
    private final String t;
    private final String u;
    private Object x;
    private View.OnLongClickListener y;

    /* renamed from: c, reason: collision with root package name */
    private static final Lock f950c = new ReentrantLock();
    private static OutputStream d = null;
    private static Context j = null;
    public static boolean mWebViewCreated = false;
    private static com.tencent.smtt.utils.o l = null;
    private static Method m = null;
    private static String p = null;
    public static boolean mSysWebviewCreated = false;
    private static Paint v = null;
    private static boolean w = true;
    public static int NIGHT_MODE_ALPHA = 153;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class WebViewTransport {
        private WebView b;

        public WebViewTransport() {
        }

        public synchronized WebView getWebView() {
            return this.b;
        }

        public synchronized void setWebView(WebView webView) {
            this.b = webView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a extends android.webkit.WebView {
        public a(WebView webView, Context context) {
            this(context, null);
        }

        public void a(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
        }

        public boolean b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public void computeScroll() {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (WebView.w || WebView.v == null) {
                    return;
                }
                canvas.save();
                canvas.drawPaint(WebView.v);
                canvas.restore();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.dispatchTouchEvent(motionEvent, this);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView
        public android.webkit.WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.invalidate();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onInterceptTouchEvent(motionEvent, this);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        @TargetApi(9)
        public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onOverScrolled(i, i2, z, z2, this);
            } else if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onScrollChanged(i, i2, i3, i4, this);
            } else {
                super.onScrollChanged(i, i2, i3, i4);
                WebView.this.onScrollChanged(i, i2, i3, i4);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.view.View
        @TargetApi(9)
        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z, this);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        @Override // android.webkit.WebView, android.view.View
        public void setOverScrollMode(int i) {
            try {
                super.setOverScrollMode(i);
            } catch (Exception unused) {
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            CookieSyncManager.createInstance(WebView.this.i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new e());
                WebView.mSysWebviewCreated = true;
            } catch (Exception unused) {
            }
        }

        public void a() {
            super.computeScroll();
        }

        public boolean a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (Build.VERSION.SDK_INT >= 9) {
                return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        @TargetApi(9)
        public void a(int i, int i2, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i, i2, z, z2);
            }
        }
    }

    public WebView(Context context, boolean z) {
        super(context);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.a = 0;
        this.k = false;
        this.n = null;
        this.o = null;
        this.q = 1;
        this.r = 2;
        this.s = 3;
        this.t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.x = null;
        this.y = null;
    }

    private void c(Context context) {
        if (QbSdk.i && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        t a2 = t.a();
        a2.a(context);
        this.e = a2.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.String] */
    private int d(Context context) {
        FileLock a2;
        StringBuilder sb;
        File file;
        ?? r6;
        String property;
        FileOutputStream b = com.tencent.smtt.utils.f.b(context, true, "tbslock.txt");
        if (b == null || (a2 = com.tencent.smtt.utils.f.a(context, b)) == null) {
            return -1;
        }
        Lock lock = f950c;
        if (lock.tryLock()) {
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            if (!file.exists()) {
                lock.unlock();
                com.tencent.smtt.utils.f.a(a2, b);
                return -1;
            }
            Properties properties = new Properties();
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                properties.load(fileInputStream3);
                fileInputStream3.close();
                r6 = "PV";
                property = properties.getProperty("PV");
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream3;
                TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
                fileInputStream = fileInputStream2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        fileInputStream = fileInputStream2;
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("TbsInstaller--getTbsCorePV IOException=");
                        sb.append(e.toString());
                        TbsLog.e("getTbsCorePV", sb.toString());
                        f950c.unlock();
                        com.tencent.smtt.utils.f.a(a2, b);
                        return -1;
                    }
                }
                f950c.unlock();
                com.tencent.smtt.utils.f.a(a2, b);
                return -1;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e4.toString());
                    }
                }
                f950c.unlock();
                com.tencent.smtt.utils.f.a(a2, b);
                throw th;
            }
            if (property == null) {
                try {
                    fileInputStream3.close();
                    fileInputStream = r6;
                } catch (IOException e5) {
                    e = e5;
                    sb = new StringBuilder();
                    sb.append("TbsInstaller--getTbsCorePV IOException=");
                    sb.append(e.toString());
                    TbsLog.e("getTbsCorePV", sb.toString());
                    f950c.unlock();
                    com.tencent.smtt.utils.f.a(a2, b);
                    return -1;
                }
                f950c.unlock();
                com.tencent.smtt.utils.f.a(a2, b);
                return -1;
            }
            int parseInt = Integer.parseInt(property);
            try {
                fileInputStream3.close();
            } catch (IOException e6) {
                TbsLog.e("getTbsCorePV", "TbsInstaller--getTbsCorePV IOException=" + e6.toString());
            }
            f950c.unlock();
            com.tencent.smtt.utils.f.a(a2, b);
            return parseInt;
        }
        com.tencent.smtt.utils.f.a(a2, b);
        return -1;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (t.a().b()) {
            return;
        }
        com.tencent.smtt.utils.k.a("android.webkit.WebView", "disablePlatformNotifications");
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (t.a().b()) {
            return;
        }
        com.tencent.smtt.utils.k.a("android.webkit.WebView", "enablePlatformNotifications");
    }

    public static String findAddress(String str) {
        if (t.a().b()) {
            return null;
        }
        return android.webkit.WebView.findAddress(str);
    }

    public static String getCrashExtraMessage(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:43697;";
        boolean z = false;
        if ("com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
            try {
                Class.forName("de.robv.android.xposed.XposedBridge");
                z = true;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z) {
            return str + "isXposed=true;";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d.a(true).e());
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.n) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.n.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            sb.append(str2);
        }
        if (sb.length() > 8192) {
            return sb.substring(sb.length() - 8192);
        }
        return sb.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (t.a().b() || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) com.tencent.smtt.utils.k.a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        synchronized (WebView.class) {
            if (t.a().b()) {
                return null;
            }
            return com.tencent.smtt.utils.k.a("android.webkit.WebView", "getPluginList");
        }
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        d();
        return d.a(true).f();
    }

    public static int getTbsSDKVersion(Context context) {
        return 43697;
    }

    private long h() {
        long j2;
        synchronized (QbSdk.h) {
            if (QbSdk.e) {
                QbSdk.g += System.currentTimeMillis() - QbSdk.f;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.g);
            }
            j2 = QbSdk.g / 1000;
            QbSdk.g = 0L;
            QbSdk.f = System.currentTimeMillis();
        }
        return j2;
    }

    public static synchronized void setSysDayOrNight(boolean z) {
        synchronized (WebView.class) {
            if (z == w) {
                return;
            }
            w = z;
            if (v == null) {
                Paint paint = new Paint();
                v = paint;
                paint.setColor(-16777216);
            }
            if (!z) {
                int alpha = v.getAlpha();
                int i = NIGHT_MODE_ALPHA;
                if (alpha != i) {
                    v.setAlpha(i);
                }
            } else if (v.getAlpha() != 255) {
                v.setAlpha(255);
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        t a2 = t.a();
        if (a2 != null && a2.b()) {
            a2.c().a(z);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
                m = declaredMethod;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    m.invoke(null, Boolean.valueOf(z));
                }
            } catch (Exception e) {
                TbsLog.e("QbSdk", "Exception:" + e.getStackTrace());
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(android.webkit.WebView webView) {
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (!this.e) {
            this.g.addJavascriptInterface(obj, str);
        } else {
            this.f.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (!this.e) {
            this.g.addView(view);
            return;
        }
        View view2 = this.f.getView();
        try {
            Method a2 = com.tencent.smtt.utils.k.a(view2, "addView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public boolean canGoBack() {
        if (!this.e) {
            return this.g.canGoBack();
        }
        return this.f.canGoBack();
    }

    public boolean canGoBackOrForward(int i) {
        if (!this.e) {
            return this.g.canGoBackOrForward(i);
        }
        return this.f.canGoBackOrForward(i);
    }

    public boolean canGoForward() {
        if (!this.e) {
            return this.g.canGoForward();
        }
        return this.f.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        Object a2;
        if (!this.e) {
            if (Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.k.a(this.g, "canZoomIn")) == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.canZoomIn();
    }

    @Deprecated
    public boolean canZoomOut() {
        Object a2;
        if (!this.e) {
            if (Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.k.a(this.g, "canZoomOut")) == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.canZoomOut();
    }

    @Deprecated
    public Picture capturePicture() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.k.a(this.g, "capturePicture");
            if (a2 == null) {
                return null;
            }
            return (Picture) a2;
        }
        return this.f.capturePicture();
    }

    public void clearCache(boolean z) {
        if (!this.e) {
            this.g.clearCache(z);
        } else {
            this.f.clearCache(z);
        }
    }

    public void clearFormData() {
        if (!this.e) {
            this.g.clearFormData();
        } else {
            this.f.clearFormData();
        }
    }

    public void clearHistory() {
        if (!this.e) {
            this.g.clearHistory();
        } else {
            this.f.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (!this.e) {
            this.g.clearMatches();
        } else {
            this.f.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (!this.e) {
            this.g.clearSslPreferences();
        } else {
            this.f.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "clearView");
        } else {
            this.f.clearView();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method a2 = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollRange", new Class[0]);
            a2.setAccessible(true);
            return ((Integer) a2.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.e) {
            this.g.computeScroll();
        } else {
            this.f.computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        try {
            if (this.e) {
                Method a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                return ((Integer) a2.invoke(this.f.getView(), new Object[0])).intValue();
            }
            Method a3 = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            return ((Integer) a3.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        try {
            if (this.e) {
                return ((Integer) com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method a2 = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollRange", new Class[0]);
            a2.setAccessible(true);
            return ((Integer) a2.invoke(this.g, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        if (this.e) {
            return WebBackForwardList.a(this.f.copyBackForwardList());
        }
        return WebBackForwardList.a(this.g.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        if (this.e) {
            try {
                return this.f.createPrintDocumentAdapter(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        return com.tencent.smtt.utils.k.a(this.g, "createPrintDocumentAdapter", (Class<?>[]) new Class[]{String.class}, str);
    }

    public void customDiskCachePathEnabled(boolean z, String str) {
        if (!this.e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("enabled", z);
        bundle.putString("path", str);
        getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
    }

    public void destroy() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new Thread("WebviewDestroy") { // from class: com.tencent.smtt.sdk.WebView.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        WebView.this.tbsWebviewDestroy(false);
                    }
                }.start();
                if (this.e) {
                    this.f.destroy();
                } else {
                    this.g.destroy();
                }
            } else {
                tbsWebviewDestroy(true);
            }
        } catch (Throwable unused) {
            tbsWebviewDestroy(true);
        }
    }

    public void documentHasImages(Message message) {
        if (!this.e) {
            this.g.documentHasImages(message);
        } else {
            this.f.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i) {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "dumpViewHierarchyWithProperties", (Class<?>[]) new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i));
        } else {
            this.f.dumpViewHierarchyWithProperties(bufferedWriter, i);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.e) {
            try {
                Method a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                a2.setAccessible(true);
                a2.invoke(this.f.getView(), str, valueCallback);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                loadUrl(str);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", String.class, android.webkit.ValueCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.g, str, valueCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.k.a(this.g, "findAll", (Class<?>[]) new Class[]{String.class}, str);
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        return this.f.findAll(str);
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 16) {
                com.tencent.smtt.utils.k.a(this.g, "findAllAsync", (Class<?>[]) new Class[]{String.class}, str);
                return;
            }
            return;
        }
        this.f.findAllAsync(str);
    }

    public View findHierarchyView(String str, int i) {
        return !this.e ? (View) com.tencent.smtt.utils.k.a(this.g, "findHierarchyView", (Class<?>[]) new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i)) : this.f.findHierarchyView(str, i);
    }

    @TargetApi(3)
    public void findNext(boolean z) {
        if (!this.e) {
            this.g.findNext(z);
        } else {
            this.f.findNext(z);
        }
    }

    public void flingScroll(int i, int i2) {
        if (!this.e) {
            this.g.flingScroll(i, i2);
        } else {
            this.f.flingScroll(i, i2);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "freeMemory");
        } else {
            this.f.freeMemory();
        }
    }

    public SslCertificate getCertificate() {
        if (!this.e) {
            return this.g.getCertificate();
        }
        return this.f.getCertificate();
    }

    public int getContentHeight() {
        if (!this.e) {
            return this.g.getContentHeight();
        }
        return this.f.getContentHeight();
    }

    public int getContentWidth() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.k.a(this.g, "getContentWidth");
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        return this.f.getContentWidth();
    }

    public Bitmap getFavicon() {
        if (!this.e) {
            return this.g.getFavicon();
        }
        return this.f.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        if (!this.e) {
            return new HitTestResult(this.g.getHitTestResult());
        }
        return new HitTestResult(this.f.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        if (!this.e) {
            return this.g.getHttpAuthUsernamePassword(str, str2);
        }
        return this.f.getHttpAuthUsernamePassword(str, str2);
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        if (!this.e) {
            return this.g.getOriginalUrl();
        }
        return this.f.getOriginalUrl();
    }

    public int getProgress() {
        if (!this.e) {
            return this.g.getProgress();
        }
        return this.f.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        Object a2;
        try {
            if (!this.e && Build.VERSION.SDK_INT >= 26 && (a2 = com.tencent.smtt.utils.k.a(this.g, "getRendererPriorityWaivedWhenNotVisible")) != null) {
                return ((Boolean) a2).booleanValue();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        Object a2;
        try {
            if (!this.e && Build.VERSION.SDK_INT >= 26 && (a2 = com.tencent.smtt.utils.k.a(this.g, "getRendererRequestedPriority")) != null) {
                return ((Integer) a2).intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.k.a(this.g, "getScale");
            return a2 == null ? com.sigmob.sdk.base.blurkit.c.d : ((Float) a2).floatValue();
        }
        return this.f.getScale();
    }

    @Override // android.view.View
    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    @Override // android.view.View
    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    @Override // android.view.View
    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        WebSettings webSettings = this.h;
        if (webSettings != null) {
            return webSettings;
        }
        if (this.e) {
            WebSettings webSettings2 = new WebSettings(this.f.getSettings());
            this.h = webSettings2;
            return webSettings2;
        }
        WebSettings webSettings3 = new WebSettings(this.g.getSettings());
        this.h = webSettings3;
        return webSettings3;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getSettingsExtension();
        }
        return null;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        if (!this.e) {
            return this.g.getTitle();
        }
        return this.f.getTitle();
    }

    public String getUrl() {
        if (!this.e) {
            return this.g.getUrl();
        }
        return this.f.getUrl();
    }

    public View getView() {
        if (!this.e) {
            return this.g;
        }
        return this.f.getView();
    }

    public int getVisibleTitleHeight() {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.k.a(this.g, "getVisibleTitleHeight");
            if (a2 == null) {
                return 0;
            }
            return ((Integer) a2).intValue();
        }
        return this.f.getVisibleTitleHeight();
    }

    public WebChromeClient getWebChromeClient() {
        return this.o;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getWebChromeClientExtension();
        }
        return null;
    }

    public int getWebScrollX() {
        if (this.e) {
            return this.f.getView().getScrollX();
        }
        return this.g.getScrollX();
    }

    public int getWebScrollY() {
        if (this.e) {
            return this.f.getView().getScrollY();
        }
        return this.g.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.n;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension().getWebViewClientExtension();
        }
        return null;
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (this.e) {
            return this.f.getHitTestResult();
        }
        return null;
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        if (this.e) {
            return this.f.getX5WebViewExtension();
        }
        return null;
    }

    @Deprecated
    public View getZoomControls() {
        if (!this.e) {
            return (View) com.tencent.smtt.utils.k.a(this.g, "getZoomControls");
        }
        return this.f.getZoomControls();
    }

    public void goBack() {
        if (!this.e) {
            this.g.goBack();
        } else {
            this.f.goBack();
        }
    }

    public void goBackOrForward(int i) {
        if (!this.e) {
            this.g.goBackOrForward(i);
        } else {
            this.f.goBackOrForward(i);
        }
    }

    public void goForward() {
        if (!this.e) {
            this.g.goForward();
        } else {
            this.f.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (!this.e) {
            this.g.invokeZoomPicker();
        } else {
            this.f.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return w;
    }

    public boolean isPrivateBrowsingEnabled() {
        Object a2;
        if (!this.e) {
            if (Build.VERSION.SDK_INT < 11 || (a2 = com.tencent.smtt.utils.k.a(this.g, "isPrivateBrowsingEnabled")) == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.isPrivateBrowsingEnable();
    }

    public void loadData(String str, String str2, String str3) {
        if (!this.e) {
            this.g.loadData(str, str2, str3);
        } else {
            this.f.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.e) {
            this.g.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 8) {
                this.g.loadUrl(str, map);
                return;
            }
            return;
        }
        this.f.loadUrl(str, map);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName)) {
                new Thread("onDetachedFromWindow") { // from class: com.tencent.smtt.sdk.WebView.7
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            WebView.this.a();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            } else {
                a();
            }
        } catch (Throwable unused) {
            a();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        View.OnLongClickListener onLongClickListener = this.y;
        if (onLongClickListener != null) {
            if (onLongClickListener.onLongClick(view)) {
                return true;
            }
            return a(view);
        }
        return a(view);
    }

    public void onPause() {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "onPause");
        } else {
            this.f.onPause();
        }
    }

    public void onResume() {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "onResume");
        } else {
            this.f.onResume();
        }
    }

    @Override // android.view.View
    @TargetApi(11)
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (Build.VERSION.SDK_INT < 21 || !b(this.i) || !isHardwareAccelerated() || i <= 0 || i2 <= 0) {
            return;
        }
        getLayerType();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        String str;
        String str2;
        String str3;
        boolean z;
        Bundle sdkQBStatisticsInfo;
        Context context = this.i;
        if (context == null) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (p == null) {
            p = context.getApplicationInfo().packageName;
        }
        String str4 = p;
        if (str4 != null && (str4.equals("com.tencent.mm") || p.equals(TbsConfig.APP_QQ))) {
            super.onVisibilityChanged(view, i);
            return;
        }
        if (i != 0 && !this.k && this.a != 0) {
            this.k = true;
            if (!this.e || (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) == null) {
                str = "";
                str2 = str;
                str3 = str2;
            } else {
                String string = sdkQBStatisticsInfo.getString("guid");
                String string2 = sdkQBStatisticsInfo.getString("qua2");
                str3 = sdkQBStatisticsInfo.getString("lc");
                str = string;
                str2 = string2;
            }
            if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                int d2 = d(this.i);
                if (d2 == -1) {
                    d2 = this.a;
                }
                this.a = d2;
                e(this.i);
            }
            try {
                z = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("onVisibilityChanged", "exception: " + th);
                z = false;
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, h(), z);
            this.a = 0;
            this.k = false;
        }
        super.onVisibilityChanged(view, i);
    }

    public boolean overlayHorizontalScrollbar() {
        if (!this.e) {
            return this.g.overlayHorizontalScrollbar();
        }
        return this.f.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        if (this.e) {
            return this.f.overlayVerticalScrollbar();
        }
        return this.g.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z) {
        if (!this.e) {
            return this.g.pageDown(z);
        }
        return this.f.pageDown(z, -1);
    }

    public boolean pageUp(boolean z) {
        if (!this.e) {
            return this.g.pageUp(z);
        }
        return this.f.pageUp(z, -1);
    }

    public void pauseTimers() {
        if (!this.e) {
            this.g.pauseTimers();
        } else {
            this.f.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (!this.e) {
            this.g.postUrl(str, bArr);
        } else {
            this.f.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z) {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "refreshPlugins", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        } else {
            this.f.refreshPlugins(z);
        }
    }

    public void reload() {
        if (!this.e) {
            this.g.reload();
        } else {
            this.f.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (this.e) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            com.tencent.smtt.utils.k.a(this.g, "removeJavascriptInterface", (Class<?>[]) new Class[]{String.class}, str);
        } else {
            this.f.removeJavascriptInterface(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (!this.e) {
            this.g.removeView(view);
            return;
        }
        View view2 = this.f.getView();
        try {
            Method a2 = com.tencent.smtt.utils.k.a(view2, "removeView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public JSONObject reportInitPerformance(long j2, int i, long j3, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IS_X5", this.e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        if (this.e) {
            View view2 = this.f.getView();
            if (!(view2 instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view2;
            if (view == this) {
                view = view2;
            }
            return viewGroup.requestChildRectangleOnScreen(view, rect, z);
        }
        a aVar = this.g;
        if (view == this) {
            view = aVar;
        }
        return aVar.requestChildRectangleOnScreen(view, rect, z);
    }

    public void requestFocusNodeHref(Message message) {
        if (!this.e) {
            this.g.requestFocusNodeHref(message);
        } else {
            this.f.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (!this.e) {
            this.g.requestImageRef(message);
        } else {
            this.f.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.k.a(this.g, "restorePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.restorePicture(bundle, file);
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        if (!this.e) {
            return WebBackForwardList.a(this.g.restoreState(bundle));
        }
        return WebBackForwardList.a(this.f.restoreState(bundle));
    }

    public void resumeTimers() {
        if (!this.e) {
            this.g.resumeTimers();
        } else {
            this.f.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "savePassword", (Class<?>[]) new Class[]{String.class, String.class, String.class}, str, str2, str3);
        } else {
            this.f.savePassword(str, str2, str3);
        }
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (!this.e) {
            Object a2 = com.tencent.smtt.utils.k.a(this.g, "savePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        }
        return this.f.savePicture(bundle, file);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        if (!this.e) {
            return WebBackForwardList.a(this.g.saveState(bundle));
        }
        return WebBackForwardList.a(this.f.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 11) {
                com.tencent.smtt.utils.k.a(this.g, "saveWebArchive", (Class<?>[]) new Class[]{String.class}, str);
                return;
            }
            return;
        }
        this.f.saveWebArchive(str);
    }

    public void setARModeEnable(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setARModeEnable(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!this.e) {
            this.g.setBackgroundColor(i);
        } else {
            this.f.setBackgroundColor(i);
        }
        super.setBackgroundColor(i);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (!this.e) {
            this.g.setCertificate(sslCertificate);
        } else {
            this.f.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z) {
        try {
            if (this.e) {
                getSettingsExtension().setDayOrNight(z);
            }
            setSysDayOrNight(z);
            getView().postInvalidate();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        boolean z = this.e;
        if (!z) {
            this.g.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.tencent.smtt.sdk.WebView.4
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 == null) {
                        ApplicationInfo applicationInfo = WebView.this.i == null ? null : WebView.this.i.getApplicationInfo();
                        if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                            com.tencent.smtt.sdk.a.c.a(WebView.this.i, str, null, null);
                            return;
                        }
                        return;
                    }
                    downloadListener2.onDownloadStart(str, str2, str3, str4, j2);
                }
            });
        } else {
            this.f.setDownloadListener(new b(this, downloadListener, z));
        }
    }

    @TargetApi(16)
    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.g.setFindListener(new WebView.FindListener() { // from class: com.tencent.smtt.sdk.WebView.3
                    @Override // android.webkit.WebView.FindListener
                    public void onFindResultReceived(int i, int i2, boolean z) {
                        findListener.onFindResultReceived(i, i2, z);
                    }
                });
                return;
            }
            return;
        }
        this.f.setFindListener(findListener);
    }

    public void setHorizontalScrollbarOverlay(boolean z) {
        if (!this.e) {
            this.g.setHorizontalScrollbarOverlay(z);
        } else {
            this.f.setHorizontalScrollbarOverlay(z);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (!this.e) {
            this.g.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i) {
        if (!this.e) {
            this.g.setInitialScale(i);
        } else {
            this.f.setInitialScale(i);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z) {
        if (!this.e) {
            com.tencent.smtt.utils.k.a(this.g, "setMapTrackballToArrowKeys", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        } else {
            this.f.setMapTrackballToArrowKeys(z);
        }
    }

    public void setNetworkAvailable(boolean z) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 3) {
                this.g.setNetworkAvailable(z);
                return;
            }
            return;
        }
        this.f.setNetworkAvailable(z);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (!this.e) {
            this.g.setOnLongClickListener(onLongClickListener);
            return;
        }
        View view = this.f.getView();
        try {
            if (this.x == null) {
                Method a2 = com.tencent.smtt.utils.k.a(view, "getListenerInfo", new Class[0]);
                a2.setAccessible(true);
                Object invoke = a2.invoke(view, null);
                Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.x = declaredField.get(invoke);
            }
            this.y = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    public void setPictureListener(final PictureListener pictureListener) {
        if (this.e) {
            if (pictureListener == null) {
                this.f.setPictureListener(null);
                return;
            } else {
                this.f.setPictureListener(new IX5WebViewBase.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.6
                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
                        WebView.this.a(iX5WebViewBase);
                        pictureListener.onNewPicture(WebView.this, picture);
                    }

                    @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                    }
                });
                return;
            }
        }
        if (pictureListener == null) {
            this.g.setPictureListener(null);
        } else {
            this.g.setPictureListener(new WebView.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.5
                @Override // android.webkit.WebView.PictureListener
                public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                    WebView.this.a(webView);
                    pictureListener.onNewPicture(WebView.this, picture);
                }
            });
        }
    }

    public void setRendererPriorityPolicy(int i, boolean z) {
        try {
            if (this.e || Build.VERSION.SDK_INT < 26) {
                return;
            }
            com.tencent.smtt.utils.k.a(this.g, "setRendererPriorityPolicy", (Class<?>[]) new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i), Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i) {
        if (this.e) {
            this.f.getView().setScrollBarStyle(i);
        } else {
            this.g.setScrollBarStyle(i);
        }
    }

    public void setSysNightModeAlpha(int i) {
        NIGHT_MODE_ALPHA = i;
    }

    public void setVerticalScrollbarOverlay(boolean z) {
        if (!this.e) {
            this.g.setVerticalScrollbarOverlay(z);
        } else {
            this.f.setVerticalScrollbarOverlay(z);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z) {
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getView() == null) {
            return;
        }
        getView().setVisibility(i);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (this.e) {
            this.f.setWebChromeClient(webChromeClient != null ? new f(t.a().a(true).i(), this, webChromeClient) : null);
        } else {
            this.g.setWebChromeClient(webChromeClient != null ? new SystemWebChromeClient(this, webChromeClient) : null);
        }
        this.o = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        }
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (!this.e || getX5WebViewExtension() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("flag", true);
        getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        if (this.e) {
            this.f.setWebViewClient(webViewClient != null ? new g(t.a().a(true).j(), this, webViewClient) : null);
        } else {
            this.g.setWebViewClient(webViewClient != null ? new SystemWebViewClient(this, webViewClient) : null);
        }
        this.n = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (this.e) {
            this.f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            com.tencent.smtt.utils.d.a(this.i).a(lowerCase, this, this.i, k.a().getLooper());
            return true;
        }
        if (!lowerCase.startsWith("http://debugx5.qq.com") || this.e) {
            return false;
        }
        loadDataWithBaseURL(null, "<!DOCTYPE html><html><body><head><title>无法打开debugx5</title><meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" /></head><br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a></body></html>", "text/html", "utf-8", null);
        return true;
    }

    public boolean showFindDialog(String str, boolean z) {
        return false;
    }

    public void stopLoading() {
        if (!this.e) {
            this.g.stopLoading();
        } else {
            this.f.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (!this.e) {
            this.g.a();
            return;
        }
        try {
            com.tencent.smtt.utils.k.a(this.f.getView(), "super_computeScroll");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.b(motionEvent);
        }
        try {
            Object a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "super_dispatchTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.c(motionEvent);
        }
        try {
            Object a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "super_onInterceptTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (!this.e) {
            this.g.a(i, i2, z, z2);
            return;
        }
        View view = this.f.getView();
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            com.tencent.smtt.utils.k.a(view, "super_onOverScrolled", (Class<?>[]) new Class[]{cls, cls, cls2, cls2}, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        if (!this.e) {
            this.g.a(i, i2, i3, i4);
            return;
        }
        View view = this.f.getView();
        try {
            Class cls = Integer.TYPE;
            com.tencent.smtt.utils.k.a(view, "super_onScrollChanged", (Class<?>[]) new Class[]{cls, cls, cls, cls}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.e) {
            return this.g.a(motionEvent);
        }
        try {
            Object a2 = com.tencent.smtt.utils.k.a(this.f.getView(), "super_onTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (!this.e) {
            return this.g.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }
        View view = this.f.getView();
        try {
            Class cls = Integer.TYPE;
            Object a2 = com.tencent.smtt.utils.k.a(view, "super_overScrollBy", (Class<?>[]) new Class[]{cls, cls, cls, cls, cls, cls, cls, cls, Boolean.TYPE}, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z));
            if (a2 == null) {
                return false;
            }
            return ((Boolean) a2).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void switchNightMode(boolean z) {
        if (z == w) {
            return;
        }
        w = z;
        if (z) {
            TbsLog.e("QB_SDK", "deleteNightMode");
            loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
        } else {
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (w) {
            return;
        }
        TbsLog.e("QB_SDK", "switchToNightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }

    public void tbsWebviewDestroy(boolean z) {
        boolean z2;
        Bundle sdkQBStatisticsInfo;
        if (!this.k && this.a != 0) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.e && (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                str = sdkQBStatisticsInfo.getString("guid");
                str2 = sdkQBStatisticsInfo.getString("qua2");
                str3 = sdkQBStatisticsInfo.getString("lc");
            }
            String str4 = str;
            String str5 = str2;
            String str6 = str3;
            if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                int d2 = d(this.i);
                if (d2 == -1) {
                    d2 = this.a;
                }
                this.a = d2;
                e(this.i);
            }
            try {
                z2 = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("tbsWebviewDestroy", "exception: " + th);
                z2 = false;
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str4, str5, str6, this.a, this.e, h(), z2);
            this.a = 0;
            this.k = false;
        }
        if (!this.e) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, this.g);
                if (invoke != null) {
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception unused) {
            }
            if (z) {
                this.g.destroy();
            }
            try {
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        } else if (z) {
            this.f.destroy();
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
    }

    public boolean zoomIn() {
        if (!this.e) {
            return this.g.zoomIn();
        }
        return this.f.zoomIn();
    }

    public boolean zoomOut() {
        if (!this.e) {
            return this.g.zoomOut();
        }
        return this.f.zoomOut();
    }

    private boolean b(Context context) {
        try {
            return context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void e(Context context) {
        try {
            File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e.toString());
        }
    }

    protected void a() {
        String str;
        String str2;
        String str3;
        boolean z;
        Bundle sdkQBStatisticsInfo;
        if (!this.k && this.a != 0) {
            this.k = true;
            if (!this.e || (sdkQBStatisticsInfo = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo()) == null) {
                str = "";
                str2 = str;
                str3 = str2;
            } else {
                String string = sdkQBStatisticsInfo.getString("guid");
                String string2 = sdkQBStatisticsInfo.getString("qua2");
                str3 = sdkQBStatisticsInfo.getString("lc");
                str = string;
                str2 = string2;
            }
            if (TbsConfig.APP_QZONE.equals(this.i.getApplicationInfo().packageName)) {
                int d2 = d(this.i);
                if (d2 == -1) {
                    d2 = this.a;
                }
                this.a = d2;
                e(this.i);
            }
            try {
                z = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("tbsOnDetachedFromWindow", "exception: " + th);
                z = false;
            }
            com.tencent.smtt.sdk.a.b.a(this.i, str, str2, str3, this.a, this.e, h(), z);
            this.a = 0;
            this.k = false;
        }
        super.onDetachedFromWindow();
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class HitTestResult {

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;
        private IX5WebViewBase.HitTestResult a;
        private WebView.HitTestResult b;

        public HitTestResult() {
            this.b = null;
            this.a = null;
            this.b = null;
        }

        public String getExtra() {
            IX5WebViewBase.HitTestResult hitTestResult = this.a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            return hitTestResult2 != null ? hitTestResult2.getExtra() : "";
        }

        public int getType() {
            IX5WebViewBase.HitTestResult hitTestResult = this.a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            WebView.HitTestResult hitTestResult2 = this.b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getType();
            }
            return 0;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.b = null;
            this.a = hitTestResult;
            this.b = null;
        }

        public HitTestResult(WebView.HitTestResult hitTestResult) {
            this.b = null;
            this.a = null;
            this.b = hitTestResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.webkit.WebView b() {
        if (this.e) {
            return null;
        }
        return this.g;
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z, ValueCallback<String> valueCallback) {
        if (!this.e) {
            if (Build.VERSION.SDK_INT >= 11) {
                com.tencent.smtt.utils.k.a(this.g, "saveWebArchive", (Class<?>[]) new Class[]{String.class, Boolean.TYPE, android.webkit.ValueCallback.class}, str, Boolean.valueOf(z), valueCallback);
                return;
            }
            return;
        }
        this.f.saveWebArchive(str, z, valueCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IX5WebViewBase c() {
        return this.f;
    }

    public void loadUrl(String str) {
        if (str == null || showDebugView(str)) {
            return;
        }
        if (!this.e) {
            this.g.loadUrl(str);
        } else {
            this.f.loadUrl(str);
        }
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    public WebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        this(context, attributeSet, i, null, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(IX5WebViewBase iX5WebViewBase) {
        this.f = iX5WebViewBase;
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i, Map<String, Object> map, boolean z) {
        super(context, attributeSet, i);
        this.b = "WebView";
        this.e = false;
        this.h = null;
        this.i = null;
        this.a = 0;
        this.k = false;
        this.n = null;
        this.o = null;
        this.q = 1;
        this.r = 2;
        this.s = 3;
        this.t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.x = null;
        this.y = null;
        mWebViewCreated = true;
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.i = context;
            this.f = null;
            this.e = false;
            QbSdk.a(context, "failed to createTBSWebview!");
            this.g = new a(context, attributeSet);
            CookieManager.getInstance().a(context, true, false);
            CookieSyncManager.createInstance(this.i).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new e());
                mSysWebviewCreated = true;
            } catch (Exception unused) {
            }
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new FrameLayout.LayoutParams(-1, -1));
            TbsLog.i("WebView", "SystemWebView Created Success! #3");
            TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable());
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.setWriteLogJIT(true);
        } else {
            TbsLog.setWriteLogJIT(false);
        }
        TbsLog.initIfNeed(context);
        if (context != null) {
            if (l == null) {
                l = com.tencent.smtt.utils.o.a(context);
            }
            if (l.a) {
                TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
                QbSdk.a(context, "debug.conf force syswebview!");
            }
            c(context);
            this.i = context;
            if (context != null) {
                j = context.getApplicationContext();
            }
            if (this.e && !QbSdk.a) {
                IX5WebViewBase a2 = t.a().a(true).a(context);
                this.f = a2;
                if (a2 != null && a2.getView() != null) {
                    TbsLog.i("WebView", "X5 WebView Created Success!!");
                    this.f.getView().setFocusableInTouchMode(true);
                    a(attributeSet);
                    addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
                    this.f.setDownloadListener(new b(this, null, this.e));
                    this.f.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(t.a().a(true).k()) { // from class: com.tencent.smtt.sdk.WebView.1
                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void invalidate() {
                        }

                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void onScrollChanged(int i2, int i3, int i4, int i5) {
                            super.onScrollChanged(i2, i3, i4, i5);
                            WebView.this.onScrollChanged(i4, i5, i2, i3);
                        }
                    });
                } else {
                    TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                    this.f = null;
                    this.e = false;
                    QbSdk.a(context, "failed to createTBSWebview!");
                    c(context);
                    if (TbsShareManager.isThirdPartyApp(this.i)) {
                        this.g = new a(context, attributeSet);
                    } else {
                        this.g = new a(this, context);
                    }
                    TbsLog.i("WebView", "SystemWebView Created Success! #1");
                    CookieManager.getInstance().a(context, true, false);
                    CookieManager.getInstance().a();
                    this.g.setFocusableInTouchMode(true);
                    addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                    try {
                        if (Build.VERSION.SDK_INT >= 11) {
                            removeJavascriptInterface("searchBoxJavaBridge_");
                            removeJavascriptInterface("accessibility");
                            removeJavascriptInterface("accessibilityTraversal");
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    TbsLog.writeLogToDisk();
                    l.a(context);
                    return;
                }
            } else {
                this.f = null;
                if (TbsShareManager.isThirdPartyApp(this.i)) {
                    this.g = new a(context, attributeSet);
                } else {
                    this.g = new a(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #2");
                CookieManager.getInstance().a(context, true, false);
                CookieManager.getInstance().a();
                this.g.setFocusableInTouchMode(true);
                addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                setDownloadListener(null);
                TbsLog.writeLogToDisk();
                l.a(context);
            }
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    removeJavascriptInterface("searchBoxJavaBridge_");
                    removeJavascriptInterface("accessibility");
                    removeJavascriptInterface("accessibilityTraversal");
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if ((TbsConfig.APP_QQ.equals(this.i.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.i.getApplicationInfo().packageName)) && d.a(true).h() && Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
            if (this.f != null) {
                TbsLog.writeLogToDisk();
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i2 > 0 && i2 != l.a().h(context) && i2 == l.a().i(context)) {
                        l.a().n(context);
                    } else {
                        TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + l.a().h(context) + " getTbsCoreInstalledVerInNolock is " + l.a().i(context));
                    }
                }
            }
            QbSdk.continueLoadSo(context);
            return;
        }
        throw new IllegalArgumentException("Invalid context argument");
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    if (attributeSet.getAttributeName(i).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(R.attr.scrollbars);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        try {
            new Thread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (WebView.j == null) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    d a2 = d.a(true);
                    if (!d.b) {
                        j a3 = j.a(WebView.j);
                        int c2 = a3.c();
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + c2);
                        if (c2 == 2) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                            a2.a(String.valueOf(a3.b()));
                            a2.b(true);
                            return;
                        }
                        int b = a3.b("copy_status");
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + b);
                        if (b == 1) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                            a2.a(String.valueOf(a3.c("copy_core_ver")));
                            a2.b(true);
                            return;
                        } else {
                            if (t.a().b()) {
                                return;
                            }
                            if (c2 == 3 || b == 3) {
                                TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                                a2.a(String.valueOf(d.d()));
                                a2.b(true);
                                return;
                            }
                            return;
                        }
                    }
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                }
            }).start();
        } catch (Throwable th) {
            TbsLog.e("webview", "updateRebootStatus excpetion: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public void a(Context context) {
        String str;
        int d2 = d(context);
        if (d2 != -1) {
            str = "PV=" + String.valueOf(d2 + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(context.getDir("tbs", 0) + File.separator + "core_private", "pv.db");
        try {
            try {
                file.getParentFile().mkdirs();
                if (!file.isFile() || !file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                d = fileOutputStream;
                fileOutputStream.write(str.getBytes());
                OutputStream outputStream = d;
                if (outputStream != null) {
                    outputStream.flush();
                }
            } catch (Throwable th) {
                OutputStream outputStream2 = d;
                if (outputStream2 != null) {
                    outputStream2.flush();
                }
                throw th;
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(View view) {
        Object a2;
        Context context = this.i;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (a2 = com.tencent.smtt.utils.k.a(this.x, "onLongClick", (Class<?>[]) new Class[]{View.class}, view)) != null) {
            return ((Boolean) a2).booleanValue();
        }
        return false;
    }
}
