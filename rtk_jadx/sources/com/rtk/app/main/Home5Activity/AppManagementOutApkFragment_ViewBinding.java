package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppManagementOutApkFragment_ViewBinding implements Unbinder {
    private AppManagementOutApkFragment b;

    @UiThread
    public AppManagementOutApkFragment_ViewBinding(AppManagementOutApkFragment appManagementOutApkFragment, View view) {
        this.b = appManagementOutApkFragment;
        appManagementOutApkFragment.appManagementOutApkListView = (AutoListView) butterknife.c.a.c(view, R.id.app_management_out_apk_listView, "field 'appManagementOutApkListView'", AutoListView.class);
        appManagementOutApkFragment.appManagementOutApkUnInstallSelect = (TextView) butterknife.c.a.c(view, R.id.app_management_out_apk_unInstallSelect, "field 'appManagementOutApkUnInstallSelect'", TextView.class);
        appManagementOutApkFragment.appManagementOutApkTopSearchTv = (EditText) butterknife.c.a.c(view, R.id.app_management_out_apk_top_searchTv, "field 'appManagementOutApkTopSearchTv'", EditText.class);
        appManagementOutApkFragment.appManagementOutApkTopSearchBtu = (ImageView) butterknife.c.a.c(view, R.id.app_management_out_apk_top_searchBtu, "field 'appManagementOutApkTopSearchBtu'", ImageView.class);
        appManagementOutApkFragment.appManagementOutApkTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.app_management_out_apk_top_layout, "field 'appManagementOutApkTopLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        AppManagementOutApkFragment appManagementOutApkFragment = this.b;
        if (appManagementOutApkFragment != null) {
            this.b = null;
            appManagementOutApkFragment.appManagementOutApkListView = null;
            appManagementOutApkFragment.appManagementOutApkUnInstallSelect = null;
            appManagementOutApkFragment.appManagementOutApkTopSearchTv = null;
            appManagementOutApkFragment.appManagementOutApkTopSearchBtu = null;
            appManagementOutApkFragment.appManagementOutApkTopLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
