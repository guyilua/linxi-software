package com.rtk.app.main.OtherImfomationPack;

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
public class OtherPostReplyActivity extends BaseActivity implements h.j {

    @BindView
    TabLayout otherReplyTab;

    @BindView
    TextView otherReplyTopBack;

    @BindView
    LinearLayout otherReplyTopLayout;

    @BindView
    ViewPager otherReplyViewpager;
    private int q;
    private int r;
    private String s;
    private String t;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.otherReplyTopLayout, this.otherReplyTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public String L() {
        return this.t;
    }

    public String M() {
        return this.s;
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
        this.s = getIntent().getExtras().getString("uid");
        this.t = getIntent().getExtras().getString("otherNickName");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(new OtherPostMyReplyFragment());
        arrayList.add(new OtherPostReplyMeFragment());
        arrayList2.add("TA的回复(" + this.r + ")");
        arrayList2.add("回复TA的(" + this.q + ")");
        this.otherReplyTab.setupWithViewPager(this.otherReplyViewpager, true);
        this.otherReplyViewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), arrayList, arrayList2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299693) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_other_post_reply);
        ButterKnife.a(this);
    }
}
