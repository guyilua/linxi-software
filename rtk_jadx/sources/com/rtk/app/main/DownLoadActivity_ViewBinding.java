package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DownLoadActivity_ViewBinding implements Unbinder {
    private DownLoadActivity b;

    @UiThread
    public DownLoadActivity_ViewBinding(DownLoadActivity downLoadActivity, View view) {
        this.b = downLoadActivity;
        downLoadActivity.downLoadBackBackTV = (TextView) butterknife.c.a.c(view, R.id.down_load_back_backTV, "field 'downLoadBackBackTV'", TextView.class);
        downLoadActivity.downLoadBackLayout = (LinearLayout) butterknife.c.a.c(view, R.id.down_load_back_layout, "field 'downLoadBackLayout'", LinearLayout.class);
        downLoadActivity.downLoadList = (ListView) butterknife.c.a.c(view, R.id.down_load_list, "field 'downLoadList'", ListView.class);
        downLoadActivity.downLoadDeleteAll = (TextView) butterknife.c.a.c(view, R.id.down_load_deleteAll, "field 'downLoadDeleteAll'", TextView.class);
    }

    @CallSuper
    public void a() {
        DownLoadActivity downLoadActivity = this.b;
        if (downLoadActivity != null) {
            this.b = null;
            downLoadActivity.downLoadBackBackTV = null;
            downLoadActivity.downLoadBackLayout = null;
            downLoadActivity.downLoadList = null;
            downLoadActivity.downLoadDeleteAll = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
