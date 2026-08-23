package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForCheckPsw_ViewBinding implements Unbinder {
    private DialogForCheckPsw b;

    @UiThread
    public DialogForCheckPsw_ViewBinding(DialogForCheckPsw dialogForCheckPsw, View view) {
        this.b = dialogForCheckPsw;
        dialogForCheckPsw.dialogForCheckPswLayoutPsw = (EditText) butterknife.c.a.c(view, R.id.dialog_for_check_psw_layout_psw, "field 'dialogForCheckPswLayoutPsw'", EditText.class);
        dialogForCheckPsw.dialogForCheckPswLayoutSubmit = (TextView) butterknife.c.a.c(view, R.id.dialog_for_check_psw_layout_submit, "field 'dialogForCheckPswLayoutSubmit'", TextView.class);
        dialogForCheckPsw.dialogForCheckPswLayoutEye = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_check_psw_layout_eye, "field 'dialogForCheckPswLayoutEye'", ImageView.class);
    }

    @CallSuper
    public void a() {
        DialogForCheckPsw dialogForCheckPsw = this.b;
        if (dialogForCheckPsw != null) {
            this.b = null;
            dialogForCheckPsw.dialogForCheckPswLayoutPsw = null;
            dialogForCheckPsw.dialogForCheckPswLayoutSubmit = null;
            dialogForCheckPsw.dialogForCheckPswLayoutEye = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
