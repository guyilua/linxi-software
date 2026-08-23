package com.rtk.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class X5WebView extends WebView {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends WebViewClient {
        a(X5WebView x5WebView) {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public X5WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new a(this);
        i();
    }

    private void i() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setCacheMode(2);
    }

    public X5WebView(Context context) {
        super(context);
        new a(this);
    }
}
