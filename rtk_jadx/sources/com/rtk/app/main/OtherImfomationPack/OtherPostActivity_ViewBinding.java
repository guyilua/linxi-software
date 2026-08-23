package com.rtk.app.main.OtherImfomationPack;

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
public class OtherPostActivity_ViewBinding implements Unbinder {
    private OtherPostActivity b;

    @UiThread
    public OtherPostActivity_ViewBinding(OtherPostActivity otherPostActivity, View view) {
        this.b = otherPostActivity;
        otherPostActivity.otherPostListTopBack = (TextView) butterknife.c.a.c(view, R.id.other_post_list_topBack, "field 'otherPostListTopBack'", TextView.class);
        otherPostActivity.otherPostListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.other_post_list_topLayout, "field 'otherPostListTopLayout'", LinearLayout.class);
        otherPostActivity.otherPostListRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.other_post_list_recyclerView, "field 'otherPostListRecyclerView'", YcRecyclerView.class);
        otherPostActivity.otherPostListSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.other_post_list_swipeRefresh, "field 'otherPostListSwipeRefresh'", SwipeRefreshLayout.class);
    }

    @CallSuper
    public void a() {
        OtherPostActivity otherPostActivity = this.b;
        if (otherPostActivity != null) {
            this.b = null;
            otherPostActivity.otherPostListTopBack = null;
            otherPostActivity.otherPostListTopLayout = null;
            otherPostActivity.otherPostListRecyclerView = null;
            otherPostActivity.otherPostListSwipeRefresh = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
