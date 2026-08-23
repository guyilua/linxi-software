package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CoverActivity_ViewBinding implements Unbinder {
    private CoverActivity b;

    @UiThread
    public CoverActivity_ViewBinding(CoverActivity coverActivity, View view) {
        this.b = coverActivity;
        coverActivity.coverAppUninstall = (TextView) butterknife.c.a.c(view, R.id.cover_app_uninstall, "field 'coverAppUninstall'", TextView.class);
        coverActivity.coverAppApkPackage = (TextView) butterknife.c.a.c(view, R.id.cover_app_apkPackage, "field 'coverAppApkPackage'", TextView.class);
        coverActivity.coverAppSetTheme = (TextView) butterknife.c.a.c(view, R.id.cover_app_setTheme, "field 'coverAppSetTheme'", TextView.class);
        coverActivity.coverAppAboutUs = (TextView) butterknife.c.a.c(view, R.id.cover_app_aboutUs, "field 'coverAppAboutUs'", TextView.class);
        coverActivity.coverAppFeadBack = (TextView) butterknife.c.a.c(view, R.id.cover_app_feadBack, "field 'coverAppFeadBack'", TextView.class);
        coverActivity.coverAppQqChat = (TextView) butterknife.c.a.c(view, R.id.cover_app_qqChat, "field 'coverAppQqChat'", TextView.class);
        coverActivity.coverLayout = (LinearLayout) butterknife.c.a.c(view, R.id.cover_layout, "field 'coverLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        CoverActivity coverActivity = this.b;
        if (coverActivity != null) {
            this.b = null;
            coverActivity.coverAppUninstall = null;
            coverActivity.coverAppApkPackage = null;
            coverActivity.coverAppSetTheme = null;
            coverActivity.coverAppAboutUs = null;
            coverActivity.coverAppFeadBack = null;
            coverActivity.coverAppQqChat = null;
            coverActivity.coverLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
