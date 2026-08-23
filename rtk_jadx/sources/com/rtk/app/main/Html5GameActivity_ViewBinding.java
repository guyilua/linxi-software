package com.rtk.app.main;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Html5GameActivity_ViewBinding implements Unbinder {
    private Html5GameActivity b;

    @UiThread
    public Html5GameActivity_ViewBinding(Html5GameActivity html5GameActivity, View view) {
        this.b = html5GameActivity;
        html5GameActivity.html5GameWebview = (WebView) butterknife.c.a.c(view, R.id.html5_game_webview, "field 'html5GameWebview'", WebView.class);
    }

    @CallSuper
    public void a() {
        Html5GameActivity html5GameActivity = this.b;
        if (html5GameActivity != null) {
            this.b = null;
            html5GameActivity.html5GameWebview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
