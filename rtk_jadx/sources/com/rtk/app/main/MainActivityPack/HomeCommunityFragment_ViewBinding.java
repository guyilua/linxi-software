package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcSwipeRefreshLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeCommunityFragment_ViewBinding implements Unbinder {
    private HomeCommunityFragment b;

    @UiThread
    public HomeCommunityFragment_ViewBinding(HomeCommunityFragment homeCommunityFragment, View view) {
        this.b = homeCommunityFragment;
        homeCommunityFragment.homeCommunityFragmentRecyclerView = (RecyclerView) butterknife.c.a.c(view, R.id.home_community_fragment_recyclerView, "field 'homeCommunityFragmentRecyclerView'", RecyclerView.class);
        homeCommunityFragment.homeCommunityFragmentParemtLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_community_fragment_parent_layout, "field 'homeCommunityFragmentParemtLayout'", LinearLayout.class);
        homeCommunityFragment.homeCommunitySwipRefreshLayout = (YcSwipeRefreshLayout) butterknife.c.a.c(view, R.id.home_community_swipRefreshLayout, "field 'homeCommunitySwipRefreshLayout'", YcSwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        HomeCommunityFragment homeCommunityFragment = this.b;
        if (homeCommunityFragment != null) {
            this.b = null;
            homeCommunityFragment.homeCommunityFragmentRecyclerView = null;
            homeCommunityFragment.homeCommunityFragmentParemtLayout = null;
            homeCommunityFragment.homeCommunitySwipRefreshLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
