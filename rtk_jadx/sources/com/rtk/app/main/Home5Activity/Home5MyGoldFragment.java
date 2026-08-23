package com.rtk.app.main.Home5Activity;

import android.content.Context;
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
import com.rtk.app.adapter.Home5MyGoldAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.Home5MyGoldBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyGoldFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentMyGoldLayoutRecyclerView;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    View o;
    Unbinder p;
    private List<Home5MyGoldBean.DataBean.ListBean> q;
    private int r = 1;
    private int s;
    private Home5MyGoldAdapter t;
    private Home5MyGoldActivity u;
    private Home5MyGoldBean v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements YcRecyclerView.b {
        a() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            Home5MyGoldFragment.this.A();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements SwipeRefreshLayout.OnRefreshListener {
        b() {
        }

        public void onRefresh() {
            Home5MyGoldFragment.this.r = 1;
            Home5MyGoldFragment.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        this.fragmentMyGoldLayoutRecyclerView.setRefreshing(true);
        A();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentMyGoldLayoutRecyclerView.setRefreshing(false);
        com.rtk.app.tool.c0.u("Home5MyGoldFragment", " 我的金币   " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.v = (Home5MyGoldBean) create.fromJson(str, Home5MyGoldBean.class);
        if (this.r == 1) {
            this.q.clear();
            this.u.L(this.v);
        }
        this.q.addAll(this.v.getData().getList());
        if (this.v.getData().getList().size() < 30) {
            this.fragmentMyGoldLayoutRecyclerView.setIsEnd(true);
            this.t.j(true);
            this.t.k(false, null);
        } else {
            this.fragmentMyGoldLayoutRecyclerView.setIsEnd(false);
            this.t.j(false);
            this.t.k(false, null);
        }
        this.t.notifyDataSetChanged();
        this.r++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void A() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/myCoinList");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&page=");
        sb.append(this.r);
        sb.append("&limit=30&type=");
        sb.append(this.s);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyGoldLayoutRecyclerView.setRecyclerViewOnTheDownListener(new a());
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentMyGoldLayoutRecyclerView.setRefreshing(false);
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        this.t.j(true);
        this.t.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.r
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                Home5MyGoldFragment.this.w(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.s = getArguments().getInt(com.umeng.analytics.pro.d.y);
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        this.t = new Home5MyGoldAdapter(this.e, arrayList);
        this.fragmentMyGoldLayoutRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.fragmentMyGoldLayoutRecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        this.fragmentMyGoldLayoutRecyclerView.setAdapter(this.t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach(Context context) {
        super.onAttach(context);
        this.u = (Home5MyGoldActivity) context;
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

    public void onDestroyView() {
        super.onDestroyView();
        this.p.a();
    }
}
