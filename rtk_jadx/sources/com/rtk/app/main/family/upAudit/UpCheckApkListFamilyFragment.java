package com.rtk.app.main.family.upAudit;

import android.content.Intent;
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
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.FamilyUpAuditListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckApkListFamilyFragment extends BaseFragment implements h.j {
    Unbinder o;
    private Bundle p;
    private int q = 1;
    private String r = "";
    private String s = "";
    private List<FamilyUpAuditListBean.DataDTO> t = new ArrayList();
    private FamilyUpAuditSrcListAdapter u;

    @BindView
    AutoListView upCheckAgainApkListFragmentListView;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            t.X0(((BaseFragment) UpCheckApkListFamilyFragment.this).e, new ApkInfo((FamilyUpAuditListBean.DataDTO) UpCheckApkListFamilyFragment.this.t.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.q = 1;
        B();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpCheckApkListFamilyFragment", "up审核列表status" + this.r + "  \n" + str);
        this.upCheckAgainApkListFragmentListView.k();
        q();
        if (i != 1) {
            return;
        }
        FamilyUpAuditListBean familyUpAuditListBean = (FamilyUpAuditListBean) this.f.fromJson(str, FamilyUpAuditListBean.class);
        if (familyUpAuditListBean.getCode() != 0 || familyUpAuditListBean.getData() == null) {
            return;
        }
        if (this.q == 1) {
            this.t.clear();
        }
        this.t.addAll(familyUpAuditListBean.getData());
        this.u.notifyDataSetChanged();
        this.upCheckAgainApkListFragmentListView.setResultSize(familyUpAuditListBean.getData().size());
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    public void B() {
        HashMap<String, String> l = y.l();
        l.put("family_id", this.s);
        l.put("status3", this.r);
        l.put("key", t.L(l));
        l.put("$*$page", this.q + "");
        String w = y.w("family/up/check/list", l);
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(w));
        c0.u("UpCheckApkListFamilyFragment", "  家族审核列表  " + y.e + w);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upCheckAgainApkListFragmentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.upAudit.d
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpCheckApkListFamilyFragment.this.z();
            }
        });
        this.upCheckAgainApkListFragmentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.upAudit.e
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpCheckApkListFamilyFragment.this.B();
            }
        });
        this.upCheckAgainApkListFragmentListView.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.upCheckAgainApkListFragmentListView.f();
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        if (i2 == 1 && this.q == 1) {
            t(str, new s() { // from class: com.rtk.app.main.family.upAudit.f
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpCheckApkListFamilyFragment.this.x(strArr);
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
        this.s = this.p.getString("family_id");
        FamilyUpAuditSrcListAdapter familyUpAuditSrcListAdapter = new FamilyUpAuditSrcListAdapter(this.e, this.t);
        this.u = familyUpAuditSrcListAdapter;
        this.upCheckAgainApkListFragmentListView.setAdapter((ListAdapter) familyUpAuditSrcListAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        if (this.u != null) {
            c0.u("UpCheckApkListFamilyFragment", "up审核列表的适配器被销毁了");
            this.u.b();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c0.u("UpCheckApkListFamilyFragment", "onActivityResult" + i + "  " + i2);
        if (i == 1010 && i2 == 1008) {
            Bundle extras = intent.getExtras();
            int i3 = extras.getInt("modifyStatus3");
            int i4 = extras.getInt("id");
            for (FamilyUpAuditListBean.DataDTO dataDTO : this.t) {
                c0.u("UpCheckApkListFamilyFragment", "onActivityResult id:" + i4 + "  " + dataDTO.getId());
                if (dataDTO.getId() == i4) {
                    dataDTO.setStatus3(i3);
                    this.u.notifyDataSetChanged();
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
