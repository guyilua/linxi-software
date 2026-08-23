package com.rtk.app.main.HomeCommunityPack;

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
public class PostAuditListActivity_ViewBinding implements Unbinder {
    private PostAuditListActivity b;

    @UiThread
    public PostAuditListActivity_ViewBinding(PostAuditListActivity postAuditListActivity, View view) {
        this.b = postAuditListActivity;
        postAuditListActivity.postAuditListBack = (TextView) butterknife.c.a.c(view, R.id.post_audit_list_back, "field 'postAuditListBack'", TextView.class);
        postAuditListActivity.postAuditListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_audit_list_layout, "field 'postAuditListLayout'", LinearLayout.class);
        postAuditListActivity.postAuditListTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.post_audit_list_tabLayout, "field 'postAuditListTabLayout'", TabLayout.class);
        postAuditListActivity.postAuditListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.post_audit_list_viewPager, "field 'postAuditListViewPager'", BaseViewPager.class);
        postAuditListActivity.help = butterknife.c.a.b(view, R.id.help, "field 'help'");
    }

    @CallSuper
    public void a() {
        PostAuditListActivity postAuditListActivity = this.b;
        if (postAuditListActivity != null) {
            this.b = null;
            postAuditListActivity.postAuditListBack = null;
            postAuditListActivity.postAuditListLayout = null;
            postAuditListActivity.postAuditListTabLayout = null;
            postAuditListActivity.postAuditListViewPager = null;
            postAuditListActivity.help = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
