package com.rtk.app.main;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownLoadTipsAdWebViewActivity_ViewBinding implements Unbinder {
    private DownLoadTipsAdWebViewActivity b;

    @UiThread
    public DownLoadTipsAdWebViewActivity_ViewBinding(DownLoadTipsAdWebViewActivity downLoadTipsAdWebViewActivity, View view) {
        this.b = downLoadTipsAdWebViewActivity;
        downLoadTipsAdWebViewActivity.adWebBack = (TextView) butterknife.c.a.c(view, R.id.down_load_tips_ad_web_view_back, "field 'adWebBack'", TextView.class);
        downLoadTipsAdWebViewActivity.adWebLayout = (LinearLayout) butterknife.c.a.c(view, R.id.down_load_tips_ad_web_view_layout, "field 'adWebLayout'", LinearLayout.class);
        downLoadTipsAdWebViewActivity.adWebContent = (WebView) butterknife.c.a.c(view, R.id.down_load_tips_ad_web_view_content, "field 'adWebContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        DownLoadTipsAdWebViewActivity downLoadTipsAdWebViewActivity = this.b;
        if (downLoadTipsAdWebViewActivity != null) {
            this.b = null;
            downLoadTipsAdWebViewActivity.adWebBack = null;
            downLoadTipsAdWebViewActivity.adWebLayout = null;
            downLoadTipsAdWebViewActivity.adWebContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
