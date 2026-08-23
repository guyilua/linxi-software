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
import com.rtk.app.bean.GoodsReplyRecodeBean;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsReplyRecodeAdapter extends a3 {

    /* renamed from: c, reason: collision with root package name */
    private Context f64c;
    private List<GoodsReplyRecodeBean.DataBean> d;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static class ViewHolder {

        @BindView
        TextView goodsReplyRecodeItemAuditState;

        @BindView
        TextView goodsReplyRecodeItemNickName;

        @BindView
        TextView goodsReplyRecodeItemTime;

        ViewHolder(View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.b = viewHolder;
            viewHolder.goodsReplyRecodeItemAuditState = (TextView) butterknife.c.a.c(view, R.id.goods_reply_recode_item_audit_state, "field 'goodsReplyRecodeItemAuditState'", TextView.class);
            viewHolder.goodsReplyRecodeItemNickName = (TextView) butterknife.c.a.c(view, R.id.goods_reply_recode_item_nickName, "field 'goodsReplyRecodeItemNickName'", TextView.class);
            viewHolder.goodsReplyRecodeItemTime = (TextView) butterknife.c.a.c(view, R.id.goods_reply_recode_item_time, "field 'goodsReplyRecodeItemTime'", TextView.class);
        }

        @CallSuper
        public void a() {
            ViewHolder viewHolder = this.b;
            if (viewHolder != null) {
                this.b = null;
                viewHolder.goodsReplyRecodeItemAuditState = null;
                viewHolder.goodsReplyRecodeItemNickName = null;
                viewHolder.goodsReplyRecodeItemTime = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public GoodsReplyRecodeAdapter(Context context, List<GoodsReplyRecodeBean.DataBean> list) {
        super(list);
        this.f64c = context;
        this.d = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        if (r1.equals("2") != false) goto L19;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto L19
            android.content.Context r7 = r5.f64c
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r1 = 2131493316(0x7f0c01c4, float:1.8610109E38)
            android.view.View r7 = r7.inflate(r1, r8, r0)
            com.rtk.app.adapter.GoodsReplyRecodeAdapter$ViewHolder r8 = new com.rtk.app.adapter.GoodsReplyRecodeAdapter$ViewHolder
            r8.<init>(r7)
            r7.setTag(r8)
            goto L1f
        L19:
            java.lang.Object r8 = r7.getTag()
            com.rtk.app.adapter.GoodsReplyRecodeAdapter$ViewHolder r8 = (com.rtk.app.adapter.GoodsReplyRecodeAdapter.ViewHolder) r8
        L1f:
            java.util.List<com.rtk.app.bean.GoodsReplyRecodeBean$DataBean> r1 = r5.d
            java.lang.Object r1 = r1.get(r6)
            com.rtk.app.bean.GoodsReplyRecodeBean$DataBean r1 = (com.rtk.app.bean.GoodsReplyRecodeBean.DataBean) r1
            java.lang.String r1 = r1.getShow()
            r2 = -1
            int r3 = r1.hashCode()
            r4 = 1
            switch(r3) {
                case 48: goto L48;
                case 49: goto L3e;
                case 50: goto L35;
                default: goto L34;
            }
        L34:
            goto L52
        L35:
            java.lang.String r3 = "2"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L52
            goto L53
        L3e:
            java.lang.String r0 = "1"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L52
            r0 = 1
            goto L53
        L48:
            java.lang.String r0 = "0"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L52
            r0 = 2
            goto L53
        L52:
            r0 = -1
        L53:
            if (r0 == 0) goto L67
            if (r0 == r4) goto L5f
            android.widget.TextView r0 = r8.goodsReplyRecodeItemAuditState
            java.lang.String r1 = "审核中"
            r0.setText(r1)
            goto L6e
        L5f:
            android.widget.TextView r0 = r8.goodsReplyRecodeItemAuditState
            java.lang.String r1 = "审核通过"
            r0.setText(r1)
            goto L6e
        L67:
            android.widget.TextView r0 = r8.goodsReplyRecodeItemAuditState
            java.lang.String r1 = "审核未通过"
            r0.setText(r1)
        L6e:
            android.widget.TextView r0 = r8.goodsReplyRecodeItemNickName
            java.util.List<com.rtk.app.bean.GoodsReplyRecodeBean$DataBean> r1 = r5.d
            java.lang.Object r1 = r1.get(r6)
            com.rtk.app.bean.GoodsReplyRecodeBean$DataBean r1 = (com.rtk.app.bean.GoodsReplyRecodeBean.DataBean) r1
            java.lang.String r1 = r1.getGift_name()
            r0.setText(r1)
            android.widget.TextView r8 = r8.goodsReplyRecodeItemTime
            java.util.List<com.rtk.app.bean.GoodsReplyRecodeBean$DataBean> r0 = r5.d
            java.lang.Object r6 = r0.get(r6)
            com.rtk.app.bean.GoodsReplyRecodeBean$DataBean r6 = (com.rtk.app.bean.GoodsReplyRecodeBean.DataBean) r6
            long r0 = r6.getAddtime()
            java.lang.CharSequence r6 = com.rtk.app.tool.c0.o(r0)
            r8.setText(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.adapter.GoodsReplyRecodeAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
