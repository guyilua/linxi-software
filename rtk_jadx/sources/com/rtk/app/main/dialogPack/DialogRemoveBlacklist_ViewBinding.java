package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogRemoveBlacklist_ViewBinding implements Unbinder {
    private DialogRemoveBlacklist b;

    @UiThread
    public DialogRemoveBlacklist_ViewBinding(DialogRemoveBlacklist dialogRemoveBlacklist, View view) {
        this.b = dialogRemoveBlacklist;
        dialogRemoveBlacklist.removeBlacklistTip = (TextView) butterknife.c.a.c(view, R.id.dialog_remove_blacklist_tip, "field 'removeBlacklistTip'", TextView.class);
        dialogRemoveBlacklist.removeBlacklistEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_remove_blacklist_ensure, "field 'removeBlacklistEnsure'", TextView.class);
        dialogRemoveBlacklist.removeBlacklistCancel = (TextView) butterknife.c.a.c(view, R.id.dialog_remove_blacklist_cancel, "field 'removeBlacklistCancel'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogRemoveBlacklist dialogRemoveBlacklist = this.b;
        if (dialogRemoveBlacklist != null) {
            this.b = null;
            dialogRemoveBlacklist.removeBlacklistTip = null;
            dialogRemoveBlacklist.removeBlacklistEnsure = null;
            dialogRemoveBlacklist.removeBlacklistCancel = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
