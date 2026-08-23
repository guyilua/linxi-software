package com.rtk.app.main.coins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.rtk.app.R;
import com.rtk.app.bean.OptionsBean;
import java.util.ArrayList;

/* compiled from: CoinsGridViewAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends BaseAdapter {
    ArrayList<OptionsBean> a;
    RechargeRCoinsActivity b;

    /* compiled from: CoinsGridViewAdapter.java */
    /* renamed from: com.rtk.app.main.coins.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class C0022a {
        TextView a;

        protected C0022a() {
        }
    }

    public a(RechargeRCoinsActivity rechargeRCoinsActivity, ArrayList<OptionsBean> arrayList) {
        this.a = arrayList;
        this.b = rechargeRCoinsActivity;
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
        C0022a c0022a;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.coins_grid_view_item, (ViewGroup) null);
            c0022a = new C0022a();
            c0022a.a = (TextView) view.findViewById(R.id.tv);
            view.setTag(c0022a);
        } else {
            c0022a = (C0022a) view.getTag();
        }
        OptionsBean optionsBean = this.a.get(i);
        c0022a.a.setText(optionsBean.getRmb() + "元");
        c0022a.a.setSelected(optionsBean.isChecked());
        c0022a.a.setTextColor(ContextCompat.getColor(this.b, optionsBean.isChecked() ? R.color.bool_red : R.color.color_text_2));
        return view;
    }
}
