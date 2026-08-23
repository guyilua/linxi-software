package com.rtk.app.main;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommentSpecificationActivity_ViewBinding implements Unbinder {
    private CommentSpecificationActivity b;

    @UiThread
    public CommentSpecificationActivity_ViewBinding(CommentSpecificationActivity commentSpecificationActivity, View view) {
        this.b = commentSpecificationActivity;
        commentSpecificationActivity.commentSepcificationBack = (TextView) butterknife.c.a.c(view, R.id.comment_sepcification_back, "field 'commentSepcificationBack'", TextView.class);
        commentSpecificationActivity.commentSepcificationLayout = (LinearLayout) butterknife.c.a.c(view, R.id.comment_sepcification_layout, "field 'commentSepcificationLayout'", LinearLayout.class);
        commentSpecificationActivity.helpContent = (WebView) butterknife.c.a.c(view, R.id.help_content, "field 'helpContent'", WebView.class);
    }

    @CallSuper
    public void a() {
        CommentSpecificationActivity commentSpecificationActivity = this.b;
        if (commentSpecificationActivity != null) {
            this.b = null;
            commentSpecificationActivity.commentSepcificationBack = null;
            commentSpecificationActivity.commentSepcificationLayout = null;
            commentSpecificationActivity.helpContent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
