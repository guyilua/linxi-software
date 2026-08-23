package com.rtk.app.main.OtherImfomationPack;

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
public class OtherCommentForGameFragment extends BaseFragment {

    @BindView
    ViewPager myCommentForGameViewPager;

    @BindView
    TabLayout otherCommentForGameTagLayout;
    private ItemViewPagerAdapter q;
    private String r;
    Unbinder s;
    private List<String> o = new ArrayList();
    private List<View> p = new ArrayList();
    private int t = 0;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            OtherCommentForGameFragment.this.t = i;
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
        this.r = getArguments().getString("uid");
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view1, (ViewGroup) null);
        View inflate2 = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view1, (ViewGroup) null);
        View inflate3 = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view1, (ViewGroup) null);
        this.p.add(inflate);
        this.p.add(inflate2);
        this.p.add(inflate3);
        this.o.add("TA的评论");
        this.o.add("TA的回复");
        this.o.add("回复TA的");
        new OtherCommentItem(this.e, inflate, this.r, "my");
        new OtherCommentItem(this.e, inflate2, this.r, "myreply");
        new OtherCommentItem(this.e, inflate3, this.r, "replytome");
        this.q = new ItemViewPagerAdapter(this.p, this.o, this.e);
        this.otherCommentForGameTagLayout.setupWithViewPager(this.myCommentForGameViewPager);
        this.myCommentForGameViewPager.setAdapter(this.q);
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
            this.s = ButterKnife.b(this, inflate);
            b();
        } else {
            this.s = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public int v() {
        return this.t;
    }
}
