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
public class FamilyProtocolActivity_ViewBinding implements Unbinder {
    private FamilyProtocolActivity b;

    @UiThread
    public FamilyProtocolActivity_ViewBinding(FamilyProtocolActivity familyProtocolActivity, View view) {
        this.b = familyProtocolActivity;
        familyProtocolActivity.upProtocolBack = (TextView) butterknife.c.a.c(view, R.id.up_protocol_back, "field 'upProtocolBack'", TextView.class);
        familyProtocolActivity.upProtocolLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_protocol_layout, "field 'upProtocolLayout'", LinearLayout.class);
        familyProtocolActivity.upProtocolContent = (WebView) butterknife.c.a.c(view, R.id.up_protocol_content, "field 'upProtocolContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        FamilyProtocolActivity familyProtocolActivity = this.b;
        if (familyProtocolActivity != null) {
            this.b = null;
            familyProtocolActivity.upProtocolBack = null;
            familyProtocolActivity.upProtocolLayout = null;
            familyProtocolActivity.upProtocolContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
