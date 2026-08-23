package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.CustomListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityListActivity_ViewBinding implements Unbinder {
    private CommunityListActivity b;

    @UiThread
    public CommunityListActivity_ViewBinding(CommunityListActivity communityListActivity, View view) {
        this.b = communityListActivity;
        communityListActivity.communityListBack = (ImageView) butterknife.c.a.c(view, R.id.community_list_back, "field 'communityListBack'", ImageView.class);
        communityListActivity.communityListOrderingRuleSpinner = (Spinner) butterknife.c.a.c(view, R.id.community_list_ordering_rule_spinner, "field 'communityListOrderingRuleSpinner'", Spinner.class);
        communityListActivity.communityListSearch = (ImageView) butterknife.c.a.c(view, R.id.community_list_search, "field 'communityListSearch'", ImageView.class);
        communityListActivity.communityListPublishPost = (ImageView) butterknife.c.a.c(view, R.id.community_list_publish_post, "field 'communityListPublishPost'", ImageView.class);
        communityListActivity.communityListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.community_list_layout, "field 'communityListLayout'", LinearLayout.class);
        communityListActivity.communityListIcon = (ImageView) butterknife.c.a.c(view, R.id.community_list_icon, "field 'communityListIcon'", ImageView.class);
        communityListActivity.communityListName = (TextView) butterknife.c.a.c(view, R.id.community_list_Name, "field 'communityListName'", TextView.class);
        communityListActivity.communityListAttentionNum = (TextView) butterknife.c.a.c(view, R.id.community_list_attentionNum, "field 'communityListAttentionNum'", TextView.class);
        communityListActivity.communityListTopic = (TextView) butterknife.c.a.c(view, R.id.community_list_topic, "field 'communityListTopic'", TextView.class);
        communityListActivity.communityListExpert = (TextView) butterknife.c.a.c(view, R.id.community_list_Expert, "field 'communityListExpert'", TextView.class);
        communityListActivity.communityListSignIn = (TextView) butterknife.c.a.c(view, R.id.community_list_sign_in, "field 'communityListSignIn'", TextView.class);
        communityListActivity.communityListTopList = (CustomListView) butterknife.c.a.c(view, R.id.community_list_topList, "field 'communityListTopList'", CustomListView.class);
        communityListActivity.communityListTab = (TabLayout) butterknife.c.a.c(view, R.id.community_list_tab, "field 'communityListTab'", TabLayout.class);
        communityListActivity.communityListBar = (AppBarLayout) butterknife.c.a.c(view, R.id.community_list_bar, "field 'communityListBar'", AppBarLayout.class);
        communityListActivity.communityListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.community_list_viewPager, "field 'communityListViewPager'", BaseViewPager.class);
        communityListActivity.communityListCoordinatorLayout = (CoordinatorLayout) butterknife.c.a.c(view, R.id.community_list_CoordinatorLayout, "field 'communityListCoordinatorLayout'", CoordinatorLayout.class);
        communityListActivity.communityListSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.community_list_swipeRefresh, "field 'communityListSwipeRefresh'", SwipeRefreshLayout.class);
        communityListActivity.communityListModuleLv = (RelativeLayout) butterknife.c.a.c(view, R.id.community_list_module_lv, "field 'communityListModuleLv'", RelativeLayout.class);
        communityListActivity.communityListParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.community_list_parent_layout, "field 'communityListParentLayout'", LinearLayout.class);
        communityListActivity.communityListAuditCommentBtu = (TextView) butterknife.c.a.c(view, R.id.community_list_audit_comment_btu, "field 'communityListAuditCommentBtu'", TextView.class);
        communityListActivity.communityListAuditBtu = (TextView) butterknife.c.a.c(view, R.id.community_list_auditBtu, "field 'communityListAuditBtu'", TextView.class);
        communityListActivity.communityListAuditLv = (LinearLayout) butterknife.c.a.c(view, R.id.community_list_audit_lv, "field 'communityListAuditLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        CommunityListActivity communityListActivity = this.b;
        if (communityListActivity != null) {
            this.b = null;
            communityListActivity.communityListBack = null;
            communityListActivity.communityListOrderingRuleSpinner = null;
            communityListActivity.communityListSearch = null;
            communityListActivity.communityListPublishPost = null;
            communityListActivity.communityListLayout = null;
            communityListActivity.communityListIcon = null;
            communityListActivity.communityListName = null;
            communityListActivity.communityListAttentionNum = null;
            communityListActivity.communityListTopic = null;
            communityListActivity.communityListExpert = null;
            communityListActivity.communityListSignIn = null;
            communityListActivity.communityListTopList = null;
            communityListActivity.communityListTab = null;
            communityListActivity.communityListBar = null;
            communityListActivity.communityListViewPager = null;
            communityListActivity.communityListCoordinatorLayout = null;
            communityListActivity.communityListSwipeRefresh = null;
            communityListActivity.communityListModuleLv = null;
            communityListActivity.communityListParentLayout = null;
            communityListActivity.communityListAuditCommentBtu = null;
            communityListActivity.communityListAuditBtu = null;
            communityListActivity.communityListAuditLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
