package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.UpSrcListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.UpModule.UpApkListActivity;
import com.rtk.app.main.UpModule.UpLoadPoolControlActivity;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyUpSrcActivity extends BaseActivity implements h.j {

    @BindView
    TextView home5MyUpSrcCopyUrl;

    @BindView
    AutoListView home5MyUpSrcListView;

    @BindView
    TextView home5MyUpSrcShareAllUp;

    @BindView
    LinearLayout home5MyUpSrcShareLv;

    @BindView
    RadioGroup home5MyUpSrcShowStyle;

    @BindView
    RadioButton home5MyUpSrcShowStyleAll;

    @BindView
    RadioButton home5MyUpSrcShowStyleNoDelete;

    @BindView
    TextView home5MyUpSrcTopBack;

    @BindView
    LinearLayout home5MyUpSrcTopLayout;

    @BindView
    MarkedImageView home5MyUpSrcTopMyUpLoading;

    @BindView
    TextView home5MyUpSrcTopResLibrary;

    @BindView
    ImageView home5MyUpSrcUpBtu;
    private UpSrcListAdapter r;
    private List<UpApkListBean.DataBean> s;
    private com.rtk.app.main.UpModule.UpControlPack.c.b u;
    private int q = 1;
    private String t = "&issub=1";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            Home5MyUpSrcActivity home5MyUpSrcActivity = Home5MyUpSrcActivity.this;
            com.rtk.app.tool.t.X0(home5MyUpSrcActivity.f147c, new ApkInfo((UpApkListBean.DataBean) home5MyUpSrcActivity.s.get(i - 1)));
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
        M(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S() {
        M(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(RadioGroup radioGroup, int i) {
        this.t = i == 2131298015 ? "" : "&issub=1";
        this.q = 1;
        M(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.home5MyUpSrcTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/mySourceList");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&page=");
            sb2.append(this.q);
            sb2.append("&limit=10");
            sb2.append(this.t);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("Home5MyUpSrcActivity", "我的上传接口  " + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.home5MyUpSrcListView.k();
        if (i != 1) {
            return;
        }
        UpApkListBean upApkListBean = (UpApkListBean) this.g.fromJson(str, UpApkListBean.class);
        this.r.notifyDataSetChanged();
        if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
            return;
        }
        if (this.q == 1) {
            this.s.clear();
        }
        this.q++;
        this.s.addAll(upApkListBean.getData());
        this.r.notifyDataSetChanged();
        this.home5MyUpSrcListView.setResultSize(upApkListBean.getData().size());
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        new Throwable().printStackTrace();
        com.rtk.app.tool.c0.u("Home5MyUpSrcActivity", "finish");
        this.r.b();
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().c(this.u);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.q == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.v
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    Home5MyUpSrcActivity.this.O(strArr);
                }
            });
        }
        this.home5MyUpSrcListView.f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.s = new ArrayList();
        UpSrcListAdapter upSrcListAdapter = new UpSrcListAdapter(this.f147c, this.s, UpSrcListAdapter.c.MyUpApk);
        this.r = upSrcListAdapter;
        this.home5MyUpSrcListView.setAdapter((ListAdapter) upSrcListAdapter);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("upNum");
            int i = extras.getInt("notificationId");
            if (!com.rtk.app.tool.c0.q(string)) {
                this.home5MyUpSrcTopBack.setText("我的上传(" + string + ")");
            }
            com.rtk.app.main.UpModule.UpHolderTool.b.a(this.f147c).c(i);
        }
        M(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.home5MyUpSrcListView.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.u
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                Home5MyUpSrcActivity.this.Q();
            }
        });
        this.home5MyUpSrcListView.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.Home5Activity.t
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                Home5MyUpSrcActivity.this.S();
            }
        });
        this.home5MyUpSrcListView.setOnItemClickListener(new a());
        this.home5MyUpSrcShowStyle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.Home5Activity.w
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                Home5MyUpSrcActivity.this.U(radioGroup, i);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.u = new com.rtk.app.main.UpModule.UpControlPack.c.b(this.home5MyUpSrcTopMyUpLoading);
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().a(this.u);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.home5_my_up_src_copy_url /* 2131298009 */:
                com.rtk.app.tool.t.I1(this.f147c, "http://a.ruansky.com/myup/" + com.rtk.app.tool.y.I(this.f147c) + "/");
                return;
            case com.rtk.app.R.id.home5_my_up_src_share_all_up /* 2131298012 */:
                String str = "http://a.ruansky.com/myup/" + com.rtk.app.tool.y.I(this.f147c) + "/";
                LoginBean.DataBean data = MainActivity.p.getData();
                com.rtk.app.tool.t.b2(this.f147c, str, data.getNickname(), data.getFace(), "这是" + data.getNickname() + "在软天空发布的UP资源");
                return;
            case com.rtk.app.R.id.home5_my_up_src_top_back /* 2131298017 */:
                finish();
                return;
            case com.rtk.app.R.id.home5_my_up_src_top_my_up_loading /* 2131298019 */:
                com.rtk.app.tool.c.b(this.f147c, UpLoadPoolControlActivity.class, null);
                return;
            case com.rtk.app.R.id.home5_my_up_src_top_resLibrary /* 2131298020 */:
                com.rtk.app.tool.c.b(this.f147c, UpApkListActivity.class, null);
                return;
            case com.rtk.app.R.id.home5_my_up_src_upBtu /* 2131298021 */:
                com.rtk.app.tool.t.e2(this.f147c, view);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home5_my_up_src);
        ButterKnife.a(this);
        G(null, this.home5MyUpSrcTopLayout);
    }
}
