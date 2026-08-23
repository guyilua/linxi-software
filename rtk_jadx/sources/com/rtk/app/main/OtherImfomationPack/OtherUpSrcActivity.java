package com.rtk.app.main.OtherImfomationPack;

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
import com.rtk.app.adapter.UpApkListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.main.UpModule.UpApkListActivity;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherUpSrcActivity extends BaseActivity implements h.j {

    @BindView
    AutoListView otherUpSrcListView;

    @BindView
    TextView otherUpSrcTopBack;

    @BindView
    LinearLayout otherUpSrcTopLayout;

    @BindView
    TextView otherUpSrcTopResLibrary;
    private String q;
    private int r = 1;
    private UpApkListAdapter s;
    private List<UpApkListBean.DataBean> t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            OtherUpSrcActivity.this.r = 1;
            OtherUpSrcActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            OtherUpSrcActivity.this.N(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            OtherUpSrcActivity otherUpSrcActivity = OtherUpSrcActivity.this;
            com.rtk.app.tool.t.X0(otherUpSrcActivity.f147c, new ApkInfo((UpApkListBean.DataBean) otherUpSrcActivity.t.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        N(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.otherUpSrcTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void N(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("user/up/list");
            sb2.append(y.u(this.f147c));
            sb2.append("&tuid=");
            sb2.append(this.q);
            sb2.append("&uid=");
            sb2.append(y.K());
            sb2.append("&token=");
            sb2.append(y.H());
            sb2.append("&page=");
            sb2.append(this.r);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "tuid=" + this.q))));
            sb = sb2.toString();
        }
        c0.u("OtherUpSrcActivity", "他的上传  " + y.d + sb);
        com.rtk.app.tool.o.h.l(this.f147c, this, 1, com.rtk.app.tool.o.h.h(y.e).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.otherUpSrcListView.k();
        if (i != 1) {
            return;
        }
        c0.a("OtherUpSrcActivity", "  我的上传资源  " + str, 4, new Level[0]);
        UpApkListBean upApkListBean = (UpApkListBean) this.g.fromJson(str, UpApkListBean.class);
        this.s.notifyDataSetChanged();
        if (upApkListBean.getCode() != 0 || upApkListBean.getData() == null) {
            return;
        }
        if (this.r == 1) {
            this.t.clear();
        }
        this.r++;
        this.t.addAll(upApkListBean.getData());
        this.s.notifyDataSetChanged();
        this.otherUpSrcListView.setResultSize(upApkListBean.getData().size());
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        UpApkListAdapter upApkListAdapter = this.s;
        if (upApkListAdapter != null) {
            upApkListAdapter.b();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.otherUpSrcListView.f();
        if (this.r == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.u
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherUpSrcActivity.this.P(strArr);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.q = extras.getString("uid");
        extras.getString("otherNickName");
        extras.getString("upNum");
        N(1);
        this.t = new ArrayList();
        UpApkListAdapter upApkListAdapter = new UpApkListAdapter(this.f147c, this.t);
        this.s = upApkListAdapter;
        this.otherUpSrcListView.setAdapter((ListAdapter) upApkListAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.otherUpSrcListView.setOnRefreshListener(new a());
        this.otherUpSrcListView.setOnLoadListener(new b());
        this.otherUpSrcListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299697) {
            finish();
        } else {
            if (id != 2131299699) {
                return;
            }
            com.rtk.app.tool.c.b(this.f147c, UpApkListActivity.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_other_up_src);
        ButterKnife.a(this);
    }
}
