package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RTKLogActivity_ViewBinding implements Unbinder {
    private RTKLogActivity b;

    @UiThread
    public RTKLogActivity_ViewBinding(RTKLogActivity rTKLogActivity, View view) {
        this.b = rTKLogActivity;
        rTKLogActivity.text = (TextView) butterknife.c.a.c(view, 2131300394, "field 'text'", TextView.class);
        rTKLogActivity.zipTodayLog = (Button) butterknife.c.a.c(view, R.id.btn_zip_today_log, "field 'zipTodayLog'", Button.class);
        rTKLogActivity.zipThreeDaysLog = (Button) butterknife.c.a.c(view, R.id.btn_zip_logs_in_the_past_three_days, "field 'zipThreeDaysLog'", Button.class);
        rTKLogActivity.enableLog = (Button) butterknife.c.a.c(view, R.id.btn_enable_log, "field 'enableLog'", Button.class);
        rTKLogActivity.clearLog = (Button) butterknife.c.a.c(view, R.id.btn_clear_log, "field 'clearLog'", Button.class);
        rTKLogActivity.textZip = (TextView) butterknife.c.a.c(view, R.id.tv_zip, "field 'textZip'", TextView.class);
        rTKLogActivity.tvOs = (TextView) butterknife.c.a.c(view, R.id.tv_os, "field 'tvOs'", TextView.class);
    }

    @CallSuper
    public void a() {
        RTKLogActivity rTKLogActivity = this.b;
        if (rTKLogActivity != null) {
            this.b = null;
            rTKLogActivity.text = null;
            rTKLogActivity.zipTodayLog = null;
            rTKLogActivity.zipThreeDaysLog = null;
            rTKLogActivity.enableLog = null;
            rTKLogActivity.clearLog = null;
            rTKLogActivity.textZip = null;
            rTKLogActivity.tvOs = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
