package com.rtk.app.main.UpModule;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAuditSearchFragment_ViewBinding implements Unbinder {
    private UpAuditSearchFragment b;

    @UiThread
    public UpAuditSearchFragment_ViewBinding(UpAuditSearchFragment upAuditSearchFragment, View view) {
        this.b = upAuditSearchFragment;
        upAuditSearchFragment.upCheckApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_apk_list_fragment_listView, "field 'upCheckApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        UpAuditSearchFragment upAuditSearchFragment = this.b;
        if (upAuditSearchFragment != null) {
            this.b = null;
            upAuditSearchFragment.upCheckApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
