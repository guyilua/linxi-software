package com.rtk.app.main.family.upAudit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.custom.RecyclerImageView;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.main.dialogPack.v;
import com.rtk.app.tool.c0;
import com.rtk.app.tool.o.h;
import com.rtk.app.tool.s;
import com.rtk.app.tool.t;
import com.rtk.app.tool.y;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class FamilyUpCheckPassActivity extends BaseActivity implements h.j {
    private int q;
    private UpApkDetailsBean r;
    private v s;
    private int t;
    private String u;

    @BindView
    RoundedImageView upCheckAgainListShowAppIcon;

    @BindView
    TextView upCheckAgainListShowAppName;

    @BindView
    TextView upCheckAgainListShowAppSizeAndPlayerNum;

    @BindView
    TextView upCheckAgainListShowAppVersion;

    @BindView
    TextView upCheckAgainListShowFragment1Characteristic;

    @BindView
    LinearLayout upCheckAgainListShowFragment1CharacteristicLV;

    @BindView
    LinearLayout upCheckAgainListShowHeadLv;

    @BindView
    CustomTextView upCheckAgainListShowItem1Author;

    @BindView
    LinearLayout upCheckAgainListShowItem1GameInformationLayout;

    @BindView
    TextView upCheckAgainListShowItem1GamePermissionDetails;

    @BindView
    LinearLayout upCheckAgainListShowItem1GameRewardLayout;

    @BindView
    LinearLayout upCheckAgainListShowItem1GameRewardLv;

    @BindView
    LinearLayout upCheckAgainListShowItem1GameRewardLv2;

    @BindView
    CustomTextView upCheckAgainListShowItem1GameRewardNum;

    @BindView
    CustomTextView upCheckAgainListShowItem1Language;

    @BindView
    LinearLayout upCheckAgainListShowItem1Lv;

    @BindView
    MyHorizontalScrollView upCheckAgainListShowItem1SV;

    @BindView
    CustomTextView upCheckAgainListShowItem1Time;

    @BindView
    CustomTextView upCheckAgainListShowItem1Type;

    @BindView
    CustomTextView upCheckAgainListShowItem1Version;

    @BindView
    CustomTextView upCheckAgainPassShowNowStatus;

    @BindView
    RadioButton upCheckAgainPassShowRadio0;

    @BindView
    RadioButton upCheckAgainPassShowRadio1;

    @BindView
    RadioButton upCheckAgainPassShowRadio2;

    @BindView
    RadioButton upCheckAgainPassShowRadio3;

    @BindView
    RadioGroup upCheckAgainPassShowRadioGroup;

    @BindView
    EditText upCheckAgainPassShowReason;

    @BindView
    TextView upCheckAgainPassShowReasonTipTv;

    @BindView
    TextView upCheckAgainTopBack;

    @BindView
    LinearLayout upCheckAgainTopLayout;

    @BindView
    TextView upCheckAgainTopSubmit;

    @BindView
    TextView upCheckListShowItem1GameIntro;

    @BindView
    LinearLayout upCheckListShowItem1GameIntroLayout;
    private DialogForProgressTip v;
    private String w;
    private String x;
    Intent y = new Intent();
    Bundle z = new Bundle();

    private void M() {
        this.upCheckAgainListShowAppName.setText(this.r.getData().getVarName());
        t.c(this.f147c, this.r.getData().getSourceLogo(), this.upCheckAgainListShowAppIcon, new boolean[0]);
        T(this.r.getData());
        this.upCheckAgainListShowAppVersion.setText("V" + this.r.getData().getVersionName());
        this.upCheckAgainListShowAppSizeAndPlayerNum.setText(c0.q(this.r.getData().getDataPath()) ? this.r.getData().getSourceSize() : this.r.getData().getDataSize() + "(数据包)");
        this.upCheckListShowItem1GameIntro.setText(this.r.getData().getSourceDescription());
        this.upCheckAgainListShowItem1Type.setText(this.r.getData().getTypeName());
        this.upCheckAgainListShowItem1Language.setText(this.r.getData().getLang());
        this.upCheckAgainListShowItem1Time.setText(this.r.getData().getAddtime());
        this.upCheckAgainListShowItem1Author.setText(this.r.getData().getNickname());
        this.upCheckAgainListShowItem1Author.getPaint().setFlags(8);
        this.upCheckAgainListShowItem1Version.setText("V" + this.r.getData().getVersionName());
        this.upCheckAgainListShowAppVersion.setText(this.r.getData().getVersionName());
        this.upCheckListShowItem1GameIntro.setText(this.r.getData().getSourceDescription());
        this.upCheckAgainListShowFragment1Characteristic.setText(this.r.getData().getSourceCharacteristic());
        this.upCheckAgainListShowItem1GameRewardLayout.setVisibility(8);
        this.upCheckAgainListShowItem1GameRewardLv2.setVisibility(8);
        if (this.r.getData().getRewardList() != null) {
            this.upCheckAgainListShowItem1GameRewardLv.removeAllViews();
            this.upCheckAgainListShowItem1GameRewardLv2.setVisibility(this.r.getData().getRewardList().size() > 0 ? 0 : 8);
            this.upCheckAgainListShowItem1GameRewardLayout.setVisibility(this.r.getData().getRewardList().size() > 0 ? 0 : 8);
            for (int i = 0; i < this.r.getData().getRewardList().size() && i < 6; i++) {
                View inflate = LayoutInflater.from(this.f147c).inflate(R.layout.post_details_reward_item_layout, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.post_details_reward_item_img);
                TextView textView = (TextView) inflate.findViewById(R.id.post_details_reward_item_num);
                t.c(this.f147c, this.r.getData().getRewardList().get(i).getFace(), imageView, new boolean[0]);
                textView.setText(this.r.getData().getRewardList().get(i).getCoin());
                this.upCheckAgainListShowItem1GameRewardLv.addView(inflate);
            }
            this.upCheckAgainListShowItem1GameRewardLv.setVisibility(this.r.getData().getRewardList().size() <= 0 ? 8 : 0);
            this.upCheckAgainListShowItem1GameRewardNum.setLeftText("共有" + this.r.getData().getRewardNum() + "人打赏了");
            this.upCheckAgainListShowItem1GameRewardNum.setRightText("金币");
            this.upCheckAgainListShowItem1GameRewardNum.setText(" " + this.r.getData().getCoinNum() + " ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(RadioGroup radioGroup, int i) {
        this.upCheckAgainPassShowReason.setVisibility(8);
        this.upCheckAgainPassShowReasonTipTv.setVisibility(8);
        switch (i) {
            case R.id.up_family_pass_show_radio0 /* 2131300910 */:
                this.q = 1;
                break;
            case R.id.up_family_pass_show_radio1 /* 2131300911 */:
                this.q = 2;
                this.upCheckAgainPassShowReason.setVisibility(0);
                this.upCheckAgainPassShowReasonTipTv.setVisibility(0);
                this.s.show();
                break;
            case R.id.up_family_pass_show_radio2 /* 2131300912 */:
                this.q = 3;
                break;
            case R.id.up_family_pass_show_radio3 /* 2131300913 */:
                this.q = 4;
                this.upCheckAgainPassShowReason.setVisibility(0);
                this.upCheckAgainPassShowReasonTipTv.setVisibility(0);
                this.s.show();
                break;
            default:
                this.q = this.t;
                break;
        }
        c0.u("FamilyUpCheckPassActivity", "当前被点击的是" + i + "  当前选择的状态是 " + this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(String[] strArr) {
        if (strArr.length > 0) {
            this.upCheckAgainPassShowReason.setText(strArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(UpApkDetailsBean.DataBean dataBean, View view) {
        t.C0(this.f147c, dataBean.getSourcePic(), ((Integer) view.getTag()).intValue());
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        t.S1(this.f147c, this.upCheckAgainTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        HashMap hashMap = new HashMap();
        AppCompatActivity appCompatActivity = this.f147c;
        hashMap.put("channel", y.m(appCompatActivity, appCompatActivity.getPackageName()));
        hashMap.put("version", y.i(this.f147c));
        hashMap.put(ak.aj, y.g());
        hashMap.put("phone_model", y.T());
        StringBuilder sb = new StringBuilder();
        sb.append(y.K());
        String str = "";
        sb.append("");
        hashMap.put("uid", sb.toString());
        hashMap.put("upId", this.w);
        hashMap.put("token", y.H());
        hashMap.put("family_id", this.x);
        hashMap.put("status3", this.q + "");
        hashMap.put("msg3", this.u + "");
        hashMap.put("isShow3", "1");
        hashMap.put("showmsg3", "");
        hashMap.put("key", t.c0(c0.e(y.v(this.f147c, "uid=" + y.K(), "token=" + y.H(), "upId=" + this.w, "status3=" + this.q, "family_id=" + this.x, "isShow3=1"))));
        for (String str2 : hashMap.keySet()) {
            str = str + str2 + ":" + ((String) hashMap.get(str2)) + "   ";
        }
        c0.u("FamilyUpCheckPassActivity", "家族UP审核" + str);
        com.rtk.app.tool.o.h.j(this.f147c, this, y.e + "family/up/check/operate", iArr[0], hashMap);
    }

    public void T(final UpApkDetailsBean.DataBean dataBean) {
        ViewGroup.LayoutParams layoutParams = this.upCheckAgainListShowItem1Lv.getLayoutParams();
        this.upCheckAgainListShowItem1Lv.removeAllViews();
        for (int i = 0; i < dataBean.getSourcePic().size(); i++) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int i2 = layoutParams.height;
            layoutParams2.height = i2;
            layoutParams2.width = (int) (i2 / 1.4d);
            AppCompatImageView recyclerImageView = new RecyclerImageView(this.f147c);
            recyclerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            recyclerImageView.setPadding(0, 0, 10, 0);
            layoutParams2.leftMargin = 5;
            recyclerImageView.setLayoutParams(layoutParams2);
            t.c(this.f147c, dataBean.getSourcePic().get(i), recyclerImageView, new boolean[0]);
            recyclerImageView.setTag(Integer.valueOf(i));
            recyclerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.family.upAudit.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FamilyUpCheckPassActivity.this.S(dataBean, view);
                }
            });
            this.upCheckAgainListShowItem1Lv.addView(recyclerImageView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        c0.u("FamilyUpCheckPassActivity", "族核状态：" + str);
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "修改成功", f.a.f);
        this.upCheckAgainTopSubmit.setEnabled(true);
        this.z.putInt("modifyStatus3", this.q);
        this.z.putString("reason", this.u);
        this.y.putExtras(this.z);
        setResult(1033, this.y);
        this.v.dismiss();
        finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        c0.u("FamilyUpCheckPassActivity", "请求失败  " + i2 + "   " + str);
        if (i2 != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        this.upCheckAgainTopSubmit.setEnabled(true);
        this.v.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = (UpApkDetailsBean) extras.getSerializable("upApkDetailsBean");
        this.x = this.r.getData().getFamily().getFamily_id() + "";
        this.w = extras.getString("sid");
        int i = extras.getInt("startStatus");
        this.t = i;
        this.q = i;
        this.v = new DialogForProgressTip(this.f147c, "提交中，请稍后……");
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upCheckAgainPassShowRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.family.upAudit.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                FamilyUpCheckPassActivity.this.O(radioGroup, i);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        int status3 = this.r.getData().getStatus3();
        if (status3 == 1) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：待审核");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio3);
        } else if (status3 == 2) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：审核不通过");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio1);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio3);
        } else if (status3 == 3) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：审核通过");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio1);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio2);
        } else if (status3 == 4) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：已删除");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio1);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio3);
        }
        this.s = new v(this.f147c, R.array.audit_family_check_reason, new s() { // from class: com.rtk.app.main.family.upAudit.c
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                FamilyUpCheckPassActivity.this.Q(strArr);
            }
        });
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        c0.u("FamilyUpCheckPassActivity", "更新onActivityResult" + i + "   " + i2);
        if (i == 1031 && i2 == -1) {
            try {
                setResult(1031, this.y);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300917) {
            finish();
            return;
        }
        if (id != 2131300919) {
            return;
        }
        int i = this.q;
        if (i != 4 && i != 2) {
            this.u = "";
        } else {
            this.u = this.upCheckAgainPassShowReason.getText().toString().trim();
            String msg2 = this.r.getData().getMsg2();
            if (!c0.q(msg2) && c0.q(this.u)) {
                this.u = msg2;
            }
            if (c0.q(this.u)) {
                com.rtk.app.tool.f.a(this.f147c, "请输入删除原因", f.a.f);
                return;
            }
        }
        this.v.show();
        L(1);
        this.upCheckAgainTopSubmit.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_family_up_check_pass);
        ButterKnife.a(this);
    }
}
