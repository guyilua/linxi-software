package com.rtk.app.main.family;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.adapter.UpApkListAdapter;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.family.upAudit.FamilyUpCheckApkListActivity;
import com.rtk.app.main.family.upAudit.FamilyUpCommentAuditListActivity;
import com.rtk.app.tool.ApkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpActivity extends FamilyBaseActivity {

    @BindView
    LinearLayout auditLv;

    @BindView
    AutoListView autoListView;

    @BindView
    View backLayout;

    @BindView
    NoOOMEditText noOOMEditText;
    private UpApkListAdapter s;

    @BindView
    View searchHeadLayout;
    private String u;

    @BindView
    View upCommentLayout;

    @BindView
    TextView upCommentMessageNum;

    @BindView
    View upLayout;

    @BindView
    TextView upMessageNum;
    private String v;
    int r = 1;
    private List<UpApkListBean.DataBean> t = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.content.Context, com.rtk.app.main.family.FamilyUpActivity] */
        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            ?? r1 = FamilyUpActivity.this;
            com.rtk.app.tool.t.X0(r1, new ApkInfo((UpApkListBean.DataBean) ((FamilyUpActivity) r1).t.get(i - 1)));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FamilyUpActivity.this.u = editable.toString().replaceAll("&", "").trim();
            FamilyUpActivity familyUpActivity = FamilyUpActivity.this;
            familyUpActivity.r = 1;
            familyUpActivity.P(1);
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
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        this.r = 1;
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V() {
        P(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(int... iArr) {
        String str;
        int i = iArr[0];
        if (i != 1) {
            if (i == 2) {
                HashMap<String, String> l = com.rtk.app.tool.y.l();
                l.put("family_id", this.v);
                l.put("key", com.rtk.app.tool.t.L(l));
                com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/family-admin", l)));
                return;
            }
            if (i != 3) {
                return;
            }
            HashMap<String, String> l2 = com.rtk.app.tool.y.l();
            l2.put("family_id", this.v);
            l2.put("key", com.rtk.app.tool.t.L(l2));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/count/pending", 3, l2);
            return;
        }
        HashMap<String, String> k = com.rtk.app.tool.y.k();
        k.put("family_id", this.v);
        if (TextUtils.isEmpty(this.u)) {
            str = "family/up/list";
        } else {
            k.put("keyword", this.u);
            str = "family/up/search";
        }
        k.put(com.rtk.app.tool.y.z("uid"), com.rtk.app.tool.y.K());
        k.put(com.rtk.app.tool.y.z("token"), com.rtk.app.tool.y.H());
        k.put("$*$$*$page", this.r + "");
        k.put("key", com.rtk.app.tool.t.L(k));
        String w = com.rtk.app.tool.y.w(str, k);
        com.rtk.app.tool.c0.r("FamilyUpActivity", "url=" + w);
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2 A[Catch: all -> 0x0100, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:16:0x003f, B:18:0x0055, B:19:0x0069, B:21:0x0073, B:22:0x007a, B:23:0x005b, B:24:0x008a, B:26:0x00a2, B:31:0x00b2, B:32:0x00bf, B:34:0x00c5, B:36:0x00d5, B:38:0x00d9, B:39:0x00de), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[Catch: all -> 0x0100, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:16:0x003f, B:18:0x0055, B:19:0x0069, B:21:0x0073, B:22:0x007a, B:23:0x005b, B:24:0x008a, B:26:0x00a2, B:31:0x00b2, B:32:0x00bf, B:34:0x00c5, B:36:0x00d5, B:38:0x00d9, B:39:0x00de), top: B:2:0x0001 }] */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void d(java.lang.String r6, int r7) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rtk.app.main.family.FamilyUpActivity.d(java.lang.String, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("FamilyUpActivity", "code=" + i + "str=" + str + ",mark=" + i2);
        if (i2 != 1) {
            com.rtk.app.tool.f.a(this, str, ErrorCode.NETWORK_UNKNOWN);
        } else {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.a0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    FamilyUpActivity.this.R(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.autoListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.family.z
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                FamilyUpActivity.this.T();
            }
        });
        this.autoListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.family.b0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                FamilyUpActivity.this.V();
            }
        });
        this.autoListView.setOnItemClickListener(new a());
        this.noOOMEditText.addTextChangedListener(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        UpApkListAdapter upApkListAdapter = new UpApkListAdapter(this, this.t);
        this.s = upApkListAdapter;
        this.autoListView.setAdapter((ListAdapter) upApkListAdapter);
        this.noOOMEditText.setHint("搜索家族UP");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("family_id", this.v);
        int id = view.getId();
        if (id == 2131299962) {
            com.rtk.app.tool.t.d1(this, this.v);
        } else if (id == 2131300843) {
            com.rtk.app.tool.c.b(this.f147c, FamilyUpCommentAuditListActivity.class, bundle);
        } else {
            if (id != 2131300966) {
                return;
            }
            com.rtk.app.tool.c.b(this.f147c, FamilyUpCheckApkListActivity.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_up_layout);
        ButterKnife.a(this);
        this.v = getIntent().getStringExtra("family_id");
        G(null, this.backLayout);
        P(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        P(1);
    }
}
