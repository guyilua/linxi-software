package com.rtk.app.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class SearchPermissionPostFragment extends BaseFragment implements h.j {
    Unbinder o;
    private int p = 1;
    private String q = "";
    private List<CommunityPostBean.DataBean> r;
    private CommunityFragmentPostListAdapter s;

    @BindView
    LinearLayout searchHasPermissionPostParent;

    @BindView
    YcRecyclerView searchHasPermissionPostRecyclerView;

    @BindView
    SwipeRefreshLayout searchHasPermissionPostSwipeRefreshLayout;
    private CommunityPostBean t;

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
        com.rtk.app.tool.c0.u("SearchPermissionPostFragment", "搜索    " + com.rtk.app.tool.y.d + str);
        com.rtk.app.tool.o.h.l(MyApplication.b(), this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        this.searchHasPermissionPostRecyclerView.setRefreshing(true);
        u(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        this.p = 1;
        u(1);
    }

    public void D(String str) {
        this.q = str;
        com.rtk.app.tool.c0.u("SearchPermissionPostFragment", "searchStr" + str);
        LinearLayout linearLayout = this.searchHasPermissionPostParent;
        r(linearLayout, linearLayout);
        this.p = 1;
        u(1);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        if (i != 1) {
            return;
        }
        this.searchHasPermissionPostSwipeRefreshLayout.setRefreshing(false);
        com.rtk.app.tool.c0.u("SearchPermissionPostFragment", "搜索结果" + str);
        this.searchHasPermissionPostRecyclerView.setRefreshing(false);
        this.t = (CommunityPostBean) this.f.fromJson(str, CommunityPostBean.class);
        if (this.p == 1) {
            this.r.clear();
        }
        this.r.addAll(this.t.getData());
        this.p++;
        if (this.t.getData().size() < 10) {
            this.s.j(true);
            this.s.k(false, null);
            this.searchHasPermissionPostRecyclerView.setIsEnd(true);
        } else {
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
        if (this.f149c) {
            D(this.q);
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.searchHasPermissionPostSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.e0
            public final void onRefresh() {
                SearchPermissionPostFragment.this.A();
            }
        });
        this.searchHasPermissionPostRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.d0
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                SearchPermissionPostFragment.this.C();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("SearchPermissionPostFragment", "加载失败");
        this.searchHasPermissionPostSwipeRefreshLayout.setRefreshing(false);
        this.searchHasPermissionPostRecyclerView.setRefreshing(false);
        if (i2 != 1) {
            return;
        }
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.c0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    SearchPermissionPostFragment.this.w(strArr);
                }
            });
        }
        this.s.j(true);
        this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.b0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                SearchPermissionPostFragment.this.y(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = getArguments().getString("searchStr", "");
        this.r = new ArrayList();
        this.searchHasPermissionPostRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.s = new CommunityFragmentPostListAdapter(this.r, this.e);
        this.searchHasPermissionPostRecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        this.searchHasPermissionPostRecyclerView.setAdapter(this.s);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.search_has_permission_post_fragment_layout, (ViewGroup) null);
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
}
