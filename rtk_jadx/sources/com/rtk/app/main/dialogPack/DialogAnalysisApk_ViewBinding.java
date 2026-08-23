package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogAnalysisApk_ViewBinding implements Unbinder {
    private DialogAnalysisApk b;

    @UiThread
    public DialogAnalysisApk_ViewBinding(DialogAnalysisApk dialogAnalysisApk, View view) {
        this.b = dialogAnalysisApk;
        dialogAnalysisApk.dialogAnalysisApkTip = (TextView) butterknife.c.a.c(view, R.id.dialog_analysis_apk_tip, "field 'dialogAnalysisApkTip'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogAnalysisApk dialogAnalysisApk = this.b;
        if (dialogAnalysisApk != null) {
            this.b = null;
            dialogAnalysisApk.dialogAnalysisApkTip = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
