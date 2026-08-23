package com.rtk.app.main.UpModule;

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
public class UpClickSrcDataActivity_ViewBinding implements Unbinder {
    private UpClickSrcDataActivity b;

    @UiThread
    public UpClickSrcDataActivity_ViewBinding(UpClickSrcDataActivity upClickSrcDataActivity, View view) {
        this.b = upClickSrcDataActivity;
        upClickSrcDataActivity.upSrcClickDataTopBack = (TextView) butterknife.c.a.c(view, R.id.up_src_click_data_top_back, "field 'upSrcClickDataTopBack'", TextView.class);
        upClickSrcDataActivity.upSrcClickDataTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_click_data_top_layout, "field 'upSrcClickDataTopLayout'", LinearLayout.class);
        upClickSrcDataActivity.upSrcParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_parent_layout, "field 'upSrcParentLayout'", LinearLayout.class);
        upClickSrcDataActivity.upSrcClickDataAllDownloadNum = (TextView) butterknife.c.a.c(view, R.id.up_src_click_data_all_downloadNum, "field 'upSrcClickDataAllDownloadNum'", TextView.class);
        upClickSrcDataActivity.upSrcClickDataViewPage = (ViewPager) butterknife.c.a.c(view, R.id.up_src_click_data_viewPage, "field 'upSrcClickDataViewPage'", ViewPager.class);
        upClickSrcDataActivity.upSrcClickDataTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.up_src_click_data_tab_layout, "field 'upSrcClickDataTabLayout'", TabLayout.class);
        upClickSrcDataActivity.upSrcClickDataAllLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_click_data_all_lv, "field 'upSrcClickDataAllLv'", LinearLayout.class);
        upClickSrcDataActivity.upSrcClickDataToday = (TextView) butterknife.c.a.c(view, R.id.up_src_click_data_Today, "field 'upSrcClickDataToday'", TextView.class);
        upClickSrcDataActivity.upTip = (TextView) butterknife.c.a.c(view, R.id.up_tip, "field 'upTip'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpClickSrcDataActivity upClickSrcDataActivity = this.b;
        if (upClickSrcDataActivity != null) {
            this.b = null;
            upClickSrcDataActivity.upSrcClickDataTopBack = null;
            upClickSrcDataActivity.upSrcClickDataTopLayout = null;
            upClickSrcDataActivity.upSrcParentLayout = null;
            upClickSrcDataActivity.upSrcClickDataAllDownloadNum = null;
            upClickSrcDataActivity.upSrcClickDataViewPage = null;
            upClickSrcDataActivity.upSrcClickDataTabLayout = null;
            upClickSrcDataActivity.upSrcClickDataAllLv = null;
            upClickSrcDataActivity.upSrcClickDataToday = null;
            upClickSrcDataActivity.upTip = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
