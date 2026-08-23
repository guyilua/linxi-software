package com.rtk.app.main.UpModule;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckApkListFragment_ViewBinding implements Unbinder {
    private UpCheckApkListFragment b;

    @UiThread
    public UpCheckApkListFragment_ViewBinding(UpCheckApkListFragment upCheckApkListFragment, View view) {
        this.b = upCheckApkListFragment;
        upCheckApkListFragment.upCheckApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_apk_list_fragment_listView, "field 'upCheckApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        UpCheckApkListFragment upCheckApkListFragment = this.b;
        if (upCheckApkListFragment != null) {
            this.b = null;
            upCheckApkListFragment.upCheckApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
