package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogProgressForRewardVideoAdTip_ViewBinding implements Unbinder {
    private DialogProgressForRewardVideoAdTip b;

    @UiThread
    public DialogProgressForRewardVideoAdTip_ViewBinding(DialogProgressForRewardVideoAdTip dialogProgressForRewardVideoAdTip, View view) {
        this.b = dialogProgressForRewardVideoAdTip;
        dialogProgressForRewardVideoAdTip.dialogForProgressTipsTv = (TextView) butterknife.c.a.c(view, R.id.dialog_for_progress_tips_tv, "field 'dialogForProgressTipsTv'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogProgressForRewardVideoAdTip dialogProgressForRewardVideoAdTip = this.b;
        if (dialogProgressForRewardVideoAdTip != null) {
            this.b = null;
            dialogProgressForRewardVideoAdTip.dialogForProgressTipsTv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
