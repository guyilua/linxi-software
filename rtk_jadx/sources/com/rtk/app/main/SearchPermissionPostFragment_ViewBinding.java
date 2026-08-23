package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPermissionPostFragment_ViewBinding implements Unbinder {
    private SearchPermissionPostFragment b;

    @UiThread
    public SearchPermissionPostFragment_ViewBinding(SearchPermissionPostFragment searchPermissionPostFragment, View view) {
        this.b = searchPermissionPostFragment;
        searchPermissionPostFragment.searchHasPermissionPostRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.search_has_permission_post_recyclerView, "field 'searchHasPermissionPostRecyclerView'", YcRecyclerView.class);
        searchPermissionPostFragment.searchHasPermissionPostParent = (LinearLayout) butterknife.c.a.c(view, R.id.search_has_permission_post_parent, "field 'searchHasPermissionPostParent'", LinearLayout.class);
        searchPermissionPostFragment.searchHasPermissionPostSwipeRefreshLayout = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.search_has_permission_post_swipeRefreshLayout, "field 'searchHasPermissionPostSwipeRefreshLayout'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        SearchPermissionPostFragment searchPermissionPostFragment = this.b;
        if (searchPermissionPostFragment != null) {
            this.b = null;
            searchPermissionPostFragment.searchHasPermissionPostRecyclerView = null;
            searchPermissionPostFragment.searchHasPermissionPostParent = null;
            searchPermissionPostFragment.searchHasPermissionPostSwipeRefreshLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
