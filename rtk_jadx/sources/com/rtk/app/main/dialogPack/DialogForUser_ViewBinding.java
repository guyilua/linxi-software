package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForUser_ViewBinding implements Unbinder {
    private DialogForUser b;

    @UiThread
    public DialogForUser_ViewBinding(DialogForUser dialogForUser, View view) {
        this.b = dialogForUser;
        dialogForUser.dialogForUserCommandClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_user_command_close, "field 'dialogForUserCommandClose'", ImageView.class);
        dialogForUser.dialogForUserCommandIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.dialog_for_user_command_icon, "field 'dialogForUserCommandIcon'", RoundedImageView.class);
        dialogForUser.dialogForUserCommandNickname = (TextView) butterknife.c.a.c(view, R.id.dialog_for_user_command_nickname, "field 'dialogForUserCommandNickname'", TextView.class);
        dialogForUser.dialogForUserCommandSexAge = (TextView) butterknife.c.a.c(view, R.id.dialog_for_user_command_sex_age, "field 'dialogForUserCommandSexAge'", TextView.class);
        dialogForUser.dialogForUserCommandGrade = (TextView) butterknife.c.a.c(view, R.id.dialog_for_user_command_grade, "field 'dialogForUserCommandGrade'", TextView.class);
        dialogForUser.dialogForUserCommandAttention = (CustomTextView) butterknife.c.a.c(view, R.id.dialog_for_user_command_attention, "field 'dialogForUserCommandAttention'", CustomTextView.class);
        dialogForUser.dialogForUserCommandFans = (TextView) butterknife.c.a.c(view, R.id.dialog_for_user_command_fans, "field 'dialogForUserCommandFans'", TextView.class);
        dialogForUser.dialogForUserCommandDetail = (TextView) butterknife.c.a.c(view, R.id.dialog_for_user_command_detail, "field 'dialogForUserCommandDetail'", TextView.class);
        dialogForUser.dialogForUserCommandTitle = (TextView) butterknife.c.a.c(view, R.id.dialog_for_user_command_title, "field 'dialogForUserCommandTitle'", TextView.class);
        dialogForUser.dialogForUserCommandLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_for_user_command_lv, "field 'dialogForUserCommandLv'", LinearLayout.class);
        dialogForUser.dialogForUserCommandParent = (RelativeLayout) butterknife.c.a.c(view, R.id.dialog_for_user_command_parent, "field 'dialogForUserCommandParent'", RelativeLayout.class);
    }

    @CallSuper
    public void a() {
        DialogForUser dialogForUser = this.b;
        if (dialogForUser != null) {
            this.b = null;
            dialogForUser.dialogForUserCommandClose = null;
            dialogForUser.dialogForUserCommandIcon = null;
            dialogForUser.dialogForUserCommandNickname = null;
            dialogForUser.dialogForUserCommandSexAge = null;
            dialogForUser.dialogForUserCommandGrade = null;
            dialogForUser.dialogForUserCommandAttention = null;
            dialogForUser.dialogForUserCommandFans = null;
            dialogForUser.dialogForUserCommandDetail = null;
            dialogForUser.dialogForUserCommandTitle = null;
            dialogForUser.dialogForUserCommandLv = null;
            dialogForUser.dialogForUserCommandParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
