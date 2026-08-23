package com.rtk.app.main.Home5Activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.AppManagementOutApkAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.DialogPermision;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppManagementOutApkFragment extends BaseFragment implements com.rtk.app.tool.s {

    @BindView
    AutoListView appManagementOutApkListView;

    @BindView
    LinearLayout appManagementOutApkTopLayout;

    @BindView
    ImageView appManagementOutApkTopSearchBtu;

    @BindView
    EditText appManagementOutApkTopSearchTv;

    @BindView
    TextView appManagementOutApkUnInstallSelect;
    Unbinder o;
    private List<PackageInfo> p;
    private List<PackageInfo> q;
    private List<PackageInfo> r;
    private List<Boolean> s;
    private List<Boolean> t;
    private AppManagementOutApkAdapter u;
    private String v;
    private TextWatcher w;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.k1((Activity) ((BaseFragment) AppManagementOutApkFragment.this).e, ((PackageInfo) AppManagementOutApkFragment.this.p.get(i - 1)).packageName);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            AppManagementOutApkFragment.this.B();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AppManagementOutApkFragment appManagementOutApkFragment = AppManagementOutApkFragment.this;
            appManagementOutApkFragment.v = appManagementOutApkFragment.appManagementOutApkTopSearchTv.getText().toString().trim();
            if (com.rtk.app.tool.c0.q(AppManagementOutApkFragment.this.v)) {
                AppManagementOutApkFragment.this.B();
            } else {
                AppManagementOutApkFragment.this.C();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.appManagementOutApkTopSearchTv.removeTextChangedListener(this.w);
        this.q.clear();
        this.t.clear();
        this.v = "";
        this.appManagementOutApkTopSearchTv.setText("");
        AppManagementOutApkAdapter appManagementOutApkAdapter = new AppManagementOutApkAdapter(this.e, this.p, this.s, this);
        this.u = appManagementOutApkAdapter;
        this.appManagementOutApkListView.setAdapter((ListAdapter) appManagementOutApkAdapter);
        this.appManagementOutApkListView.k();
        this.appManagementOutApkListView.setLoadEnable(true);
        D(this.s);
        this.appManagementOutApkTopSearchTv.addTextChangedListener(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.appManagementOutApkTopSearchTv.removeTextChangedListener(this.w);
        DialogForProgressTip dialogForProgressTip = new DialogForProgressTip(this.e, "搜索中请稍后");
        dialogForProgressTip.show();
        this.v = this.appManagementOutApkTopSearchTv.getText().toString().trim();
        this.q.clear();
        this.t.clear();
        if (com.rtk.app.tool.c0.q(this.v)) {
            B();
            dialogForProgressTip.dismiss();
            return;
        }
        for (int i = 0; i < this.p.size(); i++) {
            if (this.p.get(i).applicationInfo.loadLabel(this.e.getPackageManager()).toString().contains(this.v)) {
                this.q.add(this.p.get(i));
                this.t.add(this.s.get(i));
            }
        }
        AppManagementOutApkAdapter appManagementOutApkAdapter = new AppManagementOutApkAdapter(this.e, this.q, this.t, this);
        this.u = appManagementOutApkAdapter;
        this.appManagementOutApkListView.setAdapter((ListAdapter) appManagementOutApkAdapter);
        this.appManagementOutApkListView.k();
        this.appManagementOutApkListView.setLoadEnable(true);
        D(this.t);
        dialogForProgressTip.dismiss();
        this.appManagementOutApkTopSearchTv.addTextChangedListener(this.w);
    }

    private void D(List<Boolean> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).booleanValue()) {
                i++;
            }
        }
        this.appManagementOutApkUnInstallSelect.setText("批量卸载（" + i + "）");
        this.appManagementOutApkUnInstallSelect.setVisibility(i <= 0 ? 8 : 0);
    }

    public void A() {
        this.p.clear();
        this.s.clear();
        this.p.addAll(com.rtk.app.tool.t.z(this.e));
        if (this.p.size() < 3) {
            new DialogPermision(this.e, getResources().getString(R.string.single_permission_tips)).show();
        }
        for (int i = 0; i < this.p.size(); i++) {
            this.s.add(Boolean.FALSE);
        }
        this.u.notifyDataSetChanged();
        this.appManagementOutApkUnInstallSelect.setVisibility(8);
        if (this.q.size() > 0) {
            C();
        }
    }

    @Override // com.rtk.app.tool.s
    public void a(String... strArr) {
        D(this.s);
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void z() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.appManagementOutApkUnInstallSelect.setOnClickListener(this);
        this.appManagementOutApkTopSearchBtu.setOnClickListener(this);
        this.appManagementOutApkListView.setOnItemClickListener(new a());
        this.appManagementOutApkListView.setOnRefreshListener(new b());
        c cVar = new c();
        this.w = cVar;
        this.appManagementOutApkTopSearchTv.addTextChangedListener(cVar);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
        com.rtk.app.tool.t.S1(this.e, this.appManagementOutApkTopLayout, null, null, null);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.r = new ArrayList();
        this.p.addAll(com.rtk.app.tool.t.z(this.e));
        for (int i = 0; i < this.p.size(); i++) {
            this.s.add(Boolean.FALSE);
        }
        AppManagementOutApkAdapter appManagementOutApkAdapter = new AppManagementOutApkAdapter(this.e, this.p, this.s, this);
        this.u = appManagementOutApkAdapter;
        this.appManagementOutApkListView.setAdapter((ListAdapter) appManagementOutApkAdapter);
        this.appManagementOutApkListView.k();
        this.appManagementOutApkListView.setLoadEnable(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int i = 0;
        if (id == 2131296508) {
            if (com.rtk.app.tool.c0.q(this.v)) {
                com.rtk.app.tool.f.a(this.e, "搜索内容不可为空", f.a.f);
                return;
            } else {
                C();
                return;
            }
        }
        if (id != 2131296510) {
            return;
        }
        this.r.clear();
        if (this.t.size() > 0) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                if (this.t.get(i2).booleanValue()) {
                    this.r.add(this.q.get(i2));
                }
            }
            while (i < this.r.size()) {
                com.rtk.app.tool.t.g2(this.e, this.r.get(i).packageName);
                i++;
            }
            return;
        }
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (this.s.get(i3).booleanValue()) {
                this.r.add(this.p.get(i3));
            }
        }
        while (i < this.r.size()) {
            com.rtk.app.tool.t.g2(this.e, this.r.get(i).packageName);
            i++;
        }
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.app_management_out_apk_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
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
