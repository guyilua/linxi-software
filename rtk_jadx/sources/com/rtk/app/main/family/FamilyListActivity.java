package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCreateCheckTipsBean;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.FamilyListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyListActivity extends FamilyBaseActivity {

    @BindView
    AutoListView autoListView;

    @BindView
    View backLayout;

    @BindView
    TextView createFamily;
    FamilyListAdapter s;
    private String u;
    List<FamilyInfoBean.DataBean> r = new ArrayList();
    private int t = 1;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [android.content.Context, com.rtk.app.main.family.FamilyListActivity] */
        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            ?? r2 = FamilyListActivity.this;
            Intent intent = new Intent((Context) r2, (Class<?>) (TextUtils.isEmpty(((FamilyListActivity) r2).u) ? MyFamilyActivity.class : FamilyInfoActivity.class));
            FamilyListActivity familyListActivity = FamilyListActivity.this;
            intent.putExtra("family_id", familyListActivity.r.get(i - familyListActivity.autoListView.getHeaderViewsCount()).getFamily_id());
            FamilyListActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(String[] strArr) {
        O(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S() {
        this.t = 1;
        O(1);
        this.autoListView.setLoadEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U() {
        O(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O(int... iArr) {
        String str;
        int i = iArr[0];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.l(this, this, 2, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/create/check", l)));
            return;
        }
        HashMap<String, String> k = com.rtk.app.tool.y.k();
        String str2 = "token";
        String str3 = "uid";
        if (TextUtils.isEmpty(this.u)) {
            str = "family/my-family";
        } else {
            str3 = com.rtk.app.tool.y.z("uid");
            str2 = com.rtk.app.tool.y.z("token");
            k.put("tuid", this.u);
            str = "family/ta-family";
        }
        k.put(str3, com.rtk.app.tool.y.K());
        k.put(str2, com.rtk.app.tool.y.H());
        k.put(com.rtk.app.tool.y.z("page"), this.t + "");
        k.put("key", com.rtk.app.tool.t.L(k));
        String w = com.rtk.app.tool.y.w(str, k);
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
        com.rtk.app.tool.c0.u("MyFamilyListActivity", "url:" + com.rtk.app.tool.y.e + w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        Intent intent;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (j1.a(((FamilyCreateCheckTipsBean) w(str, FamilyCreateCheckTipsBean.class)).getData())) {
                intent = new Intent((Context) this, (Class<?>) FamilyCreateActivity.class);
            } else {
                intent = new Intent((Context) this, (Class<?>) FamilyCreateCheckTipsActivity.class);
            }
            startActivity(intent);
            return;
        }
        F();
        this.autoListView.k();
        FamilyListBean familyListBean = (FamilyListBean) this.g.fromJson(str, FamilyListBean.class);
        com.rtk.app.tool.c0.r("MyFamilyListActivity", com.rtk.app.c.a.b(str));
        if (this.t == 1) {
            this.r.clear();
        }
        List<FamilyInfoBean.DataBean> data = familyListBean.getData();
        this.r.addAll(data);
        this.s.notifyDataSetChanged();
        this.autoListView.setResultSize(data.size());
        this.t++;
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        FamilyListAdapter familyListAdapter = this.s;
        if (familyListAdapter != null) {
            familyListAdapter.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("MyFamilyListActivity", "onError,str=" + str + ",code=" + i);
        if (i2 == 1) {
            if (this.t == 1) {
                I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.o
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        FamilyListActivity.this.Q(strArr);
                    }
                });
                return;
            }
            return;
        }
        com.rtk.app.tool.f.a(this, str, f.a.f);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        super.initData();
        O(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.m
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                FamilyListActivity.this.S();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.n
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                FamilyListActivity.this.U();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        FamilyListAdapter familyListAdapter = new FamilyListAdapter(this, this.r);
        this.s = familyListAdapter;
        this.autoListView.setAdapter((ListAdapter) familyListAdapter);
        this.s.e(!TextUtils.isEmpty(this.u));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296522) {
            return;
        }
        if (!com.rtk.app.tool.y.x(this)) {
            com.rtk.app.tool.t.w0(this);
        } else {
            O(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_latest_family);
        ButterKnife.a(this);
        this.u = getIntent().getStringExtra("tuid");
        G(null, this.backLayout);
        if (TextUtils.isEmpty(this.u)) {
            this.q.setText("我的家族列表");
            this.createFamily.setVisibility(0);
            this.createFamily.setText(R.string.create_family);
            return;
        }
        this.q.setText("TA的家族列表");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
    }
}
