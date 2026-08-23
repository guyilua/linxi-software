package com.rtk.app.main.Home5Activity.ClickHistory;

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
public class ClickHistoryActivity_ViewBinding implements Unbinder {
    private ClickHistoryActivity b;

    @UiThread
    public ClickHistoryActivity_ViewBinding(ClickHistoryActivity clickHistoryActivity, View view) {
        this.b = clickHistoryActivity;
        clickHistoryActivity.clickHistoryTopBack = (TextView) butterknife.c.a.c(view, R.id.click_history_top_back, "field 'clickHistoryTopBack'", TextView.class);
        clickHistoryActivity.clickHistoryTopClear = (TextView) butterknife.c.a.c(view, R.id.click_history_top_clear, "field 'clickHistoryTopClear'", TextView.class);
        clickHistoryActivity.clickHistoryTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.click_history_top_layout, "field 'clickHistoryTopLayout'", LinearLayout.class);
        clickHistoryActivity.clickHistoryTab = (TabLayout) butterknife.c.a.c(view, R.id.click_history_tab, "field 'clickHistoryTab'", TabLayout.class);
        clickHistoryActivity.clickHistoryViewpager = (ViewPager) butterknife.c.a.c(view, R.id.click_history_viewpager, "field 'clickHistoryViewpager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        ClickHistoryActivity clickHistoryActivity = this.b;
        if (clickHistoryActivity != null) {
            this.b = null;
            clickHistoryActivity.clickHistoryTopBack = null;
            clickHistoryActivity.clickHistoryTopClear = null;
            clickHistoryActivity.clickHistoryTopLayout = null;
            clickHistoryActivity.clickHistoryTab = null;
            clickHistoryActivity.clickHistoryViewpager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
