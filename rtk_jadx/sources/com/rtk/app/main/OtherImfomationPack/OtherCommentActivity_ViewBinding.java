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
public class OtherCommentActivity_ViewBinding implements Unbinder {
    private OtherCommentActivity b;

    @UiThread
    public OtherCommentActivity_ViewBinding(OtherCommentActivity otherCommentActivity, View view) {
        this.b = otherCommentActivity;
        otherCommentActivity.otherCommentTopBack = (TextView) butterknife.c.a.c(view, R.id.other_comment_top_back, "field 'otherCommentTopBack'", TextView.class);
        otherCommentActivity.otherCommentTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.other_comment_top_layout, "field 'otherCommentTopLayout'", LinearLayout.class);
        otherCommentActivity.otherCommentViewPager = (ViewPager) butterknife.c.a.c(view, R.id.other_comment_ViewPager, "field 'otherCommentViewPager'", ViewPager.class);
        otherCommentActivity.otherCommentTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.other_comment_tag_layout, "field 'otherCommentTagLayout'", TabLayout.class);
    }

    @CallSuper
    public void a() {
        OtherCommentActivity otherCommentActivity = this.b;
        if (otherCommentActivity != null) {
            this.b = null;
            otherCommentActivity.otherCommentTopBack = null;
            otherCommentActivity.otherCommentTopLayout = null;
            otherCommentActivity.otherCommentViewPager = null;
            otherCommentActivity.otherCommentTagLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
