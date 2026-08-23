package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForReadAllMessage_ViewBinding implements Unbinder {
    private DialogForReadAllMessage b;

    @UiThread
    public DialogForReadAllMessage_ViewBinding(DialogForReadAllMessage dialogForReadAllMessage, View view) {
        this.b = dialogForReadAllMessage;
        dialogForReadAllMessage.dialogForread_all_messageExit = (TextView) butterknife.c.a.c(view, R.id.dialog_for_read_all_message_exit, "field 'dialogForread_all_messageExit'", TextView.class);
        dialogForReadAllMessage.dialogForread_all_messageOk = (TextView) butterknife.c.a.c(view, R.id.dialog_for_read_all_message_ok, "field 'dialogForread_all_messageOk'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForReadAllMessage dialogForReadAllMessage = this.b;
        if (dialogForReadAllMessage != null) {
            this.b = null;
            dialogForReadAllMessage.dialogForread_all_messageExit = null;
            dialogForReadAllMessage.dialogForread_all_messageOk = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
