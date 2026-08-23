package com.rtk.app.main.MainActivityPack.AuditPack;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditUpAgainActivity extends BaseActivity {
    private LinearLayout q;
    private TabLayout r;
    private LinearLayout s;
    private ViewPager t;
    private List<String> u = new ArrayList();
    private List<BaseFragment> v = new ArrayList();

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.q, this.r, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.s);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (BaseFragment baseFragment : this.v) {
            c0.u("AuditUpAgainActivity", "回收");
            baseFragment.n();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.u.add("待审核");
        this.u.add("审核不通过");
        this.u.add("审核通过");
        this.u.add("已删除");
        int i = 0;
        while (i < this.u.size()) {
            UpCheckAgainApkListFragment upCheckAgainApkListFragment = new UpCheckAgainApkListFragment();
            Bundle bundle = new Bundle();
            StringBuilder sb = new StringBuilder();
            i++;
            sb.append(i);
            sb.append("");
            bundle.putString("status", sb.toString());
            upCheckAgainApkListFragment.setArguments(bundle);
            this.v.add(upCheckAgainApkListFragment);
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = (LinearLayout) findViewById(com.rtk.app.R.id.audit_up_again_top_layout);
        this.s = (LinearLayout) findViewById(com.rtk.app.R.id.audit_up_again_tab_layout);
        this.r = findViewById(com.rtk.app.R.id.audit_up_again_tab);
        this.t = findViewById(com.rtk.app.R.id.audit_up_again_viewPager);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.v, this.u);
        this.r.setupWithViewPager(this.t, true);
        this.t.setAdapter(myFragmentAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<BaseFragment> it = this.v.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296683) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_audit_up_again);
    }
}
