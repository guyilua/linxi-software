package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentAuditFragment_ViewBinding implements Unbinder {
    private PostCommentAuditFragment b;

    @UiThread
    public PostCommentAuditFragment_ViewBinding(PostCommentAuditFragment postCommentAuditFragment, View view) {
        this.b = postCommentAuditFragment;
        postCommentAuditFragment.fragementForListviewListview = (AutoListView) butterknife.c.a.c(view, R.id.fragement_for_listview_listview, "field 'fragementForListviewListview'", AutoListView.class);
        postCommentAuditFragment.fragementForListviewParentLayout = (LinearLayout) butterknife.c.a.c(view, R.id.fragement_for_listview_parent_layout, "field 'fragementForListviewParentLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        PostCommentAuditFragment postCommentAuditFragment = this.b;
        if (postCommentAuditFragment != null) {
            this.b = null;
            postCommentAuditFragment.fragementForListviewListview = null;
            postCommentAuditFragment.fragementForListviewParentLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
