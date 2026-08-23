package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SetThemeActivity_ViewBinding implements Unbinder {
    private SetThemeActivity b;

    @UiThread
    public SetThemeActivity_ViewBinding(SetThemeActivity setThemeActivity, View view) {
        this.b = setThemeActivity;
        setThemeActivity.setThemeTopBack = (TextView) butterknife.c.a.c(view, R.id.set_theme_top_back, "field 'setThemeTopBack'", TextView.class);
        setThemeActivity.setThemeTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.set_theme_top_layout, "field 'setThemeTopLayout'", LinearLayout.class);
        setThemeActivity.setThemeGridView = (GridView) butterknife.c.a.c(view, R.id.set_theme_gridView, "field 'setThemeGridView'", GridView.class);
    }

    @CallSuper
    public void a() {
        SetThemeActivity setThemeActivity = this.b;
        if (setThemeActivity != null) {
            this.b = null;
            setThemeActivity.setThemeTopBack = null;
            setThemeActivity.setThemeTopLayout = null;
            setThemeActivity.setThemeGridView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
