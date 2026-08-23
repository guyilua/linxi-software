package com.rtk.app.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameDetailsActivity_ViewBinding implements Unbinder {
    private GameDetailsActivity b;

    @UiThread
    public GameDetailsActivity_ViewBinding(GameDetailsActivity gameDetailsActivity, View view) {
        this.b = gameDetailsActivity;
        gameDetailsActivity.gameDetailsTopBack = (TextView) butterknife.c.a.c(view, R.id.game_details_top_back, "field 'gameDetailsTopBack'", TextView.class);
        gameDetailsActivity.gameDetailsTopFeedback = (ImageView) butterknife.c.a.c(view, R.id.game_details_top_feedback, "field 'gameDetailsTopFeedback'", ImageView.class);
        gameDetailsActivity.gameDetailsTopHome = (ImageView) butterknife.c.a.c(view, R.id.game_details_top_home, "field 'gameDetailsTopHome'", ImageView.class);
        gameDetailsActivity.gameDetailsTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.game_details_top_download, "field 'gameDetailsTopDownload'", MarkedImageView.class);
        gameDetailsActivity.gameDetailsTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_top_layout, "field 'gameDetailsTopLayout'", LinearLayout.class);
        gameDetailsActivity.gameDetailsAppIcon = (ImageView) butterknife.c.a.c(view, R.id.game_details_appIcon, "field 'gameDetailsAppIcon'", ImageView.class);
        gameDetailsActivity.gameDetailsAppName = (TextView) butterknife.c.a.c(view, R.id.game_details_appName, "field 'gameDetailsAppName'", TextView.class);
        gameDetailsActivity.gameDetailsAppType = (TextView) butterknife.c.a.c(view, R.id.game_details_appType, "field 'gameDetailsAppType'", TextView.class);
        gameDetailsActivity.gameDetailsAppSizeAndPlayerNum = (TextView) butterknife.c.a.c(view, R.id.game_details_appSize_and_playerNum, "field 'gameDetailsAppSizeAndPlayerNum'", TextView.class);
        gameDetailsActivity.gameDetailsAppVersion = (TextView) butterknife.c.a.c(view, R.id.game_details_appVersion, "field 'gameDetailsAppVersion'", TextView.class);
        gameDetailsActivity.gameDetailsItem1Level = (TextView) butterknife.c.a.c(view, R.id.game_details_item1_level, "field 'gameDetailsItem1Level'", TextView.class);
        gameDetailsActivity.appDetailItem1SufferLayout = (LinearLayout) butterknife.c.a.c(view, R.id.app_detail_item1_suffer_layout, "field 'appDetailItem1SufferLayout'", LinearLayout.class);
        gameDetailsActivity.gameDetailsHeadLv = (LinearLayout) butterknife.c.a.c(view, R.id.game_details_headLv, "field 'gameDetailsHeadLv'", LinearLayout.class);
        gameDetailsActivity.gameDetailsTab = (TabLayout) butterknife.c.a.c(view, R.id.game_details_tab, "field 'gameDetailsTab'", TabLayout.class);
        gameDetailsActivity.appBar = (AppBarLayout) butterknife.c.a.c(view, R.id.app_bar, "field 'appBar'", AppBarLayout.class);
        gameDetailsActivity.gameDetailsViewPager = (ViewPager) butterknife.c.a.c(view, R.id.game_details_viewPager, "field 'gameDetailsViewPager'", ViewPager.class);
        gameDetailsActivity.appCoordinatorLayout = (CoordinatorLayout) butterknife.c.a.c(view, R.id.app_CoordinatorLayout, "field 'appCoordinatorLayout'", CoordinatorLayout.class);
        gameDetailsActivity.gameDetailsAppCollect = (TextView) butterknife.c.a.c(view, R.id.game_details_app_collect, "field 'gameDetailsAppCollect'", TextView.class);
        gameDetailsActivity.gameDetailsAppOpenBtu = (TextView) butterknife.c.a.c(view, R.id.game_details_appOpenBtu, "field 'gameDetailsAppOpenBtu'", TextView.class);
        gameDetailsActivity.gameDetailsAppDownLoadProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.game_details_appDownLoadProgressBar, "field 'gameDetailsAppDownLoadProgressBar'", ProgressBar.class);
        gameDetailsActivity.gameDetailsAppDownLoadBtu = (TextView) butterknife.c.a.c(view, R.id.game_details_appDownLoadBtu, "field 'gameDetailsAppDownLoadBtu'", TextView.class);
        gameDetailsActivity.gameDetailsAppInvitation = (TextView) butterknife.c.a.c(view, R.id.game_details_app_Invitation, "field 'gameDetailsAppInvitation'", TextView.class);
    }

    @CallSuper
    public void a() {
        GameDetailsActivity gameDetailsActivity = this.b;
        if (gameDetailsActivity != null) {
            this.b = null;
            gameDetailsActivity.gameDetailsTopBack = null;
            gameDetailsActivity.gameDetailsTopFeedback = null;
            gameDetailsActivity.gameDetailsTopHome = null;
            gameDetailsActivity.gameDetailsTopDownload = null;
            gameDetailsActivity.gameDetailsTopLayout = null;
            gameDetailsActivity.gameDetailsAppIcon = null;
            gameDetailsActivity.gameDetailsAppName = null;
            gameDetailsActivity.gameDetailsAppType = null;
            gameDetailsActivity.gameDetailsAppSizeAndPlayerNum = null;
            gameDetailsActivity.gameDetailsAppVersion = null;
            gameDetailsActivity.gameDetailsItem1Level = null;
            gameDetailsActivity.appDetailItem1SufferLayout = null;
            gameDetailsActivity.gameDetailsHeadLv = null;
            gameDetailsActivity.gameDetailsTab = null;
            gameDetailsActivity.appBar = null;
            gameDetailsActivity.gameDetailsViewPager = null;
            gameDetailsActivity.appCoordinatorLayout = null;
            gameDetailsActivity.gameDetailsAppCollect = null;
            gameDetailsActivity.gameDetailsAppOpenBtu = null;
            gameDetailsActivity.gameDetailsAppDownLoadProgressBar = null;
            gameDetailsActivity.gameDetailsAppDownLoadBtu = null;
            gameDetailsActivity.gameDetailsAppInvitation = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
