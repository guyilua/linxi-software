package com.rtk.app.main.HomeCommunityPack;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.CommunityFragmentPostListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPostFragment extends BaseFragment implements h.j, AdapterView.OnItemClickListener {
    Unbinder o;
    private int p = 1;
    private String q = "";
    private List<CommunityPostBean.DataBean> r;
    private CommunityFragmentPostListAdapter s;

    @BindView
    View searchHistoryView;

    @BindView
    TextView searchPostFragmentForModule;

    @BindView
    LinearLayout searchPostFragmentParent;

    @BindView
    YcRecyclerView searchPostFragmentRecyclerView;

    @BindView
    SwipeRefreshLayout searchPostFragmentSwipeRefreshLayout;
    private CommunityPostBean t;
    private SearchHistoryViewHolder u;
    private String v;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C() {
        u(1);
    }

    private void u(int i) {
        String str = "";
        if (i == 1) {
            this.q = this.q.replaceAll("&", "");
            if (com.rtk.app.tool.y.x(this.e)) {
                str = "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H();
            }
            str = "members/bbsSearch" + com.rtk.app.tool.y.u(this.e) + "&keyword=" + this.q + str + "&page=" + this.p + "&limit=10" + com.rtk.app.tool.y.J(this.e) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, new String[0])));
        }
        com.rtk.app.tool.c0.u("SearchPostFragment", "搜索    " + com.rtk.app.tool.y.d + str);
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        this.searchPostFragmentRecyclerView.setRefreshing(true);
        u(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        u(1);
    }

    public void D(String str) {
        if (!this.f149c || com.rtk.app.tool.c0.q(((SearchPostOrUserActivity) this.e).v) || ((SearchPostOrUserActivity) this.e).v.equals(this.q)) {
            return;
        }
        String d = com.rtk.app.tool.v.d(getContext(), com.rtk.app.tool.v.e);
        String str2 = "";
        String replaceAll = str.replaceAll("&", "");
        List<String> d2 = com.rtk.app.tool.c0.d(d, "\\|");
        if (d2.contains(replaceAll)) {
            d2.remove(replaceAll);
            d2.add(replaceAll);
            for (int i = 0; i < d2.size(); i++) {
                str2 = i != d2.size() - 1 ? str2 + d2.get(i) + "|" : str2 + d2.get(i);
            }
            com.rtk.app.tool.v.h(this.e, com.rtk.app.tool.v.e, str2);
        }
        this.searchPostFragmentForModule.setVisibility(com.rtk.app.tool.c0.q(this.v) ? 8 : 0);
        this.q = replaceAll;
        F(false);
        LinearLayout linearLayout = this.searchPostFragmentParent;
        r(linearLayout, linearLayout);
        this.p = 1;
        u(1);
    }

    public void E(String str) {
        this.v = str;
    }

    public void F(boolean z) {
        View view = this.searchHistoryView;
        if (view != null && this.searchPostFragmentRecyclerView != null && this.u != null) {
            view.setVisibility(z ? 0 : 8);
            this.searchPostFragmentRecyclerView.setVisibility(z ? 8 : 0);
            this.u.i();
            return;
        }
        com.rtk.app.tool.c0.s("SearchPostFragment", "setSearchHistoryViewVisible null point");
    }

    public void G(String str) {
        this.q = str;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        if (i != 1) {
            return;
        }
        this.searchPostFragmentSwipeRefreshLayout.setRefreshing(false);
        com.rtk.app.tool.c0.u("SearchPostFragment", "搜索结果" + str);
        this.searchPostFragmentRecyclerView.setRefreshing(false);
        this.t = (CommunityPostBean) this.f.fromJson(str, CommunityPostBean.class);
        if (this.p == 1) {
            this.r.clear();
        }
        this.r.addAll(this.t.getData());
        this.p++;
        if (this.t.getData().size() < 10) {
            this.s.j(true);
            this.s.k(false, null);
            this.searchPostFragmentRecyclerView.setIsEnd(true);
        } else {
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void B() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.searchPostFragmentForModule.setOnClickListener(this);
        this.searchPostFragmentSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.HomeCommunityPack.j0
            public final void onRefresh() {
                SearchPostFragment.this.A();
            }
        });
        this.searchPostFragmentRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.HomeCommunityPack.i0
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                SearchPostFragment.this.C();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("SearchPostFragment", "加载失败");
        this.searchPostFragmentSwipeRefreshLayout.setRefreshing(false);
        this.searchPostFragmentRecyclerView.setRefreshing(false);
        if (i2 != 1) {
            return;
        }
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.h0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    SearchPostFragment.this.w(strArr);
                }
            });
        }
        this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.k0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                SearchPostFragment.this.y(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.u = new SearchHistoryViewHolder(this.e, this.searchHistoryView, com.rtk.app.tool.v.e, this);
        this.r = new ArrayList();
        this.searchPostFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.s = new CommunityFragmentPostListAdapter(this.r, this.e);
        this.searchPostFragmentRecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        this.searchPostFragmentRecyclerView.setAdapter(this.s);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300115) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("mid", this.v);
        bundle.putString("searchStr", this.q);
        com.rtk.app.tool.c.b((Activity) this.e, PostSearchForModuleActivity.class, bundle);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.search_post_fragment_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
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

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((SearchPostOrUserActivity) this.e).P(((TextView) view).getText().toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.rtk.app.tool.c0.u("SearchPostFragment", "对用户可见" + z);
        Object obj = this.e;
        if (obj == null || com.rtk.app.tool.c0.q(((SearchPostOrUserActivity) obj).v)) {
            return;
        }
        D(((SearchPostOrUserActivity) this.e).v);
    }
}
