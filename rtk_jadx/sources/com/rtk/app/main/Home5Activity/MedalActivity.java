package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.adapter.MyMedalListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.AchievementBean;
import com.rtk.app.bean.EventMedalBean;
import com.rtk.app.bean.MedalListBean;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MedalActivity extends BaseActivity implements h.j {

    @BindView
    LinearLayout medalHeadView;

    @BindView
    LinearLayout medalParentLayout;

    @BindView
    RecyclerView medalRecyclerView;

    @BindView
    TextView medalTopBack;

    @BindView
    LinearLayout medalTopLayout;
    private MyMedalListAdapter q;
    private List<AchievementBean> r = new ArrayList();
    private List<EventMedalBean> s = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements com.rtk.app.tool.s {
        a() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            MedalActivity.this.L(1);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.medalTopLayout, null, null, null, this.medalHeadView);
    }

    public void L(int... iArr) {
        String str;
        String str2 = "";
        if (com.rtk.app.tool.y.x(this.f147c)) {
            str = "&uid=" + com.rtk.app.tool.y.K() + "&token=" + com.rtk.app.tool.y.H();
        } else {
            str = "";
        }
        if (iArr[0] == 1) {
            str2 = "members/medalList" + com.rtk.app.tool.y.u(this.f147c) + str + "&already=0&key=" + com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, new String[0])));
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(str2));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        if (i == 0) {
            com.rtk.app.tool.c0.u("MedalActivity", "积分   " + str);
            return;
        }
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("MedalActivity", "勋章列表   " + str);
        MedalListBean medalListBean = (MedalListBean) this.g.fromJson(str, MedalListBean.class);
        if (medalListBean.getData() != null) {
            this.r.addAll(medalListBean.getData().getAchievement());
            this.s.addAll(medalListBean.getData().getEventMedal());
            this.q.notifyDataSetChanged();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("MedalActivity", "勋章列表失败  s" + str);
        if (i2 != 1) {
            return;
        }
        I(str, new a());
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = new MyMedalListAdapter(this.f147c);
        this.medalRecyclerView.setLayoutManager(new LinearLayoutManager(this.f147c));
        this.medalRecyclerView.setAdapter(this.q);
        this.q.o(this.r);
        this.q.p(this.s);
        LinearLayout linearLayout = this.medalParentLayout;
        G(linearLayout, linearLayout);
        L(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299074) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_medal);
        ButterKnife.a(this);
    }
}
