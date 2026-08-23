package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.GridViewForScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeClassicsGameClassifyFragment_ViewBinding implements Unbinder {
    private HomeClassicsGameClassifyFragment b;

    @UiThread
    public HomeClassicsGameClassifyFragment_ViewBinding(HomeClassicsGameClassifyFragment homeClassicsGameClassifyFragment, View view) {
        this.b = homeClassicsGameClassifyFragment;
        homeClassicsGameClassifyFragment.homeClassicsGameClassifyLayoutParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_classics_game_classify_layout_parent_layout, "field 'homeClassicsGameClassifyLayoutParentLayout'", LinearLayout.class);
        homeClassicsGameClassifyFragment.homeClassicsGameClassifyLayoutNormalGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.home_classics_game_classify_layout_normal_gridView, "field 'homeClassicsGameClassifyLayoutNormalGridView'", GridViewForScrollView.class);
        homeClassicsGameClassifyFragment.homeClassicsGameClassifyLayoutFeatureGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.home_classics_game_classify_layout_feature_gridView, "field 'homeClassicsGameClassifyLayoutFeatureGridView'", GridViewForScrollView.class);
        homeClassicsGameClassifyFragment.homeClassicsGameClassifySwipeLayout = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.home_classics_game_classify_swipeLayout, "field 'homeClassicsGameClassifySwipeLayout'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        HomeClassicsGameClassifyFragment homeClassicsGameClassifyFragment = this.b;
        if (homeClassicsGameClassifyFragment != null) {
            this.b = null;
            homeClassicsGameClassifyFragment.homeClassicsGameClassifyLayoutParentLayout = null;
            homeClassicsGameClassifyFragment.homeClassicsGameClassifyLayoutNormalGridView = null;
            homeClassicsGameClassifyFragment.homeClassicsGameClassifyLayoutFeatureGridView = null;
            homeClassicsGameClassifyFragment.homeClassicsGameClassifySwipeLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
