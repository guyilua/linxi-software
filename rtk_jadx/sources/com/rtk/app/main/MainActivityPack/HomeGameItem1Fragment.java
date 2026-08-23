package com.rtk.app.main.MainActivityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.GameRecyclerViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.HomePageAllGameBean;
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameItem1Fragment extends BaseFragment implements h.j {

    @BindView
    LinearLayout home1Item1Parent;

    @BindView
    YcRecyclerView home1Item1RecyclerView;

    @BindView
    SwipeRefreshLayout home1Item1Swiprefresh;
    Unbinder o;
    private View p;
    private View s;
    private List<DataBean> t;
    private List<DataBean> u;
    private List<DataBean> v;
    private List<DataBean> w;
    private GameRecyclerViewAdapter x;
    private HomePageAllGameBean y;
    private String q = "";
    private int r = 1;
    private Map<Integer, String> z = new HashMap();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int i2;
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                GridLayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    i2 = layoutManager.findLastVisibleItemPosition();
                } else if (layoutManager instanceof LinearLayoutManager) {
                    i2 = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                    staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                    i2 = com.rtk.app.tool.t.v(iArr);
                } else {
                    i2 = -1;
                }
                if (i2 == recyclerView.getLayoutManager().getItemCount() - 1) {
                    HomeGameItem1Fragment.this.u(3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u(1);
        u(2);
        u(3);
        u(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        this.home1Item1RecyclerView.setRefreshing(true);
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        this.r = 1;
        u(1);
        u(2);
        u(3);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.home1Item1Swiprefresh.setRefreshing(false);
        q();
        if (str == null) {
            return;
        }
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 1) {
            com.rtk.app.tool.v.h(this.e, "HomeBannerValue" + i, str);
            c0.u("HomeGameItem1Fragment", "游戏Banner" + str);
            this.x.p((UpAdBean) create.fromJson(str, UpAdBean.class));
            if (this.y != null) {
                this.x.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i == 2) {
            c0.u("HomeGameItem1Fragment", "游戏推荐模块" + str);
            com.rtk.app.tool.v.h(this.e, getClass().getName() + i, str);
            this.x.o((RecommendModuleAndClassifyBean) create.fromJson(str, RecommendModuleAndClassifyBean.class));
            if (this.y != null) {
                this.x.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        c0.u("HomeGameItem1Fragment", "所有类型" + str);
        HomePageAllGameBean homePageAllGameBean = (HomePageAllGameBean) create.fromJson(str, HomePageAllGameBean.class);
        this.y = homePageAllGameBean;
        if (homePageAllGameBean.getCode() == 0) {
            if (this.r == 1 && !str.equals(this.q)) {
                com.rtk.app.tool.v.h(this.e, getClass().getName() + i, str);
            }
            if (this.r == 1) {
                this.t.clear();
                this.u.clear();
                this.v.clear();
                this.w.clear();
            }
            this.t.addAll(this.y.getData().getHot());
            this.u.addAll(this.y.getData().getSpeed());
            this.v.addAll(this.y.getData().getLatest());
            this.w.addAll(this.y.getData().getBoutique());
            if (this.y.getData().getBoutique().size() < 10) {
                this.x.n(false);
                this.home1Item1RecyclerView.setIsEnd(true);
                this.x.j(true);
            } else {
                this.home1Item1RecyclerView.setIsEnd(false);
                this.x.j(false);
            }
            this.x.k(false, null);
            this.x.notifyDataSetChanged();
            this.r++;
            c0.u("HomeGameItem1Fragment", "撒到脚后跟" + this.r);
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void B() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.home1Item1Swiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.MainActivityPack.f
            public final void onRefresh() {
                HomeGameItem1Fragment.this.A();
            }
        });
        this.home1Item1RecyclerView.addOnScrollListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("HomeGameItem1Fragment", "请求失败：" + str);
        this.home1Item1Swiprefresh.setRefreshing(false);
        ((LinearLayout) this.s).getChildAt(1).setVisibility(8);
        ((TextView) ((LinearLayout) this.s).getChildAt(0)).setText("请求失败");
        this.z.put(Integer.valueOf(i2), str);
        if (this.z.size() >= 4) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.h
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeGameItem1Fragment.this.w(strArr);
                }
            });
            this.z.clear();
        }
        if (i2 != 3) {
            return;
        }
        this.x.j(true);
        this.x.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.g
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                HomeGameItem1Fragment.this.y(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.home1Item1RecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.s = LayoutInflater.from(this.e).inflate(R.layout.looding_footview, (ViewGroup) null);
        GameRecyclerViewAdapter gameRecyclerViewAdapter = new GameRecyclerViewAdapter(this.e, this.t, this.u, this.v, this.w);
        this.x = gameRecyclerViewAdapter;
        this.home1Item1RecyclerView.setAdapter(gameRecyclerViewAdapter);
        try {
            this.r = 0;
            d(com.rtk.app.tool.v.d(this.e, "HomeBannerValue1"), 1);
            d(com.rtk.app.tool.v.d(this.e, getClass().getName() + 2), 2);
            d(com.rtk.app.tool.v.d(this.e, getClass().getName() + 3), 3);
        } catch (Exception e) {
            c0.u("HomeGameItem1Fragment", "首页缓存数据异常" + e.toString());
        }
        u(1);
        u(2);
        this.r = 1;
        u(3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.p;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home1_item1_layout, viewGroup, false);
            this.p = inflate;
            this.o = ButterKnife.b(this, inflate);
            LinearLayout linearLayout = this.home1Item1Parent;
            r(linearLayout, linearLayout);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.p;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }

    public void u(int i) {
        String str;
        if (i == 1) {
            str = "banner/banner_list" + y.u(this.e) + "&type=3&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
        } else if (i == 2) {
            str = "game/gamecategory" + y.u(this.e) + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
        } else if (i != 3) {
            str = "";
        } else {
            str = "game/homePage" + y.u(this.e) + "&list=all&page=" + this.r + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
        }
        if (c0.q(str)) {
            return;
        }
        c0.u("HomeGameItem1Fragment", " 地址 " + y.d + str);
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }
}
