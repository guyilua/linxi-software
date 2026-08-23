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
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpExampleListActivity extends BaseActivity {

    @BindView
    TabLayout homeUpExampleListTablayout;

    @BindView
    TextView homeUpExampleListTopBack;

    @BindView
    MarkedImageView homeUpExampleListTopDownload;

    @BindView
    LinearLayout homeUpExampleListTopLayout;

    @BindView
    TextView homeUpExampleListTopSearchTv;

    @BindView
    BaseViewPager homeUpExampleListViewPager;
    private List<String> q;
    private List<BaseFragment> r;
    private List<String> s;
    private MyFragmentAdapter t;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.homeUpExampleListTopLayout, this.homeUpExampleListTablayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (int i = 0; i < this.r.size(); i++) {
            this.r.get(i).n();
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
            bundle.putString("url", "up/down-ranking");
            homeUpExampleListFragment.setArguments(bundle);
            this.r.add(homeUpExampleListFragment);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
        this.t = myFragmentAdapter;
        this.homeUpExampleListViewPager.setAdapter(myFragmentAdapter);
        this.homeUpExampleListTablayout.setupWithViewPager(this.homeUpExampleListViewPager, true);
        this.homeUpExampleListViewPager.setOffscreenPageLimit(this.q.size());
        this.b = new n(this.homeUpExampleListTopDownload);
        x.c().b(this.b);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.home_up_example_list_topBack /* 2131298141 */:
                finish();
                return;
            case com.rtk.app.R.id.home_up_example_list_topLayout /* 2131298142 */:
            default:
                return;
            case com.rtk.app.R.id.home_up_example_list_top_download /* 2131298143 */:
                t.o0(this.f147c);
                return;
            case com.rtk.app.R.id.home_up_example_list_top_search_tv /* 2131298144 */:
                t.h1(this.f147c);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home_up_example_list);
        ButterKnife.a(this);
    }
}
