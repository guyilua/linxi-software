package com.rtk.app.main.HomeCommunityPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.custom.RichEditText.RichEditText;
import com.rtk.app.tool.o.h;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditPostActivity extends BaseActivity implements h.j {

    @BindView
    RichEditText editPostEditText;

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, null, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        this.editPostEditText.setTagStr(getIntent().getExtras().getString("editStr"));
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
        setContentView(com.rtk.app.R.layout.activity_edit_post);
        ButterKnife.a(this);
    }
}
