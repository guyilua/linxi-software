package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.GoodsReplyRecodeAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.GoodsReplyRecodeBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GoodsReplyRecodeActivity extends BaseActivity implements h.j {

    @BindView
    AutoListView goodsReplyRecodeListView;

    @BindView
    LinearLayout goodsReplyRecodeParent;

    @BindView
    TextView goodsReplyRecodeTopBack;

    @BindView
    LinearLayout goodsReplyRecodeTopLayout;
    private int q = 1;
    private List<GoodsReplyRecodeBean.DataBean> r = new ArrayList();
    private GoodsReplyRecodeAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            GoodsReplyRecodeActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            GoodsReplyRecodeActivity.this.q = 1;
            GoodsReplyRecodeActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.c0.u("GoodsReplyRecodeActivity", "被点击的位置" + i);
            Bundle bundle = new Bundle();
            bundle.putString("gid", ((GoodsReplyRecodeBean.DataBean) GoodsReplyRecodeActivity.this.r.get(i + (-1))).getId());
            com.rtk.app.tool.c.b(GoodsReplyRecodeActivity.this.f147c, GoodsRecodeDetailsActivity.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        N(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.goodsReplyRecodeTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void N(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/gift_apply_record");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&page=");
            sb2.append(this.q);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "token=" + com.rtk.app.tool.y.H(), "uid=" + com.rtk.app.tool.y.K()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("GoodsReplyRecodeActivity", "商品购买 链接" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("GoodsReplyRecodeActivity", "请求成功  " + str);
        this.goodsReplyRecodeListView.k();
        F();
        if (i != 1) {
            return;
        }
        GoodsReplyRecodeBean goodsReplyRecodeBean = (GoodsReplyRecodeBean) this.g.fromJson(str, GoodsReplyRecodeBean.class);
        this.r.addAll(goodsReplyRecodeBean.getData());
        if (goodsReplyRecodeBean.getCode().intValue() == 0 && goodsReplyRecodeBean.getData() != null) {
            if (this.q == 1) {
                this.r.clear();
            }
            this.r.addAll(goodsReplyRecodeBean.getData());
            this.s.notifyDataSetChanged();
            this.goodsReplyRecodeListView.setResultSize(goodsReplyRecodeBean.getData().size());
        }
        this.q++;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("GoodsReplyRecodeActivity", "请求失败  " + str);
        if (i2 != 1) {
            return;
        }
        this.goodsReplyRecodeListView.f();
        if (this.q == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.n
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    GoodsReplyRecodeActivity.this.P(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.goodsReplyRecodeListView.setOnLoadListener(new a());
        this.goodsReplyRecodeListView.setOnRefreshListener(new b());
        this.goodsReplyRecodeListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        LinearLayout linearLayout = this.goodsReplyRecodeParent;
        G(linearLayout, linearLayout);
        N(1);
        GoodsReplyRecodeAdapter goodsReplyRecodeAdapter = new GoodsReplyRecodeAdapter(this.f147c, this.r);
        this.s = goodsReplyRecodeAdapter;
        this.goodsReplyRecodeListView.setAdapter((ListAdapter) goodsReplyRecodeAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297834) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_goods_reply_recode);
        ButterKnife.a(this);
    }
}
