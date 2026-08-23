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
public class MyCommentActivity_ViewBinding implements Unbinder {
    private MyCommentActivity b;

    @UiThread
    public MyCommentActivity_ViewBinding(MyCommentActivity myCommentActivity, View view) {
        this.b = myCommentActivity;
        myCommentActivity.myCommentTopBack = (TextView) butterknife.c.a.c(view, R.id.my_comment_top_back, "field 'myCommentTopBack'", TextView.class);
        myCommentActivity.myCommentTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_comment_top_layout, "field 'myCommentTopLayout'", LinearLayout.class);
        myCommentActivity.myCommentViewPager = (ViewPager) butterknife.c.a.c(view, R.id.my_comment_ViewPager, "field 'myCommentViewPager'", ViewPager.class);
        myCommentActivity.myCommentTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.my_comment_tag_layout, "field 'myCommentTagLayout'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        MyCommentActivity myCommentActivity = this.b;
        if (myCommentActivity != null) {
            this.b = null;
            myCommentActivity.myCommentTopBack = null;
            myCommentActivity.myCommentTopLayout = null;
            myCommentActivity.myCommentViewPager = null;
            myCommentActivity.myCommentTagLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
