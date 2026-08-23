package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.GridViewForScrollView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogScreenForClassifyUpApk_ViewBinding implements Unbinder {
    private DialogScreenForClassifyUpApk b;

    @UiThread
    public DialogScreenForClassifyUpApk_ViewBinding(DialogScreenForClassifyUpApk dialogScreenForClassifyUpApk, View view) {
        this.b = dialogScreenForClassifyUpApk;
        dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_screen_for_classify_up_apk_close, "field 'dialogScreenForClassifyUpApkClose'", ImageView.class);
        dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkSize = (GridViewForScrollView) butterknife.c.a.c(view, R.id.dialog_screen_for_classify_up_apk_size, "field 'dialogScreenForClassifyUpApkSize'", GridViewForScrollView.class);
        dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkLanguage = (GridViewForScrollView) butterknife.c.a.c(view, R.id.dialog_screen_for_classify_up_apk_language, "field 'dialogScreenForClassifyUpApkLanguage'", GridViewForScrollView.class);
        dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_screen_for_classify_up_apk_ensure, "field 'dialogScreenForClassifyUpApkEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogScreenForClassifyUpApk dialogScreenForClassifyUpApk = this.b;
        if (dialogScreenForClassifyUpApk != null) {
            this.b = null;
            dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkClose = null;
            dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkSize = null;
            dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkLanguage = null;
            dialogScreenForClassifyUpApk.dialogScreenForClassifyUpApkEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
