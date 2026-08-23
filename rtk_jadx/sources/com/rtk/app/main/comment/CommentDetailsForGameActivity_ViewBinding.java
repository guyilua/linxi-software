package com.rtk.app.main.comment;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentDetailsForGameActivity_ViewBinding implements Unbinder {
    private CommentDetailsForGameActivity b;

    @UiThread
    public CommentDetailsForGameActivity_ViewBinding(CommentDetailsForGameActivity commentDetailsForGameActivity, View view) {
        this.b = commentDetailsForGameActivity;
        commentDetailsForGameActivity.activityCommentDetailsTitleRl = (RelativeLayout) butterknife.c.a.c(view, R.id.activity_comment_details_title_rl, "field 'activityCommentDetailsTitleRl'", RelativeLayout.class);
        commentDetailsForGameActivity.commentdetailsActivityCommentListView = (AutoListView) butterknife.c.a.c(view, R.id.commentdetailsActivity_commentListView, "field 'commentdetailsActivityCommentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        CommentDetailsForGameActivity commentDetailsForGameActivity = this.b;
        if (commentDetailsForGameActivity != null) {
            this.b = null;
            commentDetailsForGameActivity.activityCommentDetailsTitleRl = null;
            commentDetailsForGameActivity.commentdetailsActivityCommentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
