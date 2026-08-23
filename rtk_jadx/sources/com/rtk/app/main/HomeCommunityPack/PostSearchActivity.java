package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
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
import com.sigmob.sdk.downloader.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class PostSearchActivity extends BaseActivity implements h.j {

    @BindView
    TextView postSearchBack;

    @BindView
    View postSearchHistoryLayout;

    @BindView
    LinearLayout postSearchParent;

    @BindView
    YcRecyclerView postSearchRecyclerView;

    @BindView
    ImageView postSearchSearchBtu;

    @BindView
    EditText postSearchSearchEdit;

    @BindView
    SwipeRefreshLayout postSearchSwipeRefresh;

    @BindView
    TextView postSearchThisModule;

    @BindView
    LinearLayout postSearchTopLayout;
    private String q = "";
    private int r = 1;
    private String s;

    @BindView
    TextView searchHistoryClear;
    private List<CommunityPostBean.DataBean> t;
    private CommunityFragmentPostListAdapter u;
    private CommunityPostBean v;
    private SearchHistoryViewHolder w;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            PostSearchActivity.this.postSearchSearchEdit.setText(((TextView) view).getText().toString());
            PostSearchActivity postSearchActivity = PostSearchActivity.this;
            postSearchActivity.s = postSearchActivity.postSearchSearchEdit.getText().toString().trim();
            PostSearchActivity.this.r = 1;
            if (com.rtk.app.tool.c0.q(PostSearchActivity.this.s)) {
                return;
            }
            PostSearchActivity postSearchActivity2 = PostSearchActivity.this;
            postSearchActivity2.G(null, postSearchActivity2.postSearchTopLayout);
            PostSearchActivity.this.P(1);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().length() == 0) {
                PostSearchActivity.this.Y(true);
            }
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
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(String[] strArr) {
        this.postSearchRecyclerView.setRefreshing(true);
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V() {
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X() {
        P(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(boolean z) {
        this.postSearchHistoryLayout.setVisibility(z ? 0 : 8);
        this.postSearchSwipeRefresh.setVisibility(z ? 8 : 0);
        if (z) {
            this.w.i();
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.postSearchTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void P(int... iArr) {
        Y(false);
        if (this.r == 1) {
            LinearLayout linearLayout = this.postSearchParent;
            G(linearLayout, linearLayout);
        }
        String str = "";
        if (iArr[0] == 1) {
            if (com.rtk.app.tool.y.x(this.f147c)) {
                str = "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H();
            }
            str = "members/bbsSearch" + com.rtk.app.tool.y.u(this.f147c) + "&keyword=" + this.s + str + "&page=" + this.r + "&limit=10" + com.rtk.app.tool.y.J(this.f147c) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        com.rtk.app.tool.c0.u("PostSearchActivity", "搜索    " + com.rtk.app.tool.y.d + str);
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        this.postSearchSwipeRefresh.setRefreshing(false);
        com.rtk.app.tool.c0.u("PostSearchActivity", "搜索结果" + str);
        if (i != 1) {
            return;
        }
        this.postSearchRecyclerView.setRefreshing(false);
        this.v = (CommunityPostBean) this.g.fromJson(str, CommunityPostBean.class);
        if (this.r == 1) {
            this.t.clear();
        }
        this.t.addAll(this.v.getData());
        this.r++;
        if (this.v.getData().size() < 10) {
            this.u.j(true);
            this.u.k(false, null);
            this.postSearchRecyclerView.setIsEnd(true);
        } else {
            this.u.j(false);
            this.u.k(false, null);
        }
        this.u.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("PostSearchActivity", "帖子搜索加载失败了" + str);
        if (this.r == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.v
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    PostSearchActivity.this.R(strArr);
                }
            });
        }
        this.u.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.HomeCommunityPack.u
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                PostSearchActivity.this.T(strArr);
            }
        });
        this.postSearchSwipeRefresh.setRefreshing(false);
        this.postSearchRecyclerView.setRefreshing(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        String string = getIntent().getExtras().getString("mid", null);
        this.q = string;
        this.postSearchThisModule.setVisibility(com.rtk.app.tool.c0.q(string) ? 8 : 0);
        this.t = new ArrayList();
        this.postSearchRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.u = new CommunityFragmentPostListAdapter(this.t, this.f147c);
        this.postSearchRecyclerView.addItemDecoration(new DividerItemDecoration(this.f147c, 1));
        this.postSearchRecyclerView.setAdapter(this.u);
        this.postSearchSearchEdit.setFocusable(true);
        this.postSearchSearchEdit.setFocusableInTouchMode(true);
        this.postSearchSearchEdit.requestFocus();
        ((InputMethodManager) this.f147c.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.postSearchSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.HomeCommunityPack.s
            public final void onRefresh() {
                PostSearchActivity.this.V();
            }
        });
        this.postSearchRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.HomeCommunityPack.t
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                PostSearchActivity.this.X();
            }
        });
        this.postSearchSearchEdit.addTextChangedListener(new b());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.w = new SearchHistoryViewHolder(this.f147c, this.postSearchHistoryLayout, com.rtk.app.tool.v.e, new a());
        Y(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131299878) {
            finish();
            return;
        }
        if (id != 2131299888) {
            if (id != 2131299891) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mid", this.q);
            bundle.putString("searchStr", this.s);
            com.rtk.app.tool.c.b(this.f147c, PostSearchForModuleActivity.class, bundle);
            return;
        }
        String trim = this.postSearchSearchEdit.getText().toString().trim();
        this.s = trim;
        this.r = 1;
        if (!com.rtk.app.tool.c0.q(trim)) {
            String d = com.rtk.app.tool.v.d(this.f147c, com.rtk.app.tool.v.e);
            if (!com.rtk.app.tool.c0.d(d, "\\|").contains(this.s)) {
                com.rtk.app.tool.v.h(this.f147c, com.rtk.app.tool.v.e, d + "|" + this.s);
            }
            G(null, this.postSearchTopLayout);
            P(1);
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "请输入搜索内容", f.a.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_post_search);
        ButterKnife.a(this);
    }
}
