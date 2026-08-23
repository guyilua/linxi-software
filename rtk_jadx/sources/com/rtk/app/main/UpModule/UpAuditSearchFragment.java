package com.rtk.app.main.UpModule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.UpSrcListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpAuditSearchFragment extends BaseFragment implements h.j {
    Unbinder o;
    private Bundle p;
    private int q = 1;
    private String r = "";
    private List<UpApkListBean.DataBean> s = new ArrayList();
    private UpSrcListAdapter t;
    private String u;

    @BindView
    AutoListView upCheckApkListFragmentListView;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.X0(((BaseFragment) UpAuditSearchFragment.this).e, new ApkInfo((UpApkListBean.DataBean) UpAuditSearchFragment.this.s.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.q = 1;
        z();
    }

    public void C(String str, int i) {
        this.r = i + "";
        this.u = str;
        this.e = MyApplication.b();
        this.q = 1;
        z();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpAuditSearchFragment", "up审核列表status" + this.r + "  \n" + str);
        this.upCheckApkListFragmentListView.k();
        q();
        if (i != 1) {
            return;
        }
        UpApkListBean upApkListBean = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
        if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
            return;
        }
        if (this.q == 1) {
            this.s.clear();
        }
        this.s.addAll(upApkListBean.getData());
        this.t.notifyDataSetChanged();
        this.upCheckApkListFragmentListView.setResultSize(upApkListBean.getData().size());
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void B() {
        if (com.rtk.app.tool.c0.q(this.u)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("members/adminSourceList");
        sb.append(com.rtk.app.tool.y.u(MyApplication.b()));
        sb.append("&status=");
        sb.append(this.r);
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&searchWord=");
        sb.append(this.u);
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(MyApplication.b(), "token=" + com.rtk.app.tool.y.H(), "uid=" + com.rtk.app.tool.y.K()))));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("  审核列表  ");
        sb3.append(com.rtk.app.tool.y.d);
        sb3.append(sb2);
        com.rtk.app.tool.c0.u("UpAuditSearchFragment", sb3.toString());
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb2));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upCheckApkListFragmentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.a0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpAuditSearchFragment.this.z();
            }
        });
        this.upCheckApkListFragmentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.c0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpAuditSearchFragment.this.B();
            }
        });
        this.upCheckApkListFragmentListView.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        if (i2 != 1) {
            return;
        }
        this.upCheckApkListFragmentListView.f();
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.b0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpAuditSearchFragment.this.x(strArr);
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
        this.p = arguments;
        this.r = arguments.getString("status");
        UpSrcListAdapter upSrcListAdapter = new UpSrcListAdapter(this.e, this.s, UpSrcListAdapter.c.UpCheckApk);
        this.t = upSrcListAdapter;
        this.upCheckApkListFragmentListView.setAdapter((ListAdapter) upSrcListAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        if (this.t != null) {
            com.rtk.app.tool.c0.u("UpAuditSearchFragment", "up审核列表的适配器被销毁了");
            this.t.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.up_check_apk_list_fragmet_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            this.q = 1;
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
}
