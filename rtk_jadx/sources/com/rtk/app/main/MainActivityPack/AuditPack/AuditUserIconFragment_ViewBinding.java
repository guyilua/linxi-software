package com.rtk.app.main.MainActivityPack.AuditPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditUserIconFragment_ViewBinding implements Unbinder {
    private AuditUserIconFragment b;

    @UiThread
    public AuditUserIconFragment_ViewBinding(AuditUserIconFragment auditUserIconFragment, View view) {
        this.b = auditUserIconFragment;
        auditUserIconFragment.upCheckAgainApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_again_apk_list_fragment_listView, "field 'upCheckAgainApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        AuditUserIconFragment auditUserIconFragment = this.b;
        if (auditUserIconFragment != null) {
            this.b = null;
            auditUserIconFragment.upCheckAgainApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
