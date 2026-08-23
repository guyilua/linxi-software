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
public class FamilyUpFragment_ViewBinding implements Unbinder {
    private FamilyUpFragment b;

    @UiThread
    public FamilyUpFragment_ViewBinding(FamilyUpFragment familyUpFragment, View view) {
        this.b = familyUpFragment;
        familyUpFragment.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        familyUpFragment.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
        familyUpFragment.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        FamilyUpFragment familyUpFragment = this.b;
        if (familyUpFragment != null) {
            this.b = null;
            familyUpFragment.fragmentForRecyclerviewLayoutListView = null;
            familyUpFragment.fragmentForRecyclerviewParentLayout = null;
            familyUpFragment.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
