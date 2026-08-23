package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyUpCommentAuditFragment_ViewBinding implements Unbinder {
    private MyUpCommentAuditFragment b;

    @UiThread
    public MyUpCommentAuditFragment_ViewBinding(MyUpCommentAuditFragment myUpCommentAuditFragment, View view) {
        this.b = myUpCommentAuditFragment;
        myUpCommentAuditFragment.fragmentForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragmentForListviewListview'", AutoListView.class);
        myUpCommentAuditFragment.fragmentForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragmentForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        MyUpCommentAuditFragment myUpCommentAuditFragment = this.b;
        if (myUpCommentAuditFragment != null) {
            this.b = null;
            myUpCommentAuditFragment.fragmentForListviewListview = null;
            myUpCommentAuditFragment.fragmentForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
