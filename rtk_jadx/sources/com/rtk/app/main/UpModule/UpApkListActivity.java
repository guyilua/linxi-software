package com.rtk.app.main.UpModule;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.MyAttentionNumBean;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpExampleListFragment;
import com.rtk.app.main.MainActivityPack.UpChoicenessPack.HomeUpSrcListFragemnt;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpApkListActivity extends BaseActivity implements h.j {
    private MyFragmentAdapter s;
    private com.rtk.app.main.UpModule.UpControlPack.c.b t;

    @BindView
    TabLayout upApkListTab;

    @BindView
    TextView upApkListTopBack;

    @BindView
    TextView upApkListTopGoToCheck;

    @BindView
    TextView upApkListTopGoToCommentCheck;

    @BindView
    LinearLayout upApkListTopLayout;

    @BindView
    MarkedImageView upApkListTopMyUpLoading;

    @BindView
    ImageView upApkListUpBtu;

    @BindView
    ViewPager upApkListViewpager;
    private List<String> q = new ArrayList();
    private List<BaseFragment> r = new ArrayList();
    private int u = 0;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upApkListTopLayout, this.upApkListTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/myMomentsTotal");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        String str2;
        com.rtk.app.tool.c0.u("UpApkListActivity", "我关注的up资源数量" + str);
        if (i != 1) {
            return;
        }
        MyAttentionNumBean myAttentionNumBean = (MyAttentionNumBean) this.g.fromJson(str, MyAttentionNumBean.class);
        this.q.remove(0);
        int momentsUp = myAttentionNumBean.getData().getMomentsUp();
        List<String> list = this.q;
        if (momentsUp == 0) {
            str2 = "关注";
        } else {
            str2 = "关注(" + momentsUp + ")";
        }
        list.add(0, str2);
        this.s.notifyDataSetChanged();
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (int i = 0; i < this.r.size(); i++) {
            this.r.get(i).n();
        }
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().c(this.t);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q.add("关注");
        this.q.add("最新");
        this.q.add("热度");
        this.q.add("赏金榜");
        this.q.add("人气旺");
        this.r.add(new UpApkListMyAttentionFragment());
        UpApkListFragment upApkListFragment = new UpApkListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("listType", 0);
        upApkListFragment.setArguments(bundle);
        this.r.add(upApkListFragment);
        HomeUpSrcListFragemnt homeUpSrcListFragemnt = new HomeUpSrcListFragemnt();
        Bundle bundle2 = new Bundle();
        bundle2.putString("model", "recommonds");
        homeUpSrcListFragemnt.setArguments(bundle2);
        this.r.add(homeUpSrcListFragemnt);
        HomeUpExampleListFragment homeUpExampleListFragment = new HomeUpExampleListFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString("dayType", "month");
        bundle3.putString("url", "up/reward-ranking");
        homeUpExampleListFragment.setArguments(bundle3);
        this.r.add(homeUpExampleListFragment);
        HomeUpExampleListFragment homeUpExampleListFragment2 = new HomeUpExampleListFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putString("dayType", "month");
        bundle4.putString("url", "up/down-ranking");
        homeUpExampleListFragment2.setArguments(bundle4);
        this.r.add(homeUpExampleListFragment2);
        if (c.d.a.d.d() && (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getAdmin() == 2 || MainActivity.p.getData().getAdmin().getUpAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAdmin() == 2)) {
            this.upApkListTopGoToCheck.setVisibility(0);
            this.upApkListTopGoToCommentCheck.setVisibility(0);
            this.u = (MainActivity.p.getData().getAdmin().getAdmin() == 1 || MainActivity.p.getData().getAdmin().getUpAdmin() == 1) ? 1 : 2;
        } else {
            this.upApkListTopGoToCheck.setVisibility(8);
        }
        if (c.d.a.d.d()) {
            if (MainActivity.p.getData().getAdmin().getCommentadmin() != 1 && this.u != 1) {
                if (MainActivity.p.getData().getAdmin().getCommentadmin() == 2) {
                    this.u = 2;
                    this.upApkListTopGoToCommentCheck.setVisibility(0);
                    return;
                }
                return;
            }
            this.u = 1;
            this.upApkListTopGoToCommentCheck.setVisibility(0);
            return;
        }
        this.upApkListTopGoToCommentCheck.setVisibility(8);
        this.u = 0;
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.s = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
        this.upApkListTab.setupWithViewPager(this.upApkListViewpager, true);
        this.upApkListViewpager.setAdapter(this.s);
        this.upApkListViewpager.setCurrentItem(1);
        this.t = new com.rtk.app.main.UpModule.UpControlPack.c.b(this.upApkListTopMyUpLoading);
        com.rtk.app.main.UpModule.UpControlPack.c.a.b().a(this.t);
        L(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.up_apk_list_top_back /* 2131300694 */:
                finish();
                return;
            case com.rtk.app.R.id.up_apk_list_top_goToCheck /* 2131300695 */:
                com.rtk.app.tool.c.b(this.f147c, UpCheckApkListActivity.class, null);
                return;
            case com.rtk.app.R.id.up_apk_list_top_goTo_comment_Check /* 2131300696 */:
                com.rtk.app.tool.c0.u("UpApkListActivity", " onClick 跳转审核回复页面");
                Bundle bundle = new Bundle();
                bundle.putInt("hasCommentPermission", this.u);
                com.rtk.app.tool.c.b(this.f147c, UpCommentAuditListActivity.class, bundle);
                return;
            case com.rtk.app.R.id.up_apk_list_top_help /* 2131300697 */:
                com.rtk.app.tool.c.b(this.f147c, UpHelpActivity.class, null);
                return;
            case com.rtk.app.R.id.up_apk_list_top_layout /* 2131300698 */:
            default:
                return;
            case com.rtk.app.R.id.up_apk_list_top_my_up_loading /* 2131300699 */:
                com.rtk.app.tool.c.b(this.f147c, UpLoadPoolControlActivity.class, null);
                return;
            case com.rtk.app.R.id.up_apk_list_upBtu /* 2131300700 */:
                com.rtk.app.tool.t.e2(this.f147c, this.upApkListUpBtu);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_apk_list);
        ButterKnife.a(this);
    }
}
