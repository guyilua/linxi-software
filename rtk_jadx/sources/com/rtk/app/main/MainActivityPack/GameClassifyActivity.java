package com.rtk.app.main.MainActivityPack;

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
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class GameClassifyActivity extends BaseActivity {

    @BindView
    TabLayout gameClassifyTagLayout;

    @BindView
    TextView gameClassifyTopBack;

    @BindView
    LinearLayout gameClassifyTopLayout;

    @BindView
    ViewPager gameClassifyViewPager;
    private List<String> q;
    private List<BaseFragment> r;
    private MyFragmentAdapter s;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.gameClassifyTopLayout, this.gameClassifyTagLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        arrayList.add("详细分类");
        this.q.add("经典分类");
        HomeParticularGameClassifyFragment homeParticularGameClassifyFragment = new HomeParticularGameClassifyFragment();
        HomeClassicsGameClassifyFragment homeClassicsGameClassifyFragment = new HomeClassicsGameClassifyFragment();
        ArrayList arrayList2 = new ArrayList();
        this.r = arrayList2;
        arrayList2.add(homeParticularGameClassifyFragment);
        this.r.add(homeClassicsGameClassifyFragment);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
        this.s = myFragmentAdapter;
        this.gameClassifyViewPager.setAdapter(myFragmentAdapter);
        this.gameClassifyTagLayout.setupWithViewPager(this.gameClassifyViewPager, true);
        this.gameClassifyViewPager.setOffscreenPageLimit(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297637) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_game_classify);
        ButterKnife.a(this);
    }
}
