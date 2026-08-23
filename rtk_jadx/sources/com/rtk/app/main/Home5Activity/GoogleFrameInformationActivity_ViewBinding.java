package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoogleFrameInformationActivity_ViewBinding implements Unbinder {
    private GoogleFrameInformationActivity b;

    @UiThread
    public GoogleFrameInformationActivity_ViewBinding(GoogleFrameInformationActivity googleFrameInformationActivity, View view) {
        this.b = googleFrameInformationActivity;
        googleFrameInformationActivity.googleFrameInformationBack = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_back, "field 'googleFrameInformationBack'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationUseHelp = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_use_help, "field 'googleFrameInformationUseHelp'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationTopLv = (LinearLayout) butterknife.c.a.c(view, R.id.google_frame_information_top_lv, "field 'googleFrameInformationTopLv'", LinearLayout.class);
        googleFrameInformationActivity.googleFrameInformationBrand = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_brand, "field 'googleFrameInformationBrand'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationApi = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_api, "field 'googleFrameInformationApi'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationRootState = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_root_state, "field 'googleFrameInformationRootState'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationGoogleServeState = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_google_serve_state, "field 'googleFrameInformationGoogleServeState'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationGoogleManage = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_google_manage, "field 'googleFrameInformationGoogleManage'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationGooglePlayServe = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_google_play_serve, "field 'googleFrameInformationGooglePlayServe'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationGooglePlayMarket = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_google_play_market, "field 'googleFrameInformationGooglePlayMarket'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationGoogleAllState = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_google_all_state, "field 'googleFrameInformationGoogleAllState'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationOpenGoogleList = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_open_google_list, "field 'googleFrameInformationOpenGoogleList'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationUninstallGoogle = (TextView) butterknife.c.a.c(view, R.id.google_frame_information_uninstall_google, "field 'googleFrameInformationUninstallGoogle'", TextView.class);
        googleFrameInformationActivity.googleFrameInformationGoogleManageLv = (LinearLayout) butterknife.c.a.c(view, R.id.google_frame_information_google_manage_lv, "field 'googleFrameInformationGoogleManageLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        GoogleFrameInformationActivity googleFrameInformationActivity = this.b;
        if (googleFrameInformationActivity != null) {
            this.b = null;
            googleFrameInformationActivity.googleFrameInformationBack = null;
            googleFrameInformationActivity.googleFrameInformationUseHelp = null;
            googleFrameInformationActivity.googleFrameInformationTopLv = null;
            googleFrameInformationActivity.googleFrameInformationBrand = null;
            googleFrameInformationActivity.googleFrameInformationApi = null;
            googleFrameInformationActivity.googleFrameInformationRootState = null;
            googleFrameInformationActivity.googleFrameInformationGoogleServeState = null;
            googleFrameInformationActivity.googleFrameInformationGoogleManage = null;
            googleFrameInformationActivity.googleFrameInformationGooglePlayServe = null;
            googleFrameInformationActivity.googleFrameInformationGooglePlayMarket = null;
            googleFrameInformationActivity.googleFrameInformationGoogleAllState = null;
            googleFrameInformationActivity.googleFrameInformationOpenGoogleList = null;
            googleFrameInformationActivity.googleFrameInformationUninstallGoogle = null;
            googleFrameInformationActivity.googleFrameInformationGoogleManageLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
