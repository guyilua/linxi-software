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
public class MyCollectActivity_ViewBinding implements Unbinder {
    private MyCollectActivity b;

    @UiThread
    public MyCollectActivity_ViewBinding(MyCollectActivity myCollectActivity, View view) {
        this.b = myCollectActivity;
        myCollectActivity.muCollectBack = (TextView) butterknife.c.a.c(view, R.id.mu_collect_back, "field 'muCollectBack'", TextView.class);
        myCollectActivity.muCollectTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.mu_collect_top_layout, "field 'muCollectTopLayout'", LinearLayout.class);
        myCollectActivity.myCollectViewpager = (ViewPager) butterknife.c.a.c(view, R.id.my_collect_viewpager, "field 'myCollectViewpager'", ViewPager.class);
        myCollectActivity.myCollectTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.my_collect_tabLayout, "field 'myCollectTabLayout'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        MyCollectActivity myCollectActivity = this.b;
        if (myCollectActivity != null) {
            this.b = null;
            myCollectActivity.muCollectBack = null;
            myCollectActivity.muCollectTopLayout = null;
            myCollectActivity.myCollectViewpager = null;
            myCollectActivity.myCollectTabLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
