package com.rtk.app.main.coins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.rtk.app.R;
import java.util.ArrayList;

/* compiled from: ExchangeRecordGridViewAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d extends BaseAdapter {
    ArrayList<c> a;
    ExchangeRecordsActivity b;

    public d(ExchangeRecordsActivity exchangeRecordsActivity, ArrayList<c> arrayList) {
        this.a = arrayList;
        this.b = exchangeRecordsActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ExchangeRecordViewHolder exchangeRecordViewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.coins_exchange_records_list_item, (ViewGroup) null);
            exchangeRecordViewHolder = new ExchangeRecordViewHolder(view);
            view.setTag(exchangeRecordViewHolder);
        } else {
            exchangeRecordViewHolder = (ExchangeRecordViewHolder) view.getTag();
        }
        c cVar = this.a.get(i);
        exchangeRecordViewHolder.exchange_time.setText(cVar.b());
        exchangeRecordViewHolder.exchange_result.setText(cVar.a());
        exchangeRecordViewHolder.get_gold_coin.setText(cVar.c());
        exchangeRecordViewHolder.pay_r_coin.setText(cVar.d());
        return view;
    }
}
