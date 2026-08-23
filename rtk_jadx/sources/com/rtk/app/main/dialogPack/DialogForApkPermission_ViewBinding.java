package com.rtk.app.main.dialogPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForApkPermission_ViewBinding implements Unbinder {
    private DialogForApkPermission b;

    @UiThread
    public DialogForApkPermission_ViewBinding(DialogForApkPermission dialogForApkPermission, View view) {
        this.b = dialogForApkPermission;
        dialogForApkPermission.dialogForApkPermissionListView = (ListView) butterknife.c.a.c(view, R.id.dialog_for_apk_permission_listView, "field 'dialogForApkPermissionListView'", ListView.class);
        dialogForApkPermission.dialogForApkPermissionClose = (ImageView) butterknife.c.a.c(view, R.id.dialog_for_apk_permission_close, "field 'dialogForApkPermissionClose'", ImageView.class);
    }

    @CallSuper
    public void a() {
        DialogForApkPermission dialogForApkPermission = this.b;
        if (dialogForApkPermission != null) {
            this.b = null;
            dialogForApkPermission.dialogForApkPermissionListView = null;
            dialogForApkPermission.dialogForApkPermissionClose = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
