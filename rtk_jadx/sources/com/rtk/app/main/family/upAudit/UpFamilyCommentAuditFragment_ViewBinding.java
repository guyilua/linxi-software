package com.rtk.app.main.family.upAudit;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpFamilyCommentAuditFragment_ViewBinding implements Unbinder {
    private UpFamilyCommentAuditFragment b;

    @UiThread
    public UpFamilyCommentAuditFragment_ViewBinding(UpFamilyCommentAuditFragment upFamilyCommentAuditFragment, View view) {
        this.b = upFamilyCommentAuditFragment;
        upFamilyCommentAuditFragment.fragmentForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragmentForListviewListview'", AutoListView.class);
        upFamilyCommentAuditFragment.fragmentForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragmentForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpFamilyCommentAuditFragment upFamilyCommentAuditFragment = this.b;
        if (upFamilyCommentAuditFragment != null) {
            this.b = null;
            upFamilyCommentAuditFragment.fragmentForListviewListview = null;
            upFamilyCommentAuditFragment.fragmentForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
