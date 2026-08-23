package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LiBaoSearchActivity_ViewBinding implements Unbinder {
    private LiBaoSearchActivity b;

    @UiThread
    public LiBaoSearchActivity_ViewBinding(LiBaoSearchActivity liBaoSearchActivity, View view) {
        this.b = liBaoSearchActivity;
        liBaoSearchActivity.libaoSearchListTitle = (TextView) butterknife.c.a.c(view, R.id.libao_search_list_title, "field 'libaoSearchListTitle'", TextView.class);
        liBaoSearchActivity.libaoSearchListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.libao_search_list_layout, "field 'libaoSearchListLayout'", LinearLayout.class);
        liBaoSearchActivity.libaoSearchListListView = (AutoListView) butterknife.c.a.c(view, R.id.libao_search_list_listView, "field 'libaoSearchListListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        LiBaoSearchActivity liBaoSearchActivity = this.b;
        if (liBaoSearchActivity != null) {
            this.b = null;
            liBaoSearchActivity.libaoSearchListTitle = null;
            liBaoSearchActivity.libaoSearchListLayout = null;
            liBaoSearchActivity.libaoSearchListListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
