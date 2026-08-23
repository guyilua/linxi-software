package com.rtk.app.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GiftDetailsActivity_ViewBinding implements Unbinder {
    private GiftDetailsActivity b;

    @UiThread
    public GiftDetailsActivity_ViewBinding(GiftDetailsActivity giftDetailsActivity, View view) {
        this.b = giftDetailsActivity;
        giftDetailsActivity.giftDetailBack = (TextView) butterknife.c.a.c(view, R.id.gift_detail_back, "field 'giftDetailBack'", TextView.class);
        giftDetailsActivity.giftDetailLv = (LinearLayout) butterknife.c.a.c(view, R.id.gift_detail_lv, "field 'giftDetailLv'", LinearLayout.class);
        giftDetailsActivity.giftDetailLogo = (ImageView) butterknife.c.a.c(view, R.id.gift_detail_logo, "field 'giftDetailLogo'", ImageView.class);
        giftDetailsActivity.giftDetailName = (TextView) butterknife.c.a.c(view, R.id.gift_detail_name, "field 'giftDetailName'", TextView.class);
        giftDetailsActivity.giftDetailProgressbar = (ProgressBar) butterknife.c.a.c(view, R.id.gift_detail_progressbar, "field 'giftDetailProgressbar'", ProgressBar.class);
        giftDetailsActivity.giftDetailRemaining = (TextView) butterknife.c.a.c(view, R.id.gift_detail_remaining, "field 'giftDetailRemaining'", TextView.class);
        giftDetailsActivity.giftDetailNo = (TextView) butterknife.c.a.c(view, R.id.gift_detail_no, "field 'giftDetailNo'", TextView.class);
        giftDetailsActivity.giftDetailState2Ly = (LinearLayout) butterknife.c.a.c(view, R.id.gift_detail_state2_ly, "field 'giftDetailState2Ly'", LinearLayout.class);
        giftDetailsActivity.giftDetailState = (TextView) butterknife.c.a.c(view, R.id.gift_detail_state, "field 'giftDetailState'", TextView.class);
        giftDetailsActivity.giftDetailTip = (TextView) butterknife.c.a.c(view, R.id.gift_detail_tip, "field 'giftDetailTip'", TextView.class);
        giftDetailsActivity.giftDetailDrawTime = (TextView) butterknife.c.a.c(view, R.id.gift_detail_drawTime, "field 'giftDetailDrawTime'", TextView.class);
        giftDetailsActivity.giftDetailGiftInformation = (TextView) butterknife.c.a.c(view, R.id.gift_detail_giftInformation, "field 'giftDetailGiftInformation'", TextView.class);
        giftDetailsActivity.giftDetailExchangeTime = (TextView) butterknife.c.a.c(view, R.id.gift_detail_exchangeTime, "field 'giftDetailExchangeTime'", TextView.class);
        giftDetailsActivity.giftDetailUseMethod = (TextView) butterknife.c.a.c(view, R.id.gift_detail_useMethod, "field 'giftDetailUseMethod'", TextView.class);
        giftDetailsActivity.giftDetailDetail = (TextView) butterknife.c.a.c(view, R.id.gift_detail_detail, "field 'giftDetailDetail'", TextView.class);
        giftDetailsActivity.giftDetailsHintView = (TextView) butterknife.c.a.c(view, R.id.gift_details_hintView, "field 'giftDetailsHintView'", TextView.class);
        giftDetailsActivity.giftDetailProgressbarLv = (LinearLayout) butterknife.c.a.c(view, R.id.gift_detail_progressbar_lv, "field 'giftDetailProgressbarLv'", LinearLayout.class);
    }

    @CallSuper
    public void a() {
        GiftDetailsActivity giftDetailsActivity = this.b;
        if (giftDetailsActivity != null) {
            this.b = null;
            giftDetailsActivity.giftDetailBack = null;
            giftDetailsActivity.giftDetailLv = null;
            giftDetailsActivity.giftDetailLogo = null;
            giftDetailsActivity.giftDetailName = null;
            giftDetailsActivity.giftDetailProgressbar = null;
            giftDetailsActivity.giftDetailRemaining = null;
            giftDetailsActivity.giftDetailNo = null;
            giftDetailsActivity.giftDetailState2Ly = null;
            giftDetailsActivity.giftDetailState = null;
            giftDetailsActivity.giftDetailTip = null;
            giftDetailsActivity.giftDetailDrawTime = null;
            giftDetailsActivity.giftDetailGiftInformation = null;
            giftDetailsActivity.giftDetailExchangeTime = null;
            giftDetailsActivity.giftDetailUseMethod = null;
            giftDetailsActivity.giftDetailDetail = null;
            giftDetailsActivity.giftDetailsHintView = null;
            giftDetailsActivity.giftDetailProgressbarLv = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
