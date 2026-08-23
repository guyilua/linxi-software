package com.rtk.app.main.family;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyNoticeAndIntroduceActivity extends FamilyBaseActivity {
    FamilyInfoBean.DataBean r;

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        ((TextView) findViewById(R.id.family_introduce)).setText(this.r.getFamily_introduce());
        ((TextView) findViewById(R.id.family_notice)).setText(this.r.getFamily_notice());
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_notice_and_introduce);
        ButterKnife.a(this);
        FamilyInfoBean.DataBean dataBean = (FamilyInfoBean.DataBean) getIntent().getSerializableExtra("family_Info");
        this.r = dataBean;
        if (dataBean == null) {
            finish();
        }
    }
}
