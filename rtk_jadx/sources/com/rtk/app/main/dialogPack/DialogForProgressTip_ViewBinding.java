package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForProgressTip_ViewBinding implements Unbinder {
    private DialogForProgressTip b;

    @UiThread
    public DialogForProgressTip_ViewBinding(DialogForProgressTip dialogForProgressTip, View view) {
        this.b = dialogForProgressTip;
        dialogForProgressTip.dialogForProgressTipsTv = (TextView) butterknife.c.a.c(view, R.id.dialog_for_progress_tips_tv, "field 'dialogForProgressTipsTv'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForProgressTip dialogForProgressTip = this.b;
        if (dialogForProgressTip != null) {
            this.b = null;
            dialogForProgressTip.dialogForProgressTipsTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
