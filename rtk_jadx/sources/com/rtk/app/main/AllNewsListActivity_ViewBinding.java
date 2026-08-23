package com.rtk.app.main;

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
public class AllNewsListActivity_ViewBinding implements Unbinder {
    private AllNewsListActivity b;

    @UiThread
    public AllNewsListActivity_ViewBinding(AllNewsListActivity allNewsListActivity, View view) {
        this.b = allNewsListActivity;
        allNewsListActivity.allNewsTopBack = (TextView) butterknife.c.a.c(view, R.id.all_news_top_back, "field 'allNewsTopBack'", TextView.class);
        allNewsListActivity.allNewsTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.all_news_top_layout, "field 'allNewsTopLayout'", LinearLayout.class);
        allNewsListActivity.allNewsTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.all_news_tabLayout, "field 'allNewsTabLayout'", TabLayout.class);
        allNewsListActivity.allNewsViewpager = (ViewPager) butterknife.c.a.c(view, R.id.all_news_viewpager, "field 'allNewsViewpager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        AllNewsListActivity allNewsListActivity = this.b;
        if (allNewsListActivity != null) {
            this.b = null;
            allNewsListActivity.allNewsTopBack = null;
            allNewsListActivity.allNewsTopLayout = null;
            allNewsListActivity.allNewsTabLayout = null;
            allNewsListActivity.allNewsViewpager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
