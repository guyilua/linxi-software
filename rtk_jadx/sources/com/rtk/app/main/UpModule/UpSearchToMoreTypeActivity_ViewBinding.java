package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSearchToMoreTypeActivity_ViewBinding implements Unbinder {
    private UpSearchToMoreTypeActivity b;

    @UiThread
    public UpSearchToMoreTypeActivity_ViewBinding(UpSearchToMoreTypeActivity upSearchToMoreTypeActivity, View view) {
        this.b = upSearchToMoreTypeActivity;
        upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopBack = (TextView) butterknife.c.a.c(view, R.id.activity_up_search_to_more_type_top_back, "field 'activityUpSearchToMoreTypeTopBack'", TextView.class);
        upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopSearch = (EditText) butterknife.c.a.c(view, R.id.activity_up_search_to_more_type_top_search, "field 'activityUpSearchToMoreTypeTopSearch'", EditText.class);
        upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopSubmit = (TextView) butterknife.c.a.c(view, R.id.activity_up_search_to_more_type_top_submit, "field 'activityUpSearchToMoreTypeTopSubmit'", TextView.class);
        upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.activity_up_search_to_more_type_top_layout, "field 'activityUpSearchToMoreTypeTopLayout'", LinearLayout.class);
        upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTab = (TabLayout) butterknife.c.a.c(view, R.id.activity_up_search_to_more_type_tab, "field 'activityUpSearchToMoreTypeTab'", TabLayout.class);
        upSearchToMoreTypeActivity.activityUpSearchToMoreTypeViewpager = (ViewPager) butterknife.c.a.c(view, R.id.activity_up_search_to_more_type_viewpager, "field 'activityUpSearchToMoreTypeViewpager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        UpSearchToMoreTypeActivity upSearchToMoreTypeActivity = this.b;
        if (upSearchToMoreTypeActivity != null) {
            this.b = null;
            upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopBack = null;
            upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopSearch = null;
            upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopSubmit = null;
            upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTopLayout = null;
            upSearchToMoreTypeActivity.activityUpSearchToMoreTypeTab = null;
            upSearchToMoreTypeActivity.activityUpSearchToMoreTypeViewpager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
