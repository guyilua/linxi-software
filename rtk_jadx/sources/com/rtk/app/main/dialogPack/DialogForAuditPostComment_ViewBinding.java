package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAuditPostComment_ViewBinding implements Unbinder {
    private DialogForAuditPostComment b;

    @UiThread
    public DialogForAuditPostComment_ViewBinding(DialogForAuditPostComment dialogForAuditPostComment, View view) {
        this.b = dialogForAuditPostComment;
        dialogForAuditPostComment.dialogForAuditPostCommentLayoutGoDetails = (TextView) butterknife.c.a.c(view, R.id.dialog_for_audit_post_comment_layout_go_details, "field 'dialogForAuditPostCommentLayoutGoDetails'", TextView.class);
        dialogForAuditPostComment.dialogForAuditPostCommentLayoutCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_audit_post_comment_layout_cancel, "field 'dialogForAuditPostCommentLayoutCancel'", TextView.class);
        dialogForAuditPostComment.dialogForAuditPostCommentLayoutEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_audit_post_comment_layout_ensure, "field 'dialogForAuditPostCommentLayoutEnsure'", TextView.class);
        dialogForAuditPostComment.dialogForAuditPostCommentLayoutRadioGroup = (RadioGroup) butterknife.c.a.c(view, R.id.dialog_for_audit_post_comment_layout_radioGroup, "field 'dialogForAuditPostCommentLayoutRadioGroup'", RadioGroup.class);
        dialogForAuditPostComment.dialogForAuditPostCommentLayoutReason = (EditText) butterknife.c.a.c(view, R.id.dialog_for_audit_post_comment_layout_reason, "field 'dialogForAuditPostCommentLayoutReason'", EditText.class);
    }

    @CallSuper
    public void a() {
        DialogForAuditPostComment dialogForAuditPostComment = this.b;
        if (dialogForAuditPostComment != null) {
            this.b = null;
            dialogForAuditPostComment.dialogForAuditPostCommentLayoutGoDetails = null;
            dialogForAuditPostComment.dialogForAuditPostCommentLayoutCancel = null;
            dialogForAuditPostComment.dialogForAuditPostCommentLayoutEnsure = null;
            dialogForAuditPostComment.dialogForAuditPostCommentLayoutRadioGroup = null;
            dialogForAuditPostComment.dialogForAuditPostCommentLayoutReason = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
