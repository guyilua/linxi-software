package com.rtk.app.main.Home5Activity.ClickHistory;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClickHistoryUserFragment_ViewBinding implements Unbinder {
    private ClickHistoryUserFragment b;

    @UiThread
    public ClickHistoryUserFragment_ViewBinding(ClickHistoryUserFragment clickHistoryUserFragment, View view) {
        this.b = clickHistoryUserFragment;
        clickHistoryUserFragment.clickListview = (AutoListView) butterknife.c.a.c(view, R.id.click_his_list, "field 'clickListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        ClickHistoryUserFragment clickHistoryUserFragment = this.b;
        if (clickHistoryUserFragment != null) {
            this.b = null;
            clickHistoryUserFragment.clickListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
