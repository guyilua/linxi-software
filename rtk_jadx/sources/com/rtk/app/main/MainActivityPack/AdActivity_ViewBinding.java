package com.rtk.app.main.MainActivityPack;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdActivity_ViewBinding implements Unbinder {
    private AdActivity b;

    @UiThread
    public AdActivity_ViewBinding(AdActivity adActivity, View view) {
        this.b = adActivity;
        adActivity.adLayout = (LinearLayout) butterknife.c.a.c(view, R.id.ad_layout, "field 'adLayout'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        AdActivity adActivity = this.b;
        if (adActivity != null) {
            this.b = null;
            adActivity.adLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
