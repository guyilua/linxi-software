package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FeedBackdActivity_ViewBinding implements Unbinder {
    private FeedBackdActivity b;

    @UiThread
    public FeedBackdActivity_ViewBinding(FeedBackdActivity feedBackdActivity, View view) {
        this.b = feedBackdActivity;
        feedBackdActivity.feedBackTopBack = (TextView) butterknife.c.a.c(view, R.id.feed_back_top_back, "field 'feedBackTopBack'", TextView.class);
        feedBackdActivity.feedBackTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.feed_back_top_layout, "field 'feedBackTopLayout'", LinearLayout.class);
        feedBackdActivity.feedBackComment = (EditText) butterknife.c.a.c(view, R.id.feedBack_comment, "field 'feedBackComment'", EditText.class);
        feedBackdActivity.feedBackContentSize = (TextView) butterknife.c.a.c(view, R.id.feedBack_content_size, "field 'feedBackContentSize'", TextView.class);
        feedBackdActivity.feedBackContact = (EditText) butterknife.c.a.c(view, R.id.feedBack_contact, "field 'feedBackContact'", EditText.class);
        feedBackdActivity.feedBackSubmit = (TextView) butterknife.c.a.c(view, R.id.feedBack_submit, "field 'feedBackSubmit'", TextView.class);
        feedBackdActivity.feedBackBlank = (RelativeLayout) butterknife.c.a.c(view, R.id.feedBack_blank, "field 'feedBackBlank'", RelativeLayout.class);
    }

    @CallSuper
    public void a() {
        FeedBackdActivity feedBackdActivity = this.b;
        if (feedBackdActivity != null) {
            this.b = null;
            feedBackdActivity.feedBackTopBack = null;
            feedBackdActivity.feedBackTopLayout = null;
            feedBackdActivity.feedBackComment = null;
            feedBackdActivity.feedBackContentSize = null;
            feedBackdActivity.feedBackContact = null;
            feedBackdActivity.feedBackSubmit = null;
            feedBackdActivity.feedBackBlank = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
