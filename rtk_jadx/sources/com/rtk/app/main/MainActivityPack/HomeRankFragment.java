package com.rtk.app.main.MainActivityPack;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.tool.c0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeRankFragment extends BaseFragment {

    @BindView
    TabLayout home2Tab;

    @BindView
    ViewPager home2ViewPager;
    View o;
    Unbinder p;
    private HomeHeadTopLayout q;
    private List<String> r;
    private MyFragmentAdapter s;
    private List<Fragment> t;

    public HomeRankFragment() {
        new ArrayList();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void A() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
        Context context = this.e;
        TabLayout tabLayout = this.home2Tab;
        com.rtk.app.tool.t.S1(context, tabLayout, tabLayout, null);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = new HomeHeadTopLayout(this.e, this.o.findViewById(R.id.home1_2_fragment_head_layout));
        c0.u("HomeRankFragment", "初始化Fragment的initView");
        ArrayList arrayList = new ArrayList();
        this.r = arrayList;
        arrayList.add("总榜");
        this.r.add("单机榜");
        this.r.add("新品榜");
        this.r.add("BT榜");
        this.t = new ArrayList();
        String[] strArr = {"all", "modify", "new", "bt"};
        for (int i = 0; i < 4; i++) {
            HomeGameRankItemFragment homeGameRankItemFragment = new HomeGameRankItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("rank", strArr[i]);
            homeGameRankItemFragment.setArguments(bundle);
            this.t.add(homeGameRankItemFragment);
        }
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), this.t, this.r);
        this.s = myFragmentAdapter;
        this.home2ViewPager.setAdapter(myFragmentAdapter);
        this.home2Tab.setupWithViewPager(this.home2ViewPager, true);
        this.home2ViewPager.setOffscreenPageLimit(4);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        this.q.j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            c0.u("HomeRankFragment", "Fragment创建了onCreateView");
            View inflate = layoutInflater.inflate(R.layout.home2_layout, viewGroup, false);
            this.o = inflate;
            this.p = ButterKnife.b(this, inflate);
            c();
        } else {
            this.p = ButterKnife.b(this, view);
        }
        return this.o;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.p.a();
    }

    @Override // com.rtk.app.base.BaseFragment
    public void onResume() {
        super.onResume();
        c0.u("HomeRankFragment", "Fragment调用onResume");
        this.q.k();
    }
}
