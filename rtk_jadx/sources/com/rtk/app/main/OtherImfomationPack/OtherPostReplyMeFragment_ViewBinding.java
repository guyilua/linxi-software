package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherPostReplyMeFragment_ViewBinding implements Unbinder {
    private OtherPostReplyMeFragment b;

    @UiThread
    public OtherPostReplyMeFragment_ViewBinding(OtherPostReplyMeFragment otherPostReplyMeFragment, View view) {
        this.b = otherPostReplyMeFragment;
        otherPostReplyMeFragment.fragmentMyPostCommentRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_my_post_comment_recyclerView, "field 'fragmentMyPostCommentRecyclerView'", YcRecyclerView.class);
        otherPostReplyMeFragment.fragmentMyPostCommentSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_post_comment_swipeRefresh, "field 'fragmentMyPostCommentSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        OtherPostReplyMeFragment otherPostReplyMeFragment = this.b;
        if (otherPostReplyMeFragment != null) {
            this.b = null;
            otherPostReplyMeFragment.fragmentMyPostCommentRecyclerView = null;
            otherPostReplyMeFragment.fragmentMyPostCommentSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
