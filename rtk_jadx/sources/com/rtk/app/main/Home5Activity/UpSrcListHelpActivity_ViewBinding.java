package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcListHelpActivity_ViewBinding implements Unbinder {
    private UpSrcListHelpActivity b;

    @UiThread
    public UpSrcListHelpActivity_ViewBinding(UpSrcListHelpActivity upSrcListHelpActivity, View view) {
        this.b = upSrcListHelpActivity;
        upSrcListHelpActivity.upSrcListHelpBack = (TextView) butterknife.c.a.c(view, R.id.up_src_list_help_back, "field 'upSrcListHelpBack'", TextView.class);
        upSrcListHelpActivity.upSrcListHelpLayout = (LinearLayout) butterknife.c.a.c(view, R.id.up_src_list_help_layout, "field 'upSrcListHelpLayout'", LinearLayout.class);
        upSrcListHelpActivity.upSrcListHelpIntro = (WebView) butterknife.c.a.c(view, R.id.up_src_list_help_intro, "field 'upSrcListHelpIntro'", WebView.class);
    }

    @CallSuper
    public void a() {
        UpSrcListHelpActivity upSrcListHelpActivity = this.b;
        if (upSrcListHelpActivity != null) {
            this.b = null;
            upSrcListHelpActivity.upSrcListHelpBack = null;
            upSrcListHelpActivity.upSrcListHelpLayout = null;
            upSrcListHelpActivity.upSrcListHelpIntro = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
