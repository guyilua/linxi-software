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
public class GameNoTypeListActivity_ViewBinding implements Unbinder {
    private GameNoTypeListActivity b;

    @UiThread
    public GameNoTypeListActivity_ViewBinding(GameNoTypeListActivity gameNoTypeListActivity, View view) {
        this.b = gameNoTypeListActivity;
        gameNoTypeListActivity.gameNoTypeListTopTitle = (TextView) butterknife.c.a.c(view, R.id.game_no_type_list_top_title, "field 'gameNoTypeListTopTitle'", TextView.class);
        gameNoTypeListActivity.gameNoTypeListTopDownload = (MarkedImageView) butterknife.c.a.c(view, R.id.game_no_type_list_top_download, "field 'gameNoTypeListTopDownload'", MarkedImageView.class);
        gameNoTypeListActivity.gameNoTypeListTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_no_type_list_top_layout, "field 'gameNoTypeListTopLayout'", LinearLayout.class);
        gameNoTypeListActivity.gameNoTypeListViewHelp = (TextView) butterknife.c.a.c(view, R.id.game_no_type_list_view_help, "field 'gameNoTypeListViewHelp'", TextView.class);
        gameNoTypeListActivity.gameNoTypeListTablayout = (TabLayout) butterknife.c.a.c(view, R.id.game_no_type_list_tablayout, "field 'gameNoTypeListTablayout'", TabLayout.class);
        gameNoTypeListActivity.gameNoTypeListScreen = (TextView) butterknife.c.a.c(view, R.id.game_no_type_list_screen, "field 'gameNoTypeListScreen'", TextView.class);
        gameNoTypeListActivity.gameNoTypeListTablayoutTabLayout = (LinearLayout) butterknife.c.a.c(view, R.id.game_no_type_list_tablayout_tabLayout, "field 'gameNoTypeListTablayoutTabLayout'", LinearLayout.class);
        gameNoTypeListActivity.gameNoTypeListViewPager = (ViewPager) butterknife.c.a.c(view, R.id.game_no_type_list_viewPager, "field 'gameNoTypeListViewPager'", ViewPager.class);
        gameNoTypeListActivity.gameNoTypeListParent = (LinearLayout) butterknife.c.a.c(view, R.id.game_no_type_list_parent, "field 'gameNoTypeListParent'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        GameNoTypeListActivity gameNoTypeListActivity = this.b;
        if (gameNoTypeListActivity != null) {
            this.b = null;
            gameNoTypeListActivity.gameNoTypeListTopTitle = null;
            gameNoTypeListActivity.gameNoTypeListTopDownload = null;
            gameNoTypeListActivity.gameNoTypeListTopLayout = null;
            gameNoTypeListActivity.gameNoTypeListViewHelp = null;
            gameNoTypeListActivity.gameNoTypeListTablayout = null;
            gameNoTypeListActivity.gameNoTypeListScreen = null;
            gameNoTypeListActivity.gameNoTypeListTablayoutTabLayout = null;
            gameNoTypeListActivity.gameNoTypeListViewPager = null;
            gameNoTypeListActivity.gameNoTypeListParent = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
