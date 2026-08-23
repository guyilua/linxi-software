package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherPostReplyActivity_ViewBinding implements Unbinder {
    private OtherPostReplyActivity b;

    @UiThread
    public OtherPostReplyActivity_ViewBinding(OtherPostReplyActivity otherPostReplyActivity, View view) {
        this.b = otherPostReplyActivity;
        otherPostReplyActivity.otherReplyTopBack = (TextView) butterknife.c.a.c(view, R.id.other_reply_topBack, "field 'otherReplyTopBack'", TextView.class);
        otherPostReplyActivity.otherReplyTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.other_reply_topLayout, "field 'otherReplyTopLayout'", LinearLayout.class);
        otherPostReplyActivity.otherReplyViewpager = (ViewPager) butterknife.c.a.c(view, R.id.other_reply_viewpager, "field 'otherReplyViewpager'", ViewPager.class);
        otherPostReplyActivity.otherReplyTab = (TabLayout) butterknife.c.a.c(view, R.id.other_reply_tab, "field 'otherReplyTab'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        OtherPostReplyActivity otherPostReplyActivity = this.b;
        if (otherPostReplyActivity != null) {
            this.b = null;
            otherPostReplyActivity.otherReplyTopBack = null;
            otherPostReplyActivity.otherReplyTopLayout = null;
            otherPostReplyActivity.otherReplyViewpager = null;
            otherPostReplyActivity.otherReplyTab = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
