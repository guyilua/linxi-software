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
public class MyPostAttentionFragment_ViewBinding implements Unbinder {
    private MyPostAttentionFragment b;

    @UiThread
    public MyPostAttentionFragment_ViewBinding(MyPostAttentionFragment myPostAttentionFragment, View view) {
        this.b = myPostAttentionFragment;
        myPostAttentionFragment.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        myPostAttentionFragment.fragmentForRecyclerviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_parent_layout, "field 'fragmentForRecyclerviewParentLayout'", LinearLayout.class);
        myPostAttentionFragment.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        MyPostAttentionFragment myPostAttentionFragment = this.b;
        if (myPostAttentionFragment != null) {
            this.b = null;
            myPostAttentionFragment.fragmentForRecyclerviewLayoutListView = null;
            myPostAttentionFragment.fragmentForRecyclerviewParentLayout = null;
            myPostAttentionFragment.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
