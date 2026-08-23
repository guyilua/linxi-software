package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyContributeFragment_ViewBinding implements Unbinder {
    private Home5MyContributeFragment b;

    @UiThread
    public Home5MyContributeFragment_ViewBinding(Home5MyContributeFragment home5MyContributeFragment, View view) {
        this.b = home5MyContributeFragment;
        home5MyContributeFragment.fragmentMyGoldLayoutRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentMyGoldLayoutRecyclerView'", YcRecyclerView.class);
        home5MyContributeFragment.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        Home5MyContributeFragment home5MyContributeFragment = this.b;
        if (home5MyContributeFragment != null) {
            this.b = null;
            home5MyContributeFragment.fragmentMyGoldLayoutRecyclerView = null;
            home5MyContributeFragment.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
