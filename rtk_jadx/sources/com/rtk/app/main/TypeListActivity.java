package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.adapter.GameListViewAdapter;
import com.rtk.app.adapter.NewestGameListViewAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.GameListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TypeListActivity extends BaseActivity implements View.OnClickListener, h.j {
    private Activity q;
    private NewestGameListViewAdapter t;

    @BindView
    TextView typeListBack;

    @BindView
    MarkedImageView typeListDownload;

    @BindView
    LinearLayout typeListLayout;

    @BindView
    AutoListView typeListListView;
    private GameListViewAdapter u;
    private String r = "";
    private List<DataBean> s = new ArrayList();
    private int v = 1;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.c {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            TypeListActivity.this.v = 1;
            TypeListActivity.this.O(new int[0]);
            TypeListActivity.this.typeListListView.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            TypeListActivity.this.O(new int[0]);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(TypeListActivity.this.q, new ApkInfo((DataBean) TypeListActivity.this.s.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(String[] strArr) {
        O(new int[0]);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.q, this.typeListLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void O(int... iArr) {
        Activity activity = this.q;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/gamelist");
        sb.append(com.rtk.app.tool.y.u(this.q));
        sb.append("&games_type=");
        sb.append(com.rtk.app.tool.y.t(this.q));
        sb.append("&model=");
        sb.append(this.r);
        sb.append("&page=");
        sb.append(this.v);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.q, "games_type=" + com.rtk.app.tool.y.t(this.q)))));
        com.rtk.app.tool.o.h.l(activity, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.typeListListView.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        GameListBean gameListBean = (GameListBean) create.fromJson(str, GameListBean.class);
        if (this.v == 1) {
            this.s.clear();
        }
        this.v++;
        this.s.addAll(gameListBean.getData());
        NewestGameListViewAdapter newestGameListViewAdapter = this.t;
        if (newestGameListViewAdapter != null) {
            newestGameListViewAdapter.notifyDataSetChanged();
        } else {
            this.u.notifyDataSetChanged();
        }
        this.typeListListView.setResultSize(gameListBean.getData().size());
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        GameListViewAdapter gameListViewAdapter = this.u;
        if (gameListViewAdapter != null) {
            gameListViewAdapter.b();
        }
        NewestGameListViewAdapter newestGameListViewAdapter = this.t;
        if (newestGameListViewAdapter != null) {
            newestGameListViewAdapter.b();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.typeListListView.f();
        if (this.v == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.k0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    TypeListActivity.this.Q(strArr);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.r = getIntent().getExtras().getString(com.umeng.analytics.pro.d.y);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.typeListListView.setOnRefreshListener(new a());
        this.typeListListView.setOnLoadListener(new b());
        this.typeListListView.setOnItemClickListener(new c());
        this.b = new com.rtk.app.tool.DownLoadTool.n(this.typeListDownload);
        com.rtk.app.tool.DownLoadTool.x.c().b(this.b);
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        if (this.r.equals("newest")) {
            NewestGameListViewAdapter newestGameListViewAdapter = new NewestGameListViewAdapter(this.q, this.s);
            this.t = newestGameListViewAdapter;
            this.typeListListView.setAdapter((ListAdapter) newestGameListViewAdapter);
            this.typeListBack.setText("最新");
        } else {
            GameListViewAdapter gameListViewAdapter = new GameListViewAdapter(this.q, this.s);
            this.u = gameListViewAdapter;
            this.typeListListView.setAdapter((ListAdapter) gameListViewAdapter);
            this.typeListBack.setText("精品");
        }
        O(new int[0]);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.type_list_back /* 2131300555 */:
                com.rtk.app.tool.c.a(this.q);
                return;
            case com.rtk.app.R.id.type_list_download /* 2131300556 */:
                com.rtk.app.tool.t.o0(this.q);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_type_list);
        ButterKnife.a(this);
        this.q = this;
    }
}
