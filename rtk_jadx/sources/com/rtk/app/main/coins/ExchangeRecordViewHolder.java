package com.rtk.app.main.coins;

import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ExchangeRecordViewHolder {

    @BindView
    TextView exchange_result;

    @BindView
    TextView exchange_time;

    @BindView
    TextView get_gold_coin;

    @BindView
    TextView pay_r_coin;

    public ExchangeRecordViewHolder(View view) {
        ButterKnife.b(this, view);
    }
}
