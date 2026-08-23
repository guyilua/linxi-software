package com.rtk.app.main.coins;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.custom.NoOOMEditText;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RechargeRCoinsActivity_ViewBinding implements Unbinder {
    private RechargeRCoinsActivity b;

    @UiThread
    public RechargeRCoinsActivity_ViewBinding(RechargeRCoinsActivity rechargeRCoinsActivity, View view) {
        this.b = rechargeRCoinsActivity;
        rechargeRCoinsActivity.gridView = (GridView) butterknife.c.a.c(view, R.id.coins_grid_view, "field 'gridView'", GridView.class);
        rechargeRCoinsActivity.goRecharge = butterknife.c.a.b(view, R.id.go_recharge, "field 'goRecharge'");
        rechargeRCoinsActivity.exchangeGoldCoins = butterknife.c.a.b(view, R.id.exchange_gold_coins, "field 'exchangeGoldCoins'");
        rechargeRCoinsActivity.account = (TextView) butterknife.c.a.c(view, R.id.account, "field 'account'", TextView.class);
        rechargeRCoinsActivity.rCoins = (TextView) butterknife.c.a.c(view, R.id.rcoins, "field 'rCoins'", TextView.class);
        rechargeRCoinsActivity.desc = (TextView) butterknife.c.a.c(view, 2131297103, "field 'desc'", TextView.class);
        rechargeRCoinsActivity.customMoneyLayout = butterknife.c.a.b(view, R.id.custom_money_layout, "field 'customMoneyLayout'");
        rechargeRCoinsActivity.btnWechat = butterknife.c.a.b(view, R.id.btn_wechat, "field 'btnWechat'");
        rechargeRCoinsActivity.btnZfb = butterknife.c.a.b(view, R.id.btn_zfb, "field 'btnZfb'");
        rechargeRCoinsActivity.btnWechatQrcode = butterknife.c.a.b(view, R.id.btn_wechat_qrcode, "field 'btnWechatQrcode'");
        rechargeRCoinsActivity.btnZfbQrcode = butterknife.c.a.b(view, R.id.btn_zfb_qrcode, "field 'btnZfbQrcode'");
        rechargeRCoinsActivity.btnWechatH5 = butterknife.c.a.b(view, R.id.btn_wechat_h5, "field 'btnWechatH5'");
        rechargeRCoinsActivity.btnZfbH5 = butterknife.c.a.b(view, R.id.btn_zfb_h5, "field 'btnZfbH5'");
        rechargeRCoinsActivity.selectPayLayout = butterknife.c.a.b(view, R.id.select_pay_layout, "field 'selectPayLayout'");
        rechargeRCoinsActivity.etCustom = (NoOOMEditText) butterknife.c.a.c(view, R.id.et_custom, "field 'etCustom'", NoOOMEditText.class);
        rechargeRCoinsActivity.ratio = (TextView) butterknife.c.a.c(view, R.id.ratio, "field 'ratio'", TextView.class);
        rechargeRCoinsActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
    }

    @CallSuper
    public void a() {
        RechargeRCoinsActivity rechargeRCoinsActivity = this.b;
        if (rechargeRCoinsActivity != null) {
            this.b = null;
            rechargeRCoinsActivity.gridView = null;
            rechargeRCoinsActivity.goRecharge = null;
            rechargeRCoinsActivity.exchangeGoldCoins = null;
            rechargeRCoinsActivity.account = null;
            rechargeRCoinsActivity.rCoins = null;
            rechargeRCoinsActivity.desc = null;
            rechargeRCoinsActivity.customMoneyLayout = null;
            rechargeRCoinsActivity.btnWechat = null;
            rechargeRCoinsActivity.btnZfb = null;
            rechargeRCoinsActivity.btnWechatQrcode = null;
            rechargeRCoinsActivity.btnZfbQrcode = null;
            rechargeRCoinsActivity.btnWechatH5 = null;
            rechargeRCoinsActivity.btnZfbH5 = null;
            rechargeRCoinsActivity.selectPayLayout = null;
            rechargeRCoinsActivity.etCustom = null;
            rechargeRCoinsActivity.ratio = null;
            rechargeRCoinsActivity.backLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
