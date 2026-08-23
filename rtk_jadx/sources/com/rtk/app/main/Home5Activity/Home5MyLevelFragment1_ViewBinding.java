package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.webkit.WebView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyLevelFragment1_ViewBinding implements Unbinder {
    private Home5MyLevelFragment1 b;

    @UiThread
    public Home5MyLevelFragment1_ViewBinding(Home5MyLevelFragment1 home5MyLevelFragment1, View view) {
        this.b = home5MyLevelFragment1;
        home5MyLevelFragment1.swipeAndWebViewWebView = (WebView) butterknife.c.a.c(view, R.id.swipe_and_web_view_webView, "field 'swipeAndWebViewWebView'", WebView.class);
    }

    @CallSuper
    public void a() {
        Home5MyLevelFragment1 home5MyLevelFragment1 = this.b;
        if (home5MyLevelFragment1 != null) {
            this.b = null;
            home5MyLevelFragment1.swipeAndWebViewWebView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
