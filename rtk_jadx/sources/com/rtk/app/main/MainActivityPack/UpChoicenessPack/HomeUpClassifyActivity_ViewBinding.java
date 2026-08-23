package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.GridViewForScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpClassifyActivity_ViewBinding implements Unbinder {
    private HomeUpClassifyActivity b;

    @UiThread
    public HomeUpClassifyActivity_ViewBinding(HomeUpClassifyActivity homeUpClassifyActivity, View view) {
        this.b = homeUpClassifyActivity;
        homeUpClassifyActivity.homeUpClassifyGameGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.home_up_classify_game_gridView, "field 'homeUpClassifyGameGridView'", GridViewForScrollView.class);
        homeUpClassifyActivity.homeUpClassifySoftGridView = (GridViewForScrollView) butterknife.c.a.c(view, R.id.home_up_classify_soft_gridView, "field 'homeUpClassifySoftGridView'", GridViewForScrollView.class);
        homeUpClassifyActivity.homeUpClassifySwipeLayout = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.home_up_classify_swipeLayout, "field 'homeUpClassifySwipeLayout'", SwipeRefreshLayout.class);
        homeUpClassifyActivity.homeUpClassifyTopBack = (TextView) butterknife.c.a.c(view, R.id.home_up_classify_topBack, "field 'homeUpClassifyTopBack'", TextView.class);
        homeUpClassifyActivity.homeUpClassifyTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_classify_topLayout, "field 'homeUpClassifyTopLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        HomeUpClassifyActivity homeUpClassifyActivity = this.b;
        if (homeUpClassifyActivity != null) {
            this.b = null;
            homeUpClassifyActivity.homeUpClassifyGameGridView = null;
            homeUpClassifyActivity.homeUpClassifySoftGridView = null;
            homeUpClassifyActivity.homeUpClassifySwipeLayout = null;
            homeUpClassifyActivity.homeUpClassifyTopBack = null;
            homeUpClassifyActivity.homeUpClassifyTopLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
