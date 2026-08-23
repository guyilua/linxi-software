package com.rtk.app.main.family;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyBaseActivity extends BaseActivity implements h.j {
    protected TextView q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        View findViewById = findViewById(R.id.back_layout);
        if (findViewById == null || q()) {
            return;
        }
        com.rtk.app.tool.t.S1(this, findViewById, null, null, null);
    }

    public synchronized void d(String str, int i) {
    }

    public void g(int i, String str, int i2) {
    }

    public void initData() {
    }

    public void initListener() {
    }

    public void initView() {
    }

    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        TextView textView = (TextView) findViewById(R.id.backTV);
        this.q = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.family.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FamilyBaseActivity.this.M(view);
                }
            });
        }
    }
}
