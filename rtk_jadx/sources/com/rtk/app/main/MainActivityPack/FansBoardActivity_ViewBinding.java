package com.rtk.app.main.MainActivityPack;

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
public class FansBoardActivity_ViewBinding implements Unbinder {
    private FansBoardActivity b;

    @UiThread
    public FansBoardActivity_ViewBinding(FansBoardActivity fansBoardActivity, View view) {
        this.b = fansBoardActivity;
        fansBoardActivity.fansBoardTopBack = (TextView) butterknife.c.a.c(view, R.id.fans_board_topBack, "field 'fansBoardTopBack'", TextView.class);
        fansBoardActivity.fansBoardTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fans_board_topLayout, "field 'fansBoardTopLayout'", LinearLayout.class);
        fansBoardActivity.fansBoardTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.fans_board_tab_layout, "field 'fansBoardTabLayout'", TabLayout.class);
        fansBoardActivity.fansBoardViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.fans_board_viewPager, "field 'fansBoardViewPager'", BaseViewPager.class);
    }

    @CallSuper
    public void a() {
        FansBoardActivity fansBoardActivity = this.b;
        if (fansBoardActivity != null) {
            this.b = null;
            fansBoardActivity.fansBoardTopBack = null;
            fansBoardActivity.fansBoardTopLayout = null;
            fansBoardActivity.fansBoardTabLayout = null;
            fansBoardActivity.fansBoardViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
