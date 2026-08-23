package com.rtk.app.main.coins;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ExchangeRecordViewHolder_ViewBinding implements Unbinder {
    private ExchangeRecordViewHolder b;

    @UiThread
    public ExchangeRecordViewHolder_ViewBinding(ExchangeRecordViewHolder exchangeRecordViewHolder, View view) {
        this.b = exchangeRecordViewHolder;
        exchangeRecordViewHolder.exchange_time = (TextView) butterknife.c.a.c(view, R.id.exchange_time, "field 'exchange_time'", TextView.class);
        exchangeRecordViewHolder.pay_r_coin = (TextView) butterknife.c.a.c(view, R.id.pay_r_coin, "field 'pay_r_coin'", TextView.class);
        exchangeRecordViewHolder.get_gold_coin = (TextView) butterknife.c.a.c(view, R.id.get_gold_coin, "field 'get_gold_coin'", TextView.class);
        exchangeRecordViewHolder.exchange_result = (TextView) butterknife.c.a.c(view, R.id.exchange_result, "field 'exchange_result'", TextView.class);
    }

    @CallSuper
    public void a() {
        ExchangeRecordViewHolder exchangeRecordViewHolder = this.b;
        if (exchangeRecordViewHolder != null) {
            this.b = null;
            exchangeRecordViewHolder.exchange_time = null;
            exchangeRecordViewHolder.pay_r_coin = null;
            exchangeRecordViewHolder.get_gold_coin = null;
            exchangeRecordViewHolder.exchange_result = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
