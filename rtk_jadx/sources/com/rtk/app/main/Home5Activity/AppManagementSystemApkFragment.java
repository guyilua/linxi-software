package com.rtk.app.main.Home5Activity;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rtk.app.R;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.main.dialogPack.DialogPermision;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppManagementSystemApkFragment extends BaseFragment {
    ListView o;
    private List<PackageInfo> p;
    private AppManagementSystemApkAdapter q;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.k1((Activity) ((BaseFragment) AppManagementSystemApkFragment.this).e, ((PackageInfo) AppManagementSystemApkFragment.this.p.get(i)).packageName);
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void D() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.o.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        arrayList.addAll(com.rtk.app.tool.t.A(this.e));
        if (this.p.size() < 3) {
            new DialogPermision(this.e, getResources().getString(R.string.single_permission_tips)).show();
        }
        AppManagementSystemApkAdapter appManagementSystemApkAdapter = new AppManagementSystemApkAdapter(this.e, this.p);
        this.q = appManagementSystemApkAdapter;
        this.o.setAdapter((ListAdapter) appManagementSystemApkAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.a == null) {
            this.o = (ListView) layoutInflater.inflate(R.layout.listview_layout, viewGroup, false);
            b();
        }
        return this.o;
    }
}
