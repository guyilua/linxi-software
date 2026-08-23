package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForGameCommentDeleteReason_ViewBinding implements Unbinder {
    private DialogForGameCommentDeleteReason b;

    @UiThread
    public DialogForGameCommentDeleteReason_ViewBinding(DialogForGameCommentDeleteReason dialogForGameCommentDeleteReason, View view) {
        this.b = dialogForGameCommentDeleteReason;
        dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonTagFlowLayout = (TagFlowLayout) butterknife.c.a.c(view, R.id.dialog_for_game_comment_delete_reason_tagFlowLayout, "field 'dialogForGameCommentDeleteReasonTagFlowLayout'", TagFlowLayout.class);
        dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonEdv = (EditText) butterknife.c.a.c(view, R.id.dialog_for_game_comment_delete_reason_edv, "field 'dialogForGameCommentDeleteReasonEdv'", EditText.class);
        dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_game_comment_delete_reason_cancel, "field 'dialogForGameCommentDeleteReasonCancel'", TextView.class);
        dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_game_comment_delete_reason_ensure, "field 'dialogForGameCommentDeleteReasonEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForGameCommentDeleteReason dialogForGameCommentDeleteReason = this.b;
        if (dialogForGameCommentDeleteReason != null) {
            this.b = null;
            dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonTagFlowLayout = null;
            dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonEdv = null;
            dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonCancel = null;
            dialogForGameCommentDeleteReason.dialogForGameCommentDeleteReasonEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
