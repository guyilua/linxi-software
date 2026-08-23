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
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.UpModule.MyUpCommentAuditFragment;
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyAuditCommentActivity extends BaseActivity {
    private LinearLayout q;
    private TabLayout r;
    private LinearLayout s;
    private ViewPager t;
    private MyUpCommentAuditFragment w;
    private MyFragmentAdapter x;
    private List<BaseFragment> u = new ArrayList();
    private List<String> v = new ArrayList();
    private int y = 0;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            MyAuditCommentActivity myAuditCommentActivity = MyAuditCommentActivity.this;
            myAuditCommentActivity.w = (MyUpCommentAuditFragment) myAuditCommentActivity.u.get(i);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.q, this.r, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.s);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        if (c.d.a.d.d()) {
            if (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 2) {
                this.y = (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getCommentadmin() == 1) ? 1 : 2;
            }
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.t.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = (LinearLayout) findViewById(com.rtk.app.R.id.my_audit_comment_top_layout);
        this.s = (LinearLayout) findViewById(com.rtk.app.R.id.my_audit_comment_tab_layout);
        this.r = findViewById(com.rtk.app.R.id.my_audit_comment_tab);
        this.t = findViewById(com.rtk.app.R.id.my_audit_comment_viewPager);
        for (int i = 1; i <= 4; i++) {
            MyUpCommentAuditFragment myUpCommentAuditFragment = new MyUpCommentAuditFragment();
            Bundle bundle = new Bundle();
            if (i == 4) {
                bundle.putInt("state", 0);
            } else {
                bundle.putInt("state", i + 1);
            }
            bundle.putInt("hasCommentPermission", this.y);
            myUpCommentAuditFragment.setArguments(bundle);
            this.u.add(myUpCommentAuditFragment);
        }
        this.v.add("审核不通过");
        this.v.add("审核通过");
        this.v.add("已删除");
        this.v.add("全部");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.u, this.v);
        this.x = myFragmentAdapter;
        this.t.setAdapter(myFragmentAdapter);
        this.r.setupWithViewPager(this.t, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299412) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_my_audit_comment);
    }
}
