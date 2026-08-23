package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoldRuleActivity_ViewBinding implements Unbinder {
    private GoldRuleActivity b;

    @UiThread
    public GoldRuleActivity_ViewBinding(GoldRuleActivity goldRuleActivity, View view) {
        this.b = goldRuleActivity;
        goldRuleActivity.goldRuleBack = (TextView) butterknife.c.a.c(view, R.id.gold_rule_back, "field 'goldRuleBack'", TextView.class);
        goldRuleActivity.goldRuleLayout = (LinearLayout) butterknife.c.a.c(view, R.id.gold_rule_layout, "field 'goldRuleLayout'", LinearLayout.class);
        goldRuleActivity.goldRuleWebView = (WebView) butterknife.c.a.c(view, R.id.gold_rule_webView, "field 'goldRuleWebView'", WebView.class);
    }

    @CallSuper
    public void a() {
        GoldRuleActivity goldRuleActivity = this.b;
        if (goldRuleActivity != null) {
            this.b = null;
            goldRuleActivity.goldRuleBack = null;
            goldRuleActivity.goldRuleLayout = null;
            goldRuleActivity.goldRuleWebView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
