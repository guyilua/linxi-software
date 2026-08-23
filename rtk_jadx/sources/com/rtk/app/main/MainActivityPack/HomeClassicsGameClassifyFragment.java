package com.rtk.app.main.MainActivityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.HomeClassicsGameClassifyFeatureGridViewAdapter;
import com.rtk.app.adapter.HomeClassicsGameClassifyNormalGridViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.ClassifyBean;
import com.rtk.app.custom.GridViewForScrollView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeClassicsGameClassifyFragment extends BaseFragment implements h.j {

    @BindView
    GridViewForScrollView homeClassicsGameClassifyLayoutFeatureGridView;

    @BindView
    GridViewForScrollView homeClassicsGameClassifyLayoutNormalGridView;

    @BindView
    LinearLayout homeClassicsGameClassifyLayoutParentLayout;

    @BindView
    SwipeRefreshLayout homeClassicsGameClassifySwipeLayout;
    private Unbinder o;
    private List<ClassifyBean.DataBean.NormalTypeBean> p;
    private List<ClassifyBean.DataBean.FeatureTypeBean> q;
    private ClassifyBean r;
    private HomeClassicsGameClassifyNormalGridViewAdapter s;
    private HomeClassicsGameClassifyFeatureGridViewAdapter t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            HashMap hashMap = new HashMap();
            hashMap.put("games_type", ((ClassifyBean.DataBean.NormalTypeBean) HomeClassicsGameClassifyFragment.this.p.get(i)).getType_id() + "");
            com.rtk.app.tool.t.T0(((BaseFragment) HomeClassicsGameClassifyFragment.this).e, ((ClassifyBean.DataBean.NormalTypeBean) HomeClassicsGameClassifyFragment.this.p.get(i)).getType_name(), hashMap);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b extends com.rtk.app.custom.AutoListView.b {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            HashMap hashMap = new HashMap();
            hashMap.put("tags_id", ((ClassifyBean.DataBean.FeatureTypeBean) HomeClassicsGameClassifyFragment.this.q.get(i)).getTag_id() + "");
            hashMap.put("tags_type", ((ClassifyBean.DataBean.FeatureTypeBean) HomeClassicsGameClassifyFragment.this.q.get(i)).getTag_type() + "");
            com.rtk.app.tool.t.T0(((BaseFragment) HomeClassicsGameClassifyFragment.this).e, ((ClassifyBean.DataBean.FeatureTypeBean) HomeClassicsGameClassifyFragment.this.q.get(i)).getTag_name(), hashMap);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements SwipeRefreshLayout.OnRefreshListener {
        c() {
        }

        public void onRefresh() {
            HomeClassicsGameClassifyFragment.this.w();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements com.rtk.app.tool.s {
        d() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            HomeClassicsGameClassifyFragment.this.w();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.homeClassicsGameClassifySwipeLayout.setRefreshing(false);
        if (i != 1) {
            return;
        }
        this.p.clear();
        this.q.clear();
        ClassifyBean classifyBean = (ClassifyBean) new GsonBuilder().enableComplexMapKeySerialization().create().fromJson(str, ClassifyBean.class);
        this.r = classifyBean;
        this.p.addAll(classifyBean.getData().getNormalType());
        this.s.notifyDataSetChanged();
        this.q.addAll(this.r.getData().getFeatureType());
        this.t.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void w() {
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("game/classcategory" + y.u(this.e) + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])))));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homeClassicsGameClassifyLayoutNormalGridView.setOnItemClickListener(new a());
        this.homeClassicsGameClassifyLayoutFeatureGridView.setOnItemClickListener(new b());
        this.homeClassicsGameClassifySwipeLayout.setOnRefreshListener(new c());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.homeClassicsGameClassifySwipeLayout.setRefreshing(false);
        t(str, new d());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.s = new HomeClassicsGameClassifyNormalGridViewAdapter(this.e, this.p);
        this.t = new HomeClassicsGameClassifyFeatureGridViewAdapter(this.e, this.q);
        this.homeClassicsGameClassifyLayoutNormalGridView.setAdapter((ListAdapter) this.s);
        this.homeClassicsGameClassifyLayoutFeatureGridView.setAdapter((ListAdapter) this.t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home_classics_game_classify_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
            LinearLayout linearLayout = this.homeClassicsGameClassifyLayoutParentLayout;
            r(linearLayout, linearLayout);
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }
}
