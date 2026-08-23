package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcDataFragment_ViewBinding implements Unbinder {
    private UpSrcDataFragment b;

    @UiThread
    public UpSrcDataFragment_ViewBinding(UpSrcDataFragment upSrcDataFragment, View view) {
        this.b = upSrcDataFragment;
        upSrcDataFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
        upSrcDataFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpSrcDataFragment upSrcDataFragment = this.b;
        if (upSrcDataFragment != null) {
            this.b = null;
            upSrcDataFragment.fragementForListviewListview = null;
            upSrcDataFragment.fragementForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
