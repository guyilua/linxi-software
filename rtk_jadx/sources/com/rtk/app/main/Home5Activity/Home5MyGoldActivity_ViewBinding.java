package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyGoldActivity_ViewBinding implements Unbinder {
    private Home5MyGoldActivity b;

    @UiThread
    public Home5MyGoldActivity_ViewBinding(Home5MyGoldActivity home5MyGoldActivity, View view) {
        this.b = home5MyGoldActivity;
        home5MyGoldActivity.home5MyGoldTopBack = (TextView) butterknife.c.a.c(view, R.id.home5_my_gold_top_back, "field 'home5MyGoldTopBack'", TextView.class);
        home5MyGoldActivity.home5MyGoldTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home5_my_gold_top_layout, "field 'home5MyGoldTopLayout'", LinearLayout.class);
        home5MyGoldActivity.home5MyGoldGoldNum = (TextView) butterknife.c.a.c(view, R.id.home5_my_gold_goldNum, "field 'home5MyGoldGoldNum'", TextView.class);
        home5MyGoldActivity.home5MyGoldAllIncome = (CustomTextView) butterknife.c.a.c(view, R.id.home5_my_gold_all_income, "field 'home5MyGoldAllIncome'", CustomTextView.class);
        home5MyGoldActivity.home5MyGoldAllExpense = (CustomTextView) butterknife.c.a.c(view, R.id.home5_my_gold_all_expense, "field 'home5MyGoldAllExpense'", CustomTextView.class);
        home5MyGoldActivity.home5MyGoldTab = (TabLayout) butterknife.c.a.c(view, R.id.home5_my_gold_tab, "field 'home5MyGoldTab'", TabLayout.class);
        home5MyGoldActivity.home5MyGoldViewpager = (BaseViewPager) butterknife.c.a.c(view, R.id.home5_my_gold_viewpager, "field 'home5MyGoldViewpager'", BaseViewPager.class);
        home5MyGoldActivity.home5MyGoldBar = (AppBarLayout) butterknife.c.a.c(view, R.id.home5_my_gold_bar, "field 'home5MyGoldBar'", AppBarLayout.class);
        home5MyGoldActivity.home5MyGoldTopExplainBtu = (ImageView) butterknife.c.a.c(view, R.id.home5_my_gold_top_explain_btu, "field 'home5MyGoldTopExplainBtu'", ImageView.class);
    }

    @CallSuper
    public void a() {
        Home5MyGoldActivity home5MyGoldActivity = this.b;
        if (home5MyGoldActivity != null) {
            this.b = null;
            home5MyGoldActivity.home5MyGoldTopBack = null;
            home5MyGoldActivity.home5MyGoldTopLayout = null;
            home5MyGoldActivity.home5MyGoldGoldNum = null;
            home5MyGoldActivity.home5MyGoldAllIncome = null;
            home5MyGoldActivity.home5MyGoldAllExpense = null;
            home5MyGoldActivity.home5MyGoldTab = null;
            home5MyGoldActivity.home5MyGoldViewpager = null;
            home5MyGoldActivity.home5MyGoldBar = null;
            home5MyGoldActivity.home5MyGoldTopExplainBtu = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
