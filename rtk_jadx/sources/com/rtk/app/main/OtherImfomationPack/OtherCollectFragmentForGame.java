package com.rtk.app.main.OtherImfomationPack;

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
public class OtherCollectFragmentForGame extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;
    View o;
    Unbinder p;
    private int q = 1;
    private List<DataBean> r;
    private GameListViewAdapter s;
    private String t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(((BaseFragment) OtherCollectFragmentForGame.this).e, new ApkInfo((DataBean) OtherCollectFragmentForGame.this.r.get(i - 1)));
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            OtherCollectFragmentForGame.this.q = 1;
            OtherCollectFragmentForGame.this.w();
            OtherCollectFragmentForGame.this.fragementForListviewListview.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            OtherCollectFragmentForGame.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        w();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.fragementForListviewListview.k();
        c0.u("OtherCollectFragmentForGame", "我的收藏" + str);
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

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void w() {
        Context context = this.e;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("member/collectList");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(this.t);
        sb.append("&page=");
        sb.append(this.q);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + this.t))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnItemClickListener(new a());
        this.fragementForListviewListview.setOnRefreshListener(new b());
        this.fragementForListviewListview.setOnLoadListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.fragementForListviewListview.f();
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.OtherImfomationPack.b
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    OtherCollectFragmentForGame.this.y(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.r = new ArrayList();
        this.t = getArguments().getString("uid");
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
