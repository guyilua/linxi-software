package com.rtk.app.main.HomeCommunityPack;

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
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.family.FamilyProtocolActivity;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostCommentAuditListActivity extends BaseActivity implements h.j {

    @BindView
    View help;

    @BindView
    TextView postCommentAuditListBack;

    @BindView
    LinearLayout postCommentAuditListLayout;

    @BindView
    TextView postCommentAuditListRefresh;

    @BindView
    TabLayout postCommentAuditListTabLayout;

    @BindView
    BaseViewPager postCommentAuditListViewPager;
    private Bundle q;
    private String r;
    private PostCommentAuditFragment t;
    private MyFragmentAdapter v;
    private int w;
    private String x;
    private boolean y;
    private List<BaseFragment> s = new ArrayList();
    private List<String> u = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            PostCommentAuditListActivity postCommentAuditListActivity = PostCommentAuditListActivity.this;
            postCommentAuditListActivity.t = (PostCommentAuditFragment) postCommentAuditListActivity.s.get(i);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postCommentAuditListLayout, this.postCommentAuditListTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
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
        this.r = extras.getString("mid", "0");
        this.w = this.q.getInt("moudleAdmin", 0);
        this.x = this.q.getString("family_id");
        boolean z = this.q.getBoolean("isAuditInfoForFamily", false);
        this.y = z;
        if (z) {
            this.postCommentAuditListBack.setText("家族帖子回复审核列表（初审）");
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postCommentAuditListViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (!c.d.a.d.d() && MainActivity.p.getData().getAdmin().getAdmin() == 0 && MainActivity.p.getData().getAdmin().getBbsAdmin() == 0 && this.w == 0) {
            finish();
        }
        for (int i = 1; i <= 4; i++) {
            PostCommentAuditFragment postCommentAuditFragment = new PostCommentAuditFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("state", i);
            bundle.putInt("moudleAdmin", this.w);
            bundle.putString("mid", this.r);
            bundle.putString("family_id", this.x);
            bundle.putBoolean("isAuditInfoForFamily", this.y);
            postCommentAuditFragment.setArguments(bundle);
            this.s.add(postCommentAuditFragment);
        }
        this.t = (PostCommentAuditFragment) this.s.get(0);
        this.u.add("待审核");
        this.u.add("审核不通过");
        this.u.add("审核通过");
        this.u.add("已删除");
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.s, this.u);
        this.v = myFragmentAdapter;
        this.postCommentAuditListViewPager.setAdapter(myFragmentAdapter);
        this.postCommentAuditListTabLayout.setupWithViewPager(this.postCommentAuditListViewPager, true);
        if (TextUtils.isEmpty(this.x)) {
            return;
        }
        this.postCommentAuditListBack.setText("家族帖子回复审核列表");
        this.help.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297862) {
            Bundle bundle = new Bundle();
            bundle.putString("title", "家族帖子回复审核功能帮助");
            bundle.putString("url", "user/agreement/family/posts-comment-check-help");
            com.rtk.app.tool.c.b(this, FamilyProtocolActivity.class, bundle);
            return;
        }
        if (id == 2131299750) {
            finish();
        } else {
            if (id != 2131299762) {
                return;
            }
            this.t.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_comment_audit_list);
        ButterKnife.a(this);
    }
}
