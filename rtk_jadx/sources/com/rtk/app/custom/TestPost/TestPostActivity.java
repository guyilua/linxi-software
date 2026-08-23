package com.rtk.app.custom.TestPost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class TestPostActivity extends BaseActivity {

    @BindView
    TextView testPostContent;

    @BindView
    Button testPostSelectImg;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_test_post);
        ButterKnife.a(this);
    }
}
