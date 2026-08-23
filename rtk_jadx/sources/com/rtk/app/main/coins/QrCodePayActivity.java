package com.rtk.app.main.coins;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.family.FamilyBaseActivity;
import com.rtk.app.tool.r;
import com.rtk.app.tool.t;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class QrCodePayActivity extends FamilyBaseActivity {

    @BindView
    TextView backTv;

    @BindView
    TextView coins;

    @BindView
    ImageView img;

    @BindView
    View layout;

    @BindView
    View layoutQrcode;

    @BindView
    TextView option;
    String r;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity
    protected void A() {
        View findViewById = findViewById(R.id.back_layout);
        if (findViewById != null && !q()) {
            t.S1(this, findViewById, null, null, null);
        }
        t.S1(this, this.layout, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131300067 && !TextUtils.isEmpty(this.r) && r.b(this)) {
            t.f2(this, this.layoutQrcode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qrcode_pay);
        ButterKnife.a(this);
        String stringExtra = getIntent().getStringExtra("url");
        this.r = stringExtra;
        t.c(this, stringExtra, this.img, new boolean[0]);
        String stringExtra2 = getIntent().getStringExtra(com.umeng.analytics.pro.d.y);
        String stringExtra3 = getIntent().getStringExtra("money");
        this.backTv.setText(stringExtra2);
        this.coins.setText("R币充值-" + stringExtra3 + "元");
        this.option.setText(getString(R.string.alipay_scanner_pay).equals(stringExtra2) ? R.string.alipay_option : R.string.wx_option);
    }
}
