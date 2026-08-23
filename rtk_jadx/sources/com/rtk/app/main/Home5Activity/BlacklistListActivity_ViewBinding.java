package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BlacklistListActivity_ViewBinding implements Unbinder {
    private BlacklistListActivity b;

    @UiThread
    public BlacklistListActivity_ViewBinding(BlacklistListActivity blacklistListActivity, View view) {
        this.b = blacklistListActivity;
        blacklistListActivity.blacklistListBackLv = (LinearLayout) butterknife.c.a.c(view, R.id.blacklist_list_back_layout, "field 'blacklistListBackLv'", LinearLayout.class);
        blacklistListActivity.blacklistListBack = (TextView) butterknife.c.a.c(view, R.id.blacklist_list_back, "field 'blacklistListBack'", TextView.class);
        blacklistListActivity.blacklistListview = (AutoListView) butterknife.c.a.c(view, R.id.blacklist_listview, "field 'blacklistListview'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        BlacklistListActivity blacklistListActivity = this.b;
        if (blacklistListActivity != null) {
            this.b = null;
            blacklistListActivity.blacklistListBackLv = null;
            blacklistListActivity.blacklistListBack = null;
            blacklistListActivity.blacklistListview = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
