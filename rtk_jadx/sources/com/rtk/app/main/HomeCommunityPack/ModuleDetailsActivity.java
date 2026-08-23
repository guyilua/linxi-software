package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.adapter.PostModeratorListAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.ModuleDetailsBean;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class ModuleDetailsActivity extends BaseActivity implements h.j {

    @BindView
    RoundedImageView moduleDetailsIcon;

    @BindView
    TextView moduleDetailsIntro;

    @BindView
    GridView moduleDetailsModerator;

    @BindView
    TextView moduleDetailsName;

    @BindView
    TextView moduleDetailsRuleWebView;

    @BindView
    TextView moduleDetailsTopBack;

    @BindView
    LinearLayout moduleDetailsTopLayout;
    private ModuleDetailsBean s;
    private PostModeratorListAdapter u;
    private String q = "";
    private String r = "";
    private List<ModuleDetailsBean.DataBean.ModeratorListBean> t = new ArrayList();

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends com.rtk.app.custom.AutoListView.b {
        a() {
        }

        @Override // com.rtk.app.custom.AutoListView.b
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            ModuleDetailsActivity moduleDetailsActivity = ModuleDetailsActivity.this;
            com.rtk.app.tool.t.B0(moduleDetailsActivity.f147c, ((ModuleDetailsBean.DataBean.ModeratorListBean) moduleDetailsActivity.t.get(i)).getUid());
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.moduleDetailsTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void M(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/moudelDetail");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&mid=");
            sb2.append(this.q);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "mid=" + this.q))));
            sb = sb2.toString();
        }
        if (com.rtk.app.tool.c0.q(sb)) {
            return;
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("ModuleDetailsActivity", "模块详情" + str);
        ModuleDetailsBean moduleDetailsBean = (ModuleDetailsBean) this.g.fromJson(str, ModuleDetailsBean.class);
        this.s = moduleDetailsBean;
        this.moduleDetailsIntro.setText(moduleDetailsBean.getData().getIntroduction());
        com.rtk.app.tool.t.c(this.f147c, this.s.getData().getLogo(), this.moduleDetailsIcon, new boolean[0]);
        this.moduleDetailsRuleWebView.setText(this.s.getData().getDescription());
        this.t.clear();
        this.t.addAll(this.s.getData().getModeratorList());
        this.u.notifyDataSetChanged();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.moduleDetailsModerator.setOnItemClickListener(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = getIntent().getExtras().getString("mid");
        this.r = getIntent().getExtras().getString("moduleName");
        M(1);
        this.moduleDetailsName.setText(this.r);
        this.moduleDetailsTopBack.setText(this.r);
        PostModeratorListAdapter postModeratorListAdapter = new PostModeratorListAdapter(this.f147c, this.t);
        this.u = postModeratorListAdapter;
        this.moduleDetailsModerator.setAdapter((ListAdapter) postModeratorListAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299101) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_module_details);
        ButterKnife.a(this);
    }
}
