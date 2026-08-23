package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.ApplyJoinFamilyInfo;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyApplyFamilyListActivity extends FamilyBaseActivity {

    @BindView
    AutoListView autoListView;

    @BindView
    View backLayout;
    MyApplyFamilyListAdapter s;
    List<ApplyJoinFamilyInfo.DataBean> r = new ArrayList();
    private int t = 1;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent((Context) MyApplyFamilyListActivity.this, (Class<?>) FamilyInfoActivity.class);
            MyApplyFamilyListActivity myApplyFamilyListActivity = MyApplyFamilyListActivity.this;
            intent.putExtra("family_id", myApplyFamilyListActivity.r.get(i - myApplyFamilyListActivity.autoListView.getHeaderViewsCount()).getFamily_id());
            MyApplyFamilyListActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        N(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R() {
        this.t = 1;
        N(1);
        this.autoListView.setLoadEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        N(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("status", "1");
        l.put(com.rtk.app.tool.y.z("page"), this.t + "");
        l.put("key", com.rtk.app.tool.t.L(l));
        String w = com.rtk.app.tool.y.w("family/join/my-apply-list", l);
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
        com.rtk.app.tool.c0.u("MyApplyFamilyListActivity", "url:" + com.rtk.app.tool.y.e + w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.r("MyApplyFamilyListActivity", "success,str=\n" + com.rtk.app.c.a.b(str));
        F();
        this.autoListView.k();
        List<ApplyJoinFamilyInfo.DataBean> data = ((ApplyJoinFamilyInfo) this.g.fromJson(str, ApplyJoinFamilyInfo.class)).getData();
        com.rtk.app.tool.c0.r("MyApplyFamilyListActivity", com.rtk.app.c.a.b(str));
        if (this.t == 1) {
            this.r.clear();
            if (data.isEmpty()) {
                com.rtk.app.tool.f.a(this, "您没有申请加入任何家族。", f.a.f);
            }
        }
        this.r.addAll(data);
        this.s.notifyDataSetChanged();
        this.autoListView.setResultSize(data.size());
        this.t++;
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        MyApplyFamilyListAdapter myApplyFamilyListAdapter = this.s;
        if (myApplyFamilyListAdapter != null) {
            myApplyFamilyListAdapter.b();
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("MyApplyFamilyListActivity", "onError,str=" + str + ",code=" + i);
        if (this.t == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.o0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyApplyFamilyListActivity.this.P(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        super.initData();
        N(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.n0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                MyApplyFamilyListActivity.this.R();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.m0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                MyApplyFamilyListActivity.this.T();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        MyApplyFamilyListAdapter myApplyFamilyListAdapter = new MyApplyFamilyListAdapter(this, this.r);
        this.s = myApplyFamilyListAdapter;
        this.autoListView.setAdapter((ListAdapter) myApplyFamilyListAdapter);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_my_apply_family_list);
        ButterKnife.a(this);
        G(null, this.backLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
    }
}
