package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class InstallApkActivity_ViewBinding implements Unbinder {
    private InstallApkActivity b;

    @UiThread
    public InstallApkActivity_ViewBinding(InstallApkActivity installApkActivity, View view) {
        this.b = installApkActivity;
        installApkActivity.installApkTopBack = (TextView) butterknife.c.a.c(view, R.id.install_apk_top_back, "field 'installApkTopBack'", TextView.class);
        installApkActivity.installApkEmptyPath = (TextView) butterknife.c.a.c(view, R.id.install_apk_empty_path, "field 'installApkEmptyPath'", TextView.class);
        installApkActivity.installApkTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.install_apk_top_layout, "field 'installApkTopLayout'", LinearLayout.class);
        installApkActivity.installApkListView = (ListView) butterknife.c.a.c(view, R.id.install_apk_listView, "field 'installApkListView'", ListView.class);
        installApkActivity.installApkEmpty = (ImageView) butterknife.c.a.c(view, R.id.install_apk_empty, "field 'installApkEmpty'", ImageView.class);
        installApkActivity.installApkLayout = (LinearLayout) butterknife.c.a.c(view, R.id.install_apk_layout, "field 'installApkLayout'", LinearLayout.class);
        installApkActivity.installApkEmpty1 = (LinearLayout) butterknife.c.a.c(view, R.id.install_apk_empty1, "field 'installApkEmpty1'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        InstallApkActivity installApkActivity = this.b;
        if (installApkActivity != null) {
            this.b = null;
            installApkActivity.installApkTopBack = null;
            installApkActivity.installApkEmptyPath = null;
            installApkActivity.installApkTopLayout = null;
            installApkActivity.installApkListView = null;
            installApkActivity.installApkEmpty = null;
            installApkActivity.installApkLayout = null;
            installApkActivity.installApkEmpty1 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
