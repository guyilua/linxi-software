package com.rtk.app.main.family;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCoinDetailBean;
import com.rtk.app.custom.SpacesItemDecoration;
import com.rtk.app.custom.YcRecyclerView;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCoinDetailActivity extends FamilyBaseActivity {

    @BindView
    View backLayout;

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    LinearLayout fragmentForRecyclerviewParentLayout;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    private String r;
    private int s = 1;
    private FamilyCoinDetailBean t;
    private List<FamilyCoinDetailBean.DataBean> u;
    private FamilyCoinDetailListAdapter v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            FamilyCoinDetailActivity.this.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(true);
        N(new int[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R() {
        N(new int[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.r);
        l.put("key", com.rtk.app.tool.t.L(l));
        l.put(com.rtk.app.tool.y.z("$*$page"), this.s + "");
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/coin/list", l)));
    }

    public void S() {
        this.s = 1;
        N(new int[0]);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        com.rtk.app.tool.c0.r("FamilyCoinDetailActivity", "success,str:" + str);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        FamilyCoinDetailBean familyCoinDetailBean = (FamilyCoinDetailBean) w(str, FamilyCoinDetailBean.class);
        this.t = familyCoinDetailBean;
        if (familyCoinDetailBean == null) {
            return;
        }
        if (this.s == 1) {
            this.u.clear();
        }
        this.u.addAll(this.t.getData());
        this.s++;
        if (this.t.getData().size() < 10) {
            this.v.j(true);
            this.v.k(false, null);
            this.fragmentForRecyclerviewLayoutListView.setIsEnd(true);
        } else {
            this.v.j(false);
            this.v.k(false, null);
        }
        this.v.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, f.a.f);
        com.rtk.app.tool.c0.u("FamilyCoinDetailActivity", "请求错误" + str);
        if (i2 != 1) {
            return;
        }
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.v.j(false);
        this.v.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.h
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                FamilyCoinDetailActivity.this.P(strArr);
            }
        });
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new a());
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.family.g
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                FamilyCoinDetailActivity.this.R();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        this.u = new ArrayList();
        this.fragmentForRecyclerviewLayoutListView.setLayoutManager(new LinearLayoutManager(this));
        this.fragmentForRecyclerviewLayoutListView.addItemDecoration(new SpacesItemDecoration(com.rtk.app.tool.h.a(10.0f, this)));
        FamilyCoinDetailListAdapter familyCoinDetailListAdapter = new FamilyCoinDetailListAdapter(this.u, this);
        this.v = familyCoinDetailListAdapter;
        this.fragmentForRecyclerviewLayoutListView.setAdapter(familyCoinDetailListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_coin_detail_layout);
        ButterKnife.a(this);
        this.r = getIntent().getStringExtra("family_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        N(1);
    }
}
