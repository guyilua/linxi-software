package com.rtk.app.main.family;

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
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpFragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    LinearLayout fragmentForRecyclerviewParentLayout;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    Unbinder o;
    private int p = 1;
    private UpApkListBean q;
    private List<UpApkListBean.DataBean> r;
    private FamilyUpFragmentUpListAdapter s;
    private String t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            FamilyUpFragment.this.w();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements YcRecyclerView.b {
        b() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            FamilyUpFragment.this.A();
        }
    }

    public FamilyUpFragment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(true);
        A();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("FamilyUpFragment", "我的帖子关注列表  " + str);
        if (i != 1) {
            return;
        }
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        this.q = upApkListBean;
        if (upApkListBean == null) {
            return;
        }
        try {
            ((MainActivity) this.e).z();
        } catch (Exception unused) {
        }
        if (this.p == 1) {
            this.r.clear();
            if (!com.rtk.app.tool.y.x(this.e)) {
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
    protected void A() {
        if (com.rtk.app.tool.y.x(this.e) && !TextUtils.isEmpty(this.t)) {
            HashMap<String, String> k = com.rtk.app.tool.y.k();
            k.put("family_id", this.t);
            k.put(com.rtk.app.tool.y.z("uid"), com.rtk.app.tool.y.K());
            k.put(com.rtk.app.tool.y.z("token"), com.rtk.app.tool.y.H());
            k.put("$*$$*$page", this.p + "");
            k.put("key", com.rtk.app.tool.t.L(k));
            String w = com.rtk.app.tool.y.w("family/up/list", k);
            com.rtk.app.tool.c0.r("FamilyUpFragment", "url=" + w);
            com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new a());
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new b());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("FamilyUpFragment", "我的帖子关注  请求错误" + str);
        if (i2 != 1) {
            return;
        }
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.s.j(false);
        this.s.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.c0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                FamilyUpFragment.this.v(strArr);
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
        FamilyUpFragmentUpListAdapter familyUpFragmentUpListAdapter = new FamilyUpFragmentUpListAdapter(this.r, this.e);
        this.s = familyUpFragmentUpListAdapter;
        this.fragmentForRecyclerviewLayoutListView.setAdapter(familyUpFragmentUpListAdapter);
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

    public void w() {
        this.p = 1;
        A();
    }

    public FamilyUpFragment(String str) {
        this.t = str;
    }
}
