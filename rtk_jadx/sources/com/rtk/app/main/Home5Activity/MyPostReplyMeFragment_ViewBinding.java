package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostReplyMeFragment_ViewBinding implements Unbinder {
    private MyPostReplyMeFragment b;

    @UiThread
    public MyPostReplyMeFragment_ViewBinding(MyPostReplyMeFragment myPostReplyMeFragment, View view) {
        this.b = myPostReplyMeFragment;
        myPostReplyMeFragment.fragmentMyPostCommentRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_my_post_comment_recyclerView, "field 'fragmentMyPostCommentRecyclerView'", YcRecyclerView.class);
        myPostReplyMeFragment.fragmentMyPostCommentSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_post_comment_swipeRefresh, "field 'fragmentMyPostCommentSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        MyPostReplyMeFragment myPostReplyMeFragment = this.b;
        if (myPostReplyMeFragment != null) {
            this.b = null;
            myPostReplyMeFragment.fragmentMyPostCommentRecyclerView = null;
            myPostReplyMeFragment.fragmentMyPostCommentSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
