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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpCommentAuditListActivity_ViewBinding implements Unbinder {
    private FamilyUpCommentAuditListActivity b;

    @UiThread
    public FamilyUpCommentAuditListActivity_ViewBinding(FamilyUpCommentAuditListActivity familyUpCommentAuditListActivity, View view) {
        this.b = familyUpCommentAuditListActivity;
        familyUpCommentAuditListActivity.upCommentAuditListBack = (TextView) butterknife.c.a.c(view, R.id.up_family_comment_audit_list_back, "field 'upCommentAuditListBack'", TextView.class);
        familyUpCommentAuditListActivity.upCommentAuditListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_family_comment_audit_list_layout, "field 'upCommentAuditListLayout'", LinearLayout.class);
        familyUpCommentAuditListActivity.upCommentAuditListTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.up_family_comment_audit_list_tabLayout, "field 'upCommentAuditListTabLayout'", TabLayout.class);
        familyUpCommentAuditListActivity.upCommentAuditListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.up_family_comment_audit_list_viewPager, "field 'upCommentAuditListViewPager'", BaseViewPager.class);
        familyUpCommentAuditListActivity.upCommentAuditListRefresh = (TextView) butterknife.c.a.c(view, R.id.up_family_comment_audit_list_refresh, "field 'upCommentAuditListRefresh'", TextView.class);
        familyUpCommentAuditListActivity.upCommentAuditMyAudit = (TextView) butterknife.c.a.c(view, R.id.up_family_comment_audit_my_audit, "field 'upCommentAuditMyAudit'", TextView.class);
    }

    @CallSuper
    public void a() {
        FamilyUpCommentAuditListActivity familyUpCommentAuditListActivity = this.b;
        if (familyUpCommentAuditListActivity != null) {
            this.b = null;
            familyUpCommentAuditListActivity.upCommentAuditListBack = null;
            familyUpCommentAuditListActivity.upCommentAuditListLayout = null;
            familyUpCommentAuditListActivity.upCommentAuditListTabLayout = null;
            familyUpCommentAuditListActivity.upCommentAuditListViewPager = null;
            familyUpCommentAuditListActivity.upCommentAuditListRefresh = null;
            familyUpCommentAuditListActivity.upCommentAuditMyAudit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
