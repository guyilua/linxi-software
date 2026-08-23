package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPermissionUpFragment_ViewBinding implements Unbinder {
    private SearchPermissionUpFragment b;

    @UiThread
    public SearchPermissionUpFragment_ViewBinding(SearchPermissionUpFragment searchPermissionUpFragment, View view) {
        this.b = searchPermissionUpFragment;
        searchPermissionUpFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
        searchPermissionUpFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        SearchPermissionUpFragment searchPermissionUpFragment = this.b;
        if (searchPermissionUpFragment != null) {
            this.b = null;
            searchPermissionUpFragment.fragementForListviewListview = null;
            searchPermissionUpFragment.fragementForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
