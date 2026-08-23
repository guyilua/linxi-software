package com.rtk.app.main.family.upAudit;

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
public class FamilyUpCheckApkListActivity_ViewBinding implements Unbinder {
    private FamilyUpCheckApkListActivity b;

    @UiThread
    public FamilyUpCheckApkListActivity_ViewBinding(FamilyUpCheckApkListActivity familyUpCheckApkListActivity, View view) {
        this.b = familyUpCheckApkListActivity;
        familyUpCheckApkListActivity.upCheckApkListTopBack = (TextView) butterknife.c.a.c(view, R.id.up_check_apk_list_top_back, "field 'upCheckApkListTopBack'", TextView.class);
        familyUpCheckApkListActivity.upCheckApkListTopSearch = (TextView) butterknife.c.a.c(view, R.id.up_check_apk_list_top_search, "field 'upCheckApkListTopSearch'", TextView.class);
        familyUpCheckApkListActivity.upCheckApkListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_check_apk_list_top_layout, "field 'upCheckApkListTopLayout'", LinearLayout.class);
        familyUpCheckApkListActivity.upCheckApkListViewpager = (BaseViewPager) butterknife.c.a.c(view, R.id.up_check_apk_list_viewpager, "field 'upCheckApkListViewpager'", BaseViewPager.class);
        familyUpCheckApkListActivity.upCheckApkListTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.up_check_apk_list_tab_layout, "field 'upCheckApkListTabLayout'", TabLayout.class);
        familyUpCheckApkListActivity.upCheckApkListTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.up_check_apk_list_top_download, "field 'upCheckApkListTopDownload'", MarkedImageView.class);
        familyUpCheckApkListActivity.help = butterknife.c.a.b(view, R.id.help, "field 'help'");
    }

    @CallSuper
    public void a() {
        FamilyUpCheckApkListActivity familyUpCheckApkListActivity = this.b;
        if (familyUpCheckApkListActivity != null) {
            this.b = null;
            familyUpCheckApkListActivity.upCheckApkListTopBack = null;
            familyUpCheckApkListActivity.upCheckApkListTopSearch = null;
            familyUpCheckApkListActivity.upCheckApkListTopLayout = null;
            familyUpCheckApkListActivity.upCheckApkListViewpager = null;
            familyUpCheckApkListActivity.upCheckApkListTabLayout = null;
            familyUpCheckApkListActivity.upCheckApkListTopDownload = null;
            familyUpCheckApkListActivity.help = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
