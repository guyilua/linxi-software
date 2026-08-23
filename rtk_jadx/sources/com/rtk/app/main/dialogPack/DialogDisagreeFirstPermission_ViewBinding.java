package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogDisagreeFirstPermission_ViewBinding implements Unbinder {
    private DialogDisagreeFirstPermission b;

    @UiThread
    public DialogDisagreeFirstPermission_ViewBinding(DialogDisagreeFirstPermission dialogDisagreeFirstPermission, View view) {
        this.b = dialogDisagreeFirstPermission;
        dialogDisagreeFirstPermission.dialogDisagreeFirstExit = (TextView) butterknife.c.a.c(view, R.id.dialog_disagree_first_exit, "field 'dialogDisagreeFirstExit'", TextView.class);
        dialogDisagreeFirstPermission.dialogDisagreeFirstShowAgain = (TextView) butterknife.c.a.c(view, R.id.dialog_disagree_first_show_again, "field 'dialogDisagreeFirstShowAgain'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogDisagreeFirstPermission dialogDisagreeFirstPermission = this.b;
        if (dialogDisagreeFirstPermission != null) {
            this.b = null;
            dialogDisagreeFirstPermission.dialogDisagreeFirstExit = null;
            dialogDisagreeFirstPermission.dialogDisagreeFirstShowAgain = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
