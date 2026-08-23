package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FansBoardFragment_ViewBinding implements Unbinder {
    private FansBoardFragment b;

    @UiThread
    public FansBoardFragment_ViewBinding(FansBoardFragment fansBoardFragment, View view) {
        this.b = fansBoardFragment;
        fansBoardFragment.homeUpExpertFragmentListview = (AutoListView) butterknife.c.a.c(view, R.id.home_up_expert_fragment_listview, "field 'homeUpExpertFragmentListview'", AutoListView.class);
        fansBoardFragment.homeUpExpertFragmentParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_expert_parent_layout, "field 'homeUpExpertFragmentParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        FansBoardFragment fansBoardFragment = this.b;
        if (fansBoardFragment != null) {
            this.b = null;
            fansBoardFragment.homeUpExpertFragmentListview = null;
            fansBoardFragment.homeUpExpertFragmentParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
