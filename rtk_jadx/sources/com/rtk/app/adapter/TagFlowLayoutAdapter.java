package com.rtk.app.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.bean.GameDetailsBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TagFlowLayoutAdapter extends com.zhy.view.flowlayout.a<GameDetailsBean.DataBean.GameTagListBean> {
    private Context d;
    private List<GameDetailsBean.DataBean.GameTagListBean> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder {

        @BindView
        TextView tabFlowLayoutItemTv;

        ViewHolder(TagFlowLayoutAdapter tagFlowLayoutAdapter, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.tabFlowLayoutItemTv = (TextView) butterknife.c.a.c(view, R.id.tab_flow_layout_item_tv, "field 'tabFlowLayoutItemTv'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.tabFlowLayoutItemTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public TagFlowLayoutAdapter(Context context, List<GameDetailsBean.DataBean.GameTagListBean> list) {
        super(list);
        this.d = context;
        this.e = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006f, code lost:
    
        return r3;
     */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View d(com.zhy.view.flowlayout.FlowLayout r3, int r4, com.rtk.app.bean.GameDetailsBean.DataBean.GameTagListBean r5) {
        /*
            r2 = this;
            android.content.Context r5 = r2.d
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            r0 = 2131493775(0x7f0c038f, float:1.861104E38)
            r1 = 0
            android.view.View r3 = r5.inflate(r0, r3, r1)
            com.rtk.app.adapter.TagFlowLayoutAdapter$ViewHolder r5 = new com.rtk.app.adapter.TagFlowLayoutAdapter$ViewHolder
            r5.<init>(r2, r3)
            android.widget.TextView r5 = r5.tabFlowLayoutItemTv
            java.util.List<com.rtk.app.bean.GameDetailsBean$DataBean$GameTagListBean> r0 = r2.e
            java.lang.Object r0 = r0.get(r4)
            com.rtk.app.bean.GameDetailsBean$DataBean$GameTagListBean r0 = (com.rtk.app.bean.GameDetailsBean.DataBean.GameTagListBean) r0
            java.lang.String r0 = r0.getTag_name()
            r5.setText(r0)
            int r4 = r4 % 10
            switch(r4) {
                case 0: goto L69;
                case 1: goto L62;
                case 2: goto L5b;
                case 3: goto L54;
                case 4: goto L4d;
                case 5: goto L46;
                case 6: goto L3f;
                case 7: goto L38;
                case 8: goto L31;
                case 9: goto L2a;
                default: goto L29;
            }
        L29:
            goto L6f
        L2a:
            r4 = 2131231649(0x7f0803a1, float:1.8079385E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L31:
            r4 = 2131231671(0x7f0803b7, float:1.807943E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L38:
            r4 = 2131231670(0x7f0803b6, float:1.8079428E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L3f:
            r4 = 2131231669(0x7f0803b5, float:1.8079426E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L46:
            r4 = 2131231668(0x7f0803b4, float:1.8079424E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L4d:
            r4 = 2131231666(0x7f0803b2, float:1.807942E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L54:
            r4 = 2131231664(0x7f0803b0, float:1.8079415E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L5b:
            r4 = 2131231662(0x7f0803ae, float:1.8079411E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L62:
            r4 = 2131231658(0x7f0803aa, float:1.8079403E38)
            r3.setBackgroundResource(r4)
            goto L6f
        L69:
            r4 = 2131231650(0x7f0803a2, float:1.8079387E38)
            r3.setBackgroundResource(r4)
        L6f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.adapter.TagFlowLayoutAdapter.d(com.zhy.view.flowlayout.FlowLayout, int, com.rtk.app.bean.GameDetailsBean$DataBean$GameTagListBean):android.view.View");
    }
}
