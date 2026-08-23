package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.ItemViewPagerAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.MarkedImageView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OpenServiceActivity extends BaseActivity {

    @BindView
    ImageView openServiceBack;

    @BindView
    MarkedImageView openServiceDownload;

    @BindView
    RelativeLayout openServiceLayout;

    @BindView
    TabLayout openServiceTablayout;

    @BindView
    TextView openServiceTitle;

    @BindView
    ViewPager openServiceViewPager;
    private Context q;
    private List<View> r;
    private ItemViewPagerAdapter s;
    private List<String> t;
    private OpenServiceItem1 u;
    private OpenServiceItem2 v;
    private OpenServiceItem3 w;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.openServiceLayout, this.openServiceTablayout, this.openServiceTitle, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.u.j();
        this.v.j();
        this.w.j();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.b = new com.rtk.app.tool.DownLoadTool.n(this.openServiceDownload);
        com.rtk.app.tool.DownLoadTool.x.c().b(this.b);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.t = new ArrayList();
        this.r = new ArrayList();
        this.t.add("已开服");
        this.t.add("今日开服");
        this.t.add("即将开服");
        View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.open_service_item1_layout, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.open_service_item2_layout, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.open_service_item3_layout, (ViewGroup) null);
        this.r.add(inflate);
        this.r.add(inflate2);
        this.r.add(inflate3);
        this.u = new OpenServiceItem1(this.q, inflate);
        this.v = new OpenServiceItem2(this.q, inflate2);
        this.w = new OpenServiceItem3(this.q, inflate3);
        ItemViewPagerAdapter itemViewPagerAdapter = new ItemViewPagerAdapter(this.r, this.t, this.q);
        this.s = itemViewPagerAdapter;
        this.openServiceViewPager.setAdapter(itemViewPagerAdapter);
        this.openServiceTablayout.setupWithViewPager(this.openServiceViewPager);
        this.openServiceViewPager.setCurrentItem(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.open_service_back /* 2131299629 */:
                com.rtk.app.tool.c.a((Activity) this.q);
                return;
            case com.rtk.app.R.id.open_service_download /* 2131299630 */:
                com.rtk.app.tool.t.o0(this.q);
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
        setContentView(com.rtk.app.R.layout.activity_open_service);
        this.q = this;
        ButterKnife.a(this);
    }
}
