package com.rtk.app.main.Home5Activity;

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
import com.rtk.app.tool.o.h;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostReplyActivity extends BaseActivity implements h.j {

    @BindView
    TabLayout myReplyTab;

    @BindView
    TextView myReplyTopBack;

    @BindView
    LinearLayout myReplyTopLayout;

    @BindView
    ViewPager myReplyViewpager;
    private int q;
    private int r;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.myReplyTopLayout, this.myReplyTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
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
        this.q = Integer.parseInt(getIntent().getExtras().getString("replyMeNum"));
        this.r = Integer.parseInt(getIntent().getExtras().getString("replyNum"));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(new MyPostMyReplyFragment());
        arrayList2.add("我的回复(" + this.r + ")");
        arrayList2.add("回复我的(" + this.q + ")");
        arrayList.add(new MyPostReplyMeFragment());
        this.myReplyTab.setupWithViewPager(this.myReplyViewpager, true);
        this.myReplyViewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), arrayList, arrayList2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299521) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_reply_post);
        ButterKnife.a(this);
    }
}
