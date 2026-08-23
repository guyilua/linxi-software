package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import java.util.List;

/* compiled from: DialogPostMoreAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class x2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f143c;
    private List<String> d;
    private com.rtk.app.tool.s e;

    /* compiled from: DialogPostMoreAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x2.this.e.a((String) x2.this.d.get(this.a));
        }
    }

    public x2(Context context, List list, com.rtk.app.tool.s sVar) {
        super(list);
        this.d = list;
        this.f143c = context;
        this.e = sVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f143c).inflate(R.layout.dialog_post_more_item_layout, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.dialog_post_more_item_layout)).setText(this.d.get(i));
        view.setOnClickListener(new a(i));
        return view;
    }
}
