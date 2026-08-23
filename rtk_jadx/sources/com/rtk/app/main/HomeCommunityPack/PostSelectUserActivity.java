package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
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
import com.sigmob.sdk.downloader.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSelectUserActivity extends BaseActivity implements h.j {

    @BindView
    AutoListView postSelectUserListView;

    @BindView
    TextView postSelectUserSearchBtu;

    @BindView
    EditText postSelectUserSearchEdit;

    @BindView
    TextView postSelectUserTips;

    @BindView
    TextView postSelectUserTopBack;

    @BindView
    LinearLayout postSelectUserTopLayout;
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
            PostSelectUserActivity.this.r = 1;
            PostSelectUserActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            PostSelectUserActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", (Serializable) PostSelectUserActivity.this.q.get(i - 1));
            intent.putExtras(bundle);
            PostSelectUserActivity.this.setResult(1005, intent);
            PostSelectUserActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        N(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postSelectUserTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void N(int... iArr) {
        String sb;
        if (this.r == 1) {
            G(null, this.postSelectUserTopLayout);
        }
        int i = iArr[0];
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/followsList");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&fans=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&page=");
            sb2.append(this.r);
            sb2.append("&limit=");
            sb2.append(this.postSelectUserListView.getPageSize());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "fans=" + com.rtk.app.tool.y.K()))));
            sb = sb2.toString();
        } else if (i != 2) {
            sb = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/userSearch");
            sb3.append(com.rtk.app.tool.y.u(this.f147c));
            sb3.append("&uname=");
            sb3.append(this.t);
            sb3.append("&page=");
            sb3.append(this.r);
            sb3.append("&issub=1&limit=");
            sb3.append(this.postSelectUserListView.getPageSize());
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.K());
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uname=" + this.t))));
            sb = sb3.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("PostSelectUserActivity", "我的关注" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.postSelectUserListView.k();
        com.rtk.app.tool.c0.u("PostSelectUserActivity", "  我的关注列表  " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1 || i == 2) {
            MyAttentionBean myAttentionBean = (MyAttentionBean) create.fromJson(str, MyAttentionBean.class);
            if (this.r == 1) {
                this.q.clear();
            }
            this.q.addAll(myAttentionBean.getData());
            this.s.notifyDataSetChanged();
            this.postSelectUserListView.setResultSize(myAttentionBean.getData().size());
            this.r++;
        }
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
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.g0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostSelectUserActivity.this.P(strArr);
                }
            });
        }
        this.postSelectUserListView.f();
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.postSelectUserListView.setPageSize(20);
        this.q = new ArrayList();
        N(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postSelectUserListView.setOnRefreshListener(new a());
        this.postSelectUserListView.setOnLoadListener(new b());
        this.postSelectUserListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        MyAttentionAdapter myAttentionAdapter = new MyAttentionAdapter(this.f147c, this.q);
        this.s = myAttentionAdapter;
        this.postSelectUserListView.setAdapter((ListAdapter) myAttentionAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131299914) {
            if (id != 2131299917) {
                return;
            }
            finish();
            return;
        }
        String trim = this.postSelectUserSearchEdit.getText().toString().trim();
        this.t = trim;
        if (com.rtk.app.tool.c0.q(trim)) {
            com.rtk.app.tool.f.a(this.f147c, "用户名为空", f.a.f);
        } else {
            this.r = 1;
            N(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_select_user);
        ButterKnife.a(this);
    }
}
