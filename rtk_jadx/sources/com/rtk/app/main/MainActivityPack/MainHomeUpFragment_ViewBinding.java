package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MainHomeUpFragment_ViewBinding implements Unbinder {
    private MainHomeUpFragment b;

    @UiThread
    public MainHomeUpFragment_ViewBinding(MainHomeUpFragment mainHomeUpFragment, View view) {
        this.b = mainHomeUpFragment;
        mainHomeUpFragment.mainHomeUpTab = (TabLayout) butterknife.c.a.c(view, R.id.main_home_up_tab, "field 'mainHomeUpTab'", TabLayout.class);
        mainHomeUpFragment.mainHomeUpViewPager = (ViewPager) butterknife.c.a.c(view, R.id.main_home_up_viewPager, "field 'mainHomeUpViewPager'", ViewPager.class);
        mainHomeUpFragment.headView = butterknife.c.a.b(view, R.id.main_home_up_fragment_head_layout, "field 'headView'");
    }

    @CallSuper
    public void a() {
        MainHomeUpFragment mainHomeUpFragment = this.b;
        if (mainHomeUpFragment != null) {
            this.b = null;
            mainHomeUpFragment.mainHomeUpTab = null;
            mainHomeUpFragment.mainHomeUpViewPager = null;
            mainHomeUpFragment.headView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
