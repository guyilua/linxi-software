package com.rtk.app.main;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdWebViewActivity_ViewBinding implements Unbinder {
    private AdWebViewActivity b;

    @UiThread
    public AdWebViewActivity_ViewBinding(AdWebViewActivity adWebViewActivity, View view) {
        this.b = adWebViewActivity;
        adWebViewActivity.adWebBack = (TextView) butterknife.c.a.c(view, R.id.ad_web_back, "field 'adWebBack'", TextView.class);
        adWebViewActivity.adWebLayout = (LinearLayout) butterknife.c.a.c(view, R.id.ad_web_layout, "field 'adWebLayout'", LinearLayout.class);
        adWebViewActivity.adWebContent = (WebView) butterknife.c.a.c(view, R.id.ad_web_content, "field 'adWebContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        AdWebViewActivity adWebViewActivity = this.b;
        if (adWebViewActivity != null) {
            this.b = null;
            adWebViewActivity.adWebBack = null;
            adWebViewActivity.adWebLayout = null;
            adWebViewActivity.adWebContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
