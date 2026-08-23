package com.rtk.app.main.MainActivityPack.AuditPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditNickNameFragment_ViewBinding implements Unbinder {
    private AuditNickNameFragment b;

    @UiThread
    public AuditNickNameFragment_ViewBinding(AuditNickNameFragment auditNickNameFragment, View view) {
        this.b = auditNickNameFragment;
        auditNickNameFragment.upCheckAgainApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_again_apk_list_fragment_listView, "field 'upCheckAgainApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        AuditNickNameFragment auditNickNameFragment = this.b;
        if (auditNickNameFragment != null) {
            this.b = null;
            auditNickNameFragment.upCheckAgainApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
