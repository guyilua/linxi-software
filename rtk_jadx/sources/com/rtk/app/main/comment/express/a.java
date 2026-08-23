package com.rtk.app.main.comment.express;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.rtk.app.R;
import java.util.List;

/* compiled from: ExpressionAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a extends BaseAdapter {
    private List<Integer> a;
    private LayoutInflater b;

    /* compiled from: ExpressionAdapter.java */
    /* renamed from: com.rtk.app.main.comment.express.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class C0023a {
        ImageView a;

        C0023a(a aVar) {
        }
    }

    public a(LayoutInflater layoutInflater, List<Integer> list) {
        this.b = layoutInflater;
        this.a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size() + 1;
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
        C0023a c0023a;
        if (view == null) {
            view = this.b.inflate(R.layout.rc_emoji_item, (ViewGroup) null);
            c0023a = new C0023a(this);
            c0023a.a = (ImageView) view.findViewById(R.id.rc_emoji_item);
            view.setTag(c0023a);
        } else {
            c0023a = (C0023a) view.getTag();
        }
        if (i == this.a.size()) {
            c0023a.a.setImageResource(R.drawable.emoji_delete);
        } else {
            c0023a.a.setImageResource(this.a.get(i).intValue());
        }
        return view;
    }
}
