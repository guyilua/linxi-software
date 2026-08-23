package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.HomeUpSrcClassifyAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpClassifyBean;
import com.rtk.app.custom.GridViewForScrollView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpClassifyActivity extends BaseActivity implements h.j {

    @BindView
    GridViewForScrollView homeUpClassifyGameGridView;

    @BindView
    GridViewForScrollView homeUpClassifySoftGridView;

    @BindView
    SwipeRefreshLayout homeUpClassifySwipeLayout;

    @BindView
    TextView homeUpClassifyTopBack;

    @BindView
    LinearLayout homeUpClassifyTopLayout;
    private int q = 1;
    private List<UpClassifyBean.DataBean.GameBean> r;
    private List<UpClassifyBean.DataBean.SoftBean> s;
    private HomeUpSrcClassifyAdapter t;
    private HomeUpSrcClassifyAdapter u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            HomeUpClassifyActivity.this.L(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            HomeUpClassifyActivity.this.L(1);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.homeUpClassifyTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String str;
        if (iArr[0] != 1) {
            str = "";
        } else {
            str = "game/upclasscategory" + y.u(this.f147c) + "&tags=day&page=" + this.q + "&key=" + t.c0(c0.e(y.v(this.f147c, "tags=day")));
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        this.homeUpClassifySwipeLayout.setRefreshing(false);
        F();
        c0.u("HomeUpClassifyActivity", " 分类  " + str);
        UpClassifyBean upClassifyBean = (UpClassifyBean) this.g.fromJson(str, UpClassifyBean.class);
        if (upClassifyBean.getData() != null) {
            this.r.clear();
            this.s.clear();
            this.r.addAll(upClassifyBean.getData().getGame());
            this.s.addAll(upClassifyBean.getData().getSoft());
            this.t.notifyDataSetChanged();
            this.u.notifyDataSetChanged();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        this.homeUpClassifySwipeLayout.setRefreshing(false);
        I(str, new b());
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.homeUpClassifySwipeLayout.setOnRefreshListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.r = new ArrayList();
        this.s = new ArrayList();
        G(null, this.homeUpClassifyTopLayout);
        L(1);
        this.t = new HomeUpSrcClassifyAdapter(this.f147c, this.r, null);
        this.u = new HomeUpSrcClassifyAdapter(this.f147c, null, this.s);
        this.homeUpClassifyGameGridView.setAdapter((ListAdapter) this.t);
        this.homeUpClassifySoftGridView.setAdapter((ListAdapter) this.u);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298109) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home_up_classify);
        ButterKnife.a(this);
    }
}
