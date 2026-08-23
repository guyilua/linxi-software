package com.rtk.app.main.Home5Activity;

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
public class MyCollectActivity extends BaseActivity implements h.j {

    @BindView
    TextView muCollectBack;

    @BindView
    LinearLayout muCollectTopLayout;

    @BindView
    TabLayout myCollectTabLayout;

    @BindView
    ViewPager myCollectViewpager;
    private Context q;
    private List<Fragment> r;
    private List<String> s;
    private MyCollectFragmentForGame t;
    private MyCollectFragmentForPost u;
    private MyCollectFragmentForUp v;
    private int w;
    private int x;
    private int y;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.muCollectTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        MyCollectFragmentForGame myCollectFragmentForGame = this.t;
        if (myCollectFragmentForGame != null) {
            myCollectFragmentForGame.n();
        }
        MyCollectFragmentForUp myCollectFragmentForUp = this.v;
        if (myCollectFragmentForUp != null) {
            myCollectFragmentForUp.n();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.w = Integer.parseInt(extras.getString("gameNum"));
        this.x = Integer.parseInt(extras.getString("collectNum"));
        this.y = Integer.parseInt(extras.getString("upCollectNum"));
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new MyCollectFragmentForGame();
        this.u = new MyCollectFragmentForPost();
        this.v = new MyCollectFragmentForUp();
        this.r.add(this.t);
        this.r.add(this.u);
        this.r.add(this.v);
        this.s.add("游戏(" + this.w + ")");
        this.s.add("帖子(" + this.x + ")");
        this.s.add("Up资源(" + this.y + ")");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.s);
        this.myCollectTabLayout.setupWithViewPager(this.myCollectViewpager, true);
        this.myCollectViewpager.setAdapter(myFragmentAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299402) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_collect);
        ButterKnife.a(this);
        this.q = this;
        L(new int[0]);
    }
}
