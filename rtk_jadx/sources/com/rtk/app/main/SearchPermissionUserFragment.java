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
import com.rtk.app.adapter.MyAttentionAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchPermissionUserFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;

    @BindView
    LinearLayout fragementForListviewParentLayout;
    Unbinder o;
    private int p = 1;
    private String q = "";
    private List<MyAttentionBean.DataBean> r;
    private MyAttentionAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            SearchPermissionUserFragment.this.p = 1;
            SearchPermissionUserFragment.this.y(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            SearchPermissionUserFragment.this.y(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.B0(((BaseFragment) SearchPermissionUserFragment.this).e, ((MyAttentionBean.DataBean) SearchPermissionUserFragment.this.r.get(i - 1)).getFans());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i) {
        String str = "";
        if (i == 1) {
            this.q = this.q.replaceAll("&", "");
            StringBuilder sb = new StringBuilder();
            sb.append("members/userSearch");
            sb.append(com.rtk.app.tool.y.u(this.e));
            sb.append("&uname=");
            sb.append(this.q);
            sb.append("&page=");
            sb.append(this.p);
            sb.append("&limit=");
            sb.append(this.fragementForListviewListview.getPageSize());
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uname=" + this.q))));
            str = sb.toString();
        }
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
        com.rtk.app.tool.c0.u("SearchPermissionUserFragment", "搜索用户  " + com.rtk.app.tool.y.d + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(String[] strArr) {
        y(1);
    }

    public void B(String str) {
        this.q = str;
        com.rtk.app.tool.c0.u("SearchPermissionUserFragment", "searchStr" + str);
        LinearLayout linearLayout = this.fragementForListviewParentLayout;
        r(linearLayout, linearLayout);
        this.p = 1;
        y(1);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.fragementForListviewListview.k();
        com.rtk.app.tool.c0.u("SearchPermissionUserFragment", "搜索用户" + str);
        if (i != 1) {
            return;
        }
        q();
        MyAttentionBean myAttentionBean = (MyAttentionBean) this.f.fromJson(str, MyAttentionBean.class);
        if (this.p == 1) {
            this.r.clear();
        }
        this.r.addAll(myAttentionBean.getData());
        this.s.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(myAttentionBean.getData().size());
        this.p++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void A() {
        if (this.f149c) {
            B(this.q);
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnRefreshListener(new a());
        this.fragementForListviewListview.setOnLoadListener(new b());
        this.fragementForListviewListview.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.g0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    SearchPermissionUserFragment.this.A(strArr);
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
        this.q = getArguments().getString("searchStr", "");
        this.r = new ArrayList();
        this.fragementForListviewListview.setPageSize(20);
        this.s = new MyAttentionAdapter(this.e, this.r);
        this.fragementForListviewListview.setResultSize(0);
        this.fragementForListviewListview.setAdapter((ListAdapter) this.s);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        MyAttentionAdapter myAttentionAdapter = this.s;
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
            this.o = ButterKnife.b(this, inflate);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroy() {
        super.onDestroy();
        this.o.a();
    }
}
