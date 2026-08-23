package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalActivity_ViewBinding implements Unbinder {
    private MedalActivity b;

    @UiThread
    public MedalActivity_ViewBinding(MedalActivity medalActivity, View view) {
        this.b = medalActivity;
        medalActivity.medalTopBack = (TextView) butterknife.c.a.c(view, R.id.medal_top_back, "field 'medalTopBack'", TextView.class);
        medalActivity.medalTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.medal_top_layout, "field 'medalTopLayout'", LinearLayout.class);
        medalActivity.medalParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.medal_parent_layout, "field 'medalParentLayout'", LinearLayout.class);
        medalActivity.medalRecyclerView = (RecyclerView) butterknife.c.a.c(view, R.id.medal_recyclerView, "field 'medalRecyclerView'", RecyclerView.class);
        medalActivity.medalHeadView = (LinearLayout) butterknife.c.a.c(view, R.id.medal_head_view, "field 'medalHeadView'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        MedalActivity medalActivity = this.b;
        if (medalActivity != null) {
            this.b = null;
            medalActivity.medalTopBack = null;
            medalActivity.medalTopLayout = null;
            medalActivity.medalParentLayout = null;
            medalActivity.medalRecyclerView = null;
            medalActivity.medalHeadView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
