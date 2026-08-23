package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.main.HomeCommunityPack.PostAdapter.PostSelectPostListAdapter;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSelectPostActivity extends BaseActivity implements h.j {

    @BindView
    TextView postSelectPostBack;

    @BindView
    YcRecyclerView postSelectPostListView;

    @BindView
    TextView postSelectPostSearchBtu;

    @BindView
    EditText postSelectPostSearchEdit;

    @BindView
    SwipeRefreshLayout postSelectPostSwipeRefresh;

    @BindView
    TextView postSelectPostTips;

    @BindView
    LinearLayout postSelectPostTopLayout;
    private String q;
    private int r = 1;
    private List<CommunityPostBean.DataBean> s;
    private PostSelectPostListAdapter t;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        this.postSelectPostListView.setRefreshing(true);
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R() {
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T() {
        this.r = 1;
        L(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postSelectPostTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        if (this.r == 1) {
            G(null, this.postSelectPostTopLayout);
        }
        if (iArr[0] == 1 || iArr[0] == 2) {
            iArr[0] = com.rtk.app.tool.c0.q(this.q) ? 1 : 2;
        }
        int i = iArr[0];
        String str = "";
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("members/myPosts");
            sb.append(com.rtk.app.tool.y.u(this.f147c));
            sb.append("&uid=");
            sb.append(com.rtk.app.tool.y.K());
            sb.append("&token=");
            sb.append(com.rtk.app.tool.y.H());
            sb.append("&page=");
            sb.append(this.r);
            sb.append("&limit=10&key=");
            sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            str = sb.toString();
        } else if (i == 2) {
            if (com.rtk.app.tool.y.x(this.f147c)) {
                str = "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H();
            }
            str = "members/bbsSearch" + com.rtk.app.tool.y.u(this.f147c) + "&keyword=" + this.q + str + "&page=" + this.r + "&limit=10" + com.rtk.app.tool.y.J(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
        com.rtk.app.tool.c0.u("PostSelectPostActivity", "插入帖子的的帖子列表" + com.rtk.app.tool.y.d + str);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.postSelectPostSwipeRefresh.setRefreshing(false);
        com.rtk.app.tool.c0.u("PostSelectPostActivity", "社区帖子选择列表  " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1 || i == 2) {
            this.postSelectPostListView.setRefreshing(false);
            CommunityPostBean communityPostBean = (CommunityPostBean) create.fromJson(str, CommunityPostBean.class);
            if (this.r == 1) {
                this.s.clear();
            }
            this.s.addAll(communityPostBean.getData());
            this.r++;
            if (communityPostBean.getData().size() < 10) {
                this.t.j(true);
                this.t.k(false, null);
                this.postSelectPostListView.setIsEnd(true);
            } else {
                this.t.j(false);
                this.t.k(false, null);
            }
            this.t.notifyDataSetChanged();
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.postSelectPostSearchEdit.clearFocus();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.postSelectPostSwipeRefresh.setRefreshing(false);
        this.postSelectPostListView.setRefreshing(false);
        if (this.r == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.b0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostSelectPostActivity.this.N(strArr);
                }
            });
        }
        this.t.j(true);
        this.t.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.d0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostSelectPostActivity.this.P(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.s = new ArrayList();
        L(1);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postSelectPostListView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.HomeCommunityPack.e0
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                PostSelectPostActivity.this.R();
            }
        });
        this.postSelectPostSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.HomeCommunityPack.c0
            public final void onRefresh() {
                PostSelectPostActivity.this.T();
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.postSelectPostListView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.t = new PostSelectPostListAdapter(this.s, this.f147c);
        this.postSelectPostListView.addItemDecoration(new DividerItemDecoration(this.f147c, 1));
        this.postSelectPostListView.setAdapter(this.t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299899) {
            finish();
            return;
        }
        if (id != 2131299901) {
            return;
        }
        String trim = this.postSelectPostSearchEdit.getText().toString().trim();
        this.q = trim;
        this.postSelectPostTips.setVisibility(com.rtk.app.tool.c0.q(trim) ? 0 : 8);
        this.r = 1;
        if (!com.rtk.app.tool.c0.q(this.q)) {
            L(2);
        } else {
            com.rtk.app.tool.f.a(this.f147c, "请输入搜索内容", f.a.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_select_post);
        ButterKnife.a(this);
    }
}
