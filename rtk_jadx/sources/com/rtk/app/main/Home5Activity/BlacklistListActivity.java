package com.rtk.app.main.Home5Activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.BlacklistListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.BlacklistListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.OtherImfomationPack.OtherPersonerImformationActivity;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class BlacklistListActivity extends BaseActivity implements h.j {

    @BindView
    TextView blacklistListBack;

    @BindView
    LinearLayout blacklistListBackLv;

    @BindView
    AutoListView blacklistListview;
    private Context q;
    private int r = 1;
    private List<BlacklistListBean.DataDTO> s = new ArrayList();
    private BlacklistListAdapter t;
    private int u;
    private String v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = i - 1;
            BlacklistListActivity.this.u = i2;
            Bundle bundle = new Bundle();
            bundle.putString("fans", ((BlacklistListBean.DataDTO) BlacklistListActivity.this.s.get(i2)).getUid());
            Intent intent = new Intent(BlacklistListActivity.this.q, (Class<?>) OtherPersonerImformationActivity.class);
            intent.putExtras(bundle);
            BlacklistListActivity.this.startActivityForResult(intent, 1030);
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
        O(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U() {
        this.r = 1;
        O(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.blacklistListBackLv, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void O(int... iArr) {
        String w;
        if (iArr[0] != 1) {
            w = "";
        } else if (TextUtils.isEmpty(this.v)) {
            StringBuilder sb = new StringBuilder();
            sb.append("user/blacklist");
            sb.append(com.rtk.app.tool.y.u(this.f147c));
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&token=");
            sb.append(com.rtk.app.tool.y.H());
            sb.append("&page=");
            sb.append(this.r);
            sb.append("&limit=");
            sb.append(10);
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "token=" + com.rtk.app.tool.y.H(), "uid=" + com.rtk.app.tool.y.K()))));
            w = sb.toString();
        } else {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("family_id", this.v);
            l.put("key", com.rtk.app.tool.t.L(l));
            w = com.rtk.app.tool.y.w("family/user/blacklist", l);
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
        com.rtk.app.tool.c0.u("BlacklistListActivity", "黑名单列表 链接" + com.rtk.app.tool.y.e + w);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("BlacklistListActivity", "黑名单列表success:" + str);
        this.blacklistListview.k();
        BlacklistListBean blacklistListBean = (BlacklistListBean) this.g.fromJson(str, BlacklistListBean.class);
        if (blacklistListBean.getCode() != 0 || blacklistListBean.getData() == null) {
            return;
        }
        if (this.r == 1) {
            this.s.clear();
        }
        this.s.addAll(blacklistListBean.getData());
        this.t.notifyDataSetChanged();
        this.blacklistListview.setResultSize(blacklistListBean.getData().size());
        this.r++;
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("BlacklistListActivity", "黑名单列表error:" + str);
        if (i2 != 1) {
            return;
        }
        this.blacklistListview.f();
        if (this.r == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.g
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    BlacklistListActivity.this.Q(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.blacklistListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.Home5Activity.i
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                BlacklistListActivity.this.S();
            }
        });
        this.blacklistListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.h
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                BlacklistListActivity.this.U();
            }
        });
        this.blacklistListview.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (!TextUtils.isEmpty(this.v)) {
            this.blacklistListBack.setText(com.rtk.app.R.string.family_black_manager);
        }
        this.blacklistListview.setPageSize(10);
        O(1);
        BlacklistListAdapter blacklistListAdapter = new BlacklistListAdapter(this.q, this.s, this.v);
        this.t = blacklistListAdapter;
        this.blacklistListview.setAdapter((ListAdapter) blacklistListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1030) {
            this.s.get(this.u).setBlacklist(intent.getExtras().getBoolean("isBlacklist"));
            this.t.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296798) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_blacklist_list);
        ButterKnife.a(this);
        this.q = this;
        this.v = getIntent().getStringExtra("family_id");
    }
}
