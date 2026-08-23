package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeAdImageHolder_ViewBinding implements Unbinder {
    private HomeAdImageHolder b;

    @UiThread
    public HomeAdImageHolder_ViewBinding(HomeAdImageHolder homeAdImageHolder, View view) {
        this.b = homeAdImageHolder;
        homeAdImageHolder.homePageItem1FragmentAdImage = (ImageView) butterknife.c.a.c(view, R.id.home_page_item1_fragment_ad_image, "field 'homePageItem1FragmentAdImage'", ImageView.class);
    }

    @CallSuper
    public void a() {
        HomeAdImageHolder homeAdImageHolder = this.b;
        if (homeAdImageHolder != null) {
            this.b = null;
            homeAdImageHolder.homePageItem1FragmentAdImage = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
