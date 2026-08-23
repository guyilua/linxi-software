package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.AutoListView.AutoListView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1Item4Fragment_ViewBinding implements Unbinder {
    private Home1Item4Fragment b;

    @UiThread
    public Home1Item4Fragment_ViewBinding(Home1Item4Fragment home1Item4Fragment, View view) {
        this.b = home1Item4Fragment;
        home1Item4Fragment.home1Item4ListView = (AutoListView) butterknife.c.a.c(view, R.id.home1_item4_listView, "field 'home1Item4ListView'", AutoListView.class);
    }

    @CallSuper
    public void a() {
        Home1Item4Fragment home1Item4Fragment = this.b;
        if (home1Item4Fragment != null) {
            this.b = null;
            home1Item4Fragment.home1Item4ListView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
