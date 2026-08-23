package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpLoadPoolControlActivity_ViewBinding implements Unbinder {
    private UpLoadPoolControlActivity b;

    @UiThread
    public UpLoadPoolControlActivity_ViewBinding(UpLoadPoolControlActivity upLoadPoolControlActivity, View view) {
        this.b = upLoadPoolControlActivity;
        upLoadPoolControlActivity.upLoadPoolControlTopBack = (TextView) butterknife.c.a.c(view, R.id.up_load_pool_control_top_back, "field 'upLoadPoolControlTopBack'", TextView.class);
        upLoadPoolControlActivity.upLoadPoolControlTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_load_pool_control_top_layout, "field 'upLoadPoolControlTopLayout'", LinearLayout.class);
        upLoadPoolControlActivity.upLoadPoolControlListView = (ListView) butterknife.c.a.c(view, R.id.up_load_pool_control_listView, "field 'upLoadPoolControlListView'", ListView.class);
    }

    @CallSuper
    public void a() {
        UpLoadPoolControlActivity upLoadPoolControlActivity = this.b;
        if (upLoadPoolControlActivity != null) {
            this.b = null;
            upLoadPoolControlActivity.upLoadPoolControlTopBack = null;
            upLoadPoolControlActivity.upLoadPoolControlTopLayout = null;
            upLoadPoolControlActivity.upLoadPoolControlListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
