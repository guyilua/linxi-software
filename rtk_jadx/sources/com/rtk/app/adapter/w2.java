package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import java.util.List;

/* compiled from: DialogGridViewAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class w2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f142c;
    private List<String> d;
    private int e;

    public w2(Context context, List<String> list, int i) {
        super(list);
        this.f142c = context;
        this.d = list;
        this.e = i;
    }

    public void e(int i) {
        this.e = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f142c).inflate(R.layout.dialog_screen_item, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_screen_item_TV);
        textView.setText(this.d.get(i));
        if (this.e == i) {
            textView.setSelected(true);
        }
        return inflate;
    }
}
