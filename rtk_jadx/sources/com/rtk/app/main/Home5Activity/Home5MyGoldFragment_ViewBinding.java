package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyGoldFragment_ViewBinding implements Unbinder {
    private Home5MyGoldFragment b;

    @UiThread
    public Home5MyGoldFragment_ViewBinding(Home5MyGoldFragment home5MyGoldFragment, View view) {
        this.b = home5MyGoldFragment;
        home5MyGoldFragment.fragmentMyGoldLayoutRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentMyGoldLayoutRecyclerView'", YcRecyclerView.class);
        home5MyGoldFragment.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        Home5MyGoldFragment home5MyGoldFragment = this.b;
        if (home5MyGoldFragment != null) {
            this.b = null;
            home5MyGoldFragment.fragmentMyGoldLayoutRecyclerView = null;
            home5MyGoldFragment.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
