package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForPermissionTip_ViewBinding implements Unbinder {
    private DialogForPermissionTip b;

    @UiThread
    public DialogForPermissionTip_ViewBinding(DialogForPermissionTip dialogForPermissionTip, View view) {
        this.b = dialogForPermissionTip;
        dialogForPermissionTip.dialogForPermissionAgreement = (TextView) butterknife.c.a.c(view, R.id.dialog_for_permission_agreement, "field 'dialogForPermissionAgreement'", TextView.class);
        dialogForPermissionTip.dialogForPermissionBtu = (TextView) butterknife.c.a.c(view, R.id.dialog_for_permission_btu, "field 'dialogForPermissionBtu'", TextView.class);
        dialogForPermissionTip.dialogForPermissionNo = (TextView) butterknife.c.a.c(view, R.id.dialog_for_permission_no, "field 'dialogForPermissionNo'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForPermissionTip dialogForPermissionTip = this.b;
        if (dialogForPermissionTip != null) {
            this.b = null;
            dialogForPermissionTip.dialogForPermissionAgreement = null;
            dialogForPermissionTip.dialogForPermissionBtu = null;
            dialogForPermissionTip.dialogForPermissionNo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
