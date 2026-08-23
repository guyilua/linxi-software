package com.rtk.app.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
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
public class SearchPermissionGameFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;

    @BindView
    LinearLayout fragementForListviewParentLayout;
    Unbinder o;
    public int p = 1;
    private List<DataBean> q;
    private GameListViewAdapter r;
    private String s;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.e0(((BaseFragment) SearchPermissionGameFragment.this).e, new ApkInfo((DataBean) SearchPermissionGameFragment.this.q.get(i - 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        com.rtk.app.tool.c0.u("SearchPermissionGameFragment", "setOnRefreshListener");
        this.p = 1;
        C();
        this.fragementForListviewListview.setLoadEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(String[] strArr) {
        C();
    }

    public void C(String str) {
        this.s = str;
        this.p = 1;
        C();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.fragementForListviewListview.k();
        if (i != 1) {
            return;
        }
        GameListBean gameListBean = (GameListBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, GameListBean.class);
        if (gameListBean.getCode() != 0 || gameListBean.getData() == null) {
            return;
        }
        if (this.p == 1) {
            this.q.clear();
        }
        this.p++;
        this.q.addAll(gameListBean.getData());
        this.r.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(gameListBean.getData().size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void z() {
        Context context = this.e;
        if (context == null) {
            return;
        }
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("game/gamelist");
        sb.append(com.rtk.app.tool.y.u(this.e));
        sb.append("&games_type=");
        sb.append(com.rtk.app.tool.y.t(this.e));
        sb.append("&search_words=");
        sb.append(this.s);
        sb.append("&page=");
        sb.append(this.p);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.e, "games_type=" + com.rtk.app.tool.y.t(this.e)))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.y
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                SearchPermissionGameFragment.this.z();
            }
        });
        this.fragementForListviewListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.a0
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                SearchPermissionGameFragment.this.B();
            }
        });
        this.fragementForListviewListview.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.p == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.z
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    SearchPermissionGameFragment.this.x(strArr);
                }
            });
        }
        this.fragementForListviewListview.f();
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.s = getArguments().getString("searchStr");
        this.q = new ArrayList();
        GameListViewAdapter gameListViewAdapter = new GameListViewAdapter(this.e, this.q);
        this.r = gameListViewAdapter;
        this.fragementForListviewListview.setAdapter((ListAdapter) gameListViewAdapter);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        GameListViewAdapter gameListViewAdapter = this.r;
        if (gameListViewAdapter != null) {
            gameListViewAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.fragement_for_listview_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
            LinearLayout linearLayout = this.fragementForListviewParentLayout;
            r(linearLayout, linearLayout);
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }
}
