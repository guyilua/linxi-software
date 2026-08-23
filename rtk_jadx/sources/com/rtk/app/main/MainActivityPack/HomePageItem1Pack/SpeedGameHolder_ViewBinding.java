package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SpeedGameHolder_ViewBinding implements Unbinder {
    private SpeedGameHolder b;

    @UiThread
    public SpeedGameHolder_ViewBinding(SpeedGameHolder speedGameHolder, View view) {
        this.b = speedGameHolder;
        speedGameHolder.homePageItem1FragmentSpeedGameViewItemMore = (TextView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_speed_game_view_item_more, "field 'homePageItem1FragmentSpeedGameViewItemMore'", TextView.class);
        speedGameHolder.homePageItem1FragmentBoutiqueViewItemMore = (TextView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_boutique_game_view_item_more, "field 'homePageItem1FragmentBoutiqueViewItemMore'", TextView.class);
        speedGameHolder.homePageItem1FragmentSpeedGameViewGameLv = (LinearLayout) butterknife.c.a.c(view, R.id.home_page_item1_fragment_speed_game_view_gameLv, "field 'homePageItem1FragmentSpeedGameViewGameLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        SpeedGameHolder speedGameHolder = this.b;
        if (speedGameHolder != null) {
            this.b = null;
            speedGameHolder.homePageItem1FragmentSpeedGameViewItemMore = null;
            speedGameHolder.homePageItem1FragmentBoutiqueViewItemMore = null;
            speedGameHolder.homePageItem1FragmentSpeedGameViewGameLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
