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
public class MedalDetailAchievementActivity_ViewBinding implements Unbinder {
    private MedalDetailAchievementActivity b;

    @UiThread
    public MedalDetailAchievementActivity_ViewBinding(MedalDetailAchievementActivity medalDetailAchievementActivity, View view) {
        this.b = medalDetailAchievementActivity;
        medalDetailAchievementActivity.medalDetaiAchievementTopBack = (TextView) butterknife.c.a.c(view, R.id.medal_detail_achievement_top_back, "field 'medalDetaiAchievementTopBack'", TextView.class);
        medalDetailAchievementActivity.medalDetaiAchievementTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.medal_detail_achievement_top_layout, "field 'medalDetaiAchievementTopLayout'", LinearLayout.class);
        medalDetailAchievementActivity.medalDetaiAchievementViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.medal_detail_achievement_view_pager, "field 'medalDetaiAchievementViewPager'", BaseViewPager.class);
        medalDetailAchievementActivity.medalDetaiAchievementMedalFlow = (LinearLayout) butterknife.c.a.c(view, R.id.medal_detail_achievement_medal_flow, "field 'medalDetaiAchievementMedalFlow'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        MedalDetailAchievementActivity medalDetailAchievementActivity = this.b;
        if (medalDetailAchievementActivity != null) {
            this.b = null;
            medalDetailAchievementActivity.medalDetaiAchievementTopBack = null;
            medalDetailAchievementActivity.medalDetaiAchievementTopLayout = null;
            medalDetailAchievementActivity.medalDetaiAchievementViewPager = null;
            medalDetailAchievementActivity.medalDetaiAchievementMedalFlow = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
