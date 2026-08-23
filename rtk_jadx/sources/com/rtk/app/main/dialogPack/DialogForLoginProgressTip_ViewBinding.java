package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForLoginProgressTip_ViewBinding implements Unbinder {
    private DialogForLoginProgressTip b;

    @UiThread
    public DialogForLoginProgressTip_ViewBinding(DialogForLoginProgressTip dialogForLoginProgressTip, View view) {
        this.b = dialogForLoginProgressTip;
        dialogForLoginProgressTip.dialogForProgressTipsTv = (TextView) butterknife.c.a.c(view, R.id.dialog_for_progress_tips_tv, "field 'dialogForProgressTipsTv'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForLoginProgressTip dialogForLoginProgressTip = this.b;
        if (dialogForLoginProgressTip != null) {
            this.b = null;
            dialogForLoginProgressTip.dialogForProgressTipsTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
