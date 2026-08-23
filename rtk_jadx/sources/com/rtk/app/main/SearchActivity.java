package com.rtk.app.main;

import android.R;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.GameListViewAdapter;
import com.rtk.app.adapter.c3;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.GameListBean;
import com.rtk.app.bean.HotSearchBean;
import com.rtk.app.bean.SearchPermissionBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class SearchActivity extends BaseActivity implements h.j {

    @BindView
    LinearLayout hotSearchLayout;
    private List<DataBean> q;
    private List<String> r;
    private List<String> s;

    @BindView
    TextView searchBtu;

    @BindView
    TextView searchClear;

    @BindView
    EditText searchEdt;

    @BindView
    TagFlowLayout searchFlowlayout;

    @BindView
    LinearLayout searchFlowlayoutTitle;

    @BindView
    LinearLayout searchHistory;

    @BindView
    TagFlowLayout searchHotFlowlayout;

    @BindView
    AutoListView searchListView;

    @BindView
    LinearLayout searchListViewEmpty;

    @BindView
    TextView searchTopTitle;
    private GameListViewAdapter t;

    @BindView
    LinearLayout tagListTopLayout;
    private c3 w;
    private c3 x;
    private int u = 1;
    private String v = "";
    private int y = 0;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchActivity.this.searchEdt.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) SearchActivity.this.f147c.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(SearchActivity.this.searchEdt, 0);
            }
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            SearchActivity.this.searchHistory.setVisibility(8);
            SearchActivity.this.searchFlowlayoutTitle.setVisibility(8);
            SearchActivity.this.searchFlowlayoutTitle.setVisibility(8);
            SearchActivity.this.a0();
            com.rtk.app.tool.f.a(SearchActivity.this.f147c, "已删除该历史", f.a.f);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            SearchActivity.this.v = strArr[0];
            SearchActivity.this.r.remove(SearchActivity.this.v);
            SearchActivity.this.r.add(SearchActivity.this.v);
            SearchActivity searchActivity = SearchActivity.this;
            searchActivity.searchEdt.setText(searchActivity.v);
            SearchActivity.this.w.e();
            SearchActivity.this.a0();
            SearchActivity searchActivity2 = SearchActivity.this;
            searchActivity2.V(searchActivity2.y);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements com.rtk.app.tool.s {
        d(SearchActivity searchActivity) {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class e implements com.rtk.app.tool.s {
        e() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            SearchActivity.this.u = 1;
            SearchActivity.this.v = strArr[0];
            SearchActivity searchActivity = SearchActivity.this;
            searchActivity.searchEdt.setText(searchActivity.v);
            SearchActivity searchActivity2 = SearchActivity.this;
            searchActivity2.V(searchActivity2.y);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class f implements AutoListView.c {
        f() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            SearchActivity.this.u = 1;
            SearchActivity.this.T();
            SearchActivity.this.searchListView.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class g implements AutoListView.b {
        g() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            SearchActivity.this.T();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class h extends com.rtk.app.custom.AutoListView.b {
        h() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(SearchActivity.this.f147c, new ApkInfo((DataBean) SearchActivity.this.q.get(i - 1)));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class i implements TextView.OnEditorActionListener {
        i() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchActivity.this.b0();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(String[] strArr) {
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z() {
        try {
            ViewGroup.LayoutParams layoutParams = this.searchFlowlayout.getLayoutParams();
            layoutParams.height = this.searchFlowlayout.getChildAt(0).getMeasuredHeight() * 2;
            if (this.searchFlowlayout.getMeasuredHeight() > layoutParams.height) {
                this.searchFlowlayout.setLayoutParams(layoutParams);
            }
        } catch (NullPointerException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            stringBuffer.append(this.r.get(i2) + "||");
        }
        com.rtk.app.tool.v.h(this.f147c, "searchHistroryVALUE", stringBuffer.toString());
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.tagListTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void T() {
        if (this.u == 1) {
            G(null, this.tagListTopLayout);
        }
        this.searchListView.setVisibility(0);
        if (this.searchFlowlayout.getChildCount() > 0) {
            this.searchFlowlayout.getChildAt(0).post(new Runnable() { // from class: com.rtk.app.main.x
                @Override // java.lang.Runnable
                public final void run() {
                    SearchActivity.this.Z();
                }
            });
        }
        this.v = this.v.replaceAll("&", "");
        AppCompatActivity appCompatActivity = this.f147c;
        com.rtk.app.tool.o.i h2 = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/gamelist");
        sb.append(com.rtk.app.tool.y.u(this.f147c));
        sb.append("&games_type=");
        sb.append(com.rtk.app.tool.y.t(this.f147c));
        sb.append("&search_words=");
        sb.append(this.v);
        sb.append("&page=");
        sb.append(this.u);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "games_type=" + com.rtk.app.tool.y.t(this.f147c)))));
        com.rtk.app.tool.o.h.l(appCompatActivity, this, 1, h2.a(sb.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U(int... iArr) {
        String str;
        int i2 = iArr[0];
        if (i2 == 2) {
            str = "game/gameSearchHotKeywords" + com.rtk.app.tool.y.u(this) + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, new String[0])));
        } else if (i2 != 4) {
            str = "";
        } else {
            str = "members/searchPermision" + com.rtk.app.tool.y.u(this.f147c) + "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H() + "&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        com.rtk.app.tool.c0.u("SearchActivity", "搜索界面接口  " + com.rtk.app.tool.y.d + str);
        if (com.rtk.app.tool.c0.q(str)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    public void V(int i2) {
        this.v = this.v.replaceAll("&", "");
        Bundle bundle = new Bundle();
        bundle.putInt("searchPermission", i2);
        bundle.putString("searchStr", this.v);
        com.rtk.app.tool.c.b(this.f147c, SearchHasPermissionActivity.class, bundle);
    }

    public void b0() {
        String trim = this.searchEdt.getText().toString().trim();
        this.v = trim;
        String replaceAll = trim.replaceAll("&", "");
        this.v = replaceAll;
        this.u = 1;
        if (this.r.contains(replaceAll)) {
            this.r.remove(this.v);
        }
        this.r.add(this.v);
        a0();
        V(this.y);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i2) {
        this.searchListView.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i2 != 1) {
            if (i2 == 2) {
                this.s.addAll(((HotSearchBean) create.fromJson(str, HotSearchBean.class)).getData());
                this.x.e();
                return;
            } else {
                if (i2 != 4) {
                    return;
                }
                com.rtk.app.tool.c0.u("SearchActivity", "搜索权限" + str);
                this.y = ((SearchPermissionBean) create.fromJson(str, SearchPermissionBean.class)).getData().getSearchPermision().intValue();
                return;
            }
        }
        F();
        View emptyView = this.searchListView.getEmptyView();
        LinearLayout linearLayout = this.searchListViewEmpty;
        if (emptyView != linearLayout) {
            this.searchListView.setEmptyView(linearLayout);
        }
        com.rtk.app.tool.c0.a("SearchActivity", "搜索" + str, 2, new Level[0]);
        GameListBean gameListBean = (GameListBean) create.fromJson(str, GameListBean.class);
        if (this.u == 1) {
            this.q.clear();
        }
        this.u++;
        this.q.addAll(gameListBean.getData());
        this.t.notifyDataSetChanged();
        this.searchListView.setResultSize(gameListBean.getData().size());
        com.rtk.app.tool.t.l1(this.f147c);
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.t.b();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i2, String str, int i3) {
        this.searchListView.f();
        com.rtk.app.tool.c0.u("SearchActivity", "热门搜索" + str + i3);
        if (i3 == 1) {
            if (this.u == 1) {
                I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.w
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        SearchActivity.this.X(strArr);
                    }
                });
            }
            View emptyView = this.searchListView.getEmptyView();
            LinearLayout linearLayout = this.searchListViewEmpty;
            if (emptyView != linearLayout) {
                this.searchListView.setEmptyView(linearLayout);
            }
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        try {
            this.r.addAll(com.rtk.app.tool.c0.d(com.rtk.app.tool.v.d(this.f147c, "searchHistroryVALUE"), "\\|\\|"));
        } catch (Exception unused) {
        }
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.searchListView.setOnRefreshListener(new f());
        this.searchListView.setOnLoadListener(new g());
        this.searchListView.setOnItemClickListener(new h());
        this.searchEdt.setOnEditorActionListener(new i());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.searchEdt.post(new a());
        GameListViewAdapter gameListViewAdapter = new GameListViewAdapter(this.f147c, this.q);
        this.t = gameListViewAdapter;
        this.searchListView.setAdapter((ListAdapter) gameListViewAdapter);
        this.searchListViewEmpty.setVisibility(8);
        this.w = new c3(this.r, this.f147c, new b(), new c());
        this.x = new c3(this.s, this.f147c, new d(this), new e());
        this.w.l();
        this.w.m();
        this.searchFlowlayout.setAdapter(this.w);
        this.searchHotFlowlayout.setAdapter(this.x);
        U(2);
        U(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300082) {
            b0();
            return;
        }
        if (id != 2131300086) {
            if (id != 2131300126) {
                return;
            }
            com.rtk.app.tool.c.a(this);
        } else {
            com.rtk.app.tool.v.h(this.f147c, "searchHistroryVALUE", "");
            this.searchFlowlayout.removeAllViews();
            this.r.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_search);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        this.t.notifyDataSetChanged();
    }
}
