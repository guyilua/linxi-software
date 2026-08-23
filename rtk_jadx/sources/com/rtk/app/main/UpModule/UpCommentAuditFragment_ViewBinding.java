package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCommentAuditFragment_ViewBinding implements Unbinder {
    private UpCommentAuditFragment b;

    @UiThread
    public UpCommentAuditFragment_ViewBinding(UpCommentAuditFragment upCommentAuditFragment, View view) {
        this.b = upCommentAuditFragment;
        upCommentAuditFragment.fragmentForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragmentForListviewListview'", AutoListView.class);
        upCommentAuditFragment.fragmentForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragmentForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpCommentAuditFragment upCommentAuditFragment = this.b;
        if (upCommentAuditFragment != null) {
            this.b = null;
            upCommentAuditFragment.fragmentForListviewListview = null;
            upCommentAuditFragment.fragmentForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
