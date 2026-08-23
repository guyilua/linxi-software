package com.rtk.app.main.Home5Activity;

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
public class MyPostListActivity_ViewBinding implements Unbinder {
    private MyPostListActivity b;

    @UiThread
    public MyPostListActivity_ViewBinding(MyPostListActivity myPostListActivity, View view) {
        this.b = myPostListActivity;
        myPostListActivity.myPostListTopBack = (TextView) butterknife.c.a.c(view, R.id.my_post_list_topBack, "field 'myPostListTopBack'", TextView.class);
        myPostListActivity.myPostListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_post_list_topLayout, "field 'myPostListTopLayout'", LinearLayout.class);
        myPostListActivity.myPostListRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.my_post_list_recyclerView, "field 'myPostListRecyclerView'", YcRecyclerView.class);
        myPostListActivity.myPostListSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.my_post_list_swipeRefresh, "field 'myPostListSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        MyPostListActivity myPostListActivity = this.b;
        if (myPostListActivity != null) {
            this.b = null;
            myPostListActivity.myPostListTopBack = null;
            myPostListActivity.myPostListTopLayout = null;
            myPostListActivity.myPostListRecyclerView = null;
            myPostListActivity.myPostListSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
