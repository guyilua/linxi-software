package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.DialogForGoodsOrderFormAdapter;
import com.rtk.app.bean.GoodsDetailsBean;
import com.rtk.app.bean.ResponseDataBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForGoodsOrderForm extends o implements h.j {

    @BindView
    TextView dialogForGoodsOrderFormEnsure;

    @BindView
    ListView dialogForGoodsOrderFormListView;
    private Context k;
    private GoodsDetailsBean.DataBean l;
    private String m;
    private DialogForGoodsOrderFormAdapter n;

    public DialogForGoodsOrderForm(Context context, GoodsDetailsBean.DataBean dataBean) {
        super(context);
        this.m = "";
        this.k = context;
        this.l = dataBean;
        i(R.layout.dialog_for_goods_order_form_layout, 80);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
    }

    private void p(int i) {
        HashMap hashMap = new HashMap();
        if (i == 1) {
            Context context = this.k;
            hashMap.put("channel", com.rtk.app.tool.y.m(context, context.getPackageName()));
            hashMap.put("version", com.rtk.app.tool.y.i(this.k));
            hashMap.put(ak.aj, com.rtk.app.tool.y.g());
            hashMap.put("phone_model", com.rtk.app.tool.y.T());
            hashMap.put("uid", com.rtk.app.tool.y.K());
            hashMap.put("token", com.rtk.app.tool.y.H());
            hashMap.put("gid", this.l.getId());
            hashMap.put("num", "1");
            hashMap.put("gift_type", this.l.getGift_type());
            hashMap.put("msg", this.m);
            hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "token=" + com.rtk.app.tool.y.H(), "uid=" + com.rtk.app.tool.y.K(), "gid=" + this.l.getId(), "num=1", "gift_type=" + this.l.getGift_type()))));
        }
        com.rtk.app.tool.o.h.j(this.k, this, com.rtk.app.tool.y.d + "members/gift_apply", i, hashMap);
    }

    private void q() {
        DialogForGoodsOrderFormAdapter dialogForGoodsOrderFormAdapter = new DialogForGoodsOrderFormAdapter(this.k, this.l.getContact());
        this.n = dialogForGoodsOrderFormAdapter;
        this.dialogForGoodsOrderFormListView.setAdapter((ListAdapter) dialogForGoodsOrderFormAdapter);
        this.dialogForGoodsOrderFormEnsure.setOnClickListener(this);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("DialogForGoodsOrderForm", "申请商品  成功  " + str);
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.k, ((ResponseDataBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, ResponseDataBean.class)).getMsg(), f.a.f);
        dismiss();
        this.dialogForGoodsOrderFormEnsure.setEnabled(true);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.k, "申请失败:" + str, f.a.f);
        this.dialogForGoodsOrderFormEnsure.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297219) {
            return;
        }
        this.m = "";
        for (int i = 0; i < this.l.getContact().size(); i++) {
            String charSequence = ((TextView) ((ViewGroup) this.dialogForGoodsOrderFormListView.getChildAt(i)).getChildAt(0)).getText().toString();
            if (com.rtk.app.tool.c0.q(charSequence)) {
                com.rtk.app.tool.f.a(this.k, "请填写所有信息", f.a.f);
                return;
            }
            this.m += this.l.getContact().get(i).getTags() + ":" + charSequence + "\r\n";
        }
        p(1);
        this.dialogForGoodsOrderFormEnsure.setEnabled(false);
    }
}
