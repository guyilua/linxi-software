package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpExampleListFragment_ViewBinding implements Unbinder {
    private HomeUpExampleListFragment b;

    @UiThread
    public HomeUpExampleListFragment_ViewBinding(HomeUpExampleListFragment homeUpExampleListFragment, View view) {
        this.b = homeUpExampleListFragment;
        homeUpExampleListFragment.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        homeUpExampleListFragment.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
        homeUpExampleListFragment.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        HomeUpExampleListFragment homeUpExampleListFragment = this.b;
        if (homeUpExampleListFragment != null) {
            this.b = null;
            homeUpExampleListFragment.fragmentForRecyclerviewLayoutListView = null;
            homeUpExampleListFragment.fragmentForRecyclerviewParentLayout = null;
            homeUpExampleListFragment.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
