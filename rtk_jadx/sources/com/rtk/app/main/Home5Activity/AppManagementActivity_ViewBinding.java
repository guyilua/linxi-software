package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppManagementActivity_ViewBinding implements Unbinder {
    private AppManagementActivity b;

    @UiThread
    public AppManagementActivity_ViewBinding(AppManagementActivity appManagementActivity, View view) {
        this.b = appManagementActivity;
        appManagementActivity.appManagementTopBack = (TextView) butterknife.c.a.c(view, R.id.app_management_top_back, "field 'appManagementTopBack'", TextView.class);
        appManagementActivity.appManagementTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.app_management_top_layout, "field 'appManagementTopLayout'", LinearLayout.class);
        appManagementActivity.appManagementViewpager = (ViewPager) butterknife.c.a.c(view, R.id.app_management_viewpager, "field 'appManagementViewpager'", ViewPager.class);
        appManagementActivity.appManagementTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.app_management_tag_layout, "field 'appManagementTagLayout'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        AppManagementActivity appManagementActivity = this.b;
        if (appManagementActivity != null) {
            this.b = null;
            appManagementActivity.appManagementTopBack = null;
            appManagementActivity.appManagementTopLayout = null;
            appManagementActivity.appManagementViewpager = null;
            appManagementActivity.appManagementTagLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
