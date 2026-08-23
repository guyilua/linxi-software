package com.rtk.app.main.Home5Activity;

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
public class MyLibaoActivity_ViewBinding implements Unbinder {
    private MyLibaoActivity b;

    @UiThread
    public MyLibaoActivity_ViewBinding(MyLibaoActivity myLibaoActivity, View view) {
        this.b = myLibaoActivity;
        myLibaoActivity.myLibaoBack = (TextView) butterknife.c.a.c(view, R.id.my_libao_back, "field 'myLibaoBack'", TextView.class);
        myLibaoActivity.myLibaoTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_libao_top_layout, "field 'myLibaoTopLayout'", LinearLayout.class);
        myLibaoActivity.myLibaoTablayout = (TabLayout) butterknife.c.a.c(view, R.id.my_libao_tablayout, "field 'myLibaoTablayout'", TabLayout.class);
        myLibaoActivity.myLibaoViewPager = (ViewPager) butterknife.c.a.c(view, R.id.my_libao_viewPager, "field 'myLibaoViewPager'", ViewPager.class);
        myLibaoActivity.myLibaoTips = (TextView) butterknife.c.a.c(view, R.id.my_libao_tips, "field 'myLibaoTips'", TextView.class);
    }

    @CallSuper
    public void a() {
        MyLibaoActivity myLibaoActivity = this.b;
        if (myLibaoActivity != null) {
            this.b = null;
            myLibaoActivity.myLibaoBack = null;
            myLibaoActivity.myLibaoTopLayout = null;
            myLibaoActivity.myLibaoTablayout = null;
            myLibaoActivity.myLibaoViewPager = null;
            myLibaoActivity.myLibaoTips = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
