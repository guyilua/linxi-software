package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageItemAttention_ViewBinding implements Unbinder {
    private HomePageItemAttention b;

    @UiThread
    public HomePageItemAttention_ViewBinding(HomePageItemAttention homePageItemAttention, View view) {
        this.b = homePageItemAttention;
        homePageItemAttention.homePageItemAttentionTabLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_page_item_attention_tab_layout, "field 'homePageItemAttentionTabLayout'", LinearLayout.class);
        homePageItemAttention.homePageItemAttentionTab = (TabLayout) butterknife.c.a.c(view, R.id.home_page_item_attention_tab, "field 'homePageItemAttentionTab'", TabLayout.class);
        homePageItemAttention.homePageItemAttentionViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.home_page_item_attention_viewPager, "field 'homePageItemAttentionViewPager'", BaseViewPager.class);
    }

    @CallSuper
    public void a() {
        HomePageItemAttention homePageItemAttention = this.b;
        if (homePageItemAttention != null) {
            this.b = null;
            homePageItemAttention.homePageItemAttentionTabLayout = null;
            homePageItemAttention.homePageItemAttentionTab = null;
            homePageItemAttention.homePageItemAttentionViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
