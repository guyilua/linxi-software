package com.rtk.app.main.HomeCommunityPack;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView communityFragmentRecycler;
    View o;
    Unbinder p;
    private Bundle q;
    private Context r;
    private String t;
    private String u;
    private String w;
    private CommunityPostBean x;
    private List<CommunityPostBean.DataBean> y;
    private CommunityFragmentPostListAdapter z;
    private int s = 1;
    private String v = "release";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements YcRecyclerView.b {
        a() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            CommunityFragment.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        this.communityFragmentRecycler.setRefreshing(true);
        z();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("CommunityFragment", "社区列表  " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.communityFragmentRecycler.setRefreshing(false);
        this.x = (CommunityPostBean) create.fromJson(str, CommunityPostBean.class);
        if (this.s == 1) {
            this.y.clear();
        }
        this.y.addAll(this.x.getData());
        this.s++;
        if (this.x.getData().size() < 10) {
            this.z.j(true);
            this.z.k(false, null);
            this.communityFragmentRecycler.setIsEnd(true);
        } else {
            this.z.j(false);
            this.z.k(false, null);
        }
        this.z.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
        if (TextUtils.isEmpty(this.w)) {
            String str = "members/postsList" + com.rtk.app.tool.y.u(this.r) + "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H() + "&mid=" + this.t + "&type=" + this.v + "&tags=" + this.u + "&page=" + this.s + "&limit=10&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, new String[0])));
            com.rtk.app.tool.o.h.l(this.r, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(str));
            com.rtk.app.tool.c0.u("CommunityFragment", "社区请求的类型" + com.rtk.app.tool.y.d + str);
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.w);
        l.put("mid", this.t);
        l.put(com.rtk.app.tool.y.z("tag"), this.u);
        l.put(com.rtk.app.tool.y.z(com.umeng.analytics.pro.d.y), this.v);
        l.put(com.rtk.app.tool.y.z("page"), this.s + "");
        l.put(com.rtk.app.tool.y.z("limit"), PointType.SIGMOB_APP);
        l.put("key", com.rtk.app.tool.t.L(l));
        String w = com.rtk.app.tool.y.w("family/bbs/list/posts", l);
        com.rtk.app.tool.c0.u("CommunityFragment", "  社区地址    " + com.rtk.app.tool.y.e + w);
        com.rtk.app.tool.o.h.l(this.r, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.communityFragmentRecycler.setRecyclerViewOnTheDownListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.communityFragmentRecycler.setRefreshing(false);
        this.communityFragmentRecycler.setIsEnd(true);
        CommunityFragmentPostListAdapter communityFragmentPostListAdapter = this.z;
        if (communityFragmentPostListAdapter != null) {
            communityFragmentPostListAdapter.j(true);
            this.z.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.a
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    CommunityFragment.this.v(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.t = this.q.getString("mid");
        this.u = this.q.getString("tags");
        this.v = this.q.getString(com.umeng.analytics.pro.d.y);
        this.w = this.q.getString("family_id");
        this.y = new ArrayList();
        this.communityFragmentRecycler.setLayoutManager(new LinearLayoutManager(this.r));
        CommunityFragmentPostListAdapter communityFragmentPostListAdapter = new CommunityFragmentPostListAdapter(this.y, this.r);
        this.z = communityFragmentPostListAdapter;
        communityFragmentPostListAdapter.l(this.w);
        this.communityFragmentRecycler.addItemDecoration(new DividerItemDecoration(this.r, 1));
        this.communityFragmentRecycler.setAdapter(this.z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = getArguments();
        this.r = getActivity();
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.community_fragment_layout, viewGroup, false);
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

    public void w() {
        this.s = 1;
        z();
    }

    public void x(String str) {
        if (this.v.equals(str)) {
            return;
        }
        this.v = str;
        this.s = 1;
        if (this.d) {
            z();
        }
    }
}
