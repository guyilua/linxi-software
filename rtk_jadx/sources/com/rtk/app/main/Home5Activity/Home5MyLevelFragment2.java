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
import com.rtk.app.adapter.Home5MyLevelAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.Home5MyLevelBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyLevelFragment2 extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView myLevelFragmentRecyclerView;

    @BindView
    SwipeRefreshLayout myLevelFragmentSwipeRefresh;
    View o;
    Unbinder p;
    private List<Home5MyLevelBean.DataBean> q;
    private int r = 1;
    private Home5MyLevelAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements YcRecyclerView.b {
        a() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            Home5MyLevelFragment2.this.z();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements SwipeRefreshLayout.OnRefreshListener {
        b() {
        }

        public void onRefresh() {
            Home5MyLevelFragment2.this.r = 1;
            Home5MyLevelFragment2.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        this.myLevelFragmentRecyclerView.setRefreshing(true);
        z();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.myLevelFragmentSwipeRefresh.setRefreshing(false);
        this.myLevelFragmentRecyclerView.setRefreshing(false);
        com.rtk.app.tool.c0.u("Home5MyLevelFragment2", " 我的经验值   " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        Home5MyLevelBean home5MyLevelBean = (Home5MyLevelBean) create.fromJson(str, Home5MyLevelBean.class);
        if (this.r == 1) {
            this.q.clear();
        }
        this.q.addAll(home5MyLevelBean.getData());
        if (home5MyLevelBean.getData().size() < 10) {
            this.myLevelFragmentRecyclerView.setIsEnd(true);
            this.s.j(true);
            this.s.k(false, null);
        } else {
            this.myLevelFragmentRecyclerView.setIsEnd(false);
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
        this.r++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/myExperienceList");
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
        this.myLevelFragmentRecyclerView.setRecyclerViewOnTheDownListener(new a());
        this.myLevelFragmentSwipeRefresh.setOnRefreshListener(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        this.myLevelFragmentSwipeRefresh.setRefreshing(false);
        this.myLevelFragmentRecyclerView.setRefreshing(false);
        this.s.j(true);
        this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.s
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                Home5MyLevelFragment2.this.w(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        getArguments();
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        this.s = new Home5MyLevelAdapter(this.e, arrayList);
        this.myLevelFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.myLevelFragmentRecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        this.myLevelFragmentRecyclerView.setAdapter(this.s);
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
