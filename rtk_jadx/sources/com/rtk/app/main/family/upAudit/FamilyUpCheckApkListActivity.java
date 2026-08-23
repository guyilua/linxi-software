package com.rtk.app.main.family.upAudit;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.base.BaseFragment;
import com.rtk.app.custom.BaseViewPager;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.UpModule.UpAuditSearchActivity;
import com.rtk.app.main.family.FamilyProtocolActivity;
import com.rtk.app.tool.DownLoadTool.x;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpCheckApkListActivity extends BaseActivity {

    @BindView
    View help;
    private List<String> q = new ArrayList();
    private List<BaseFragment> r = new ArrayList();
    private String s;

    @BindView
    TabLayout upCheckApkListTabLayout;

    @BindView
    TextView upCheckApkListTopBack;

    @BindView
    MarkedImageView upCheckApkListTopDownload;

    @BindView
    LinearLayout upCheckApkListTopLayout;

    @BindView
    TextView upCheckApkListTopSearch;

    @BindView
    BaseViewPager upCheckApkListViewpager;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.upCheckApkListTopLayout, this.upCheckApkListTabLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        for (BaseFragment baseFragment : this.r) {
            c0.u("UpCheckApkListActivity", "开始回收");
            baseFragment.n();
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        this.q.add("待审核");
        this.q.add("审核不通过");
        this.q.add("审核通过");
        this.q.add("已下架");
        for (int i = 0; i < this.q.size(); i++) {
            UpCheckApkListFamilyFragment upCheckApkListFamilyFragment = new UpCheckApkListFamilyFragment();
            Bundle bundle = new Bundle();
            if (i == 3) {
                bundle.putString("status", TextUtils.isEmpty(this.s) ? "0" : GlobalSetting.NATIVE_EXPRESS_AD);
            } else {
                bundle.putString("status", (i + 1) + "");
            }
            bundle.putString("family_id", this.s);
            upCheckApkListFamilyFragment.setArguments(bundle);
            this.r.add(upCheckApkListFamilyFragment);
        }
        this.b = new com.rtk.app.tool.DownLoadTool.n(this.upCheckApkListTopDownload);
        x.c().b(this.b);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), this.r, this.q);
        this.upCheckApkListTabLayout.setupWithViewPager(this.upCheckApkListViewpager, true);
        this.upCheckApkListViewpager.setAdapter(myFragmentAdapter);
        this.help.setVisibility(0);
        this.upCheckApkListTopBack.setText("家族UP审核列表");
        this.upCheckApkListTopSearch.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Iterator<BaseFragment> it = this.r.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.help /* 2131297862 */:
                Bundle bundle = new Bundle();
                bundle.putString("title", "家族UP审核功能帮助");
                bundle.putString("url", "user/agreement/family/up-check-help");
                com.rtk.app.tool.c.b(this, FamilyProtocolActivity.class, bundle);
                return;
            case com.rtk.app.R.id.up_check_apk_list_top_back /* 2131300757 */:
                finish();
                return;
            case com.rtk.app.R.id.up_check_apk_list_top_download /* 2131300758 */:
                t.o0(this.f147c);
                return;
            case com.rtk.app.R.id.up_check_apk_list_top_search /* 2131300760 */:
                com.rtk.app.tool.c.b(this.f147c, UpAuditSearchActivity.class, null);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_check_apk_list);
        ButterKnife.a(this);
        this.s = getIntent().getStringExtra("family_id");
    }
}
