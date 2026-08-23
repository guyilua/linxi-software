package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogPostReward_ViewBinding implements Unbinder {
    private DialogPostReward b;

    @UiThread
    public DialogPostReward_ViewBinding(DialogPostReward dialogPostReward, View view) {
        this.b = dialogPostReward;
        dialogPostReward.postDialogRewardEnsure = (TextView) butterknife.c.a.c(view, R.id.post_dialog_reward_ensure, "field 'postDialogRewardEnsure'", TextView.class);
        dialogPostReward.postDialogRewardUserName = (TextView) butterknife.c.a.c(view, R.id.post_dialog_reward_userName, "field 'postDialogRewardUserName'", TextView.class);
        dialogPostReward.postDialogRewardNum = (TextView) butterknife.c.a.c(view, R.id.post_dialog_reward_Num, "field 'postDialogRewardNum'", TextView.class);
        dialogPostReward.postDialogRewardUserIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.post_dialog_reward_userIcon, "field 'postDialogRewardUserIcon'", RoundedImageView.class);
        dialogPostReward.dialogRewardRadioGroup1 = (RadioGroup) butterknife.c.a.c(view, R.id.dialog_reward_radioGroup1, "field 'dialogRewardRadioGroup1'", RadioGroup.class);
        dialogPostReward.dialogRewardRadioGroup2 = (RadioGroup) butterknife.c.a.c(view, R.id.dialog_reward_radioGroup2, "field 'dialogRewardRadioGroup2'", RadioGroup.class);
        dialogPostReward.postDialogRewardOther = (EditText) butterknife.c.a.c(view, R.id.post_dialog_reward_other, "field 'postDialogRewardOther'", EditText.class);
        dialogPostReward.postDialogRewardRadio1 = (RadioButton) butterknife.c.a.c(view, R.id.post_dialog_reward_radio1, "field 'postDialogRewardRadio1'", RadioButton.class);
        dialogPostReward.postDialogRewardRadio2 = (RadioButton) butterknife.c.a.c(view, R.id.post_dialog_reward_radio2, "field 'postDialogRewardRadio2'", RadioButton.class);
        dialogPostReward.postDialogRewardRadio3 = (RadioButton) butterknife.c.a.c(view, R.id.post_dialog_reward_radio3, "field 'postDialogRewardRadio3'", RadioButton.class);
        dialogPostReward.postDialogRewardRadio4 = (RadioButton) butterknife.c.a.c(view, R.id.post_dialog_reward_radio4, "field 'postDialogRewardRadio4'", RadioButton.class);
        dialogPostReward.postDialogRewardRadio5 = (RadioButton) butterknife.c.a.c(view, R.id.post_dialog_reward_radio5, "field 'postDialogRewardRadio5'", RadioButton.class);
        dialogPostReward.postDialogRewardReason = (EditText) butterknife.c.a.c(view, R.id.post_dialog_reward_reason, "field 'postDialogRewardReason'", EditText.class);
    }

    @CallSuper
    public void a() {
        DialogPostReward dialogPostReward = this.b;
        if (dialogPostReward != null) {
            this.b = null;
            dialogPostReward.postDialogRewardEnsure = null;
            dialogPostReward.postDialogRewardUserName = null;
            dialogPostReward.postDialogRewardNum = null;
            dialogPostReward.postDialogRewardUserIcon = null;
            dialogPostReward.dialogRewardRadioGroup1 = null;
            dialogPostReward.dialogRewardRadioGroup2 = null;
            dialogPostReward.postDialogRewardOther = null;
            dialogPostReward.postDialogRewardRadio1 = null;
            dialogPostReward.postDialogRewardRadio2 = null;
            dialogPostReward.postDialogRewardRadio3 = null;
            dialogPostReward.postDialogRewardRadio4 = null;
            dialogPostReward.postDialogRewardRadio5 = null;
            dialogPostReward.postDialogRewardReason = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
