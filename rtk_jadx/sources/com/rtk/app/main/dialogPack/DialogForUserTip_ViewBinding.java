package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForUserTip_ViewBinding implements Unbinder {
    private DialogForUserTip b;

    @UiThread
    public DialogForUserTip_ViewBinding(DialogForUserTip dialogForUserTip, View view) {
        this.b = dialogForUserTip;
        dialogForUserTip.dialogForCheckAppSignLayoutTitle = (TextView) butterknife.c.a.c(view, R.id.dialog_for_check_app_sign_layout_title, "field 'dialogForCheckAppSignLayoutTitle'", TextView.class);
        dialogForUserTip.dialogForCheckAppSignLayoutTip = (TextView) butterknife.c.a.c(view, R.id.dialog_for_check_app_sign_layout_tip, "field 'dialogForCheckAppSignLayoutTip'", TextView.class);
        dialogForUserTip.dialogForCheckAppSignLayoutSubmit = (TextView) butterknife.c.a.c(view, R.id.dialog_for_check_app_sign_layout_submit, "field 'dialogForCheckAppSignLayoutSubmit'", TextView.class);
        dialogForUserTip.dialogForCheckAppSignLayoutCancle = (TextView) butterknife.c.a.c(view, R.id.dialog_for_check_app_sign_layout_cancle, "field 'dialogForCheckAppSignLayoutCancle'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForUserTip dialogForUserTip = this.b;
        if (dialogForUserTip != null) {
            this.b = null;
            dialogForUserTip.dialogForCheckAppSignLayoutTitle = null;
            dialogForUserTip.dialogForCheckAppSignLayoutTip = null;
            dialogForUserTip.dialogForCheckAppSignLayoutSubmit = null;
            dialogForUserTip.dialogForCheckAppSignLayoutCancle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
