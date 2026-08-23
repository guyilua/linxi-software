package com.rtk.app.main.MainActivityPack.AuditPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.AuditIconAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.AuditIconListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditUserIconFragment extends BaseFragment implements h.j {
    Unbinder o;
    private AuditIconListBean q;
    private List<AuditIconListBean.DataDTO> r;
    private AuditIconAdapter s;
    private Bundle u;

    @BindView
    AutoListView upCheckAgainApkListFragmentListView;
    private int p = 1;
    private int t = 0;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            c0.u("AuditUserIconFragment", "setOnRefreshListener");
            AuditUserIconFragment.this.p = 1;
            AuditUserIconFragment.this.x();
            AuditUserIconFragment.this.upCheckAgainApkListFragmentListView.setLoadEnable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        x();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.r("AuditUserIconFragment", "state类型:" + this.t + " " + str);
        q();
        this.upCheckAgainApkListFragmentListView.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.q = (AuditIconListBean) create.fromJson(str, AuditIconListBean.class);
        if (this.p == 1) {
            this.upCheckAgainApkListFragmentListView.setSelectionFromTop(0, 0);
            this.r.clear();
        }
        this.p++;
        this.r.addAll(this.q.getData());
        this.s.notifyDataSetChanged();
        this.upCheckAgainApkListFragmentListView.setResultSize(this.q.getData().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void y() {
        StringBuilder sb = new StringBuilder();
        sb.append("user/check/avatar-list");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&state=");
        sb.append(this.t);
        sb.append("&page=");
        sb.append(this.p);
        sb.append("&key=");
        sb.append(t.c0(c0.e(y.v(this.e, "state=" + this.t, "uid=" + y.K(), "token=" + y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("审核头像列表：");
        sb3.append(y.e);
        sb3.append(sb2);
        c0.u("AuditUserIconFragment", sb3.toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upCheckAgainApkListFragmentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.i
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                AuditUserIconFragment.this.y();
            }
        });
        this.upCheckAgainApkListFragmentListView.setOnRefreshListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            t(str, new s() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.h
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    AuditUserIconFragment.this.w(strArr);
                }
            });
        }
        this.upCheckAgainApkListFragmentListView.f();
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        Bundle arguments = getArguments();
        this.u = arguments;
        this.t = arguments.getInt("state");
        this.r = new ArrayList();
        int admin = c.d.a.d.d() ? MainActivity.p.getData().getAdmin().getAdmin() : 0;
        if (c.d.a.d.d()) {
            r1 = (MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUserFaceAdmin() == 2) ? 2 : 0;
            if (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserFaceAdmin() == 1) {
                r1 = 1;
            }
        }
        AuditIconAdapter auditIconAdapter = new AuditIconAdapter(this.e, this.r, r1, admin);
        this.s = auditIconAdapter;
        this.upCheckAgainApkListFragmentListView.setAdapter((ListAdapter) auditIconAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.up_check_again_apk_list_fragmet_layout, (ViewGroup) null);
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
