package com.rtk.app.main;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PictureDetailsActivity_ViewBinding implements Unbinder {
    private PictureDetailsActivity b;

    @UiThread
    public PictureDetailsActivity_ViewBinding(PictureDetailsActivity pictureDetailsActivity, View view) {
        this.b = pictureDetailsActivity;
        pictureDetailsActivity.pictureDetailsViewpager = (ViewPager) butterknife.c.a.c(view, R.id.picture_details_viewpager, "field 'pictureDetailsViewpager'", ViewPager.class);
        pictureDetailsActivity.pictureDetailsNum = (TextView) butterknife.c.a.c(view, R.id.picture_details_num, "field 'pictureDetailsNum'", TextView.class);
    }

    @CallSuper
    public void a() {
        PictureDetailsActivity pictureDetailsActivity = this.b;
        if (pictureDetailsActivity != null) {
            this.b = null;
            pictureDetailsActivity.pictureDetailsViewpager = null;
            pictureDetailsActivity.pictureDetailsNum = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
