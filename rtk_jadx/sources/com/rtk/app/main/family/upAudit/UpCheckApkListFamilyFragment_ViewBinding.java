package com.rtk.app.main.family.upAudit;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckApkListFamilyFragment_ViewBinding implements Unbinder {
    private UpCheckApkListFamilyFragment b;

    @UiThread
    public UpCheckApkListFamilyFragment_ViewBinding(UpCheckApkListFamilyFragment upCheckApkListFamilyFragment, View view) {
        this.b = upCheckApkListFamilyFragment;
        upCheckApkListFamilyFragment.upCheckAgainApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_again_apk_list_fragment_listView, "field 'upCheckAgainApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        UpCheckApkListFamilyFragment upCheckApkListFamilyFragment = this.b;
        if (upCheckApkListFamilyFragment != null) {
            this.b = null;
            upCheckApkListFamilyFragment.upCheckAgainApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
