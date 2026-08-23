package com.rtk.app.main;

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
import com.rtk.app.main.Home5Activity.MyLibaoActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LiBaoListActivity extends BaseActivity {
    public static boolean w = false;

    @BindView
    LinearLayout libaoListLayout;

    @BindView
    TextView libaoListMyLibao;

    @BindView
    TabLayout libaoListTablayout;

    @BindView
    TextView libaoListTitle;

    @BindView
    ViewPager libaoListViewPager;
    private Context q;
    private List<View> r = new ArrayList();
    private List<String> s = new ArrayList();
    private LiBaoListItem1 t;
    private LiBaoListItem2 u;
    private LiBaoListItem3 v;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.libaoListLayout, this.libaoListTablayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.s.add("正在放号");
        this.s.add("即将放号");
        this.s.add("往期放号");
        View inflate = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.libao_list_viewpager_item1_layout, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.libao_list_viewpager_item2_layout, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this.q).inflate(com.rtk.app.R.layout.libao_list_viewpager_item3_layout, (ViewGroup) null);
        this.r.add(inflate);
        this.r.add(inflate2);
        this.r.add(inflate3);
        this.t = new LiBaoListItem1(this.q, inflate);
        this.u = new LiBaoListItem2(this.q, inflate2);
        this.v = new LiBaoListItem3(this.q, inflate3);
        this.libaoListViewPager.setAdapter(new ItemViewPagerAdapter(this.r, this.s, this.q));
        this.libaoListTablayout.setupWithViewPager(this.libaoListViewPager);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null) {
            return;
        }
        com.rtk.app.tool.c0.u("LiBaoListActivity", "LiBaoListActivity  onActivityResult\n   requestCode:" + i + "  \n  resultCode" + i2 + "    \ngiftStatus" + intent.getIntExtra("giftStatus", 0) + "     \ngiftbag_id" + intent.getStringExtra("giftbag_id"));
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
        int id = view.getId();
        if (id != 2131298948) {
            if (id != 2131298950) {
                return;
            }
            com.rtk.app.tool.c.a((Activity) this.q);
        } else if (com.rtk.app.tool.y.I(this.q) != 0) {
            com.rtk.app.tool.c.b((Activity) this.q, MyLibaoActivity.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_li_bao_list);
        ButterKnife.a(this);
        this.q = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        com.rtk.app.tool.c0.u("LiBaoListActivity", "LiBaoListActivity    onResume ");
        this.t.k.notifyDataSetChanged();
        this.u.k.notifyDataSetChanged();
        this.v.k.notifyDataSetChanged();
        if (w) {
            w = false;
            this.t.k();
            this.u.k();
            this.v.k();
        }
    }
}
