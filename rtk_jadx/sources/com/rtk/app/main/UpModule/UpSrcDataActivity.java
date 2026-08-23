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
import com.rtk.app.bean.UpSrcNumBean;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpSrcDataActivity extends BaseActivity implements h.j {
    private List<BaseFragment> q = new ArrayList();
    private List<String> r = new ArrayList();
    private int s = 0;
    private Bundle t;
    private UpSrcNumBean u;

    @BindView
    TextView upSrcDataAllDownloadNum;

    @BindView
    LinearLayout upSrcDataAllLv;

    @BindView
    TabLayout upSrcDataTabLayout;

    @BindView
    TextView upSrcDataToday;

    @BindView
    TextView upSrcDataTopBack;

    @BindView
    LinearLayout upSrcDataTopLayout;

    @BindView
    ViewPager upSrcDataViewPage;

    @BindView
    LinearLayout upSrcParentLayout;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            UpSrcDataActivity.this.L(1);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upSrcDataTopLayout, this.upSrcDataTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.upSrcDataAllLv);
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/downRankingCount");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&sid=");
            sb2.append(this.s);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "sid=" + this.s, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("UpSrcDataActivity", "" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("UpSrcDataActivity", "下载量等信息  " + str);
        this.u = (UpSrcNumBean) this.g.fromJson(str, UpSrcNumBean.class);
        this.upSrcDataToday.setText(this.u.getData().getTodayhits() + "");
        this.upSrcDataAllDownloadNum.setText(this.u.getData().getYearhits() + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("UpSrcDataActivity", "下载量等信息  " + str);
        if (i2 != 1) {
            return;
        }
        I(str, new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.t = extras;
        this.s = extras.getInt("sid");
        this.t.getInt("allNum");
        this.t.getInt("toDayDown");
        L(1);
        this.r.add("7日");
        this.r.add("30日");
        this.r.add("60日");
        this.r.add("90日");
        for (int i = 0; i < 4; i++) {
            UpSrcDataFragment upSrcDataFragment = new UpSrcDataFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sid", this.s);
            if (i == 0) {
                bundle.putInt("position", 7);
            } else if (i == 1) {
                bundle.putInt("position", 30);
            } else if (i == 2) {
                bundle.putInt("position", 60);
            } else if (i == 3) {
                bundle.putInt("position", 90);
            }
            upSrcDataFragment.setArguments(bundle);
            this.q.add(upSrcDataFragment);
        }
        this.upSrcDataTabLayout.setupWithViewPager(this.upSrcDataViewPage, true);
        this.upSrcDataViewPage.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131301033) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_src_data);
        ButterKnife.a(this);
        LinearLayout linearLayout = this.upSrcParentLayout;
        G(linearLayout, linearLayout);
    }
}
