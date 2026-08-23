package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcSearchActivity_ViewBinding implements Unbinder {
    private UpSrcSearchActivity b;

    @UiThread
    public UpSrcSearchActivity_ViewBinding(UpSrcSearchActivity upSrcSearchActivity, View view) {
        this.b = upSrcSearchActivity;
        upSrcSearchActivity.upSrcSearchTopBack = (TextView) butterknife.c.a.c(view, R.id.up_src_search_top_back, "field 'upSrcSearchTopBack'", TextView.class);
        upSrcSearchActivity.upSrcSearchTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_search_top_layout, "field 'upSrcSearchTopLayout'", LinearLayout.class);
        upSrcSearchActivity.upSrcSearchListview = (AutoListView) butterknife.c.a.c(view, R.id.up_src_search_listview, "field 'upSrcSearchListview'", AutoListView.class);
        upSrcSearchActivity.upSrcSearchTopSearch = (EditText) butterknife.c.a.c(view, R.id.up_src_search_top_search, "field 'upSrcSearchTopSearch'", EditText.class);
        upSrcSearchActivity.upSrcSearchTopSubmit = (TextView) butterknife.c.a.c(view, R.id.up_src_search_top_submit, "field 'upSrcSearchTopSubmit'", TextView.class);
        upSrcSearchActivity.history = butterknife.c.a.b(view, R.id.up_src_search_history, "field 'history'");
        upSrcSearchActivity.upSrcSearchParent = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_search_parent, "field 'upSrcSearchParent'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpSrcSearchActivity upSrcSearchActivity = this.b;
        if (upSrcSearchActivity != null) {
            this.b = null;
            upSrcSearchActivity.upSrcSearchTopBack = null;
            upSrcSearchActivity.upSrcSearchTopLayout = null;
            upSrcSearchActivity.upSrcSearchListview = null;
            upSrcSearchActivity.upSrcSearchTopSearch = null;
            upSrcSearchActivity.upSrcSearchTopSubmit = null;
            upSrcSearchActivity.history = null;
            upSrcSearchActivity.upSrcSearchParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
