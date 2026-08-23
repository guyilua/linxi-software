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
public class HomeGameItem1Fragment_ViewBinding implements Unbinder {
    private HomeGameItem1Fragment b;

    @UiThread
    public HomeGameItem1Fragment_ViewBinding(HomeGameItem1Fragment homeGameItem1Fragment, View view) {
        this.b = homeGameItem1Fragment;
        homeGameItem1Fragment.home1Item1RecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.home1_item1_recyclerView, "field 'home1Item1RecyclerView'", YcRecyclerView.class);
        homeGameItem1Fragment.home1Item1Swiprefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.home1_item1_swiprefresh, "field 'home1Item1Swiprefresh'", SwipeRefreshLayout.class);
        homeGameItem1Fragment.home1Item1Parent = (LinearLayout) butterknife.c.a.c(view, R.id.home1_item1_parent, "field 'home1Item1Parent'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        HomeGameItem1Fragment homeGameItem1Fragment = this.b;
        if (homeGameItem1Fragment != null) {
            this.b = null;
            homeGameItem1Fragment.home1Item1RecyclerView = null;
            homeGameItem1Fragment.home1Item1Swiprefresh = null;
            homeGameItem1Fragment.home1Item1Parent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
