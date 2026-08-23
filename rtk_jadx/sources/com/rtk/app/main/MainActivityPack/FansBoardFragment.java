package com.rtk.app.main.MainActivityPack;

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
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.BoardHeadView;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FansBoardFragment extends BaseFragment implements h.j {

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
            com.rtk.app.tool.t.B0(((BaseFragment) FansBoardFragment.this).e, ((UserRankBean.DataBean) FansBoardFragment.this.q.get(i - 2)).getUid());
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
        c0.u("FansBoardFragment", "粉丝榜 " + i + "str" + str);
        if (i != 1) {
            if (i != 2) {
                return;
            }
            c0.u("FansBoardFragment", "排行榜信息" + str);
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
        StringBuilder sb = new StringBuilder();
        sb.append("user/fans-ranking");
        sb.append(y.u(this.e));
        sb.append("&type=");
        sb.append(this.p);
        sb.append("&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&page=");
        sb.append(this.o);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "type=" + this.p))));
        String sb2 = sb.toString();
        c0.u("FansBoardFragment", "粉丝榜" + y.e + sb2);
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(y.e).a(sb2));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("user/fans-ranking/tips");
        sb3.append(y.u(this.e));
        sb3.append("&type=");
        sb3.append(this.p);
        sb3.append("&uid=");
        sb3.append(y.K());
        sb3.append("&token=");
        sb3.append(y.H());
        sb3.append("&page=");
        sb3.append(this.o);
        sb3.append("&key=");
        sb3.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "type=" + this.p))));
        String sb4 = sb3.toString();
        if (this.o == 1) {
            c0.u("FansBoardFragment", "粉丝榜的介绍" + y.e + sb4);
            com.rtk.app.tool.o.h.l(this.e, this, 2, com.rtk.app.tool.o.h.h(y.e).a(sb4));
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homeUpExpertFragmentListview.setOnRefreshListener(new AutoListView.c() { // from class: com.rtk.app.main.MainActivityPack.b
            @Override // com.rtk.app.custom.AutoListView.AutoListView.c
            public final void onRefresh() {
                FansBoardFragment.this.z();
            }
        });
        this.homeUpExpertFragmentListview.setOnLoadListener(new AutoListView.b() { // from class: com.rtk.app.main.MainActivityPack.c
            @Override // com.rtk.app.custom.AutoListView.AutoListView.b
            public final void a() {
                FansBoardFragment.this.B();
            }
        });
        this.homeUpExpertFragmentListview.setOnItemClickListener(new a());
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("FansBoardFragment", "粉丝榜" + i2 + " str:" + str);
        if (i2 != 1) {
            return;
        }
        this.homeUpExpertFragmentListview.f();
        if (this.o == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.a
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    FansBoardFragment.this.x(strArr);
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
