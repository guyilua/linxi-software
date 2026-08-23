package com.rtk.app.main.MainActivityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.HomePageItem1Adapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.HomeAdBean;
import com.rtk.app.bean.HomePageAllGameBean;
import com.rtk.app.bean.RecommendModuleAndClassifyBean;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.bean.UserRankBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageItem1Fragment extends BaseFragment implements h.j {

    @BindView
    YcRecyclerView fragmentForRecyclerviewLayoutListView;

    @BindView
    LinearLayout fragmentForRecyclerviewParentLayout;

    @BindView
    SwipeRefreshLayout fragmentMyGoldLayoutSwipeRefresh;
    Unbinder o;
    private UpAdBean p;
    private RecommendModuleAndClassifyBean q;
    private HomePageItem1Adapter r;
    private UserRankBean s;
    private List<DataBean> t;
    private List<DataBean> u;
    private List<DataBean> v;
    private UserRankBean x;
    private int w = 1;
    private Map<Integer, String> y = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C() {
        u(5);
    }

    private void u(int i) {
        String str;
        switch (i) {
            case 1:
                str = "banner/banner_list" + y.u(this.e) + "&type=1&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
                break;
            case 2:
                str = "game/gamecategory" + y.u(this.e) + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
                break;
            case 3:
                str = "members/sourceRanking" + y.u(this.e) + "&tags=yesterday&page=1&uid=" + y.K() + "&token=" + y.H() + "&limit=4&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
                break;
            case 4:
                str = "members/sourceRanking" + y.u(this.e) + "&tags=week&page=1&uid=" + y.K() + "&token=" + y.H() + "&limit=4&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
                break;
            case 5:
                str = "game/homePage" + y.u(this.e) + "&list=all&page=" + this.w + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
                break;
            case 6:
                str = "ad/ad_list" + y.u(this.e) + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
                break;
            default:
                str = "";
                break;
        }
        if (c0.q(str)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(true);
        u(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        u(1);
        u(2);
        u(3);
        u(4);
        u(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        this.w = 1;
        B();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
        this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
        c0.u("HomePageItem1Fragment", "数据   " + i + "   " + str);
        q();
        switch (i) {
            case 1:
                UpAdBean upAdBean = (UpAdBean) this.f.fromJson(str, UpAdBean.class);
                this.p = upAdBean;
                this.r.p(upAdBean);
                com.rtk.app.tool.v.h(this.e, "HomeBannerValue", str);
                break;
            case 2:
                RecommendModuleAndClassifyBean recommendModuleAndClassifyBean = (RecommendModuleAndClassifyBean) this.f.fromJson(str, RecommendModuleAndClassifyBean.class);
                this.q = recommendModuleAndClassifyBean;
                this.r.o(recommendModuleAndClassifyBean);
                com.rtk.app.tool.v.h(this.e, "HomePageItem1FragmentValue" + i, str);
                break;
            case 3:
                this.x = (UserRankBean) this.f.fromJson(str, UserRankBean.class);
                com.rtk.app.tool.v.h(this.e, "HomePageItem1FragmentValue" + i, str);
                UserRankBean userRankBean = this.x;
                if (userRankBean != null) {
                    this.r.r(userRankBean);
                    break;
                }
                break;
            case 4:
                this.s = (UserRankBean) this.f.fromJson(str, UserRankBean.class);
                com.rtk.app.tool.v.h(this.e, "HomePageItem1FragmentValue" + i, str);
                UserRankBean userRankBean2 = this.s;
                if (userRankBean2 != null) {
                    this.r.q(userRankBean2);
                    break;
                }
                break;
            case 5:
                HomePageAllGameBean homePageAllGameBean = (HomePageAllGameBean) this.f.fromJson(str, HomePageAllGameBean.class);
                if (this.u.size() == 0) {
                    this.u.addAll(homePageAllGameBean.getData().getHot());
                    this.r.m(this.u);
                }
                if (this.v.size() == 0) {
                    this.v.addAll(homePageAllGameBean.getData().getSpeed());
                    this.r.n(this.v);
                }
                if (this.w == 1) {
                    this.t.clear();
                    com.rtk.app.tool.v.h(this.e, "HomePageItem1FragmentValue" + i, str);
                }
                this.t.addAll(homePageAllGameBean.getData().getBoutique());
                if (homePageAllGameBean.getData().getBoutique().size() < 10) {
                    this.r.j(true);
                    this.r.k(false, null);
                    this.fragmentForRecyclerviewLayoutListView.setIsEnd(true);
                } else {
                    this.r.j(false);
                    this.r.k(false, null);
                    this.fragmentForRecyclerviewLayoutListView.setIsEnd(false);
                }
                this.w++;
                break;
            case 6:
                c0.u("HomePageItem1Fragment", "广告接口" + str);
                HomeAdBean homeAdBean = (HomeAdBean) this.f.fromJson(str, HomeAdBean.class);
                y.o = homeAdBean;
                if (homeAdBean != null) {
                    this.r.l(homeAdBean);
                    break;
                }
                break;
        }
        this.r.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void B() {
        u(1);
        u(2);
        u(3);
        u(4);
        u(5);
        u(6);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragmentMyGoldLayoutSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.MainActivityPack.n
            public final void onRefresh() {
                HomePageItem1Fragment.this.A();
            }
        });
        this.fragmentForRecyclerviewLayoutListView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.MainActivityPack.m
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                HomePageItem1Fragment.this.C();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 3) {
            c0.t("HomePageItem1Fragment", "今日up达人   " + i + "    " + str);
            if (i == 2001) {
                u(3);
            }
        } else if (i2 == 4) {
            if (i == 2001) {
                u(4);
            }
            c0.t("HomePageItem1Fragment", "昨日up达人   " + i + "    " + str);
        } else if (i2 == 5) {
            this.fragmentMyGoldLayoutSwipeRefresh.setRefreshing(false);
            this.fragmentForRecyclerviewLayoutListView.setRefreshing(false);
            this.r.j(true);
            this.r.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.o
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomePageItem1Fragment.this.w(strArr);
                }
            });
        }
        this.y.put(Integer.valueOf(i2), str);
        if (this.y.size() >= 5) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.p
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomePageItem1Fragment.this.y(strArr);
                }
            });
            this.y.clear();
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.r = new HomePageItem1Adapter(this.e, this.t);
        this.fragmentForRecyclerviewLayoutListView.setLayoutManager(new LinearLayoutManager(this.e));
        this.fragmentForRecyclerviewLayoutListView.setAdapter(this.r);
        try {
            d(com.rtk.app.tool.v.d(this.e, "HomeBannerValue"), 1);
            d(com.rtk.app.tool.v.d(this.e, "HomePageItem1FragmentValue2"), 2);
            d(com.rtk.app.tool.v.d(this.e, "HomePageItem1FragmentValue3"), 3);
            d(com.rtk.app.tool.v.d(this.e, "HomePageItem1FragmentValue4"), 4);
            d(com.rtk.app.tool.v.d(this.e, "HomePageItem1FragmentValue5"), 5);
        } catch (Exception e) {
            c0.u("HomePageItem1Fragment", "默认打开数据" + e.toString());
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        HomePageItem1Adapter homePageItem1Adapter = this.r;
        if (homePageItem1Adapter != null) {
            homePageItem1Adapter.i();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragement_for_recyclerview_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }
}
