package com.rtk.app.main.Home5Activity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.RealNameAuthBean;
import com.rtk.app.custom.CustomSingleEditTextView;
import com.rtk.app.main.family.AuthRealNameProtocolActivity;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class RealNameAuthActivity extends BaseActivity implements h.j {

    @BindView
    View backLayout;

    @BindView
    View backTv;

    @BindView
    CheckBox checkBox;

    @BindView
    View checkBoxLayout;

    @BindView
    CustomSingleEditTextView identityEditTextView;

    @BindView
    CustomSingleEditTextView nameEditTextView;
    String q;
    String r;
    RealNameAuthBean s;

    @BindView
    View submit;

    @BindView
    TextView tips;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements InputFilter {
        a() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (RealNameAuthActivity.this.s.getData() != null && RealNameAuthActivity.this.s.getData().isAuthenticated()) {
                return null;
            }
            if ("X".equalsIgnoreCase(charSequence.toString())) {
                return "X";
            }
            if (charSequence.toString().matches("[0-9]+")) {
                return null;
            }
            return "";
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.backLayout, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void L(int... iArr) {
        if (com.rtk.app.tool.y.x(this)) {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            int i = iArr[0];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                l.put("key", com.rtk.app.tool.t.L(l));
                com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "user/real-name-auth/query", 2, l);
                return;
            }
            l.put("name", this.q);
            l.put("idNum", this.r);
            l.put("key", com.rtk.app.tool.t.L(l));
            com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "user/real-name-auth/check", 1, l);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.r("RealNameAuthActivity", "mark=" + i + ",str=" + com.rtk.app.c.a.b(str));
        if (i == 1) {
            com.rtk.app.tool.f.a(this, "提交成功", f.a.f);
            finish();
            return;
        }
        if (i != 2) {
            return;
        }
        RealNameAuthBean realNameAuthBean = (RealNameAuthBean) w(str, RealNameAuthBean.class);
        this.s = realNameAuthBean;
        if (realNameAuthBean.getData() != null && this.s.getData().isAuthenticated()) {
            this.nameEditTextView.setContent(this.s.getData().getReal_name());
            this.nameEditTextView.setEnabled(false);
            this.identityEditTextView.setContent(this.s.getData().getId_num());
            this.identityEditTextView.setEnabled(false);
            this.submit.setVisibility(8);
            this.checkBoxLayout.setVisibility(8);
            return;
        }
        this.tips.setText(this.s.getData().getTips());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, f.a.f);
    }

    @Override // com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.nameEditTextView.setMaxWordCount(0);
        this.nameEditTextView.setHint("请输入您的真实姓名");
        this.nameEditTextView.setBackgroundResource(R.drawable.shape_search_corner5dp_theme_dark666);
        this.identityEditTextView.setHint("请输入您的真实身份证号");
        this.identityEditTextView.setBackgroundResource(R.drawable.shape_search_corner5dp_theme_dark666);
        this.identityEditTextView.setMaxWordCount(18);
        this.identityEditTextView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18), new a()});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131296692) {
            finish();
            return;
        }
        if (id != 2131300333) {
            if (id != 2131301134) {
                return;
            }
            com.rtk.app.tool.c.b(this, AuthRealNameProtocolActivity.class, null);
            return;
        }
        String content = this.nameEditTextView.getContent();
        this.q = content;
        if (TextUtils.isEmpty(content)) {
            com.rtk.app.tool.f.a(this, "请输入您的真实姓名", f.a.f);
            return;
        }
        String content2 = this.identityEditTextView.getContent();
        this.r = content2;
        if (!TextUtils.isEmpty(content2) && c.d.a.c.a(this.r)) {
            if (!this.checkBox.isChecked()) {
                com.rtk.app.tool.f.a(this, "请勾选同意实名认证服务协议", 200);
                return;
            } else {
                L(1);
                return;
            }
        }
        com.rtk.app.tool.f.a(this, "请输入您的真实身份证号", f.a.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_real_name_auth_layout);
        ButterKnife.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rtk.app.base.BaseActivity
    public void onResume() {
        super.onResume();
        L(2);
    }
}
