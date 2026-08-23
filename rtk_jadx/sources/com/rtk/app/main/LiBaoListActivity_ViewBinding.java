package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LiBaoListActivity_ViewBinding implements Unbinder {
    private LiBaoListActivity b;

    @UiThread
    public LiBaoListActivity_ViewBinding(LiBaoListActivity liBaoListActivity, View view) {
        this.b = liBaoListActivity;
        liBaoListActivity.libaoListTitle = (TextView) butterknife.c.a.c(view, R.id.libao_list_title, "field 'libaoListTitle'", TextView.class);
        liBaoListActivity.libaoListMyLibao = (TextView) butterknife.c.a.c(view, R.id.libao_list_myLibao, "field 'libaoListMyLibao'", TextView.class);
        liBaoListActivity.libaoListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.libao_list_layout, "field 'libaoListLayout'", LinearLayout.class);
        liBaoListActivity.libaoListTablayout = (TabLayout) butterknife.c.a.c(view, R.id.libao_list_tablayout, "field 'libaoListTablayout'", TabLayout.class);
        liBaoListActivity.libaoListViewPager = (ViewPager) butterknife.c.a.c(view, R.id.libao_list_viewPager, "field 'libaoListViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        LiBaoListActivity liBaoListActivity = this.b;
        if (liBaoListActivity != null) {
            this.b = null;
            liBaoListActivity.libaoListTitle = null;
            liBaoListActivity.libaoListMyLibao = null;
            liBaoListActivity.libaoListLayout = null;
            liBaoListActivity.libaoListTablayout = null;
            liBaoListActivity.libaoListViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
