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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForFamily_ViewBinding implements Unbinder {
    private DialogForFamily b;

    @UiThread
    public DialogForFamily_ViewBinding(DialogForFamily dialogForFamily, View view) {
        this.b = dialogForFamily;
        dialogForFamily.dialogForUserCommandClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_family_command_close, "field 'dialogForUserCommandClose'", ImageView.class);
        dialogForFamily.dialogForUserCommandIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.dialog_for_family_command_icon, "field 'dialogForUserCommandIcon'", RoundedImageView.class);
        dialogForFamily.dialogForUserCommandDetail = (TextView) butterknife.c.a.c(view, R.id.dialog_for_family_command_detail, "field 'dialogForUserCommandDetail'", TextView.class);
        dialogForFamily.dialogForUserCommandName = (TextView) butterknife.c.a.c(view, R.id.dialog_for_family_command_name, "field 'dialogForUserCommandName'", TextView.class);
        dialogForFamily.dialogForUserCommandId = (TextView) butterknife.c.a.c(view, R.id.dialog_for_family_command_id, "field 'dialogForUserCommandId'", TextView.class);
        dialogForFamily.dialogForUserCommandNum = (TextView) butterknife.c.a.c(view, R.id.dialog_for_family_command_num, "field 'dialogForUserCommandNum'", TextView.class);
        dialogForFamily.dialogForUserCommandLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_for_family_command_lv, "field 'dialogForUserCommandLv'", LinearLayout.class);
        dialogForFamily.dialogForUserCommandTitle = (TextView) butterknife.c.a.c(view, R.id.dialog_for_family_command_title, "field 'dialogForUserCommandTitle'", TextView.class);
        dialogForFamily.dialogForUserCommandParent = (RelativeLayout) butterknife.c.a.c(view, R.id.dialog_for_family_command_parent, "field 'dialogForUserCommandParent'", RelativeLayout.class);
    }

    @CallSuper
    public void a() {
        DialogForFamily dialogForFamily = this.b;
        if (dialogForFamily != null) {
            this.b = null;
            dialogForFamily.dialogForUserCommandClose = null;
            dialogForFamily.dialogForUserCommandIcon = null;
            dialogForFamily.dialogForUserCommandDetail = null;
            dialogForFamily.dialogForUserCommandName = null;
            dialogForFamily.dialogForUserCommandId = null;
            dialogForFamily.dialogForUserCommandNum = null;
            dialogForFamily.dialogForUserCommandLv = null;
            dialogForFamily.dialogForUserCommandTitle = null;
            dialogForFamily.dialogForUserCommandParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
