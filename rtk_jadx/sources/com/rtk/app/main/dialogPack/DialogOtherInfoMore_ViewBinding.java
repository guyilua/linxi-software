package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogOtherInfoMore_ViewBinding implements Unbinder {
    private DialogOtherInfoMore b;

    @UiThread
    public DialogOtherInfoMore_ViewBinding(DialogOtherInfoMore dialogOtherInfoMore, View view) {
        this.b = dialogOtherInfoMore;
        dialogOtherInfoMore.otherInfoReport = (TextView) butterknife.c.a.c(view, R.id.dialog_other_info_report, "field 'otherInfoReport'", TextView.class);
        dialogOtherInfoMore.otherInfoBlacklist = (TextView) butterknife.c.a.c(view, R.id.dialog_oth_info_blacklist, "field 'otherInfoBlacklist'", TextView.class);
        dialogOtherInfoMore.otherInfoCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_oth_info_cancel, "field 'otherInfoCancel'", TextView.class);
        dialogOtherInfoMore.nickNameTv = (TextView) butterknife.c.a.c(view, R.id.nick_name, "field 'nickNameTv'", TextView.class);
        dialogOtherInfoMore.nickNameLine = butterknife.c.a.b(view, R.id.nick_name_line, "field 'nickNameLine'");
    }

    @CallSuper
    public void a() {
        DialogOtherInfoMore dialogOtherInfoMore = this.b;
        if (dialogOtherInfoMore != null) {
            this.b = null;
            dialogOtherInfoMore.otherInfoReport = null;
            dialogOtherInfoMore.otherInfoBlacklist = null;
            dialogOtherInfoMore.otherInfoCancel = null;
            dialogOtherInfoMore.nickNameTv = null;
            dialogOtherInfoMore.nickNameLine = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
