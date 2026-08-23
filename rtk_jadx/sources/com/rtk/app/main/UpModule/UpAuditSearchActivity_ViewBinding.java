package com.rtk.app.main.UpModule;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.custom.MarkedImageView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAuditSearchActivity_ViewBinding implements Unbinder {
    private UpAuditSearchActivity b;

    @UiThread
    public UpAuditSearchActivity_ViewBinding(UpAuditSearchActivity upAuditSearchActivity, View view) {
        this.b = upAuditSearchActivity;
        upAuditSearchActivity.upAuditSearchTopBack = (TextView) butterknife.c.a.c(view, R.id.up_audit_search_top_back, "field 'upAuditSearchTopBack'", TextView.class);
        upAuditSearchActivity.upAuditSearchTopMyUpLoading = (MarkedImageView) butterknife.c.a.c(view, R.id.up_audit_search_top_my_up_loading, "field 'upAuditSearchTopMyUpLoading'", MarkedImageView.class);
        upAuditSearchActivity.upAuditSearchTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_audit_search_top_layout, "field 'upAuditSearchTopLayout'", LinearLayout.class);
        upAuditSearchActivity.upAuditSearchTab = (TabLayout) butterknife.c.a.c(view, R.id.up_audit_search_tab, "field 'upAuditSearchTab'", TabLayout.class);
        upAuditSearchActivity.upAuditSearchViewpager = (ViewPager) butterknife.c.a.c(view, R.id.up_audit_search_viewpager, "field 'upAuditSearchViewpager'", ViewPager.class);
        upAuditSearchActivity.upAuditSearchTopSearch = (EditText) butterknife.c.a.c(view, R.id.up_audit_search_top_search, "field 'upAuditSearchTopSearch'", EditText.class);
        upAuditSearchActivity.upSrcAuditTopSubmit = (TextView) butterknife.c.a.c(view, R.id.up_audit_top_submit, "field 'upSrcAuditTopSubmit'", TextView.class);
    }

    @CallSuper
    public void a() {
        UpAuditSearchActivity upAuditSearchActivity = this.b;
        if (upAuditSearchActivity != null) {
            this.b = null;
            upAuditSearchActivity.upAuditSearchTopBack = null;
            upAuditSearchActivity.upAuditSearchTopMyUpLoading = null;
            upAuditSearchActivity.upAuditSearchTopLayout = null;
            upAuditSearchActivity.upAuditSearchTab = null;
            upAuditSearchActivity.upAuditSearchViewpager = null;
            upAuditSearchActivity.upAuditSearchTopSearch = null;
            upAuditSearchActivity.upSrcAuditTopSubmit = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
