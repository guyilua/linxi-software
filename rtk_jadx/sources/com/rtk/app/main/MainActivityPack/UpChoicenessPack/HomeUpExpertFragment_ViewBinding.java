package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpExpertFragment_ViewBinding implements Unbinder {
    private HomeUpExpertFragment b;

    @UiThread
    public HomeUpExpertFragment_ViewBinding(HomeUpExpertFragment homeUpExpertFragment, View view) {
        this.b = homeUpExpertFragment;
        homeUpExpertFragment.homeUpExpertFragmentListview = (AutoListView) butterknife.c.a.c(view, R.id.home_up_expert_fragment_listview, "field 'homeUpExpertFragmentListview'", AutoListView.class);
        homeUpExpertFragment.homeUpExpertFragmentParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.home_up_expert_parent_layout, "field 'homeUpExpertFragmentParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        HomeUpExpertFragment homeUpExpertFragment = this.b;
        if (homeUpExpertFragment != null) {
            this.b = null;
            homeUpExpertFragment.homeUpExpertFragmentListview = null;
            homeUpExpertFragment.homeUpExpertFragmentParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
