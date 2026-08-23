package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalDetailEventActivity_ViewBinding implements Unbinder {
    private MedalDetailEventActivity b;

    @UiThread
    public MedalDetailEventActivity_ViewBinding(MedalDetailEventActivity medalDetailEventActivity, View view) {
        this.b = medalDetailEventActivity;
        medalDetailEventActivity.medalDetaiEventTopBack = (TextView) butterknife.c.a.c(view, R.id.medal_detail_event_top_back, "field 'medalDetaiEventTopBack'", TextView.class);
        medalDetailEventActivity.medalDetaiEventTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.medal_detail_event_top_layout, "field 'medalDetaiEventTopLayout'", LinearLayout.class);
        medalDetailEventActivity.medalDetaiEventViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.medal_detail_event_view_pager, "field 'medalDetaiEventViewPager'", BaseViewPager.class);
        medalDetailEventActivity.medalDetaiEventMedalFlow = (LinearLayout) butterknife.c.a.c(view, R.id.medal_detail_event_medal_flow, "field 'medalDetaiEventMedalFlow'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        MedalDetailEventActivity medalDetailEventActivity = this.b;
        if (medalDetailEventActivity != null) {
            this.b = null;
            medalDetailEventActivity.medalDetaiEventTopBack = null;
            medalDetailEventActivity.medalDetaiEventTopLayout = null;
            medalDetailEventActivity.medalDetaiEventViewPager = null;
            medalDetailEventActivity.medalDetaiEventMedalFlow = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
