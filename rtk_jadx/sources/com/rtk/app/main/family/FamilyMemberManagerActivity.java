package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.FamilyMemberInfo;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.OtherImfomationPack.OtherPersonerImformationActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyMemberManagerActivity extends FamilyBaseActivity {

    @BindView
    AutoListView autoListView;

    @BindView
    View backLayout;

    @BindView
    NoOOMEditText noOOMEditText;
    private String r;

    @BindView
    View remove;
    int s = 1;
    List<FamilyMemberInfo.DataBean> t = new ArrayList();
    FamilyMemberManagerAdapter u;
    private String v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Bundle bundle = new Bundle();
            FamilyMemberManagerActivity familyMemberManagerActivity = FamilyMemberManagerActivity.this;
            bundle.putString("fans", familyMemberManagerActivity.t.get(i - familyMemberManagerActivity.autoListView.getHeaderViewsCount()).getUid());
            Intent intent = new Intent((Context) FamilyMemberManagerActivity.this, (Class<?>) OtherPersonerImformationActivity.class);
            intent.putExtras(bundle);
            FamilyMemberManagerActivity.this.startActivity(intent);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FamilyMemberManagerActivity.this.v = editable.toString().replaceAll("&", "").trim();
            FamilyMemberManagerActivity familyMemberManagerActivity = FamilyMemberManagerActivity.this;
            familyMemberManagerActivity.s = 1;
            familyMemberManagerActivity.O(1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            FamilyMemberManagerActivity.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S() {
        O(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void Q() {
        this.s = 1;
        O(1);
        O(2);
        this.autoListView.setLoadEnable(false);
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
            l.put("family_id", this.r);
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/info/real", 2, l);
            return;
        }
        HashMap<String, String> l2 = com.rtk.app.tool.y.l();
        l2.put("family_id", this.r);
        if (TextUtils.isEmpty(this.v)) {
            str = "family/user/list";
        } else {
            l2.put("keyword", this.v);
            str = "family/user/search";
        }
        l2.put("$*$$*$page", this.s + "");
        l2.put("key", com.rtk.app.tool.t.L(l2));
        String w = com.rtk.app.tool.y.w(str, l2);
        com.rtk.app.tool.c0.r("FamilyMemberManagerActivity", "url=" + w);
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            if (i != 2) {
                return;
            }
            FamilyInfoBean familyInfoBean = (FamilyInfoBean) w(str, FamilyInfoBean.class);
            this.q.setText("家族成员管理(" + familyInfoBean.getData().getMember_num() + "人)");
            return;
        }
        F();
        com.rtk.app.tool.c0.r("FamilyMemberManagerActivity", "success--mark:" + i + ",str:" + str);
        this.autoListView.k();
        FamilyMemberInfo familyMemberInfo = (FamilyMemberInfo) this.g.fromJson(str, FamilyMemberInfo.class);
        if (this.s == 1) {
            this.t.clear();
        }
        this.t.addAll(familyMemberInfo.getData());
        this.u.notifyDataSetChanged();
        this.autoListView.setResultSize(familyMemberInfo.getData().size());
        this.s++;
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            I(str, new c());
            return;
        }
        com.rtk.app.tool.c0.r("FamilyMemberManagerActivity", "code=" + i + "str=" + str + ",mark=" + i2);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        O(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.s
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                FamilyMemberManagerActivity.this.Q();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.r
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                FamilyMemberManagerActivity.this.S();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
        this.noOOMEditText.addTextChangedListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        FamilyMemberManagerAdapter familyMemberManagerAdapter = new FamilyMemberManagerAdapter(this, this.r, this.t);
        this.u = familyMemberManagerAdapter;
        this.autoListView.setAdapter((ListAdapter) familyMemberManagerAdapter);
        this.noOOMEditText.setHint("搜索家族成员");
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
        setContentView(R.layout.activity_family_member_manager);
        ButterKnife.a(this);
        this.r = getIntent().getStringExtra("family_id");
        G(null, this.backLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        O(2);
    }
}
