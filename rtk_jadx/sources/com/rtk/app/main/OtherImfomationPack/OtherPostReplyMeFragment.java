package com.rtk.app.main.OtherImfomationPack;

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
import com.rtk.app.adapter.FragementReplyMeReplyAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MypostReplyMeBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherPostReplyMeFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentMyPostCommentRecyclerView;

    @BindView
    SwipeRefreshLayout fragmentMyPostCommentSwipeRefresh;
    View o;
    Unbinder p;
    private int q = 1;
    private MypostReplyMeBean r;
    private List<MypostReplyMeBean.DataBean> s;
    private FragementReplyMeReplyAdapter t;
    private String u;
    private String v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            OtherPostReplyMeFragment.this.q = 1;
            OtherPostReplyMeFragment.this.A();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements YcRecyclerView.b {
        b() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            OtherPostReplyMeFragment.this.A();
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
        this.fragmentMyPostCommentRecyclerView.setRefreshing(true);
        A();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.fragmentMyPostCommentSwipeRefresh.setRefreshing(false);
        this.fragmentMyPostCommentRecyclerView.setRefreshing(false);
        c0.u("OtherPostReplyMeFragment", " 回复他的   " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.r = (MypostReplyMeBean) create.fromJson(str, MypostReplyMeBean.class);
        if (this.q == 1) {
            this.s.clear();
        }
        this.s.addAll(this.r.getData());
        if (this.r.getData().size() < 10) {
            this.fragmentMyPostCommentRecyclerView.setIsEnd(true);
            this.t.j(true);
        } else {
            this.fragmentMyPostCommentRecyclerView.setIsEnd(false);
            this.t.j(false);
        }
        this.t.k(false, null);
        this.t.notifyDataSetChanged();
        this.q++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void A() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/hisPostsCommentList");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(this.u);
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&model=replytome&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + this.u))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        c0.u("OtherPostReplyMeFragment", "   帖子回复列表    " + y.d + sb2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyPostCommentSwipeRefresh.setOnRefreshListener(new a());
        this.fragmentMyPostCommentRecyclerView.setRecyclerViewOnTheDownListener(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.fragmentMyPostCommentSwipeRefresh.setRefreshing(false);
        this.fragmentMyPostCommentRecyclerView.setRefreshing(false);
        this.t.j(true);
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.r
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherPostReplyMeFragment.this.w(strArr);
                }
            });
        }
        this.t.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.s
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                OtherPostReplyMeFragment.this.y(strArr);
            }
        });
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.fragmentMyPostCommentRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.s = new ArrayList();
        this.fragmentMyPostCommentRecyclerView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        FragementReplyMeReplyAdapter fragementReplyMeReplyAdapter = new FragementReplyMeReplyAdapter(this.e, this.s);
        this.t = fragementReplyMeReplyAdapter;
        fragementReplyMeReplyAdapter.m(this.v);
        this.fragmentMyPostCommentRecyclerView.setAdapter(this.t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach(Context context) {
        super.onAttach(context);
        OtherPostReplyActivity otherPostReplyActivity = (OtherPostReplyActivity) context;
        this.u = otherPostReplyActivity.M();
        this.v = otherPostReplyActivity.L();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_my_post_my_comment, viewGroup, false);
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
