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
public class PostCommentAuditListActivity_ViewBinding implements Unbinder {
    private PostCommentAuditListActivity b;

    @UiThread
    public PostCommentAuditListActivity_ViewBinding(PostCommentAuditListActivity postCommentAuditListActivity, View view) {
        this.b = postCommentAuditListActivity;
        postCommentAuditListActivity.postCommentAuditListBack = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_back, "field 'postCommentAuditListBack'", TextView.class);
        postCommentAuditListActivity.postCommentAuditListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_comment_audit_list_layout, "field 'postCommentAuditListLayout'", LinearLayout.class);
        postCommentAuditListActivity.postCommentAuditListTabLayout = (TabLayout) butterknife.c.a.c(view, R.id.post_comment_audit_list_tabLayout, "field 'postCommentAuditListTabLayout'", TabLayout.class);
        postCommentAuditListActivity.postCommentAuditListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.post_comment_audit_list_viewPager, "field 'postCommentAuditListViewPager'", BaseViewPager.class);
        postCommentAuditListActivity.postCommentAuditListRefresh = (TextView) butterknife.c.a.c(view, R.id.post_comment_audit_list_refresh, "field 'postCommentAuditListRefresh'", TextView.class);
        postCommentAuditListActivity.help = butterknife.c.a.b(view, R.id.help, "field 'help'");
    }

    @CallSuper
    public void a() {
        PostCommentAuditListActivity postCommentAuditListActivity = this.b;
        if (postCommentAuditListActivity != null) {
            this.b = null;
            postCommentAuditListActivity.postCommentAuditListBack = null;
            postCommentAuditListActivity.postCommentAuditListLayout = null;
            postCommentAuditListActivity.postCommentAuditListTabLayout = null;
            postCommentAuditListActivity.postCommentAuditListViewPager = null;
            postCommentAuditListActivity.postCommentAuditListRefresh = null;
            postCommentAuditListActivity.help = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
