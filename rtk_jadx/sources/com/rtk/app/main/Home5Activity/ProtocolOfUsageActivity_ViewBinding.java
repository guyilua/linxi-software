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
public class ProtocolOfUsageActivity_ViewBinding implements Unbinder {
    private ProtocolOfUsageActivity b;

    @UiThread
    public ProtocolOfUsageActivity_ViewBinding(ProtocolOfUsageActivity protocolOfUsageActivity, View view) {
        this.b = protocolOfUsageActivity;
        protocolOfUsageActivity.protocolOfUsageBack = (TextView) butterknife.c.a.c(view, R.id.protocol_of_usage_back, "field 'protocolOfUsageBack'", TextView.class);
        protocolOfUsageActivity.protocolOfUsageLayout = (LinearLayout) butterknife.c.a.c(view, R.id.protocol_of_usage_layout, "field 'protocolOfUsageLayout'", LinearLayout.class);
        protocolOfUsageActivity.helpContent = (WebView) butterknife.c.a.c(view, R.id.help_content, "field 'helpContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        ProtocolOfUsageActivity protocolOfUsageActivity = this.b;
        if (protocolOfUsageActivity != null) {
            this.b = null;
            protocolOfUsageActivity.protocolOfUsageBack = null;
            protocolOfUsageActivity.protocolOfUsageLayout = null;
            protocolOfUsageActivity.helpContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
