package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameItem3Fragment_ViewBinding implements Unbinder {
    private HomeGameItem3Fragment b;

    @UiThread
    public HomeGameItem3Fragment_ViewBinding(HomeGameItem3Fragment homeGameItem3Fragment, View view) {
        this.b = homeGameItem3Fragment;
        homeGameItem3Fragment.homeGameItem3ListView = (AutoListView) butterknife.c.a.c(view, R.id.home_game_item3_listView, "field 'homeGameItem3ListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        HomeGameItem3Fragment homeGameItem3Fragment = this.b;
        if (homeGameItem3Fragment != null) {
            this.b = null;
            homeGameItem3Fragment.homeGameItem3ListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
