package com.rtk.app.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OpenServiceActivity_ViewBinding implements Unbinder {
    private OpenServiceActivity b;

    @UiThread
    public OpenServiceActivity_ViewBinding(OpenServiceActivity openServiceActivity, View view) {
        this.b = openServiceActivity;
        openServiceActivity.openServiceTitle = (TextView) butterknife.c.a.c(view, R.id.open_service_title, "field 'openServiceTitle'", TextView.class);
        openServiceActivity.openServiceDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.open_service_download, "field 'openServiceDownload'", MarkedImageView.class);
        openServiceActivity.openServiceLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.open_service_layout, "field 'openServiceLayout'", RelativeLayout.class);
        openServiceActivity.openServiceTablayout = (TabLayout) butterknife.c.a.c(view, R.id.open_service_tablayout, "field 'openServiceTablayout'", TabLayout.class);
        openServiceActivity.openServiceViewPager = (ViewPager) butterknife.c.a.c(view, R.id.open_service_viewPager, "field 'openServiceViewPager'", ViewPager.class);
        openServiceActivity.openServiceBack = (ImageView) butterknife.c.a.c(view, R.id.open_service_back, "field 'openServiceBack'", ImageView.class);
    }

    @CallSuper
    public void a() {
        OpenServiceActivity openServiceActivity = this.b;
        if (openServiceActivity != null) {
            this.b = null;
            openServiceActivity.openServiceTitle = null;
            openServiceActivity.openServiceDownload = null;
            openServiceActivity.openServiceLayout = null;
            openServiceActivity.openServiceTablayout = null;
            openServiceActivity.openServiceViewPager = null;
            openServiceActivity.openServiceBack = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
