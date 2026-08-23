package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeRankFragment_ViewBinding implements Unbinder {
    private HomeRankFragment b;

    @UiThread
    public HomeRankFragment_ViewBinding(HomeRankFragment homeRankFragment, View view) {
        this.b = homeRankFragment;
        homeRankFragment.home2Tab = (TabLayout) butterknife.c.a.c(view, R.id.home2_tab, "field 'home2Tab'", TabLayout.class);
        homeRankFragment.home2ViewPager = (ViewPager) butterknife.c.a.c(view, R.id.home2_viewPager, "field 'home2ViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        HomeRankFragment homeRankFragment = this.b;
        if (homeRankFragment != null) {
            this.b = null;
            homeRankFragment.home2Tab = null;
            homeRankFragment.home2ViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
