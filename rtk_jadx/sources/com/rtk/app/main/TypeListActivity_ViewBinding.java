package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TypeListActivity_ViewBinding implements Unbinder {
    private TypeListActivity b;

    @UiThread
    public TypeListActivity_ViewBinding(TypeListActivity typeListActivity, View view) {
        this.b = typeListActivity;
        typeListActivity.typeListBack = (TextView) butterknife.c.a.c(view, R.id.type_list_back, "field 'typeListBack'", TextView.class);
        typeListActivity.typeListDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.type_list_download, "field 'typeListDownload'", MarkedImageView.class);
        typeListActivity.typeListLayout = (LinearLayout) butterknife.c.a.c(view, R.id.type_list_layout, "field 'typeListLayout'", LinearLayout.class);
        typeListActivity.typeListListView = (AutoListView) butterknife.c.a.c(view, R.id.type_list_listView, "field 'typeListListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        TypeListActivity typeListActivity = this.b;
        if (typeListActivity != null) {
            this.b = null;
            typeListActivity.typeListBack = null;
            typeListActivity.typeListDownload = null;
            typeListActivity.typeListLayout = null;
            typeListActivity.typeListListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
