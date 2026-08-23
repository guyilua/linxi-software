package com.rtk.app.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPermissionUpFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;

    @BindView
    LinearLayout fragementForListviewParentLayout;
    Unbinder o;
    public int p = 1;
    protected String q;
    private List<UpApkListBean.DataBean> r;
    private UpApkListAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            SearchPermissionUpFragment.this.w();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            SearchPermissionUpFragment searchPermissionUpFragment = SearchPermissionUpFragment.this;
            searchPermissionUpFragment.p = 1;
            searchPermissionUpFragment.w();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.X0(((BaseFragment) SearchPermissionUpFragment.this).e, new ApkInfo((UpApkListBean.DataBean) SearchPermissionUpFragment.this.r.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        w();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.fragementForListviewListview.k();
        if (i != 1) {
            return;
        }
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
            return;
        }
        if (this.p == 1) {
            this.r.clear();
        }
        this.r.addAll(upApkListBean.getData());
        this.s.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(upApkListBean.getData().size());
        this.p++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void w() {
        String str;
        this.s.b();
        if (this.p == 1) {
            LinearLayout linearLayout = this.fragementForListviewParentLayout;
            r(linearLayout, linearLayout);
        }
        String K = com.rtk.app.tool.y.K();
        String H = com.rtk.app.tool.y.H();
        if (com.rtk.app.tool.c0.q(K) || com.rtk.app.tool.c0.q(H)) {
            str = "";
        } else {
            str = "&uid=" + K + "&token=" + H;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("up/search");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&model=recommonds&search_words=");
        sb.append(this.q);
        sb.append(str);
        sb.append("&page=");
        sb.append(this.p);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "model=recommonds", "search_words=" + this.q))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb2));
        com.rtk.app.tool.c0.u("SearchPermissionUpFragment", "up搜索  " + com.rtk.app.tool.y.e + sb2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnLoadListener(new a());
        this.fragementForListviewListview.setOnRefreshListener(new b());
        this.fragementForListviewListview.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.f0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    SearchPermissionUpFragment.this.x(strArr);
                }
            });
        }
        com.rtk.app.tool.c0.u("SearchPermissionUpFragment", "请求失败   UP列表  " + str);
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        this.fragementForListviewListview.f();
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.p = 1;
        this.q = getArguments().getString("searchStr");
        this.r = new ArrayList();
        UpApkListAdapter upApkListAdapter = new UpApkListAdapter(this.e, this.r);
        this.s = upApkListAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) upApkListAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        UpApkListAdapter upApkListAdapter = this.s;
        if (upApkListAdapter != null) {
            upApkListAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.fragement_for_listview_layout, (ViewGroup) null);
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

    public void y(String str) {
        this.q = str;
        this.p = 1;
        w();
    }
}
