package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForInstallPermission_ViewBinding implements Unbinder {
    private DialogForInstallPermission b;

    @UiThread
    public DialogForInstallPermission_ViewBinding(DialogForInstallPermission dialogForInstallPermission, View view) {
        this.b = dialogForInstallPermission;
        dialogForInstallPermission.dialogForInstallPermissionEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_install_permission_ensure, "field 'dialogForInstallPermissionEnsure'", TextView.class);
        dialogForInstallPermission.dialogForInstallPermissionCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_install_permission_cancel, "field 'dialogForInstallPermissionCancel'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForInstallPermission dialogForInstallPermission = this.b;
        if (dialogForInstallPermission != null) {
            this.b = null;
            dialogForInstallPermission.dialogForInstallPermissionEnsure = null;
            dialogForInstallPermission.dialogForInstallPermissionCancel = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
