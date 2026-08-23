package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import java.util.List;

/* compiled from: SearchNoListenerAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class b3 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private List<String> f134c;
    private Context d;

    public b3(List<String> list, Context context) {
        super(list);
        this.d = context;
        this.f134c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) LayoutInflater.from(this.d).inflate(R.layout.tag_flow_vertical_item_layout, (ViewGroup) null);
        textView.setText(this.f134c.get((r4.size() - 1) - i));
        return textView;
    }
}
