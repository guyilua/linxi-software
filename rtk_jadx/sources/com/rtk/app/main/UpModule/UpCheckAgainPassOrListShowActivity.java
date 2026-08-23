package com.rtk.app.main.UpModule;

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
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.custom.RecyclerImageView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckAgainPassOrListShowActivity extends BaseActivity implements h.j {
    private int B;
    private int q;
    private UpApkDetailsBean r;
    private com.rtk.app.main.dialogPack.v s;
    private com.rtk.app.main.dialogPack.w t;
    private int u;

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
    RadioButton upCheckAgainListShowRadio0;

    @BindView
    RadioButton upCheckAgainListShowRadio1;

    @BindView
    RadioGroup upCheckAgainListShowRadioGroup;

    @BindView
    EditText upCheckAgainListShowReason;

    @BindView
    CustomTextView upCheckAgainListShowStatus;

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
    private String v;
    private String w;
    private DialogForProgressTip x;
    private String y;
    private String z;
    private int A = 1;
    Intent C = new Intent();
    Bundle D = new Bundle();

    private void M() {
        this.upCheckAgainListShowAppName.setText(this.r.getData().getVarName());
        com.rtk.app.tool.t.c(this.f147c, this.r.getData().getSourceLogo(), this.upCheckAgainListShowAppIcon, new boolean[0]);
        X(this.r.getData());
        this.upCheckAgainListShowAppVersion.setText("V" + this.r.getData().getVersionName());
        this.upCheckAgainListShowAppSizeAndPlayerNum.setText(com.rtk.app.tool.c0.q(this.r.getData().getDataPath()) ? this.r.getData().getSourceSize() : this.r.getData().getDataSize() + "(数据包)");
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
                com.rtk.app.tool.t.c(this.f147c, this.r.getData().getRewardList().get(i).getFace(), imageView, new boolean[0]);
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
            case R.id.up_check_again_pass_show_radio0 /* 2131300745 */:
                this.q = 1;
                break;
            case R.id.up_check_again_pass_show_radio1 /* 2131300746 */:
                this.q = 2;
                this.upCheckAgainPassShowReason.setVisibility(0);
                this.upCheckAgainPassShowReasonTipTv.setVisibility(0);
                this.s.show();
                break;
            case R.id.up_check_again_pass_show_radio2 /* 2131300747 */:
                this.q = 3;
                break;
            case R.id.up_check_again_pass_show_radio3 /* 2131300748 */:
                this.q = 4;
                this.upCheckAgainPassShowReason.setVisibility(0);
                this.upCheckAgainPassShowReasonTipTv.setVisibility(0);
                this.s.show();
                break;
            default:
                this.q = this.u;
                break;
        }
        com.rtk.app.tool.c0.u("UpCheckAgainPassOrListShowActivity", "当前被点击的是" + i + "  当前选择的状态是 " + this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.up_check_again_list_show_radio0 /* 2131300739 */:
                com.rtk.app.tool.c0.u("UpCheckAgainPassOrListShowActivity", "列表展示");
                this.upCheckAgainListShowReason.setVisibility(8);
                this.A = 1;
                return;
            case R.id.up_check_again_list_show_radio1 /* 2131300740 */:
                com.rtk.app.tool.c0.u("UpCheckAgainPassOrListShowActivity", "列表不展示");
                this.upCheckAgainListShowReason.setVisibility(0);
                this.A = 0;
                this.t.show();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(String[] strArr) {
        if (strArr.length > 0) {
            this.upCheckAgainPassShowReason.setText(strArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        if (strArr.length > 0) {
            this.upCheckAgainListShowReason.setText(strArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(UpApkDetailsBean.DataBean dataBean, View view) {
        com.rtk.app.tool.t.C0(this.f147c, dataBean.getSourcePic(), ((Integer) view.getTag()).intValue());
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upCheckAgainTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        HashMap hashMap = new HashMap();
        AppCompatActivity appCompatActivity = this.f147c;
        hashMap.put("channel", com.rtk.app.tool.y.m(appCompatActivity, appCompatActivity.getPackageName()));
        hashMap.put("version", com.rtk.app.tool.y.i(this.f147c));
        hashMap.put(ak.aj, com.rtk.app.tool.y.g());
        hashMap.put("phone_model", com.rtk.app.tool.y.T());
        hashMap.put("uid", com.rtk.app.tool.y.K() + "");
        hashMap.put("token", com.rtk.app.tool.y.H());
        hashMap.put("upId", this.y);
        hashMap.put("status2", this.q + "");
        hashMap.put("msg2", this.v);
        hashMap.put("isShow2", this.A + "");
        hashMap.put("showmsg2", this.w);
        hashMap.put("key", com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "upId=" + this.y, "status2=" + this.q, "isShow2=" + this.A))));
        AppCompatActivity appCompatActivity2 = this.f147c;
        StringBuilder sb = new StringBuilder();
        sb.append(com.rtk.app.tool.y.e);
        sb.append("up/check/review-operate");
        com.rtk.app.tool.o.h.j(appCompatActivity2, this, sb.toString(), iArr[0], hashMap);
    }

    public void X(final UpApkDetailsBean.DataBean dataBean) {
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
            com.rtk.app.tool.t.c(this.f147c, dataBean.getSourcePic().get(i), recyclerImageView, new boolean[0]);
            recyclerImageView.setTag(Integer.valueOf(i));
            recyclerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.rtk.app.main.UpModule.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpCheckAgainPassOrListShowActivity.this.W(dataBean, view);
                }
            });
            this.upCheckAgainListShowItem1Lv.addView(recyclerImageView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, "修改成功", f.a.f);
        this.upCheckAgainTopSubmit.setEnabled(true);
        this.D.putInt("modifyStatus2", this.q);
        this.D.putInt("isshow2", this.A);
        this.D.putString("msg2", this.v);
        this.D.putString("showMsg2", this.z);
        this.C.putExtras(this.D);
        setResult(1032, this.C);
        this.x.dismiss();
        finish();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("UpCheckAgainPassOrListShowActivity", "请求失败  " + i2 + "   " + str);
        if (i2 != 1) {
            return;
        }
        com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
        this.upCheckAgainTopSubmit.setEnabled(true);
        this.x.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = (UpApkDetailsBean) extras.getSerializable("upApkDetailsBean");
        this.y = extras.getString("sid");
        int i = extras.getInt("startStatus");
        this.u = i;
        this.q = i;
        int isshow2 = this.r.getData().getIsshow2();
        this.B = isshow2;
        this.A = isshow2;
        this.x = new DialogForProgressTip(this.f147c, "提交中，请稍后……");
        com.rtk.app.tool.c0.u("UpCheckAgainPassOrListShowActivity", "originalIsshow   " + this.B);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upCheckAgainPassShowRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.h0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                UpCheckAgainPassOrListShowActivity.this.O(radioGroup, i);
            }
        });
        this.upCheckAgainListShowRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.d0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                UpCheckAgainPassOrListShowActivity.this.Q(radioGroup, i);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.upCheckAgainListShowRadio0.setChecked(this.B == 1);
        this.upCheckAgainListShowRadio1.setChecked(this.B == 0);
        this.upCheckAgainListShowStatus.setText(this.B == 0 ? "当前状态：不展示" : "当前状态：展示");
        if (this.B == 0) {
            this.upCheckAgainListShowReason.setVisibility(0);
            this.upCheckAgainListShowReason.setText(this.r.getData().getShowmsg2());
        } else {
            this.upCheckAgainListShowReason.setText("");
            this.upCheckAgainListShowReason.setVisibility(8);
        }
        int status2 = this.r.getData().getStatus2();
        if (status2 == 1) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：待审核");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio3);
        } else if (status2 == 2) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：审核不通过");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio1);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio3);
        } else if (status2 == 3) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：审核通过");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio1);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio2);
        } else if (status2 == 4) {
            this.upCheckAgainPassShowNowStatus.setText("当前状态：已删除");
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio0);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio1);
            this.upCheckAgainPassShowRadioGroup.removeView(this.upCheckAgainPassShowRadio3);
        }
        new com.rtk.app.main.dialogPack.b0(this.f147c);
        this.s = new com.rtk.app.main.dialogPack.v(this.f147c, R.array.audit_again_check_reason, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.f0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpCheckAgainPassOrListShowActivity.this.S(strArr);
            }
        });
        this.t = new com.rtk.app.main.dialogPack.w(this.f147c, R.array.audit_again_list_show, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.g0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpCheckAgainPassOrListShowActivity.this.U(strArr);
            }
        });
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("UpCheckAgainPassOrListShowActivity", "更新onActivityResult" + i + "   " + i2);
        if (i == 1031 && i2 == -1) {
            try {
                setResult(1031, this.C);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300752) {
            finish();
            return;
        }
        if (id != 2131300754) {
            return;
        }
        LoginBean loginBean = MainActivity.p;
        if (loginBean != null && loginBean.getData().getAdmin() != null && MainActivity.p.getData().getAdmin().getAdmin() != 1 && !com.rtk.app.tool.t.q1(this.f147c, this.r.getData().getPackageName())) {
            com.rtk.app.tool.f.a(this.f147c, "请安装测试后再审核", f.a.f);
            return;
        }
        if (this.B == this.A && this.q == this.u) {
            com.rtk.app.tool.f.a(this.f147c, "状态未修改", f.a.f);
        }
        int i = this.q;
        if (i != 4 && i != 2) {
            this.v = "";
        } else {
            this.v = this.upCheckAgainPassShowReason.getText().toString().trim();
            String msg2 = this.r.getData().getMsg2();
            if (!com.rtk.app.tool.c0.q(msg2) && com.rtk.app.tool.c0.q(this.v)) {
                this.v = msg2;
            }
            if (com.rtk.app.tool.c0.q(this.v)) {
                com.rtk.app.tool.f.a(this.f147c, "请输入删除原因", f.a.f);
                return;
            }
        }
        this.x.show();
        this.w = this.upCheckAgainListShowReason.getText().toString().trim();
        L(1);
        this.upCheckAgainTopSubmit.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_up_check_again_pass_or_list_show);
        ButterKnife.a(this);
    }
}
