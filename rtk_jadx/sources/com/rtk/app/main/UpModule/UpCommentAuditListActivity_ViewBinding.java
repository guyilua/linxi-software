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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCommentAuditListActivity_ViewBinding implements Unbinder {
    private UpCommentAuditListActivity b;

    @UiThread
    public UpCommentAuditListActivity_ViewBinding(UpCommentAuditListActivity upCommentAuditListActivity, View view) {
        this.b = upCommentAuditListActivity;
        upCommentAuditListActivity.upCommentAuditListBack = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_back, "field 'upCommentAuditListBack'", TextView.class);
        upCommentAuditListActivity.upCommentAuditListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_comment_audit_list_layout, "field 'upCommentAuditListLayout'", LinearLayout.class);
        upCommentAuditListActivity.upCommentAuditListTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.up_comment_audit_list_tabLayout, "field 'upCommentAuditListTabLayout'", TabLayout.class);
        upCommentAuditListActivity.upCommentAuditListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.up_comment_audit_list_viewPager, "field 'upCommentAuditListViewPager'", BaseViewPager.class);
        upCommentAuditListActivity.upCommentAuditListRefresh = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_list_refresh, "field 'upCommentAuditListRefresh'", TextView.class);
        upCommentAuditListActivity.upCommentAuditMyAudit = (TextView) butterknife.c.a.c(view, R.id.up_comment_audit_my_audit, "field 'upCommentAuditMyAudit'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpCommentAuditListActivity upCommentAuditListActivity = this.b;
        if (upCommentAuditListActivity != null) {
            this.b = null;
            upCommentAuditListActivity.upCommentAuditListBack = null;
            upCommentAuditListActivity.upCommentAuditListLayout = null;
            upCommentAuditListActivity.upCommentAuditListTabLayout = null;
            upCommentAuditListActivity.upCommentAuditListViewPager = null;
            upCommentAuditListActivity.upCommentAuditListRefresh = null;
            upCommentAuditListActivity.upCommentAuditMyAudit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
