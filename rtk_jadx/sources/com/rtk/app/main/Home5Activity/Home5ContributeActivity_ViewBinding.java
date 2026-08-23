package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5ContributeActivity_ViewBinding implements Unbinder {
    private Home5ContributeActivity b;

    @UiThread
    public Home5ContributeActivity_ViewBinding(Home5ContributeActivity home5ContributeActivity, View view) {
        this.b = home5ContributeActivity;
        home5ContributeActivity.home5ContributeTopBack = (TextView) butterknife.c.a.c(view, R.id.home5_contribute_top_back, "field 'home5ContributeTopBack'", TextView.class);
        home5ContributeActivity.home5ContributeTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home5_contribute_top_layout, "field 'home5ContributeTopLayout'", LinearLayout.class);
        home5ContributeActivity.home5ContributeGoldNum = (TextView) butterknife.c.a.c(view, R.id.home5_contribute_goldNum, "field 'home5ContributeGoldNum'", TextView.class);
        home5ContributeActivity.home5ContributeTab = (TabLayout) butterknife.c.a.c(view, R.id.home5_contribute_tab, "field 'home5ContributeTab'", TabLayout.class);
        home5ContributeActivity.home5ContributeBar = (AppBarLayout) butterknife.c.a.c(view, R.id.home5_contribute_bar, "field 'home5ContributeBar'", AppBarLayout.class);
        home5ContributeActivity.home5ContributeViewpager = (BaseViewPager) butterknife.c.a.c(view, R.id.home5_contribute_viewpager, "field 'home5ContributeViewpager'", BaseViewPager.class);
    }

    @CallSuper
    public void a() {
        Home5ContributeActivity home5ContributeActivity = this.b;
        if (home5ContributeActivity != null) {
            this.b = null;
            home5ContributeActivity.home5ContributeTopBack = null;
            home5ContributeActivity.home5ContributeTopLayout = null;
            home5ContributeActivity.home5ContributeGoldNum = null;
            home5ContributeActivity.home5ContributeTab = null;
            home5ContributeActivity.home5ContributeBar = null;
            home5ContributeActivity.home5ContributeViewpager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
