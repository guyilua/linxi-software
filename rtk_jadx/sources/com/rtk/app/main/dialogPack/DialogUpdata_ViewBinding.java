package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogUpdata_ViewBinding implements Unbinder {
    private DialogUpdata b;

    @UiThread
    public DialogUpdata_ViewBinding(DialogUpdata dialogUpdata, View view) {
        this.b = dialogUpdata;
        dialogUpdata.dialogUpdataTopLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.dialog_updata_top_layout, "field 'dialogUpdataTopLayout'", RelativeLayout.class);
        dialogUpdata.dialog_updayaProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.dialog_updayaProgressBar, "field 'dialog_updayaProgressBar'", ProgressBar.class);
        dialogUpdata.dialogUpdataCancel = (ImageView) butterknife.c.a.c(view, R.id.dialog_updata_cancel, "field 'dialogUpdataCancel'", ImageView.class);
        dialogUpdata.dialogUpdataContent = (TextView) butterknife.c.a.c(view, R.id.dialog_updata_content, "field 'dialogUpdataContent'", TextView.class);
        dialogUpdata.dialogUpdataEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_updata_ensure, "field 'dialogUpdataEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogUpdata dialogUpdata = this.b;
        if (dialogUpdata != null) {
            this.b = null;
            dialogUpdata.dialogUpdataTopLayout = null;
            dialogUpdata.dialog_updayaProgressBar = null;
            dialogUpdata.dialogUpdataCancel = null;
            dialogUpdata.dialogUpdataContent = null;
            dialogUpdata.dialogUpdataEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
