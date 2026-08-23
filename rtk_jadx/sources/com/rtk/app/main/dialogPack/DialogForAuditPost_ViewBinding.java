package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAuditPost_ViewBinding implements Unbinder {
    private DialogForAuditPost b;

    @UiThread
    public DialogForAuditPost_ViewBinding(DialogForAuditPost dialogForAuditPost, View view) {
        this.b = dialogForAuditPost;
        dialogForAuditPost.dialogForAuditPostLayoutSuggestion = (CustomTextView) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_suggestion, "field 'dialogForAuditPostLayoutSuggestion'", CustomTextView.class);
        dialogForAuditPost.dialogForAuditPostLayoutCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_cancel, "field 'dialogForAuditPostLayoutCancel'", TextView.class);
        dialogForAuditPost.dialogForAuditPostLayoutEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_ensure, "field 'dialogForAuditPostLayoutEnsure'", TextView.class);
        dialogForAuditPost.dialogForAuditPostLayoutRadioGroup = (RadioGroup) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_radioGroup, "field 'dialogForAuditPostLayoutRadioGroup'", RadioGroup.class);
        dialogForAuditPost.dialogForAuditPostLayoutReason = (EditText) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_reason, "field 'dialogForAuditPostLayoutReason'", EditText.class);
        dialogForAuditPost.dialogForAuditPostLayoutRadio1 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_radio1, "field 'dialogForAuditPostLayoutRadio1'", RadioButton.class);
        dialogForAuditPost.dialogForAuditPostLayoutRadio2 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_radio2, "field 'dialogForAuditPostLayoutRadio2'", RadioButton.class);
        dialogForAuditPost.dialogForAuditPostLayoutRadio3 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_radio3, "field 'dialogForAuditPostLayoutRadio3'", RadioButton.class);
        dialogForAuditPost.dialogForAuditPostLayoutRadio4 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_audit_post_layout_radio4, "field 'dialogForAuditPostLayoutRadio4'", RadioButton.class);
    }

    @CallSuper
    public void a() {
        DialogForAuditPost dialogForAuditPost = this.b;
        if (dialogForAuditPost != null) {
            this.b = null;
            dialogForAuditPost.dialogForAuditPostLayoutSuggestion = null;
            dialogForAuditPost.dialogForAuditPostLayoutCancel = null;
            dialogForAuditPost.dialogForAuditPostLayoutEnsure = null;
            dialogForAuditPost.dialogForAuditPostLayoutRadioGroup = null;
            dialogForAuditPost.dialogForAuditPostLayoutReason = null;
            dialogForAuditPost.dialogForAuditPostLayoutRadio1 = null;
            dialogForAuditPost.dialogForAuditPostLayoutRadio2 = null;
            dialogForAuditPost.dialogForAuditPostLayoutRadio3 = null;
            dialogForAuditPost.dialogForAuditPostLayoutRadio4 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
