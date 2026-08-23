package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.GridViewForScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeParticularGameClassifyFragment_ViewBinding implements Unbinder {
    private HomeParticularGameClassifyFragment b;

    @UiThread
    public HomeParticularGameClassifyFragment_ViewBinding(HomeParticularGameClassifyFragment homeParticularGameClassifyFragment, View view) {
        this.b = homeParticularGameClassifyFragment;
        homeParticularGameClassifyFragment.homeParticularGameClassifySwipeRefreshLayout = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.home_particular_game_classify_swipeRefreshLayout, "field 'homeParticularGameClassifySwipeRefreshLayout'", SwipeRefreshLayout.class);
        homeParticularGameClassifyFragment.homeParticularGameClassifyGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.home_particular_game_classify_gridView, "field 'homeParticularGameClassifyGridView'", GridViewForScrollView.class);
        homeParticularGameClassifyFragment.homeParticularGameClassifyListview = (ListView) butterknife.c.a.c(view, R.id.home_particular_game_classify_listview, "field 'homeParticularGameClassifyListview'", ListView.class);
    }

    @CallSuper
    public void a() {
        HomeParticularGameClassifyFragment homeParticularGameClassifyFragment = this.b;
        if (homeParticularGameClassifyFragment != null) {
            this.b = null;
            homeParticularGameClassifyFragment.homeParticularGameClassifySwipeRefreshLayout = null;
            homeParticularGameClassifyFragment.homeParticularGameClassifyGridView = null;
            homeParticularGameClassifyFragment.homeParticularGameClassifyListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
