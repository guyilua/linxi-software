package com.rtk.app.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.adapter.ItemViewPagerAdapter;
import com.rtk.app.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AllNewsListActivity extends BaseActivity {

    @BindView
    TabLayout allNewsTabLayout;

    @BindView
    TextView allNewsTopBack;

    @BindView
    LinearLayout allNewsTopLayout;

    @BindView
    ViewPager allNewsViewpager;
    private int q = 0;
    private int r = 0;
    private List<View> s;
    private List<String> t;
    private Context u;

    private void L(View view, String str) {
        this.s.add(view);
        this.t.add(str);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = getIntent().getExtras().getInt("id");
        this.r = getIntent().getExtras().getInt(com.umeng.analytics.pro.d.y);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.s = new ArrayList();
        this.t = new ArrayList();
        View inflate = LayoutInflater.from(this.u).inflate(R.layout.all_news_item1_layout, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this.u).inflate(R.layout.all_news_item2_layout, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this.u).inflate(R.layout.all_news_item3_layout, (ViewGroup) null);
        View inflate4 = LayoutInflater.from(this.u).inflate(R.layout.all_news_item4_layout, (ViewGroup) null);
        View inflate5 = LayoutInflater.from(this.u).inflate(R.layout.all_news_item5_layout, (ViewGroup) null);
        View inflate6 = LayoutInflater.from(this.u).inflate(R.layout.all_news_item6_layout, (ViewGroup) null);
        L(inflate, "全部");
        L(inflate2, "资料");
        L(inflate3, "攻略");
        L(inflate4, "评测");
        L(inflate5, "活动");
        L(inflate6, "公告");
        new AllNewsListItem1(this.u, inflate, this.q);
        new AllNewsListItem2(this.u, inflate2, this.q);
        new AllNewsListItem3(this.u, inflate3, this.q);
        new AllNewsListItem4(this.u, inflate4, this.q);
        new AllNewsListItem5(this.u, inflate5, this.q);
        new AllNewsListItem6(this.u, inflate6, this.q);
        ItemViewPagerAdapter itemViewPagerAdapter = new ItemViewPagerAdapter(this.s, this.t, this.u);
        this.allNewsTabLayout.setupWithViewPager(this.allNewsViewpager, true);
        this.allNewsViewpager.setAdapter(itemViewPagerAdapter);
        this.allNewsViewpager.setCurrentItem(this.r);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296433) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.u);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_all_news_list);
        ButterKnife.a(this);
        this.u = this;
    }
}
