package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCommentForUpApkFragment_ViewBinding implements Unbinder {
    private OtherCommentForUpApkFragment b;

    @UiThread
    public OtherCommentForUpApkFragment_ViewBinding(OtherCommentForUpApkFragment otherCommentForUpApkFragment, View view) {
        this.b = otherCommentForUpApkFragment;
        otherCommentForUpApkFragment.myCommentForUpApkTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.my_comment_for_up_apk_tag_layout, "field 'myCommentForUpApkTagLayout'", TabLayout.class);
        otherCommentForUpApkFragment.myCommentForUpApkViewPager = (ViewPager) butterknife.c.a.c(view, R.id.my_comment_for_up_apk_ViewPager, "field 'myCommentForUpApkViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        OtherCommentForUpApkFragment otherCommentForUpApkFragment = this.b;
        if (otherCommentForUpApkFragment != null) {
            this.b = null;
            otherCommentForUpApkFragment.myCommentForUpApkTagLayout = null;
            otherCommentForUpApkFragment.myCommentForUpApkViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
