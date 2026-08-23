package com.rtk.app.main.OtherImfomationPack;

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
import com.rtk.app.adapter.CommunityFragmentPostListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCollectFragmentForPost extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    Unbinder o;
    private View p;
    private CommunityPostBean q;
    private CommunityFragmentPostListAdapter r;
    private List<CommunityPostBean.DataBean> s;
    private int t = 1;
    private String u;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        this.t = 1;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(true);
        C();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.a("OtherCollectFragmentForPost", "我的帖子收藏" + str, 2, new Level[0]);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        if (i != 1) {
            return;
        }
        this.q = (CommunityPostBean) create.fromJson(str, CommunityPostBean.class);
        if (this.t == 1) {
            this.s.clear();
        }
        this.s.addAll(this.q.getData());
        this.t++;
        if (this.q.getData().size() < 10) {
            this.r.j(true);
            this.r.k(false, null);
            this.fragmentForRecyclerviewLayoutListView.setIsEnd(true);
        } else {
            this.r.j(false);
            this.r.k(false, null);
        }
        this.r.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void z() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/collectPosts");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(this.u);
        sb.append("&page=");
        sb.append(this.t);
        sb.append("&limit=10&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + this.u))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        c0.u("OtherCollectFragmentForPost", "帖子收藏   " + y.d + sb2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.OtherImfomationPack.c
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                OtherCollectFragmentForPost.this.z();
            }
        });
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.OtherImfomationPack.f
            public final void onRefresh() {
                OtherCollectFragmentForPost.this.B();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.t == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.e
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherCollectFragmentForPost.this.v(strArr);
                }
            });
        }
        this.r.j(true);
        this.r.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.d
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                OtherCollectFragmentForPost.this.x(strArr);
            }
        });
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.s = new ArrayList();
        this.u = getArguments().getString("uid");
        this.fragmentForRecyclerviewLayoutListView.setLayoutManager(new LinearLayoutManager(this.e));
        this.r = new CommunityFragmentPostListAdapter(this.s, this.e);
        this.fragmentForRecyclerviewLayoutListView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        this.fragmentForRecyclerviewLayoutListView.setAdapter(this.r);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.p;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_recyclerview_layout, viewGroup, false);
            this.p = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.p;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }
}
