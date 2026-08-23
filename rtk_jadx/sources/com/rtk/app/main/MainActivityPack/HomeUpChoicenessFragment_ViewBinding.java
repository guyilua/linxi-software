package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.YcRecyclerView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpChoicenessFragment_ViewBinding implements Unbinder {
    private HomeUpChoicenessFragment b;

    @UiThread
    public HomeUpChoicenessFragment_ViewBinding(HomeUpChoicenessFragment homeUpChoicenessFragment, View view) {
        this.b = homeUpChoicenessFragment;
        homeUpChoicenessFragment.homeUpChoicenessLayoutRecyclerView = (YcRecyclerView) butterknife.c.a.c(view, R.id.home_up_choiceness_layout_recyclerView, "field 'homeUpChoicenessLayoutRecyclerView'", YcRecyclerView.class);
        homeUpChoicenessFragment.homeUpChoicenessLayoutParent = (RelativeLayout) butterknife.c.a.c(view, R.id.home_up_choiceness_layout_parent, "field 'homeUpChoicenessLayoutParent'", RelativeLayout.class);
        homeUpChoicenessFragment.homeUpChoicenessLayoutSwiprefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.home_up_choiceness_layout_swiprefresh, "field 'homeUpChoicenessLayoutSwiprefresh'", SwipeRefreshLayout.class);
        homeUpChoicenessFragment.homeUpChoicenessPublishUp = (ImageView) butterknife.c.a.c(view, R.id.home_up_choiceness_publish_up, "field 'homeUpChoicenessPublishUp'", ImageView.class);
    }

    @CallSuper
    public void a() {
        HomeUpChoicenessFragment homeUpChoicenessFragment = this.b;
        if (homeUpChoicenessFragment != null) {
            this.b = null;
            homeUpChoicenessFragment.homeUpChoicenessLayoutRecyclerView = null;
            homeUpChoicenessFragment.homeUpChoicenessLayoutParent = null;
            homeUpChoicenessFragment.homeUpChoicenessLayoutSwiprefresh = null;
            homeUpChoicenessFragment.homeUpChoicenessPublishUp = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
