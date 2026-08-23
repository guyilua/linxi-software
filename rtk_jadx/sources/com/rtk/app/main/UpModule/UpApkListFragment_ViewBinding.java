package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkListFragment_ViewBinding implements Unbinder {
    private UpApkListFragment b;

    @UiThread
    public UpApkListFragment_ViewBinding(UpApkListFragment upApkListFragment, View view) {
        this.b = upApkListFragment;
        upApkListFragment.upApkListFragmentListview = (AutoListView) butterknife.c.a.c(view, R.id.up_apk_list_fragment_listview, "field 'upApkListFragmentListview'", AutoListView.class);
        upApkListFragment.upApkListFragmentSearch = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_fragment_search, "field 'upApkListFragmentSearch'", TextView.class);
        upApkListFragment.upApkListFragmentScreen = (TextView) butterknife.c.a.c(view, R.id.up_apk_list_fragment_screen, "field 'upApkListFragmentScreen'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpApkListFragment upApkListFragment = this.b;
        if (upApkListFragment != null) {
            this.b = null;
            upApkListFragment.upApkListFragmentListview = null;
            upApkListFragment.upApkListFragmentSearch = null;
            upApkListFragment.upApkListFragmentScreen = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
