package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.FixedViewPager;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpMyAttentionActivity_ViewBinding implements Unbinder {
    private HomeUpMyAttentionActivity b;

    @UiThread
    public HomeUpMyAttentionActivity_ViewBinding(HomeUpMyAttentionActivity homeUpMyAttentionActivity, View view) {
        this.b = homeUpMyAttentionActivity;
        homeUpMyAttentionActivity.homeUpMyAttentionTopBack = (TextView) butterknife.c.a.c(view, R.id.home_up_my_attention_top_back, "field 'homeUpMyAttentionTopBack'", TextView.class);
        homeUpMyAttentionActivity.homeUpMyAttentionTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.home_up_my_attention_top_download, "field 'homeUpMyAttentionTopDownload'", MarkedImageView.class);
        homeUpMyAttentionActivity.homeUpMyAttentionTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_my_attention_top_layout, "field 'homeUpMyAttentionTopLayout'", LinearLayout.class);
        homeUpMyAttentionActivity.homeUpMyAttentionViewPager = (FixedViewPager) butterknife.c.a.c(view, R.id.home_up_my_attention_viewPager, "field 'homeUpMyAttentionViewPager'", FixedViewPager.class);
    }

    @CallSuper
    public void a() {
        HomeUpMyAttentionActivity homeUpMyAttentionActivity = this.b;
        if (homeUpMyAttentionActivity != null) {
            this.b = null;
            homeUpMyAttentionActivity.homeUpMyAttentionTopBack = null;
            homeUpMyAttentionActivity.homeUpMyAttentionTopDownload = null;
            homeUpMyAttentionActivity.homeUpMyAttentionTopLayout = null;
            homeUpMyAttentionActivity.homeUpMyAttentionViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
