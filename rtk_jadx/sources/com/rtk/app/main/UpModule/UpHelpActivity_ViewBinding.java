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
public class UpHelpActivity_ViewBinding implements Unbinder {
    private UpHelpActivity b;

    @UiThread
    public UpHelpActivity_ViewBinding(UpHelpActivity upHelpActivity, View view) {
        this.b = upHelpActivity;
        upHelpActivity.upHelpBack = (TextView) butterknife.c.a.c(view, R.id.up_help_back, "field 'upHelpBack'", TextView.class);
        upHelpActivity.upHelpLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_help_layout, "field 'upHelpLayout'", LinearLayout.class);
        upHelpActivity.upHelpContent = (WebView) butterknife.c.a.c(view, R.id.up_help_content, "field 'upHelpContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        UpHelpActivity upHelpActivity = this.b;
        if (upHelpActivity != null) {
            this.b = null;
            upHelpActivity.upHelpBack = null;
            upHelpActivity.upHelpLayout = null;
            upHelpActivity.upHelpContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
