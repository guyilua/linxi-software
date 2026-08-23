package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSearchJustHistoryActivity_ViewBinding implements Unbinder {
    private UpSearchJustHistoryActivity b;

    @UiThread
    public UpSearchJustHistoryActivity_ViewBinding(UpSearchJustHistoryActivity upSearchJustHistoryActivity, View view) {
        this.b = upSearchJustHistoryActivity;
        upSearchJustHistoryActivity.activityUpSearchJustHistoryTopBack = (TextView) butterknife.c.a.c(view, R.id.activity_up_search_just_history_top_back, "field 'activityUpSearchJustHistoryTopBack'", TextView.class);
        upSearchJustHistoryActivity.activityUpSearchJustHistoryTopSearch = (EditText) butterknife.c.a.c(view, R.id.activity_up_search_just_history_top_search, "field 'activityUpSearchJustHistoryTopSearch'", EditText.class);
        upSearchJustHistoryActivity.activityUpSearchJustHistoryTopSubmit = (TextView) butterknife.c.a.c(view, R.id.activity_up_search_just_history_top_submit, "field 'activityUpSearchJustHistoryTopSubmit'", TextView.class);
        upSearchJustHistoryActivity.activityUpSearchJustHistoryTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.activity_up_search_just_history_top_layout, "field 'activityUpSearchJustHistoryTopLayout'", LinearLayout.class);
        upSearchJustHistoryActivity.activityUpSearchJustHistoryClear = (TextView) butterknife.c.a.c(view, R.id.activity_up_search_just_history_clear, "field 'activityUpSearchJustHistoryClear'", TextView.class);
        upSearchJustHistoryActivity.activityUpSearchJustHistoryLv = (LinearLayout) butterknife.c.a.c(view, R.id.activity_up_search_just_history_lv, "field 'activityUpSearchJustHistoryLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        UpSearchJustHistoryActivity upSearchJustHistoryActivity = this.b;
        if (upSearchJustHistoryActivity != null) {
            this.b = null;
            upSearchJustHistoryActivity.activityUpSearchJustHistoryTopBack = null;
            upSearchJustHistoryActivity.activityUpSearchJustHistoryTopSearch = null;
            upSearchJustHistoryActivity.activityUpSearchJustHistoryTopSubmit = null;
            upSearchJustHistoryActivity.activityUpSearchJustHistoryTopLayout = null;
            upSearchJustHistoryActivity.activityUpSearchJustHistoryClear = null;
            upSearchJustHistoryActivity.activityUpSearchJustHistoryLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
