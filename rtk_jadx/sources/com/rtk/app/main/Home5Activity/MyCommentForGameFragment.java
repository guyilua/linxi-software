package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.adapter.ItemViewPagerAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.MyHorizontalScrollView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyCommentForGameFragment extends BaseFragment {

    @BindView
    TabLayout myCommentForGameTagLayout;

    @BindView
    ViewPager myCommentForGameViewPager;
    Unbinder o;
    private ItemViewPagerAdapter r;
    private List<View> p = new ArrayList();
    private List<String> q = new ArrayList();
    private int s = 0;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            MyCommentForGameFragment.this.s = i;
            if (i != 0) {
                MyHorizontalScrollView.b = true;
            } else {
                MyHorizontalScrollView.b = false;
            }
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void e() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
        this.myCommentForGameViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view1, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view2, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view3, (ViewGroup) null);
        this.p.add(inflate);
        this.p.add(inflate2);
        this.p.add(inflate3);
        this.q.add("我的评论");
        this.q.add("我的回复");
        this.q.add("回复我的");
        new MyCommentItem1(this.e, inflate);
        new MyCommentItem2(this.e, inflate2);
        new MyCommentItem3(this.e, inflate3);
        this.r = new ItemViewPagerAdapter(this.p, this.q, this.e);
        this.myCommentForGameTagLayout.setupWithViewPager(this.myCommentForGameViewPager);
        this.myCommentForGameViewPager.setAdapter(this.r);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.my_comment_for_game_fragment_layout, (ViewGroup) null);
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

    public int v() {
        return this.s;
    }
}
