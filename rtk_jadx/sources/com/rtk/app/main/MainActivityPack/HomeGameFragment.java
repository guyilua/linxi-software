package com.rtk.app.main.MainActivityPack;

import android.app.Activity;
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
import com.rtk.app.main.SearchActivity;
import com.rtk.app.main.login.InformationActivity;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeGameFragment extends BaseFragment {

    @BindView
    TabLayout homeGameTab;

    @BindView
    ViewPager homeGameViewPager;
    View o;
    Unbinder p;
    private HomeHeadTopLayout q;
    private HomeGameItem1Fragment r;
    private HomeGameItem2Fragment s;
    private HomeGameItem3Fragment t;
    private HomeParticularGameClassifyFragment u;
    private MyFragmentAdapter v;
    private List<Fragment> w;
    private List<String> x;

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void w() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    public void h() {
        com.rtk.app.tool.t.S1(this.e, null, this.homeGameTab, null, null, null);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = new HomeHeadTopLayout(this.e, this.o.findViewById(R.id.home_game_2_fragment_head_layout));
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        arrayList.add("热度");
        this.x.add("最新");
        this.x.add("热门");
        this.x.add("分类");
        this.r = new HomeGameItem1Fragment();
        this.s = new HomeGameItem2Fragment();
        this.t = new HomeGameItem3Fragment();
        this.u = new HomeParticularGameClassifyFragment();
        ArrayList arrayList2 = new ArrayList();
        this.w = arrayList2;
        arrayList2.add(this.r);
        this.w.add(this.s);
        this.w.add(this.t);
        this.w.add(this.u);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), this.w, this.x);
        this.v = myFragmentAdapter;
        this.homeGameViewPager.setAdapter(myFragmentAdapter);
        this.homeGameTab.setupWithViewPager(this.homeGameViewPager, true);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        this.t.n();
        this.q.j();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.o.getId()) {
            case R.id.main_download_img /* 2131299014 */:
                com.rtk.app.tool.t.o0(this.e);
                return;
            case R.id.main_head_icon /* 2131299015 */:
                if (y.x(this.e)) {
                    com.rtk.app.tool.c.b((Activity) this.e, InformationActivity.class, null);
                    return;
                } else {
                    com.rtk.app.tool.t.w0(this.e);
                    return;
                }
            case R.id.main_search_tv /* 2131299022 */:
                com.rtk.app.tool.c.b((Activity) this.e, SearchActivity.class, null);
                return;
            default:
                return;
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home_game_layout, viewGroup, false);
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
        this.q.k();
        super.onResume();
    }
}
