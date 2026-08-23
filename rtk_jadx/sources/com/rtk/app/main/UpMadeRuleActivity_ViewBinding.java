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
public class UpMadeRuleActivity_ViewBinding implements Unbinder {
    private UpMadeRuleActivity b;

    @UiThread
    public UpMadeRuleActivity_ViewBinding(UpMadeRuleActivity upMadeRuleActivity, View view) {
        this.b = upMadeRuleActivity;
        upMadeRuleActivity.upMadeRuleBack = (TextView) butterknife.c.a.c(view, R.id.up_made_rule_back, "field 'upMadeRuleBack'", TextView.class);
        upMadeRuleActivity.upMadeRuleLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_made_rule_layout, "field 'upMadeRuleLayout'", LinearLayout.class);
        upMadeRuleActivity.upMadeRuleContent = (WebView) butterknife.c.a.c(view, R.id.up_made_rule_content, "field 'upMadeRuleContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        UpMadeRuleActivity upMadeRuleActivity = this.b;
        if (upMadeRuleActivity != null) {
            this.b = null;
            upMadeRuleActivity.upMadeRuleBack = null;
            upMadeRuleActivity.upMadeRuleLayout = null;
            upMadeRuleActivity.upMadeRuleContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
