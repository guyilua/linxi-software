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
public class MyFamilyPostFragment_ViewBinding implements Unbinder {
    private MyFamilyPostFragment b;

    @UiThread
    public MyFamilyPostFragment_ViewBinding(MyFamilyPostFragment myFamilyPostFragment, View view) {
        this.b = myFamilyPostFragment;
        myFamilyPostFragment.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        myFamilyPostFragment.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
        myFamilyPostFragment.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        MyFamilyPostFragment myFamilyPostFragment = this.b;
        if (myFamilyPostFragment != null) {
            this.b = null;
            myFamilyPostFragment.fragmentForRecyclerviewLayoutListView = null;
            myFamilyPostFragment.fragmentForRecyclerviewParentLayout = null;
            myFamilyPostFragment.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
