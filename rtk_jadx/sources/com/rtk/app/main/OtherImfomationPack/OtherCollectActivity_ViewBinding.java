package com.rtk.app.main.OtherImfomationPack;

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
public class OtherCollectActivity_ViewBinding implements Unbinder {
    private OtherCollectActivity b;

    @UiThread
    public OtherCollectActivity_ViewBinding(OtherCollectActivity otherCollectActivity, View view) {
        this.b = otherCollectActivity;
        otherCollectActivity.otherCollectBack = (TextView) butterknife.c.a.c(view, R.id.otherCollect_back, "field 'otherCollectBack'", TextView.class);
        otherCollectActivity.otherCollectTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.otherCollect_top_layout, "field 'otherCollectTopLayout'", LinearLayout.class);
        otherCollectActivity.otherCollectViewpager = (ViewPager) butterknife.c.a.c(view, R.id.otherCollect_viewpager, "field 'otherCollectViewpager'", ViewPager.class);
        otherCollectActivity.otherCollectTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.otherCollect_tabLayout, "field 'otherCollectTabLayout'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        OtherCollectActivity otherCollectActivity = this.b;
        if (otherCollectActivity != null) {
            this.b = null;
            otherCollectActivity.otherCollectBack = null;
            otherCollectActivity.otherCollectTopLayout = null;
            otherCollectActivity.otherCollectViewpager = null;
            otherCollectActivity.otherCollectTabLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
