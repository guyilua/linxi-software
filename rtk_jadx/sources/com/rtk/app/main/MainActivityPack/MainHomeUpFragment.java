package com.rtk.app.main.MainActivityPack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.rtk.app.bean.MyAttentionNumBean;
import com.rtk.app.main.UpModule.UpApkListMyAttentionFragment;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MainHomeUpFragment extends BaseFragment implements h.j {

    @BindView
    View headView;

    @BindView
    TabLayout mainHomeUpTab;

    @BindView
    ViewPager mainHomeUpViewPager;
    Unbinder o;
    private MainUpHeadHolder p;
    private List<String> q;
    private List<BaseFragment> r;
    private MyFragmentAdapter s;
    private HomeUpChoicenessFragment t;
    private UpApkListMyAttentionFragment u;
    public MyAttentionNumBean v;

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        String str2;
        c0.u("MainHomeUpFragment", "我关注的up资源数量" + str);
        if (i != 1) {
            return;
        }
        this.v = (MyAttentionNumBean) this.f.fromJson(str, MyAttentionNumBean.class);
        this.q.remove(0);
        int momentsUp = this.v.getData().getMomentsUp();
        this.v.getData().setMomentsUp(momentsUp);
        List<String> list = this.q;
        if (momentsUp == 0) {
            str2 = "我的关注";
        } else {
            str2 = "我的关注(" + momentsUp + ")";
        }
        list.add(0, str2);
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseFragment
    /* renamed from: e */
    protected void B() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/myMomentsTotal");
        sb.append(y.u(this.e));
        sb.append("&uid=");
        sb.append(y.K());
        sb.append("&token=");
        sb.append(y.H());
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.e, "uid=" + y.K(), "token=" + y.H()))));
        com.rtk.app.tool.o.h.l(this.e, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb.toString()));
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void f() {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseFragment
    public void h() {
        com.rtk.app.tool.t.S1(this.e, this.headView, this.mainHomeUpTab);
    }

    @Override // com.rtk.app.base.BaseFragment
    protected void i() {
        this.p = new MainUpHeadHolder(this.e, this.headView);
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        arrayList.add("我的关注");
        this.q.add("精选动态");
        this.r = new ArrayList();
        this.u = new UpApkListMyAttentionFragment();
        this.t = new HomeUpChoicenessFragment();
        this.r.add(this.u);
        this.r.add(this.t);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager(), this.r, this.q);
        this.s = myFragmentAdapter;
        this.mainHomeUpViewPager.setAdapter(myFragmentAdapter);
        this.mainHomeUpTab.setupWithViewPager(this.mainHomeUpViewPager, true);
        this.mainHomeUpViewPager.setCurrentItem(1);
    }

    @Override // com.rtk.app.base.BaseFragment
    public void n() {
        super.n();
        this.p.j();
        this.t.n();
        this.u.n();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.a;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.main_home_up_fragment_layout, viewGroup, false);
            this.a = inflate;
            this.o = ButterKnife.b(this, inflate);
            c();
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
        c0.u("MainHomeUpFragment", "Fragment调用onResume");
        this.p.k();
    }

    public int u() {
        c0.u("MainHomeUpFragment", "被调用getTabNum");
        MyAttentionNumBean myAttentionNumBean = this.v;
        if (myAttentionNumBean == null || myAttentionNumBean.getData() == null) {
            return 0;
        }
        return this.v.getData().getMomentsUp();
    }

    public void v() {
        List<String> list = this.q;
        if (list == null || list.size() <= 0 || this.s == null || !y.x(this.e)) {
            return;
        }
        if (this.q.size() >= 1) {
            this.q.remove(0);
            this.q.add(0, "我的关注");
        }
        this.s.notifyDataSetChanged();
        MyAttentionNumBean myAttentionNumBean = this.v;
        if (myAttentionNumBean == null || myAttentionNumBean.getData() == null) {
            return;
        }
        this.v.getData().setMomentsUp(0);
    }
}
