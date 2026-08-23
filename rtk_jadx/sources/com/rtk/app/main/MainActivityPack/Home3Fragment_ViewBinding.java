package com.rtk.app.main.MainActivityPack;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home3Fragment_ViewBinding implements Unbinder {
    private Home3Fragment b;

    @UiThread
    public Home3Fragment_ViewBinding(Home3Fragment home3Fragment, View view) {
        this.b = home3Fragment;
        home3Fragment.home3Tab = (TabLayout) butterknife.c.a.c(view, R.id.home3_tab, "field 'home3Tab'", TabLayout.class);
        home3Fragment.home3ViewPager = (ViewPager) butterknife.c.a.c(view, R.id.home3_viewPager, "field 'home3ViewPager'", ViewPager.class);
    }

    @CallSuper
    public void a() {
        Home3Fragment home3Fragment = this.b;
        if (home3Fragment != null) {
            this.b = null;
            home3Fragment.home3Tab = null;
            home3Fragment.home3ViewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
