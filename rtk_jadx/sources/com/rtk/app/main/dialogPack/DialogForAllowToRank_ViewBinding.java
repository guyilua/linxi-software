package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAllowToRank_ViewBinding implements Unbinder {
    private DialogForAllowToRank b;

    @UiThread
    public DialogForAllowToRank_ViewBinding(DialogForAllowToRank dialogForAllowToRank, View view) {
        this.b = dialogForAllowToRank;
        dialogForAllowToRank.dialogForAllowToRankDownLoad = (TextView) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_downLoad, "field 'dialogForAllowToRankDownLoad'", TextView.class);
        dialogForAllowToRank.dialogForAllowToRankReword = (TextView) butterknife.c.a.c(view, R.id.dialog_for_allow_to_rank_reword, "field 'dialogForAllowToRankReword'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForAllowToRank dialogForAllowToRank = this.b;
        if (dialogForAllowToRank != null) {
            this.b = null;
            dialogForAllowToRank.dialogForAllowToRankDownLoad = null;
            dialogForAllowToRank.dialogForAllowToRankReword = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
