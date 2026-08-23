package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1Item5$ViewHolder_ViewBinding implements Unbinder {
    private Home1Item5$ViewHolder b;

    @UiThread
    public Home1Item5$ViewHolder_ViewBinding(Home1Item5$ViewHolder home1Item5$ViewHolder, View view) {
        home1Item5$ViewHolder.home1Item5ListView = (AutoListView) butterknife.c.a.c(view, R.id.home1_item5_listView, "field 'home1Item5ListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        Home1Item5$ViewHolder home1Item5$ViewHolder = this.b;
        if (home1Item5$ViewHolder != null) {
            home1Item5$ViewHolder.home1Item5ListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
