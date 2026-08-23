package com.rtk.app.main.UpModule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.dialogPack.DialogScreenForUpApk;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkListFragment extends BaseFragment implements h.j, com.rtk.app.tool.s {
    Unbinder o;
    private View p;
    private UpApkListAdapter r;

    @BindView
    AutoListView upApkListFragmentListview;

    @BindView
    TextView upApkListFragmentScreen;

    @BindView
    TextView upApkListFragmentSearch;
    private DialogScreenForUpApk v;
    private List<UpApkListBean.DataBean> q = new ArrayList();
    private int s = 1;
    private String t = "";
    private String u = "";
    private String w = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.X0(((BaseFragment) UpApkListFragment.this).e, new ApkInfo((UpApkListBean.DataBean) UpApkListFragment.this.q.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        this.s = 1;
        com.rtk.app.tool.c0.u("UpApkListFragment", "upApkListFragmentListview" + this.s);
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        y();
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        this.t = strArr[0];
        this.u = strArr[1];
        this.w = strArr[2];
        this.s = 1;
        y();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 1) {
            q();
        }
        this.upApkListFragmentListview.k();
        com.rtk.app.tool.c0.u("UpApkListFragment", "up资源 mark" + i);
        if (i != 1) {
            return;
        }
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
            return;
        }
        if (this.s == 1) {
            this.q.clear();
        }
        this.q.addAll(upApkListBean.getData());
        this.r.notifyDataSetChanged();
        this.upApkListFragmentListview.setResultSize(upApkListBean.getData().size());
        this.s++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void z() {
        String str = "up/list" + com.rtk.app.tool.y.u(this.e) + "&model=new&sourceSize=" + this.t + "&sourceLang=" + this.u + "&type=" + this.w + "&page=" + this.s + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, new String[0])));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(str));
        com.rtk.app.tool.c0.u("UpApkListFragment", "        " + com.rtk.app.tool.y.e + str);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upApkListFragmentListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.o
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpApkListFragment.this.z();
            }
        });
        this.upApkListFragmentListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.p
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpApkListFragment.this.B();
            }
        });
        this.upApkListFragmentListview.setOnItemClickListener(new a());
        this.upApkListFragmentSearch.setOnClickListener(this);
        this.upApkListFragmentScreen.setOnClickListener(this);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.upApkListFragmentListview.f();
        if (this.s == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.q
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpApkListFragment.this.x(strArr);
                }
            });
        }
        com.rtk.app.tool.c0.u("UpApkListFragment", "请求失败   UP列表  " + str + " page:" + this.s);
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.v = new DialogScreenForUpApk(this.e, this);
        getArguments().getInt("listType");
        UpApkListAdapter upApkListAdapter = new UpApkListAdapter(this.e, this.q);
        this.r = upApkListAdapter;
        this.upApkListFragmentListview.setAdapter((ListAdapter) upApkListAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        UpApkListAdapter upApkListAdapter = this.r;
        if (upApkListAdapter != null) {
            upApkListAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.up_apk_list_fragment_screen /* 2131300674 */:
                this.v.D();
                return;
            case R.id.up_apk_list_fragment_search /* 2131300675 */:
                com.rtk.app.tool.t.h1(this.e);
                return;
            default:
                return;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getArguments();
        this.e = getActivity();
        View view = this.p;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.up_apk_list_fragment_layout, viewGroup, false);
            this.p = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
            View view2 = this.p;
            r(view2, view2);
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.p;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }
}
