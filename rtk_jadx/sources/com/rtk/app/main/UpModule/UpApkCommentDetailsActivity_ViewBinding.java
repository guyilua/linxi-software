package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkCommentDetailsActivity_ViewBinding implements Unbinder {
    private UpApkCommentDetailsActivity b;

    @UiThread
    public UpApkCommentDetailsActivity_ViewBinding(UpApkCommentDetailsActivity upApkCommentDetailsActivity, View view) {
        this.b = upApkCommentDetailsActivity;
        upApkCommentDetailsActivity.upApkCommentDetailsBack = (TextView) butterknife.c.a.c(view, R.id.up_apk_comment_details_back, "field 'upApkCommentDetailsBack'", TextView.class);
        upApkCommentDetailsActivity.upApkCommentDetailsTitleRl = (RelativeLayout) butterknife.c.a.c(view, R.id.up_apk_comment_details_title_rl, "field 'upApkCommentDetailsTitleRl'", RelativeLayout.class);
        upApkCommentDetailsActivity.commentdetailsupApkCommentListView = (AutoListView) butterknife.c.a.c(view, R.id.commentdetailsup_apk_commentListView, "field 'commentdetailsupApkCommentListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        UpApkCommentDetailsActivity upApkCommentDetailsActivity = this.b;
        if (upApkCommentDetailsActivity != null) {
            this.b = null;
            upApkCommentDetailsActivity.upApkCommentDetailsBack = null;
            upApkCommentDetailsActivity.upApkCommentDetailsTitleRl = null;
            upApkCommentDetailsActivity.commentdetailsupApkCommentListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
