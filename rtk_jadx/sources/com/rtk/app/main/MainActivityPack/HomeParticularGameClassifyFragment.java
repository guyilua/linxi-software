package com.rtk.app.main.MainActivityPack;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.GameMutualityGridViewAdapter;
import com.rtk.app.adapter.GameMutualityListViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.custom.GridViewForScrollView;
import com.rtk.app.main.LiBaoListActivity;
import com.rtk.app.main.OpenServiceActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeParticularGameClassifyFragment extends BaseFragment implements h.j {

    @BindView
    GridViewForScrollView homeParticularGameClassifyGridView;

    @BindView
    ListView homeParticularGameClassifyListview;

    @BindView
    SwipeRefreshLayout homeParticularGameClassifySwipeRefreshLayout;
    private Unbinder o;
    private GameMutualityGridViewAdapter p;
    private ArrayList<RecommendModuleAndClassifyBean.DataBean.MatrixBean> q;
    private ArrayList<RecommendModuleAndClassifyBean.DataBean.CategoryBean> r;
    private GameMutualityListViewAdapter s;
    private RecommendModuleAndClassifyBean t;
    private String u = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            String methods = HomeParticularGameClassifyFragment.this.t.getData().getMatrix().get(i).getMethods();
            methods.hashCode();
            char c2 = 65535;
            switch (methods.hashCode()) {
                case -1768442992:
                    if (methods.equals("gamelist")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1140035200:
                    if (methods.equals("kaifulist")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 338813073:
                    if (methods.equals("libaolist")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    new Bundle();
                    com.rtk.app.tool.t.T0(((BaseFragment) HomeParticularGameClassifyFragment.this).e, HomeParticularGameClassifyFragment.this.t.getData().getMatrix().get(i).getTitle(), HomeParticularGameClassifyFragment.this.t.getData().getMatrix().get(i).getType());
                    return;
                case 1:
                    new Bundle();
                    com.rtk.app.tool.c.b((Activity) ((BaseFragment) HomeParticularGameClassifyFragment.this).e, OpenServiceActivity.class, null);
                    return;
                case 2:
                    com.rtk.app.tool.c.b((Activity) ((BaseFragment) HomeParticularGameClassifyFragment.this).e, LiBaoListActivity.class, null);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements SwipeRefreshLayout.OnRefreshListener {
        b() {
        }

        public void onRefresh() {
            HomeParticularGameClassifyFragment.this.z();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("HomeParticularGameClassifyFragment", "mark  " + str);
        this.homeParticularGameClassifySwipeRefreshLayout.setRefreshing(false);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.q.clear();
        this.r.clear();
        RecommendModuleAndClassifyBean recommendModuleAndClassifyBean = (RecommendModuleAndClassifyBean) create.fromJson(str, RecommendModuleAndClassifyBean.class);
        this.t = recommendModuleAndClassifyBean;
        if (recommendModuleAndClassifyBean.getCode() != 0) {
            return;
        }
        if (!str.equals(this.u)) {
            com.rtk.app.tool.v.h(this.e, getClass().getName(), str);
        }
        this.q.addAll(this.t.getData().getMatrix());
        this.r.addAll(this.t.getData().getCategory());
        this.p.notifyDataSetChanged();
        this.s.notifyDataSetChanged();
        this.u = str;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("game/gamecategory" + y.u(this.e) + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])))));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homeParticularGameClassifyGridView.setOnItemClickListener(new a());
        this.homeParticularGameClassifySwipeRefreshLayout.setOnRefreshListener(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.homeParticularGameClassifySwipeRefreshLayout.setRefreshing(false);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = new ArrayList<>();
        GameMutualityGridViewAdapter gameMutualityGridViewAdapter = new GameMutualityGridViewAdapter(this.q, this.e);
        this.p = gameMutualityGridViewAdapter;
        this.homeParticularGameClassifyGridView.setAdapter((ListAdapter) gameMutualityGridViewAdapter);
        this.r = new ArrayList<>();
        GameMutualityListViewAdapter gameMutualityListViewAdapter = new GameMutualityListViewAdapter(this.r, this.e);
        this.s = gameMutualityListViewAdapter;
        this.homeParticularGameClassifyListview.setAdapter((ListAdapter) gameMutualityListViewAdapter);
        try {
            String d = com.rtk.app.tool.v.d(this.e, getClass().getName());
            this.u = d;
            d(d, 1);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home_particular_game_classify_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }
}
