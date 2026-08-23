package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.EditText;
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
public class PostSearchActivity_ViewBinding implements Unbinder {
    private PostSearchActivity b;

    @UiThread
    public PostSearchActivity_ViewBinding(PostSearchActivity postSearchActivity, View view) {
        this.b = postSearchActivity;
        postSearchActivity.postSearchBack = (TextView) butterknife.c.a.c(view, R.id.post_search_back, "field 'postSearchBack'", TextView.class);
        postSearchActivity.postSearchSearchEdit = (EditText) butterknife.c.a.c(view, R.id.post_search_searchEdit, "field 'postSearchSearchEdit'", EditText.class);
        postSearchActivity.postSearchSearchBtu = (ImageView) butterknife.c.a.c(view, R.id.post_search_searchBtu, "field 'postSearchSearchBtu'", ImageView.class);
        postSearchActivity.postSearchTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.post_search_top_layout, "field 'postSearchTopLayout'", LinearLayout.class);
        postSearchActivity.postSearchRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.post_search_recyclerView, "field 'postSearchRecyclerView'", YcRecyclerView.class);
        postSearchActivity.postSearchThisModule = (TextView) butterknife.c.a.c(view, R.id.post_search_thisModule, "field 'postSearchThisModule'", TextView.class);
        postSearchActivity.postSearchSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.post_search_swipeRefresh, "field 'postSearchSwipeRefresh'", SwipeRefreshLayout.class);
        postSearchActivity.postSearchHistoryLayout = butterknife.c.a.b(view, R.id.post_search_history_layout, "field 'postSearchHistoryLayout'");
        postSearchActivity.searchHistoryClear = (TextView) butterknife.c.a.c(view, R.id.search_history_clear, "field 'searchHistoryClear'", TextView.class);
        postSearchActivity.postSearchParent = (LinearLayout) butterknife.c.a.c(view, R.id.post_search_parent, "field 'postSearchParent'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        PostSearchActivity postSearchActivity = this.b;
        if (postSearchActivity != null) {
            this.b = null;
            postSearchActivity.postSearchBack = null;
            postSearchActivity.postSearchSearchEdit = null;
            postSearchActivity.postSearchSearchBtu = null;
            postSearchActivity.postSearchTopLayout = null;
            postSearchActivity.postSearchRecyclerView = null;
            postSearchActivity.postSearchThisModule = null;
            postSearchActivity.postSearchSwipeRefresh = null;
            postSearchActivity.postSearchHistoryLayout = null;
            postSearchActivity.searchHistoryClear = null;
            postSearchActivity.postSearchParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
