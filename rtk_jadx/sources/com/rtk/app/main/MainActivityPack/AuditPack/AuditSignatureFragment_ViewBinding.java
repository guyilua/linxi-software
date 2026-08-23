package com.rtk.app.main.MainActivityPack.AuditPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditSignatureFragment_ViewBinding implements Unbinder {
    private AuditSignatureFragment b;

    @UiThread
    public AuditSignatureFragment_ViewBinding(AuditSignatureFragment auditSignatureFragment, View view) {
        this.b = auditSignatureFragment;
        auditSignatureFragment.upCheckAgainApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_again_apk_list_fragment_listView, "field 'upCheckAgainApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        AuditSignatureFragment auditSignatureFragment = this.b;
        if (auditSignatureFragment != null) {
            this.b = null;
            auditSignatureFragment.upCheckAgainApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
