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
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpChoicenessForExpertActivity extends BaseActivity {

    @BindView
    TabLayout homeUpChoicenessForExpertTablayout;

    @BindView
    TextView homeUpChoicenessForExpertTopBack;

    @BindView
    LinearLayout homeUpChoicenessForExpertTopLayout;

    @BindView
    BaseViewPager homeUpChoicenessForExpertViewPager;
    private List<String> q;
    private List<BaseFragment> r;
    private MyFragmentAdapter s;
    private List<String> t;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.homeUpChoicenessForExpertTopLayout, this.homeUpChoicenessForExpertTablayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
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
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = new ArrayList();
        this.t = new ArrayList();
        this.r = new ArrayList();
        this.t.add("近一天");
        this.t.add("近一周");
        this.t.add("近一月");
        this.t.add("近三月");
        this.q.add("yesterday");
        this.q.add("week");
        this.q.add("month");
        this.q.add("quarter");
        for (int i = 0; i < this.q.size(); i++) {
            HomeUpExpertFragment homeUpExpertFragment = new HomeUpExpertFragment();
            Bundle bundle = new Bundle();
            bundle.putString("dayType", this.q.get(i));
            homeUpExpertFragment.setArguments(bundle);
            this.r.add(homeUpExpertFragment);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.t);
        this.s = myFragmentAdapter;
        this.homeUpChoicenessForExpertViewPager.setAdapter(myFragmentAdapter);
        this.homeUpChoicenessForExpertTablayout.setupWithViewPager(this.homeUpChoicenessForExpertViewPager, true);
        this.homeUpChoicenessForExpertViewPager.setOffscreenPageLimit(this.t.size());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298090) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home_up_choiceness_for_expert);
        ButterKnife.a(this);
    }
}
