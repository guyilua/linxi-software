package com.rtk.app.main.family;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuthRealNameProtocolActivity_ViewBinding implements Unbinder {
    private AuthRealNameProtocolActivity b;

    @UiThread
    public AuthRealNameProtocolActivity_ViewBinding(AuthRealNameProtocolActivity authRealNameProtocolActivity, View view) {
        this.b = authRealNameProtocolActivity;
        authRealNameProtocolActivity.upProtocolBack = (TextView) butterknife.c.a.c(view, R.id.up_protocol_back, "field 'upProtocolBack'", TextView.class);
        authRealNameProtocolActivity.upProtocolLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_protocol_layout, "field 'upProtocolLayout'", LinearLayout.class);
        authRealNameProtocolActivity.upProtocolContent = (WebView) butterknife.c.a.c(view, R.id.up_protocol_content, "field 'upProtocolContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        AuthRealNameProtocolActivity authRealNameProtocolActivity = this.b;
        if (authRealNameProtocolActivity != null) {
            this.b = null;
            authRealNameProtocolActivity.upProtocolBack = null;
            authRealNameProtocolActivity.upProtocolLayout = null;
            authRealNameProtocolActivity.upProtocolContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
