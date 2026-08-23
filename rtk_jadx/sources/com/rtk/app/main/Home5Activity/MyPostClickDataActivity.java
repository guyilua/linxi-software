package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.adapter.MyPostClickDataFragment;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.bean.UpSrcClickNumBean;
import com.rtk.app.tool.o.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class MyPostClickDataActivity extends BaseActivity implements h.j {
    private List<BaseFragment> q = new ArrayList();
    private List<String> r = new ArrayList();
    private String s;
    private Bundle t;
    private UpSrcClickNumBean u;

    @BindView
    TextView upSrcClickDataAllDownloadNum;

    @BindView
    LinearLayout upSrcClickDataAllLv;

    @BindView
    TabLayout upSrcClickDataTabLayout;

    @BindView
    TextView upSrcClickDataToday;

    @BindView
    TextView upSrcClickDataTopBack;

    @BindView
    LinearLayout upSrcClickDataTopLayout;

    @BindView
    ViewPager upSrcClickDataViewPage;

    @BindView
    LinearLayout upSrcParentLayout;

    @BindView
    TextView upTip;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(String[] strArr) {
        L(1);
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upSrcClickDataTopLayout, this.upSrcClickDataTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0), this.upSrcClickDataAllLv);
    }

    public void L(int... iArr) {
        String sb;
        if (iArr[0] != 1) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bbs/pv/count");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.H());
            sb2.append("&posts_id=");
            sb2.append(this.s);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "posts_id=" + this.s, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(sb));
        com.rtk.app.tool.c0.u("MyPostClickDataActivity", "" + com.rtk.app.tool.y.d + sb);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        F();
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("MyPostClickDataActivity", "帖子点击量等信息  " + str);
        this.u = (UpSrcClickNumBean) this.g.fromJson(str, UpSrcClickNumBean.class);
        this.upSrcClickDataToday.setText(this.u.getData().getToday() + "");
        this.upSrcClickDataAllDownloadNum.setText(this.u.getData().getTotal() + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("MyPostClickDataActivity", "帖子点击量等信息  " + str);
        if (i2 != 1) {
            return;
        }
        I(str, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.Home5Activity.v0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                MyPostClickDataActivity.this.N(strArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.t = extras;
        this.s = extras.getString("up_id");
        L(1);
        this.r.add("7日");
        this.r.add("30日");
        this.r.add("60日");
        this.r.add("90日");
        for (int i = 0; i < 4; i++) {
            MyPostClickDataFragment myPostClickDataFragment = new MyPostClickDataFragment();
            Bundle bundle = new Bundle();
            bundle.putString("sid", this.s);
            if (i == 0) {
                bundle.putInt("range", 7);
            } else if (i == 1) {
                bundle.putInt("range", 30);
            } else if (i == 2) {
                bundle.putInt("range", 60);
            } else if (i == 3) {
                bundle.putInt("range", 90);
            }
            myPostClickDataFragment.setArguments(bundle);
            this.q.add(myPostClickDataFragment);
        }
        this.upSrcClickDataTabLayout.setupWithViewPager(this.upSrcClickDataViewPage, true);
        this.upSrcClickDataViewPage.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        try {
            if (Long.parseLong(this.s) <= 573462) {
                this.upTip.setVisibility(0);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131301024) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_src_click_data);
        ButterKnife.a(this);
        LinearLayout linearLayout = this.upSrcParentLayout;
        G(linearLayout, linearLayout);
    }
}
