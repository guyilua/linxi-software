package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.bean.TagsBean;
import java.util.List;

/* compiled from: DialogForPostTagAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class v2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f141c;
    private List<TagsBean> d;

    public v2(Context context, List<TagsBean> list) {
        super(list);
        this.f141c = context;
        this.d = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f141c).inflate(R.layout.dialog_post_more_item_layout, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.dialog_post_more_item_layout)).setText(this.d.get(i).getName());
        return view;
    }
}
