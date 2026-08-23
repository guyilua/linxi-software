package com.rtk.app.main.Home5Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;
import com.youth.banner.Banner;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsRecodeDetailsActivity_ViewBinding implements Unbinder {
    private GoodsRecodeDetailsActivity b;

    @UiThread
    public GoodsRecodeDetailsActivity_ViewBinding(GoodsRecodeDetailsActivity goodsRecodeDetailsActivity, View view) {
        this.b = goodsRecodeDetailsActivity;
        goodsRecodeDetailsActivity.goodsRecodeDetailsBackTV = (TextView) butterknife.c.a.c(view, R.id.goods_recode_details_backTV, "field 'goodsRecodeDetailsBackTV'", TextView.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsBackLayout = (LinearLayout) butterknife.c.a.c(view, R.id.goods_recode_details_back_layout, "field 'goodsRecodeDetailsBackLayout'", LinearLayout.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsBanner = (Banner) butterknife.c.a.c(view, R.id.goods_recode_details_banner, "field 'goodsRecodeDetailsBanner'", Banner.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsName = (TextView) butterknife.c.a.c(view, R.id.goods_recode_details_name, "field 'goodsRecodeDetailsName'", TextView.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsIntegral = (TextView) butterknife.c.a.c(view, R.id.goods_recode_details_integral, "field 'goodsRecodeDetailsIntegral'", TextView.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsNum = (TextView) butterknife.c.a.c(view, R.id.goods_recode_details_num, "field 'goodsRecodeDetailsNum'", TextView.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsIntro = (TextView) butterknife.c.a.c(view, R.id.goods_recode_details_intro, "field 'goodsRecodeDetailsIntro'", TextView.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsParent = (LinearLayout) butterknife.c.a.c(view, R.id.goods_recode_details_parent, "field 'goodsRecodeDetailsParent'", LinearLayout.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsSwipeRefresh = (SwipeRefreshLayout) butterknife.c.a.c(view, R.id.goods_recode_details_swipe_refresh, "field 'goodsRecodeDetailsSwipeRefresh'", SwipeRefreshLayout.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsBuyTime = (CustomTextView) butterknife.c.a.c(view, R.id.goods_recode_details_buy_time, "field 'goodsRecodeDetailsBuyTime'", CustomTextView.class);
        goodsRecodeDetailsActivity.goodsRecodeDetailsAuditState = (CustomTextView) butterknife.c.a.c(view, R.id.goods_recode_details_audit_state, "field 'goodsRecodeDetailsAuditState'", CustomTextView.class);
    }

    @CallSuper
    public void a() {
        GoodsRecodeDetailsActivity goodsRecodeDetailsActivity = this.b;
        if (goodsRecodeDetailsActivity != null) {
            this.b = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsBackTV = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsBackLayout = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsBanner = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsName = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsIntegral = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsNum = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsIntro = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsParent = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsSwipeRefresh = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsBuyTime = null;
            goodsRecodeDetailsActivity.goodsRecodeDetailsAuditState = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
