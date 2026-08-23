package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UnInstallActivity_ViewBinding implements Unbinder {
    private UnInstallActivity b;

    @UiThread
    public UnInstallActivity_ViewBinding(UnInstallActivity unInstallActivity, View view) {
        this.b = unInstallActivity;
        unInstallActivity.unInstallTopBack = (TextView) butterknife.c.a.c(view, R.id.un_install_top_back, "field 'unInstallTopBack'", TextView.class);
        unInstallActivity.unInstallTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.un_install_top_layout, "field 'unInstallTopLayout'", LinearLayout.class);
        unInstallActivity.unInstallListview = (ListView) butterknife.c.a.c(view, R.id.un_install_listview, "field 'unInstallListview'", ListView.class);
    }

    @CallSuper
    public void a() {
        UnInstallActivity unInstallActivity = this.b;
        if (unInstallActivity != null) {
            this.b = null;
            unInstallActivity.unInstallTopBack = null;
            unInstallActivity.unInstallTopLayout = null;
            unInstallActivity.unInstallListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
