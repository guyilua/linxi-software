package com.rtk.app.main.family;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.adapter.CommunityFragmentPostListAdapter;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.custom.YcRecyclerView;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyPostSearchActivity extends FamilyBaseActivity {

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    LinearLayout fragmentForRecyclerviewParentLayout;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;

    @BindView
    NoOOMEditText noOOMEditText;
    private String r;
    private int s = 1;
    private CommunityPostBean t;
    private List<CommunityPostBean.DataBean> u;
    private CommunityFragmentPostListAdapter v;
    private String w;
    private String x;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements SwipeRefreshLayout.OnRefreshListener {
        a() {
        }

        public void onRefresh() {
            FamilyPostSearchActivity.this.S();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements YcRecyclerView.b {
        b() {
        }

        @Override // com.rtk.app.custom.YcRecyclerView.b
        public void a() {
            FamilyPostSearchActivity.this.P(new int[0]);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FamilyPostSearchActivity.this.r = editable.toString().replaceAll("&", "").trim();
            FamilyPostSearchActivity.this.s = 1;
            FamilyPostSearchActivity.this.P(new int[0]);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R(String[] strArr) {
        P(new int[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(int... iArr) {
        String str;
        if (!com.rtk.app.tool.y.x(this) || TextUtils.isEmpty(this.x) || TextUtils.isEmpty(this.w)) {
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.w);
        l.put(com.rtk.app.tool.y.z("page"), this.s + "");
        l.put(com.rtk.app.tool.y.z("limit"), PointType.SIGMOB_APP);
        if (!TextUtils.isEmpty(this.r)) {
            l.put("keyword", this.r);
            l.put(com.rtk.app.tool.y.z("mid"), this.x);
            str = "family/bbs/search";
        } else {
            l.put("mid", this.x);
            l.put(com.rtk.app.tool.y.z("tag"), "0");
            l.put(com.rtk.app.tool.y.z(com.umeng.analytics.pro.d.y), "release");
            str = "family/bbs/list/posts";
        }
        l.put("key", com.rtk.app.tool.t.L(l));
        String w = com.rtk.app.tool.y.w(str, l);
        com.rtk.app.tool.c0.u("FamilyPostSearchActivity", "  社区地址    " + com.rtk.app.tool.y.e + w);
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(w));
    }

    public void S() {
        this.s = 1;
        P(new int[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("FamilyPostSearchActivity", "我的帖子关注列表  " + str);
        if (i != 1) {
            return;
        }
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        this.t = (CommunityPostBean) this.g.fromJson(str, CommunityPostBean.class);
        if (this.s == 1) {
            this.u.clear();
            if (!com.rtk.app.tool.y.x(this)) {
                g(ErrorCode.NETWORK_TIMEOUT, "请先登录", 1);
                return;
            }
        }
        F();
        this.u.addAll(this.t.getData());
        this.s++;
        if (this.t.getData().size() < 10) {
            this.v.j(true);
            this.v.k(false, null);
            this.fragmentForRecyclerviewLayoutListView.setIsEnd(true);
        } else {
            this.v.j(false);
            this.v.k(false, null);
        }
        this.v.notifyDataSetChanged();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.family.v
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                FamilyPostSearchActivity.this.R(strArr);
            }
        });
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        com.rtk.app.tool.c0.r("FamilyPostSearchActivity", "code=" + i + "str=" + str + ",mark=" + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
        super.initData();
        this.w = getIntent().getStringExtra("family_id");
        this.x = getIntent().getStringExtra("mid");
        P(new int[0]);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new a());
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new b());
        this.noOOMEditText.addTextChangedListener(new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        this.u = new ArrayList();
        this.fragmentForRecyclerviewLayoutListView.setLayoutManager(new LinearLayoutManager(this));
        this.fragmentForRecyclerviewLayoutListView.addItemDecoration(new DividerItemDecoration(this, 1));
        CommunityFragmentPostListAdapter communityFragmentPostListAdapter = new CommunityFragmentPostListAdapter(this.u, this);
        this.v = communityFragmentPostListAdapter;
        this.fragmentForRecyclerviewLayoutListView.setAdapter(communityFragmentPostListAdapter);
        this.noOOMEditText.setHint("搜索家族帖子");
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_post_search_layout);
        ButterKnife.a(this);
        LinearLayout linearLayout = this.fragmentForRecyclerviewParentLayout;
        G(linearLayout, linearLayout);
    }
}
