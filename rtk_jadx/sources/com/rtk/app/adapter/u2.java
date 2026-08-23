package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import java.util.List;

/* compiled from: AboutUsAndHelpQQListViewAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class u2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f140c;
    private List<String> d;

    public u2(Context context, List<String> list) {
        super(list);
        this.f140c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f140c).inflate(R.layout.about_us_and_help_qq_list_item_layout, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.about_us_and_help_qq_listItem_QQ)).setText("QQ官方" + (i + 1) + "群" + this.d.get(i));
        return view;
    }
}
