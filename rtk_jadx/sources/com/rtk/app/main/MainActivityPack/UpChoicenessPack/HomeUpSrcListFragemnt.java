package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
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
import com.rtk.app.main.dialogPack.DialogScreenForClassifyUpApk;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpSrcListFragemnt extends BaseFragment implements h.j, s {
    Unbinder o;
    private String q;
    private String r;
    private String s;
    private DialogScreenForClassifyUpApk u;

    @BindView
    AutoListView upApkListFragmentListview;

    @BindView
    TextView upApkListFragmentScreen;

    @BindView
    TextView upApkListFragmentSearch;
    private UpApkListAdapter v;
    private String w;
    private String x;
    private int p = 1;
    private List<UpApkListBean.DataBean> t = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            HomeUpSrcListFragemnt.this.C();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            HomeUpSrcListFragemnt.this.p = 1;
            HomeUpSrcListFragemnt.this.C();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            t.X0(((BaseFragment) HomeUpSrcListFragemnt.this).e, new ApkInfo((UpApkListBean.DataBean) HomeUpSrcListFragemnt.this.t.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        C();
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        this.w = strArr[0];
        this.x = strArr[1];
        this.p = 1;
        c0.u("HomeUpSrcListFragemnt", "size  " + this.w + "language  " + this.x);
        C();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        AutoListView autoListView = this.upApkListFragmentListview;
        if (autoListView == null) {
            return;
        }
        autoListView.k();
        q();
        if (i != 1) {
            return;
        }
        c0.u("HomeUpSrcListFragemnt", "   up资源列表  " + str);
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
            return;
        }
        if (this.p == 1) {
            this.t.clear();
        }
        this.t.addAll(upApkListBean.getData());
        this.v.notifyDataSetChanged();
        this.upApkListFragmentListview.setResultSize(upApkListBean.getData().size());
        this.p++;
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void C() {
        String str;
        String K = y.K();
        String H = y.H();
        if (c0.q(K) || c0.q(H)) {
            str = "";
        } else {
            str = "&uid=" + K + "&token=" + H;
        }
        String str2 = "up/list" + y.u(this.e) + "&type=" + this.q + "&model=" + this.s + "&sourceSize=" + this.w + "&sourceLang=" + this.x + str + "&tags=" + this.r + "&page=" + this.p + "&key=" + t.c0(c0.e(y.v(this.e, new String[0])));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(str2));
        c0.u("HomeUpSrcListFragemnt", "筛选地址   " + y.e + str2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upApkListFragmentListview.setOnLoadListener(new a());
        this.upApkListFragmentListview.setOnRefreshListener(new b());
        this.upApkListFragmentListview.setOnItemClickListener(new c());
        this.upApkListFragmentSearch.setOnClickListener(this);
        this.upApkListFragmentScreen.setOnClickListener(this);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.s("HomeUpSrcListFragemnt", i + " error");
        if (i2 != 1) {
            return;
        }
        this.upApkListFragmentListview.f();
        if (this.p == 1) {
            t(str, new s() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.h
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeUpSrcListFragemnt.this.y(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        Bundle arguments = getArguments();
        this.q = arguments.getString(com.umeng.analytics.pro.d.y);
        this.r = arguments.getString("tags");
        this.s = arguments.getString("model");
        this.u = new DialogScreenForClassifyUpApk(this.e, this);
        UpApkListAdapter upApkListAdapter = new UpApkListAdapter(this.e, this.t);
        this.v = upApkListAdapter;
        this.upApkListFragmentListview.setAdapter((ListAdapter) upApkListAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up_apk_list_fragment_screen /* 2131300674 */:
                this.u.A();
                return;
            case R.id.up_apk_list_fragment_search /* 2131300675 */:
                t.h1(this.e);
                return;
            default:
                return;
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.up_apk_list_fragment_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
            View view2 = this.a;
            r(view2, view2);
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
    }
}
