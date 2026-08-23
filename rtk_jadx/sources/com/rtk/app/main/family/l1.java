package com.rtk.app.main.family;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.rtk.app.R;
import java.util.ArrayList;

/* compiled from: MyFamilyFeatureAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class l1 extends BaseAdapter {
    ArrayList<i1> a;
    Activity b;

    /* compiled from: MyFamilyFeatureAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected static class a {
        ImageView a;
        TextView b;

        protected a() {
        }
    }

    public l1(Activity activity, ArrayList<i1> arrayList) {
        this.a = arrayList;
        this.b = activity;
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
            view = LayoutInflater.from(this.b).inflate(R.layout.family_feature_gridview_item_layout, (ViewGroup) null);
            aVar = new a();
            aVar.a = (ImageView) view.findViewById(R.id.game_gridview_item_img);
            aVar.b = (TextView) view.findViewById(R.id.game_gridview_item_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        i1 i1Var = this.a.get(i);
        aVar.a.setImageResource(i1Var.a());
        aVar.b.setText(i1Var.b());
        return view;
    }
}
