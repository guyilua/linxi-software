package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogUpdatePsw_ViewBinding implements Unbinder {
    private DialogUpdatePsw b;

    @UiThread
    public DialogUpdatePsw_ViewBinding(DialogUpdatePsw dialogUpdatePsw, View view) {
        this.b = dialogUpdatePsw;
        dialogUpdatePsw.dialogUpdatePswLastPsw = (NoOOMEditText) butterknife.c.a.c(view, R.id.dialog_update_psw_lastPsw, "field 'dialogUpdatePswLastPsw'", NoOOMEditText.class);
        dialogUpdatePsw.dialogUpdatePswNewPsw = (NoOOMEditText) butterknife.c.a.c(view, R.id.dialog_update_psw_newPsw, "field 'dialogUpdatePswNewPsw'", NoOOMEditText.class);
        dialogUpdatePsw.dialogUpdatePswPswAgain = (NoOOMEditText) butterknife.c.a.c(view, R.id.dialog_update_psw_pswAgain, "field 'dialogUpdatePswPswAgain'", NoOOMEditText.class);
        dialogUpdatePsw.dialogUpdatePswSubmit = (Button) butterknife.c.a.c(view, R.id.dialog_update_psw_submit, "field 'dialogUpdatePswSubmit'", Button.class);
        dialogUpdatePsw.dialogUpdatePswLayoutEye = (ImageView) butterknife.c.a.c(view, R.id.dialog_update_psw_layout_eye, "field 'dialogUpdatePswLayoutEye'", ImageView.class);
    }

    @CallSuper
    public void a() {
        DialogUpdatePsw dialogUpdatePsw = this.b;
        if (dialogUpdatePsw != null) {
            this.b = null;
            dialogUpdatePsw.dialogUpdatePswLastPsw = null;
            dialogUpdatePsw.dialogUpdatePswNewPsw = null;
            dialogUpdatePsw.dialogUpdatePswPswAgain = null;
            dialogUpdatePsw.dialogUpdatePswSubmit = null;
            dialogUpdatePsw.dialogUpdatePswLayoutEye = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
