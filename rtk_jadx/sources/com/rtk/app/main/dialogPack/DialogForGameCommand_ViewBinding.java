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
public class DialogForGameCommand_ViewBinding implements Unbinder {
    private DialogForGameCommand b;

    @UiThread
    public DialogForGameCommand_ViewBinding(DialogForGameCommand dialogForGameCommand, View view) {
        this.b = dialogForGameCommand;
        dialogForGameCommand.dialogForGameCommandClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_game_command_close, "field 'dialogForGameCommandClose'", ImageView.class);
        dialogForGameCommand.dialogForCommandGameLogo = (RoundedImageView) butterknife.c.a.c(view, R.id.dialog_for_command_game_logo, "field 'dialogForCommandGameLogo'", RoundedImageView.class);
        dialogForGameCommand.dialogForCommandGameName = (TextView) butterknife.c.a.c(view, R.id.dialog_for_command_game_name, "field 'dialogForCommandGameName'", TextView.class);
        dialogForGameCommand.dialogForCommandGameVersion = (CustomTextView) butterknife.c.a.c(view, R.id.dialog_for_command_game_version, "field 'dialogForCommandGameVersion'", CustomTextView.class);
        dialogForGameCommand.dialogForCommandGameSize = (TextView) butterknife.c.a.c(view, R.id.dialog_for_command_game_size, "field 'dialogForCommandGameSize'", TextView.class);
        dialogForGameCommand.dialogForCommandGameTitle = (TextView) butterknife.c.a.c(view, R.id.dialog_for_game_command_title, "field 'dialogForCommandGameTitle'", TextView.class);
        dialogForGameCommand.dialogForCommandGameLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_for_command_gameLv, "field 'dialogForCommandGameLv'", LinearLayout.class);
        dialogForGameCommand.dialogForCommandGameParent = (RelativeLayout) butterknife.c.a.c(view, R.id.dialog_for_command_game_parent, "field 'dialogForCommandGameParent'", RelativeLayout.class);
        dialogForGameCommand.dialogForGameCommandLv = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_for_game_command_lv, "field 'dialogForGameCommandLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        DialogForGameCommand dialogForGameCommand = this.b;
        if (dialogForGameCommand != null) {
            this.b = null;
            dialogForGameCommand.dialogForGameCommandClose = null;
            dialogForGameCommand.dialogForCommandGameLogo = null;
            dialogForGameCommand.dialogForCommandGameName = null;
            dialogForGameCommand.dialogForCommandGameVersion = null;
            dialogForGameCommand.dialogForCommandGameSize = null;
            dialogForGameCommand.dialogForCommandGameTitle = null;
            dialogForGameCommand.dialogForCommandGameLv = null;
            dialogForGameCommand.dialogForCommandGameParent = null;
            dialogForGameCommand.dialogForGameCommandLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
