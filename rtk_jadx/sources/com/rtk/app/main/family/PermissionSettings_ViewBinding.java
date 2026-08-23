package com.rtk.app.main.family;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PermissionSettings_ViewBinding implements Unbinder {
    private PermissionSettings b;

    @UiThread
    public PermissionSettings_ViewBinding(PermissionSettings permissionSettings, View view) {
        this.b = permissionSettings;
        permissionSettings.fileAccess = (TextView) butterknife.c.a.c(view, R.id.go_storage_permission, "field 'fileAccess'", TextView.class);
        permissionSettings.installApp = (TextView) butterknife.c.a.c(view, R.id.go_install_permission, "field 'installApp'", TextView.class);
    }

    @CallSuper
    public void a() {
        PermissionSettings permissionSettings = this.b;
        if (permissionSettings != null) {
            this.b = null;
            permissionSettings.fileAccess = null;
            permissionSettings.installApp = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
