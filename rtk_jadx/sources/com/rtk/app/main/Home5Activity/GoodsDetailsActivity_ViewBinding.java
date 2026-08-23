package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.youth.banner.Banner;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsDetailsActivity_ViewBinding implements Unbinder {
    private GoodsDetailsActivity b;

    @UiThread
    public GoodsDetailsActivity_ViewBinding(GoodsDetailsActivity goodsDetailsActivity, View view) {
        this.b = goodsDetailsActivity;
        goodsDetailsActivity.goodsDetailsTopBack = (TextView) butterknife.c.a.c(view, R.id.goods_details_top_back, "field 'goodsDetailsTopBack'", TextView.class);
        goodsDetailsActivity.goodsDetailsTopLayout = (LinearLayout) butterknife.c.a.c(view, R.id.goods_details_top_layout, "field 'goodsDetailsTopLayout'", LinearLayout.class);
        goodsDetailsActivity.goodsDetailsBanner = (Banner) butterknife.c.a.c(view, R.id.goods_details_banner, "field 'goodsDetailsBanner'", Banner.class);
        goodsDetailsActivity.goodsDetailsName = (TextView) butterknife.c.a.c(view, R.id.goods_details_name, "field 'goodsDetailsName'", TextView.class);
        goodsDetailsActivity.goodsDetailsIntegral = (TextView) butterknife.c.a.c(view, R.id.goods_details_integral, "field 'goodsDetailsIntegral'", TextView.class);
        goodsDetailsActivity.goodsDetailsSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.goods_details_swipe_refresh, "field 'goodsDetailsSwipeRefresh'", SwipeRefreshLayout.class);
        goodsDetailsActivity.goodsDetailsParent = (LinearLayout) butterknife.c.a.c(view, R.id.goods_details_parent, "field 'goodsDetailsParent'", LinearLayout.class);
        goodsDetailsActivity.goodsDetailsSubmit = (TextView) butterknife.c.a.c(view, R.id.goods_details_submit, "field 'goodsDetailsSubmit'", TextView.class);
        goodsDetailsActivity.goodsDetailsNum = (TextView) butterknife.c.a.c(view, R.id.goods_details_num, "field 'goodsDetailsNum'", TextView.class);
        goodsDetailsActivity.goodsDetailsIntro = (WebView) butterknife.c.a.c(view, R.id.goods_details_intro, "field 'goodsDetailsIntro'", WebView.class);
        goodsDetailsActivity.availableNum = (TextView) butterknife.c.a.c(view, R.id.availableNum, "field 'availableNum'", TextView.class);
        goodsDetailsActivity.monthNum = (TextView) butterknife.c.a.c(view, R.id.monthNum, "field 'monthNum'", TextView.class);
    }

    @CallSuper
    public void a() {
        GoodsDetailsActivity goodsDetailsActivity = this.b;
        if (goodsDetailsActivity != null) {
            this.b = null;
            goodsDetailsActivity.goodsDetailsTopBack = null;
            goodsDetailsActivity.goodsDetailsTopLayout = null;
            goodsDetailsActivity.goodsDetailsBanner = null;
            goodsDetailsActivity.goodsDetailsName = null;
            goodsDetailsActivity.goodsDetailsIntegral = null;
            goodsDetailsActivity.goodsDetailsSwipeRefresh = null;
            goodsDetailsActivity.goodsDetailsParent = null;
            goodsDetailsActivity.goodsDetailsSubmit = null;
            goodsDetailsActivity.goodsDetailsNum = null;
            goodsDetailsActivity.goodsDetailsIntro = null;
            goodsDetailsActivity.availableNum = null;
            goodsDetailsActivity.monthNum = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
