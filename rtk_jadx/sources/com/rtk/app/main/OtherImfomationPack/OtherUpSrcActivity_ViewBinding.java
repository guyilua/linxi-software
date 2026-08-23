package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherUpSrcActivity_ViewBinding implements Unbinder {
    private OtherUpSrcActivity b;

    @UiThread
    public OtherUpSrcActivity_ViewBinding(OtherUpSrcActivity otherUpSrcActivity, View view) {
        this.b = otherUpSrcActivity;
        otherUpSrcActivity.otherUpSrcTopBack = (TextView) butterknife.c.a.c(view, R.id.other_up_src_top_back, "field 'otherUpSrcTopBack'", TextView.class);
        otherUpSrcActivity.otherUpSrcTopResLibrary = (TextView) butterknife.c.a.c(view, R.id.other_up_src_top_resLibrary, "field 'otherUpSrcTopResLibrary'", TextView.class);
        otherUpSrcActivity.otherUpSrcTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.other_up_src_top_layout, "field 'otherUpSrcTopLayout'", LinearLayout.class);
        otherUpSrcActivity.otherUpSrcListView = (AutoListView) butterknife.c.a.c(view, R.id.other_up_src_listView, "field 'otherUpSrcListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        OtherUpSrcActivity otherUpSrcActivity = this.b;
        if (otherUpSrcActivity != null) {
            this.b = null;
            otherUpSrcActivity.otherUpSrcTopBack = null;
            otherUpSrcActivity.otherUpSrcTopResLibrary = null;
            otherUpSrcActivity.otherUpSrcTopLayout = null;
            otherUpSrcActivity.otherUpSrcListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
