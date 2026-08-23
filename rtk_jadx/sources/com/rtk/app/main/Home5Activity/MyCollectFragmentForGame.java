package com.rtk.app.main.Home5Activity;

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
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCollectFragmentForGame extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;
    View o;
    Unbinder p;
    private int q = 1;
    private List<DataBean> r;
    private GameListViewAdapter s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(((BaseFragment) MyCollectFragmentForGame.this).e, new ApkInfo((DataBean) MyCollectFragmentForGame.this.r.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.q = 1;
        B();
        this.fragementForListviewListview.setLoadEnable(false);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.fragementForListviewListview.k();
        com.rtk.app.tool.c0.u("MyCollectFragmentForGame", "我的收藏" + str);
        GameListBean gameListBean = (GameListBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GameListBean.class);
        if (gameListBean.getCode() != 0 || gameListBean.getData() == null) {
            return;
        }
        if (this.q == 1) {
            this.r.clear();
        }
        this.q++;
        this.r.addAll(gameListBean.getData());
        this.s.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(gameListBean.getData().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void B() {
        Context context = this.e;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("member/collectList");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.K());
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.G(this.e));
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "uid=" + com.rtk.app.tool.y.K()))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnItemClickListener(new a());
        this.fragementForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.Home5Activity.e0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                MyCollectFragmentForGame.this.z();
            }
        });
        this.fragementForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.Home5Activity.f0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                MyCollectFragmentForGame.this.B();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("MyCollectFragmentForGame", "失效" + str + "   " + com.rtk.app.tool.y.E);
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.g0
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    MyCollectFragmentForGame.this.x(strArr);
                }
            });
        }
        this.fragementForListviewListview.f();
        if (str.equals(com.rtk.app.tool.y.E)) {
            com.rtk.app.tool.c0.u("MyCollectFragmentForGame", "尺寸" + this.r.size());
            this.r.size();
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.r = new ArrayList();
        GameListViewAdapter gameListViewAdapter = new GameListViewAdapter(this.e, this.r);
        this.s = gameListViewAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) gameListViewAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        GameListViewAdapter gameListViewAdapter = this.s;
        if (gameListViewAdapter != null) {
            gameListViewAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_listview_layout, viewGroup, false);
            this.o = inflate;
            this.p = ButterKnife.b(this, inflate);
            b();
            View view2 = this.o;
            r(view2, view2);
        } else {
            this.p = ButterKnife.b(this, view);
        }
        return this.o;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.p.a();
    }
}
