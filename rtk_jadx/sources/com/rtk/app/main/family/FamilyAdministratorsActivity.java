package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.bean.LeaderBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyAdministratorsActivity extends FamilyBaseActivity {

    @BindView
    View bbsDefaultLayout;

    @BindView
    GridView bbsGridView;

    @BindView
    RoundedImageView headLeaderImg;

    @BindView
    TextView headerLeaderName;

    @BindView
    View leaderDefaultLayout;

    @BindView
    GridView leaderGridView;

    @BindView
    TextView manager;
    FamilyInfoBean.DataBean r;
    LeaderBean s;
    private String t;

    @BindView
    View upDefaultLayout;

    @BindView
    GridView upGridView;
    private k1 x;
    private k1 y;
    private k1 z;
    private List<LeaderBean> u = new ArrayList();
    private List<LeaderBean> v = new ArrayList();
    private List<LeaderBean> w = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.B0(FamilyAdministratorsActivity.this, ((LeaderBean) FamilyAdministratorsActivity.this.u.get(i)).getId() + "");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.B0(FamilyAdministratorsActivity.this, ((LeaderBean) FamilyAdministratorsActivity.this.v.get(i)).getId() + "");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.rtk.app.tool.t.B0(FamilyAdministratorsActivity.this, ((LeaderBean) FamilyAdministratorsActivity.this.w.get(i)).getId() + "");
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.B0(FamilyAdministratorsActivity.this, FamilyAdministratorsActivity.this.s.getId() + "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R() {
        this.manager.setVisibility(this.r.isAdmin(com.rtk.app.tool.y.K()) ? 0 : 8);
        LeaderBean leader = this.r.getFamily_admin().getLeader();
        this.s = leader;
        this.headerLeaderName.setText(leader.getNickname());
        com.rtk.app.tool.t.c(this, this.s.getFace(), this.headLeaderImg, new boolean[0]);
        List<LeaderBean> second_leader = this.r.getFamily_admin().getSecond_leader();
        if (second_leader.isEmpty()) {
            this.leaderDefaultLayout.setVisibility(0);
            this.leaderGridView.setVisibility(8);
        } else {
            this.leaderDefaultLayout.setVisibility(8);
            this.leaderGridView.setVisibility(0);
            this.u.clear();
            this.u.addAll(second_leader);
            this.x.notifyDataSetChanged();
        }
        List<LeaderBean> bbs_admin = this.r.getFamily_admin().getBbs_admin();
        if (bbs_admin.isEmpty()) {
            this.bbsDefaultLayout.setVisibility(0);
            this.bbsGridView.setVisibility(8);
        } else {
            this.bbsDefaultLayout.setVisibility(8);
            this.bbsGridView.setVisibility(0);
            this.w.clear();
            this.w.addAll(bbs_admin);
            this.z.notifyDataSetChanged();
        }
        List<LeaderBean> up_admin = this.r.getFamily_admin().getUp_admin();
        if (up_admin.isEmpty()) {
            this.upDefaultLayout.setVisibility(0);
            this.upGridView.setVisibility(8);
            return;
        }
        this.upDefaultLayout.setVisibility(8);
        this.upGridView.setVisibility(0);
        this.v.clear();
        this.v.addAll(up_admin);
        this.y.notifyDataSetChanged();
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
        sb.append(this.t);
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, "family_id=" + this.t, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb.toString()));
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.r("FamilyManagerActivity", "success,str:" + str);
        if (i != 1) {
            return;
        }
        this.r = ((FamilyInfoBean) this.g.fromJson(str, FamilyInfoBean.class)).getData();
        R();
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
        super.initListener();
        this.leaderGridView.setOnItemClickListener(new a());
        this.upGridView.setOnItemClickListener(new b());
        this.bbsGridView.setOnItemClickListener(new c());
        this.headLeaderImg.setOnClickListener(new d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        super.initView();
        k1 k1Var = new k1(this, this.u);
        this.x = k1Var;
        this.leaderGridView.setAdapter((ListAdapter) k1Var);
        k1 k1Var2 = new k1(this, this.v);
        this.y = k1Var2;
        this.upGridView.setAdapter((ListAdapter) k1Var2);
        k1 k1Var3 = new k1(this, this.w);
        this.z = k1Var3;
        this.bbsGridView.setAdapter((ListAdapter) k1Var3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.bbs_default_layout /* 2131296703 */:
            case R.id.leader_default_layout /* 2131298929 */:
            case R.id.up_default_layout /* 2131300845 */:
                com.rtk.app.tool.f.a(this, "本家族此岗位暂时缺乏", ErrorCode.NETWORK_UNKNOWN);
                return;
            case R.id.manager /* 2131299023 */:
                Intent intent = new Intent((Context) this, (Class<?>) FamilyManagerActivity.class);
                intent.putExtra("family_Info", this.r);
                startActivity(intent);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_administrators_layout);
        ButterKnife.a(this);
        this.t = getIntent().getStringExtra("family_id");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        Q(1);
    }
}
