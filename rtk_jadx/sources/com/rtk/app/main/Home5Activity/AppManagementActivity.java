package com.rtk.app.main.Home5Activity;

import android.R;
import android.content.Intent;
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
import com.rtk.app.base.BaseActivity;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AppManagementActivity extends BaseActivity {

    @BindView
    TabLayout appManagementTagLayout;

    @BindView
    TextView appManagementTopBack;

    @BindView
    LinearLayout appManagementTopLayout;

    @BindView
    ViewPager appManagementViewpager;
    private MyFragmentAdapter q;
    private AppManagementOutApkFragment r;
    private AppManagementSystemApkFragment s;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.appManagementTopLayout, this.appManagementTagLayout, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.r = new AppManagementOutApkFragment();
        this.s = new AppManagementSystemApkFragment();
        arrayList.add(this.r);
        arrayList.add(this.s);
        arrayList2.add("已安装");
        arrayList2.add("系统应用");
        this.appManagementTagLayout.setupWithViewPager(this.appManagementViewpager, false);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), arrayList, arrayList2);
        this.q = myFragmentAdapter;
        this.appManagementViewpager.setAdapter(myFragmentAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 600) {
            return;
        }
        this.r.A();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131296513) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_app_management);
        ButterKnife.a(this);
    }
}
