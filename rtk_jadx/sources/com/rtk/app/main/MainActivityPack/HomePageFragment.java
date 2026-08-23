package com.rtk.app.main.MainActivityPack;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageFragment extends BaseFragment {

    @BindView
    ImageView homePageFragmentPublishSomething;

    @BindView
    TabLayout homePageFragmentTab;

    @BindView
    ViewPager homePageFragmentViewPager;
    Unbinder o;
    private HomeHeadTopLayout p;
    private List<String> q;
    private HomeGameItem2Fragment r;
    private HomeGameItem3Fragment s;
    private List<BaseFragment> t;
    private MyFragmentAdapter u;
    private HomePageItem1Fragment v;
    private HomePageItemAttention w;
    private PopupMenu x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements PopupMenu.OnMenuItemClickListener {
        a() {
        }

        @Override // android.widget.PopupMenu.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.publish_game_zip /* 2131299940 */:
                    com.rtk.app.tool.v.e(((BaseFragment) HomePageFragment.this).e, "MAINPermisionFrist", Boolean.FALSE);
                    com.rtk.app.tool.t.e1(((BaseFragment) HomePageFragment.this).e);
                    break;
                case R.id.publish_something_post /* 2131299961 */:
                    new com.rtk.app.main.dialogPack.s(((BaseFragment) HomePageFragment.this).e).show();
                    break;
                case R.id.publish_something_up /* 2131299962 */:
                    com.rtk.app.tool.v.e(((BaseFragment) HomePageFragment.this).e, "MAINPermisionFrist", Boolean.FALSE);
                    com.rtk.app.tool.t.c1(((BaseFragment) HomePageFragment.this).e);
                    break;
            }
            HomePageFragment.this.x.dismiss();
            return false;
        }
    }

    private void A(View view) {
        PopupMenu popupMenu = new PopupMenu(this.e, view);
        this.x = popupMenu;
        popupMenu.getMenuInflater().inflate(R.menu.publish_something_item_menu, this.x.getMenu());
        this.x.setOnMenuItemClickListener(new a());
        this.x.show();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void G() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.homePageFragmentPublishSomething.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    public void h() {
        Context context = this.e;
        TabLayout tabLayout = this.homePageFragmentTab;
        com.rtk.app.tool.t.S1(context, tabLayout, tabLayout, null, null);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.p = new HomeHeadTopLayout(this.e, this.a.findViewById(R.id.home_page_fragment_head_layout));
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        arrayList.add("关注");
        this.q.add("热度");
        this.q.add("新游");
        this.q.add("热游");
        this.w = new HomePageItemAttention();
        this.v = new HomePageItem1Fragment();
        this.r = new HomeGameItem2Fragment();
        this.s = new HomeGameItem3Fragment();
        ArrayList arrayList2 = new ArrayList();
        this.t = arrayList2;
        arrayList2.add(this.w);
        this.t.add(this.v);
        this.t.add(this.r);
        this.t.add(this.s);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), this.t, this.q);
        this.u = myFragmentAdapter;
        this.homePageFragmentViewPager.setAdapter(myFragmentAdapter);
        this.homePageFragmentTab.setupWithViewPager(this.homePageFragmentViewPager, true);
        this.homePageFragmentViewPager.setCurrentItem(1);
        this.homePageFragmentViewPager.setOffscreenPageLimit(4);
        this.homePageFragmentViewPager.setNestedScrollingEnabled(true);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        if (this.t == null) {
            return;
        }
        for (int i = 0; i < this.t.size(); i++) {
            BaseFragment baseFragment = this.t.get(i);
            if (baseFragment != null) {
                baseFragment.n();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298060) {
            return;
        }
        A(this.homePageFragmentPublishSomething);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.home_page_fragment_layout, viewGroup, false);
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
        this.p.k();
    }
}
