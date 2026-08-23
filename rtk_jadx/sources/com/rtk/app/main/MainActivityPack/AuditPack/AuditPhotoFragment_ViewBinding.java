package com.rtk.app.main.MainActivityPack.AuditPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditPhotoFragment_ViewBinding implements Unbinder {
    private AuditPhotoFragment b;

    @UiThread
    public AuditPhotoFragment_ViewBinding(AuditPhotoFragment auditPhotoFragment, View view) {
        this.b = auditPhotoFragment;
        auditPhotoFragment.upCheckAgainApkListFragmentListView = (AutoListView) butterknife.c.a.c(view, R.id.up_check_again_apk_list_fragment_listView, "field 'upCheckAgainApkListFragmentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        AuditPhotoFragment auditPhotoFragment = this.b;
        if (auditPhotoFragment != null) {
            this.b = null;
            auditPhotoFragment.upCheckAgainApkListFragmentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
