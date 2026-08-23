package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.LeaderBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySetUserPermissionActivity extends FamilyBaseActivity {
    private LeaderBean A;

    @BindView
    GridView bbsGridView;

    @BindView
    GridView leaderGridView;
    private String r;
    RoundedImageView s;
    TextView t;

    @BindView
    GridView upGridView;
    private k1 x;
    private k1 y;
    private k1 z;

    @BindView
    LinearLayout zuZhangLayout;
    private List<LeaderBean> u = new ArrayList();
    private List<LeaderBean> v = new ArrayList();
    private List<LeaderBean> w = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                FamilySetUserPermissionActivity.this.R(1);
                return;
            }
            if (FamilySetUserPermissionActivity.this.u == null) {
                return;
            }
            com.rtk.app.tool.t.B0(FamilySetUserPermissionActivity.this, ((LeaderBean) FamilySetUserPermissionActivity.this.u.get(i)).getId() + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void R(int i) {
        Intent intent = new Intent((Context) this, (Class<?>) FamilyUserPermissionSelectActivity.class);
        intent.putExtra(com.umeng.analytics.pro.d.y, i);
        intent.putExtra("family_id", this.r);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void T(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            R(3);
        } else {
            if (this.v == null) {
                return;
            }
            com.rtk.app.tool.t.B0(this, this.v.get(i).getId() + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V(AdapterView adapterView, View view, int i, long j) {
        if (i == 0) {
            R(2);
        } else {
            if (this.w == null) {
                return;
            }
            com.rtk.app.tool.t.B0(this, this.w.get(i).getId() + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X(View view) {
        if (this.A != null) {
            com.rtk.app.tool.t.B0(this, this.A.getId() + "");
        }
    }

    public LeaderBean P() {
        LeaderBean leaderBean = new LeaderBean();
        leaderBean.setDefaultFace(R.mipmap.icon_up_picture);
        leaderBean.setNickname("添加");
        return leaderBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Q(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        String str = "&uid=" + com.rtk.app.tool.y.K();
        String str2 = "&token=" + com.rtk.app.tool.y.H();
        StringBuilder sb = new StringBuilder();
        sb.append("family/home-page");
        sb.append(com.rtk.app.tool.y.u(this));
        sb.append(str);
        sb.append(str2);
        sb.append("&family_id=");
        sb.append(this.r);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, "family_id=" + this.r, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        FamilyInfoBean familyInfoBean = (FamilyInfoBean) w(str, FamilyInfoBean.class);
        FamilyInfoBean.DataBean data = familyInfoBean.getData();
        LeaderBean leader = familyInfoBean.getData().getFamily_admin().getLeader();
        this.A = leader;
        com.rtk.app.tool.t.c(this, leader.getFace(), this.s, new boolean[0]);
        this.t.setText(this.A.getNickname());
        List<LeaderBean> second_leader = data.getFamily_admin().getSecond_leader();
        this.u.clear();
        this.u.add(P());
        this.u.addAll(second_leader);
        this.x.notifyDataSetChanged();
        List<LeaderBean> bbs_admin = data.getFamily_admin().getBbs_admin();
        this.w.clear();
        this.w.add(P());
        this.w.addAll(bbs_admin);
        this.z.notifyDataSetChanged();
        List<LeaderBean> up_admin = data.getFamily_admin().getUp_admin();
        this.v.clear();
        this.v.add(P());
        this.v.addAll(up_admin);
        this.y.notifyDataSetChanged();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.r("FamilySetUserPermissionActivity", "code=" + i + "str=" + str + ",mark=" + i2);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        this.leaderGridView.setOnItemClickListener(new a());
        this.upGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.rtk.app.main.family.w
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FamilySetUserPermissionActivity.this.T(adapterView, view, i, j);
            }
        });
        this.bbsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.rtk.app.main.family.x
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                FamilySetUserPermissionActivity.this.V(adapterView, view, i, j);
            }
        });
        this.zuZhangLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.family.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilySetUserPermissionActivity.this.X(view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        this.s = this.zuZhangLayout.findViewById(R.id.game_gridview_item_img);
        int a2 = com.rtk.app.tool.h.a(55.0f, this);
        this.s.setLayoutParams(new LinearLayout.LayoutParams(a2, a2));
        this.s.setOval(true);
        this.t = (TextView) this.zuZhangLayout.findViewById(R.id.game_gridview_item_name);
        this.x = new k1(this, this.u);
        this.u.add(P());
        this.leaderGridView.setAdapter((ListAdapter) this.x);
        this.y = new k1(this, this.v);
        this.v.add(P());
        this.upGridView.setAdapter((ListAdapter) this.y);
        this.z = new k1(this, this.w);
        this.w.add(P());
        this.bbsGridView.setAdapter((ListAdapter) this.z);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_set_user_permission);
        ButterKnife.a(this);
        this.r = getIntent().getStringExtra("family_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        Q(1);
    }
}
