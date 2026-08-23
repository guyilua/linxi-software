package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MainActivity_ViewBinding implements Unbinder {
    private MainActivity b;

    @UiThread
    public MainActivity_ViewBinding(MainActivity mainActivity, View view) {
        this.b = mainActivity;
        mainActivity.mainLinearLayout = (LinearLayout) butterknife.c.a.c(view, R.id.main_linearLayout, "field 'mainLinearLayout'", LinearLayout.class);
        mainActivity.mainBtu = (RadioGroup) butterknife.c.a.c(view, R.id.main_btu, "field 'mainBtu'", RadioGroup.class);
        mainActivity.mainBtuHome = (RadioButton) butterknife.c.a.c(view, R.id.main_btu_home, "field 'mainBtuHome'", RadioButton.class);
        mainActivity.mainBtuUp = (RadioButton) butterknife.c.a.c(view, R.id.main_btu_up, "field 'mainBtuUp'", RadioButton.class);
        mainActivity.mainBtuCommunity = (RadioButton) butterknife.c.a.c(view, R.id.main_btu_community, "field 'mainBtuCommunity'", RadioButton.class);
        mainActivity.mainBtuGame = (RadioButton) butterknife.c.a.c(view, R.id.main_btu_game, "field 'mainBtuGame'", RadioButton.class);
        mainActivity.mainBtuManage = (RadioButton) butterknife.c.a.c(view, R.id.main_btu_manage, "field 'mainBtuManage'", RadioButton.class);
    }

    @CallSuper
    public void a() {
        MainActivity mainActivity = this.b;
        if (mainActivity != null) {
            this.b = null;
            mainActivity.mainLinearLayout = null;
            mainActivity.mainBtu = null;
            mainActivity.mainBtuHome = null;
            mainActivity.mainBtuUp = null;
            mainActivity.mainBtuCommunity = null;
            mainActivity.mainBtuGame = null;
            mainActivity.mainBtuManage = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
