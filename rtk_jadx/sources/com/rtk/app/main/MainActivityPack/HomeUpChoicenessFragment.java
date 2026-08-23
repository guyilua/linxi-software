package com.rtk.app.main.MainActivityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.HomeUpChoicenessAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.bean.UpApkListBean;
import com.rtk.app.bean.UserRankBean;
import com.rtk.app.custom.YcRecyclerView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpChoicenessFragment extends BaseFragment implements h.j {

    @BindView
    RelativeLayout homeUpChoicenessLayoutParent;

    @BindView
    YcRecyclerView homeUpChoicenessLayoutRecyclerView;

    @BindView
    SwipeRefreshLayout homeUpChoicenessLayoutSwiprefresh;

    @BindView
    ImageView homeUpChoicenessPublishUp;
    Unbinder o;
    private HomeUpChoicenessAdapter p;
    private int q = 1;
    private List<UpApkListBean.DataBean> r;
    private UpAdBean s;
    private UserRankBean t;
    private UpApkListBean u;
    private UserRankBean v;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E() {
        u(3);
    }

    private void u(int i) {
        String str;
        if (i == 1) {
            str = "banner/banner_list" + y.u(this.e) + "&type=2&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
        } else if (i == 2) {
            str = "members/sourceRanking" + y.u(this.e) + "&tags=yesterday&page=1&uid=" + y.K() + "&token=" + y.H() + "&limit=8&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
        } else {
            if (i == 3) {
                String str2 = "up/down-ranking" + y.u(this.e) + "&tags=today&page=" + this.q + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "tags=today")));
                c0.u("HomeUpChoicenessFragment", " 地址 " + y.d + str2);
                com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(y.e).a(str2));
                return;
            }
            if (i != 4) {
                str = "";
            } else {
                str = "members/sourceRanking" + y.u(this.e) + "&tags=month&page=1&uid=" + y.K() + "&token=" + y.H() + "&limit=8&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
            }
        }
        if (c0.q(str)) {
            return;
        }
        c0.u("HomeUpChoicenessFragment", " 地址 " + y.d + str);
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(String[] strArr) {
        u(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        u(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(String[] strArr) {
        this.homeUpChoicenessLayoutRecyclerView.setRefreshing(true);
        u(3);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.homeUpChoicenessLayoutSwiprefresh.setRefreshing(false);
        this.homeUpChoicenessLayoutRecyclerView.setRefreshing(false);
        if (i == 1) {
            c0.u("HomeUpChoicenessFragment", "Upbanner图" + str);
            this.s = (UpAdBean) this.f.fromJson(str, UpAdBean.class);
            com.rtk.app.tool.v.h(this.e, "HomeBannerValue", str);
            HomeUpChoicenessAdapter homeUpChoicenessAdapter = this.p;
            if (homeUpChoicenessAdapter != null) {
                homeUpChoicenessAdapter.r(this.s);
            }
        } else if (i == 2) {
            c0.u("HomeUpChoicenessFragment", "今日达人" + str);
            com.rtk.app.tool.v.h(this.e, "HomeUpItem1FragmentValue" + i, str);
            UserRankBean userRankBean = (UserRankBean) this.f.fromJson(str, UserRankBean.class);
            this.t = userRankBean;
            if (userRankBean != null) {
                this.p.s(userRankBean);
            }
        } else if (i == 3) {
            c0.u("HomeUpChoicenessFragment", "今日up推荐 " + str);
            this.u = (UpApkListBean) this.f.fromJson(str, UpApkListBean.class);
            if (this.q == 1) {
                this.r.clear();
                com.rtk.app.tool.v.h(this.e, "HomeUpItem1FragmentValue" + i, str);
            }
            this.r.addAll(this.u.getData());
            if (this.u.getData().size() < 10) {
                this.homeUpChoicenessLayoutRecyclerView.setIsEnd(true);
                this.p.j(true);
                this.p.k(false, null);
            } else {
                this.homeUpChoicenessLayoutRecyclerView.setIsEnd(false);
                this.p.j(false);
                this.p.k(false, null);
            }
            this.q++;
        } else if (i == 4) {
            c0.u("HomeUpChoicenessFragment", "月达人" + str);
            com.rtk.app.tool.v.h(this.e, "HomeUpItem1FragmentValue" + i, str);
            UserRankBean userRankBean2 = (UserRankBean) this.f.fromJson(str, UserRankBean.class);
            this.v = userRankBean2;
            if (userRankBean2 != null) {
                this.p.t(userRankBean2);
            }
        }
        this.p.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void C() {
        this.q = 1;
        u(1);
        u(2);
        u(3);
        u(4);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homeUpChoicenessLayoutSwiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.MainActivityPack.q
            public final void onRefresh() {
                HomeUpChoicenessFragment.this.C();
            }
        });
        this.homeUpChoicenessLayoutRecyclerView.setRecyclerViewOnTheDownListener(new YcRecyclerView.b() { // from class: com.rtk.app.main.MainActivityPack.r
            @Override // com.rtk.app.custom.YcRecyclerView.b
            public final void a() {
                HomeUpChoicenessFragment.this.E();
            }
        });
        this.homeUpChoicenessPublishUp.setOnClickListener(this);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("HomeUpChoicenessFragment", "加载失败" + i2 + "   " + str);
        this.homeUpChoicenessLayoutSwiprefresh.setRefreshing(false);
        this.homeUpChoicenessLayoutRecyclerView.setRefreshing(false);
        if (i2 == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.u
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeUpChoicenessFragment.this.w(strArr);
                }
            });
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.homeUpChoicenessLayoutRecyclerView.setIsEnd(true);
        if (this.q == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.s
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeUpChoicenessFragment.this.y(strArr);
                }
            });
        }
        this.p.j(true);
        this.p.k(true, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.t
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                HomeUpChoicenessFragment.this.A(strArr);
            }
        });
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        RelativeLayout relativeLayout = this.homeUpChoicenessLayoutParent;
        r(relativeLayout, relativeLayout);
        ArrayList arrayList = new ArrayList();
        this.r = arrayList;
        this.p = new HomeUpChoicenessAdapter(this.e, arrayList);
        this.homeUpChoicenessLayoutRecyclerView.setLayoutManager(new LinearLayoutManager(this.e));
        this.homeUpChoicenessLayoutRecyclerView.setAdapter(this.p);
        this.homeUpChoicenessLayoutRecyclerView.setIsEnd(true);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        HomeUpChoicenessAdapter homeUpChoicenessAdapter = this.p;
        if (homeUpChoicenessAdapter != null) {
            homeUpChoicenessAdapter.i();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298096) {
            return;
        }
        com.rtk.app.tool.v.e(this.e, "MAINPermisionFrist", Boolean.FALSE);
        com.rtk.app.tool.t.e2(this.e, view);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home_up_choiceness_layout, viewGroup, false);
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

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
        HomeUpChoicenessAdapter homeUpChoicenessAdapter = this.p;
        if (homeUpChoicenessAdapter != null) {
            homeUpChoicenessAdapter.notifyDataSetChanged();
        }
    }
}
