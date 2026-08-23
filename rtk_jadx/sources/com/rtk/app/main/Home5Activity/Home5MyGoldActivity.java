package com.rtk.app.main.Home5Activity;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.Home5MyGoldBean;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.main.coins.ExchangeGoldCoinsActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class Home5MyGoldActivity extends BaseActivity {

    @BindView
    CustomTextView home5MyGoldAllExpense;

    @BindView
    CustomTextView home5MyGoldAllIncome;

    @BindView
    AppBarLayout home5MyGoldBar;

    @BindView
    TextView home5MyGoldGoldNum;

    @BindView
    TabLayout home5MyGoldTab;

    @BindView
    TextView home5MyGoldTopBack;

    @BindView
    ImageView home5MyGoldTopExplainBtu;

    @BindView
    LinearLayout home5MyGoldTopLayout;

    @BindView
    BaseViewPager home5MyGoldViewpager;
    private List<Fragment> q;
    private List<String> r;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.home5MyGoldTopLayout, this.home5MyGoldTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void L(Home5MyGoldBean home5MyGoldBean) {
        this.home5MyGoldGoldNum.setText(home5MyGoldBean.getData().getTotalCoin() + "");
        this.home5MyGoldAllIncome.setText(home5MyGoldBean.getData().getIncome() + "");
        this.home5MyGoldAllExpense.setText(home5MyGoldBean.getData().getOutcome() + "");
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q = new ArrayList();
        this.r = new ArrayList();
        for (int i = 0; i < 3; i++) {
            Home5MyGoldFragment home5MyGoldFragment = new Home5MyGoldFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(com.umeng.analytics.pro.d.y, i);
            home5MyGoldFragment.setArguments(bundle);
            this.q.add(home5MyGoldFragment);
        }
        this.r.add("全部");
        this.r.add("收入");
        this.r.add("支出");
        this.home5MyGoldTab.setupWithViewPager(this.home5MyGoldViewpager, true);
        this.home5MyGoldViewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), this.q, this.r));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.home5_my_gold_top_back /* 2131298000 */:
                finish();
                return;
            case com.rtk.app.R.id.home5_my_gold_top_explain_btu /* 2131298001 */:
                com.rtk.app.tool.c.b(this.f147c, GoldRuleActivity.class, null);
                return;
            case com.rtk.app.R.id.more /* 2131299117 */:
                if (com.rtk.app.tool.y.x(this)) {
                    com.rtk.app.tool.c.b(this.f147c, ExchangeGoldCoinsActivity.class, null);
                    return;
                } else {
                    com.rtk.app.tool.t.w0(this);
                    return;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home5_my_gold);
        ButterKnife.a(this);
    }
}
