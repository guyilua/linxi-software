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
import com.rtk.app.R;
import com.rtk.app.adapter.AuditPhotoAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.AuditPhotoListBean;
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
public class AuditPhotoFragment extends BaseFragment implements h.j {
    Unbinder o;
    private Bundle p;
    private int q = 1;
    private String r = "";
    private List<AuditPhotoListBean.DataDTO> s = new ArrayList();
    private AuditPhotoAdapter t;

    @BindView
    AutoListView upCheckAgainApkListFragmentListView;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x() {
        this.q = 1;
        y();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("AuditPhotoFragment", "图片审核status：" + this.r + "  \n" + str);
        this.upCheckAgainApkListFragmentListView.k();
        q();
        if (i != 1) {
            return;
        }
        AuditPhotoListBean auditPhotoListBean = (AuditPhotoListBean) this.f.fromJson(str, AuditPhotoListBean.class);
        if (auditPhotoListBean.getCode() != 0 || auditPhotoListBean.getData() == null) {
            return;
        }
        if (this.q == 1) {
            this.s.clear();
        }
        this.s.addAll(auditPhotoListBean.getData());
        this.t.notifyDataSetChanged();
        this.upCheckAgainApkListFragmentListView.setResultSize(auditPhotoListBean.getData().size());
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void z() {
        StringBuilder sb = new StringBuilder();
        sb.append("user/check/photo-list");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&state=");
        sb.append(this.r);
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(t.c0(c0.e(y.v(this.e, "state=" + this.r, "uid=" + y.K(), "token=" + y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("审核相册列表：");
        sb3.append(y.e);
        sb3.append(sb2);
        c0.u("AuditPhotoFragment", sb3.toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upCheckAgainApkListFragmentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.c
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                AuditPhotoFragment.this.x();
            }
        });
        this.upCheckAgainApkListFragmentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.d
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                AuditPhotoFragment.this.z();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.upCheckAgainApkListFragmentListView.f();
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        if (i2 == 1 && this.q == 1) {
            t(str, new s() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.e
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    AuditPhotoFragment.this.v(strArr);
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
        int admin = c.d.a.d.d() ? MainActivity.p.getData().getAdmin().getAdmin() : 0;
        if (c.d.a.d.d()) {
            r1 = (MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUserPhotoAdmin() == 2) ? 2 : 0;
            if (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUserPhotoAdmin() == 1) {
                r1 = 1;
            }
        }
        AuditPhotoAdapter auditPhotoAdapter = new AuditPhotoAdapter(this.e, this.s, r1, admin);
        this.t = auditPhotoAdapter;
        this.upCheckAgainApkListFragmentListView.setAdapter((ListAdapter) auditPhotoAdapter);
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
