package com.rtk.app.main.MainActivityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.rtk.app.R;
import com.rtk.app.adapter.HomeCommunityRecyclerViewAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.FamilyListBean;
import com.rtk.app.bean.HomeCommunityBean;
import com.rtk.app.bean.MyAttentionNumBean;
import com.rtk.app.bean.UpAdBean;
import com.rtk.app.custom.NoBugGridLayoutManager;
import com.rtk.app.custom.YcSwipeRefreshLayout;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeCommunityFragment extends BaseFragment implements h.j {

    @BindView
    LinearLayout homeCommunityFragmentParemtLayout;

    @BindView
    RecyclerView homeCommunityFragmentRecyclerView;

    @BindView
    YcSwipeRefreshLayout homeCommunitySwipRefreshLayout;
    Unbinder o;
    private List<HomeCommunityBean.DataBean> p;
    private HomeCommunityRecyclerViewAdapter q;
    private HomeHeadTopLayout r;
    private GridLayoutManager s;
    private UpAdBean t;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        a(HomeCommunityFragment homeCommunityFragment) {
        }

        public int getSpanSize(int i) {
            return i > 1 ? 1 : 2;
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements com.rtk.app.tool.s {
        b() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            HomeCommunityFragment.this.v();
        }
    }

    private void u(int i) {
        String str;
        if (i == 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("family/my-family");
            sb.append(y.u(this.e));
            sb.append("&uid=");
            sb.append(y.K());
            sb.append("&token=");
            sb.append(y.H());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + y.K(), "token=" + y.H()))));
            com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(y.e).a(sb.toString()));
            return;
        }
        if (i == 2) {
            str = "members/modulesList" + y.u(this.e) + "&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
        } else if (i == 3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/myMomentsTotal");
            sb2.append(y.u(this.e));
            sb2.append("&uid=");
            sb2.append(y.K());
            sb2.append("&token=");
            sb2.append(y.H());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + y.K(), "token=" + y.H()))));
            str = sb2.toString();
        } else if (i != 4) {
            str = "";
        } else {
            str = "banner/banner_list" + y.u(this.e) + "&type=4&key=" + com.rtk.app.tool.t.c0(c0.e(y.v(this.e, new String[0])));
        }
        com.rtk.app.tool.o.h.l(this.e, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 2) {
            q();
            c0.u("HomeCommunityFragment", "社区列表" + str);
            HomeCommunityBean homeCommunityBean = (HomeCommunityBean) this.f.fromJson(str, HomeCommunityBean.class);
            this.p.clear();
            this.p.addAll(homeCommunityBean.getData());
            this.s.setSpanSizeLookup(new a(this));
            try {
                this.q.notifyDataSetChanged();
            } catch (Exception e) {
                c0.u("HomeCommunityFragment", "社区" + e.toString());
            }
            this.homeCommunitySwipRefreshLayout.setRefreshing(false);
            u(3);
            return;
        }
        if (i == 3) {
            c0.u("HomeCommunityFragment", "我的关注数量  " + str);
            this.q.h(((MyAttentionNumBean) this.f.fromJson(str, MyAttentionNumBean.class)).getData().getMomentsPost());
            return;
        }
        if (i != 4) {
            if (i != 5) {
                return;
            }
            this.q.g((FamilyListBean) this.f.fromJson(str, FamilyListBean.class));
            u(2);
            return;
        }
        UpAdBean upAdBean = (UpAdBean) this.f.fromJson(str, UpAdBean.class);
        this.t = upAdBean;
        this.q.i(upAdBean);
        com.rtk.app.tool.v.h(this.e, "HomeBannerValue", str);
        u(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void w() {
        if (y.x(this.e)) {
            u(5);
        } else {
            u(2);
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homeCommunitySwipRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.rtk.app.main.MainActivityPack.e
            public final void onRefresh() {
                HomeCommunityFragment.this.w();
            }
        });
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        this.homeCommunitySwipRefreshLayout.setRefreshing(false);
        t(str, new b());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
        com.rtk.app.tool.t.S1(this.e, null, null, null, null);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        com.rtk.app.main.HomeCommunityPack.PostAdapter.PostDetailsHolderClass.a.q(com.rtk.app.tool.v.a(this.e, "postConciseVALUE"));
        View findViewById = this.a.findViewById(R.id.home_community_fragment_head_layout);
        HomeHeadTopLayout homeHeadTopLayout = new HomeHeadTopLayout(this.e, findViewById);
        this.r = homeHeadTopLayout;
        homeHeadTopLayout.s();
        this.p = new ArrayList();
        this.s = new NoBugGridLayoutManager(this.e, 2);
        this.q = new HomeCommunityRecyclerViewAdapter(this.e, this.p);
        this.s.setOrientation(1);
        this.homeCommunityFragmentRecyclerView.setLayoutManager(this.s);
        this.homeCommunityFragmentRecyclerView.setAdapter(this.q);
        r(this.homeCommunityFragmentParemtLayout, findViewById);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        this.r.j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            FragmentActivity activity = getActivity();
            this.e = activity;
            View inflate = LayoutInflater.from(activity).inflate(R.layout.home_community_fragment, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            i();
            f();
            h();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.o.a();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        v();
    }

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
        this.r.k();
        try {
            this.q.notifyItemChanged(2);
        } catch (Exception unused) {
        }
        if (((MainActivity) this.e).m == this) {
            v();
            c0.u("HomeCommunityFragment", "home5的onResume()");
        }
    }
}
