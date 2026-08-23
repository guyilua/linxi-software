package com.rtk.app.main.HomeCommunityPack;

import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ModuleDetailsActivity_ViewBinding implements Unbinder {
    private ModuleDetailsActivity b;

    @UiThread
    public ModuleDetailsActivity_ViewBinding(ModuleDetailsActivity moduleDetailsActivity, View view) {
        this.b = moduleDetailsActivity;
        moduleDetailsActivity.moduleDetailsTopBack = (TextView) butterknife.c.a.c(view, R.id.module_details_top_back, "field 'moduleDetailsTopBack'", TextView.class);
        moduleDetailsActivity.moduleDetailsTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.module_details_top_layout, "field 'moduleDetailsTopLayout'", LinearLayout.class);
        moduleDetailsActivity.moduleDetailsIcon = (RoundedImageView) butterknife.c.a.c(view, R.id.module_details_icon, "field 'moduleDetailsIcon'", RoundedImageView.class);
        moduleDetailsActivity.moduleDetailsName = (TextView) butterknife.c.a.c(view, R.id.module_details_name, "field 'moduleDetailsName'", TextView.class);
        moduleDetailsActivity.moduleDetailsIntro = (TextView) butterknife.c.a.c(view, R.id.module_details_intro, "field 'moduleDetailsIntro'", TextView.class);
        moduleDetailsActivity.moduleDetailsModerator = (GridView) butterknife.c.a.c(view, R.id.module_details_moderator, "field 'moduleDetailsModerator'", GridView.class);
        moduleDetailsActivity.moduleDetailsRuleWebView = (TextView) butterknife.c.a.c(view, R.id.module_details_rule_webView, "field 'moduleDetailsRuleWebView'", TextView.class);
    }

    @CallSuper
    public void a() {
        ModuleDetailsActivity moduleDetailsActivity = this.b;
        if (moduleDetailsActivity != null) {
            this.b = null;
            moduleDetailsActivity.moduleDetailsTopBack = null;
            moduleDetailsActivity.moduleDetailsTopLayout = null;
            moduleDetailsActivity.moduleDetailsIcon = null;
            moduleDetailsActivity.moduleDetailsName = null;
            moduleDetailsActivity.moduleDetailsIntro = null;
            moduleDetailsActivity.moduleDetailsModerator = null;
            moduleDetailsActivity.moduleDetailsRuleWebView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
