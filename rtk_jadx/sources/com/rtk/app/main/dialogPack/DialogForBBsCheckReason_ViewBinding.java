package com.rtk.app.main.dialogPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForBBsCheckReason_ViewBinding implements Unbinder {
    private DialogForBBsCheckReason b;

    @UiThread
    public DialogForBBsCheckReason_ViewBinding(DialogForBBsCheckReason dialogForBBsCheckReason, View view) {
        this.b = dialogForBBsCheckReason;
        dialogForBBsCheckReason.dialogForBbsCheckReasonTagFlowLayout = (TagFlowLayout) butterknife.c.a.c(view, R.id.dialog_for_bbs_check_reason_tagFlowLayout, "field 'dialogForBbsCheckReasonTagFlowLayout'", TagFlowLayout.class);
    }

    @CallSuper
    public void a() {
        DialogForBBsCheckReason dialogForBBsCheckReason = this.b;
        if (dialogForBBsCheckReason != null) {
            this.b = null;
            dialogForBBsCheckReason.dialogForBbsCheckReasonTagFlowLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
