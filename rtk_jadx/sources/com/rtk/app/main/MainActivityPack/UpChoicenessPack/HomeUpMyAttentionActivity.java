package com.rtk.app.main.MainActivityPack.UpChoicenessPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.adapter.MyFragmentAdapter;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.FixedViewPager;
import com.rtk.app.custom.MarkedImageView;
import com.rtk.app.main.UpModule.UpApkListMyAttentionFragment;
import com.rtk.app.tool.t;
import java.util.ArrayList;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class HomeUpMyAttentionActivity extends BaseActivity {

    @BindView
    TextView homeUpMyAttentionTopBack;

    @BindView
    MarkedImageView homeUpMyAttentionTopDownload;

    @BindView
    LinearLayout homeUpMyAttentionTopLayout;

    @BindView
    FixedViewPager homeUpMyAttentionViewPager;
    private UpApkListMyAttentionFragment q;
    private MyFragmentAdapter r;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.homeUpMyAttentionTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.BaseActivity
    public void finish() {
        super.finish();
        this.q.n();
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.q = new UpApkListMyAttentionFragment();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.q);
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), arrayList, null);
        this.r = myFragmentAdapter;
        this.homeUpMyAttentionViewPager.setAdapter(myFragmentAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131298148) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_home_up_my_attention);
        ButterKnife.a(this);
    }
}
