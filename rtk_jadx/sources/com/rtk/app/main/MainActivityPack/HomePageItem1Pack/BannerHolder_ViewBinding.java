package com.rtk.app.main.MainActivityPack.HomePageItem1Pack;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.youth.banner.Banner;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BannerHolder_ViewBinding implements Unbinder {
    private BannerHolder b;

    @UiThread
    public BannerHolder_ViewBinding(BannerHolder bannerHolder, View view) {
        this.b = bannerHolder;
        bannerHolder.homeUpChoicenessBannerLayoutBanner = (Banner) butterknife.c.a.c(view, R.id.home_up_choiceness_banner_layout_banner, "field 'homeUpChoicenessBannerLayoutBanner'", Banner.class);
        bannerHolder.homeUpChoicenessBannerLayoutBannerTitle = (TextView) butterknife.c.a.c(view, R.id.home_up_choiceness_banner_layout_banner_title, "field 'homeUpChoicenessBannerLayoutBannerTitle'", TextView.class);
    }

    @CallSuper
    public void a() {
        BannerHolder bannerHolder = this.b;
        if (bannerHolder != null) {
            this.b = null;
            bannerHolder.homeUpChoicenessBannerLayoutBanner = null;
            bannerHolder.homeUpChoicenessBannerLayoutBannerTitle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
