package com.sigmob.sdk.base.common;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import com.sigmob.windad.WindAdRequest;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class w extends j {
    com.sigmob.sdk.base.views.g f;
    private int g;
    private BaseAdUnit h;
    private RelativeLayout i;
    private TextView j;
    private ImageView k;
    private String l;

    /* renamed from: com.sigmob.sdk.base.common.w$7, reason: invalid class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class AnonymousClass7 {
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

    public w(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, k kVar) {
        super(activity, str, kVar);
        this.h = baseAdUnit;
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable(BaseAdActivity.i);
            if (serializable instanceof BaseAdUnit) {
                this.h = (BaseAdUnit) serializable;
            }
        }
        if (this.h != null) {
            n().requestWindowFeature(8);
        } else {
            a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            k().a();
        }
    }

    private void a() {
        if (this.f == null) {
            try {
                com.sigmob.sdk.base.views.g gVar = new com.sigmob.sdk.base.views.g(n());
                this.f = gVar;
                gVar.setScrollBarStyle(0);
                this.f.setAdUnit(this.h);
                this.f.setWebViewClient(new com.sigmob.sdk.base.h() { // from class: com.sigmob.sdk.base.common.w.1
                    @Override // com.sigmob.sdk.base.h, android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        ae.a("h5_error", "landpage", i, str2 + " error:" + str, (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                        SigmobLog.i("onReceivedError:" + webResourceError.toString());
                        int i = Build.VERSION.SDK_INT;
                        if (i < 21 || i < 23) {
                            return;
                        }
                        ae.a("h5_error", "landpage", 0, webResourceRequest.getUrl() + " error:" + ((Object) webResourceError.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            ae.a("h5_error", "landpage", webResourceResponse.getStatusCode(), webResourceRequest.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        String message;
                        Context context;
                        String scheme;
                        int i;
                        try {
                            context = webView.getContext();
                            Uri parse = Uri.parse(str);
                            scheme = parse.getScheme();
                            if (StringUtil.scheme().equalsIgnoreCase(scheme)) {
                                String host = parse.getHost();
                                if (!TextUtils.isEmpty(host) && ("track".equals(host) || "active".equals(host))) {
                                    String queryParameter = parse.getQueryParameter("data");
                                    String queryParameter2 = parse.getQueryParameter("event");
                                    if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                                        final String str2 = new String(Base64.decode(queryParameter, 0), "utf-8");
                                        ae.a(host, queryParameter2, w.this.h, new ae.a() { // from class: com.sigmob.sdk.base.common.w.1.1
                                            @Override // com.sigmob.sdk.base.common.ae.a
                                            public void a(Object obj) {
                                                if (obj instanceof PointEntitySigmob) {
                                                    ((PointEntitySigmob) obj).setUrl(str2);
                                                }
                                            }
                                        });
                                    }
                                    return true;
                                }
                            }
                        } catch (IntentNotResolvableException e) {
                            message = e.getMessage();
                            SigmobLog.e(message);
                            return true;
                        } catch (Throwable th) {
                            message = th.getMessage();
                            SigmobLog.e(message);
                            return true;
                        }
                        if (TextUtils.isEmpty(scheme) || scheme.equals("http") || scheme.equals(BaseConstants.SCHEME_HTTPS)) {
                            SigmobLog.i("load Url: " + str);
                            webView.loadUrl(str);
                            return true;
                        }
                        List<String> list = w.this.h.getAdSetting() != null ? w.this.h.getAdSetting().scheme_white_list : null;
                        if (list != null && list.size() > 0) {
                            for (i = 0; i < list.size(); i++) {
                                String str3 = list.get(i);
                                if (!str.startsWith(str3) && !str3.equals("*")) {
                                }
                                u.a(context, Uri.parse(str));
                                ae.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", w.this.h, "1", str, w.this.l);
                            }
                        }
                        return true;
                    }
                });
                this.f.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.common.w.2
                    @Override // android.webkit.WebChromeClient
                    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                        if (AnonymousClass7.a[consoleMessage.messageLevel().ordinal()] != 1) {
                            return false;
                        }
                        SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                        ae.a("h5_error", "landpage", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, w.this.h, (ae.a) null);
                        return false;
                    }

                    @Override // android.webkit.WebChromeClient
                    public void onReceivedTitle(WebView webView, String str) {
                        if (str == null || str.isEmpty() || str.startsWith("http") || str.length() > 10) {
                            if (w.this.j != null) {
                                w.this.j.setVisibility(8);
                            }
                        } else if (w.this.j != null) {
                            w.this.j.setVisibility(0);
                            w.this.j.setText(str);
                        }
                    }
                });
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                this.d.a();
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout = new LinearLayout(n());
        linearLayout.addView(this.f, 0, layoutParams);
        this.d.onSetContentView(linearLayout);
        if (this.h.getAd() != null && this.h.getAd().ad_setting != null && !this.h.getAd().ad_setting.disable_download_listener.booleanValue()) {
            this.f.setDownloadListener(new DownloadListener() { // from class: com.sigmob.sdk.base.common.w.3
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    p.a(str, w.this.h);
                    ae.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", w.this.h, "0", str, w.this.l);
                    SigmobLog.d("onDownloadStart() called with: url = [" + str + "], userAgent = [" + str2 + "], contentDisposition = [" + str3 + "], mimetype = [" + str4 + "], contentLength = [" + j + "]");
                }
            });
        }
        this.f.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.base.common.w.4
            MotionEvent a = null;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                SigmobLog.d(motionEvent.toString());
                if (motionEvent.getAction() == 0) {
                    this.a = MotionEvent.obtain(motionEvent);
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                MotionEvent motionEvent2 = this.a;
                if (motionEvent2 == null) {
                    w.this.l = SigMacroCommon.getCoordinate(motionEvent, motionEvent, true);
                    return false;
                }
                w.this.l = SigMacroCommon.getCoordinate(motionEvent2, motionEvent, true);
                return false;
            }
        });
    }

    private void a(String str, String str2, BaseAdUnit baseAdUnit, final String str3) {
        ae.a(str2, str, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.base.common.w.5
            @Override // com.sigmob.sdk.base.common.ae.a
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).setCoordinate(str3);
                }
            }
        });
    }

    private void p() {
        if (this.i == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.b);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
            layoutParams2.addRule(15);
            layoutParams2.addRule(9);
            int i = dipsToIntPixels / 2;
            layoutParams2.setMargins(i, i, 0, 0);
            ImageView imageView = new ImageView(this.b);
            this.k = imageView;
            imageView.setImageBitmap(com.sigmob.sdk.base.views.s.BACK.a());
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setClickable(true);
            this.k.setId(ClientMetadata.generateViewId());
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.common.w.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    w.this.k().a();
                }
            });
            RelativeLayout relativeLayout = new RelativeLayout(l());
            this.i = relativeLayout;
            relativeLayout.setLayoutParams(layoutParams);
            this.i.setBackgroundColor(-1);
            this.i.addView(this.k, layoutParams2);
            TextView textView = new TextView(this.b);
            this.j = textView;
            textView.setTextColor(-16777216);
            this.j.setTextSize(18.0f);
            this.j.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            this.i.addView(this.j, layoutParams3);
        }
    }

    private void q() {
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-1, -1, 17);
        ActionBar actionBar = n().getActionBar();
        if (actionBar != null) {
            p();
            actionBar.setCustomView(this.i, layoutParams);
            actionBar.setDisplayOptions(16);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void e() {
        int c2 = com.sigmob.sdk.base.g.c();
        if (c2 > 0) {
            n().getTheme().applyStyle(c2, true);
        }
        n().getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        q();
        a();
        String macroProcess = this.h.getMacroCommon().macroProcess(this.h.getMaterial().landing_page);
        if (TextUtils.isEmpty(this.h.getLandUrl())) {
            this.f.loadUrl(macroProcess);
        } else {
            this.f.loadUrl(this.h.getLandUrl());
        }
        a(IntentActions.ACTION_LANDPAGE_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void f() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void g() {
        com.sigmob.sdk.base.views.g gVar = this.f;
        if (gVar != null) {
            gVar.resumeTimers();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void h() {
        a(IntentActions.ACTION_LANDPAGE_DISMISS);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.k = null;
        }
        com.sigmob.sdk.base.views.g gVar = this.f;
        if (gVar != null) {
            gVar.destroy();
            this.f = null;
        }
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void i() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean j() {
        if (!this.f.canGoBack()) {
            return true;
        }
        this.f.goBack();
        return false;
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }
}
