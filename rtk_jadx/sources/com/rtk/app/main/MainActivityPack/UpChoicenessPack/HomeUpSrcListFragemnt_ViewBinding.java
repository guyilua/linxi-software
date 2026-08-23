package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpSrcListFragemnt_ViewBinding implements Unbinder {
    private HomeUpSrcListFragemnt b;

    @UiThread
    public HomeUpSrcListFragemnt_ViewBinding(HomeUpSrcListFragemnt homeUpSrcListFragemnt, View view) {
        this.b = homeUpSrcListFragemnt;
        homeUpSrcListFragemnt.upApkListFragmentListview = (AutoListView) butterknife.c.a.c(view, R.id.up_apk_list_fragment_listview, "field 'upApkListFragmentListview'", AutoListView.class);
        homeUpSrcListFragemnt.upApkListFragmentSearch = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_fragment_search, "field 'upApkListFragmentSearch'", TextView.class);
        homeUpSrcListFragemnt.upApkListFragmentScreen = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_fragment_screen, "field 'upApkListFragmentScreen'", TextView.class);
    }

    @CallSuper
    public void a() {
        HomeUpSrcListFragemnt homeUpSrcListFragemnt = this.b;
        if (homeUpSrcListFragemnt != null) {
            this.b = null;
            homeUpSrcListFragemnt.upApkListFragmentListview = null;
            homeUpSrcListFragemnt.upApkListFragmentSearch = null;
            homeUpSrcListFragemnt.upApkListFragmentScreen = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
