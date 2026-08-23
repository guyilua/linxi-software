package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostDetailsActivity_ViewBinding implements Unbinder {
    private PostDetailsActivity b;

    @UiThread
    public PostDetailsActivity_ViewBinding(PostDetailsActivity postDetailsActivity, View view) {
        this.b = postDetailsActivity;
        postDetailsActivity.postDetailsBack = (TextView) butterknife.c.a.c(view, R.id.post_details_back, "field 'postDetailsBack'", TextView.class);
        postDetailsActivity.postDetailsLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_details_layout, "field 'postDetailsLayout'", LinearLayout.class);
        postDetailsActivity.postDetailsSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.post_details_swipeRefresh, "field 'postDetailsSwipeRefresh'", SwipeRefreshLayout.class);
        postDetailsActivity.postDetailsTopMore = (ImageView) butterknife.c.a.c(view, R.id.post_details_top_more, "field 'postDetailsTopMore'", ImageView.class);
        postDetailsActivity.postDetailsRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.post_details_recyclerView, "field 'postDetailsRecyclerView'", YcRecyclerView.class);
        postDetailsActivity.postDetailsUp = (CheckBox) butterknife.c.a.c(view, R.id.post_details_up, "field 'postDetailsUp'", CheckBox.class);
        postDetailsActivity.postDetailsPageNum = (TextView) butterknife.c.a.c(view, R.id.post_details_pageNum, "field 'postDetailsPageNum'", TextView.class);
        postDetailsActivity.postDetailsPageLast = (ImageView) butterknife.c.a.c(view, R.id.post_details_page_last, "field 'postDetailsPageLast'", ImageView.class);
        postDetailsActivity.postDetailsPageNext = (ImageView) butterknife.c.a.c(view, R.id.post_details_page_next, "field 'postDetailsPageNext'", ImageView.class);
        postDetailsActivity.postDetailsFootLv = (RelativeLayout) butterknife.c.a.c(view, R.id.post_details_foot_lv, "field 'postDetailsFootLv'", RelativeLayout.class);
        postDetailsActivity.postDetailsCollect = (CheckBox) butterknife.c.a.c(view, R.id.post_details_collect, "field 'postDetailsCollect'", CheckBox.class);
        postDetailsActivity.postDetailsReward = (ImageView) butterknife.c.a.c(view, R.id.post_details_reward, "field 'postDetailsReward'", ImageView.class);
        postDetailsActivity.postDetailsComment = (ImageView) butterknife.c.a.c(view, R.id.post_details_comment, "field 'postDetailsComment'", ImageView.class);
        postDetailsActivity.postDetailsTopAuditBtu = (TextView) butterknife.c.a.c(view, R.id.post_details_top_audit_btu, "field 'postDetailsTopAuditBtu'", TextView.class);
        postDetailsActivity.postDetailsTopFamilyAuditBtu = (TextView) butterknife.c.a.c(view, R.id.post_details_top_family_audit_btu, "field 'postDetailsTopFamilyAuditBtu'", TextView.class);
        postDetailsActivity.postDetailsTopAuditState = (CustomTextView) butterknife.c.a.c(view, R.id.post_details_top_audit_state, "field 'postDetailsTopAuditState'", CustomTextView.class);
        postDetailsActivity.postDetailsTopAuditState3 = (CustomTextView) butterknife.c.a.c(view, R.id.post_details_top_audit_state3, "field 'postDetailsTopAuditState3'", CustomTextView.class);
        postDetailsActivity.postDetailsVideoLv = (LinearLayout) butterknife.c.a.c(view, R.id.post_details_videoLv, "field 'postDetailsVideoLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        PostDetailsActivity postDetailsActivity = this.b;
        if (postDetailsActivity != null) {
            this.b = null;
            postDetailsActivity.postDetailsBack = null;
            postDetailsActivity.postDetailsLayout = null;
            postDetailsActivity.postDetailsSwipeRefresh = null;
            postDetailsActivity.postDetailsTopMore = null;
            postDetailsActivity.postDetailsRecyclerView = null;
            postDetailsActivity.postDetailsUp = null;
            postDetailsActivity.postDetailsPageNum = null;
            postDetailsActivity.postDetailsPageLast = null;
            postDetailsActivity.postDetailsPageNext = null;
            postDetailsActivity.postDetailsFootLv = null;
            postDetailsActivity.postDetailsCollect = null;
            postDetailsActivity.postDetailsReward = null;
            postDetailsActivity.postDetailsComment = null;
            postDetailsActivity.postDetailsTopAuditBtu = null;
            postDetailsActivity.postDetailsTopFamilyAuditBtu = null;
            postDetailsActivity.postDetailsTopAuditState = null;
            postDetailsActivity.postDetailsTopAuditState3 = null;
            postDetailsActivity.postDetailsVideoLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
