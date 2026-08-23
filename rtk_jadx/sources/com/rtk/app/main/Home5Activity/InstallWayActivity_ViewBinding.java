package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InstallWayActivity_ViewBinding implements Unbinder {
    private InstallWayActivity b;

    @UiThread
    public InstallWayActivity_ViewBinding(InstallWayActivity installWayActivity, View view) {
        this.b = installWayActivity;
        installWayActivity.parent = (LinearLayout) butterknife.c.a.c(view, R.id.layout_parent, "field 'parent'", LinearLayout.class);
        installWayActivity.tips = (TextView) butterknife.c.a.c(view, R.id.tips, "field 'tips'", TextView.class);
    }

    @CallSuper
    public void a() {
        InstallWayActivity installWayActivity = this.b;
        if (installWayActivity != null) {
            this.b = null;
            installWayActivity.parent = null;
            installWayActivity.tips = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
