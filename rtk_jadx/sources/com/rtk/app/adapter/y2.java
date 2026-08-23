package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.bean.HomeCommunityBean;
import java.util.List;

/* compiled from: DialogPostMoreRemovePostAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class y2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f144c;
    private List<HomeCommunityBean.DataBean> d;

    public y2(Context context, List<HomeCommunityBean.DataBean> list) {
        super(list);
        this.f144c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f144c).inflate(R.layout.dialog_post_more_remove_item_layout, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.dialog_post_more_remove_item_modeName)).setText(this.d.get(i).getName());
        return view;
    }
}
