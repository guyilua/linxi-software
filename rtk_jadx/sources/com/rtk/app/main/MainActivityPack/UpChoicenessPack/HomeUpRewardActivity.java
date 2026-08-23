package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.tool.DownLoadTool.n;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpRewardActivity extends BaseActivity implements h.j {

    @BindView
    TabLayout homeUpRewardTablayout;

    @BindView
    TextView homeUpRewardTopBack;

    @BindView
    MarkedImageView homeUpRewardTopDownload;

    @BindView
    LinearLayout homeUpRewardTopLayout;

    @BindView
    TextView homeUpRewardTopSearchTv;

    @BindView
    BaseViewPager homeUpRewardViewPager;
    private List<String> q;
    private List<BaseFragment> r;
    private List<String> s;
    private MyFragmentAdapter t;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.homeUpRewardTopLayout, this.homeUpRewardTablayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        c0.u("HomeUpRewardActivity", "  打赏榜    " + str);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        if (this.b != null) {
            x.c().n(this.b);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            this.r.get(i3).n();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = new ArrayList();
        this.q = new ArrayList();
        this.s = new ArrayList();
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q.add("今日排行");
        this.q.add("昨日排行");
        this.q.add("周排行");
        this.q.add("月排行");
        this.q.add("季排行");
        this.s.add("today");
        this.s.add("yesterday");
        this.s.add("week");
        this.s.add("month");
        this.s.add("quarter");
        for (int i = 0; i < this.s.size(); i++) {
            HomeUpExampleListFragment homeUpExampleListFragment = new HomeUpExampleListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("dayType", this.s.get(i));
            bundle.putString("url", "up/reward-ranking");
            homeUpExampleListFragment.setArguments(bundle);
            this.r.add(homeUpExampleListFragment);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
        this.t = myFragmentAdapter;
        this.homeUpRewardViewPager.setAdapter(myFragmentAdapter);
        this.homeUpRewardTablayout.setupWithViewPager(this.homeUpRewardViewPager, true);
        this.homeUpRewardViewPager.setOffscreenPageLimit(this.q.size());
        this.b = new n(this.homeUpRewardTopDownload);
        x.c().b(this.b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.home_up_reward_topBack /* 2131298153 */:
                finish();
                return;
            case com.rtk.app.R.id.home_up_reward_topLayout /* 2131298154 */:
            default:
                return;
            case com.rtk.app.R.id.home_up_reward_top_download /* 2131298155 */:
                t.o0(this.f147c);
                return;
            case com.rtk.app.R.id.home_up_reward_top_search_tv /* 2131298156 */:
                t.h1(this.f147c);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home_up_reward);
        ButterKnife.a(this);
    }
}
