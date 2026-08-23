package com.rtk.app.main.Home5Activity.ClickHistory;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClickHistoryGameFragment_ViewBinding implements Unbinder {
    private ClickHistoryGameFragment b;

    @UiThread
    public ClickHistoryGameFragment_ViewBinding(ClickHistoryGameFragment clickHistoryGameFragment, View view) {
        this.b = clickHistoryGameFragment;
        clickHistoryGameFragment.clickListview = (AutoListView) butterknife.c.a.c(view, R.id.click_his_list, "field 'clickListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        ClickHistoryGameFragment clickHistoryGameFragment = this.b;
        if (clickHistoryGameFragment != null) {
            this.b = null;
            clickHistoryGameFragment.clickListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
