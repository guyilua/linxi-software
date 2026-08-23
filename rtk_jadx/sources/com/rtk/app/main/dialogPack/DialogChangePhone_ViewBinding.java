package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogChangePhone_ViewBinding implements Unbinder {
    private DialogChangePhone b;

    @UiThread
    public DialogChangePhone_ViewBinding(DialogChangePhone dialogChangePhone, View view) {
        this.b = dialogChangePhone;
        dialogChangePhone.dialogChangePhonePhone = (EditText) butterknife.c.a.c(view, R.id.dialog_change_phone_phone, "field 'dialogChangePhonePhone'", EditText.class);
        dialogChangePhone.dialogChangePhoneToken = (EditText) butterknife.c.a.c(view, R.id.dialog_change_phone_token, "field 'dialogChangePhoneToken'", EditText.class);
        dialogChangePhone.registerGettokenBtu = (Button) butterknife.c.a.c(view, R.id.register_gettokenBtu, "field 'registerGettokenBtu'", Button.class);
        dialogChangePhone.dialogChangePhoneSubmit = (TextView) butterknife.c.a.c(view, R.id.dialog_change_phone_submit, "field 'dialogChangePhoneSubmit'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogChangePhone dialogChangePhone = this.b;
        if (dialogChangePhone != null) {
            this.b = null;
            dialogChangePhone.dialogChangePhonePhone = null;
            dialogChangePhone.dialogChangePhoneToken = null;
            dialogChangePhone.registerGettokenBtu = null;
            dialogChangePhone.dialogChangePhoneSubmit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
