package com.rtk.app.main.MainActivityPack;

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
public class GameClassifyActivity_ViewBinding implements Unbinder {
    private GameClassifyActivity b;

    @UiThread
    public GameClassifyActivity_ViewBinding(GameClassifyActivity gameClassifyActivity, View view) {
        this.b = gameClassifyActivity;
        gameClassifyActivity.gameClassifyTopBack = (TextView) butterknife.c.a.c(view, R.id.game_classify_top_back, "field 'gameClassifyTopBack'", TextView.class);
        gameClassifyActivity.gameClassifyTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_classify_top_layout, "field 'gameClassifyTopLayout'", LinearLayout.class);
        gameClassifyActivity.gameClassifyTagLayout = (TabLayout) butterknife.c.a.c(view, R.id.game_classify_tag_layout, "field 'gameClassifyTagLayout'", TabLayout.class);
        gameClassifyActivity.gameClassifyViewPager = (ViewPager) butterknife.c.a.c(view, R.id.game_classify_ViewPager, "field 'gameClassifyViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        GameClassifyActivity gameClassifyActivity = this.b;
        if (gameClassifyActivity != null) {
            this.b = null;
            gameClassifyActivity.gameClassifyTopBack = null;
            gameClassifyActivity.gameClassifyTopLayout = null;
            gameClassifyActivity.gameClassifyTagLayout = null;
            gameClassifyActivity.gameClassifyViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
