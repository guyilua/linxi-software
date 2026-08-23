package com.rtk.app.main.family;

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
public class FamilyCommunityListActivity_ViewBinding implements Unbinder {
    private FamilyCommunityListActivity b;

    @UiThread
    public FamilyCommunityListActivity_ViewBinding(FamilyCommunityListActivity familyCommunityListActivity, View view) {
        this.b = familyCommunityListActivity;
        familyCommunityListActivity.communityListBack = (ImageView) butterknife.c.a.c(view, R.id.community_list_back, "field 'communityListBack'", ImageView.class);
        familyCommunityListActivity.communityListOrderingRuleSpinner = (Spinner) butterknife.c.a.c(view, R.id.community_list_ordering_rule_spinner, "field 'communityListOrderingRuleSpinner'", Spinner.class);
        familyCommunityListActivity.communityListSearch = (ImageView) butterknife.c.a.c(view, R.id.community_list_search, "field 'communityListSearch'", ImageView.class);
        familyCommunityListActivity.communityListPublishPost = (ImageView) butterknife.c.a.c(view, R.id.community_list_publish_post, "field 'communityListPublishPost'", ImageView.class);
        familyCommunityListActivity.communityListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.back_layout, "field 'communityListLayout'", LinearLayout.class);
        familyCommunityListActivity.communityListIcon = (ImageView) butterknife.c.a.c(view, R.id.community_list_icon, "field 'communityListIcon'", ImageView.class);
        familyCommunityListActivity.communityListName = (TextView) butterknife.c.a.c(view, R.id.community_list_Name, "field 'communityListName'", TextView.class);
        familyCommunityListActivity.communityListTopList = (CustomListView) butterknife.c.a.c(view, R.id.community_list_topList, "field 'communityListTopList'", CustomListView.class);
        familyCommunityListActivity.communityListTab = (TabLayout) butterknife.c.a.c(view, R.id.community_list_tab, "field 'communityListTab'", TabLayout.class);
        familyCommunityListActivity.communityListBar = (AppBarLayout) butterknife.c.a.c(view, R.id.community_list_bar, "field 'communityListBar'", AppBarLayout.class);
        familyCommunityListActivity.communityListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.community_list_viewPager, "field 'communityListViewPager'", BaseViewPager.class);
        familyCommunityListActivity.communityListCoordinatorLayout = (CoordinatorLayout) butterknife.c.a.c(view, R.id.community_list_CoordinatorLayout, "field 'communityListCoordinatorLayout'", CoordinatorLayout.class);
        familyCommunityListActivity.communityListSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.community_list_swipeRefresh, "field 'communityListSwipeRefresh'", SwipeRefreshLayout.class);
        familyCommunityListActivity.communityListModuleLv = (RelativeLayout) butterknife.c.a.c(view, R.id.community_list_module_lv, "field 'communityListModuleLv'", RelativeLayout.class);
        familyCommunityListActivity.communityListParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.community_list_parent_layout, "field 'communityListParentLayout'", LinearLayout.class);
        familyCommunityListActivity.auditMessageNum = (TextView) butterknife.c.a.c(view, R.id.audit_message_num, "field 'auditMessageNum'", TextView.class);
        familyCommunityListActivity.auditCommentMessageNum = (TextView) butterknife.c.a.c(view, R.id.audit_comment_message_num, "field 'auditCommentMessageNum'", TextView.class);
        familyCommunityListActivity.communityListAuditLv = (LinearLayout) butterknife.c.a.c(view, R.id.community_list_audit_lv, "field 'communityListAuditLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        FamilyCommunityListActivity familyCommunityListActivity = this.b;
        if (familyCommunityListActivity != null) {
            this.b = null;
            familyCommunityListActivity.communityListBack = null;
            familyCommunityListActivity.communityListOrderingRuleSpinner = null;
            familyCommunityListActivity.communityListSearch = null;
            familyCommunityListActivity.communityListPublishPost = null;
            familyCommunityListActivity.communityListLayout = null;
            familyCommunityListActivity.communityListIcon = null;
            familyCommunityListActivity.communityListName = null;
            familyCommunityListActivity.communityListTopList = null;
            familyCommunityListActivity.communityListTab = null;
            familyCommunityListActivity.communityListBar = null;
            familyCommunityListActivity.communityListViewPager = null;
            familyCommunityListActivity.communityListCoordinatorLayout = null;
            familyCommunityListActivity.communityListSwipeRefresh = null;
            familyCommunityListActivity.communityListModuleLv = null;
            familyCommunityListActivity.communityListParentLayout = null;
            familyCommunityListActivity.auditMessageNum = null;
            familyCommunityListActivity.auditCommentMessageNum = null;
            familyCommunityListActivity.communityListAuditLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
