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
public class RegisterProtocolActivity_ViewBinding implements Unbinder {
    private RegisterProtocolActivity b;

    @UiThread
    public RegisterProtocolActivity_ViewBinding(RegisterProtocolActivity registerProtocolActivity, View view) {
        this.b = registerProtocolActivity;
        registerProtocolActivity.registerProtocolback = (TextView) butterknife.c.a.c(view, R.id.register_protocolback, "field 'registerProtocolback'", TextView.class);
        registerProtocolActivity.registerProtocollayout = (LinearLayout) butterknife.c.a.c(view, R.id.register_protocollayout, "field 'registerProtocollayout'", LinearLayout.class);
        registerProtocolActivity.helpContent = (WebView) butterknife.c.a.c(view, R.id.help_content, "field 'helpContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        RegisterProtocolActivity registerProtocolActivity = this.b;
        if (registerProtocolActivity != null) {
            this.b = null;
            registerProtocolActivity.registerProtocolback = null;
            registerProtocolActivity.registerProtocollayout = null;
            registerProtocolActivity.helpContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
