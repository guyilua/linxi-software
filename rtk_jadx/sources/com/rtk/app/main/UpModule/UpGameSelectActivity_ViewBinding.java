package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameSelectActivity_ViewBinding implements Unbinder {
    private UpGameSelectActivity b;

    @UiThread
    public UpGameSelectActivity_ViewBinding(UpGameSelectActivity upGameSelectActivity, View view) {
        this.b = upGameSelectActivity;
        upGameSelectActivity.upGameSelectBack = (TextView) butterknife.c.a.c(view, R.id.up_game_select_back, "field 'upGameSelectBack'", TextView.class);
        upGameSelectActivity.upGameSelectLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.up_game_select_layout, "field 'upGameSelectLayout'", RelativeLayout.class);
        upGameSelectActivity.upGameSelectTab = (TabLayout) butterknife.c.a.c(view, R.id.up_game_select_tab, "field 'upGameSelectTab'", TabLayout.class);
        upGameSelectActivity.upGameSelectViewPager = (ViewPager) butterknife.c.a.c(view, R.id.up_game_select_viewPager, "field 'upGameSelectViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        UpGameSelectActivity upGameSelectActivity = this.b;
        if (upGameSelectActivity != null) {
            this.b = null;
            upGameSelectActivity.upGameSelectBack = null;
            upGameSelectActivity.upGameSelectLayout = null;
            upGameSelectActivity.upGameSelectTab = null;
            upGameSelectActivity.upGameSelectViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
