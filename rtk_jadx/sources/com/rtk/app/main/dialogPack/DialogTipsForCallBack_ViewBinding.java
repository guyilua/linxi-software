package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogTipsForCallBack_ViewBinding implements Unbinder {
    private DialogTipsForCallBack b;

    @UiThread
    public DialogTipsForCallBack_ViewBinding(DialogTipsForCallBack dialogTipsForCallBack, View view) {
        this.b = dialogTipsForCallBack;
        dialogTipsForCallBack.dialogTipForCallbackLayout = (TextView) butterknife.c.a.c(view, R.id.dialog_tip_for_callback_layout, "field 'dialogTipForCallbackLayout'", TextView.class);
        dialogTipsForCallBack.dialogTipForCallbackTip = (TextView) butterknife.c.a.c(view, R.id.dialog_tip_for_callback_tip, "field 'dialogTipForCallbackTip'", TextView.class);
        dialogTipsForCallBack.dialogTipForCallbackOk = (TextView) butterknife.c.a.c(view, R.id.dialog_tip_for_callback_ok, "field 'dialogTipForCallbackOk'", TextView.class);
        dialogTipsForCallBack.dialogTipForCallbackCancle = (TextView) butterknife.c.a.c(view, R.id.dialog_tip_for_callback_cancle, "field 'dialogTipForCallbackCancle'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogTipsForCallBack dialogTipsForCallBack = this.b;
        if (dialogTipsForCallBack != null) {
            this.b = null;
            dialogTipsForCallBack.dialogTipForCallbackLayout = null;
            dialogTipsForCallBack.dialogTipForCallbackTip = null;
            dialogTipsForCallBack.dialogTipForCallbackOk = null;
            dialogTipsForCallBack.dialogTipForCallbackCancle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
