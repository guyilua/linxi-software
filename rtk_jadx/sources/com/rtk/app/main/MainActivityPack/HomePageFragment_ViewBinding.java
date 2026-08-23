package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageFragment_ViewBinding implements Unbinder {
    private HomePageFragment b;

    @UiThread
    public HomePageFragment_ViewBinding(HomePageFragment homePageFragment, View view) {
        this.b = homePageFragment;
        homePageFragment.homePageFragmentTab = (TabLayout) butterknife.c.a.c(view, R.id.home_page_fragment_tab, "field 'homePageFragmentTab'", TabLayout.class);
        homePageFragment.homePageFragmentViewPager = (ViewPager) butterknife.c.a.c(view, R.id.home_page_fragment_view_pager, "field 'homePageFragmentViewPager'", ViewPager.class);
        homePageFragment.homePageFragmentPublishSomething = (ImageView) butterknife.c.a.c(view, R.id.home_page_fragment_publish_something, "field 'homePageFragmentPublishSomething'", ImageView.class);
    }

    @CallSuper
    public void a() {
        HomePageFragment homePageFragment = this.b;
        if (homePageFragment != null) {
            this.b = null;
            homePageFragment.homePageFragmentTab = null;
            homePageFragment.homePageFragmentViewPager = null;
            homePageFragment.homePageFragmentPublishSomething = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
