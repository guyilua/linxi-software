package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AboutUsAndHelpActivity_ViewBinding implements Unbinder {
    private AboutUsAndHelpActivity b;

    @UiThread
    public AboutUsAndHelpActivity_ViewBinding(AboutUsAndHelpActivity aboutUsAndHelpActivity, View view) {
        this.b = aboutUsAndHelpActivity;
        aboutUsAndHelpActivity.aboutUsAndHelpBack = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_back, "field 'aboutUsAndHelpBack'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpLayout = (LinearLayout) butterknife.c.a.c(view, R.id.about_us_and_help_layout, "field 'aboutUsAndHelpLayout'", LinearLayout.class);
        aboutUsAndHelpActivity.aboutUsAndHelpWebUrl = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_webUrl, "field 'aboutUsAndHelpWebUrl'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpQQ = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_QQ, "field 'aboutUsAndHelpQQ'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpHeadLv = (LinearLayout) butterknife.c.a.c(view, R.id.about_us_and_help_headLv, "field 'aboutUsAndHelpHeadLv'", LinearLayout.class);
        aboutUsAndHelpActivity.aboutUsAndHelpWebUrlLayout = (LinearLayout) butterknife.c.a.c(view, R.id.about_us_and_help_webUrl_layout, "field 'aboutUsAndHelpWebUrlLayout'", LinearLayout.class);
        aboutUsAndHelpActivity.aboutUsAndHelpVersion = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_version, "field 'aboutUsAndHelpVersion'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpQqLstView = (CustomListView) butterknife.c.a.c(view, R.id.about_us_and_help_qqListView, "field 'aboutUsAndHelpQqLstView'", CustomListView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpCopyright = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_copyright, "field 'aboutUsAndHelpCopyright'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpBeian = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_beian, "field 'aboutUsAndHelpBeian'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpQQLayout = (LinearLayout) butterknife.c.a.c(view, R.id.about_us_and_help_QQ_layout, "field 'aboutUsAndHelpQQLayout'", LinearLayout.class);
        aboutUsAndHelpActivity.aboutUsAndHelpWechat = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_wechat, "field 'aboutUsAndHelpWechat'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpWechatLayout = (LinearLayout) butterknife.c.a.c(view, R.id.about_us_and_help_wechat_layout, "field 'aboutUsAndHelpWechatLayout'", LinearLayout.class);
        aboutUsAndHelpActivity.aboutUsAndHelpEmail = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_Email, "field 'aboutUsAndHelpEmail'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpEmailLayout = (LinearLayout) butterknife.c.a.c(view, R.id.about_us_and_help_Email_layout, "field 'aboutUsAndHelpEmailLayout'", LinearLayout.class);
        aboutUsAndHelpActivity.aboutUsAndHelpQDQQ = (TextView) butterknife.c.a.c(view, R.id.about_us_and_help_QDQQ, "field 'aboutUsAndHelpQDQQ'", TextView.class);
        aboutUsAndHelpActivity.aboutUsAndHelpQDQQLayout = (LinearLayout) butterknife.c.a.c(view, R.id.about_us_and_help_QDQQ_layout, "field 'aboutUsAndHelpQDQQLayout'", LinearLayout.class);
        aboutUsAndHelpActivity.aboutUsAndHelpLogo = butterknife.c.a.b(view, R.id.about_us_and_help_logo, "field 'aboutUsAndHelpLogo'");
    }

    @CallSuper
    public void a() {
        AboutUsAndHelpActivity aboutUsAndHelpActivity = this.b;
        if (aboutUsAndHelpActivity != null) {
            this.b = null;
            aboutUsAndHelpActivity.aboutUsAndHelpBack = null;
            aboutUsAndHelpActivity.aboutUsAndHelpLayout = null;
            aboutUsAndHelpActivity.aboutUsAndHelpWebUrl = null;
            aboutUsAndHelpActivity.aboutUsAndHelpQQ = null;
            aboutUsAndHelpActivity.aboutUsAndHelpHeadLv = null;
            aboutUsAndHelpActivity.aboutUsAndHelpWebUrlLayout = null;
            aboutUsAndHelpActivity.aboutUsAndHelpVersion = null;
            aboutUsAndHelpActivity.aboutUsAndHelpQqLstView = null;
            aboutUsAndHelpActivity.aboutUsAndHelpCopyright = null;
            aboutUsAndHelpActivity.aboutUsAndHelpBeian = null;
            aboutUsAndHelpActivity.aboutUsAndHelpQQLayout = null;
            aboutUsAndHelpActivity.aboutUsAndHelpWechat = null;
            aboutUsAndHelpActivity.aboutUsAndHelpWechatLayout = null;
            aboutUsAndHelpActivity.aboutUsAndHelpEmail = null;
            aboutUsAndHelpActivity.aboutUsAndHelpEmailLayout = null;
            aboutUsAndHelpActivity.aboutUsAndHelpQDQQ = null;
            aboutUsAndHelpActivity.aboutUsAndHelpQDQQLayout = null;
            aboutUsAndHelpActivity.aboutUsAndHelpLogo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
