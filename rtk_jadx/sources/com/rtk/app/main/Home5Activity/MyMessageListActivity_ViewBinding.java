package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.BaseViewPager;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyMessageListActivity_ViewBinding implements Unbinder {
    private MyMessageListActivity b;

    @UiThread
    public MyMessageListActivity_ViewBinding(MyMessageListActivity myMessageListActivity, View view) {
        this.b = myMessageListActivity;
        myMessageListActivity.myMessageListTopBack = (TextView) butterknife.c.a.c(view, R.id.my_message_list_topBack, "field 'myMessageListTopBack'", TextView.class);
        myMessageListActivity.myMessageListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_message_list_topLayout, "field 'myMessageListTopLayout'", LinearLayout.class);
        myMessageListActivity.myMessageListViewPager = (BaseViewPager) butterknife.c.a.c(view, R.id.my_message_list_viewPager, "field 'myMessageListViewPager'", BaseViewPager.class);
        myMessageListActivity.myMessageListTab = (TabLayout) butterknife.c.a.c(view, R.id.my_message_list_tab, "field 'myMessageListTab'", TabLayout.class);
        myMessageListActivity.myMessageListTopReadAll = (TextView) butterknife.c.a.c(view, R.id.my_message_list_topReadAll, "field 'myMessageListTopReadAll'", TextView.class);
        myMessageListActivity.massageNumForUser = (TextView) butterknife.c.a.c(view, R.id.massage_numForUser, "field 'massageNumForUser'", TextView.class);
        myMessageListActivity.massageNumForSystem = (TextView) butterknife.c.a.c(view, R.id.massage_numForSystem, "field 'massageNumForSystem'", TextView.class);
    }

    @CallSuper
    public void a() {
        MyMessageListActivity myMessageListActivity = this.b;
        if (myMessageListActivity != null) {
            this.b = null;
            myMessageListActivity.myMessageListTopBack = null;
            myMessageListActivity.myMessageListTopLayout = null;
            myMessageListActivity.myMessageListViewPager = null;
            myMessageListActivity.myMessageListTab = null;
            myMessageListActivity.myMessageListTopReadAll = null;
            myMessageListActivity.massageNumForUser = null;
            myMessageListActivity.massageNumForSystem = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
