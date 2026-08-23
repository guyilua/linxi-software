package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.ShoppingMallAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.GoodsListBean;
import com.rtk.app.bean.MallCoinBean;
import com.rtk.app.custom.NoBugGridLayoutManager;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ShoppingMallActivity extends BaseActivity implements h.j {
    private NoBugGridLayoutManager q;
    private ShoppingMallAdapter r;
    private List<GoodsListBean.DataBean> s = new ArrayList();

    @BindView
    RecyclerView shoppingMallRecyclerView;

    @BindView
    SwipeRefreshLayout shoppingMallSwipeRefresh;

    @BindView
    LinearLayout shoppingMallSwipeRefreshParent;

    @BindView
    TextView shoppingMallTopBack;

    @BindView
    LinearLayout shoppingMallTopLayout;
    private MallCoinBean t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        a(ShoppingMallActivity shoppingMallActivity) {
        }

        public int getSpanSize(int i) {
            return i > 0 ? 1 : 2;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements SwipeRefreshLayout.OnRefreshListener {
        b() {
        }

        public void onRefresh() {
            if (com.rtk.app.tool.y.x(ShoppingMallActivity.this.f147c)) {
                ShoppingMallActivity.this.L(0);
            }
            ShoppingMallActivity.this.L(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            ShoppingMallActivity.this.L(1);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.shoppingMallTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String str;
        String str2 = "";
        if (com.rtk.app.tool.y.x(this.f147c)) {
            str = "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H();
        } else {
            str = "";
        }
        int i = iArr[0];
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("members/usercoin");
            sb.append(com.rtk.app.tool.y.u(this.f147c));
            sb.append(str);
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            str2 = sb.toString();
        } else if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/gift_list");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append(str);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "token=" + com.rtk.app.tool.y.H(), "uid=" + com.rtk.app.tool.y.K()))));
            str2 = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str2));
        com.rtk.app.tool.c0.u("ShoppingMallActivity", "商城列表链接" + com.rtk.app.tool.y.d + str2);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.shoppingMallSwipeRefresh.setRefreshing(false);
        if (i == 0) {
            com.rtk.app.tool.c0.u("ShoppingMallActivity", "我的金币  " + str);
            MallCoinBean mallCoinBean = (MallCoinBean) this.g.fromJson(str, MallCoinBean.class);
            this.t = mallCoinBean;
            this.r.m(mallCoinBean);
            this.r.notifyDataSetChanged();
            return;
        }
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("ShoppingMallActivity", "商城列表  " + str);
        F();
        GoodsListBean goodsListBean = (GoodsListBean) this.g.fromJson(str, GoodsListBean.class);
        this.s.clear();
        this.s.addAll(goodsListBean.getData());
        this.r.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.shoppingMallSwipeRefresh.setRefreshing(false);
        if (i2 == 0) {
            com.rtk.app.tool.c0.u("ShoppingMallActivity", "金币详情  " + str);
            return;
        }
        if (i2 != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("ShoppingMallActivity", "商城列表失败  " + str);
        I(str, new c());
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        com.rtk.app.tool.c0.u("ShoppingMallActivity", "initData");
        this.q = new NoBugGridLayoutManager(this.f147c, 2);
        ShoppingMallAdapter shoppingMallAdapter = new ShoppingMallAdapter(this.f147c, this.s);
        this.r = shoppingMallAdapter;
        this.shoppingMallRecyclerView.setAdapter(shoppingMallAdapter);
        this.shoppingMallRecyclerView.setLayoutManager(this.q);
        this.q.setSpanSizeLookup(new a(this));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.shoppingMallSwipeRefresh.setOnRefreshListener(new b());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300204) {
            finish();
        } else {
            if (id != 2131300207) {
                return;
            }
            com.rtk.app.tool.c.b(this.f147c, GoodsReplyRecodeActivity.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_shopping_mall);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        com.rtk.app.tool.c0.u("ShoppingMallActivity", "1654564");
        if (com.rtk.app.tool.y.x(this.f147c)) {
            L(0);
        }
        L(1);
        LinearLayout linearLayout = this.shoppingMallSwipeRefreshParent;
        G(linearLayout, linearLayout);
    }
}
