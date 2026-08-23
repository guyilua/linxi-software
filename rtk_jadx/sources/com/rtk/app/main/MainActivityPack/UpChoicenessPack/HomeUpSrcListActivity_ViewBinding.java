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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpSrcListActivity_ViewBinding implements Unbinder {
    private HomeUpSrcListActivity b;

    @UiThread
    public HomeUpSrcListActivity_ViewBinding(HomeUpSrcListActivity homeUpSrcListActivity, View view) {
        this.b = homeUpSrcListActivity;
        homeUpSrcListActivity.homeUpSrcListTopBack = (TextView) butterknife.c.a.c(view, R.id.home_up_src_list_topBack, "field 'homeUpSrcListTopBack'", TextView.class);
        homeUpSrcListActivity.homeUpSrcListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_src_list_topLayout, "field 'homeUpSrcListTopLayout'", LinearLayout.class);
        homeUpSrcListActivity.homeUpSrcListTablayout = (TabLayout) butterknife.c.a.c(view, R.id.home_up_src_list_tablayout, "field 'homeUpSrcListTablayout'", TabLayout.class);
        homeUpSrcListActivity.homeUpSrcListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.home_up_src_list_viewPager, "field 'homeUpSrcListViewPager'", BaseViewPager.class);
    }

    @CallSuper
    public void a() {
        HomeUpSrcListActivity homeUpSrcListActivity = this.b;
        if (homeUpSrcListActivity != null) {
            this.b = null;
            homeUpSrcListActivity.homeUpSrcListTopBack = null;
            homeUpSrcListActivity.homeUpSrcListTopLayout = null;
            homeUpSrcListActivity.homeUpSrcListTablayout = null;
            homeUpSrcListActivity.homeUpSrcListViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
