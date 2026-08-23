package com.rtk.app.main.MainActivityPack;

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
import com.qq.e.comm.constants.ErrorCode;
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

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostAttentionFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    LinearLayout fragmentForRecyclerviewParentLayout;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    Unbinder o;
    private int p = 1;
    private CommunityPostBean q;
    private List<CommunityPostBean.DataBean> r;
    private CommunityFragmentPostListAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            MyPostAttentionFragment.this.p = 1;
            MyPostAttentionFragment.this.z();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements YcRecyclerView.b {
        b() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            MyPostAttentionFragment.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(true);
        z();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        c0.u("MyPostAttentionFragment", "我的帖子关注列表  " + str);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.q = (CommunityPostBean) this.f.fromJson(str, CommunityPostBean.class);
        if (this.p == 1) {
            this.r.clear();
            if (!y.x(this.e)) {
                g(ErrorCode.NETWORK_TIMEOUT, "请先登录", 1);
                return;
            }
        }
        q();
        this.r.addAll(this.q.getData());
        this.p++;
        if (this.q.getData().size() < 10) {
            this.s.j(true);
            this.s.k(false, null);
            this.fragmentForRecyclerviewLayoutListView.setIsEnd(true);
        } else {
            this.s.j(false);
            this.s.k(false, null);
        }
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
        if (!y.x(this.e)) {
            com.rtk.app.tool.f.a(this.e, "请先登录", f.a.f);
            com.rtk.app.tool.t.w0(this.e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("user/my-moments/bbs");
        sb.append(y.u(this.e));
        sb.append("&page=");
        sb.append(this.p);
        sb.append("&limit=10&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + y.K(), "token=" + y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(sb2));
        c0.u("MyPostAttentionFragment", "我的关注所发的列表    " + y.d + sb2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new a());
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("MyPostAttentionFragment", "我的帖子关注  请求错误" + str);
        if (i2 != 1) {
            return;
        }
        if (i == 3002) {
            com.rtk.app.tool.t.w0(this.e);
        }
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.s.j(false);
        this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.w
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                MyPostAttentionFragment.this.w(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.r = new ArrayList();
        this.fragmentForRecyclerviewLayoutListView.setLayoutManager(new LinearLayoutManager(this.e));
        this.fragmentForRecyclerviewLayoutListView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        CommunityFragmentPostListAdapter communityFragmentPostListAdapter = new CommunityFragmentPostListAdapter(this.r, this.e);
        this.s = communityFragmentPostListAdapter;
        this.fragmentForRecyclerviewLayoutListView.setAdapter(communityFragmentPostListAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_recyclerview_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
            LinearLayout linearLayout = this.fragmentForRecyclerviewParentLayout;
            r(linearLayout, linearLayout);
        } else {
            this.o = ButterKnife.b(this, view);
        }
        this.o = ButterKnife.b(this, this.a);
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }
}
