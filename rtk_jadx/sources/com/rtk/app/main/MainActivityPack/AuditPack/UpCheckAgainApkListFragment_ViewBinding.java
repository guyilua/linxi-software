package com.rtk.app.main.MainActivityPack.AuditPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckAgainApkListFragment_ViewBinding implements Unbinder {
    private UpCheckAgainApkListFragment b;

    @UiThread
    public UpCheckAgainApkListFragment_ViewBinding(UpCheckAgainApkListFragment upCheckAgainApkListFragment, View view) {
        this.b = upCheckAgainApkListFragment;
        upCheckAgainApkListFragment.upCheckAgainApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_again_apk_list_fragment_listView, "field 'upCheckAgainApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        UpCheckAgainApkListFragment upCheckAgainApkListFragment = this.b;
        if (upCheckAgainApkListFragment != null) {
            this.b = null;
            upCheckAgainApkListFragment.upCheckAgainApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
