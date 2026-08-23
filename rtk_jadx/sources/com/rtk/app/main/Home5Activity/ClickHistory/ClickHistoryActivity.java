package com.rtk.app.main.Home5Activity.ClickHistory;

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
import com.rtk.app.main.dialogPack.DialogForEnSure;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ClickHistoryActivity extends BaseActivity {

    @BindView
    TabLayout clickHistoryTab;

    @BindView
    TextView clickHistoryTopBack;

    @BindView
    TextView clickHistoryTopClear;

    @BindView
    LinearLayout clickHistoryTopLayout;

    @BindView
    ViewPager clickHistoryViewpager;
    private List<Fragment> q;
    private List<String> r;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(String[] strArr) {
        c0.u("ClickHistoryActivity", "clear history");
        f.g(this.f147c);
        f.h(this.f147c);
        f.f(this.f147c);
        f.e(this.f147c);
        for (int i = 0; i < this.q.size(); i++) {
            this.q.get(i).onResume();
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.clickHistoryTopLayout, this.clickHistoryTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = new ArrayList();
        this.r = new ArrayList();
        ClickHistoryUpFragment clickHistoryUpFragment = new ClickHistoryUpFragment();
        ClickHistoryUserFragment clickHistoryUserFragment = new ClickHistoryUserFragment();
        ClickHistoryPostFragment clickHistoryPostFragment = new ClickHistoryPostFragment();
        ClickHistoryGameFragment clickHistoryGameFragment = new ClickHistoryGameFragment();
        this.q.add(clickHistoryUpFragment);
        this.q.add(clickHistoryUserFragment);
        this.q.add(clickHistoryPostFragment);
        this.q.add(clickHistoryGameFragment);
        this.r.add("UP");
        this.r.add("用户");
        this.r.add("帖子");
        this.r.add("游戏");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r);
        this.clickHistoryTab.setupWithViewPager(this.clickHistoryViewpager, true);
        this.clickHistoryViewpager.setAdapter(myFragmentAdapter);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.click_history_top_back /* 2131296910 */:
                finish();
                return;
            case com.rtk.app.R.id.click_history_top_clear /* 2131296911 */:
                new DialogForEnSure(this.f147c, "删除全部浏览记录", new s() { // from class: com.rtk.app.main.Home5Activity.ClickHistory.a
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        ClickHistoryActivity.this.M(strArr);
                    }
                }).show();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_click_history);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
    }
}
