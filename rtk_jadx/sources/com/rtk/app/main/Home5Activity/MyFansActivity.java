package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.MyAttentionAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.MyAttentionBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyFansActivity extends BaseActivity implements h.j {

    @BindView
    TextView myFansTopBack;

    @BindView
    LinearLayout myFansTopLayout;

    @BindView
    AutoListView myPostFansListview;
    private List<MyAttentionBean.DataBean> q;
    private int r = 1;
    private MyAttentionAdapter s;
    private String t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            MyFansActivity.this.r = 1;
            MyFansActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            MyFansActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            MyFansActivity myFansActivity = MyFansActivity.this;
            com.rtk.app.tool.t.B0(myFansActivity.f147c, ((MyAttentionBean.DataBean) myFansActivity.q.get(i - 1)).getFans());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        N(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.myFansTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void N(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/fans");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(this.t);
            sb2.append("&page=");
            sb2.append(this.r);
            sb2.append("&limit=");
            sb2.append(this.myPostFansListview.getPageSize());
            sb2.append("&fans=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + this.t, "fans=" + com.rtk.app.tool.y.K()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.c0.u("MyFansActivity", "   请求" + com.rtk.app.tool.y.d + sb);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.myPostFansListview.k();
        com.rtk.app.tool.c0.u("MyFansActivity", "  我的粉丝列表  " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        MyAttentionBean myAttentionBean = (MyAttentionBean) create.fromJson(str, MyAttentionBean.class);
        if (this.r == 1) {
            this.q.clear();
        }
        this.q.addAll(myAttentionBean.getData());
        this.s.notifyDataSetChanged();
        this.myPostFansListview.setResultSize(myAttentionBean.getData().size());
        this.r++;
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        MyAttentionAdapter myAttentionAdapter = this.s;
        if (myAttentionAdapter != null) {
            myAttentionAdapter.b();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.r == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.r0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyFansActivity.this.P(strArr);
                }
            });
        }
        this.myPostFansListview.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.t = getIntent().getExtras().getString("uid");
        this.q = new ArrayList();
        this.myPostFansListview.setPageSize(20);
        N(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.myPostFansListview.setOnRefreshListener(new a());
        this.myPostFansListview.setOnLoadListener(new b());
        this.myPostFansListview.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        MyAttentionAdapter myAttentionAdapter = new MyAttentionAdapter(this.f147c, this.q);
        this.s = myAttentionAdapter;
        this.myPostFansListview.setAdapter((ListAdapter) myAttentionAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299445) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_fans);
        ButterKnife.a(this);
        G(null, this.myFansTopLayout);
    }
}
