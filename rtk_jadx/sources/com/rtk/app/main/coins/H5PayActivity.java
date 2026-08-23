package com.rtk.app.main.coins;

import android.os.Bundle;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.family.FamilyBaseActivity;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class H5PayActivity extends FamilyBaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qrcode_pay);
        ButterKnife.a(this);
    }
}
