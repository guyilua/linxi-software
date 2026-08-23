package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogAddBlacklist_ViewBinding implements Unbinder {
    private DialogAddBlacklist b;

    @UiThread
    public DialogAddBlacklist_ViewBinding(DialogAddBlacklist dialogAddBlacklist, View view) {
        this.b = dialogAddBlacklist;
        dialogAddBlacklist.addBlacklistEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_add_blacklist_ensure, "field 'addBlacklistEnsure'", TextView.class);
        dialogAddBlacklist.addBlacklistCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_add_blacklist_cancel, "field 'addBlacklistCancel'", TextView.class);
        dialogAddBlacklist.layout = butterknife.c.a.b(view, 2131298916, "field 'layout'");
        dialogAddBlacklist.title = (TextView) butterknife.c.a.c(view, 2131300422, "field 'title'", TextView.class);
        dialogAddBlacklist.msg = (TextView) butterknife.c.a.c(view, R.id.msg, "field 'msg'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogAddBlacklist dialogAddBlacklist = this.b;
        if (dialogAddBlacklist != null) {
            this.b = null;
            dialogAddBlacklist.addBlacklistEnsure = null;
            dialogAddBlacklist.addBlacklistCancel = null;
            dialogAddBlacklist.layout = null;
            dialogAddBlacklist.title = null;
            dialogAddBlacklist.msg = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
