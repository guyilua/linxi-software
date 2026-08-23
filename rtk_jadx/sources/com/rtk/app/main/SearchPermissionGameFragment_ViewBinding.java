package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPermissionGameFragment_ViewBinding implements Unbinder {
    private SearchPermissionGameFragment b;

    @UiThread
    public SearchPermissionGameFragment_ViewBinding(SearchPermissionGameFragment searchPermissionGameFragment, View view) {
        this.b = searchPermissionGameFragment;
        searchPermissionGameFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
        searchPermissionGameFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        SearchPermissionGameFragment searchPermissionGameFragment = this.b;
        if (searchPermissionGameFragment != null) {
            this.b = null;
            searchPermissionGameFragment.fragementForListviewListview = null;
            searchPermissionGameFragment.fragementForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
