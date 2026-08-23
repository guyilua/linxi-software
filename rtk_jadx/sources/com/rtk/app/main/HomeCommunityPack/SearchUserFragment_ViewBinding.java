package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchUserFragment_ViewBinding implements Unbinder {
    private SearchUserFragment b;

    @UiThread
    public SearchUserFragment_ViewBinding(SearchUserFragment searchUserFragment, View view) {
        this.b = searchUserFragment;
        searchUserFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
        searchUserFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        SearchUserFragment searchUserFragment = this.b;
        if (searchUserFragment != null) {
            this.b = null;
            searchUserFragment.fragementForListviewParentLayout = null;
            searchUserFragment.fragementForListviewListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
