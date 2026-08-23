package com.rtk.app.main.OtherImfomationPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCommentForGameFragment_ViewBinding implements Unbinder {
    private OtherCommentForGameFragment b;

    @UiThread
    public OtherCommentForGameFragment_ViewBinding(OtherCommentForGameFragment otherCommentForGameFragment, View view) {
        this.b = otherCommentForGameFragment;
        otherCommentForGameFragment.otherCommentForGameTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.my_comment_for_game_tag_layout, "field 'otherCommentForGameTagLayout'", TabLayout.class);
        otherCommentForGameFragment.myCommentForGameViewPager = (ViewPager) butterknife.c.a.c(view, R.id.my_comment_for_game_ViewPager, "field 'myCommentForGameViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        OtherCommentForGameFragment otherCommentForGameFragment = this.b;
        if (otherCommentForGameFragment != null) {
            this.b = null;
            otherCommentForGameFragment.otherCommentForGameTagLayout = null;
            otherCommentForGameFragment.myCommentForGameViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
