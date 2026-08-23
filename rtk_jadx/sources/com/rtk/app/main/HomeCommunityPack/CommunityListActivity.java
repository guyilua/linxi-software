package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityListBean;
import com.rtk.app.bean.CommunityModoTypeBean;
import com.rtk.app.bean.TagsBean;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.CustomListView;
import com.rtk.app.custom.RichEditText.PostModificationBean;
import com.rtk.app.custom.b;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.CommunityTopAdapter;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class CommunityListActivity extends BaseActivity implements h.j {
    private List<TagsBean> A;
    private String B;
    private String C;
    private CommunityModoTypeBean D;
    private boolean E;

    @BindView
    TextView communityListAttentionNum;

    @BindView
    TextView communityListAuditBtu;

    @BindView
    TextView communityListAuditCommentBtu;

    @BindView
    LinearLayout communityListAuditLv;

    @BindView
    ImageView communityListBack;

    @BindView
    AppBarLayout communityListBar;

    @BindView
    CoordinatorLayout communityListCoordinatorLayout;

    @BindView
    TextView communityListExpert;

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
    TextView communityListSignIn;

    @BindView
    SwipeRefreshLayout communityListSwipeRefresh;

    @BindView
    TabLayout communityListTab;

    @BindView
    CustomListView communityListTopList;

    @BindView
    TextView communityListTopic;

    @BindView
    BaseViewPager communityListViewPager;
    private Bundle r;
    private String s;
    private List<CommunityModoTypeBean> u;
    private CommunityListBean v;
    private CommunityTopAdapter z;
    private int q = 1;
    private String t = "release";
    private List<String> w = new ArrayList();
    private List<CommunityListBean.DataBean.TopBean> x = new ArrayList();
    private List<CommunityFragment> y = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            CommunityListActivity communityListActivity = CommunityListActivity.this;
            communityListActivity.t = ((CommunityModoTypeBean) communityListActivity.u.get(i)).getType();
            if (CommunityListActivity.this.D != null) {
                for (int i2 = 0; i2 < CommunityListActivity.this.y.size(); i2++) {
                    ((CommunityFragment) CommunityListActivity.this.y.get(i2)).x(CommunityListActivity.this.t);
                }
            } else {
                CommunityListActivity.this.T(1);
            }
            CommunityListActivity communityListActivity2 = CommunityListActivity.this;
            communityListActivity2.D = (CommunityModoTypeBean) communityListActivity2.u.get(i);
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
            CommunityListActivity.this.communityListBar.setExpanded(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.b {
        c() {
        }

        @Override // com.rtk.app.custom.b
        public void a(AppBarLayout appBarLayout, b.a aVar) {
            if (g.a[aVar.ordinal()] != 1) {
                CommunityListActivity.this.communityListSwipeRefresh.setEnabled(false);
            } else {
                CommunityListActivity.this.communityListSwipeRefresh.setEnabled(true);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements SwipeRefreshLayout.OnRefreshListener {
        d() {
        }

        public void onRefresh() {
            CommunityListActivity.this.T(1);
            try {
                ((CommunityFragment) CommunityListActivity.this.y.get(CommunityListActivity.this.communityListViewPager.getCurrentItem())).w();
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements AdapterView.OnItemClickListener {
        e() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            CommunityListActivity communityListActivity = CommunityListActivity.this;
            com.rtk.app.tool.t.J0(communityListActivity.f147c, ((CommunityListBean.DataBean.TopBean) communityListActivity.x.get(i)).getId());
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements com.rtk.app.tool.s {
        f() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            CommunityListActivity.this.T(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    static /* synthetic */ class g {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.a.values().length];
            a = iArr;
            try {
                iArr[b.a.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void S() {
        if (this.A != null) {
            return;
        }
        this.A = this.v.getData().getBaseInfo().getTagsList();
        this.w.add("全部");
        CommunityFragment communityFragment = new CommunityFragment();
        Bundle bundle = new Bundle();
        bundle.putString("mid", this.s);
        bundle.putString("tags", "0");
        bundle.putString(com.umeng.analytics.pro.d.y, this.t);
        communityFragment.setArguments(bundle);
        this.y.add(communityFragment);
        for (int i = 0; i < this.A.size(); i++) {
            this.w.add(this.A.get(i).getName());
        }
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            CommunityFragment communityFragment2 = new CommunityFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("mid", this.s);
            bundle2.putString("tags", this.A.get(i2).getId() + "");
            bundle2.putString(com.umeng.analytics.pro.d.y, this.t);
            communityFragment2.setArguments(bundle2);
            this.y.add(communityFragment2);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.y, this.w);
        this.communityListTab.setupWithViewPager(this.communityListViewPager, true);
        this.communityListViewPager.setAdapter(myFragmentAdapter);
        this.communityListViewPager.setOffscreenPageLimit(this.w.size());
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.communityListLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void T(int... iArr) {
        String sb;
        int i = iArr[0];
        if (i == 1) {
            if (!com.rtk.app.tool.c0.q(this.t)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("members/normalList");
                sb2.append(com.rtk.app.tool.y.u(this.f147c));
                sb2.append("&uid=");
                sb2.append(com.rtk.app.tool.y.K());
                sb2.append("&token=");
                sb2.append(com.rtk.app.tool.y.H());
                sb2.append("&mid=");
                sb2.append(this.s);
                sb2.append("&type=");
                sb2.append(this.t);
                sb2.append("&page=");
                sb2.append(this.q);
                sb2.append("&limit=10&key=");
                sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "mid=" + this.s, "type=" + this.t))));
                sb = sb2.toString();
            }
            sb = "";
        } else if (i != 2) {
            if (i == 3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("members/postSign");
                sb3.append(com.rtk.app.tool.y.u(this.f147c));
                sb3.append("&uid=");
                sb3.append(com.rtk.app.tool.y.K());
                sb3.append("&token=");
                sb3.append(com.rtk.app.tool.y.H());
                sb3.append("&mid=");
                sb3.append(this.s);
                sb3.append("&key=");
                sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "mid=" + this.s))));
                sb = sb3.toString();
            }
            sb = "";
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("members/focusModules");
            sb4.append(com.rtk.app.tool.y.u(this.f147c));
            sb4.append("&uid=");
            sb4.append(com.rtk.app.tool.y.K());
            sb4.append("&token=");
            sb4.append(com.rtk.app.tool.y.H());
            sb4.append("&mid=");
            sb4.append(this.s);
            sb4.append("&key=");
            sb4.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "mid=" + this.s))));
            sb = sb4.toString();
        }
        com.rtk.app.tool.c0.u("CommunityListActivity", "  社区地址    " + com.rtk.app.tool.y.d + sb);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.communityListSwipeRefresh.setRefreshing(false);
        com.rtk.app.tool.c0.u("CommunityListActivity", "社区详情  " + i + " \n    " + str);
        F();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        CommunityListBean communityListBean = (CommunityListBean) create.fromJson(str, CommunityListBean.class);
        this.v = communityListBean;
        this.communityListAttentionNum.setText(communityListBean.getData().getBaseInfo().getForceNum());
        this.communityListTopic.setText(this.v.getData().getBaseInfo().getPostsNum());
        if (this.v.getData().getBaseInfo().getFocused().equals("1")) {
            this.communityListExpert.setText("已关注");
        } else {
            this.communityListExpert.setText("关注");
        }
        if (this.v.getData().getBaseInfo().getSign() == 1) {
            this.communityListSignIn.setText("已签到");
        } else {
            this.communityListSignIn.setText("签到");
        }
        this.x.clear();
        this.x.addAll(this.v.getData().getTop());
        this.communityListName.setText(this.v.getData().getBaseInfo().getName());
        com.rtk.app.tool.t.c(this.f147c, this.v.getData().getBaseInfo().getLogo(), this.communityListIcon, new boolean[0]);
        this.z.notifyDataSetChanged();
        S();
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 1 || MainActivity.p.getData().getAdmin().getBbsAdmin() == 2 || this.v.getData().getBaseInfo().getModuleAdmin() == 1 || this.v.getData().getBaseInfo().getModuleAdmin() == 2)) {
            this.communityListAuditLv.setVisibility(0);
        } else {
            this.communityListAuditLv.setVisibility(8);
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        I(str, new f());
        this.communityListSwipeRefresh.setRefreshing(false);
        com.rtk.app.tool.c0.u("CommunityListActivity", i2 + "社区详情请求失败" + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = extras;
        this.B = extras.getString("name");
        this.C = this.r.getString("logo");
        this.s = this.r.getString("mid");
        this.u = new ArrayList();
        boolean a2 = com.rtk.app.tool.v.a(this.f147c, "postModuleRuleVaule");
        this.E = a2;
        if (a2) {
            this.u.add(new CommunityModoTypeBean("release", "按发布时间"));
            this.u.add(new CommunityModoTypeBean("reply", "按回复时间"));
            this.u.add(new CommunityModoTypeBean("boutique", "按本版精品"));
        } else {
            this.u.add(new CommunityModoTypeBean("reply", "按回复时间"));
            this.u.add(new CommunityModoTypeBean("release", "按发布时间"));
            this.u.add(new CommunityModoTypeBean("boutique", "按本版精品"));
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.communityListOrderingRuleSpinner.setOnItemSelectedListener(new a());
        this.communityListViewPager.setOnPageChangeListener(new b());
        this.communityListBar.addOnOffsetChangedListener(new c());
        this.communityListSwipeRefresh.setOnRefreshListener(new d());
        this.communityListTopList.setOnItemClickListener(new e());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.communityListOrderingRuleSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter((Context) this.f147c, com.rtk.app.R.layout.my_spinner_layout, (List) this.u));
        this.communityListOrderingRuleSpinner.setSelection(0);
        CommunityTopAdapter communityTopAdapter = new CommunityTopAdapter(this.f147c, this.x);
        this.z = communityTopAdapter;
        this.communityListTopList.setAdapter((ListAdapter) communityTopAdapter);
        this.communityListName.setText(this.B);
        com.rtk.app.tool.t.c(this.f147c, this.C, this.communityListIcon, new boolean[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 1000) {
            return;
        }
        T(1);
        try {
            Iterator<CommunityFragment> it = this.y.iterator();
            while (it.hasNext()) {
                it.next().w();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.v != null || view.getId() == 2131297022) {
            switch (view.getId()) {
                case com.rtk.app.R.id.community_list_Expert /* 2131297016 */:
                    if (com.rtk.app.tool.y.x(this.f147c)) {
                        if (!this.v.getData().getBaseInfo().getFocused().equals("1")) {
                            this.v.getData().getBaseInfo().setFocused("1");
                            this.communityListExpert.setText("已关注");
                        } else {
                            this.v.getData().getBaseInfo().setFocused("0");
                            this.communityListExpert.setText("关注");
                        }
                        T(2);
                        return;
                    }
                    com.rtk.app.tool.t.w0(this.f147c);
                    return;
                case com.rtk.app.R.id.community_list_auditBtu /* 2131297019 */:
                    com.rtk.app.tool.t.E0(this.f147c, this.s, false);
                    return;
                case com.rtk.app.R.id.community_list_audit_comment_btu /* 2131297020 */:
                    com.rtk.app.tool.t.m0(this.f147c, this.s, this.v.getData().getBaseInfo().getModuleAdmin(), null, false);
                    return;
                case com.rtk.app.R.id.community_list_back /* 2131297022 */:
                    finish();
                    return;
                case com.rtk.app.R.id.community_list_module_lv /* 2131297026 */:
                    com.rtk.app.tool.t.y0(this.f147c, this.s, this.B);
                    return;
                case com.rtk.app.R.id.community_list_publish_post /* 2131297029 */:
                    if (com.rtk.app.tool.y.x(this.f147c)) {
                        com.rtk.app.tool.t.N0(this.f147c, new PostModificationBean(this.A, this.s));
                        return;
                    } else {
                        com.rtk.app.tool.t.w0(this.f147c);
                        return;
                    }
                case com.rtk.app.R.id.community_list_search /* 2131297030 */:
                    Bundle bundle = new Bundle();
                    bundle.putString("mid", this.s);
                    com.rtk.app.tool.c.b(this.f147c, SearchPostOrUserActivity.class, bundle);
                    return;
                case com.rtk.app.R.id.community_list_sign_in /* 2131297031 */:
                    if (com.rtk.app.tool.y.x(this.f147c)) {
                        if (this.v.getData().getBaseInfo().getSign() != 1) {
                            this.communityListSignIn.setText("已签到");
                            T(3);
                            this.communityListSignIn.setEnabled(false);
                            return;
                        }
                        return;
                    }
                    com.rtk.app.tool.t.w0(this.f147c);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_community_list);
        ButterKnife.a(this);
        G(this.communityListParentLayout, this.communityListLayout);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.rtk.app.tool.c0.u("CommunityListActivity", "回收Community");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
    }
}
