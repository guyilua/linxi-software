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
public class UpSrcDataActivity_ViewBinding implements Unbinder {
    private UpSrcDataActivity b;

    @UiThread
    public UpSrcDataActivity_ViewBinding(UpSrcDataActivity upSrcDataActivity, View view) {
        this.b = upSrcDataActivity;
        upSrcDataActivity.upSrcDataTopBack = (TextView) butterknife.c.a.c(view, R.id.up_src_data_top_back, "field 'upSrcDataTopBack'", TextView.class);
        upSrcDataActivity.upSrcDataTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_data_top_layout, "field 'upSrcDataTopLayout'", LinearLayout.class);
        upSrcDataActivity.upSrcParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_parent_layout, "field 'upSrcParentLayout'", LinearLayout.class);
        upSrcDataActivity.upSrcDataAllDownloadNum = (TextView) butterknife.c.a.c(view, R.id.up_src_data_all_downloadNum, "field 'upSrcDataAllDownloadNum'", TextView.class);
        upSrcDataActivity.upSrcDataViewPage = (ViewPager) butterknife.c.a.c(view, R.id.up_src_data_viewPage, "field 'upSrcDataViewPage'", ViewPager.class);
        upSrcDataActivity.upSrcDataTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.up_src_data_tab_layout, "field 'upSrcDataTabLayout'", TabLayout.class);
        upSrcDataActivity.upSrcDataAllLv = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_data_all_lv, "field 'upSrcDataAllLv'", LinearLayout.class);
        upSrcDataActivity.upSrcDataToday = (TextView) butterknife.c.a.c(view, R.id.up_src_data_Today, "field 'upSrcDataToday'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpSrcDataActivity upSrcDataActivity = this.b;
        if (upSrcDataActivity != null) {
            this.b = null;
            upSrcDataActivity.upSrcDataTopBack = null;
            upSrcDataActivity.upSrcDataTopLayout = null;
            upSrcDataActivity.upSrcParentLayout = null;
            upSrcDataActivity.upSrcDataAllDownloadNum = null;
            upSrcDataActivity.upSrcDataViewPage = null;
            upSrcDataActivity.upSrcDataTabLayout = null;
            upSrcDataActivity.upSrcDataAllLv = null;
            upSrcDataActivity.upSrcDataToday = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
