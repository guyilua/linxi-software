package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

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
import com.rtk.app.R;
import com.rtk.app.adapter.UserRankAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.RankTioInformationBean;
import com.rtk.app.bean.UserRankBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpExpertFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView homeUpExpertFragmentListview;

    @BindView
    LinearLayout homeUpExpertFragmentParentLayout;
    private int o = 1;
    private String p = "";
    private List<UserRankBean.DataBean> q;
    private UserRankAdapter r;
    private RankTioInformationBean s;
    private View t;
    private Unbinder u;
    private BoardHeadView v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            t.B0(((BaseFragment) HomeUpExpertFragment.this).e, ((UserRankBean.DataBean) HomeUpExpertFragment.this.q.get(i - 2)).getUid());
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
        this.o = 1;
        B();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            if (i != 2) {
                return;
            }
            c0.u("HomeUpExpertFragment", "排行榜信息" + str);
            RankTioInformationBean rankTioInformationBean = (RankTioInformationBean) this.f.fromJson(str, RankTioInformationBean.class);
            this.s = rankTioInformationBean;
            this.v.BoardHeadView.setText(rankTioInformationBean.getData());
            return;
        }
        this.homeUpExpertFragmentListview.k();
        q();
        UserRankBean userRankBean = (UserRankBean) this.f.fromJson(str, UserRankBean.class);
        if (this.o == 1) {
            this.q.clear();
        }
        this.q.addAll(userRankBean.getData());
        this.r.notifyDataSetChanged();
        this.homeUpExpertFragmentListview.setResultSize(userRankBean.getData().size());
        this.o++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    public void B() {
        String str = "members/sourceRanking" + y.u(this.e) + "&tags=" + this.p + "&uid=" + y.K() + "&token=" + y.H() + "&page=" + this.o + "&limit=10&key=" + t.c0(c0.e(y.v(this.e, new String[0])));
        c0.u("HomeUpExpertFragment", "达人榜" + y.d + str);
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(str));
        String str2 = "members/sourceRanking" + y.u(this.e) + "&tags=" + this.p + "&uid=" + y.K() + "&type=1&token=" + y.H() + "&page=" + this.o + "&limit=10&key=" + t.c0(c0.e(y.v(this.e, new String[0])));
        if (this.o == 1) {
            c0.u("HomeUpExpertFragment", "达人榜的介绍" + y.d + str2);
            com.rtk.app.tool.o.h.l(this.e, this, 2, com.rtk.app.tool.o.h.h(new String[0]).a(str2));
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homeUpExpertFragmentListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.e
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                HomeUpExpertFragment.this.z();
            }
        });
        this.homeUpExpertFragmentListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.f
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                HomeUpExpertFragment.this.B();
            }
        });
        this.homeUpExpertFragmentListview.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("HomeUpExpertFragment", i2 + "      " + str);
        if (i2 != 1) {
            return;
        }
        this.homeUpExpertFragmentListview.f();
        if (this.o == 1) {
            t(str, new s() { // from class: com.rtk.app.main.MainActivityPack.UpChoicenessPack.g
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeUpExpertFragment.this.x(strArr);
                }
            });
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = new ArrayList();
        this.p = getArguments().getString("dayType");
        UserRankAdapter userRankAdapter = new UserRankAdapter(this.e, this.q);
        this.r = userRankAdapter;
        this.homeUpExpertFragmentListview.setAdapter((ListAdapter) userRankAdapter);
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.board_head_view_layout, (ViewGroup) null);
        this.t = inflate;
        this.v = new BoardHeadView(this.e, inflate);
        this.homeUpExpertFragmentListview.addHeaderView(this.t);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        UserRankAdapter userRankAdapter = this.r;
        if (userRankAdapter != null) {
            userRankAdapter.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home_up_expert_fragment_layout, viewGroup, false);
            this.a = inflate;
            this.u = ButterKnife.b(this, inflate);
            View view2 = this.a;
            r(view2, view2);
            b();
        } else {
            this.u = ButterKnife.b(this, view);
        }
        this.u = ButterKnife.b(this, this.a);
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.u.a();
    }
}
