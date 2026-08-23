package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPostFragment_ViewBinding implements Unbinder {
    private SearchPostFragment b;

    @UiThread
    public SearchPostFragment_ViewBinding(SearchPostFragment searchPostFragment, View view) {
        this.b = searchPostFragment;
        searchPostFragment.searchPostFragmentSwipeRefreshLayout = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.search_post_fragment_swipeRefreshLayout, "field 'searchPostFragmentSwipeRefreshLayout'", SwipeRefreshLayout.class);
        searchPostFragment.searchHistoryView = butterknife.c.a.b(view, R.id.search_history_layout, "field 'searchHistoryView'");
        searchPostFragment.searchPostFragmentForModule = (TextView) butterknife.c.a.c(view, R.id.search_post_fragment_for_module, "field 'searchPostFragmentForModule'", TextView.class);
        searchPostFragment.searchPostFragmentRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.search_post_fragment_recyclerView, "field 'searchPostFragmentRecyclerView'", YcRecyclerView.class);
        searchPostFragment.searchPostFragmentParent = (LinearLayout) butterknife.c.a.c(view, R.id.search_post_fragment_parent, "field 'searchPostFragmentParent'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        SearchPostFragment searchPostFragment = this.b;
        if (searchPostFragment != null) {
            this.b = null;
            searchPostFragment.searchPostFragmentSwipeRefreshLayout = null;
            searchPostFragment.searchHistoryView = null;
            searchPostFragment.searchPostFragmentForModule = null;
            searchPostFragment.searchPostFragmentRecyclerView = null;
            searchPostFragment.searchPostFragmentParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
