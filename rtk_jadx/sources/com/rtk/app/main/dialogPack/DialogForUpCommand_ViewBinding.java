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
public class DialogForUpCommand_ViewBinding implements Unbinder {
    private DialogForUpCommand b;

    @UiThread
    public DialogForUpCommand_ViewBinding(DialogForUpCommand dialogForUpCommand, View view) {
        this.b = dialogForUpCommand;
        dialogForUpCommand.dialogForCommandUpName = (TextView) butterknife.c.a.c(view, R.id.dialog_for_command_up_name, "field 'dialogForCommandUpName'", TextView.class);
        dialogForUpCommand.dialogForCommandUpLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.dialog_for_command_up_logo, "field 'dialogForCommandUpLogo'", RoundedImageView.class);
        dialogForUpCommand.dialogForCommandUpVersion = (TextView) butterknife.c.a.c(view, R.id.dialog_for_command_up_version, "field 'dialogForCommandUpVersion'", TextView.class);
        dialogForUpCommand.dialogForCommandUpSize = (TextView) butterknife.c.a.c(view, R.id.dialog_for_command_up_size, "field 'dialogForCommandUpSize'", TextView.class);
        dialogForUpCommand.dialogForCommandTitle = (TextView) butterknife.c.a.c(view, R.id.dialog_for_up_command_title, "field 'dialogForCommandTitle'", TextView.class);
        dialogForUpCommand.dialogForCommandUpParent = (RelativeLayout) butterknife.c.a.c(view, R.id.dialog_for_command_up_parent, "field 'dialogForCommandUpParent'", RelativeLayout.class);
        dialogForUpCommand.dialogForUpCommandClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_up_command_close, "field 'dialogForUpCommandClose'", ImageView.class);
        dialogForUpCommand.dialogForCommandUpLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_for_command_upLv, "field 'dialogForCommandUpLv'", LinearLayout.class);
        dialogForUpCommand.dialogForUpCommandLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_for_up_command_lv, "field 'dialogForUpCommandLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        DialogForUpCommand dialogForUpCommand = this.b;
        if (dialogForUpCommand != null) {
            this.b = null;
            dialogForUpCommand.dialogForCommandUpName = null;
            dialogForUpCommand.dialogForCommandUpLogo = null;
            dialogForUpCommand.dialogForCommandUpVersion = null;
            dialogForUpCommand.dialogForCommandUpSize = null;
            dialogForUpCommand.dialogForCommandTitle = null;
            dialogForUpCommand.dialogForCommandUpParent = null;
            dialogForUpCommand.dialogForUpCommandClose = null;
            dialogForUpCommand.dialogForCommandUpLv = null;
            dialogForUpCommand.dialogForUpCommandLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
