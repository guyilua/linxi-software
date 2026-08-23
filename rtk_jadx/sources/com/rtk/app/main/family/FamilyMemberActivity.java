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
import com.rtk.app.msgBean.EventMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyMemberActivity extends FamilyBaseActivity {

    @BindView
    AutoListView autoListView;

    @BindView
    View backLayout;

    @BindView
    View manager;

    @BindView
    NoOOMEditText noOOMEditText;
    private String r;
    private FamilyMemberAdapter t;
    private String v;
    private List<FamilyMemberInfo.DataBean> s = new ArrayList();
    private int u = 1;
    private boolean w = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.content.Context, com.rtk.app.main.family.FamilyMemberActivity] */
        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            ?? r1 = FamilyMemberActivity.this;
            com.rtk.app.tool.t.B0(r1, ((FamilyMemberInfo.DataBean) ((FamilyMemberActivity) r1).s.get(i - FamilyMemberActivity.this.autoListView.getHeaderViewsCount())).getUid());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FamilyMemberActivity.this.v = editable.toString().replaceAll("&", "").trim();
            FamilyMemberActivity.this.u = 1;
            FamilyMemberActivity.this.Q(1);
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
            FamilyMemberActivity.this.u = 1;
            FamilyMemberActivity.this.Q(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U() {
        Q(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void S() {
        this.u = 1;
        Q(1);
        this.autoListView.setLoadEnable(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Q(int... iArr) {
        String str;
        int i = iArr[0];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("family_id", this.r);
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/family-admin", l)));
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
        l2.put("$*$$*$page", this.u + "");
        l2.put("key", com.rtk.app.tool.t.L(l2));
        String w = com.rtk.app.tool.y.w(str, l2);
        com.rtk.app.tool.c0.r("FamilyMemberActivity", "url=" + w);
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        if (i == 1) {
            F();
            com.rtk.app.tool.c0.r("FamilyMemberActivity", "success--mark:" + i + ",str:" + str);
            this.autoListView.k();
            FamilyMemberInfo familyMemberInfo = (FamilyMemberInfo) this.g.fromJson(str, FamilyMemberInfo.class);
            if (this.u == 1) {
                this.s.clear();
            }
            this.s.addAll(familyMemberInfo.getData());
            this.t.notifyDataSetChanged();
            this.autoListView.setResultSize(familyMemberInfo.getData().size());
            this.u++;
        } else if (i == 2) {
            com.rtk.app.tool.c0.u("FamilyMemberActivity", "家族管理员  " + i + " \n    " + com.rtk.app.c.a.b(str));
            this.manager.setVisibility(((FamilyInfoBean) this.g.fromJson(str, FamilyInfoBean.class)).getData().isLeader(com.rtk.app.tool.y.K()) ? 0 : 8);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        FamilyMemberAdapter familyMemberAdapter = this.t;
        if (familyMemberAdapter != null) {
            familyMemberAdapter.b();
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("FamilyMemberActivity", "code=" + i + "str=" + str + ",mark=" + i2);
        I(str, new c());
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        Q(2);
        Q(1);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.p
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                FamilyMemberActivity.this.S();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.q
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                FamilyMemberActivity.this.U();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
        this.noOOMEditText.addTextChangedListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        FamilyMemberAdapter familyMemberAdapter = new FamilyMemberAdapter(this, this.r, this.s);
        this.t = familyMemberAdapter;
        this.autoListView.setAdapter((ListAdapter) familyMemberAdapter);
        this.noOOMEditText.setHint("搜索家族成员");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299023) {
            return;
        }
        Intent intent = new Intent((Context) this, (Class<?>) FamilyMemberManagerActivity.class);
        intent.putExtra("family_id", this.r);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_member_layout);
        ButterKnife.a(this);
        this.r = getIntent().getStringExtra("family_id");
        G(null, this.backLayout);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.w) {
            org.greenrobot.eventbus.c.c().q(this);
            this.w = false;
        }
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onReceiveMsg(EventMessage eventMessage) {
        FamilyMemberInfo.DataBean dataBean = null;
        int i = 0;
        while (true) {
            if (i >= this.s.size()) {
                i = -1;
                break;
            }
            dataBean = this.s.get(i);
            if (TextUtils.equals(dataBean.getUid(), eventMessage.uid)) {
                break;
            } else {
                i++;
            }
        }
        if (dataBean == null || i == -1) {
            return;
        }
        this.s.get(i).setNotename(eventMessage.mark);
        com.rtk.app.tool.b0.b.b().e(Integer.parseInt(this.s.get(i).getUid()), dataBean.getFollowed());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onStart() {
        super.onStart();
        if (this.w) {
            return;
        }
        org.greenrobot.eventbus.c.c().o(this);
        this.w = true;
    }
}
