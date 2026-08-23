package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyFansActivity_ViewBinding implements Unbinder {
    private MyFansActivity b;

    @UiThread
    public MyFansActivity_ViewBinding(MyFansActivity myFansActivity, View view) {
        this.b = myFansActivity;
        myFansActivity.myFansTopBack = (TextView) butterknife.c.a.c(view, R.id.my_fans_topBack, "field 'myFansTopBack'", TextView.class);
        myFansActivity.myFansTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_fans_topLayout, "field 'myFansTopLayout'", LinearLayout.class);
        myFansActivity.myPostFansListview = (AutoListView) butterknife.c.a.c(view, R.id.my_post_fans_listview, "field 'myPostFansListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        MyFansActivity myFansActivity = this.b;
        if (myFansActivity != null) {
            this.b = null;
            myFansActivity.myFansTopBack = null;
            myFansActivity.myFansTopLayout = null;
            myFansActivity.myPostFansListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
