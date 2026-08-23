package com.rtk.app.main;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPermissionUserFragment_ViewBinding implements Unbinder {
    private SearchPermissionUserFragment b;

    @UiThread
    public SearchPermissionUserFragment_ViewBinding(SearchPermissionUserFragment searchPermissionUserFragment, View view) {
        this.b = searchPermissionUserFragment;
        searchPermissionUserFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
        searchPermissionUserFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        SearchPermissionUserFragment searchPermissionUserFragment = this.b;
        if (searchPermissionUserFragment != null) {
            this.b = null;
            searchPermissionUserFragment.fragementForListviewParentLayout = null;
            searchPermissionUserFragment.fragementForListviewListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
