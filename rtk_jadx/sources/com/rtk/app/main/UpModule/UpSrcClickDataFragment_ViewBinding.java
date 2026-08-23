package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcClickDataFragment_ViewBinding implements Unbinder {
    private UpSrcClickDataFragment b;

    @UiThread
    public UpSrcClickDataFragment_ViewBinding(UpSrcClickDataFragment upSrcClickDataFragment, View view) {
        this.b = upSrcClickDataFragment;
        upSrcClickDataFragment.fragmentForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragmentForListviewListview'", AutoListView.class);
        upSrcClickDataFragment.fragmentForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragmentForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpSrcClickDataFragment upSrcClickDataFragment = this.b;
        if (upSrcClickDataFragment != null) {
            this.b = null;
            upSrcClickDataFragment.fragmentForListviewListview = null;
            upSrcClickDataFragment.fragmentForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
