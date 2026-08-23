package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForProgressHorizontal_ViewBinding implements Unbinder {
    private DialogForProgressHorizontal b;

    @UiThread
    public DialogForProgressHorizontal_ViewBinding(DialogForProgressHorizontal dialogForProgressHorizontal, View view) {
        this.b = dialogForProgressHorizontal;
        dialogForProgressHorizontal.dialogForProgressHorizontalProgress = (ProgressBar) butterknife.c.a.c(view, R.id.dialog_for_progress_horizontal_progress, "field 'dialogForProgressHorizontalProgress'", ProgressBar.class);
        dialogForProgressHorizontal.dialogForProgressHorizontalPercent = (CustomTextView) butterknife.c.a.c(view, R.id.dialog_for_progress_horizontal_percent, "field 'dialogForProgressHorizontalPercent'", CustomTextView.class);
        dialogForProgressHorizontal.dialogForProgressHorizontalTipsTv = (TextView) butterknife.c.a.c(view, R.id.dialog_for_progress_horizontal_tips_tv, "field 'dialogForProgressHorizontalTipsTv'", TextView.class);
        dialogForProgressHorizontal.dialogForProgressHorizontalButton = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_progress_horizontal_button, "field 'dialogForProgressHorizontalButton'", ImageView.class);
    }

    @CallSuper
    public void a() {
        DialogForProgressHorizontal dialogForProgressHorizontal = this.b;
        if (dialogForProgressHorizontal != null) {
            this.b = null;
            dialogForProgressHorizontal.dialogForProgressHorizontalProgress = null;
            dialogForProgressHorizontal.dialogForProgressHorizontalPercent = null;
            dialogForProgressHorizontal.dialogForProgressHorizontalTipsTv = null;
            dialogForProgressHorizontal.dialogForProgressHorizontalButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
