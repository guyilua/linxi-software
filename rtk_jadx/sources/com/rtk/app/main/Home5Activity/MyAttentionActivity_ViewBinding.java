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
public class MyAttentionActivity_ViewBinding implements Unbinder {
    private MyAttentionActivity b;

    @UiThread
    public MyAttentionActivity_ViewBinding(MyAttentionActivity myAttentionActivity, View view) {
        this.b = myAttentionActivity;
        myAttentionActivity.myAttentionTopBack = (TextView) butterknife.c.a.c(view, R.id.my_attention_topBack, "field 'myAttentionTopBack'", TextView.class);
        myAttentionActivity.myAttentionTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.my_attention_topLayout, "field 'myAttentionTopLayout'", LinearLayout.class);
        myAttentionActivity.myAttentionListview = (AutoListView) butterknife.c.a.c(view, R.id.my_attention_listview, "field 'myAttentionListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        MyAttentionActivity myAttentionActivity = this.b;
        if (myAttentionActivity != null) {
            this.b = null;
            myAttentionActivity.myAttentionTopBack = null;
            myAttentionActivity.myAttentionTopLayout = null;
            myAttentionActivity.myAttentionListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
