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
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpSrcListActivity extends BaseActivity implements h.j {

    @BindView
    TabLayout homeUpSrcListTablayout;

    @BindView
    TextView homeUpSrcListTopBack;

    @BindView
    LinearLayout homeUpSrcListTopLayout;

    @BindView
    BaseViewPager homeUpSrcListViewPager;
    private List<String> q;
    private List<String> r;
    private List<BaseFragment> s;
    private MyFragmentAdapter t;
    private String u;
    private String v;
    private String w;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.homeUpSrcListTopLayout, this.homeUpSrcListTablayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.u = extras.getString(com.umeng.analytics.pro.d.y);
        this.v = extras.getString("tags");
        this.w = extras.getString("typeName");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.homeUpSrcListTopBack.setText(this.w);
        this.q = new ArrayList();
        this.s = new ArrayList();
        this.r = new ArrayList();
        this.q.add("热度");
        this.q.add("最新");
        this.q.add("热门");
        this.r.add("recommonds");
        this.r.add("new");
        this.r.add("hot");
        for (int i = 0; i < this.q.size(); i++) {
            HomeUpSrcListFragemnt homeUpSrcListFragemnt = new HomeUpSrcListFragemnt();
            Bundle bundle = new Bundle();
            bundle.putString(com.umeng.analytics.pro.d.y, this.u);
            bundle.putString("tags", this.v);
            bundle.putString("model", this.r.get(i));
            homeUpSrcListFragemnt.setArguments(bundle);
            this.s.add(homeUpSrcListFragemnt);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.s, this.q);
        this.t = myFragmentAdapter;
        this.homeUpSrcListViewPager.setAdapter(myFragmentAdapter);
        this.homeUpSrcListTablayout.setupWithViewPager(this.homeUpSrcListViewPager, true);
        this.homeUpSrcListViewPager.setCurrentItem(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298159) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home_up_src_list);
        ButterKnife.a(this);
    }
}
