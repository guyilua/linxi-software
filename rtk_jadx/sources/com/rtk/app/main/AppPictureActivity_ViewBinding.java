package com.rtk.app.main;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppPictureActivity_ViewBinding implements Unbinder {
    private AppPictureActivity b;

    @UiThread
    public AppPictureActivity_ViewBinding(AppPictureActivity appPictureActivity, View view) {
        this.b = appPictureActivity;
        appPictureActivity.appPictureViewpager = (ViewPager) butterknife.c.a.c(view, R.id.app_picture_viewpager, "field 'appPictureViewpager'", ViewPager.class);
        appPictureActivity.appPictureIndex = (TextView) butterknife.c.a.c(view, R.id.app_picture_index, "field 'appPictureIndex'", TextView.class);
        appPictureActivity.activityAppPicture = (RelativeLayout) butterknife.c.a.c(view, R.id.activity_app_picture, "field 'activityAppPicture'", RelativeLayout.class);
    }

    @CallSuper
    public void a() {
        AppPictureActivity appPictureActivity = this.b;
        if (appPictureActivity != null) {
            this.b = null;
            appPictureActivity.appPictureViewpager = null;
            appPictureActivity.appPictureIndex = null;
            appPictureActivity.activityAppPicture = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
