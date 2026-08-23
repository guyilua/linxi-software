package com.rtk.app.main.UpModule;

import android.R;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.main.MainActivityPack.AuditPack.MyAuditCommentActivity;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCommentAuditListActivity extends BaseActivity implements h.j {
    private Bundle q;
    private UpCommentAuditFragment s;
    private MyFragmentAdapter u;

    @BindView
    TextView upCommentAuditListBack;

    @BindView
    LinearLayout upCommentAuditListLayout;

    @BindView
    TextView upCommentAuditListRefresh;

    @BindView
    TabLayout upCommentAuditListTabLayout;

    @BindView
    BaseViewPager upCommentAuditListViewPager;

    @BindView
    TextView upCommentAuditMyAudit;
    private int v;
    private String w;
    private boolean x;
    private List<BaseFragment> r = new ArrayList();
    private List<String> t = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            UpCommentAuditListActivity upCommentAuditListActivity = UpCommentAuditListActivity.this;
            upCommentAuditListActivity.s = (UpCommentAuditFragment) upCommentAuditListActivity.r.get(i);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upCommentAuditListLayout, this.upCommentAuditListTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
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
        Bundle extras = getIntent().getExtras();
        this.q = extras;
        this.v = extras.getInt("hasCommentPermission", 0);
        this.w = this.q.getString("family_id");
        boolean z = this.q.getBoolean("isAuditInfoForFamily", false);
        this.x = z;
        if (z) {
            this.upCommentAuditListBack.setText("家族UP评论审核列表（初审）");
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upCommentAuditListViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (!c.d.a.d.d() && MainActivity.p.getData().getAdmin().getAdmin() == 0 && MainActivity.p.getData().getAdmin().getUpAdmin() == 0 && this.v == 0 && !TextUtils.isEmpty(this.w)) {
            finish();
            return;
        }
        for (int i = 1; i <= 4; i++) {
            UpCommentAuditFragment upCommentAuditFragment = new UpCommentAuditFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("state", i);
            bundle.putString("family_id", this.w);
            bundle.putInt("hasCommentPermission", this.v);
            bundle.putBoolean("isAuditInfoForFamily", this.x);
            upCommentAuditFragment.setArguments(bundle);
            this.r.add(upCommentAuditFragment);
        }
        this.s = (UpCommentAuditFragment) this.r.get(0);
        this.t.add("待审核");
        this.t.add("审核不通过");
        this.t.add("审核通过");
        this.t.add("已删除");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.t);
        this.u = myFragmentAdapter;
        this.upCommentAuditListViewPager.setAdapter(myFragmentAdapter);
        this.upCommentAuditListTabLayout.setupWithViewPager(this.upCommentAuditListViewPager, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300804) {
            finish();
        } else if (id == 2131300821) {
            this.s.u();
        } else {
            if (id != 2131300825) {
                return;
            }
            com.rtk.app.tool.c.b(this.f147c, MyAuditCommentActivity.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_comment_audit_list);
        ButterKnife.a(this);
    }
}
