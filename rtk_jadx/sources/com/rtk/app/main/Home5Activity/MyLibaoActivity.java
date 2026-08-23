package com.rtk.app.main.Home5Activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.rtk.app.adapter.ItemViewPagerAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyLibaoActivity extends BaseActivity implements h.j {

    @BindView
    TextView myLibaoBack;

    @BindView
    TabLayout myLibaoTablayout;

    @BindView
    TextView myLibaoTips;

    @BindView
    LinearLayout myLibaoTopLayout;

    @BindView
    ViewPager myLibaoViewPager;
    private Context q;
    private List<View> r = new ArrayList();
    private List<String> s = new ArrayList();
    private MYLiBaoListItem1 t;
    private MYLiBaoListItem2 u;
    private MYLiBaoListItem3 v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (i == 0) {
                MyLibaoActivity.this.myLibaoTips.setText("礼包被领取后会进入淘号阶段，请尽快使用");
            } else if (i == 1) {
                MyLibaoActivity.this.myLibaoTips.setText("淘到的号不一定能兑换，越快兑换越好");
            } else {
                if (i != 2) {
                    return;
                }
                MyLibaoActivity.this.myLibaoTips.setText("已预订的礼包可提前30分钟领取，请及时领取！");
            }
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.myLibaoTopLayout, this.myLibaoTablayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.myLibaoViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.r = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        arrayList.add("已领取");
        this.s.add("已淘号");
        this.s.add("已预订");
        View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.my_libao_list_viewpager_item1_layout, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.libao_list_viewpager_item2_layout, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.libao_list_viewpager_item3_layout, (ViewGroup) null);
        this.r.add(inflate);
        this.r.add(inflate2);
        this.r.add(inflate3);
        this.t = new MYLiBaoListItem1(this.q, inflate);
        this.u = new MYLiBaoListItem2(this.q, inflate2);
        this.v = new MYLiBaoListItem3(this.q, inflate3);
        this.myLibaoViewPager.setAdapter(new ItemViewPagerAdapter(this.r, this.s, this.q));
        this.myLibaoTablayout.setupWithViewPager(this.myLibaoViewPager);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        com.rtk.app.tool.c0.u("MyLibaoActivity", "LiBaoListActivity  onActivityResult\n   requestCode:" + i + "  \n  resultCode" + i2 + "    \ngiftStatus" + intent.getIntExtra("giftStatus", 0) + "     \ngiftbag_id" + intent.getStringExtra("giftbag_id"));
        int intExtra = intent.getIntExtra("position", 0);
        intent.getStringExtra("giftbag_id");
        int intExtra2 = intent.getIntExtra("giftStatus", 0);
        String stringExtra = intent.getStringExtra("giftContent");
        switch (i) {
            case 11:
                this.t.o.get(intExtra).setGift_status(intExtra2);
                this.t.o.get(intExtra).setGift_content(stringExtra);
                return;
            case 12:
                this.u.o.get(intExtra).setGift_status(intExtra2);
                this.u.o.get(intExtra).setGift_content(stringExtra);
                return;
            case 13:
                this.v.o.get(intExtra).setGift_status(intExtra2);
                this.v.o.get(intExtra).setGift_content(stringExtra);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299453) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_libao);
        ButterKnife.a(this);
        this.q = this;
        L(new int[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        this.t.k.notifyDataSetChanged();
        this.u.k.notifyDataSetChanged();
        this.v.k.notifyDataSetChanged();
    }
}
