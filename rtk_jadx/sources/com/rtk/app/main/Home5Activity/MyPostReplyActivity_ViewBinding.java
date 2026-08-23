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
public class MyPostReplyActivity_ViewBinding implements Unbinder {
    private MyPostReplyActivity b;

    @UiThread
    public MyPostReplyActivity_ViewBinding(MyPostReplyActivity myPostReplyActivity, View view) {
        this.b = myPostReplyActivity;
        myPostReplyActivity.myReplyTopBack = (TextView) butterknife.c.a.c(view, R.id.my_reply_topBack, "field 'myReplyTopBack'", TextView.class);
        myPostReplyActivity.myReplyTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_reply_topLayout, "field 'myReplyTopLayout'", LinearLayout.class);
        myPostReplyActivity.myReplyViewpager = (ViewPager) butterknife.c.a.c(view, R.id.my_reply_viewpager, "field 'myReplyViewpager'", ViewPager.class);
        myPostReplyActivity.myReplyTab = (TabLayout) butterknife.c.a.c(view, R.id.my_reply_tab, "field 'myReplyTab'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        MyPostReplyActivity myPostReplyActivity = this.b;
        if (myPostReplyActivity != null) {
            this.b = null;
            myPostReplyActivity.myReplyTopBack = null;
            myPostReplyActivity.myReplyTopLayout = null;
            myPostReplyActivity.myReplyViewpager = null;
            myPostReplyActivity.myReplyTab = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
