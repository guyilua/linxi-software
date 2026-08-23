package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.GridRadioGroup;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAllowToRankReason_ViewBinding implements Unbinder {
    private DialogForAllowToRankReason b;

    @UiThread
    public DialogForAllowToRankReason_ViewBinding(DialogForAllowToRankReason dialogForAllowToRankReason, View view) {
        this.b = dialogForAllowToRankReason;
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays1 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days1, "field 'dialogForAllowToRankReasonProhibitDays1'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays36500 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days36500, "field 'dialogForAllowToRankReasonProhibitDays36500'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays7 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days7, "field 'dialogForAllowToRankReasonProhibitDays7'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays15 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days15, "field 'dialogForAllowToRankReasonProhibitDays15'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays30 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days30, "field 'dialogForAllowToRankReasonProhibitDays30'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays90 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days90, "field 'dialogForAllowToRankReasonProhibitDays90'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays180 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days180, "field 'dialogForAllowToRankReasonProhibitDays180'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays365 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days365, "field 'dialogForAllowToRankReasonProhibitDays365'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays1095 = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days1095, "field 'dialogForAllowToRankReasonProhibitDays1095'", RadioButton.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDaysGroup = (GridRadioGroup) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_prohibit_days_group, "field 'dialogForAllowToRankReasonProhibitDaysGroup'", GridRadioGroup.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonReason = (EditText) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_reason, "field 'dialogForAllowToRankReasonReason'", EditText.class);
        dialogForAllowToRankReason.dialogForAllowToRankReasonEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reason_ensure, "field 'dialogForAllowToRankReasonEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForAllowToRankReason dialogForAllowToRankReason = this.b;
        if (dialogForAllowToRankReason != null) {
            this.b = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays1 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays36500 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays7 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays15 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays30 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays90 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays180 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays365 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDays1095 = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonProhibitDaysGroup = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonReason = null;
            dialogForAllowToRankReason.dialogForAllowToRankReasonEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
