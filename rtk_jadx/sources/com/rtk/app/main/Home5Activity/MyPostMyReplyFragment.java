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
import com.rtk.app.adapter.FragementMyPostReplyAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MypostMyReplyBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostMyReplyFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentMyPostReplyRecyclerView;

    @BindView
    SwipeRefreshLayout fragmentMyPostReplySwipeRefresh;
    View o;
    Unbinder p;
    private int q = 1;
    private MypostMyReplyBean r;
    private FragementMyPostReplyAdapter s;
    private List<MypostMyReplyBean.DataBean> t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            MyPostMyReplyFragment.this.q = 1;
            MyPostMyReplyFragment.this.A();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements YcRecyclerView.b {
        b() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            MyPostMyReplyFragment.this.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        this.fragmentMyPostReplyRecyclerView.setRefreshing(true);
        A();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.fragmentMyPostReplySwipeRefresh.setRefreshing(false);
        this.fragmentMyPostReplyRecyclerView.setRefreshing(false);
        com.rtk.app.tool.c0.u("MyPostMyReplyFragment", " 我的回复  " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.r = (MypostMyReplyBean) create.fromJson(str, MypostMyReplyBean.class);
        if (this.q == 1) {
            this.t.clear();
        }
        this.t.addAll(this.r.getData());
        if (this.r.getData().size() < 10) {
            this.fragmentMyPostReplyRecyclerView.setIsEnd(true);
            this.s.j(true);
            this.s.k(false, null);
        } else {
            this.fragmentMyPostReplyRecyclerView.setIsEnd(false);
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
        this.q++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void A() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/postsCommentList");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&model=myreply&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        com.rtk.app.tool.c0.u("MyPostMyReplyFragment", "   帖子回复列表    " + com.rtk.app.tool.y.d + sb2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyPostReplySwipeRefresh.setOnRefreshListener(new a());
        this.fragmentMyPostReplyRecyclerView.setRecyclerViewOnTheDownListener(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.fragmentMyPostReplySwipeRefresh.setRefreshing(false);
        this.fragmentMyPostReplyRecyclerView.setRefreshing(false);
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.z0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyPostMyReplyFragment.this.w(strArr);
                }
            });
        } else {
            this.fragmentMyPostReplyRecyclerView.setIsEnd(true);
            this.s.j(true);
            this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.y0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyPostMyReplyFragment.this.y(strArr);
                }
            });
        }
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.fragmentMyPostReplyRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        this.s = new FragementMyPostReplyAdapter(this.e, arrayList);
        this.fragmentMyPostReplyRecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        this.fragmentMyPostReplyRecyclerView.setAdapter(this.s);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_my_post_my_reply, viewGroup, false);
            this.o = inflate;
            this.p = ButterKnife.b(this, inflate);
            b();
            View view2 = this.o;
            r(view2, view2);
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
