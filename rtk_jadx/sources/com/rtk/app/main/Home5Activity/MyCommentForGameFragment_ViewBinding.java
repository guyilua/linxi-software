package com.rtk.app.main.Home5Activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCommentForGameFragment_ViewBinding implements Unbinder {
    private MyCommentForGameFragment b;

    @UiThread
    public MyCommentForGameFragment_ViewBinding(MyCommentForGameFragment myCommentForGameFragment, View view) {
        this.b = myCommentForGameFragment;
        myCommentForGameFragment.myCommentForGameTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.my_comment_for_game_tag_layout, "field 'myCommentForGameTagLayout'", TabLayout.class);
        myCommentForGameFragment.myCommentForGameViewPager = (ViewPager) butterknife.c.a.c(view, R.id.my_comment_for_game_ViewPager, "field 'myCommentForGameViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        MyCommentForGameFragment myCommentForGameFragment = this.b;
        if (myCommentForGameFragment != null) {
            this.b = null;
            myCommentForGameFragment.myCommentForGameTagLayout = null;
            myCommentForGameFragment.myCommentForGameViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
