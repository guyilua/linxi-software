package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.Home5MyLevelBeanForDetailsBean;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyExperienceActivity extends BaseActivity implements h.j {

    @BindView
    AppBarLayout home5MyExperienceBar;

    @BindView
    RoundedImageView home5MyExperienceIcon;

    @BindView
    TextView home5MyExperienceLevel;

    @BindView
    CustomTextView home5MyExperienceNeedEx;

    @BindView
    TextView home5MyExperienceNextLevel;

    @BindView
    TextView home5MyExperienceNickName;

    @BindView
    CustomTextView home5MyExperienceNowEx;

    @BindView
    ProgressBar home5MyExperienceProgress;

    @BindView
    TabLayout home5MyExperienceTab;

    @BindView
    TextView home5MyExperienceTopBack;

    @BindView
    LinearLayout home5MyExperienceTopLayout;

    @BindView
    BaseViewPager home5MyExperienceViewpager;
    private List<Fragment> q;
    private List<String> r;
    private Home5MyLevelBeanForDetailsBean s;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.home5MyExperienceTopLayout, this.home5MyExperienceTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/myExperienceList");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&type=0&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    public void M(Home5MyLevelBeanForDetailsBean home5MyLevelBeanForDetailsBean) {
        com.rtk.app.tool.t.c(this.f147c, home5MyLevelBeanForDetailsBean.getData().getFace(), this.home5MyExperienceIcon, new boolean[0]);
        this.home5MyExperienceNickName.setText(home5MyLevelBeanForDetailsBean.getData().getNickname());
        this.home5MyExperienceLevel.setText(home5MyLevelBeanForDetailsBean.getData().getLevel());
        this.home5MyExperienceNextLevel.setText(home5MyLevelBeanForDetailsBean.getData().getNextLevel() + "");
        int parseInt = Integer.parseInt(home5MyLevelBeanForDetailsBean.getData().getExperience());
        int i = parseInt > 0 ? parseInt : 0;
        int nextExperience = home5MyLevelBeanForDetailsBean.getData().getNextExperience();
        this.home5MyExperienceProgress.setMax(i + nextExperience);
        this.home5MyExperienceProgress.setProgress(i);
        this.home5MyExperienceNowEx.setText(parseInt + "");
        this.home5MyExperienceNeedEx.setText(nextExperience + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("Home5MyExperienceActivity", "我的等级   ----   " + str);
        if (i != 1) {
            return;
        }
        Home5MyLevelBeanForDetailsBean home5MyLevelBeanForDetailsBean = (Home5MyLevelBeanForDetailsBean) this.g.fromJson(str, Home5MyLevelBeanForDetailsBean.class);
        this.s = home5MyLevelBeanForDetailsBean;
        M(home5MyLevelBeanForDetailsBean);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = new ArrayList();
        this.r = new ArrayList();
        Home5MyLevelFragment1 home5MyLevelFragment1 = new Home5MyLevelFragment1();
        Home5MyLevelFragment2 home5MyLevelFragment2 = new Home5MyLevelFragment2();
        this.q.add(home5MyLevelFragment1);
        this.q.add(home5MyLevelFragment2);
        this.r.add("经验值规则");
        this.r.add("经验值明细");
        this.home5MyExperienceTab.setupWithViewPager(this.home5MyExperienceViewpager, true);
        this.home5MyExperienceViewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r));
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
        if (view.getId() != 2131297991) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home5_my_experience);
        ButterKnife.a(this);
    }
}
