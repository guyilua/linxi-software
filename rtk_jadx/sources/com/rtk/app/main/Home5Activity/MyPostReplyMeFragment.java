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
import com.rtk.app.adapter.FragementReplyMeReplyAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MypostReplyMeBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostReplyMeFragment extends BaseFragment implements h.j {

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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        this.fragmentMyPostCommentRecyclerView.setRefreshing(true);
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.q = 1;
        z();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.fragmentMyPostCommentSwipeRefresh.setRefreshing(false);
        this.fragmentMyPostCommentRecyclerView.setRefreshing(false);
        com.rtk.app.tool.c0.a("MyPostReplyMeFragment", "回复我的" + str, 10, new Level[0]);
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
            this.t.k(false, null);
        } else {
            this.fragmentMyPostCommentRecyclerView.setIsEnd(false);
            this.t.j(false);
            this.t.k(false, null);
        }
        this.t.notifyDataSetChanged();
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void B() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/postsCommentList");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&model=replytome&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
        com.rtk.app.tool.c0.u("MyPostReplyMeFragment", "   帖子回复列表    " + com.rtk.app.tool.y.d + sb2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyPostCommentSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.Home5Activity.d1
            public final void onRefresh() {
                MyPostReplyMeFragment.this.z();
            }
        });
        this.fragmentMyPostCommentRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.Home5Activity.c1
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                MyPostReplyMeFragment.this.B();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.a1
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyPostReplyMeFragment.this.v(strArr);
                }
            });
        }
        this.fragmentMyPostCommentSwipeRefresh.setRefreshing(false);
        this.fragmentMyPostCommentRecyclerView.setRefreshing(false);
        this.t.j(true);
        this.t.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.b1
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                MyPostReplyMeFragment.this.x(strArr);
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
        this.fragmentMyPostCommentRecyclerView.setAdapter(fragementReplyMeReplyAdapter);
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
