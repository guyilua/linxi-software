package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameItem2Fragment_ViewBinding implements Unbinder {
    private HomeGameItem2Fragment b;

    @UiThread
    public HomeGameItem2Fragment_ViewBinding(HomeGameItem2Fragment homeGameItem2Fragment, View view) {
        this.b = homeGameItem2Fragment;
        homeGameItem2Fragment.homeGameItem2ListView = (AutoListView) butterknife.c.a.c(view, R.id.home_game_item2_listView, "field 'homeGameItem2ListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        HomeGameItem2Fragment homeGameItem2Fragment = this.b;
        if (homeGameItem2Fragment != null) {
            this.b = null;
            homeGameItem2Fragment.homeGameItem2ListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
