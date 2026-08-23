package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ReportPostActivity_ViewBinding implements Unbinder {
    private ReportPostActivity b;

    @UiThread
    public ReportPostActivity_ViewBinding(ReportPostActivity reportPostActivity, View view) {
        this.b = reportPostActivity;
        reportPostActivity.reportPostBack = (TextView) butterknife.c.a.c(view, R.id.report_post_back, "field 'reportPostBack'", TextView.class);
        reportPostActivity.reportPostSubmit = (TextView) butterknife.c.a.c(view, R.id.report_post_submit, "field 'reportPostSubmit'", TextView.class);
        reportPostActivity.reportPostLayout = (LinearLayout) butterknife.c.a.c(view, R.id.report_post_layout, "field 'reportPostLayout'", LinearLayout.class);
        reportPostActivity.reportPostSpinner = (Spinner) butterknife.c.a.c(view, R.id.report_post_spinner, "field 'reportPostSpinner'", Spinner.class);
        reportPostActivity.reportPostComment = (EditText) butterknife.c.a.c(view, R.id.report_post_comment, "field 'reportPostComment'", EditText.class);
        reportPostActivity.reportPostContentSize = (TextView) butterknife.c.a.c(view, R.id.report_post_content_size, "field 'reportPostContentSize'", TextView.class);
        reportPostActivity.reportPostContact = (EditText) butterknife.c.a.c(view, R.id.report_post_contact, "field 'reportPostContact'", EditText.class);
    }

    @CallSuper
    public void a() {
        ReportPostActivity reportPostActivity = this.b;
        if (reportPostActivity != null) {
            this.b = null;
            reportPostActivity.reportPostBack = null;
            reportPostActivity.reportPostSubmit = null;
            reportPostActivity.reportPostLayout = null;
            reportPostActivity.reportPostSpinner = null;
            reportPostActivity.reportPostComment = null;
            reportPostActivity.reportPostContentSize = null;
            reportPostActivity.reportPostContact = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
