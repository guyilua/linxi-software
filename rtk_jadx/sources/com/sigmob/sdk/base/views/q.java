package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.o;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class q extends Dialog implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private b a;
    private Map<String, String> b;

    /* renamed from: c, reason: collision with root package name */
    private Context f482c;
    private Window d;
    private int e;
    private int f;
    private g g;
    private BaseAdUnit h;
    private boolean i;
    private ImageView j;
    private String k;
    private File l;
    private boolean m;
    private RelativeLayout n;
    private Handler o;

    /* renamed from: com.sigmob.sdk.base.views.q$5, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public static class a {
        private Map<String, String> a;

        public a(Map<String, String> map) {
            this.a = map;
        }

        @JavascriptInterface
        public String getPrivacyInfo() {
            try {
                Map<String, String> map = this.a;
                if (map == null || map.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : this.a.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface b {
        void a();

        void a(String str, String str2);

        void b();
    }

    public q(Context context, BaseAdUnit baseAdUnit) {
        super(context, com.sigmob.sdk.base.g.f());
        this.d = null;
        this.i = false;
        this.k = "";
        this.f482c = context.getApplicationContext();
        this.h = baseAdUnit;
        this.g = b();
        this.j = d();
        this.e = DeviceUtils.getRealMetrics(com.sigmob.sdk.b.e()).widthPixels;
        this.f = DeviceUtils.getRealMetrics(com.sigmob.sdk.b.e()).heightPixels;
    }

    private ImageView d() {
        ImageView imageView = new ImageView(this.f482c);
        this.j = imageView;
        imageView.setImageBitmap(s.CLOSE.a());
        this.j.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setImageAlpha(127);
        this.j.setClickable(true);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q.this.a != null) {
                    q.this.a.a();
                }
            }
        });
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.j != null) {
            int dipsToIntPixels = Dips.dipsToIntPixels(18.0f, this.f482c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            int i = dipsToIntPixels / 2;
            layoutParams.setMargins(0, i, i, 0);
            this.n.addView(this.j, layoutParams);
        }
    }

    private void f() {
        Window window = getWindow();
        this.d = window;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            this.d.setAttributes(attributes);
        }
    }

    public void a(b bVar) {
        this.a = bVar;
    }

    public boolean a() {
        return this.i;
    }

    public g b() {
        g gVar;
        String str;
        AdPrivacy adPrivacy;
        BaseAdUnit baseAdUnit = this.h;
        if (baseAdUnit != null) {
            MaterialMeta material = baseAdUnit.getMaterial();
            if (material == null || (adPrivacy = material.ad_privacy) == null) {
                SigmobLog.i("ad_privacy is null");
            } else {
                Map<String, String> map = adPrivacy.privacy_template_info;
                if (map != null && map.size() > 0) {
                    this.b = adPrivacy.privacy_template_info;
                }
                if (!TextUtils.isEmpty(adPrivacy.privacy_template_url)) {
                    String md5 = Md5Util.md5(adPrivacy.privacy_template_url);
                    this.l = com.sigmob.sdk.base.utils.e.a(com.sigmob.sdk.base.utils.e.d(com.sigmob.sdk.base.utils.e.b), md5 + ".html");
                }
            }
        }
        File file = this.l;
        if (file == null || !file.exists() || this.b == null) {
            this.i = false;
            return null;
        }
        this.i = true;
        g gVar2 = new g(this.f482c);
        this.g = gVar2;
        gVar2.a(true);
        this.g.setAdUnit(this.h);
        this.g.a((o.a) null);
        this.g.setBackgroundColor(0);
        this.g.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.views.q.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (AnonymousClass5.a[consoleMessage.messageLevel().ordinal()] != 1) {
                    return false;
                }
                SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ae.a) null);
                return false;
            }
        });
        this.g.setWebViewClient(new WebViewClient() { // from class: com.sigmob.sdk.base.views.q.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str2, String str3) {
                com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, str3 + " error:" + str2, (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ae.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                SigmobLog.i("onReceivedError:" + webResourceError.toString());
                int i = Build.VERSION.SDK_INT;
                if (i >= 21 && i >= 23) {
                    com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, webResourceRequest.getUrl() + " error:" + ((Object) webResourceError.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ae.a) null);
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (Build.VERSION.SDK_INT >= 21) {
                    com.sigmob.sdk.base.common.ae.a("h5_error", "download_dialog", 0, webResourceRequest.getUrl() + " error:" + webResourceResponse.getStatusCode(), (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ae.a) null);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                SigmobLog.i("onReceivedSslError:" + sslError.toString());
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        return com.sigmob.sdk.base.h.a(webResourceRequest.getUrl());
                    }
                    return null;
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                try {
                    return com.sigmob.sdk.base.h.a(Uri.parse(str2));
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(webView, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                try {
                    SigmobLog.i("shouldOverrideUrlLoading:" + str2);
                    Uri parse = Uri.parse(str2);
                    if (StringUtil.scheme().equalsIgnoreCase(parse.getScheme())) {
                        String host = parse.getHost();
                        if (!TextUtils.isEmpty(host)) {
                            if ("useCustomClose".equals(host)) {
                                q.this.m = true;
                                q.this.o.removeCallbacksAndMessages(null);
                            } else if ("closeFourElements".equals(host)) {
                                if (q.this.a != null) {
                                    q.this.a.a();
                                }
                            } else if ("buttonClick".equals(host)) {
                                Map queryParamMap = ClientMetadata.getQueryParamMap(parse);
                                String str3 = (String) queryParamMap.get("url");
                                String str4 = (String) queryParamMap.get("x");
                                String str5 = "0";
                                if (TextUtils.isEmpty(str4)) {
                                    str4 = "0";
                                }
                                String str6 = (String) queryParamMap.get("y");
                                if (!TextUtils.isEmpty(str6)) {
                                    str5 = str6;
                                }
                                String format = String.format("%s,%s,%s,%s", str4, str5, str4, str5);
                                q.this.h.getMacroCommon().updateClickMarco(str4, str5, str4, str5);
                                q.this.h.getClickCommon().down = new TouchLocation(Integer.parseInt(str4), Integer.parseInt(str5));
                                q.this.h.getClickCommon().up = new TouchLocation(Integer.parseInt(str4), Integer.parseInt(str5));
                                if (q.this.a != null) {
                                    q.this.a.a(str3, format);
                                }
                            }
                            return true;
                        }
                    }
                } catch (Throwable th) {
                    SigmobLog.e("DownloadDialog:" + th.getMessage());
                }
                if (!TextUtils.isEmpty(str2) && str2.startsWith("http")) {
                    webView.loadUrl(str2);
                }
                return true;
            }
        });
        if (TextUtils.isEmpty(this.k)) {
            File file2 = this.l;
            if (file2 == null || !file2.exists()) {
                this.i = false;
                return this.g;
            }
            this.g.addJavascriptInterface(new a(this.b), "sigPrivacy");
            gVar = this.g;
            str = "file://" + this.l.getAbsolutePath();
        } else {
            gVar = this.g;
            str = this.k;
        }
        gVar.loadUrl(str);
        return this.g;
    }

    public void c() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.destroy();
            this.g = null;
        }
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.o = null;
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            com.sigmob.sdk.base.utils.f.a(imageView);
            this.j = null;
        }
        if (this.f482c != null) {
            this.f482c = null;
        }
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.n = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        Window window = getWindow();
        this.d = window;
        com.sigmob.sdk.videoplayer.d.a(window);
        this.n.setBackgroundColor(0);
        setContentView(this.n);
        setOnShowListener(this);
        setOnDismissListener(this);
        if (this.g != null) {
            this.n.addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.o = handler;
        handler.postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.q.2
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.m) {
                    return;
                }
                q.this.e();
            }
        }, 5000L);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        f();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        SigmobLog.i("DownloadDialog  onDismiss");
        b bVar = this.a;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        SigmobLog.i("DownloadDialog  onShow");
        b bVar = this.a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
