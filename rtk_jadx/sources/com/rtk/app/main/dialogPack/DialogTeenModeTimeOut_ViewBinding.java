package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogTeenModeTimeOut_ViewBinding implements Unbinder {
    private DialogTeenModeTimeOut b;

    @UiThread
    public DialogTeenModeTimeOut_ViewBinding(DialogTeenModeTimeOut dialogTeenModeTimeOut, View view) {
        this.b = dialogTeenModeTimeOut;
        dialogTeenModeTimeOut.passwordEv = (EditText) butterknife.c.a.c(view, R.id.dialog_teen_mode_out_time_password, "field 'passwordEv'", EditText.class);
        dialogTeenModeTimeOut.titleTv = (TextView) butterknife.c.a.c(view, R.id.dialog_teen_mode_out_title, "field 'titleTv'", TextView.class);
        dialogTeenModeTimeOut.tipTv = (TextView) butterknife.c.a.c(view, R.id.dialog_teen_mode_out_tip, "field 'tipTv'", TextView.class);
        dialogTeenModeTimeOut.OKTv = (TextView) butterknife.c.a.c(view, R.id.dialog_teen_mode_out_ok, "field 'OKTv'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogTeenModeTimeOut dialogTeenModeTimeOut = this.b;
        if (dialogTeenModeTimeOut != null) {
            this.b = null;
            dialogTeenModeTimeOut.passwordEv = null;
            dialogTeenModeTimeOut.titleTv = null;
            dialogTeenModeTimeOut.tipTv = null;
            dialogTeenModeTimeOut.OKTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
