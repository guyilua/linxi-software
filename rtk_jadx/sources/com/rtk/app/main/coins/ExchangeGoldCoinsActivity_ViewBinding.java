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
public class ExchangeGoldCoinsActivity_ViewBinding implements Unbinder {
    private ExchangeGoldCoinsActivity b;

    @UiThread
    public ExchangeGoldCoinsActivity_ViewBinding(ExchangeGoldCoinsActivity exchangeGoldCoinsActivity, View view) {
        this.b = exchangeGoldCoinsActivity;
        exchangeGoldCoinsActivity.gridView = (GridView) butterknife.c.a.c(view, R.id.exchange_gold_grid_view, "field 'gridView'", GridView.class);
        exchangeGoldCoinsActivity.exchangeRecord = butterknife.c.a.b(view, R.id.exchange_record, "field 'exchangeRecord'");
        exchangeGoldCoinsActivity.rCoins = (TextView) butterknife.c.a.c(view, R.id.r_coins, "field 'rCoins'", TextView.class);
        exchangeGoldCoinsActivity.coins = (TextView) butterknife.c.a.c(view, R.id.coins, "field 'coins'", TextView.class);
        exchangeGoldCoinsActivity.etCustom = (NoOOMEditText) butterknife.c.a.c(view, R.id.et_custom, "field 'etCustom'", NoOOMEditText.class);
        exchangeGoldCoinsActivity.ratio = (TextView) butterknife.c.a.c(view, R.id.ratio, "field 'ratio'", TextView.class);
        exchangeGoldCoinsActivity.customMoneyLayout = butterknife.c.a.b(view, R.id.custom_money_layout, "field 'customMoneyLayout'");
        exchangeGoldCoinsActivity.tips = (TextView) butterknife.c.a.c(view, R.id.tips, "field 'tips'", TextView.class);
        exchangeGoldCoinsActivity.manager = (TextView) butterknife.c.a.c(view, R.id.manager, "field 'manager'", TextView.class);
        exchangeGoldCoinsActivity.recharge = (TextView) butterknife.c.a.c(view, R.id.recharge, "field 'recharge'", TextView.class);
        exchangeGoldCoinsActivity.backLayout = butterknife.c.a.b(view, R.id.back_layout, "field 'backLayout'");
        exchangeGoldCoinsActivity.pwdLayout = butterknife.c.a.b(view, R.id.pwd_layout, "field 'pwdLayout'");
    }

    @CallSuper
    public void a() {
        ExchangeGoldCoinsActivity exchangeGoldCoinsActivity = this.b;
        if (exchangeGoldCoinsActivity != null) {
            this.b = null;
            exchangeGoldCoinsActivity.gridView = null;
            exchangeGoldCoinsActivity.exchangeRecord = null;
            exchangeGoldCoinsActivity.rCoins = null;
            exchangeGoldCoinsActivity.coins = null;
            exchangeGoldCoinsActivity.etCustom = null;
            exchangeGoldCoinsActivity.ratio = null;
            exchangeGoldCoinsActivity.customMoneyLayout = null;
            exchangeGoldCoinsActivity.tips = null;
            exchangeGoldCoinsActivity.manager = null;
            exchangeGoldCoinsActivity.recharge = null;
            exchangeGoldCoinsActivity.backLayout = null;
            exchangeGoldCoinsActivity.pwdLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
