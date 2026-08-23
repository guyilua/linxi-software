package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyExperienceActivity_ViewBinding implements Unbinder {
    private Home5MyExperienceActivity b;

    @UiThread
    public Home5MyExperienceActivity_ViewBinding(Home5MyExperienceActivity home5MyExperienceActivity, View view) {
        this.b = home5MyExperienceActivity;
        home5MyExperienceActivity.home5MyExperienceTopBack = (TextView) butterknife.c.a.c(view, R.id.home5_my_experience_top_back, "field 'home5MyExperienceTopBack'", TextView.class);
        home5MyExperienceActivity.home5MyExperienceTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home5_my_experience_top_layout, "field 'home5MyExperienceTopLayout'", LinearLayout.class);
        home5MyExperienceActivity.home5MyExperienceIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.home5_my_experience_icon, "field 'home5MyExperienceIcon'", RoundedImageView.class);
        home5MyExperienceActivity.home5MyExperienceNickName = (TextView) butterknife.c.a.c(view, R.id.home5_my_experience_nickName, "field 'home5MyExperienceNickName'", TextView.class);
        home5MyExperienceActivity.home5MyExperienceLevel = (TextView) butterknife.c.a.c(view, R.id.home5_my_experience_level, "field 'home5MyExperienceLevel'", TextView.class);
        home5MyExperienceActivity.home5MyExperienceProgress = (ProgressBar) butterknife.c.a.c(view, R.id.home5_my_experience_progress, "field 'home5MyExperienceProgress'", ProgressBar.class);
        home5MyExperienceActivity.home5MyExperienceNowEx = (CustomTextView) butterknife.c.a.c(view, R.id.home5_my_experience_now_Ex, "field 'home5MyExperienceNowEx'", CustomTextView.class);
        home5MyExperienceActivity.home5MyExperienceNextLevel = (TextView) butterknife.c.a.c(view, R.id.home5_my_experience_next_level, "field 'home5MyExperienceNextLevel'", TextView.class);
        home5MyExperienceActivity.home5MyExperienceNeedEx = (CustomTextView) butterknife.c.a.c(view, R.id.home5_my_experience_need_Ex, "field 'home5MyExperienceNeedEx'", CustomTextView.class);
        home5MyExperienceActivity.home5MyExperienceTab = (TabLayout) butterknife.c.a.c(view, R.id.home5_my_experience_tab, "field 'home5MyExperienceTab'", TabLayout.class);
        home5MyExperienceActivity.home5MyExperienceBar = (AppBarLayout) butterknife.c.a.c(view, R.id.home5_my_experience_bar, "field 'home5MyExperienceBar'", AppBarLayout.class);
        home5MyExperienceActivity.home5MyExperienceViewpager = (BaseViewPager) butterknife.c.a.c(view, R.id.home5_my_experience_viewpager, "field 'home5MyExperienceViewpager'", BaseViewPager.class);
    }

    @CallSuper
    public void a() {
        Home5MyExperienceActivity home5MyExperienceActivity = this.b;
        if (home5MyExperienceActivity != null) {
            this.b = null;
            home5MyExperienceActivity.home5MyExperienceTopBack = null;
            home5MyExperienceActivity.home5MyExperienceTopLayout = null;
            home5MyExperienceActivity.home5MyExperienceIcon = null;
            home5MyExperienceActivity.home5MyExperienceNickName = null;
            home5MyExperienceActivity.home5MyExperienceLevel = null;
            home5MyExperienceActivity.home5MyExperienceProgress = null;
            home5MyExperienceActivity.home5MyExperienceNowEx = null;
            home5MyExperienceActivity.home5MyExperienceNextLevel = null;
            home5MyExperienceActivity.home5MyExperienceNeedEx = null;
            home5MyExperienceActivity.home5MyExperienceTab = null;
            home5MyExperienceActivity.home5MyExperienceBar = null;
            home5MyExperienceActivity.home5MyExperienceViewpager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
