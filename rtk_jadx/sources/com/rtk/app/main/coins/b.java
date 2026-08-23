package com.rtk.app.main.coins;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.rtk.app.R;
import com.rtk.app.bean.OptionsBean;
import java.util.ArrayList;

/* compiled from: ExchangeGoldCoinsAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b extends BaseAdapter {
    ArrayList<OptionsBean> a;
    Context b;

    /* compiled from: ExchangeGoldCoinsAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class a {
        TextView a;
        TextView b;

        /* renamed from: c, reason: collision with root package name */
        RelativeLayout f225c;

        protected a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(ExchangeGoldCoinsActivity exchangeGoldCoinsActivity, ArrayList<OptionsBean> arrayList) {
        this.a = arrayList;
        this.b = exchangeGoldCoinsActivity;
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
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.exchange_glod_coins_list_item, (ViewGroup) null);
            aVar = new a();
            aVar.a = (TextView) view.findViewById(R.id.tv);
            aVar.b = (TextView) view.findViewById(R.id.option);
            aVar.f225c = (RelativeLayout) view.findViewById(2131299707);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        OptionsBean optionsBean = this.a.get(i);
        aVar.a.setText(optionsBean.getCoin() + "金币");
        aVar.b.setText("消耗" + optionsBean.getRcoin() + "R币");
        aVar.f225c.setBackgroundResource(R.drawable.bg_ptb_price);
        if (optionsBean.isChecked()) {
            aVar.a.setTextColor(ContextCompat.getColor(this.b, R.color.bool_red));
            aVar.b.setTextColor(ContextCompat.getColor(this.b, R.color.bool_red));
            aVar.f225c.setBackgroundResource(R.drawable.bg_green);
        } else {
            aVar.a.setTextColor(ContextCompat.getColor(this.b, R.color.color_text_2));
            aVar.b.setTextColor(ContextCompat.getColor(this.b, R.color.color_text_2));
            aVar.f225c.setBackgroundResource(R.drawable.bg_shadow_white);
        }
        return view;
    }
}
