package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.GridRadioGroup;
import com.zhy.view.flowlayout.TagFlowLayout;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForProhibitUser_ViewBinding implements Unbinder {
    private DialogForProhibitUser b;

    @UiThread
    public DialogForProhibitUser_ViewBinding(DialogForProhibitUser dialogForProhibitUser, View view) {
        this.b = dialogForProhibitUser;
        dialogForProhibitUser.dialogForProhibitUserCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_for_prohibit_user_cancel, "field 'dialogForProhibitUserCancel'", TextView.class);
        dialogForProhibitUser.dialogForProhibitUserEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_prohibit_user_ensure, "field 'dialogForProhibitUserEnsure'", TextView.class);
        dialogForProhibitUser.dialogForProhibitUserReasonTagFlowLayout = (TagFlowLayout) butterknife.c.a.c(view, R.id.dialog_for_prohibit_user_reason_tagFlowLayout, "field 'dialogForProhibitUserReasonTagFlowLayout'", TagFlowLayout.class);
        dialogForProhibitUser.dialogForProhibitUserReason = (EditText) butterknife.c.a.c(view, R.id.dialog_for_prohibit_user_reason, "field 'dialogForProhibitUserReason'", EditText.class);
        dialogForProhibitUser.dialogForProhibitDaysGroup = (GridRadioGroup) butterknife.c.a.c(view, R.id.dialog_for_prohibit_days_group, "field 'dialogForProhibitDaysGroup'", GridRadioGroup.class);
        dialogForProhibitUser.dialogForProhibitDaysGroup2 = (GridRadioGroup) butterknife.c.a.c(view, R.id.dialog_for_prohibit_days_group2, "field 'dialogForProhibitDaysGroup2'", GridRadioGroup.class);
    }

    @CallSuper
    public void a() {
        DialogForProhibitUser dialogForProhibitUser = this.b;
        if (dialogForProhibitUser != null) {
            this.b = null;
            dialogForProhibitUser.dialogForProhibitUserCancel = null;
            dialogForProhibitUser.dialogForProhibitUserEnsure = null;
            dialogForProhibitUser.dialogForProhibitUserReasonTagFlowLayout = null;
            dialogForProhibitUser.dialogForProhibitUserReason = null;
            dialogForProhibitUser.dialogForProhibitDaysGroup = null;
            dialogForProhibitUser.dialogForProhibitDaysGroup2 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
