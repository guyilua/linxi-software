package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.Home5MyContributeBean;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5ContributeActivity extends BaseActivity implements h.j {

    @BindView
    AppBarLayout home5ContributeBar;

    @BindView
    TextView home5ContributeGoldNum;

    @BindView
    TabLayout home5ContributeTab;

    @BindView
    TextView home5ContributeTopBack;

    @BindView
    LinearLayout home5ContributeTopLayout;

    @BindView
    BaseViewPager home5ContributeViewpager;
    private List<Fragment> q;
    private List<String> r;
    private Home5MyContributeBean s;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.home5ContributeTopLayout, this.home5ContributeTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/myContributeList");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&type=0&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    public void M(Home5MyContributeBean home5MyContributeBean) {
        this.home5ContributeGoldNum.setText(home5MyContributeBean.getData().getContribute());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        Home5MyContributeBean home5MyContributeBean = (Home5MyContributeBean) this.g.fromJson(str, Home5MyContributeBean.class);
        this.s = home5MyContributeBean;
        M(home5MyContributeBean);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.q.add(new Home5MyContributeRuleFragment());
        this.q.add(new Home5MyContributeFragment());
        this.r.add("贡献值规则");
        this.r.add("贡献值明细");
        this.home5ContributeTab.setupWithViewPager(this.home5ContributeViewpager, true);
        this.home5ContributeViewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r));
        L(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297958) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home5_contribute);
        ButterKnife.a(this);
    }
}
