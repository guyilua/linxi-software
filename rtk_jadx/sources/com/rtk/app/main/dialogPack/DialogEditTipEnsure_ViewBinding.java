package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogEditTipEnsure_ViewBinding implements Unbinder {
    private DialogEditTipEnsure b;

    @UiThread
    public DialogEditTipEnsure_ViewBinding(DialogEditTipEnsure dialogEditTipEnsure, View view) {
        this.b = dialogEditTipEnsure;
        dialogEditTipEnsure.dialogEditTipEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_edit_tip_ensure, "field 'dialogEditTipEnsure'", TextView.class);
        dialogEditTipEnsure.dialogEditTipEv = (EditText) butterknife.c.a.c(view, R.id.dialog_edit_tip_ev, "field 'dialogEditTipEv'", EditText.class);
        dialogEditTipEnsure.dialogTipForCallbackOk = (TextView) butterknife.c.a.c(view, R.id.dialog_tip_for_callback_ok, "field 'dialogTipForCallbackOk'", TextView.class);
        dialogEditTipEnsure.dialogTipForCallbackCancle = (TextView) butterknife.c.a.c(view, R.id.dialog_tip_for_callback_cancle, "field 'dialogTipForCallbackCancle'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogEditTipEnsure dialogEditTipEnsure = this.b;
        if (dialogEditTipEnsure != null) {
            this.b = null;
            dialogEditTipEnsure.dialogEditTipEnsure = null;
            dialogEditTipEnsure.dialogEditTipEv = null;
            dialogEditTipEnsure.dialogTipForCallbackOk = null;
            dialogEditTipEnsure.dialogTipForCallbackCancle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
