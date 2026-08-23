package com.rtk.app.main.family;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.rtk.app.R;
import com.rtk.app.bean.FamilyInfoBean;
import com.rtk.app.custom.NoOOMEditText;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilySelectOpenTypeActivity extends FamilyBaseActivity {

    @BindView
    RadioButton allowed;

    @BindView
    NoOOMEditText answerEditText;

    @BindView
    RadioButton answerQuestion;

    @BindView
    RadioButton notAllowed;

    @BindView
    View questionAnswerLayout;

    @BindView
    NoOOMEditText questionEditText;
    private String r = "1";
    private String s;

    @BindView
    TextView save;
    private String t;
    private String u;
    FamilyInfoBean v;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        View a;

        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                FamilySelectOpenTypeActivity.this.questionAnswerLayout.setVisibility(0);
                if (TextUtils.isEmpty(FamilySelectOpenTypeActivity.this.questionEditText.getText().toString())) {
                    AppCompatEditText appCompatEditText = FamilySelectOpenTypeActivity.this.questionEditText;
                    this.a = appCompatEditText;
                    appCompatEditText.requestFocus();
                } else {
                    AppCompatEditText appCompatEditText2 = FamilySelectOpenTypeActivity.this.answerEditText;
                    this.a = appCompatEditText2;
                    appCompatEditText2.requestFocus();
                }
                com.rtk.app.main.comment.express.b.e(this.a);
                return;
            }
            com.rtk.app.main.comment.express.b.d(this.a);
            FamilySelectOpenTypeActivity.this.questionAnswerLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N(int... iArr) {
        if (iArr[0] != 1) {
            return;
        }
        HashMap<String, String> l = com.rtk.app.tool.y.l();
        l.put("family_id", this.s);
        l.put("open_type", this.r);
        if (TextUtils.equals(GlobalSetting.SPLASH_AD, this.r)) {
            l.put(com.rtk.app.tool.y.z("question"), this.t);
            l.put(com.rtk.app.tool.y.z("answer"), this.u);
        }
        l.put("key", com.rtk.app.tool.t.L(l));
        com.rtk.app.tool.o.h.j(this, this, com.rtk.app.tool.y.e + "family/info/is-allow-join", 1, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.r("FamilySelectOpenTypeActivity", "success,str:" + str);
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this, "设置成功", ErrorCode.NETWORK_UNKNOWN);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this, str, ErrorCode.NETWORK_UNKNOWN);
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initData() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initListener() {
    }

    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.f
    public void initView() {
        this.answerQuestion.setOnCheckedChangeListener(new a());
        int open_type = this.v.getData().getOpen_type();
        if (open_type == 1) {
            this.allowed.setChecked(true);
            return;
        }
        if (open_type == 2) {
            this.notAllowed.setChecked(true);
        } else {
            if (open_type != 3) {
                return;
            }
            this.questionAnswerLayout.setVisibility(0);
            this.questionEditText.setText(this.v.getData().getQuestion());
            this.answerEditText.setText(this.v.getData().getAnswer());
            this.answerQuestion.setChecked(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131300067) {
            return;
        }
        if (this.answerQuestion.isChecked()) {
            this.r = GlobalSetting.SPLASH_AD;
            String trim = this.questionEditText.getText().toString().trim();
            this.t = trim;
            if (TextUtils.isEmpty(trim)) {
                com.rtk.app.tool.f.a(this, "问题不能为空", ErrorCode.NETWORK_UNKNOWN);
                return;
            }
            String trim2 = this.answerEditText.getText().toString().trim();
            this.u = trim2;
            if (TextUtils.isEmpty(trim2)) {
                com.rtk.app.tool.f.a(this, "答案不能为空", ErrorCode.NETWORK_UNKNOWN);
                return;
            }
        } else if (this.allowed.isChecked()) {
            this.r = "1";
        } else {
            this.r = "2";
        }
        N(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.main.family.FamilyBaseActivity, com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_select_open_type);
        ButterKnife.a(this);
        FamilyInfoBean familyInfoBean = (FamilyInfoBean) getIntent().getSerializableExtra("family_Info");
        this.v = familyInfoBean;
        this.s = familyInfoBean.getData().getFamily_id();
    }
}
