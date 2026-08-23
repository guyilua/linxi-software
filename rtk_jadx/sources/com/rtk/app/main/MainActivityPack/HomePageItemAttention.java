package com.rtk.app.main.MainActivityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.R;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.main.UpModule.UpApkListMyAttentionFragment;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomePageItemAttention extends BaseFragment implements h.j {

    @BindView
    TabLayout homePageItemAttentionTab;

    @BindView
    LinearLayout homePageItemAttentionTabLayout;

    @BindView
    BaseViewPager homePageItemAttentionViewPager;
    Unbinder o;
    private List<String> p = new ArrayList();
    private List<BaseFragment> q = new ArrayList();
    private UpApkListMyAttentionFragment r;
    private MyPostAttentionFragment s;
    private MyFragmentAdapter t;

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void C() {
        c0.u("HomePageItemAttention", "运行到了");
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.p.add("ＵＰ动态");
        this.p.add("社区动态");
        this.r = new UpApkListMyAttentionFragment();
        this.s = new MyPostAttentionFragment();
        this.q.add(this.r);
        this.q.add(this.s);
        try {
            MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), this.q, this.p);
            this.t = myFragmentAdapter;
            this.homePageItemAttentionViewPager.setAdapter(myFragmentAdapter);
            this.homePageItemAttentionTab.setupWithViewPager(this.homePageItemAttentionViewPager, true);
        } catch (Exception e) {
            c0.u("HomePageItemAttention", "  设置关注界面异常   " + e.toString());
        }
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void h() {
        com.rtk.app.tool.t.S1(this.e, this.homePageItemAttentionTabLayout, this.homePageItemAttentionTab);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.home_page_item_attention_layout, (ViewGroup) null);
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
}
