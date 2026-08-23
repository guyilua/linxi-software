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
public class HomeUpRewardActivity_ViewBinding implements Unbinder {
    private HomeUpRewardActivity b;

    @UiThread
    public HomeUpRewardActivity_ViewBinding(HomeUpRewardActivity homeUpRewardActivity, View view) {
        this.b = homeUpRewardActivity;
        homeUpRewardActivity.homeUpRewardTopBack = (TextView) butterknife.c.a.c(view, R.id.home_up_reward_topBack, "field 'homeUpRewardTopBack'", TextView.class);
        homeUpRewardActivity.homeUpRewardTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.home_up_reward_top_download, "field 'homeUpRewardTopDownload'", MarkedImageView.class);
        homeUpRewardActivity.homeUpRewardTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_reward_topLayout, "field 'homeUpRewardTopLayout'", LinearLayout.class);
        homeUpRewardActivity.homeUpRewardTablayout = (TabLayout) butterknife.c.a.c(view, R.id.home_up_reward_tablayout, "field 'homeUpRewardTablayout'", TabLayout.class);
        homeUpRewardActivity.homeUpRewardViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.home_up_reward_viewPager, "field 'homeUpRewardViewPager'", BaseViewPager.class);
        homeUpRewardActivity.homeUpRewardTopSearchTv = (TextView) butterknife.c.a.c(view, R.id.home_up_reward_top_search_tv, "field 'homeUpRewardTopSearchTv'", TextView.class);
    }

    @CallSuper
    public void a() {
        HomeUpRewardActivity homeUpRewardActivity = this.b;
        if (homeUpRewardActivity != null) {
            this.b = null;
            homeUpRewardActivity.homeUpRewardTopBack = null;
            homeUpRewardActivity.homeUpRewardTopDownload = null;
            homeUpRewardActivity.homeUpRewardTopLayout = null;
            homeUpRewardActivity.homeUpRewardTablayout = null;
            homeUpRewardActivity.homeUpRewardViewPager = null;
            homeUpRewardActivity.homeUpRewardTopSearchTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
