package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpExampleListActivity_ViewBinding implements Unbinder {
    private HomeUpExampleListActivity b;

    @UiThread
    public HomeUpExampleListActivity_ViewBinding(HomeUpExampleListActivity homeUpExampleListActivity, View view) {
        this.b = homeUpExampleListActivity;
        homeUpExampleListActivity.homeUpExampleListTopBack = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_topBack, "field 'homeUpExampleListTopBack'", TextView.class);
        homeUpExampleListActivity.homeUpExampleListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_example_list_topLayout, "field 'homeUpExampleListTopLayout'", LinearLayout.class);
        homeUpExampleListActivity.homeUpExampleListTablayout = (TabLayout) butterknife.c.a.c(view, R.id.home_up_example_list_tablayout, "field 'homeUpExampleListTablayout'", TabLayout.class);
        homeUpExampleListActivity.homeUpExampleListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.home_up_example_list_viewPager, "field 'homeUpExampleListViewPager'", BaseViewPager.class);
        homeUpExampleListActivity.homeUpExampleListTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.home_up_example_list_top_download, "field 'homeUpExampleListTopDownload'", MarkedImageView.class);
        homeUpExampleListActivity.homeUpExampleListTopSearchTv = (TextView) butterknife.c.a.c(view, R.id.home_up_example_list_top_search_tv, "field 'homeUpExampleListTopSearchTv'", TextView.class);
    }

    @CallSuper
    public void a() {
        HomeUpExampleListActivity homeUpExampleListActivity = this.b;
        if (homeUpExampleListActivity != null) {
            this.b = null;
            homeUpExampleListActivity.homeUpExampleListTopBack = null;
            homeUpExampleListActivity.homeUpExampleListTopLayout = null;
            homeUpExampleListActivity.homeUpExampleListTablayout = null;
            homeUpExampleListActivity.homeUpExampleListViewPager = null;
            homeUpExampleListActivity.homeUpExampleListTopDownload = null;
            homeUpExampleListActivity.homeUpExampleListTopSearchTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
