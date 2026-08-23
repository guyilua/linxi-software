package com.rtk.app.main.HomeCommunityPack;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.rtk.app.adapter.PostAuditListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.PostAuditListBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostAuditFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    LinearLayout fragmentForRecyclerviewParentLayout;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    Unbinder o;
    private String p;
    private int s;
    private PostAuditListAdapter u;
    private int q = 1;
    private String r = "";
    private List<PostAuditListBean.DataBean> t = new ArrayList();
    private boolean v = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        com.rtk.app.tool.c0.u("PostAuditFragment", "下一页");
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(true);
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
        com.rtk.app.tool.c0.u("PostAuditFragment", "帖子审核str" + str);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        PostAuditListBean postAuditListBean = (PostAuditListBean) this.f.fromJson(str, PostAuditListBean.class);
        if (this.q == 1) {
            this.t.clear();
        }
        this.t.addAll(postAuditListBean.getData());
        this.q++;
        if (postAuditListBean.getData().size() < 10) {
            this.u.j(true);
            this.u.k(false, null);
            this.fragmentForRecyclerviewLayoutListView.setIsEnd(true);
        } else {
            this.u.j(false);
            this.u.k(false, null);
        }
        this.u.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
        String w;
        if (TextUtils.isEmpty(this.p)) {
            HashMap<String, String> k = com.rtk.app.tool.y.k();
            k.put("key", com.rtk.app.tool.t.L(k));
            k.put("uid", com.rtk.app.tool.y.K());
            k.put("token", com.rtk.app.tool.y.H());
            k.put("mid", this.r);
            k.put("state", this.s + "");
            k.put("page", this.q + "");
            k.put("limit", PointType.SIGMOB_APP);
            if (this.v) {
                com.rtk.app.tool.c0.u("PostAuditFragment", "isAuditInfoForFamily true");
                k.put(com.umeng.analytics.pro.d.y, "1");
            }
            w = com.rtk.app.tool.y.w("bbs/examine/list", k);
        } else {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("family_id", this.p);
            l.put("mid", this.r);
            l.put("state3", this.s + "");
            l.put(com.rtk.app.tool.y.z("page"), this.q + "");
            l.put(com.rtk.app.tool.y.z("limit"), PointType.SIGMOB_APP);
            l.put("key", com.rtk.app.tool.t.L(l));
            w = com.rtk.app.tool.y.w("family/bbs/check/list", l);
        }
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
        com.rtk.app.tool.c0.u("PostAuditFragment", "帖子审核列表状态码  " + this.s + "   " + com.rtk.app.tool.y.e + w);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.HomeCommunityPack.g
            public final void onRefresh() {
                PostAuditFragment.this.z();
            }
        });
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.HomeCommunityPack.e
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                PostAuditFragment.this.B();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.f
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostAuditFragment.this.v(strArr);
                }
            });
        }
        this.u.j(true);
        this.u.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.d
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostAuditFragment.this.x(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        Bundle arguments = getArguments();
        this.p = arguments.getString("family_id");
        this.v = arguments.getBoolean("isAuditInfoForFamily", false);
        this.s = arguments.getInt("state");
        this.r = arguments.getString("mid", "0");
        com.rtk.app.tool.c0.u("PostAuditFragment", "帖子审核列表mid" + this.r);
        this.fragmentForRecyclerviewLayoutListView.setLayoutManager(new LinearLayoutManager(this.e));
        this.fragmentForRecyclerviewLayoutListView.addItemDecoration(new DividerItemDecoration(this.e, 1));
        PostAuditListAdapter postAuditListAdapter = new PostAuditListAdapter(this.e, this.t, this.p);
        this.u = postAuditListAdapter;
        this.fragmentForRecyclerviewLayoutListView.setAdapter(postAuditListAdapter);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("PostAuditFragment", "审核列表requestCode" + i + " resultCode  " + i2);
        if (i2 == 1024 && intent.getExtras() != null) {
            boolean z = intent.getExtras().getBoolean("isFamily");
            int i3 = intent.getExtras().getInt("state");
            String string = intent.getExtras().getString("pid");
            int i4 = 0;
            if (z) {
                while (i4 < this.t.size()) {
                    if (this.t.get(i4).getId() == Integer.parseInt(string)) {
                        this.t.get(i4).setState3(i3);
                        this.u.notifyDataSetChanged();
                        return;
                    }
                    i4++;
                }
                return;
            }
            while (i4 < this.t.size()) {
                if (this.t.get(i4).getId() == Integer.parseInt(string)) {
                    this.t.get(i4).setState(i3);
                    this.u.notifyDataSetChanged();
                    return;
                }
                i4++;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_recyclerview_layout, (ViewGroup) null);
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
