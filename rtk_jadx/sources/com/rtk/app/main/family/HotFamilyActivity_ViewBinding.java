package com.rtk.app.main.family;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HotFamilyActivity_ViewBinding implements Unbinder {
    private HotFamilyActivity b;

    @UiThread
    public HotFamilyActivity_ViewBinding(HotFamilyActivity hotFamilyActivity, View view) {
        this.b = hotFamilyActivity;
        hotFamilyActivity.autoListView = (AutoListView) butterknife.c.a.c(view, R.id.listview, "field 'autoListView'", AutoListView.class);
        hotFamilyActivity.backTv = (TextView) butterknife.c.a.c(view, R.id.backTV, "field 'backTv'", TextView.class);
        hotFamilyActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        hotFamilyActivity.applyJoinList = butterknife.c.a.b(view, R.id.apply_join_list, "field 'applyJoinList'");
    }

    @CallSuper
    public void a() {
        HotFamilyActivity hotFamilyActivity = this.b;
        if (hotFamilyActivity != null) {
            this.b = null;
            hotFamilyActivity.autoListView = null;
            hotFamilyActivity.backTv = null;
            hotFamilyActivity.backLayout = null;
            hotFamilyActivity.applyJoinList = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
