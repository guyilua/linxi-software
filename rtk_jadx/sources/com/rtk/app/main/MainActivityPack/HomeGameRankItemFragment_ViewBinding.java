package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameRankItemFragment_ViewBinding implements Unbinder {
    private HomeGameRankItemFragment b;

    @UiThread
    public HomeGameRankItemFragment_ViewBinding(HomeGameRankItemFragment homeGameRankItemFragment, View view) {
        this.b = homeGameRankItemFragment;
        homeGameRankItemFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.home2_item1_listView, "field 'fragementForListviewListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        HomeGameRankItemFragment homeGameRankItemFragment = this.b;
        if (homeGameRankItemFragment != null) {
            this.b = null;
            homeGameRankItemFragment.fragementForListviewListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
