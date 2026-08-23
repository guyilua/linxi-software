package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpgradeGameActivity_ViewBinding implements Unbinder {
    private UpgradeGameActivity b;

    @UiThread
    public UpgradeGameActivity_ViewBinding(UpgradeGameActivity upgradeGameActivity, View view) {
        this.b = upgradeGameActivity;
        upgradeGameActivity.upgradeGameTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.upgrade_game_top_layout, "field 'upgradeGameTopLayout'", LinearLayout.class);
        upgradeGameActivity.upgradeGameListview = (ListView) butterknife.c.a.c(view, R.id.upgrade_game_listview, "field 'upgradeGameListview'", ListView.class);
        upgradeGameActivity.upgradeGameTopBack = (TextView) butterknife.c.a.c(view, R.id.upgrade_game_top_back, "field 'upgradeGameTopBack'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpgradeGameActivity upgradeGameActivity = this.b;
        if (upgradeGameActivity != null) {
            this.b = null;
            upgradeGameActivity.upgradeGameTopLayout = null;
            upgradeGameActivity.upgradeGameListview = null;
            upgradeGameActivity.upgradeGameTopBack = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
