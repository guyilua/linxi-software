package com.rtk.app.main.Home5Activity;

import android.R;
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
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCommentActivity extends BaseActivity implements h.j {

    @BindView
    TabLayout myCommentTagLayout;

    @BindView
    TextView myCommentTopBack;

    @BindView
    LinearLayout myCommentTopLayout;

    @BindView
    ViewPager myCommentViewPager;
    private List<Fragment> q;
    private List<String> r;
    private MyCommentForGameFragment s;
    private MyCommentForUpApkFragment t;
    private MyFragmentAdapter u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (i == 0 && MyCommentActivity.this.s.v() == 0) {
                MyHorizontalScrollView.b = false;
            } else {
                MyHorizontalScrollView.b = true;
            }
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.myCommentTopLayout, this.myCommentTagLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new MyCommentForGameFragment();
        this.t = new MyCommentForUpApkFragment();
        this.r.add("游戏评论");
        this.r.add("up资源评论");
        this.q.add(this.s);
        this.q.add(this.t);
        this.myCommentTagLayout.setupWithViewPager(this.myCommentViewPager, true);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r);
        this.u = myFragmentAdapter;
        this.myCommentViewPager.setAdapter(myFragmentAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.myCommentViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299439) {
            return;
        }
        com.rtk.app.tool.c.a(this.f147c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_comment);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
    }
}
