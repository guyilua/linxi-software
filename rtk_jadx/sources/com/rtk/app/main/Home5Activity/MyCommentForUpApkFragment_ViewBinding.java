package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCommentForUpApkFragment_ViewBinding implements Unbinder {
    private MyCommentForUpApkFragment b;

    @UiThread
    public MyCommentForUpApkFragment_ViewBinding(MyCommentForUpApkFragment myCommentForUpApkFragment, View view) {
        this.b = myCommentForUpApkFragment;
        myCommentForUpApkFragment.myCommentForUpApkTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.my_comment_for_up_apk_tag_layout, "field 'myCommentForUpApkTagLayout'", TabLayout.class);
        myCommentForUpApkFragment.myCommentForUpApkViewPager = (ViewPager) butterknife.c.a.c(view, R.id.my_comment_for_up_apk_ViewPager, "field 'myCommentForUpApkViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        MyCommentForUpApkFragment myCommentForUpApkFragment = this.b;
        if (myCommentForUpApkFragment != null) {
            this.b = null;
            myCommentForUpApkFragment.myCommentForUpApkTagLayout = null;
            myCommentForUpApkFragment.myCommentForUpApkViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
