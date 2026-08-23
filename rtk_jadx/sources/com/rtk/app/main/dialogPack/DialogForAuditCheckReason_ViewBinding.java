package com.rtk.app.main.dialogPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAuditCheckReason_ViewBinding implements Unbinder {
    private DialogForAuditCheckReason b;

    @UiThread
    public DialogForAuditCheckReason_ViewBinding(DialogForAuditCheckReason dialogForAuditCheckReason, View view) {
        this.b = dialogForAuditCheckReason;
        dialogForAuditCheckReason.dialogForBbsCheckReasonTagFlowLayout = (TagFlowLayout) butterknife.c.a.c(view, R.id.dialog_for_bbs_check_reason_tagFlowLayout, "field 'dialogForBbsCheckReasonTagFlowLayout'", TagFlowLayout.class);
    }

    @CallSuper
    public void a() {
        DialogForAuditCheckReason dialogForAuditCheckReason = this.b;
        if (dialogForAuditCheckReason != null) {
            this.b = null;
            dialogForAuditCheckReason.dialogForBbsCheckReasonTagFlowLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
