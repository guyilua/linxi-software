package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForPublishUpSrcShowShatus_ViewBinding implements Unbinder {
    private DialogForPublishUpSrcShowShatus b;

    @UiThread
    public DialogForPublishUpSrcShowShatus_ViewBinding(DialogForPublishUpSrcShowShatus dialogForPublishUpSrcShowShatus, View view) {
        this.b = dialogForPublishUpSrcShowShatus;
        dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusPublic = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_publish_up_src_show_status_public, "field 'dialogForPublishUpSrcShowStatusPublic'", RadioButton.class);
        dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusNeedShare = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_publish_up_src_show_status_need_share, "field 'dialogForPublishUpSrcShowStatusNeedShare'", RadioButton.class);
        dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusPrivate = (RadioButton) butterknife.c.a.c(view, R.id.dialog_for_publish_up_src_show_status_private, "field 'dialogForPublishUpSrcShowStatusPrivate'", RadioButton.class);
        dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusGroup = (RadioGroup) butterknife.c.a.c(view, R.id.dialog_for_publish_up_src_show_status_group, "field 'dialogForPublishUpSrcShowStatusGroup'", RadioGroup.class);
    }

    @CallSuper
    public void a() {
        DialogForPublishUpSrcShowShatus dialogForPublishUpSrcShowShatus = this.b;
        if (dialogForPublishUpSrcShowShatus != null) {
            this.b = null;
            dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusPublic = null;
            dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusNeedShare = null;
            dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusPrivate = null;
            dialogForPublishUpSrcShowShatus.dialogForPublishUpSrcShowStatusGroup = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
