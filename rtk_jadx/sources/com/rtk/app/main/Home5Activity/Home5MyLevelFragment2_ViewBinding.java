package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyLevelFragment2_ViewBinding implements Unbinder {
    private Home5MyLevelFragment2 b;

    @UiThread
    public Home5MyLevelFragment2_ViewBinding(Home5MyLevelFragment2 home5MyLevelFragment2, View view) {
        this.b = home5MyLevelFragment2;
        home5MyLevelFragment2.myLevelFragmentRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'myLevelFragmentRecyclerView'", YcRecyclerView.class);
        home5MyLevelFragment2.myLevelFragmentSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'myLevelFragmentSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        Home5MyLevelFragment2 home5MyLevelFragment2 = this.b;
        if (home5MyLevelFragment2 != null) {
            this.b = null;
            home5MyLevelFragment2.myLevelFragmentRecyclerView = null;
            home5MyLevelFragment2.myLevelFragmentSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
