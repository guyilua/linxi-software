package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentDetailsActivity_ViewBinding implements Unbinder {
    private PostCommentDetailsActivity b;

    @UiThread
    public PostCommentDetailsActivity_ViewBinding(PostCommentDetailsActivity postCommentDetailsActivity, View view) {
        this.b = postCommentDetailsActivity;
        postCommentDetailsActivity.postCommentDetailsTopBack = (TextView) butterknife.c.a.c(view, R.id.post_comment_details_top_back, "field 'postCommentDetailsTopBack'", TextView.class);
        postCommentDetailsActivity.postCommentDetailsTopMore = (ImageView) butterknife.c.a.c(view, R.id.post_comment_details_top_more, "field 'postCommentDetailsTopMore'", ImageView.class);
        postCommentDetailsActivity.postCommentDetailsTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_comment_details_top_layout, "field 'postCommentDetailsTopLayout'", LinearLayout.class);
        postCommentDetailsActivity.postCommentDetailsRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.post_comment_details_recyclerView, "field 'postCommentDetailsRecyclerView'", YcRecyclerView.class);
        postCommentDetailsActivity.postCommentDetailsSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.post_comment_details_swipeRefresh, "field 'postCommentDetailsSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        PostCommentDetailsActivity postCommentDetailsActivity = this.b;
        if (postCommentDetailsActivity != null) {
            this.b = null;
            postCommentDetailsActivity.postCommentDetailsTopBack = null;
            postCommentDetailsActivity.postCommentDetailsTopMore = null;
            postCommentDetailsActivity.postCommentDetailsTopLayout = null;
            postCommentDetailsActivity.postCommentDetailsRecyclerView = null;
            postCommentDetailsActivity.postCommentDetailsSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
