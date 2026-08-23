package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckApkListActivity_ViewBinding implements Unbinder {
    private UpCheckApkListActivity b;

    @UiThread
    public UpCheckApkListActivity_ViewBinding(UpCheckApkListActivity upCheckApkListActivity, View view) {
        this.b = upCheckApkListActivity;
        upCheckApkListActivity.upCheckApkListTopBack = (TextView) butterknife.c.a.c(view, R.id.up_check_apk_list_top_back, "field 'upCheckApkListTopBack'", TextView.class);
        upCheckApkListActivity.upCheckApkListTopSearch = (TextView) butterknife.c.a.c(view, R.id.up_check_apk_list_top_search, "field 'upCheckApkListTopSearch'", TextView.class);
        upCheckApkListActivity.upCheckApkListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_apk_list_top_layout, "field 'upCheckApkListTopLayout'", LinearLayout.class);
        upCheckApkListActivity.upCheckApkListViewpager = (BaseViewPager) butterknife.c.a.c(view, R.id.up_check_apk_list_viewpager, "field 'upCheckApkListViewpager'", BaseViewPager.class);
        upCheckApkListActivity.upCheckApkListTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.up_check_apk_list_tab_layout, "field 'upCheckApkListTabLayout'", TabLayout.class);
        upCheckApkListActivity.upCheckApkListTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.up_check_apk_list_top_download, "field 'upCheckApkListTopDownload'", MarkedImageView.class);
    }

    @CallSuper
    public void a() {
        UpCheckApkListActivity upCheckApkListActivity = this.b;
        if (upCheckApkListActivity != null) {
            this.b = null;
            upCheckApkListActivity.upCheckApkListTopBack = null;
            upCheckApkListActivity.upCheckApkListTopSearch = null;
            upCheckApkListActivity.upCheckApkListTopLayout = null;
            upCheckApkListActivity.upCheckApkListViewpager = null;
            upCheckApkListActivity.upCheckApkListTabLayout = null;
            upCheckApkListActivity.upCheckApkListTopDownload = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
