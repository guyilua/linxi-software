package com.rtk.app.main.coins;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RealPayH5Activity_ViewBinding implements Unbinder {
    private RealPayH5Activity b;

    @UiThread
    public RealPayH5Activity_ViewBinding(RealPayH5Activity realPayH5Activity, View view) {
        this.b = realPayH5Activity;
        realPayH5Activity.upProtocolBack = (TextView) butterknife.c.a.c(view, R.id.backTV, "field 'upProtocolBack'", TextView.class);
        realPayH5Activity.upProtocolContent = (WebView) butterknife.c.a.c(view, R.id.up_protocol_content, "field 'upProtocolContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        RealPayH5Activity realPayH5Activity = this.b;
        if (realPayH5Activity != null) {
            this.b = null;
            realPayH5Activity.upProtocolBack = null;
            realPayH5Activity.upProtocolContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
