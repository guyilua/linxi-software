package com.rtk.app.main.MainActivityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class AdActivity extends BaseActivity {

    @BindView
    LinearLayout adLayout;

    private void L() {
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, null, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.base.f
    public void initData() {
        L();
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_ad);
        ButterKnife.a(this);
        Bundle extras = getIntent().getExtras();
        extras.getInt("adType");
        extras.getInt("appId");
        extras.getInt("codeBitId");
    }
}
