package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.UnInstallAdapter;
import com.rtk.app.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UnInstallActivity extends BaseActivity {
    private Context q;
    private List<PackageInfo> r;
    private UnInstallAdapter s;

    @BindView
    ListView unInstallListview;

    @BindView
    TextView unInstallTopBack;

    @BindView
    LinearLayout unInstallTopLayout;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.unInstallTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayList arrayList = new ArrayList();
        this.r = arrayList;
        arrayList.addAll(com.rtk.app.tool.t.z(this.q));
        UnInstallAdapter unInstallAdapter = new UnInstallAdapter(this.q, this.r);
        this.s = unInstallAdapter;
        this.unInstallListview.setAdapter((ListAdapter) unInstallAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 600) {
            return;
        }
        this.r.clear();
        this.r.addAll(com.rtk.app.tool.t.z(this.q));
        this.s.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300569) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_un_install);
        ButterKnife.a(this);
        this.q = this;
    }
}
