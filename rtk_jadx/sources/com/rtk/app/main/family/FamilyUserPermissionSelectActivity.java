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
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyMemberInfo;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.OtherImfomationPack.OtherPersonerImformationActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUserPermissionSelectActivity extends FamilyBaseActivity {

    @BindView
    AutoListView autoListView;

    @BindView
    View backLayout;

    @BindView
    TextView backTV;

    @BindView
    NoOOMEditText noOOMEditText;
    private String r;

    @BindView
    TextView remove;
    private String t;
    FamilyMemberManagerAdapter w;
    private int s = 1;
    int u = 1;
    List<FamilyMemberInfo.DataBean> v = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Bundle bundle = new Bundle();
            FamilyUserPermissionSelectActivity familyUserPermissionSelectActivity = FamilyUserPermissionSelectActivity.this;
            bundle.putString("fans", familyUserPermissionSelectActivity.v.get(i - familyUserPermissionSelectActivity.autoListView.getHeaderViewsCount()).getUid());
            Intent intent = new Intent((Context) FamilyUserPermissionSelectActivity.this, (Class<?>) OtherPersonerImformationActivity.class);
            intent.putExtras(bundle);
            FamilyUserPermissionSelectActivity.this.startActivity(intent);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FamilyUserPermissionSelectActivity.this.t = editable.toString().replaceAll("&", "").trim();
            FamilyUserPermissionSelectActivity.this.s = 1;
            FamilyUserPermissionSelectActivity.this.P(1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V() {
        P(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity
    protected void A() {
    }

    @Override // com.rtk.app.base.BaseActivity
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void T() {
        super.Q();
        this.s = 1;
        P(1);
        this.autoListView.setLoadEnable(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(int... iArr) {
        String str;
        if (iArr[0] != 1) {
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.r);
        if (TextUtils.isEmpty(this.t)) {
            str = "family/user/list";
        } else {
            l.put("keyword", this.t);
            str = "family/user/search";
        }
        l.put("$*$$*$page", this.s + "");
        l.put("key", com.rtk.app.tool.t.L(l));
        String w = com.rtk.app.tool.y.w(str, l);
        com.rtk.app.tool.c0.r("FamilyUserPermissionSelectActivity", "url=" + w);
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        com.rtk.app.tool.c0.r("FamilyUserPermissionSelectActivity", "success--mark:" + i + ",str:" + str);
        if (i != 1) {
            if (i != 2) {
                return;
            }
            com.rtk.app.tool.f.a(this, "设置成功", ErrorCode.NETWORK_UNKNOWN);
            finish();
            return;
        }
        this.autoListView.k();
        List<FamilyMemberInfo.DataBean> data = ((FamilyMemberInfo) this.g.fromJson(str, FamilyMemberInfo.class)).getData();
        if (this.s == 1) {
            this.v.clear();
        }
        this.v.addAll(data);
        this.w.notifyDataSetChanged();
        this.autoListView.setResultSize(data.size());
        this.s++;
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("FamilyUserPermissionSelectActivity", "code=" + i + "str=" + str + ",mark=" + i2);
        if (i2 == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.e0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    FamilyUserPermissionSelectActivity.this.R(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        P(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.f0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                FamilyUserPermissionSelectActivity.this.T();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.d0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                FamilyUserPermissionSelectActivity.this.V();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
        this.noOOMEditText.addTextChangedListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        FamilyMemberManagerAdapter familyMemberManagerAdapter = new FamilyMemberManagerAdapter(this, this.r, this.v);
        this.w = familyMemberManagerAdapter;
        familyMemberManagerAdapter.n(this.u);
        this.autoListView.setAdapter((ListAdapter) this.w);
        this.noOOMEditText.setHint("搜索家族成员");
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300002) {
            return;
        }
        P(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_member_manager);
        ButterKnife.a(this);
        this.r = getIntent().getStringExtra("family_id");
        this.u = getIntent().getIntExtra(com.umeng.analytics.pro.d.y, 1);
        if (TextUtils.isEmpty(this.r)) {
            finish();
            return;
        }
        int i = this.u;
        this.backTV.setText(i != 2 ? i != 3 ? R.string.set_fu_zu_zhang : R.string.set_up_audit : R.string.set_board_master);
        this.remove.setText(R.string.save);
        G(null, this.backLayout);
    }
}
