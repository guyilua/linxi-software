package com.rtk.app.main.UpModule;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpProtocolActivity_ViewBinding implements Unbinder {
    private UpProtocolActivity b;

    @UiThread
    public UpProtocolActivity_ViewBinding(UpProtocolActivity upProtocolActivity, View view) {
        this.b = upProtocolActivity;
        upProtocolActivity.upProtocolBack = (TextView) butterknife.c.a.c(view, R.id.up_protocol_back, "field 'upProtocolBack'", TextView.class);
        upProtocolActivity.upProtocolLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_protocol_layout, "field 'upProtocolLayout'", LinearLayout.class);
        upProtocolActivity.upProtocolContent = (WebView) butterknife.c.a.c(view, R.id.up_protocol_content, "field 'upProtocolContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        UpProtocolActivity upProtocolActivity = this.b;
        if (upProtocolActivity != null) {
            this.b = null;
            upProtocolActivity.upProtocolBack = null;
            upProtocolActivity.upProtocolLayout = null;
            upProtocolActivity.upProtocolContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
