package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherPostMyReplyFragment_ViewBinding implements Unbinder {
    private OtherPostMyReplyFragment b;

    @UiThread
    public OtherPostMyReplyFragment_ViewBinding(OtherPostMyReplyFragment otherPostMyReplyFragment, View view) {
        this.b = otherPostMyReplyFragment;
        otherPostMyReplyFragment.fragmentMyPostReplyRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_my_post_reply_recyclerView, "field 'fragmentMyPostReplyRecyclerView'", YcRecyclerView.class);
        otherPostMyReplyFragment.fragmentMyPostReplySwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_post_reply_swipeRefresh, "field 'fragmentMyPostReplySwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        OtherPostMyReplyFragment otherPostMyReplyFragment = this.b;
        if (otherPostMyReplyFragment != null) {
            this.b = null;
            otherPostMyReplyFragment.fragmentMyPostReplyRecyclerView = null;
            otherPostMyReplyFragment.fragmentMyPostReplySwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
