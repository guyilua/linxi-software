package com.rtk.app.main.UpModule;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpSrcClickNumBean;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpClickSrcDataActivity extends BaseActivity implements h.j {
    private List<BaseFragment> q = new ArrayList();
    private List<String> r = new ArrayList();
    private int s = 0;
    private int t = 2539685;
    private Bundle u;

    @BindView
    TextView upSrcClickDataAllDownloadNum;

    @BindView
    LinearLayout upSrcClickDataAllLv;

    @BindView
    TabLayout upSrcClickDataTabLayout;

    @BindView
    TextView upSrcClickDataToday;

    @BindView
    TextView upSrcClickDataTopBack;

    @BindView
    LinearLayout upSrcClickDataTopLayout;

    @BindView
    ViewPager upSrcClickDataViewPage;

    @BindView
    LinearLayout upSrcParentLayout;

    @BindView
    TextView upTip;
    private UpSrcClickNumBean v;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        L(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upSrcClickDataTopLayout, this.upSrcClickDataTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.upSrcClickDataAllLv);
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("up/pv/count");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&up_id=");
            sb2.append(this.s);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "up_id=" + this.s, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb));
        com.rtk.app.tool.c0.u("UpClickSrcDataActivity", "" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("UpClickSrcDataActivity", "下载量等信息  " + str);
        this.v = (UpSrcClickNumBean) this.g.fromJson(str, UpSrcClickNumBean.class);
        this.upSrcClickDataToday.setText(this.v.getData().getToday() + "");
        this.upSrcClickDataAllDownloadNum.setText(this.v.getData().getTotal() + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("UpClickSrcDataActivity", "下载量等信息  " + str);
        if (i2 != 1) {
            return;
        }
        I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.p0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpClickSrcDataActivity.this.N(strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.u = extras;
        this.s = extras.getInt("up_id");
        L(1);
        this.r.add("7日");
        this.r.add("30日");
        this.r.add("60日");
        this.r.add("90日");
        for (int i = 0; i < 4; i++) {
            UpSrcClickDataFragment upSrcClickDataFragment = new UpSrcClickDataFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sid", this.s);
            if (i == 0) {
                bundle.putInt("range", 7);
            } else if (i == 1) {
                bundle.putInt("range", 30);
            } else if (i == 2) {
                bundle.putInt("range", 60);
            } else if (i == 3) {
                bundle.putInt("range", 90);
            }
            upSrcClickDataFragment.setArguments(bundle);
            this.q.add(upSrcClickDataFragment);
        }
        this.upSrcClickDataTabLayout.setupWithViewPager(this.upSrcClickDataViewPage, true);
        this.upSrcClickDataViewPage.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (this.s <= this.t) {
            this.upTip.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131301024) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_src_click_data);
        ButterKnife.a(this);
        LinearLayout linearLayout = this.upSrcParentLayout;
        G(linearLayout, linearLayout);
    }
}
