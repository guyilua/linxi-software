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
public class MyPostClickDataActivity_ViewBinding implements Unbinder {
    private MyPostClickDataActivity b;

    @UiThread
    public MyPostClickDataActivity_ViewBinding(MyPostClickDataActivity myPostClickDataActivity, View view) {
        this.b = myPostClickDataActivity;
        myPostClickDataActivity.upSrcClickDataTopBack = (TextView) butterknife.c.a.c(view, R.id.up_src_click_data_top_back, "field 'upSrcClickDataTopBack'", TextView.class);
        myPostClickDataActivity.upSrcClickDataTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_click_data_top_layout, "field 'upSrcClickDataTopLayout'", LinearLayout.class);
        myPostClickDataActivity.upSrcParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_parent_layout, "field 'upSrcParentLayout'", LinearLayout.class);
        myPostClickDataActivity.upSrcClickDataAllDownloadNum = (TextView) butterknife.c.a.c(view, R.id.up_src_click_data_all_downloadNum, "field 'upSrcClickDataAllDownloadNum'", TextView.class);
        myPostClickDataActivity.upSrcClickDataViewPage = (ViewPager) butterknife.c.a.c(view, R.id.up_src_click_data_viewPage, "field 'upSrcClickDataViewPage'", ViewPager.class);
        myPostClickDataActivity.upSrcClickDataTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.up_src_click_data_tab_layout, "field 'upSrcClickDataTabLayout'", TabLayout.class);
        myPostClickDataActivity.upSrcClickDataAllLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_click_data_all_lv, "field 'upSrcClickDataAllLv'", LinearLayout.class);
        myPostClickDataActivity.upSrcClickDataToday = (TextView) butterknife.c.a.c(view, R.id.up_src_click_data_Today, "field 'upSrcClickDataToday'", TextView.class);
        myPostClickDataActivity.upTip = (TextView) butterknife.c.a.c(view, R.id.up_tip, "field 'upTip'", TextView.class);
    }

    @CallSuper
    public void a() {
        MyPostClickDataActivity myPostClickDataActivity = this.b;
        if (myPostClickDataActivity != null) {
            this.b = null;
            myPostClickDataActivity.upSrcClickDataTopBack = null;
            myPostClickDataActivity.upSrcClickDataTopLayout = null;
            myPostClickDataActivity.upSrcParentLayout = null;
            myPostClickDataActivity.upSrcClickDataAllDownloadNum = null;
            myPostClickDataActivity.upSrcClickDataViewPage = null;
            myPostClickDataActivity.upSrcClickDataTabLayout = null;
            myPostClickDataActivity.upSrcClickDataAllLv = null;
            myPostClickDataActivity.upSrcClickDataToday = null;
            myPostClickDataActivity.upTip = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
