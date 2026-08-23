package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForOpenDeveloperUrl_ViewBinding implements Unbinder {
    private DialogForOpenDeveloperUrl b;

    @UiThread
    public DialogForOpenDeveloperUrl_ViewBinding(DialogForOpenDeveloperUrl dialogForOpenDeveloperUrl, View view) {
        this.b = dialogForOpenDeveloperUrl;
        dialogForOpenDeveloperUrl.dialogForOpenDeveloperUrlEnsure = (TextView) butterknife.c.a.c(view, R.id.dialog_for_open_developer_url_ensure, "field 'dialogForOpenDeveloperUrlEnsure'", TextView.class);
    }

    @CallSuper
    public void a() {
        DialogForOpenDeveloperUrl dialogForOpenDeveloperUrl = this.b;
        if (dialogForOpenDeveloperUrl != null) {
            this.b = null;
            dialogForOpenDeveloperUrl.dialogForOpenDeveloperUrlEnsure = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
