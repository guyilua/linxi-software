package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForCommentOverAudit_ViewBinding implements Unbinder {
    private DialogForCommentOverAudit b;

    @UiThread
    public DialogForCommentOverAudit_ViewBinding(DialogForCommentOverAudit dialogForCommentOverAudit, View view) {
        this.b = dialogForCommentOverAudit;
        dialogForCommentOverAudit.dialogForCommentOverAuditCheck = (CheckBox) butterknife.c.a.c(view, R.id.dialog_for_comment_over_audit_check, "field 'dialogForCommentOverAuditCheck'", CheckBox.class);
        dialogForCommentOverAudit.dialogForCommentOverAuditEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_comment_over_audit_ensure, "field 'dialogForCommentOverAuditEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForCommentOverAudit dialogForCommentOverAudit = this.b;
        if (dialogForCommentOverAudit != null) {
            this.b = null;
            dialogForCommentOverAudit.dialogForCommentOverAuditCheck = null;
            dialogForCommentOverAudit.dialogForCommentOverAuditEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
