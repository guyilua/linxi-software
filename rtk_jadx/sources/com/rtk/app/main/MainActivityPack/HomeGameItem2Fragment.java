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
import com.rtk.app.adapter.NewestGameListViewAdapter;
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
import org.apache.log4j.Level;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameItem2Fragment extends BaseFragment implements h.j {

    @BindView
    AutoListView homeGameItem2ListView;
    private Unbinder o;
    private List<DataBean> p;
    private NewestGameListViewAdapter q;
    private int r;
    private String s = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            c0.u("HomeGameItem2Fragment", "我被执行了   onLoadMore");
            HomeGameItem2Fragment.this.B();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            c0.u("HomeGameItem2Fragment", "setOnRefreshListener");
            HomeGameItem2Fragment.this.r = 1;
            HomeGameItem2Fragment.this.B();
            HomeGameItem2Fragment.this.homeGameItem2ListView.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(((BaseFragment) HomeGameItem2Fragment.this).e, new ApkInfo((DataBean) HomeGameItem2Fragment.this.p.get(i - 1)));
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
        try {
            this.homeGameItem2ListView.k();
            if (this.r == 1) {
                com.rtk.app.tool.v.h(this.e, getClass().getName() + i, str);
            }
            if (i != 1) {
                return;
            }
            c0.a("HomeGameItem2Fragment", "Home1Item2" + str, 3, new Level[0]);
            GameListBean gameListBean = (GameListBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GameListBean.class);
            if (str.equals(this.s)) {
                return;
            }
            if (this.r == 1) {
                this.p.clear();
            }
            this.r++;
            this.p.addAll(gameListBean.getData());
            this.q.notifyDataSetChanged();
            this.homeGameItem2ListView.setResultSize(gameListBean.getData().size());
        } catch (Exception e) {
            c0.u("HomeGameItem2Fragment", "Gson异常" + e.toString());
        }
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
        sb.append("&model=latest&page=");
        sb.append(this.r);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "games_type=" + y.t(this.e)))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homeGameItem2ListView.setOnLoadListener(new a());
        this.homeGameItem2ListView.setOnRefreshListener(new b());
        this.homeGameItem2ListView.setOnItemClickListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.homeGameItem2ListView.f();
        if (this.r == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.i
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeGameItem2Fragment.this.y(strArr);
                }
            });
        }
        c0.u("HomeGameItem2Fragment", "Home1Item2请求失败首页请求" + str);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        try {
            d(com.rtk.app.tool.v.d(this.e, getClass().getName() + 1), 1);
        } catch (Exception unused) {
        }
        this.r = 1;
        this.p = new ArrayList();
        NewestGameListViewAdapter newestGameListViewAdapter = new NewestGameListViewAdapter(this.e, this.p);
        this.q = newestGameListViewAdapter;
        this.homeGameItem2ListView.setAdapter((ListAdapter) newestGameListViewAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        this.q.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home_game_item2_layout, viewGroup, false);
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
