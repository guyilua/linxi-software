package com.rtk.app.main.OtherImfomationPack;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.OtherImformationBean;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import java.util.Date;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class EditOtherPersonActivity extends BaseActivity implements h.j {

    @BindView
    TextView editOtherPersonalBack;

    @BindView
    TextView editOtherPersonalEnsure;

    @BindView
    TextView editOtherPersonalInformationBirthday;

    @BindView
    LinearLayout editOtherPersonalInformationBirthdayLayout;

    @BindView
    NoOOMEditText editOtherPersonalInformationEmail;

    @BindView
    LinearLayout editOtherPersonalInformationEmailLayout;

    @BindView
    NoOOMEditText editOtherPersonalInformationIntro;

    @BindView
    LinearLayout editOtherPersonalInformationIntroLayout;

    @BindView
    NoOOMEditText editOtherPersonalInformationName;

    @BindView
    LinearLayout editOtherPersonalInformationNameLayout;

    @BindView
    NoOOMEditText editOtherPersonalInformationQQ;

    @BindView
    LinearLayout editOtherPersonalInformationQQLayout;

    @BindView
    RadioGroup editOtherPersonalInformationSex;

    @BindView
    LinearLayout editOtherPersonalInformationSexLayout;

    @BindView
    RelativeLayout editOtherPersonalTopLayout;
    private OtherImformationBean r;
    private long w;
    private String q = "";
    private String s = "";
    private int t = 1;
    private String u = "";
    private String v = "";
    private String x = "";

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            EditOtherPersonActivity.this.t = (i % 2) + 1;
            c0.u("EditOtherPersonActivity", "性别" + EditOtherPersonActivity.this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements com.codbking.widget.g {
        b() {
        }

        public void a(Date date) {
            EditOtherPersonActivity.this.w = date.getTime() / 1000;
            EditOtherPersonActivity.this.r.getData().setBirthday(((int) EditOtherPersonActivity.this.w) + "");
            EditOtherPersonActivity editOtherPersonActivity = EditOtherPersonActivity.this;
            editOtherPersonActivity.editOtherPersonalInformationBirthday.setText(c0.g(editOtherPersonActivity.w));
            c0.u("EditOtherPersonActivity", "生日" + EditOtherPersonActivity.this.w);
        }
    }

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class c implements com.rtk.app.tool.s {
        c() {
        }

        @Override // com.rtk.app.tool.s
        public void a(String... strArr) {
            EditOtherPersonActivity.this.Q(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R() {
        com.codbking.widget.b bVar = new com.codbking.widget.b(this);
        bVar.n(28);
        bVar.k(new Date(90, 1, 1));
        bVar.l("请选择时间");
        bVar.m(com.codbking.widget.i.a.d);
        bVar.i((com.codbking.widget.f) null);
        bVar.j(new b());
        bVar.show();
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.editOtherPersonalTopLayout, null, null, ((ViewGroup) findViewById(R.id.content)).getChildAt(0));
    }

    public void Q(int... iArr) {
        int i = iArr[0];
        String str = "";
        if (i == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("members/baseInfo");
            sb.append(y.u(this.f147c));
            sb.append("&uid=");
            sb.append(this.q);
            sb.append("&fans=");
            sb.append(y.K());
            sb.append("&key=");
            sb.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "uid=" + this.q))));
            str = sb.toString();
        } else if (i == 2) {
            if (!c0.q(this.u)) {
                str = "&qq=" + this.u;
            }
            String str2 = (str + "&birthday=" + this.w) + "&sex=" + this.t;
            MainActivity.p.getData().setSex(this.t);
            if (!c0.q(this.x)) {
                str2 = str2 + "&signature=" + com.rtk.app.tool.t.f(this.x);
            }
            if (!c0.q(this.v)) {
                str2 = str2 + "&email=" + this.v;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("member/userInfoUpdate");
            sb2.append(y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(MainActivity.p.getData().getUid());
            sb2.append("&token=");
            sb2.append(y.G(this.f147c));
            sb2.append("&touser=");
            sb2.append(this.q);
            sb2.append("&nickname=");
            sb2.append(com.rtk.app.tool.t.f(this.s));
            sb2.append(str2);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(c0.e(y.v(this.f147c, "uid=" + MainActivity.p.getData().getUid()))));
            str = sb2.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(str));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("EditOtherPersonActivity", "修改成功  " + str);
        F();
        if (i != 1) {
            if (i != 2) {
                return;
            }
            com.rtk.app.tool.f.a(this.f147c, "修改成功", f.a.f);
            finish();
            return;
        }
        c0.u("EditOtherPersonActivity", "其他用户个人信息  " + str);
        OtherImformationBean otherImformationBean = (OtherImformationBean) this.g.fromJson(str, OtherImformationBean.class);
        this.r = otherImformationBean;
        this.editOtherPersonalInformationName.setText(otherImformationBean.getData().getNickname());
        if (this.r.getData().getSex().equals("1")) {
            ((RadioButton) this.editOtherPersonalInformationSex.getChildAt(0)).setChecked(true);
        } else {
            ((RadioButton) this.editOtherPersonalInformationSex.getChildAt(1)).setChecked(true);
        }
        if (!c0.q(this.r.getData().getQq())) {
            this.editOtherPersonalInformationQQ.setText(this.r.getData().getQq() + "");
        }
        if (!c0.q(this.r.getData().getEmail())) {
            this.editOtherPersonalInformationEmail.setText(this.r.getData().getEmail() + "");
        }
        if (!c0.q(this.r.getData().getBirthday())) {
            this.editOtherPersonalInformationBirthday.setText(c0.g(Long.parseLong(this.r.getData().getBirthday())));
        }
        if (c0.q(this.r.getData().getSignature())) {
            return;
        }
        this.editOtherPersonalInformationIntro.setText(this.r.getData().getSignature() + "");
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("EditOtherPersonActivity", "修改失败  " + str);
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        if (i2 != 1) {
            return;
        }
        I(str, new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = (OtherImformationBean) extras.getSerializable("otherImformationBean");
        this.q = extras.getString("id");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.editOtherPersonalInformationSex.setOnCheckedChangeListener(new a());
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        G(null, this.editOtherPersonalTopLayout);
        Q(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case com.rtk.app.R.id.edit_other_personal_back /* 2131297468 */:
                finish();
                return;
            case com.rtk.app.R.id.edit_other_personal_ensure /* 2131297469 */:
                this.s = this.editOtherPersonalInformationName.getText().toString().trim();
                this.u = this.editOtherPersonalInformationQQ.getText().toString().trim();
                this.v = this.editOtherPersonalInformationEmail.getText().toString().trim();
                String trim = this.editOtherPersonalInformationIntro.getText().toString().trim();
                this.x = trim;
                if (c0.q(this.s, this.u, this.v, trim)) {
                    com.rtk.app.tool.f.a(this.f147c, "请填写所有属性", f.a.f);
                    return;
                } else if (!c0.q(this.s) && this.s.length() >= 2 && this.s.length() <= 10) {
                    Q(2);
                    return;
                } else {
                    com.rtk.app.tool.f.a(this.f147c, "昵称长度在2-10个字符", f.a.f);
                    return;
                }
            case com.rtk.app.R.id.edit_other_personal_information_birthday_layout /* 2131297473 */:
                R();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.rtk.app.R.layout.activity_edit_other_person);
        ButterKnife.a(this);
    }
}
