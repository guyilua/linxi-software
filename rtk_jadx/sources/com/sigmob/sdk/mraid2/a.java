package com.sigmob.sdk.mraid2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.views.ar;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class a extends FrameLayout {
    public static HashMap<String, com.sigmob.sdk.mraid.j> a = new LinkedHashMap();
    private static String b = "BaseWebView2";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f577c = false;
    private Map<String, APKStatusBroadcastReceiver> d;
    private com.sigmob.sdk.base.views.g e;

    /* renamed from: com.sigmob.sdk.mraid2.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    private class C0052a {
        public C0052a() {
        }

        @JavascriptInterface
        public int cancelDownloadTaskByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.b, baseAdUnit + "-----------resumeDownloadByVid---------" + str);
            if (baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.c(a.this.getContext(), baseAdUnit);
        }

        @JavascriptInterface
        public int getApKDownloadProcessId(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.b, baseAdUnit + "-----------getApKDownloadProcessId---------" + str);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            if (a.this.getContext() == null || baseAdUnit == null) {
                return -1;
            }
            long[] d = baseAdUnit.getApkDownloadType() != 0 ? com.sigmob.sdk.base.common.n.d(a.this.getContext(), baseAdUnit) : com.sigmob.sdk.base.common.p.a(a.this.getContext(), baseAdUnit.getDownloadId());
            int i2 = (int) d[2];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        return i2 != 8 ? -1 : 100;
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
        public int pauseDownloadByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.b, baseAdUnit + "-----------PauseDownloadByVid---------" + str);
            if (baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.a(a.this.getContext(), baseAdUnit);
        }

        @JavascriptInterface
        public void registerDownloadEvent(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.b, baseAdUnit + "-----------registerDownloadEvent---------" + str);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            a.this.a(baseAdUnit);
        }

        @JavascriptInterface
        public int resumeDownloadByVid(String str) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() != null && a.this.getAdUnitList().size() > 0) {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(str)) {
                        break;
                    }
                }
            }
            baseAdUnit = null;
            Log.d(a.b, baseAdUnit + "-----------resumeDownloadByVid---------" + str);
            if (baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.n.b(a.this.getContext(), baseAdUnit);
        }
    }

    public a(Context context) {
        super(context);
        this.d = new HashMap();
        this.e = null;
        com.sigmob.sdk.base.views.g a2 = ar.a().a(context);
        this.e = a2;
        if (a2 == null) {
            this.e = new com.sigmob.sdk.base.views.g(context);
        }
        this.e.addJavascriptInterface(new C0052a(), "sigandroidapk");
        addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    }

    public void a() {
        Map<String, APKStatusBroadcastReceiver> map = this.d;
        if (map != null && map.size() > 0) {
            for (APKStatusBroadcastReceiver aPKStatusBroadcastReceiver : this.d.values()) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
            this.d.clear();
        }
        HashMap<String, com.sigmob.sdk.mraid.j> hashMap = a;
        if (hashMap != null && hashMap.size() > 0) {
            for (com.sigmob.sdk.mraid.j jVar : a.values()) {
                if (jVar != null) {
                    jVar.c();
                }
            }
            a.clear();
        }
        if (this.e != null) {
            ar.a().a(this.e);
            this.e = null;
        }
        removeAllViews();
    }

    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || this.d.get(baseAdUnit.getUuid()) != null) {
            return;
        }
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new o.a() { // from class: com.sigmob.sdk.mraid2.a.1
            @Override // com.sigmob.sdk.base.common.o.a
            public void a(boolean z) {
                if (z) {
                    a.this.f();
                } else {
                    a.this.c();
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void a(boolean z, long j) {
                if (z) {
                    a.this.b();
                } else {
                    a.this.c();
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void b(boolean z) {
                if (z) {
                    a.this.g();
                } else {
                    a.this.c();
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void b(boolean z, long j) {
                if (z) {
                    a.this.e();
                } else {
                    a.this.c();
                }
            }

            @Override // com.sigmob.sdk.base.common.o.a
            public void c(boolean z, long j) {
                a.this.d();
            }
        }, baseAdUnit.getUuid());
        aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
        this.d.put(baseAdUnit.getUuid(), aPKStatusBroadcastReceiver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"JavascriptInterface"})
    public void a(Object obj, String str) {
        this.e.addJavascriptInterface(obj, str);
    }

    public void a(String str) {
        this.e.loadUrl(str);
    }

    void a(String str, ValueCallback valueCallback) {
        if (this.e == null) {
            return;
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + str);
        if (Build.VERSION.SDK_INT >= 19) {
            this.e.evaluateJavascript(str, valueCallback);
            return;
        }
        a("javascript:" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, String str3, String str4, String str5) {
        com.sigmob.sdk.base.views.g gVar = this.e;
        if (gVar != null) {
            gVar.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        com.sigmob.sdk.base.views.g gVar = this.e;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    void b() {
        b("download_start");
    }

    void b(final String str) {
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.a("mraidbridge.notifyApkDownloadStateEvent(\"" + str + "\");", (ValueCallback) null);
            }
        });
    }

    public void b(String str, ValueCallback valueCallback) {
        com.sigmob.sdk.base.views.g gVar;
        if (Build.VERSION.SDK_INT < 19 || (gVar = this.e) == null) {
            return;
        }
        gVar.evaluateJavascript(str, valueCallback);
    }

    void c() {
        b("download_fail");
    }

    void d() {
        b("download_pause");
    }

    void e() {
        b(PointCategory.DOWNLOAD_END);
    }

    void f() {
        b(com.sigmob.sdk.base.common.a.I);
    }

    void g() {
        b("install_end");
    }

    abstract List<BaseAdUnit> getAdUnitList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSettings getSettings() {
        return this.e.getSettings();
    }

    public void h() {
        com.sigmob.sdk.base.views.g gVar = this.e;
        if (gVar != null) {
            gVar.reload();
        }
    }

    public void i() {
        com.sigmob.sdk.base.views.g gVar = this.e;
        if (gVar != null) {
            gVar.stopLoading();
        }
    }

    public void j() {
        this.e.resumeTimers();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        if (Build.VERSION.SDK_INT >= 16) {
            this.e.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        this.e.setBackgroundColor(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        com.sigmob.sdk.base.views.g gVar = this.e;
        if (gVar != null) {
            gVar.setWebChromeClient(webChromeClient);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWebViewClient(WebViewClient webViewClient) {
        com.sigmob.sdk.base.views.g gVar = this.e;
        if (gVar != null) {
            gVar.setWebViewClient(webViewClient);
        }
    }
}
