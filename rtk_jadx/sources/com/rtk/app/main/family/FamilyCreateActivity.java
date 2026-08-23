package com.rtk.app.main.family;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyCreateCheckTipsBean;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.custom.CustomSingleEditTextView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyCreateActivity extends FamilyBaseActivity {

    @BindView
    CheckBox checkBox;

    @BindView
    TextView desc;

    @BindView
    CustomSingleEditTextView familyNameEditText;

    @BindView
    TextView goCreateFamily;

    @BindView
    TextView protocolTV;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements h.j {
        a() {
        }

        @Override // com.rtk.app.tool.o.h.j
        public void d(String str, int i) {
            com.rtk.app.tool.c0.r("CreateFamilyActivity", "success，str=" + str);
            Intent intent = new Intent((Context) FamilyCreateActivity.this, (Class<?>) MyFamilyActivity.class);
            intent.putExtra("family_id", ((FamilyInfoBean) FamilyCreateActivity.this.w(str, FamilyInfoBean.class)).getData().getFamily_id());
            FamilyCreateActivity.this.startActivity(intent);
            FamilyCreateActivity.this.finish();
        }

        @Override // com.rtk.app.tool.o.h.j
        public void g(int i, String str, int i2) {
            com.rtk.app.tool.c0.r("CreateFamilyActivity", "onError--" + i + "," + str);
            com.rtk.app.tool.f.a(FamilyCreateActivity.this, str, f.a.f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.l(this, this, 1, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("family/create/check", l)));
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public synchronized void d(String str, int i) {
        super.d(str, i);
        FamilyCreateCheckTipsBean.DataBean data = ((FamilyCreateCheckTipsBean) w(str, FamilyCreateCheckTipsBean.class)).getData();
        if (data == null) {
            return;
        }
        this.desc.setText(data.getCreateDesc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, f.a.f);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297800) {
            if (id != 2131301134) {
                return;
            }
            com.rtk.app.tool.c.b(this, FamilyProtocolActivity.class, null);
            return;
        }
        if (!com.rtk.app.tool.y.x(this)) {
            com.rtk.app.tool.t.w0(this);
            return;
        }
        if (!this.checkBox.isChecked()) {
            com.rtk.app.tool.f.a(this, "请勾选家族功能使用协议", f.a.f);
            return;
        }
        String trim = this.familyNameEditText.getContent().toString().trim();
        if (!TextUtils.isEmpty(trim) && trim.length() >= 2) {
            HashMap hashMap = new HashMap();
            hashMap.put("channel", com.rtk.app.tool.y.m(this, getPackageName()));
            hashMap.put("version", com.rtk.app.tool.y.i(this));
            hashMap.put(ak.aj, com.rtk.app.tool.y.g());
            hashMap.put("phone_model", com.rtk.app.tool.y.T());
            hashMap.put("uid", com.rtk.app.tool.y.K() + "");
            hashMap.put("token", com.rtk.app.tool.y.H());
            hashMap.put("name", trim);
            hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "name=" + trim))));
            a aVar = new a();
            StringBuilder sb = new StringBuilder();
            sb.append(com.rtk.app.tool.y.e);
            sb.append("family/create");
            com.rtk.app.tool.o.h.j(this, aVar, sb.toString(), 0, hashMap);
            return;
        }
        com.rtk.app.tool.f.a(this, "家族名字不能少于2个字", f.a.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_family);
        ButterKnife.a(this);
        this.familyNameEditText.setMaxWordCount(10);
        this.familyNameEditText.setHint("请输入家族名称");
        N(new int[0]);
    }
}
