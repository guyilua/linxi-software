package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.Home5MyIntegralAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.HomeMyContributeBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyContributeFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentMyGoldLayoutRecyclerView;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    View o;
    Unbinder p;
    private List<HomeMyContributeBean.DataBean> q;
    private int r = 1;
    private Home5MyIntegralAdapter s;
    private HomeMyContributeBean t;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        this.fragmentMyGoldLayoutRecyclerView.setRefreshing(true);
        x();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("Home5MyContributeFragment", "   我的贡献值   " + str);
        this.fragmentMyGoldLayoutRecyclerView.setRefreshing(false);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.t = (HomeMyContributeBean) create.fromJson(str, HomeMyContributeBean.class);
        if (this.r == 1) {
            this.q.clear();
        }
        this.q.addAll(this.t.getData());
        if (this.t.getData().size() < 10) {
            this.fragmentMyGoldLayoutRecyclerView.setIsEnd(true);
            this.s.j(true);
            this.s.k(false, null);
        } else {
            this.fragmentMyGoldLayoutRecyclerView.setIsEnd(false);
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
        this.r++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void z() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/myContributeList");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&page=");
        sb.append(this.r);
        sb.append("&limit=10&type=1&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyGoldLayoutRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.Home5Activity.o
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                Home5MyContributeFragment.this.x();
            }
        });
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.Home5Activity.q
            public final void onRefresh() {
                Home5MyContributeFragment.this.z();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.fragmentMyGoldLayoutRecyclerView.setRefreshing(false);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.s.j(true);
        this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.p
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                Home5MyContributeFragment.this.v(strArr);
            }
        });
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        getArguments();
        this.q = new ArrayList();
        this.fragmentMyGoldLayoutRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.fragmentMyGoldLayoutRecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        Home5MyIntegralAdapter home5MyIntegralAdapter = new Home5MyIntegralAdapter(this.e, this.q);
        this.s = home5MyIntegralAdapter;
        this.fragmentMyGoldLayoutRecyclerView.setAdapter(home5MyIntegralAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_recyclerview_layout, viewGroup, false);
            this.o = inflate;
            this.p = ButterKnife.b(this, inflate);
            b();
        } else {
            this.p = ButterKnife.b(this, view);
        }
        return this.o;
    }
}
