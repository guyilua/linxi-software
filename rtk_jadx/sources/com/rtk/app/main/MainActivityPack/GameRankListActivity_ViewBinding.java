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
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameRankListActivity_ViewBinding implements Unbinder {
    private GameRankListActivity b;

    @UiThread
    public GameRankListActivity_ViewBinding(GameRankListActivity gameRankListActivity, View view) {
        this.b = gameRankListActivity;
        gameRankListActivity.gameRankListTopBack = (TextView) butterknife.c.a.c(view, R.id.game_rank_list_top_back, "field 'gameRankListTopBack'", TextView.class);
        gameRankListActivity.gameRankListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_rank_list_top_layout, "field 'gameRankListTopLayout'", LinearLayout.class);
        gameRankListActivity.gameRankListTab = (TabLayout) butterknife.c.a.c(view, R.id.game_rank_list_tab, "field 'gameRankListTab'", TabLayout.class);
        gameRankListActivity.gameRankListViewPager = (ViewPager) butterknife.c.a.c(view, R.id.game_rank_list_viewPager, "field 'gameRankListViewPager'", ViewPager.class);
        gameRankListActivity.gameRankListTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.game_rank_list_top_download, "field 'gameRankListTopDownload'", MarkedImageView.class);
    }

    @CallSuper
    public void a() {
        GameRankListActivity gameRankListActivity = this.b;
        if (gameRankListActivity != null) {
            this.b = null;
            gameRankListActivity.gameRankListTopBack = null;
            gameRankListActivity.gameRankListTopLayout = null;
            gameRankListActivity.gameRankListTab = null;
            gameRankListActivity.gameRankListViewPager = null;
            gameRankListActivity.gameRankListTopDownload = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
