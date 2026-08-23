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
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class OtherCommentForUpApkFragment extends BaseFragment {

    @BindView
    TabLayout myCommentForUpApkTagLayout;

    @BindView
    ViewPager myCommentForUpApkViewPager;
    private Unbinder o;
    private List<View> p = new ArrayList();
    private List<String> q = new ArrayList();
    private ItemViewPagerAdapter r;
    private View s;
    private View t;
    private View u;
    private String v;

    @Override // com.rtk.app.base.BaseFragment
    protected void e() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.s = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view1, (ViewGroup) null);
        this.t = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view1, (ViewGroup) null);
        this.u = LayoutInflater.from(this.e).inflate(R.layout.my_comment_view1, (ViewGroup) null);
        this.p.add(this.s);
        this.p.add(this.t);
        this.p.add(this.u);
        this.q.add("TA的评论");
        this.q.add("TA的回复");
        this.q.add("回复TA的");
        this.r = new ItemViewPagerAdapter(this.p, this.q, this.e);
        this.myCommentForUpApkTagLayout.setupWithViewPager(this.myCommentForUpApkViewPager);
        this.myCommentForUpApkViewPager.setAdapter(this.r);
        String string = getArguments().getString("uid");
        this.v = string;
        new OtherUpApkCommentItem(this.e, this.s, "my", string);
        new OtherUpApkCommentItem(this.e, this.t, "myreply", this.v);
        new OtherUpApkCommentItem(this.e, this.u, "replytome", this.v);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.my_comment_for_up_apk_fragment_layout, (ViewGroup) null);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            b();
        } else {
            this.o = ButterKnife.b(this, view);
        }
        return this.a;
    }

    public void onDestroy() {
        super.onDestroy();
        this.o.a();
    }
}
