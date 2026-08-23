package com.rtk.app.main.UpModule;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckApkListFragment extends BaseFragment implements h.j {
    Unbinder o;
    private Bundle p;
    private int q = 1;
    private String r = "";
    private List<UpApkListBean.DataBean> s = new ArrayList();
    private UpSrcListAdapter t;
    private String u;

    @BindView
    AutoListView upCheckApkListFragmentListView;
    private boolean v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.X0(((BaseFragment) UpCheckApkListFragment.this).e, new ApkInfo((UpApkListBean.DataBean) UpCheckApkListFragment.this.s.get(i - 1)));
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

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpCheckApkListFragment", "up审核列表status" + this.r + "  \n" + str);
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
        if (TextUtils.isEmpty(this.u)) {
            HashMap<String, String> k = com.rtk.app.tool.y.k();
            k.put("status", this.r);
            k.put("key", com.rtk.app.tool.t.L(k));
            k.put("uid", com.rtk.app.tool.y.K());
            k.put("token", com.rtk.app.tool.y.H());
            k.put("page", this.q + "");
            if (this.v) {
                com.rtk.app.tool.c0.u("UpCheckApkListFragment", "isAuditInfoForFamily true");
                k.put(com.umeng.analytics.pro.d.y, "1");
            }
            String w = com.rtk.app.tool.y.w("members/sourceListExamine", k);
            com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(w));
            com.rtk.app.tool.c0.u("UpCheckApkListFragment", "  审核列表  " + com.rtk.app.tool.y.d + w);
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.u);
        l.put("status3", this.r);
        l.put("key", com.rtk.app.tool.t.L(l));
        l.put("$*$page", this.q + "");
        String w2 = com.rtk.app.tool.y.w("family/up/check/list", l);
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w2));
        com.rtk.app.tool.c0.u("UpCheckApkListFragment", "  审核列表  " + com.rtk.app.tool.y.e + w2);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upCheckApkListFragmentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.UpModule.j0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpCheckApkListFragment.this.z();
            }
        });
        this.upCheckApkListFragmentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.UpModule.k0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpCheckApkListFragment.this.B();
            }
        });
        this.upCheckApkListFragmentListView.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.upCheckApkListFragmentListView.f();
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        if (i2 == 1 && this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.i0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpCheckApkListFragment.this.x(strArr);
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
        this.u = this.p.getString("family_id");
        this.v = this.p.getBoolean("isAuditInfoForFamily", false);
        UpSrcListAdapter upSrcListAdapter = new UpSrcListAdapter(this.e, this.s, UpSrcListAdapter.c.UpCheckApk);
        this.t = upSrcListAdapter;
        this.upCheckApkListFragmentListView.setAdapter((ListAdapter) upSrcListAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        if (this.t != null) {
            com.rtk.app.tool.c0.u("UpCheckApkListFragment", "up审核列表的适配器被销毁了");
            this.t.b();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010 && i2 == 1008) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("modifyStatus");
            int i3 = extras.getInt("id");
            for (UpApkListBean.DataBean dataBean : this.s) {
                if (dataBean.getId() == i3) {
                    dataBean.setStatus(string);
                    this.t.notifyDataSetChanged();
                    return;
                }
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
            View inflate = layoutInflater.inflate(R.layout.up_check_apk_list_fragmet_layout, (ViewGroup) null);
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
}
