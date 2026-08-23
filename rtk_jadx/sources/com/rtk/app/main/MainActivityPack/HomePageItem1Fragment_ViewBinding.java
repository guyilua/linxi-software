package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageItem1Fragment_ViewBinding implements Unbinder {
    private HomePageItem1Fragment b;

    @UiThread
    public HomePageItem1Fragment_ViewBinding(HomePageItem1Fragment homePageItem1Fragment, View view) {
        this.b = homePageItem1Fragment;
        homePageItem1Fragment.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        homePageItem1Fragment.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
        homePageItem1Fragment.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        HomePageItem1Fragment homePageItem1Fragment = this.b;
        if (homePageItem1Fragment != null) {
            this.b = null;
            homePageItem1Fragment.fragmentForRecyclerviewLayoutListView = null;
            homePageItem1Fragment.fragmentForRecyclerviewParentLayout = null;
            homePageItem1Fragment.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
