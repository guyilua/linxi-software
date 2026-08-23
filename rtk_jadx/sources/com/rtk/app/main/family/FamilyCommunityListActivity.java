package com.rtk.app.main.family;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.bean.CommunityListBean;
import com.rtk.app.bean.CommunityModoTypeBean;
import com.rtk.app.bean.FamilyCountPendingBean;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.TagsBean;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.CustomListView;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.custom.b;
import com.rtk.app.main.HomeCommunityPack.CommunityFragment;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.CommunityTopAdapter;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@SuppressLint({"All"})
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCommunityListActivity extends FamilyBaseActivity implements h.j {
    private String A;
    private String B;
    private CommunityModoTypeBean C;
    private String D;

    @BindView
    TextView auditCommentMessageNum;

    @BindView
    TextView auditMessageNum;

    @BindView
    LinearLayout communityListAuditLv;

    @BindView
    ImageView communityListBack;

    @BindView
    AppBarLayout communityListBar;

    @BindView
    CoordinatorLayout communityListCoordinatorLayout;

    @BindView
    ImageView communityListIcon;

    @BindView
    LinearLayout communityListLayout;

    @BindView
    RelativeLayout communityListModuleLv;

    @BindView
    TextView communityListName;

    @BindView
    Spinner communityListOrderingRuleSpinner;

    @BindView
    LinearLayout communityListParentLayout;

    @BindView
    ImageView communityListPublishPost;

    @BindView
    ImageView communityListSearch;

    @BindView
    SwipeRefreshLayout communityListSwipeRefresh;

    @BindView
    TabLayout communityListTab;

    @BindView
    CustomListView communityListTopList;

    @BindView
    BaseViewPager communityListViewPager;
    private String r;
    private List<CommunityModoTypeBean> t;
    private CommunityListBean u;
    private CommunityTopAdapter y;
    private List<TagsBean> z;
    private String s = "release";
    private final List<String> v = new ArrayList();
    private final List<CommunityListBean.DataBean.TopBean> w = new ArrayList();
    private final List<CommunityFragment> x = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            FamilyCommunityListActivity familyCommunityListActivity = FamilyCommunityListActivity.this;
            familyCommunityListActivity.s = ((CommunityModoTypeBean) familyCommunityListActivity.t.get(i)).getType();
            if (FamilyCommunityListActivity.this.C != null) {
                for (int i2 = 0; i2 < FamilyCommunityListActivity.this.x.size(); i2++) {
                    ((CommunityFragment) FamilyCommunityListActivity.this.x.get(i2)).x(FamilyCommunityListActivity.this.s);
                }
            } else {
                FamilyCommunityListActivity.this.U(1);
            }
            FamilyCommunityListActivity familyCommunityListActivity2 = FamilyCommunityListActivity.this;
            familyCommunityListActivity2.C = (CommunityModoTypeBean) familyCommunityListActivity2.t.get(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            FamilyCommunityListActivity.this.communityListBar.setExpanded(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.b {
        c() {
        }

        @Override // com.rtk.app.custom.b
        public void a(AppBarLayout appBarLayout, b.a aVar) {
            SwipeRefreshLayout swipeRefreshLayout = FamilyCommunityListActivity.this.communityListSwipeRefresh;
            Objects.requireNonNull(aVar);
            swipeRefreshLayout.setEnabled(aVar == b.a.EXPANDED);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements com.rtk.app.tool.s {
        d() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            FamilyCommunityListActivity.this.U(1);
        }
    }

    private void T() {
        if (this.z != null) {
            return;
        }
        this.z = this.u.getData().getBaseInfo().getTagsList();
        this.v.add("全部");
        CommunityFragment communityFragment = new CommunityFragment();
        Bundle bundle = new Bundle();
        bundle.putString("mid", this.r);
        bundle.putString("tags", "0");
        bundle.putString(com.umeng.analytics.pro.d.y, this.s);
        bundle.putString("family_id", this.D);
        communityFragment.setArguments(bundle);
        this.x.add(communityFragment);
        for (int i = 0; i < this.z.size(); i++) {
            this.v.add(this.z.get(i).getName());
        }
        for (int i2 = 0; i2 < this.z.size(); i2++) {
            CommunityFragment communityFragment2 = new CommunityFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("mid", this.r);
            bundle2.putString("tags", this.z.get(i2).getId() + "");
            bundle2.putString(com.umeng.analytics.pro.d.y, this.s);
            bundle2.putString("family_id", this.D);
            communityFragment2.setArguments(bundle2);
            this.x.add(communityFragment2);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.x, this.v);
        this.communityListTab.setupWithViewPager(this.communityListViewPager, true);
        this.communityListViewPager.setAdapter(myFragmentAdapter);
        this.communityListViewPager.setOffscreenPageLimit(this.v.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W() {
        U(1);
        try {
            this.x.get(this.communityListViewPager.getCurrentItem()).w();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y(AdapterView adapterView, View view, int i, long j) {
        com.rtk.app.tool.t.J0(this.f147c, this.w.get(i).getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.D);
        int i = iArr[0];
        if (i == 1) {
            l.put("mid", this.r);
            l.put("key", com.rtk.app.tool.t.L(l));
            String w = com.rtk.app.tool.y.w("family/bbs/list/top", l);
            com.rtk.app.tool.c0.u("FamilyCommunityListActivity", "  社区地址    " + com.rtk.app.tool.y.e + w);
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
            return;
        }
        if (i == 2) {
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/family-admin", l)));
        } else {
            if (i != 3) {
                return;
            }
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/count/pending", 3, l);
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.communityListSwipeRefresh.setRefreshing(false);
        F();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1) {
            com.rtk.app.tool.c0.u("FamilyCommunityListActivity", "社区详情  " + i + " \n    " + com.rtk.app.c.a.b(str));
            this.u = (CommunityListBean) create.fromJson(str, CommunityListBean.class);
            this.w.clear();
            this.w.addAll(this.u.getData().getTop());
            this.communityListName.setText(this.u.getData().getBaseInfo().getName());
            com.rtk.app.tool.t.c(this.f147c, this.u.getData().getBaseInfo().getLogo(), this.communityListIcon, new boolean[0]);
            this.y.notifyDataSetChanged();
            T();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            FamilyCountPendingBean.DataBean data = ((FamilyCountPendingBean) w(str, FamilyCountPendingBean.class)).getData();
            if (com.rtk.app.c.a.c(data.getPostsCount())) {
                this.auditMessageNum.setVisibility(8);
            } else {
                this.auditMessageNum.setVisibility(0);
                this.auditMessageNum.setText(data.getPostsCount());
            }
            if (com.rtk.app.c.a.c(data.getPostsCommentCount())) {
                this.auditCommentMessageNum.setVisibility(8);
                return;
            } else {
                this.auditCommentMessageNum.setVisibility(0);
                this.auditCommentMessageNum.setText(data.getPostsCommentCount());
                return;
            }
        }
        com.rtk.app.tool.c0.u("FamilyCommunityListActivity", "家族管理员  " + i + " \n    " + com.rtk.app.c.a.b(str));
        FamilyInfoBean.DataBean data2 = ((FamilyInfoBean) create.fromJson(str, FamilyInfoBean.class)).getData();
        if (data2.isBbsAdmin(com.rtk.app.tool.y.K()) || data2.isLeader(com.rtk.app.tool.y.K())) {
            U(3);
            this.communityListAuditLv.setVisibility(0);
        } else {
            this.communityListAuditLv.setVisibility(8);
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            I(str, new d());
            this.communityListSwipeRefresh.setRefreshing(false);
            com.rtk.app.tool.c0.u("FamilyCommunityListActivity", i2 + "社区详情请求失败" + str + ",code=" + i);
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.D = extras.getString("family_id");
        this.A = extras.getString("name");
        this.B = extras.getString("logo");
        this.r = extras.getString("mid");
        this.t = new ArrayList();
        if (com.rtk.app.tool.v.a(this.f147c, "postModuleRuleVaule")) {
            this.t.add(new CommunityModoTypeBean("release", "按发布时间"));
            this.t.add(new CommunityModoTypeBean("reply", "按回复时间"));
            this.t.add(new CommunityModoTypeBean("boutique", "按本版精品"));
        } else {
            this.t.add(new CommunityModoTypeBean("reply", "按回复时间"));
            this.t.add(new CommunityModoTypeBean("release", "按发布时间"));
            this.t.add(new CommunityModoTypeBean("boutique", "按本版精品"));
        }
        U(2);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.communityListOrderingRuleSpinner.setOnItemSelectedListener(new a());
        this.communityListViewPager.addOnPageChangeListener(new b());
        this.communityListBar.addOnOffsetChangedListener(new c());
        this.communityListSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.family.j
            public final void onRefresh() {
                FamilyCommunityListActivity.this.W();
            }
        });
        this.communityListTopList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.rtk.app.main.family.k
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FamilyCommunityListActivity.this.Y(adapterView, view, i, j);
            }
        });
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        this.communityListOrderingRuleSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter((Context) this.f147c, R.layout.my_spinner_layout, (List) this.t));
        this.communityListOrderingRuleSpinner.setSelection(0);
        CommunityTopAdapter communityTopAdapter = new CommunityTopAdapter(this.f147c, this.w);
        this.y = communityTopAdapter;
        this.communityListTopList.setAdapter((ListAdapter) communityTopAdapter);
        this.communityListName.setText(this.A);
        com.rtk.app.tool.t.c(this.f147c, this.B, this.communityListIcon, new boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1000) {
            U(1);
            try {
                Iterator<CommunityFragment> it = this.x.iterator();
                while (it.hasNext()) {
                    it.next().w();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    @SuppressLint({"NonConstantResourceId"})
    public void onClick(View view) {
        if (this.u != null || view.getId() == 2131297022) {
            switch (view.getId()) {
                case R.id.audit_comment_layout /* 2131296540 */:
                    com.rtk.app.tool.t.m0(this.f147c, this.r, this.u.getData().getBaseInfo().getModuleAdmin(), this.D, false);
                    return;
                case R.id.audit_layout /* 2131296569 */:
                    com.rtk.app.tool.t.D0(this.f147c, this.D, this.r);
                    return;
                case R.id.community_list_back /* 2131297022 */:
                    finish();
                    return;
                case R.id.community_list_module_lv /* 2131297026 */:
                    if (TextUtils.isEmpty(this.D)) {
                        com.rtk.app.tool.t.y0(this.f147c, this.r, this.A);
                        return;
                    }
                    return;
                case R.id.community_list_publish_post /* 2131297029 */:
                    if (com.rtk.app.tool.y.x(this.f147c)) {
                        PostModificationBean postModificationBean = new PostModificationBean(this.z, this.r, this.D);
                        if (TextUtils.isEmpty(this.D)) {
                            com.rtk.app.tool.t.N0(this.f147c, postModificationBean);
                            return;
                        } else {
                            com.rtk.app.tool.t.v1(this.f147c, postModificationBean);
                            return;
                        }
                    }
                    com.rtk.app.tool.t.w0(this.f147c);
                    return;
                case R.id.community_list_search /* 2131297030 */:
                    Bundle bundle = new Bundle();
                    bundle.putString("mid", this.r);
                    bundle.putString("family_id", this.D);
                    com.rtk.app.tool.c.b(this.f147c, FamilyPostSearchActivity.class, bundle);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_community_list);
        ButterKnife.a(this);
        G(this.communityListParentLayout, this.communityListLayout);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.rtk.app.tool.c0.u("FamilyCommunityListActivity", "回收Community");
    }
}
