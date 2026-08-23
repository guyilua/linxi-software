package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkSearchListFragment_ViewBinding implements Unbinder {
    private UpApkSearchListFragment b;

    @UiThread
    public UpApkSearchListFragment_ViewBinding(UpApkSearchListFragment upApkSearchListFragment, View view) {
        this.b = upApkSearchListFragment;
        upApkSearchListFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
        upApkSearchListFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpApkSearchListFragment upApkSearchListFragment = this.b;
        if (upApkSearchListFragment != null) {
            this.b = null;
            upApkSearchListFragment.fragementForListviewListview = null;
            upApkSearchListFragment.fragementForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
