package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostMyReplyFragment_ViewBinding implements Unbinder {
    private MyPostMyReplyFragment b;

    @UiThread
    public MyPostMyReplyFragment_ViewBinding(MyPostMyReplyFragment myPostMyReplyFragment, View view) {
        this.b = myPostMyReplyFragment;
        myPostMyReplyFragment.fragmentMyPostReplyRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.fragment_my_post_reply_recyclerView, "field 'fragmentMyPostReplyRecyclerView'", YcRecyclerView.class);
        myPostMyReplyFragment.fragmentMyPostReplySwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.fragment_my_post_reply_swipeRefresh, "field 'fragmentMyPostReplySwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        MyPostMyReplyFragment myPostMyReplyFragment = this.b;
        if (myPostMyReplyFragment != null) {
            this.b = null;
            myPostMyReplyFragment.fragmentMyPostReplyRecyclerView = null;
            myPostMyReplyFragment.fragmentMyPostReplySwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
