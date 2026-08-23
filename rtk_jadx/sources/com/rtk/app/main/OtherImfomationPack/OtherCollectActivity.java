package com.rtk.app.main.OtherImfomationPack;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCollectActivity extends BaseActivity implements h.j {

    @BindView
    TextView otherCollectBack;

    @BindView
    TabLayout otherCollectTabLayout;

    @BindView
    LinearLayout otherCollectTopLayout;

    @BindView
    ViewPager otherCollectViewpager;
    private Context q;
    private List<Fragment> r;
    private List<String> s;
    private OtherCollectFragmentForGame t;
    private OtherCollectFragmentForPost u;
    private String v;
    private String w;
    private String x;
    private OtherCollectFragmentForUpSrc y;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.otherCollectTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.t.n();
        this.y.n();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        extras.getString("uid");
        this.v = extras.getString("gameNum");
        this.w = extras.getString("postcollectNum");
        this.x = extras.getString("upCollectNum");
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new OtherCollectFragmentForGame();
        this.u = new OtherCollectFragmentForPost();
        this.y = new OtherCollectFragmentForUpSrc();
        this.t.setArguments(extras);
        this.u.setArguments(extras);
        this.y.setArguments(extras);
        this.r.add(this.t);
        this.r.add(this.u);
        this.r.add(this.y);
        this.s.add("游戏(" + this.v + ")");
        this.s.add("帖子(" + this.w + ")");
        this.s.add("up资源(" + this.x + ")");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.s);
        this.otherCollectTabLayout.setupWithViewPager(this.otherCollectViewpager, true);
        this.otherCollectViewpager.setAdapter(myFragmentAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299646) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_other_collect);
        ButterKnife.a(this);
        this.q = this;
        L(new int[0]);
    }
}
