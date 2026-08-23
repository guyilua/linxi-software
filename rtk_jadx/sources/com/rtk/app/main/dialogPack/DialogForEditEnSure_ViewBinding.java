package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForEditEnSure_ViewBinding implements Unbinder {
    private DialogForEditEnSure b;

    @UiThread
    public DialogForEditEnSure_ViewBinding(DialogForEditEnSure dialogForEditEnSure, View view) {
        this.b = dialogForEditEnSure;
        dialogForEditEnSure.dialogForEditEnsureTips = (EditText) butterknife.c.a.c(view, R.id.dialog_for_edit_ensure_tips, "field 'dialogForEditEnsureTips'", EditText.class);
        dialogForEditEnSure.dialogForEditEnsureBtuCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_edit_ensure_btuCancel, "field 'dialogForEditEnsureBtuCancel'", TextView.class);
        dialogForEditEnSure.dialogForEditEnsureBtuEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_edit_ensure_btuEnsure, "field 'dialogForEditEnsureBtuEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForEditEnSure dialogForEditEnSure = this.b;
        if (dialogForEditEnSure != null) {
            this.b = null;
            dialogForEditEnSure.dialogForEditEnsureTips = null;
            dialogForEditEnSure.dialogForEditEnsureBtuCancel = null;
            dialogForEditEnSure.dialogForEditEnsureBtuEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
