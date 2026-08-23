package com.rtk.app.main;

import android.R;
import android.app.Activity;
import android.content.Context;
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
import com.rtk.app.adapter.LibaolistViewAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.LiBaoListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class LiBaoSearchActivity extends BaseActivity implements h.j {

    @BindView
    LinearLayout libaoSearchListLayout;

    @BindView
    AutoListView libaoSearchListListView;

    @BindView
    TextView libaoSearchListTitle;
    private String q;
    private Context r;
    private int s = 1;
    public List<LiBaoListBean.DataBean> t;
    private LibaolistViewAdapter u;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            LiBaoSearchActivity.this.N(new int[0]);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            LiBaoSearchActivity.this.s = 1;
            LiBaoSearchActivity.this.N(new int[0]);
            LiBaoSearchActivity.this.libaoSearchListListView.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            if (LiBaoSearchActivity.this.t.size() == 0) {
                return;
            }
            Context context = LiBaoSearchActivity.this.r;
            StringBuilder sb = new StringBuilder();
            int i2 = i - 1;
            sb.append(LiBaoSearchActivity.this.t.get(i2).getGift_id());
            sb.append("");
            com.rtk.app.tool.t.f0(context, sb.toString(), 11, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(String[] strArr) {
        N(new int[0]);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.r, this.libaoSearchListLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void N(int... iArr) {
        Context context = this.r;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/list_by_search");
        sb.append(com.rtk.app.tool.y.u(this.r));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&words=");
        sb.append(this.q);
        sb.append("&page=");
        sb.append(this.s);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, "words=" + this.q))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(com.rtk.app.tool.y.d);
        sb2.append("game/list_by_search");
        sb2.append(com.rtk.app.tool.y.u(this.r));
        sb2.append(com.rtk.app.tool.y.K());
        sb2.append("&words=");
        sb2.append(this.q);
        sb2.append("&page=");
        sb2.append(this.s);
        sb2.append("&key=");
        sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.r, "words=" + this.q))));
        com.rtk.app.tool.c0.u("LiBaoSearchActivity", sb2.toString());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.a("LiBaoSearchActivity", "礼包搜索页面" + str, 2, new Level[0]);
        this.libaoSearchListListView.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i != 1) {
            return;
        }
        LiBaoListBean liBaoListBean = (LiBaoListBean) create.fromJson(str, LiBaoListBean.class);
        if (this.s == 1) {
            this.t.clear();
        }
        this.s++;
        this.t.addAll(liBaoListBean.getData());
        this.u.notifyDataSetChanged();
        this.libaoSearchListListView.setResultSize(liBaoListBean.getData().size());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.libaoSearchListListView.f();
        if (this.s == 1) {
            I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.s
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    LiBaoSearchActivity.this.P(strArr);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = getIntent().getExtras().getString("searchContent");
        this.libaoSearchListTitle.setText("搜索礼包：" + this.q);
        LiBaoListActivity.w = true;
        this.q = com.rtk.app.tool.t.f(this.q);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.libaoSearchListListView.setOnLoadListener(new a());
        this.libaoSearchListListView.setOnRefreshListener(new b());
        this.libaoSearchListListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.t = new ArrayList();
        LibaolistViewAdapter libaolistViewAdapter = new LibaolistViewAdapter(this.r, this.t);
        this.u = libaolistViewAdapter;
        this.libaoSearchListListView.setAdapter((ListAdapter) libaolistViewAdapter);
        N(new int[0]);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298959) {
            return;
        }
        com.rtk.app.tool.c.a((Activity) this.r);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_li_bao_search);
        ButterKnife.a(this);
        this.r = this;
    }
}
