package com.rtk.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rtk.app.R;
import com.zhy.view.flowlayout.FlowLayout;
import java.util.List;
import java.util.Objects;

/* compiled from: TagFlowAdapter.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class c3 extends com.zhy.view.flowlayout.a<String> {
    private List<String> d;
    private Context e;
    private boolean f;
    private boolean g;
    private com.rtk.app.tool.s h;
    private com.rtk.app.tool.s i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TagFlowAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            c3.this.d.remove(((Integer) view.getTag()).intValue());
            c3.this.e();
            Objects.requireNonNull(c3.this.h, "longClickCallback不可为空");
            c3.this.h.a(new String[0]);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TagFlowAdapter.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            Objects.requireNonNull(c3.this.i, "onClickCallBack不可为空");
            c3.this.i.a((String) c3.this.d.get(intValue));
        }
    }

    public c3(List<String> list, Context context, com.rtk.app.tool.s... sVarArr) {
        super(list);
        this.f = false;
        this.g = false;
        this.d = list;
        this.e = context;
        if (sVarArr.length > 0) {
            this.h = sVarArr[0];
        }
        if (sVarArr.length > 1) {
            this.i = sVarArr[1];
        }
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public View d(FlowLayout flowLayout, int i, String str) {
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.tag_flow_item_layout, (ViewGroup) flowLayout, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tag_flow_item_tv);
        if (this.f) {
            textView.setText(this.d.get((r0.size() - 1) - i));
            inflate.setTag(Integer.valueOf((this.d.size() - 1) - i));
        } else {
            textView.setText(this.d.get(i));
            inflate.setTag(Integer.valueOf(i));
        }
        if (this.g) {
            inflate.setOnLongClickListener(new a());
        }
        inflate.setOnClickListener(new b());
        return inflate;
    }

    public void l() {
        this.f = true;
    }

    public void m() {
        this.g = true;
    }
}
