package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCollectFragmentForPost_ViewBinding implements Unbinder {
    private OtherCollectFragmentForPost b;

    @UiThread
    public OtherCollectFragmentForPost_ViewBinding(OtherCollectFragmentForPost otherCollectFragmentForPost, View view) {
        this.b = otherCollectFragmentForPost;
        otherCollectFragmentForPost.fragmentForRecyclerviewLayoutListView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_for_recyclerview_layout_listView, "field 'fragmentForRecyclerviewLayoutListView'", YcRecyclerView.class);
        otherCollectFragmentForPost.fragmentMyGoldLayoutSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_gold_layout_swipeRefresh, "field 'fragmentMyGoldLayoutSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        OtherCollectFragmentForPost otherCollectFragmentForPost = this.b;
        if (otherCollectFragmentForPost != null) {
            this.b = null;
            otherCollectFragmentForPost.fragmentForRecyclerviewLayoutListView = null;
            otherCollectFragmentForPost.fragmentMyGoldLayoutSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
