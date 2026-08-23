package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.MyAttentionAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AddAttentionActivity extends BaseActivity implements h.j {

    @BindView
    EditText addAttentionEdv;

    @BindView
    TextView addAttentionEnsure;

    @BindView
    TextView addAttentionForMyAttention;

    @BindView
    AutoListView addAttentionListview;

    @BindView
    TextView addAttentionTopBack;

    @BindView
    LinearLayout addAttentionTopLayout;
    private List<MyAttentionBean.DataBean> s;
    private MyAttentionAdapter t;
    private int q = 1;
    String r = "";
    private boolean u = false;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            AddAttentionActivity addAttentionActivity = AddAttentionActivity.this;
            com.rtk.app.tool.t.B0(addAttentionActivity.f147c, ((MyAttentionBean.DataBean) addAttentionActivity.s.get(i - 1)).getFans());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(String[] strArr) {
        M(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q() {
        this.q = 1;
        if (this.u) {
            M(2);
        } else {
            M(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S() {
        if (this.u) {
            M(2);
        } else {
            M(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean U(TextView textView, int i, KeyEvent keyEvent) {
        this.q = 1;
        this.r = this.addAttentionEdv.getText().toString().trim();
        if (this.u) {
            M(2);
        } else {
            M(1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W() {
        this.addAttentionEdv.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f147c.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.addAttentionEdv, 0);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.addAttentionTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String sb;
        if (this.q == 1) {
            G(null, this.addAttentionTopLayout);
        }
        int i = iArr[0];
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/userSearch");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uname=");
            sb2.append(this.r);
            sb2.append("&page=");
            sb2.append(this.q);
            sb2.append("&limit=");
            sb2.append(this.addAttentionListview.getPageSize());
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uname=" + this.r))));
            sb = sb2.toString();
            this.addAttentionForMyAttention.setVisibility(0);
        } else if (i != 2) {
            sb = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/userSearch");
            sb3.append(com.rtk.app.tool.y.u(this.f147c));
            sb3.append("&uname=");
            sb3.append(this.r);
            sb3.append("&page=");
            sb3.append(this.q);
            sb3.append("&issub=1&limit=");
            sb3.append(this.addAttentionListview.getPageSize());
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.K());
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uname=" + this.r))));
            sb = sb3.toString();
            this.addAttentionForMyAttention.setVisibility(8);
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("AddAttentionActivity", "搜索用户  " + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.addAttentionListview.k();
        com.rtk.app.tool.c0.u("AddAttentionActivity", "搜索用户" + str);
        if (i == 1 || i == 2) {
            MyAttentionBean myAttentionBean = (MyAttentionBean) this.g.fromJson(str, MyAttentionBean.class);
            if (this.q == 1) {
                this.s.clear();
            }
            this.s.addAll(myAttentionBean.getData());
            this.t.notifyDataSetChanged();
            this.addAttentionListview.setResultSize(myAttentionBean.getData().size());
            this.q++;
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        MyAttentionAdapter myAttentionAdapter = this.t;
        if (myAttentionAdapter != null) {
            myAttentionAdapter.b();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.q == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.c
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    AddAttentionActivity.this.O(strArr);
                }
            });
        }
        this.addAttentionListview.f();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.addAttentionListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.f
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                AddAttentionActivity.this.Q();
            }
        });
        this.addAttentionListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.Home5Activity.e
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                AddAttentionActivity.this.S();
            }
        });
        this.addAttentionListview.setOnItemClickListener(new a());
        this.addAttentionEdv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.rtk.app.main.Home5Activity.d
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return AddAttentionActivity.this.U(textView, i, keyEvent);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.s = new ArrayList();
        this.addAttentionListview.setPageSize(20);
        this.t = new MyAttentionAdapter(this.f147c, this.s);
        this.addAttentionListview.setResultSize(0);
        this.addAttentionListview.setAdapter((ListAdapter) this.t);
        this.addAttentionEdv.post(new Runnable() { // from class: com.rtk.app.main.Home5Activity.b
            @Override // java.lang.Runnable
            public final void run() {
                AddAttentionActivity.this.W();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.add_attention_ensure /* 2131296417 */:
                this.q = 1;
                this.r = this.addAttentionEdv.getText().toString().trim();
                this.u = false;
                M(1);
                return;
            case com.rtk.app.R.id.add_attention_for_myAttention /* 2131296418 */:
                this.q = 1;
                this.r = this.addAttentionEdv.getText().toString().trim();
                this.u = true;
                M(2);
                return;
            case com.rtk.app.R.id.add_attention_listview /* 2131296419 */:
            default:
                return;
            case com.rtk.app.R.id.add_attention_topBack /* 2131296420 */:
                finish();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_add_attention);
        ButterKnife.a(this);
    }
}
