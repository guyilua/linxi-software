package com.rtk.app.main.family;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCoinDetailActivity_ViewBinding implements Unbinder {
    private FamilyCoinDetailActivity b;

    @UiThread
    public FamilyCoinDetailActivity_ViewBinding(FamilyCoinDetailActivity familyCoinDetailActivity, View view) {
        this.b = familyCoinDetailActivity;
        familyCoinDetailActivity.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        familyCoinDetailActivity.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
        familyCoinDetailActivity.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
        familyCoinDetailActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
    }

    @CallSuper
    public void a() {
        FamilyCoinDetailActivity familyCoinDetailActivity = this.b;
        if (familyCoinDetailActivity != null) {
            this.b = null;
            familyCoinDetailActivity.fragmentForRecyclerviewLayoutListView = null;
            familyCoinDetailActivity.fragmentForRecyclerviewParentLayout = null;
            familyCoinDetailActivity.fragmentMyGoldLayoutSwipeRefresh = null;
            familyCoinDetailActivity.backLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
