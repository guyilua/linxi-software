package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.bean.ApplyJoinFamilyInfo;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.OtherImfomationPack.OtherPersonerImformationActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyApplyJoinListActivity extends FamilyBaseActivity {

    @BindView
    AutoListView autoListView;

    @BindView
    CheckBox checkBox;
    private String s;
    private h1 u;
    private int r = 1;
    List<ApplyJoinFamilyInfo.DataBean> t = new ArrayList();
    private int v = 1;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Bundle bundle = new Bundle();
            FamilyApplyJoinListActivity familyApplyJoinListActivity = FamilyApplyJoinListActivity.this;
            bundle.putString("fans", familyApplyJoinListActivity.t.get(i - familyApplyJoinListActivity.autoListView.getHeaderViewsCount()).getUid());
            Intent intent = new Intent((Context) FamilyApplyJoinListActivity.this, (Class<?>) OtherPersonerImformationActivity.class);
            intent.putExtras(bundle);
            FamilyApplyJoinListActivity.this.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(CompoundButton compoundButton, boolean z) {
        this.v = z ? 1 : 0;
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        N(new int[0]);
    }

    @Override // com.rtk.app.base.BaseActivity
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void R() {
        this.r = 1;
        N(new int[0]);
        this.autoListView.setLoadEnable(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put(com.rtk.app.tool.y.z("page"), this.r + "");
        l.put("family_id", this.s);
        l.put(com.rtk.app.tool.y.z("status"), this.v + "");
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/join/user-list", l)));
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.autoListView.k();
        ApplyJoinFamilyInfo applyJoinFamilyInfo = (ApplyJoinFamilyInfo) this.g.fromJson(str, ApplyJoinFamilyInfo.class);
        com.rtk.app.tool.c0.r("ApplyJoinFamilyListActivity", "onSuccess,str=" + applyJoinFamilyInfo);
        if (this.r == 1) {
            this.t.clear();
        }
        this.t.addAll(applyJoinFamilyInfo.getData());
        this.u.notifyDataSetChanged();
        this.autoListView.setResultSize(applyJoinFamilyInfo.getData().size());
        this.r++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("ApplyJoinFamilyListActivity", "code=" + i + "--str--" + str);
        com.rtk.app.tool.f.a(this, str, ErrorCode.NETWORK_UNKNOWN);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        N(new int[0]);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rtk.app.main.family.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                FamilyApplyJoinListActivity.this.P(compoundButton, z);
            }
        });
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.a
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                FamilyApplyJoinListActivity.this.R();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.b
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                FamilyApplyJoinListActivity.this.T();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        h1 h1Var = new h1(this, this.t);
        this.u = h1Var;
        this.autoListView.setAdapter((ListAdapter) h1Var);
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
        setContentView(R.layout.activity_family_join_family_list);
        ButterKnife.a(this);
        this.s = getIntent().getStringExtra("family_id");
    }
}
