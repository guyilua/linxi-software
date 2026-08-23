package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameFragment_ViewBinding implements Unbinder {
    private HomeGameFragment b;

    @UiThread
    public HomeGameFragment_ViewBinding(HomeGameFragment homeGameFragment, View view) {
        this.b = homeGameFragment;
        homeGameFragment.homeGameTab = (TabLayout) butterknife.c.a.c(view, R.id.home_game_tab, "field 'homeGameTab'", TabLayout.class);
        homeGameFragment.homeGameViewPager = (ViewPager) butterknife.c.a.c(view, R.id.home_game_viewPager, "field 'homeGameViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        HomeGameFragment homeGameFragment = this.b;
        if (homeGameFragment != null) {
            this.b = null;
            homeGameFragment.homeGameTab = null;
            homeGameFragment.homeGameViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
