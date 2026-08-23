package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.List;

/* compiled from: TagFlowNotListenerSmallForGameAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class d3 extends com.zhy.view.flowlayout.a<String> {
    private List<String> d;
    private Context e;

    public d3(List<String> list, Context context) {
        super(list);
        this.d = list;
        this.e = context;
    }

    public int a() {
        if (this.d.size() > 2) {
            return 2;
        }
        return super.a();
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public View d(FlowLayout flowLayout, int i, String str) {
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.tag_flow_item_layout1, (ViewGroup) flowLayout, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tag_flow_item1_tv);
        textView.setText(this.d.get(i));
        int i2 = i % 4;
        if (i2 == 0) {
            textView.setBackgroundResource(R.drawable.shape_corner_theme1_2dp);
        } else if (i2 == 1) {
            textView.setBackgroundResource(R.drawable.shape_corner_theme2_2dp);
        } else if (i2 == 2) {
            textView.setBackgroundResource(R.drawable.shape_corner_theme3_2dp);
        } else if (i2 == 3) {
            textView.setBackgroundResource(R.drawable.shape_corner_theme4_2dp);
        }
        return inflate;
    }
}
