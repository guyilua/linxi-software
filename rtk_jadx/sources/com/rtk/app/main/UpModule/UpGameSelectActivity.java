package com.rtk.app.main.UpModule;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.main.dialogPack.AllFileAccessPermissionDialog;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpGameSelectActivity extends BaseActivity {
    private UpGameSelectFragment q;
    private UpGameSelectFragment r;
    private AllFileAccessPermissionDialog s;

    @BindView
    TextView upGameSelectBack;

    @BindView
    RelativeLayout upGameSelectLayout;

    @BindView
    TabLayout upGameSelectTab;

    @BindView
    ViewPager upGameSelectViewPager;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [android.content.Context, com.rtk.app.main.UpModule.UpGameSelectActivity] */
        public void onPageSelected(int i) {
            if (i == 1) {
                com.rtk.app.tool.t.l1(UpGameSelectActivity.this.f147c);
                if (UpGameSelectActivity.this.s == null || !UpGameSelectActivity.this.s.isShowing()) {
                    ?? r2 = UpGameSelectActivity.this;
                    ((UpGameSelectActivity) r2).s = com.rtk.app.tool.r.h(r2);
                    if (UpGameSelectActivity.this.s != null) {
                        UpGameSelectActivity.this.s.e();
                    }
                }
            }
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upGameSelectLayout, this.upGameSelectTab, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        try {
            this.r.t.d(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.q = new UpGameSelectFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isLocalApk", false);
        this.q.setArguments(bundle);
        this.r = new UpGameSelectFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("isLocalApk", true);
        this.r.setArguments(bundle2);
        arrayList.add("本地应用");
        arrayList.add("本地安装包");
        arrayList2.add(this.q);
        arrayList2.add(this.r);
        this.upGameSelectTab.setupWithViewPager(this.upGameSelectViewPager, true);
        this.upGameSelectViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), arrayList2, arrayList));
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upGameSelectViewPager.setOnPageChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 118 && com.rtk.app.tool.r.e(this)) {
            AllFileAccessPermissionDialog allFileAccessPermissionDialog = this.s;
            if (allFileAccessPermissionDialog != null && allFileAccessPermissionDialog.isShowing()) {
                this.s.dismiss();
            }
            this.r.A();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300938) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_up_game_select);
        ButterKnife.a(this);
    }
}
