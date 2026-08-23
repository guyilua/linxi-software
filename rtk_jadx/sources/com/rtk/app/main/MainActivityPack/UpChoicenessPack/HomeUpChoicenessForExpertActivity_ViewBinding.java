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
public class HomeUpChoicenessForExpertActivity_ViewBinding implements Unbinder {
    private HomeUpChoicenessForExpertActivity b;

    @UiThread
    public HomeUpChoicenessForExpertActivity_ViewBinding(HomeUpChoicenessForExpertActivity homeUpChoicenessForExpertActivity, View view) {
        this.b = homeUpChoicenessForExpertActivity;
        homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertTopBack = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_for_expert_topBack, "field 'homeUpChoicenessForExpertTopBack'", TextView.class);
        homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_choiceness_for_expert_topLayout, "field 'homeUpChoicenessForExpertTopLayout'", LinearLayout.class);
        homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.home_up_choiceness_for_expert_viewPager, "field 'homeUpChoicenessForExpertViewPager'", BaseViewPager.class);
        homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertTablayout = (TabLayout) butterknife.c.a.c(view, R.id.home_up_choiceness_for_expert_tablayout, "field 'homeUpChoicenessForExpertTablayout'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        HomeUpChoicenessForExpertActivity homeUpChoicenessForExpertActivity = this.b;
        if (homeUpChoicenessForExpertActivity != null) {
            this.b = null;
            homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertTopBack = null;
            homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertTopLayout = null;
            homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertViewPager = null;
            homeUpChoicenessForExpertActivity.homeUpChoicenessForExpertTablayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
