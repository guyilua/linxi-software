package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCollectFragmentForPost_ViewBinding implements Unbinder {
    private MyCollectFragmentForPost b;

    @UiThread
    public MyCollectFragmentForPost_ViewBinding(MyCollectFragmentForPost myCollectFragmentForPost, View view) {
        this.b = myCollectFragmentForPost;
        myCollectFragmentForPost.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        myCollectFragmentForPost.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
        myCollectFragmentForPost.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        MyCollectFragmentForPost myCollectFragmentForPost = this.b;
        if (myCollectFragmentForPost != null) {
            this.b = null;
            myCollectFragmentForPost.fragmentForRecyclerviewLayoutListView = null;
            myCollectFragmentForPost.fragmentMyGoldLayoutSwipeRefresh = null;
            myCollectFragmentForPost.fragmentForRecyclerviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
