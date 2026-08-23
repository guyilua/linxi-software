package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import com.rtk.app.bean.TagsBean;
import java.util.List;

/* compiled from: DialogPostMoreRemovePostForTagAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class z2 extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f145c;
    private List<TagsBean> d;

    public z2(Context context, List<TagsBean> list) {
        super(list);
        this.d = list;
        this.f145c = context;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f145c).inflate(R.layout.my_tag_for_remove_post_layout, (ViewGroup) null);
        }
        ((TextView) view).setText(this.d.get(i).getName());
        return view;
    }
}
