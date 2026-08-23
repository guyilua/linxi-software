package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogInstallTip$ViewHolder_ViewBinding implements Unbinder {
    private DialogInstallTip$ViewHolder b;

    @UiThread
    public DialogInstallTip$ViewHolder_ViewBinding(DialogInstallTip$ViewHolder dialogInstallTip$ViewHolder, View view) {
        dialogInstallTip$ViewHolder.toInstallHint = (TextView) butterknife.c.a.c(view, R.id.to_install_hint, "field 'toInstallHint'", TextView.class);
        dialogInstallTip$ViewHolder.toInstallOk = (TextView) butterknife.c.a.c(view, R.id.to_install_ok, "field 'toInstallOk'", TextView.class);
        dialogInstallTip$ViewHolder.toInstallCancle = (TextView) butterknife.c.a.c(view, R.id.to_install_cancle, "field 'toInstallCancle'", TextView.class);
        dialogInstallTip$ViewHolder.dialogInstallTipLayout = (TextView) butterknife.c.a.c(view, R.id.dialog_install_tip_layout, "field 'dialogInstallTipLayout'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogInstallTip$ViewHolder dialogInstallTip$ViewHolder = this.b;
        if (dialogInstallTip$ViewHolder != null) {
            dialogInstallTip$ViewHolder.toInstallHint = null;
            dialogInstallTip$ViewHolder.toInstallOk = null;
            dialogInstallTip$ViewHolder.toInstallCancle = null;
            dialogInstallTip$ViewHolder.dialogInstallTipLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
