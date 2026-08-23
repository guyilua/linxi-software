package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.UpgradeGameAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpgradeGameBean;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpgradeGameActivity extends BaseActivity implements h.j {
    private Context q;
    private List<PackageInfo> r;
    private UpgradeGameBean s;
    private List<UpgradeGameBean.DataBean> t;
    private UpgradeGameAdapter u;

    @BindView
    ListView upgradeGameListview;

    @BindView
    TextView upgradeGameTopBack;

    @BindView
    LinearLayout upgradeGameTopLayout;
    private View v;
    private TextView w;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(UpgradeGameActivity.this.q, new ApkInfo(((UpgradeGameBean.DataBean) UpgradeGameActivity.this.t.get(i)).getGame_id(), null, ((UpgradeGameBean.DataBean) UpgradeGameActivity.this.t.get(i)).getPackage_name(), null, null, null, 0, 0, null));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpgradeGameActivity.this.N(new int[0]);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.upgradeGameTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        this.r = com.rtk.app.tool.t.z(this.q);
        String str = "[";
        for (int i = 0; i < this.r.size(); i++) {
            str = str + "{\"packagename\":\"" + this.r.get(i).packageName + "\",\"versioncode\":\"" + this.r.get(i).versionCode + "\"},";
        }
        String str2 = str.substring(0, str.length() - 1) + "]";
        HashMap hashMap = new HashMap();
        hashMap.put("channel", com.rtk.app.tool.y.m(this.q, getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.q));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("package_data", str2);
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "package_data=" + str2))));
        com.rtk.app.tool.o.h.j(this.q, this, com.rtk.app.tool.y.d + "game/gamesIsUpdate", 1, hashMap);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("UpgradeGameActivity", "需要更新的页面" + str);
        F();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        this.s = (UpgradeGameBean) create.fromJson(str, UpgradeGameBean.class);
        this.w.setText("暂无可升级游戏");
        if (this.s.getCode() == 0) {
            this.t.addAll(this.s.getData());
        }
        if (this.t.size() == 0) {
            this.v.setVisibility(0);
            com.rtk.app.tool.t.h(this.v, this.upgradeGameListview);
        }
        this.u.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        I(str, new b());
        if (com.rtk.app.tool.t.t1(this.q)) {
            return;
        }
        this.v.setVisibility(0);
        this.w.setText("请检查您的网络");
        com.rtk.app.tool.t.h(this.v, this.upgradeGameListview);
        this.u.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upgradeGameListview.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.t = new ArrayList();
        this.u = new UpgradeGameAdapter(this.q, this.t);
        View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.upgrade_game_listview_empty_layout, (ViewGroup) null);
        this.v = inflate;
        this.w = (TextView) inflate.findViewById(com.rtk.app.R.id.upgrade_game_listview_item_empty_tv);
        this.upgradeGameListview.setAdapter((ListAdapter) this.u);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131301125) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_upgrade_game);
        ButterKnife.a(this);
        this.q = this;
        N(new int[0]);
        G(null, this.upgradeGameTopLayout);
    }
}
