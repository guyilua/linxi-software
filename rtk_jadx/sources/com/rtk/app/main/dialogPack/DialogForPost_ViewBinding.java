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
public class DialogForPost_ViewBinding implements Unbinder {
    private DialogForPost b;

    @UiThread
    public DialogForPost_ViewBinding(DialogForPost dialogForPost, View view) {
        this.b = dialogForPost;
        dialogForPost.dialogForCommandClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_post_command_close, "field 'dialogForCommandClose'", ImageView.class);
        dialogForPost.dialogForCommandLV = (LinearLayout) butterknife.c.a.c(view, R.id.dialog_for_post_command_lv, "field 'dialogForCommandLV'", LinearLayout.class);
        dialogForPost.dialogForCommandParent = (RelativeLayout) butterknife.c.a.c(view, R.id.dialog_for_post_command_parent, "field 'dialogForCommandParent'", RelativeLayout.class);
        dialogForPost.dialogForCommandIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.dialog_for_command_post_icon, "field 'dialogForCommandIcon'", RoundedImageView.class);
        dialogForPost.dialogForCommandTitle = (CustomTextView) butterknife.c.a.c(view, R.id.dialog_for_command_post_title, "field 'dialogForCommandTitle'", CustomTextView.class);
        dialogForPost.dialogForCommandNickname = (TextView) butterknife.c.a.c(view, R.id.dialog_for_command_post_nickname, "field 'dialogForCommandNickname'", TextView.class);
        dialogForPost.dialogForCommandDetail = (TextView) butterknife.c.a.c(view, R.id.dialog_for_command_post_detail, "field 'dialogForCommandDetail'", TextView.class);
        dialogForPost.dialogForCommandTopTitle = (TextView) butterknife.c.a.c(view, R.id.dialog_for_post_command_title, "field 'dialogForCommandTopTitle'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForPost dialogForPost = this.b;
        if (dialogForPost != null) {
            this.b = null;
            dialogForPost.dialogForCommandClose = null;
            dialogForPost.dialogForCommandLV = null;
            dialogForPost.dialogForCommandParent = null;
            dialogForPost.dialogForCommandIcon = null;
            dialogForPost.dialogForCommandTitle = null;
            dialogForPost.dialogForCommandNickname = null;
            dialogForPost.dialogForCommandDetail = null;
            dialogForPost.dialogForCommandTopTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
