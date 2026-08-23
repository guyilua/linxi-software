package com.rtk.app.custom.TestPost;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.c.a;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TestPostHtmlPageActivity_ViewBinding implements Unbinder {
    private TestPostHtmlPageActivity b;

    @UiThread
    public TestPostHtmlPageActivity_ViewBinding(TestPostHtmlPageActivity testPostHtmlPageActivity, View view) {
        this.b = testPostHtmlPageActivity;
        testPostHtmlPageActivity.testPostHtmlWebView = (WebView) a.c(view, R.id.test_post_html_webView, "field 'testPostHtmlWebView'", WebView.class);
        testPostHtmlPageActivity.testPostHtmlPageBack = (TextView) a.c(view, R.id.test_post_html_page_back, "field 'testPostHtmlPageBack'", TextView.class);
        testPostHtmlPageActivity.testPostHtmlPageLv = (LinearLayout) a.c(view, R.id.test_post_html_page_lv, "field 'testPostHtmlPageLv'", LinearLayout.class);
        testPostHtmlPageActivity.testPostHtmlProgressBar = (ProgressBar) a.c(view, R.id.test_post_html_progressBar, "field 'testPostHtmlProgressBar'", ProgressBar.class);
        testPostHtmlPageActivity.testPostHtmlBack = (ImageView) a.c(view, R.id.test_post_html_back, "field 'testPostHtmlBack'", ImageView.class);
        testPostHtmlPageActivity.testPostHtmlGo = (ImageView) a.c(view, R.id.test_post_html_go, "field 'testPostHtmlGo'", ImageView.class);
        testPostHtmlPageActivity.testPostHtmlHome = (ImageView) a.c(view, R.id.test_post_html_home, "field 'testPostHtmlHome'", ImageView.class);
        testPostHtmlPageActivity.testPostHtmlUseBrowser = (TextView) a.c(view, R.id.test_post_html_useBrowser, "field 'testPostHtmlUseBrowser'", TextView.class);
    }

    @CallSuper
    public void a() {
        TestPostHtmlPageActivity testPostHtmlPageActivity = this.b;
        if (testPostHtmlPageActivity != null) {
            this.b = null;
            testPostHtmlPageActivity.testPostHtmlWebView = null;
            testPostHtmlPageActivity.testPostHtmlPageBack = null;
            testPostHtmlPageActivity.testPostHtmlPageLv = null;
            testPostHtmlPageActivity.testPostHtmlProgressBar = null;
            testPostHtmlPageActivity.testPostHtmlBack = null;
            testPostHtmlPageActivity.testPostHtmlGo = null;
            testPostHtmlPageActivity.testPostHtmlHome = null;
            testPostHtmlPageActivity.testPostHtmlUseBrowser = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
