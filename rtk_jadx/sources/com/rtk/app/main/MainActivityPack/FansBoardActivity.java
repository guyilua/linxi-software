package com.rtk.app.main.MainActivityPack;

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
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FansBoardActivity extends BaseActivity {

    @BindView
    TabLayout fansBoardTabLayout;

    @BindView
    TextView fansBoardTopBack;

    @BindView
    LinearLayout fansBoardTopLayout;

    @BindView
    BaseViewPager fansBoardViewPager;
    private List<BaseFragment> q;
    private MyFragmentAdapter r;
    private List<String> s;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.fansBoardTopLayout, this.fansBoardTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (int i = 0; i < this.q.size(); i++) {
            this.q.get(i).n();
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
        this.s = new ArrayList();
        this.q = new ArrayList();
        this.s.add("近一天");
        this.s.add("近一周");
        this.s.add("近一月");
        this.s.add("近三月");
        this.s.add("牛人");
        for (int i = 1; i <= this.s.size(); i++) {
            FansBoardFragment fansBoardFragment = new FansBoardFragment();
            Bundle bundle = new Bundle();
            bundle.putString("dayType", i + "");
            fansBoardFragment.setArguments(bundle);
            this.q.add(fansBoardFragment);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.s);
        this.r = myFragmentAdapter;
        this.fansBoardViewPager.setAdapter(myFragmentAdapter);
        this.fansBoardTabLayout.setupWithViewPager(this.fansBoardViewPager, true);
        this.fansBoardViewPager.setOffscreenPageLimit(this.s.size());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297562) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.fans_board_layout);
        ButterKnife.a(this);
    }
}
