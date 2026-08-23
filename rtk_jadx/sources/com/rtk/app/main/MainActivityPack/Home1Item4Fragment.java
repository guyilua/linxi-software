package com.rtk.app.main.MainActivityPack;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.GameListViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.GameListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home1Item4Fragment extends BaseFragment implements h.j {

    @BindView
    AutoListView home1Item4ListView;
    private Unbinder o;
    private List<DataBean> p;
    private GameListViewAdapter q;
    private int r = 1;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            Home1Item4Fragment.this.B();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            c0.u("Home1Item4Fragment", "setOnRefreshListener");
            Home1Item4Fragment.this.r = 1;
            Home1Item4Fragment.this.B();
            Home1Item4Fragment.this.home1Item4ListView.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(((BaseFragment) Home1Item4Fragment.this).e, new ApkInfo((DataBean) Home1Item4Fragment.this.p.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        B();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.home1Item4ListView.k();
        if (i != 1) {
            return;
        }
        GameListBean gameListBean = (GameListBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GameListBean.class);
        if (gameListBean.getCode() != 0 || gameListBean.getData() == null) {
            return;
        }
        if (this.r == 1) {
            this.p.clear();
        }
        this.r++;
        this.p.addAll(gameListBean.getData());
        this.q.notifyDataSetChanged();
        this.home1Item4ListView.setResultSize(gameListBean.getData().size());
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void B() {
        Context context = this.e;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/gamelist");
        sb.append(y.u(this.e));
        sb.append("&games_type=");
        sb.append(y.t(this.e));
        sb.append("&model=boutique&page=");
        sb.append(this.r);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "games_type=" + y.t(this.e)))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.home1Item4ListView.setOnLoadListener(new a());
        this.home1Item4ListView.setOnRefreshListener(new b());
        this.home1Item4ListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.r == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.d
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    Home1Item4Fragment.this.y(strArr);
                }
            });
        }
        this.home1Item4ListView.f();
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.p = new ArrayList();
        GameListViewAdapter gameListViewAdapter = new GameListViewAdapter(this.e, this.p);
        this.q = gameListViewAdapter;
        this.home1Item4ListView.setAdapter((ListAdapter) gameListViewAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home1_item4_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
            View view2 = this.a;
            r(view2, view2);
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
        this.q.notifyDataSetChanged();
    }
}
