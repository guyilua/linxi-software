package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkListActivity_ViewBinding implements Unbinder {
    private UpApkListActivity b;

    @UiThread
    public UpApkListActivity_ViewBinding(UpApkListActivity upApkListActivity, View view) {
        this.b = upApkListActivity;
        upApkListActivity.upApkListTopBack = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_top_back, "field 'upApkListTopBack'", TextView.class);
        upApkListActivity.upApkListTopGoToCommentCheck = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_top_goTo_comment_Check, "field 'upApkListTopGoToCommentCheck'", TextView.class);
        upApkListActivity.upApkListTopGoToCheck = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_top_goToCheck, "field 'upApkListTopGoToCheck'", TextView.class);
        upApkListActivity.upApkListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_apk_list_top_layout, "field 'upApkListTopLayout'", LinearLayout.class);
        upApkListActivity.upApkListTab = (TabLayout) butterknife.c.a.c(view, R.id.up_apk_list_tab, "field 'upApkListTab'", TabLayout.class);
        upApkListActivity.upApkListViewpager = (ViewPager) butterknife.c.a.c(view, R.id.up_apk_list_viewpager, "field 'upApkListViewpager'", ViewPager.class);
        upApkListActivity.upApkListTopMyUpLoading = (MarkedImageView) butterknife.c.a.c(view, R.id.up_apk_list_top_my_up_loading, "field 'upApkListTopMyUpLoading'", MarkedImageView.class);
        upApkListActivity.upApkListUpBtu = (ImageView) butterknife.c.a.c(view, R.id.up_apk_list_upBtu, "field 'upApkListUpBtu'", ImageView.class);
    }

    @CallSuper
    public void a() {
        UpApkListActivity upApkListActivity = this.b;
        if (upApkListActivity != null) {
            this.b = null;
            upApkListActivity.upApkListTopBack = null;
            upApkListActivity.upApkListTopGoToCommentCheck = null;
            upApkListActivity.upApkListTopGoToCheck = null;
            upApkListActivity.upApkListTopLayout = null;
            upApkListActivity.upApkListTab = null;
            upApkListActivity.upApkListViewpager = null;
            upApkListActivity.upApkListTopMyUpLoading = null;
            upApkListActivity.upApkListUpBtu = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
