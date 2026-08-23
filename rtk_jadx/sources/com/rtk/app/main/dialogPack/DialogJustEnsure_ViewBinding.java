package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogJustEnsure_ViewBinding implements Unbinder {
    private DialogJustEnsure b;

    @UiThread
    public DialogJustEnsure_ViewBinding(DialogJustEnsure dialogJustEnsure, View view) {
        this.b = dialogJustEnsure;
        dialogJustEnsure.dialogJustEnsureTips = (TextView) butterknife.c.a.c(view, R.id.dialog_just_ensure_tips, "field 'dialogJustEnsureTips'", TextView.class);
        dialogJustEnsure.dialogJustEnsureBtuEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_just_ensure_btuEnsure, "field 'dialogJustEnsureBtuEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogJustEnsure dialogJustEnsure = this.b;
        if (dialogJustEnsure != null) {
            this.b = null;
            dialogJustEnsure.dialogJustEnsureTips = null;
            dialogJustEnsure.dialogJustEnsureBtuEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
