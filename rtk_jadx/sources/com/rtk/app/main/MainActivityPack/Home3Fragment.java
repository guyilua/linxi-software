package com.rtk.app.main.MainActivityPack;

import android.app.Activity;
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
import com.rtk.app.main.SearchActivity;
import com.rtk.app.main.login.InformationActivity;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home3Fragment extends BaseFragment {

    @BindView
    TabLayout home3Tab;

    @BindView
    ViewPager home3ViewPager;
    View o;
    Unbinder p;
    private HomeHeadTopLayout q;
    private List<String> r;
    private MyFragmentAdapter s;
    private List<Fragment> t;

    public Home3Fragment() {
        new ArrayList();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void G() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
        Context context = this.e;
        TabLayout tabLayout = this.home3Tab;
        com.rtk.app.tool.t.S1(context, tabLayout, tabLayout, null, null);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.q = new HomeHeadTopLayout(this.e, this.o.findViewById(R.id.home1_2_fragment_head_layout));
        ArrayList arrayList = new ArrayList();
        this.r = arrayList;
        arrayList.add("详细分类");
        this.r.add("经典分类");
        HomeParticularGameClassifyFragment homeParticularGameClassifyFragment = new HomeParticularGameClassifyFragment();
        HomeClassicsGameClassifyFragment homeClassicsGameClassifyFragment = new HomeClassicsGameClassifyFragment();
        ArrayList arrayList2 = new ArrayList();
        this.t = arrayList2;
        arrayList2.add(homeParticularGameClassifyFragment);
        this.t.add(homeClassicsGameClassifyFragment);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), this.t, this.r);
        this.s = myFragmentAdapter;
        this.home3ViewPager.setAdapter(myFragmentAdapter);
        this.home3Tab.setupWithViewPager(this.home3ViewPager, true);
        this.home3ViewPager.setOffscreenPageLimit(2);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
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
        this.e = getContext();
        View view = this.o;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home3_layout, viewGroup, false);
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
        this.q.k();
    }

    public void onStart() {
        super.onStart();
    }
}
