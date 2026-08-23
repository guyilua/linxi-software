package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.CommunityFragmentPostListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.CommunityPostBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSearchForModuleActivity extends BaseActivity implements h.j {

    @BindView
    TextView postSearchForModuleBack;

    @BindView
    YcRecyclerView postSearchForModuleRecyclerView;

    @BindView
    ImageView postSearchForModuleSearchBtu;

    @BindView
    EditText postSearchForModuleSearchEdit;

    @BindView
    SwipeRefreshLayout postSearchForModuleSwipeRefresh;

    @BindView
    LinearLayout postSearchForModuleTopLayout;
    private String q = "";
    private String r = "";
    private int s = 1;
    private List<CommunityPostBean.DataBean> t;
    private CommunityFragmentPostListAdapter u;
    private CommunityPostBean v;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        this.postSearchForModuleRecyclerView.setRefreshing(true);
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
        L(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postSearchForModuleTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String str = "";
        if (iArr[0] == 1) {
            if (com.rtk.app.tool.y.x(this.f147c)) {
                str = "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H();
            }
            str = "members/bbsSearch" + com.rtk.app.tool.y.u(this.f147c) + "&mid=" + this.q + str + "&keyword=" + this.r + "&page=" + this.s + "&limit=10" + com.rtk.app.tool.y.J(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        com.rtk.app.tool.c0.u("PostSearchForModuleActivity", "搜索本板块下 " + com.rtk.app.tool.y.d + str);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.postSearchForModuleSwipeRefresh.setRefreshing(false);
        this.postSearchForModuleRecyclerView.setRefreshing(false);
        if (i != 1) {
            return;
        }
        this.postSearchForModuleRecyclerView.setRefreshing(false);
        this.v = (CommunityPostBean) this.g.fromJson(str, CommunityPostBean.class);
        if (this.s == 1) {
            this.t.clear();
        }
        this.t.addAll(this.v.getData());
        this.s++;
        if (this.v.getData().size() < 10) {
            this.u.j(true);
            this.u.k(false, null);
            this.postSearchForModuleRecyclerView.setIsEnd(true);
        } else {
            this.u.j(false);
            this.u.k(false, null);
        }
        this.u.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.postSearchForModuleSwipeRefresh.setRefreshing(false);
        this.postSearchForModuleRecyclerView.setRefreshing(false);
        if (this.s == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.w
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostSearchForModuleActivity.this.N(strArr);
                }
            });
        }
        this.u.j(true);
        this.u.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.x
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostSearchForModuleActivity.this.P(strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = extras.getString("searchStr");
        this.q = extras.getString("mid");
        this.postSearchForModuleSearchEdit.setText(this.r);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postSearchForModuleSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.HomeCommunityPack.y
            public final void onRefresh() {
                PostSearchForModuleActivity.this.R();
            }
        });
        this.postSearchForModuleRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.HomeCommunityPack.z
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                PostSearchForModuleActivity.this.T();
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.t = new ArrayList();
        this.postSearchForModuleRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.u = new CommunityFragmentPostListAdapter(this.t, this.f147c);
        this.postSearchForModuleRecyclerView.addItemDecoration(new DividerItemDecoration(this.f147c, 1));
        this.postSearchForModuleRecyclerView.setAdapter(this.u);
        L(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299879) {
            finish();
            return;
        }
        if (id != 2131299881) {
            return;
        }
        String trim = this.postSearchForModuleSearchEdit.getText().toString().trim();
        this.r = trim;
        if (com.rtk.app.tool.c0.q(trim)) {
            return;
        }
        L(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_search_for_module);
        ButterKnife.a(this);
    }
}
