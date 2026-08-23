package com.rtk.app.main.MainActivityPack;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rtk.app.R;
import com.rtk.app.adapter.GameListViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.DataBean;
import com.rtk.app.bean.GameListBean;
import com.rtk.app.custom.AutoListView.AutoListView;
import com.rtk.app.tool.ApkInfo;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameRankItemFragment extends BaseFragment implements h.j {

    @BindView
    AutoListView fragementForListviewListview;
    Unbinder o;
    private List<DataBean> p;
    private GameListViewAdapter q;
    private View s;
    private HeadHolder t;
    private List<DataBean> u;
    private com.rtk.app.tool.DownLoadTool.u w;
    private com.rtk.app.tool.DownLoadTool.u x;
    private com.rtk.app.tool.DownLoadTool.u y;
    private int r = 1;
    private String v = "all";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HeadHolder {

        @BindView
        RelativeLayout gameRangFirstLayout;

        @BindView
        RelativeLayout gameRangTwoLayout;

        @BindView
        RelativeLayout gameRangeThreeLayout;

        @BindView
        ImageView home2Item1GameFirstIcon;

        @BindView
        TextView home2Item1GameFirstName;

        @BindView
        TextView home2Item1GameFirstSize;

        @BindView
        ImageView home2Item1GameThreeIcon;

        @BindView
        TextView home2Item1GameThreeName;

        @BindView
        TextView home2Item1GameThreeSize;

        @BindView
        ImageView home2Item1GameTwoIcon;

        @BindView
        TextView home2Item1GameTwoName;

        @BindView
        TextView home2Item1GameTwoSize;

        @BindView
        TextView home2Item1HeardviewFristDownload;

        @BindView
        ProgressBar home2Item1HeardviewFristProgressBar;

        @BindView
        TextView home2Item1HeardviewThreeDownload;

        @BindView
        ProgressBar home2Item1HeardviewThreeProgressBar;

        @BindView
        TextView home2Item1HeardviewTwoDownload;

        @BindView
        ProgressBar home2Item1HeardviewTwoProgressBar;

        HeadHolder(HomeGameRankItemFragment homeGameRankItemFragment, View view) {
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class HeadHolder_ViewBinding implements Unbinder {
        private HeadHolder b;

        @UiThread
        public HeadHolder_ViewBinding(HeadHolder headHolder, View view) {
            this.b = headHolder;
            headHolder.home2Item1GameTwoIcon = (ImageView) butterknife.c.a.c(view, R.id.home2_item1_game_two_icon, "field 'home2Item1GameTwoIcon'", ImageView.class);
            headHolder.home2Item1GameTwoName = (TextView) butterknife.c.a.c(view, R.id.home2_item1_game_two_name, "field 'home2Item1GameTwoName'", TextView.class);
            headHolder.home2Item1GameTwoSize = (TextView) butterknife.c.a.c(view, R.id.home2_item1_game_two_size, "field 'home2Item1GameTwoSize'", TextView.class);
            headHolder.home2Item1GameFirstIcon = (ImageView) butterknife.c.a.c(view, R.id.home2_item1_game_first_icon, "field 'home2Item1GameFirstIcon'", ImageView.class);
            headHolder.home2Item1GameFirstName = (TextView) butterknife.c.a.c(view, R.id.home2_item1_game_first_name, "field 'home2Item1GameFirstName'", TextView.class);
            headHolder.home2Item1GameFirstSize = (TextView) butterknife.c.a.c(view, R.id.home2_item1_game_first_size, "field 'home2Item1GameFirstSize'", TextView.class);
            headHolder.home2Item1GameThreeIcon = (ImageView) butterknife.c.a.c(view, R.id.home2_item1_game_three_icon, "field 'home2Item1GameThreeIcon'", ImageView.class);
            headHolder.home2Item1GameThreeName = (TextView) butterknife.c.a.c(view, R.id.home2_item1_game_three_name, "field 'home2Item1GameThreeName'", TextView.class);
            headHolder.home2Item1GameThreeSize = (TextView) butterknife.c.a.c(view, R.id.home2_item1_game_three_size, "field 'home2Item1GameThreeSize'", TextView.class);
            headHolder.home2Item1HeardviewFristDownload = (TextView) butterknife.c.a.c(view, R.id.home2_item1_heardview_frist_download, "field 'home2Item1HeardviewFristDownload'", TextView.class);
            headHolder.home2Item1HeardviewTwoDownload = (TextView) butterknife.c.a.c(view, R.id.home2_item1_heardview_two_download, "field 'home2Item1HeardviewTwoDownload'", TextView.class);
            headHolder.home2Item1HeardviewThreeDownload = (TextView) butterknife.c.a.c(view, R.id.home2_item1_heardview_three_download, "field 'home2Item1HeardviewThreeDownload'", TextView.class);
            headHolder.home2Item1HeardviewTwoProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.home2_item1_heardview_two_progressBar, "field 'home2Item1HeardviewTwoProgressBar'", ProgressBar.class);
            headHolder.home2Item1HeardviewFristProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.home2_item1_heardview_frist_progressBar, "field 'home2Item1HeardviewFristProgressBar'", ProgressBar.class);
            headHolder.home2Item1HeardviewThreeProgressBar = (ProgressBar) butterknife.c.a.c(view, R.id.home2_item1_heardview_three_progressBar, "field 'home2Item1HeardviewThreeProgressBar'", ProgressBar.class);
            headHolder.gameRangTwoLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.game_rang_two_layout, "field 'gameRangTwoLayout'", RelativeLayout.class);
            headHolder.gameRangFirstLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.game_rang_first_layout, "field 'gameRangFirstLayout'", RelativeLayout.class);
            headHolder.gameRangeThreeLayout = (RelativeLayout) butterknife.c.a.c(view, R.id.game_range_three_layout, "field 'gameRangeThreeLayout'", RelativeLayout.class);
        }

        @CallSuper
        public void a() {
            HeadHolder headHolder = this.b;
            if (headHolder != null) {
                this.b = null;
                headHolder.home2Item1GameTwoIcon = null;
                headHolder.home2Item1GameTwoName = null;
                headHolder.home2Item1GameTwoSize = null;
                headHolder.home2Item1GameFirstIcon = null;
                headHolder.home2Item1GameFirstName = null;
                headHolder.home2Item1GameFirstSize = null;
                headHolder.home2Item1GameThreeIcon = null;
                headHolder.home2Item1GameThreeName = null;
                headHolder.home2Item1GameThreeSize = null;
                headHolder.home2Item1HeardviewFristDownload = null;
                headHolder.home2Item1HeardviewTwoDownload = null;
                headHolder.home2Item1HeardviewThreeDownload = null;
                headHolder.home2Item1HeardviewTwoProgressBar = null;
                headHolder.home2Item1HeardviewFristProgressBar = null;
                headHolder.home2Item1HeardviewThreeProgressBar = null;
                headHolder.gameRangTwoLayout = null;
                headHolder.gameRangFirstLayout = null;
                headHolder.gameRangeThreeLayout = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.b
        public void a() {
            HomeGameRankItemFragment.this.B();
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AutoListView.c {
        b() {
        }

        @Override // com.rtk.app.custom.AutoListView.AutoListView.c
        public void onRefresh() {
            HomeGameRankItemFragment.this.r = 1;
            HomeGameRankItemFragment.this.B();
            HomeGameRankItemFragment.this.fragementForListviewListview.setLoadEnable(false);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c extends com.rtk.app.custom.AutoListView.b {
        c() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            if (i >= 2) {
                com.rtk.app.tool.t.e0(((BaseFragment) HomeGameRankItemFragment.this).e, new ApkInfo((DataBean) HomeGameRankItemFragment.this.p.get(i - 2)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(String[] strArr) {
        B();
    }

    public void A(List<DataBean> list) {
        HeadHolder headHolder = new HeadHolder(this, this.s);
        com.rtk.app.tool.t.d(this.e, list.get(0).getGame_logo(), headHolder.home2Item1GameFirstIcon);
        com.rtk.app.tool.t.d(this.e, list.get(1).getGame_logo(), headHolder.home2Item1GameTwoIcon);
        com.rtk.app.tool.t.d(this.e, list.get(2).getGame_logo(), headHolder.home2Item1GameThreeIcon);
        headHolder.home2Item1GameFirstName.setText(list.get(0).getGame_name());
        headHolder.home2Item1GameTwoName.setText(list.get(1).getGame_name());
        headHolder.home2Item1GameThreeName.setText(list.get(2).getGame_name());
        headHolder.home2Item1GameFirstSize.setText(list.get(0).getPackage_size());
        headHolder.home2Item1GameTwoSize.setText(list.get(1).getPackage_size());
        headHolder.home2Item1GameThreeSize.setText(list.get(2).getPackage_size());
        headHolder.home2Item1HeardviewFristDownload.setTag(Integer.valueOf(list.get(0).getGame_id()));
        headHolder.home2Item1HeardviewTwoDownload.setTag(Integer.valueOf(list.get(1).getGame_id()));
        headHolder.home2Item1HeardviewThreeDownload.setTag(Integer.valueOf(list.get(2).getGame_id()));
        this.w = new com.rtk.app.tool.DownLoadTool.u(headHolder.home2Item1HeardviewFristProgressBar, list.get(0).getGame_id(), headHolder.home2Item1HeardviewFristDownload);
        this.x = new com.rtk.app.tool.DownLoadTool.u(headHolder.home2Item1HeardviewTwoProgressBar, list.get(1).getGame_id(), headHolder.home2Item1HeardviewTwoDownload);
        this.y = new com.rtk.app.tool.DownLoadTool.u(headHolder.home2Item1HeardviewThreeProgressBar, list.get(2).getGame_id(), headHolder.home2Item1HeardviewThreeDownload);
        x.c().a(this.w);
        x.c().a(this.x);
        x.c().a(this.y);
        com.rtk.app.tool.DownLoadTool.r.h(this.e, new ApkInfo(list.get(0)), headHolder.home2Item1HeardviewFristDownload, headHolder.home2Item1HeardviewFristProgressBar);
        com.rtk.app.tool.DownLoadTool.r.h(this.e, new ApkInfo(list.get(1)), headHolder.home2Item1HeardviewTwoDownload, headHolder.home2Item1HeardviewTwoProgressBar);
        com.rtk.app.tool.DownLoadTool.r.h(this.e, new ApkInfo(list.get(2)), headHolder.home2Item1HeardviewThreeDownload, headHolder.home2Item1HeardviewThreeProgressBar);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        q();
        this.fragementForListviewListview.k();
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        c0.u("HomeGameRankItemFragment", "榜单" + str);
        if (i != 1) {
            return;
        }
        GameListBean gameListBean = (GameListBean) create.fromJson(str, GameListBean.class);
        if (gameListBean.getCode() != 0 || gameListBean.getData() == null) {
            return;
        }
        if (this.r == 1) {
            this.p.clear();
        }
        this.p.addAll(gameListBean.getData());
        if (this.p.size() > 3 && this.r == 1) {
            this.u.clear();
            this.u.add(this.p.get(0));
            this.u.add(this.p.get(1));
            this.u.add(this.p.get(2));
            this.p.remove(0);
            this.p.remove(0);
            this.p.remove(0);
            A(this.u);
            this.s.setVisibility(0);
        }
        this.r++;
        this.q.notifyDataSetChanged();
        this.fragementForListviewListview.setResultSize(gameListBean.getData().size());
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void B() {
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a("game/gamerank" + y.u(this.e) + "&rank=" + this.v + "&page=" + this.r + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])))));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.fragementForListviewListview.setOnLoadListener(new a());
        this.fragementForListviewListview.setOnRefreshListener(new b());
        this.fragementForListviewListview.setOnItemClickListener(new c());
        this.t.home2Item1GameFirstIcon.setOnClickListener(this);
        this.t.home2Item1GameTwoIcon.setOnClickListener(this);
        this.t.home2Item1GameThreeIcon.setOnClickListener(this);
        this.t.home2Item1HeardviewFristDownload.setOnClickListener(this);
        this.t.home2Item1HeardviewTwoDownload.setOnClickListener(this);
        this.t.home2Item1HeardviewThreeDownload.setOnClickListener(this);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (this.r == 1) {
            t(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.MainActivityPack.k
                @Override // com.rtk.app.tool.s
                public final void a(String[] strArr) {
                    HomeGameRankItemFragment.this.y(strArr);
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
        this.p = new ArrayList();
        this.u = new ArrayList();
        this.v = getArguments().getString("rank");
        this.q = new GameListViewAdapter(this.e, this.p);
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.home2_item1_heardview_layout, (ViewGroup) null);
        this.s = inflate;
        this.t = new HeadHolder(this, inflate);
        this.fragementForListviewListview.addHeaderView(this.s);
        this.fragementForListviewListview.setAdapter((ListAdapter) this.q);
        z();
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        GameListViewAdapter gameListViewAdapter = this.q;
        if (gameListViewAdapter != null) {
            gameListViewAdapter.b();
        }
        try {
            x.c().m(this.w);
            x.c().m(this.x);
            x.c().m(this.y);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home2_item1_game_first_icon /* 2131297908 */:
                com.rtk.app.tool.t.e0(this.e, new ApkInfo(this.u.get(0)));
                return;
            case R.id.home2_item1_game_three_icon /* 2131297914 */:
                com.rtk.app.tool.t.e0(this.e, new ApkInfo(this.u.get(2)));
                return;
            case R.id.home2_item1_game_two_icon /* 2131297919 */:
                com.rtk.app.tool.t.e0(this.e, new ApkInfo(this.u.get(1)));
                return;
            case R.id.home2_item1_heardview_frist_download /* 2131297922 */:
                com.rtk.app.tool.DownLoadTool.r.g(this.e, new ApkInfo(this.u.get(0)), (TextView) view);
                return;
            case R.id.home2_item1_heardview_three_download /* 2131297924 */:
                com.rtk.app.tool.DownLoadTool.r.g(this.e, new ApkInfo(this.u.get(2)), (TextView) view);
                return;
            case R.id.home2_item1_heardview_two_download /* 2131297926 */:
                com.rtk.app.tool.DownLoadTool.r.g(this.e, new ApkInfo(this.u.get(1)), (TextView) view);
                return;
            default:
                return;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home2_item1_layout, viewGroup, false);
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

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
        this.q.notifyDataSetChanged();
        z();
        try {
            Context context = this.e;
            ApkInfo apkInfo = new ApkInfo(this.u.get(0));
            HeadHolder headHolder = this.t;
            com.rtk.app.tool.DownLoadTool.r.h(context, apkInfo, headHolder.home2Item1HeardviewFristDownload, headHolder.home2Item1HeardviewFristProgressBar);
            Context context2 = this.e;
            ApkInfo apkInfo2 = new ApkInfo(this.u.get(1));
            HeadHolder headHolder2 = this.t;
            com.rtk.app.tool.DownLoadTool.r.h(context2, apkInfo2, headHolder2.home2Item1HeardviewTwoDownload, headHolder2.home2Item1HeardviewTwoProgressBar);
            Context context3 = this.e;
            ApkInfo apkInfo3 = new ApkInfo(this.u.get(2));
            HeadHolder headHolder3 = this.t;
            com.rtk.app.tool.DownLoadTool.r.h(context3, apkInfo3, headHolder3.home2Item1HeardviewThreeDownload, headHolder3.home2Item1HeardviewThreeProgressBar);
        } catch (Exception unused) {
        }
    }

    public void z() {
        this.t.gameRangTwoLayout.setBackgroundResource(com.rtk.app.tool.t.F(this.e, new boolean[0]));
        this.t.gameRangFirstLayout.setBackgroundResource(com.rtk.app.tool.t.F(this.e, new boolean[0]));
        this.t.gameRangeThreeLayout.setBackgroundResource(com.rtk.app.tool.t.F(this.e, new boolean[0]));
    }
}
