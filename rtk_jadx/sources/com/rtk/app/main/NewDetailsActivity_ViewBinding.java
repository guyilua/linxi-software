package com.rtk.app.main;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class NewDetailsActivity_ViewBinding implements Unbinder {
    private NewDetailsActivity b;

    @UiThread
    public NewDetailsActivity_ViewBinding(NewDetailsActivity newDetailsActivity, View view) {
        this.b = newDetailsActivity;
        newDetailsActivity.newsDetailsLv = (LinearLayout) butterknife.c.a.c(view, R.id.news_details_lv, "field 'newsDetailsLv'", LinearLayout.class);
        newDetailsActivity.newsDetailsTitles = (TextView) butterknife.c.a.c(view, R.id.news_details_titles, "field 'newsDetailsTitles'", TextView.class);
        newDetailsActivity.newsDetailsTime = (TextView) butterknife.c.a.c(view, R.id.news_details_time, "field 'newsDetailsTime'", TextView.class);
        newDetailsActivity.newsDetailasType = (TextView) butterknife.c.a.c(view, R.id.news_detailas_type, "field 'newsDetailasType'", TextView.class);
        newDetailsActivity.newsDetailsAppIcon = (ImageView) butterknife.c.a.c(view, R.id.news_details_appIcon, "field 'newsDetailsAppIcon'", ImageView.class);
        newDetailsActivity.newsDetalisAppName = (TextView) butterknife.c.a.c(view, R.id.news_detalis_appName, "field 'newsDetalisAppName'", TextView.class);
        newDetailsActivity.newsDetalisAppVersion = (TextView) butterknife.c.a.c(view, R.id.news_detalis_appVersion, "field 'newsDetalisAppVersion'", TextView.class);
        newDetailsActivity.newsDetalisAppType = (TextView) butterknife.c.a.c(view, R.id.news_detalis_appType, "field 'newsDetalisAppType'", TextView.class);
        newDetailsActivity.newsDetalisAppSize = (TextView) butterknife.c.a.c(view, R.id.news_detalis_appSize, "field 'newsDetalisAppSize'", TextView.class);
        newDetailsActivity.newsDetailsAppLv = (LinearLayout) butterknife.c.a.c(view, R.id.news_details_appLv, "field 'newsDetailsAppLv'", LinearLayout.class);
        newDetailsActivity.newsDetailsContent = (WebView) butterknife.c.a.c(view, R.id.news_details_content, "field 'newsDetailsContent'", WebView.class);
        newDetailsActivity.newsDetailsAppIcon2 = (ImageView) butterknife.c.a.c(view, R.id.news_details_appIcon2, "field 'newsDetailsAppIcon2'", ImageView.class);
        newDetailsActivity.newsDetailsName2 = (TextView) butterknife.c.a.c(view, R.id.news_details_name2, "field 'newsDetailsName2'", TextView.class);
        newDetailsActivity.newsDetailsAppLv2 = (LinearLayout) butterknife.c.a.c(view, R.id.news_details_appLv2, "field 'newsDetailsAppLv2'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        NewDetailsActivity newDetailsActivity = this.b;
        if (newDetailsActivity != null) {
            this.b = null;
            newDetailsActivity.newsDetailsLv = null;
            newDetailsActivity.newsDetailsTitles = null;
            newDetailsActivity.newsDetailsTime = null;
            newDetailsActivity.newsDetailasType = null;
            newDetailsActivity.newsDetailsAppIcon = null;
            newDetailsActivity.newsDetalisAppName = null;
            newDetailsActivity.newsDetalisAppVersion = null;
            newDetailsActivity.newsDetalisAppType = null;
            newDetailsActivity.newsDetalisAppSize = null;
            newDetailsActivity.newsDetailsAppLv = null;
            newDetailsActivity.newsDetailsContent = null;
            newDetailsActivity.newsDetailsAppIcon2 = null;
            newDetailsActivity.newsDetailsName2 = null;
            newDetailsActivity.newsDetailsAppLv2 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
