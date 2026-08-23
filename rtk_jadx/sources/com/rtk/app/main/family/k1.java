package com.rtk.app.main.family;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.LeaderBean;
import java.util.List;

/* compiled from: LeaderListAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class k1 extends BaseAdapter {
    List<LeaderBean> a;
    Activity b;

    /* compiled from: LeaderListAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    protected class a {
        RoundedImageView a;
        TextView b;

        protected a(k1 k1Var) {
        }
    }

    public k1(Activity activity, List<LeaderBean> list) {
        this.a = list;
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
            view = LayoutInflater.from(this.b).inflate(R.layout.game_gridview_item_layout, (ViewGroup) null);
            aVar = new a(this);
            aVar.a = view.findViewById(R.id.game_gridview_item_img);
            aVar.b = (TextView) view.findViewById(R.id.game_gridview_item_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        LeaderBean leaderBean = this.a.get(i);
        if (!TextUtils.isEmpty(leaderBean.getFace())) {
            aVar.a.setOval(true);
            aVar.a.setCornerRadius(com.sigmob.sdk.base.blurkit.c.d);
            com.rtk.app.tool.t.c(this.b, leaderBean.getFace(), aVar.a, new boolean[0]);
        } else if (leaderBean.getDefaultFace() != -1) {
            aVar.a.setOval(false);
            aVar.a.setCornerRadius(com.rtk.app.tool.h.a(10.0f, this.b));
            aVar.a.setImageResource(leaderBean.getDefaultFace());
        }
        aVar.b.setTextColor(-16777216);
        aVar.b.setText(leaderBean.getNickname());
        return view;
    }
}
