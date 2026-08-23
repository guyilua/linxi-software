package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.main.family.FamilyProtocolActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostAuditListActivity extends BaseActivity {

    @BindView
    View help;

    @BindView
    TextView postAuditListBack;

    @BindView
    LinearLayout postAuditListLayout;

    @BindView
    TabLayout postAuditListTabLayout;

    @BindView
    BaseViewPager postAuditListViewPager;
    private MyFragmentAdapter s;
    private Bundle t;
    private String u;
    private String v;
    private List<BaseFragment> q = new ArrayList();
    private List<String> r = new ArrayList();
    private boolean w = false;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postAuditListLayout, this.postAuditListTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.t = extras;
        this.u = extras.getString("mid", "0");
        this.v = this.t.getString("family_id");
        boolean z = this.t.getBoolean("isAuditInfoForFamily", false);
        this.w = z;
        if (z) {
            this.postAuditListBack.setText("家族帖子审核列表（初审）");
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        for (int i = 1; i <= 4; i++) {
            PostAuditFragment postAuditFragment = new PostAuditFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("state", i);
            bundle.putString("mid", this.u);
            bundle.putString("family_id", this.v);
            bundle.putBoolean("isAuditInfoForFamily", this.w);
            postAuditFragment.setArguments(bundle);
            this.q.add(postAuditFragment);
        }
        this.r.add("待审核");
        this.r.add("审核不通过");
        this.r.add("审核通过");
        this.r.add("已删除");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r);
        this.s = myFragmentAdapter;
        this.postAuditListViewPager.setAdapter(myFragmentAdapter);
        this.postAuditListTabLayout.setupWithViewPager(this.postAuditListViewPager, true);
        if (TextUtils.isEmpty(this.v)) {
            return;
        }
        this.postAuditListBack.setText("家族帖子审核列表");
        this.help.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.q.get(this.postAuditListViewPager.getCurrentItem()).onActivityResult(i, i2, intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297862) {
            if (id != 2131299743) {
                return;
            }
            finish();
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("title", "家族帖子审核功能帮助");
            bundle.putString("url", "user/agreement/family/posts-check-help");
            com.rtk.app.tool.c.b(this, FamilyProtocolActivity.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_audit_list);
        ButterKnife.a(this);
    }
}
