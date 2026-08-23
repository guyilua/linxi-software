package com.rtk.app.main;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ThemeSwitchHelpActivity_ViewBinding implements Unbinder {
    private ThemeSwitchHelpActivity b;

    @UiThread
    public ThemeSwitchHelpActivity_ViewBinding(ThemeSwitchHelpActivity themeSwitchHelpActivity, View view) {
        this.b = themeSwitchHelpActivity;
        themeSwitchHelpActivity.themSwitchTopImg = (ImageView) butterknife.c.a.c(view, R.id.them_switch_topImg, "field 'themSwitchTopImg'", ImageView.class);
        themeSwitchHelpActivity.themSwitchMoomTopImg = (ImageView) butterknife.c.a.c(view, R.id.them_switch_moom_top_Img, "field 'themSwitchMoomTopImg'", ImageView.class);
        themeSwitchHelpActivity.themSwitchDownImg = (ImageView) butterknife.c.a.c(view, R.id.them_switch_DownImg, "field 'themSwitchDownImg'", ImageView.class);
        themeSwitchHelpActivity.themSwitchMoomDownImg = (ImageView) butterknife.c.a.c(view, R.id.them_switch_moom_down_Img, "field 'themSwitchMoomDownImg'", ImageView.class);
    }

    @CallSuper
    public void a() {
        ThemeSwitchHelpActivity themeSwitchHelpActivity = this.b;
        if (themeSwitchHelpActivity != null) {
            this.b = null;
            themeSwitchHelpActivity.themSwitchTopImg = null;
            themeSwitchHelpActivity.themSwitchMoomTopImg = null;
            themeSwitchHelpActivity.themSwitchDownImg = null;
            themeSwitchHelpActivity.themSwitchMoomDownImg = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
