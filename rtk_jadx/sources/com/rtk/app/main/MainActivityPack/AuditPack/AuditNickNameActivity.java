package com.rtk.app.main.MainActivityPack.AuditPack;

import android.R;
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
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AuditNickNameActivity extends BaseActivity {
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
            c0.u("AuditNickNameActivity", "回收");
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
            AuditNickNameFragment auditNickNameFragment = new AuditNickNameFragment();
            Bundle bundle = new Bundle();
            i++;
            bundle.putInt("state", i);
            auditNickNameFragment.setArguments(bundle);
            this.v.add(auditNickNameFragment);
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = (LinearLayout) findViewById(com.rtk.app.R.id.audit_nick_name_top_layout);
        this.s = (LinearLayout) findViewById(com.rtk.app.R.id.audit_nick_name_tab_layout);
        this.r = findViewById(com.rtk.app.R.id.audit_nick_name_tab);
        this.t = findViewById(com.rtk.app.R.id.audit_nick_name_viewPager);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.v, this.u);
        this.r.setupWithViewPager(this.t, true);
        this.t.setAdapter(myFragmentAdapter);
        c0.u("AuditNickNameActivity", "审核昵称");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296587) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_audit_nick_name);
    }
}
