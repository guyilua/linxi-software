package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostAttentionActivity_ViewBinding implements Unbinder {
    private MyPostAttentionActivity b;

    @UiThread
    public MyPostAttentionActivity_ViewBinding(MyPostAttentionActivity myPostAttentionActivity, View view) {
        this.b = myPostAttentionActivity;
        myPostAttentionActivity.myPostAttentionBack = (TextView) butterknife.c.a.c(view, R.id.my_post_attention_back, "field 'myPostAttentionBack'", TextView.class);
        myPostAttentionActivity.myPostAttentionLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_post_attention_layout, "field 'myPostAttentionLayout'", LinearLayout.class);
        myPostAttentionActivity.myPostAttentionRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.my_post_attention_recyclerView, "field 'myPostAttentionRecyclerView'", YcRecyclerView.class);
        myPostAttentionActivity.myPostAttentionSwipeLayout = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.my_post_attention_swipeLayout, "field 'myPostAttentionSwipeLayout'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        MyPostAttentionActivity myPostAttentionActivity = this.b;
        if (myPostAttentionActivity != null) {
            this.b = null;
            myPostAttentionActivity.myPostAttentionBack = null;
            myPostAttentionActivity.myPostAttentionLayout = null;
            myPostAttentionActivity.myPostAttentionRecyclerView = null;
            myPostAttentionActivity.myPostAttentionSwipeLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
