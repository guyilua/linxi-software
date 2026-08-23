package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSelectPostActivity_ViewBinding implements Unbinder {
    private PostSelectPostActivity b;

    @UiThread
    public PostSelectPostActivity_ViewBinding(PostSelectPostActivity postSelectPostActivity, View view) {
        this.b = postSelectPostActivity;
        postSelectPostActivity.postSelectPostBack = (TextView) butterknife.c.a.c(view, R.id.post_select_post_back, "field 'postSelectPostBack'", TextView.class);
        postSelectPostActivity.postSelectPostTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_select_post_top_layout, "field 'postSelectPostTopLayout'", LinearLayout.class);
        postSelectPostActivity.postSelectPostSearchEdit = (EditText) butterknife.c.a.c(view, R.id.post_select_post_searchEdit, "field 'postSelectPostSearchEdit'", EditText.class);
        postSelectPostActivity.postSelectPostSearchBtu = (TextView) butterknife.c.a.c(view, R.id.post_select_post_searchBtu, "field 'postSelectPostSearchBtu'", TextView.class);
        postSelectPostActivity.postSelectPostTips = (TextView) butterknife.c.a.c(view, R.id.post_select_post_tips, "field 'postSelectPostTips'", TextView.class);
        postSelectPostActivity.postSelectPostListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.post_select_post_listView, "field 'postSelectPostListView'", YcRecyclerView.class);
        postSelectPostActivity.postSelectPostSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.post_select_post_swipeRefresh, "field 'postSelectPostSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        PostSelectPostActivity postSelectPostActivity = this.b;
        if (postSelectPostActivity != null) {
            this.b = null;
            postSelectPostActivity.postSelectPostBack = null;
            postSelectPostActivity.postSelectPostTopLayout = null;
            postSelectPostActivity.postSelectPostSearchEdit = null;
            postSelectPostActivity.postSelectPostSearchBtu = null;
            postSelectPostActivity.postSelectPostTips = null;
            postSelectPostActivity.postSelectPostListView = null;
            postSelectPostActivity.postSelectPostSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
