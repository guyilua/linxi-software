package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForToAccountSecurityActivity_ViewBinding implements Unbinder {
    private DialogForToAccountSecurityActivity b;

    @UiThread
    public DialogForToAccountSecurityActivity_ViewBinding(DialogForToAccountSecurityActivity dialogForToAccountSecurityActivity, View view) {
        this.b = dialogForToAccountSecurityActivity;
        dialogForToAccountSecurityActivity.dialogForToAccountSecurityTips = (TextView) butterknife.c.a.c(view, R.id.dialog_for_to_account_security_tips, "field 'dialogForToAccountSecurityTips'", TextView.class);
        dialogForToAccountSecurityActivity.dialogForToAccountSecurityBtuEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_to_account_security_btuEnsure, "field 'dialogForToAccountSecurityBtuEnsure'", TextView.class);
        dialogForToAccountSecurityActivity.dialogForToAccountSecurityBtuCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_to_account_security_btu_cancel, "field 'dialogForToAccountSecurityBtuCancel'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForToAccountSecurityActivity dialogForToAccountSecurityActivity = this.b;
        if (dialogForToAccountSecurityActivity != null) {
            this.b = null;
            dialogForToAccountSecurityActivity.dialogForToAccountSecurityTips = null;
            dialogForToAccountSecurityActivity.dialogForToAccountSecurityBtuEnsure = null;
            dialogForToAccountSecurityActivity.dialogForToAccountSecurityBtuCancel = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
