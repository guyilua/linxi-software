package com.rtk.app.main.OtherImfomationPack;

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
public class OtherCommentActivity extends BaseActivity implements h.j {

    @BindView
    TabLayout otherCommentTagLayout;

    @BindView
    TextView otherCommentTopBack;

    @BindView
    LinearLayout otherCommentTopLayout;

    @BindView
    ViewPager otherCommentViewPager;
    private List<String> q = new ArrayList();
    private String r;
    private OtherCommentForGameFragment s;
    private OtherCommentForUpApkFragment t;
    private List<Fragment> u;
    private MyFragmentAdapter v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (i == 0 && OtherCommentActivity.this.s.v() == 0) {
                MyHorizontalScrollView.b = false;
            } else {
                MyHorizontalScrollView.b = true;
            }
        }
    }

    public OtherCommentActivity() {
        new ArrayList();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.otherCommentTopLayout, this.otherCommentTagLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
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
        this.r = getIntent().getExtras().getString("uid");
        getIntent().getExtras().getString("otherNickName");
        this.u = new ArrayList();
        this.q = new ArrayList();
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.r);
        this.s = new OtherCommentForGameFragment();
        this.t = new OtherCommentForUpApkFragment();
        this.s.setArguments(bundle);
        this.t.setArguments(bundle);
        this.q.add("游戏评论");
        this.q.add("up资源评论");
        this.u.add(this.s);
        this.u.add(this.t);
        this.otherCommentTagLayout.setupWithViewPager(this.otherCommentViewPager, true);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.u, this.q);
        this.v = myFragmentAdapter;
        this.otherCommentViewPager.setAdapter(myFragmentAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.otherCommentViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299653) {
            return;
        }
        com.rtk.app.tool.c.a(this.f147c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_other_comment);
        ButterKnife.a(this);
    }
}
