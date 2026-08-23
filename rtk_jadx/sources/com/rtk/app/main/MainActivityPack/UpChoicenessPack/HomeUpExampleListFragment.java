package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.HomeUpExampleListRecyclerViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.RankTioInformationBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpExampleListFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    LinearLayout fragmentForRecyclerviewParentLayout;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    Unbinder o;
    private HomeUpExampleListRecyclerViewAdapter p;
    private int q = 1;
    private String r = "";
    private List<UpApkListBean.DataBean> s = new ArrayList();
    private String t;
    private RankTioInformationBean u;

    private void u(int i) {
        String sb;
        if (i != 2) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.t);
            sb2.append(y.u(this.e));
            sb2.append("&tags=");
            sb2.append(this.r);
            sb2.append("&page=");
            sb2.append(this.q);
            sb2.append("&type=1&key=");
            sb2.append(t.c0(c0.e(y.v(this.e, "tags=" + this.r))));
            sb = sb2.toString();
        }
        if (c0.q(sb)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(y.e).a(sb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(true);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        this.q = 1;
        B();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            if (i != 2) {
                return;
            }
            RankTioInformationBean rankTioInformationBean = (RankTioInformationBean) this.f.fromJson(str, RankTioInformationBean.class);
            this.u = rankTioInformationBean;
            this.p.B(rankTioInformationBean);
            this.p.notifyDataSetChanged();
            c0.u("HomeUpExampleListFragment", "榜单头部信息" + str);
            return;
        }
        q();
        c0.u("HomeUpExampleListFragment", "下载榜 榜单" + str);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        if (this.q == 1) {
            this.s.clear();
            this.s.addAll(upApkListBean.getData());
            u(2);
            HomeUpExampleListRecyclerViewAdapter homeUpExampleListRecyclerViewAdapter = new HomeUpExampleListRecyclerViewAdapter(this.e, this.s);
            this.p = homeUpExampleListRecyclerViewAdapter;
            this.fragmentForRecyclerviewLayoutListView.setAdapter(homeUpExampleListRecyclerViewAdapter);
        } else {
            this.s.addAll(upApkListBean.getData());
        }
        if (upApkListBean.getData().size() < 10) {
            this.fragmentForRecyclerviewLayoutListView.setIsEnd(true);
            this.p.j(true);
        } else {
            this.fragmentForRecyclerviewLayoutListView.setIsEnd(false);
            this.p.j(false);
        }
        this.p.k(false, null);
        this.p.notifyDataSetChanged();
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void C() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.t);
        sb.append(y.u(this.e));
        sb.append("&tags=");
        sb.append(this.r);
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(t.c0(c0.e(y.v(this.e, "tags=" + this.r))));
        String sb2 = sb.toString();
        c0.u("HomeUpExampleListFragment", " 地址 " + y.d + sb2);
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(sb2));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.d
            public final void onRefresh() {
                HomeUpExampleListFragment.this.A();
            }
        });
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.a
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                HomeUpExampleListFragment.this.C();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 != 1) {
            return;
        }
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        if (this.q == 1) {
            t(str, new s() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.b
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeUpExampleListFragment.this.w(strArr);
                }
            });
        } else {
            this.p.j(true);
            this.p.k(true, new s() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.c
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeUpExampleListFragment.this.y(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        c0.u("HomeUpExampleListFragment", "出现");
        this.r = getArguments().getString("dayType");
        this.t = getArguments().getString("url");
        this.fragmentForRecyclerviewLayoutListView.setLayoutManager(new LinearLayoutManager(this.e));
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        HomeUpExampleListRecyclerViewAdapter homeUpExampleListRecyclerViewAdapter = this.p;
        if (homeUpExampleListRecyclerViewAdapter != null) {
            homeUpExampleListRecyclerViewAdapter.i();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_recyclerview_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            LinearLayout linearLayout = this.fragmentForRecyclerviewParentLayout;
            r(linearLayout, linearLayout);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }
}
