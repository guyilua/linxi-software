package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogFileCopy_ViewBinding implements Unbinder {
    private DialogFileCopy b;

    @UiThread
    public DialogFileCopy_ViewBinding(DialogFileCopy dialogFileCopy, View view) {
        this.b = dialogFileCopy;
        dialogFileCopy.dialogForProgressTipsTv = (TextView) butterknife.c.a.c(view, R.id.dialog_for_progress_tips_tv, "field 'dialogForProgressTipsTv'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogFileCopy dialogFileCopy = this.b;
        if (dialogFileCopy != null) {
            this.b = null;
            dialogFileCopy.dialogForProgressTipsTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
