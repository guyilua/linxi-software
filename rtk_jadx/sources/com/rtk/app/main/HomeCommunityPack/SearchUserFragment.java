package com.rtk.app.main.HomeCommunityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyAttentionAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchUserFragment extends BaseFragment implements h.j, AdapterView.OnItemClickListener {

    @BindView
    AutoListView fragementForListviewListview;

    @BindView
    LinearLayout fragementForListviewParentLayout;
    private View o;
    Unbinder p;
    private int q = 1;
    String r = "";
    private List<MyAttentionBean.DataBean> s;
    private MyAttentionAdapter t;
    private SearchHistoryViewHolder u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            SearchUserFragment.this.q = 1;
            SearchUserFragment.this.y(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            SearchUserFragment.this.y(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.B0(((BaseFragment) SearchUserFragment.this).e, ((MyAttentionBean.DataBean) SearchUserFragment.this.s.get(i - 1)).getFans());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i) {
        String str = "";
        if (i == 1) {
            this.r = this.r.replaceAll("&", "");
            StringBuilder sb = new StringBuilder();
            sb.append("members/userSearch");
            sb.append(com.rtk.app.tool.y.u(this.e));
            sb.append("&uname=");
            sb.append(this.r);
            sb.append("&page=");
            sb.append(this.q);
            sb.append("&limit=");
            sb.append(this.fragementForListviewListview.getPageSize());
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uname=" + this.r))));
            str = sb.toString();
        }
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
        com.rtk.app.tool.c0.u("SearchUserFragment", "搜索用户  " + com.rtk.app.tool.y.d + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(String[] strArr) {
        y(1);
    }

    public void B(String str) {
        if (!this.f149c || com.rtk.app.tool.c0.q(((SearchPostOrUserActivity) this.e).v) || ((SearchPostOrUserActivity) this.e).v.equals(this.r)) {
            return;
        }
        String d = com.rtk.app.tool.v.d(getContext(), com.rtk.app.tool.v.e);
        String str2 = "";
        String replaceAll = str.replaceAll("&", "");
        List<String> d2 = com.rtk.app.tool.c0.d(d, "\\|");
        if (d2.contains(replaceAll)) {
            d2.remove(replaceAll);
            d2.add(replaceAll);
            for (int i = 0; i < d2.size(); i++) {
                str2 = i != d2.size() - 1 ? str2 + d2.get(i) + "|" : str2 + d2.get(i);
            }
            com.rtk.app.tool.v.h(this.e, com.rtk.app.tool.v.e, str2);
        }
        C(false);
        this.q = 1;
        this.r = replaceAll;
        LinearLayout linearLayout = this.fragementForListviewParentLayout;
        r(linearLayout, linearLayout);
        y(1);
    }

    public void C(boolean z) {
        this.fragementForListviewParentLayout.removeAllViews();
        if (z) {
            this.fragementForListviewParentLayout.removeView(this.fragementForListviewListview);
            this.fragementForListviewParentLayout.addView(this.o);
            this.u.i();
        } else {
            this.fragementForListviewParentLayout.removeView(this.o);
            this.fragementForListviewParentLayout.addView(this.fragementForListviewListview);
        }
    }

    public void D(String str) {
        this.r = str;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.fragementForListviewListview.k();
        com.rtk.app.tool.c0.u("SearchUserFragment", "搜索用户" + str);
        if (i != 1) {
            return;
        }
        q();
        MyAttentionBean myAttentionBean = (MyAttentionBean) this.f.fromJson(str, MyAttentionBean.class);
        if (this.q == 1) {
            this.s.clear();
        }
        this.s.addAll(myAttentionBean.getData());
        this.t.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(myAttentionBean.getData().size());
        this.q++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void C() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnRefreshListener(new a());
        this.fragementForListviewListview.setOnLoadListener(new b());
        this.fragementForListviewListview.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.l0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    SearchUserFragment.this.A(strArr);
                }
            });
        }
        this.fragementForListviewListview.f();
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.s = new ArrayList();
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.search_history_layout, (ViewGroup) null);
        this.o = inflate;
        this.fragementForListviewParentLayout.addView(inflate, 0);
        this.fragementForListviewParentLayout.removeView(this.fragementForListviewListview);
        this.u = new SearchHistoryViewHolder(this.e, this.o, com.rtk.app.tool.v.e, this);
        this.fragementForListviewListview.setPageSize(20);
        this.t = new MyAttentionAdapter(this.e, this.s);
        this.fragementForListviewListview.setResultSize(0);
        this.fragementForListviewListview.setAdapter((ListAdapter) this.t);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        MyAttentionAdapter myAttentionAdapter = this.t;
        if (myAttentionAdapter != null) {
            myAttentionAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_listview_layout, (ViewGroup) null);
            this.a = inflate;
            this.p = ButterKnife.b(this, inflate);
            b();
        } else {
            this.p = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.p.a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((SearchPostOrUserActivity) this.e).P(((TextView) view).getText().toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Object obj = this.e;
        if (obj == null || com.rtk.app.tool.c0.q(((SearchPostOrUserActivity) obj).v)) {
            return;
        }
        B(((SearchPostOrUserActivity) this.e).v);
    }
}
