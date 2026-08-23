package com.rtk.app.main.family;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LatestFamilyActivity_ViewBinding implements Unbinder {
    private LatestFamilyActivity b;

    @UiThread
    public LatestFamilyActivity_ViewBinding(LatestFamilyActivity latestFamilyActivity, View view) {
        this.b = latestFamilyActivity;
        latestFamilyActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        latestFamilyActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        latestFamilyActivity.applyJoinList = butterknife.c.a.b(view, R.id.apply_join_list, "field 'applyJoinList'");
    }

    @CallSuper
    public void a() {
        LatestFamilyActivity latestFamilyActivity = this.b;
        if (latestFamilyActivity != null) {
            this.b = null;
            latestFamilyActivity.autoListView = null;
            latestFamilyActivity.backLayout = null;
            latestFamilyActivity.applyJoinList = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
