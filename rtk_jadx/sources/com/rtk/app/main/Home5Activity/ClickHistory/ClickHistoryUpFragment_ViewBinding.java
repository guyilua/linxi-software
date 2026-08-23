package com.rtk.app.main.Home5Activity.ClickHistory;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClickHistoryUpFragment_ViewBinding implements Unbinder {
    private ClickHistoryUpFragment b;

    @UiThread
    public ClickHistoryUpFragment_ViewBinding(ClickHistoryUpFragment clickHistoryUpFragment, View view) {
        this.b = clickHistoryUpFragment;
        clickHistoryUpFragment.clickListview = (AutoListView) butterknife.c.a.c(view, R.id.click_his_list, "field 'clickListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        ClickHistoryUpFragment clickHistoryUpFragment = this.b;
        if (clickHistoryUpFragment != null) {
            this.b = null;
            clickHistoryUpFragment.clickListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
