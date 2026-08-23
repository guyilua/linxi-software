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
public class PrivacyOfUsageActivity_ViewBinding implements Unbinder {
    private PrivacyOfUsageActivity b;

    @UiThread
    public PrivacyOfUsageActivity_ViewBinding(PrivacyOfUsageActivity privacyOfUsageActivity, View view) {
        this.b = privacyOfUsageActivity;
        privacyOfUsageActivity.privacyOfUsageBack = (TextView) butterknife.c.a.c(view, R.id.privacy_of_usage_back, "field 'privacyOfUsageBack'", TextView.class);
        privacyOfUsageActivity.privacyOfUsageLayout = (LinearLayout) butterknife.c.a.c(view, R.id.privacy_of_usage_layout, "field 'privacyOfUsageLayout'", LinearLayout.class);
        privacyOfUsageActivity.helpContent = (WebView) butterknife.c.a.c(view, R.id.help_content, "field 'helpContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        PrivacyOfUsageActivity privacyOfUsageActivity = this.b;
        if (privacyOfUsageActivity != null) {
            this.b = null;
            privacyOfUsageActivity.privacyOfUsageBack = null;
            privacyOfUsageActivity.privacyOfUsageLayout = null;
            privacyOfUsageActivity.helpContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
