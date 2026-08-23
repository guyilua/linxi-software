package com.rtk.app.main.Home5Activity.ClickHistory;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClickHistoryPostFragment_ViewBinding implements Unbinder {
    private ClickHistoryPostFragment b;

    @UiThread
    public ClickHistoryPostFragment_ViewBinding(ClickHistoryPostFragment clickHistoryPostFragment, View view) {
        this.b = clickHistoryPostFragment;
        clickHistoryPostFragment.clickListview = (AutoListView) butterknife.c.a.c(view, R.id.click_his_list, "field 'clickListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        ClickHistoryPostFragment clickHistoryPostFragment = this.b;
        if (clickHistoryPostFragment != null) {
            this.b = null;
            clickHistoryPostFragment.clickListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
