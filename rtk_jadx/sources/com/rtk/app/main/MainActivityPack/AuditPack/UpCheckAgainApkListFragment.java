package com.rtk.app.main.MainActivityPack.AuditPack;

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
import com.rtk.app.adapter.UpAuditAgainSrcListAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpAuditAgainListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckAgainApkListFragment extends BaseFragment implements h.j {
    Unbinder o;
    private Bundle p;
    private int q = 1;
    private String r = "";
    private List<UpAuditAgainListBean.DataDTO> s = new ArrayList();
    private UpAuditAgainSrcListAdapter t;

    @BindView
    AutoListView upCheckAgainApkListFragmentListView;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            t.X0(((BaseFragment) UpCheckAgainApkListFragment.this).e, new ApkInfo((UpAuditAgainListBean.DataDTO) UpCheckAgainApkListFragment.this.s.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.q = 1;
        A();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("UpCheckApkListFamilyFragment", "up审核列表status" + this.r + "  \n" + str);
        this.upCheckAgainApkListFragmentListView.k();
        q();
        if (i != 1) {
            return;
        }
        UpAuditAgainListBean upAuditAgainListBean = (UpAuditAgainListBean) this.f.fromJson(str, UpAuditAgainListBean.class);
        if (upAuditAgainListBean.getCode() != 0 || upAuditAgainListBean.getData() == null) {
            return;
        }
        if (this.q == 1) {
            this.s.clear();
        }
        this.s.addAll(upAuditAgainListBean.getData());
        this.t.notifyDataSetChanged();
        this.upCheckAgainApkListFragmentListView.setResultSize(upAuditAgainListBean.getData().size());
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void B() {
        StringBuilder sb = new StringBuilder();
        sb.append("up/check/review-list");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&status2=");
        sb.append(this.r);
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(t.c0(c0.e(y.v(this.e, "status2=" + this.r, "uid=" + y.K(), "token=" + y.H()))));
        String sb2 = sb.toString();
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("up复审审核列表  ");
        sb3.append(y.e);
        sb3.append(sb2);
        c0.u("UpCheckApkListFamilyFragment", sb3.toString());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.upCheckAgainApkListFragmentListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.l
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                UpCheckAgainApkListFragment.this.z();
            }
        });
        this.upCheckAgainApkListFragmentListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.k
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                UpCheckAgainApkListFragment.this.B();
            }
        });
        this.upCheckAgainApkListFragmentListView.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.upCheckAgainApkListFragmentListView.f();
        com.rtk.app.tool.f.a(this.e, str, f.a.f);
        if (i2 == 1 && this.q == 1) {
            t(str, new s() { // from class: com.rtk.app.main.MainActivityPack.AuditPack.j
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    UpCheckAgainApkListFragment.this.x(strArr);
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
        UpAuditAgainSrcListAdapter upAuditAgainSrcListAdapter = new UpAuditAgainSrcListAdapter(this.e, this.s);
        this.t = upAuditAgainSrcListAdapter;
        this.upCheckAgainApkListFragmentListView.setAdapter((ListAdapter) upAuditAgainSrcListAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        if (this.t != null) {
            c0.u("UpCheckApkListFamilyFragment", "up审核列表的适配器被销毁了");
            this.t.b();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010 && i2 == 1008) {
            Bundle extras = intent.getExtras();
            int i3 = extras.getInt("modifyStatus2");
            int i4 = extras.getInt("id");
            for (UpAuditAgainListBean.DataDTO dataDTO : this.s) {
                if (dataDTO.getId() == i4) {
                    dataDTO.setStatus2(i3);
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
