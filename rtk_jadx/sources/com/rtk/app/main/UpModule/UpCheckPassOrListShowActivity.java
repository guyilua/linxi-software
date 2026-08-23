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
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.base.BaseActivity;
import com.rtk.app.bean.LoginBean;
import com.rtk.app.bean.UpApkDetailsBean;
import com.rtk.app.bean.UpSuguestBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.custom.MyHorizontalScrollView;
import com.rtk.app.custom.RecyclerImageView;
import com.rtk.app.main.MainActivityPack.MainActivity;
import com.rtk.app.main.dialogPack.DialogForProgressTip;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class UpCheckPassOrListShowActivity extends BaseActivity implements h.j {
    private int B;
    private int q;
    private UpSuguestBean r;
    private UpApkDetailsBean s;
    private com.rtk.app.main.dialogPack.v t;
    private com.rtk.app.main.dialogPack.w u;

    @BindView
    RoundedImageView upCheckListShowAppIcon;

    @BindView
    TextView upCheckListShowAppName;

    @BindView
    TextView upCheckListShowAppSizeAndPlayerNum;

    @BindView
    TextView upCheckListShowAppVersion;

    @BindView
    TextView upCheckListShowEdit;

    @BindView
    TextView upCheckListShowFragment1Characteristic;

    @BindView
    LinearLayout upCheckListShowFragment1CharacteristicLV;

    @BindView
    LinearLayout upCheckListShowHeadLv;

    @BindView
    CustomTextView upCheckListShowItem1Author;

    @BindView
    LinearLayout upCheckListShowItem1GameInformationLayout;

    @BindView
    TextView upCheckListShowItem1GameIntro;

    @BindView
    LinearLayout upCheckListShowItem1GameIntroLayout;

    @BindView
    TextView upCheckListShowItem1GamePermissionDetails;

    @BindView
    LinearLayout upCheckListShowItem1GameRewardLayout;

    @BindView
    LinearLayout upCheckListShowItem1GameRewardLv;

    @BindView
    LinearLayout upCheckListShowItem1GameRewardLv2;

    @BindView
    CustomTextView upCheckListShowItem1GameRewardNum;

    @BindView
    CustomTextView upCheckListShowItem1Language;

    @BindView
    LinearLayout upCheckListShowItem1Lv;

    @BindView
    MyHorizontalScrollView upCheckListShowItem1SV;

    @BindView
    CustomTextView upCheckListShowItem1Time;

    @BindView
    CustomTextView upCheckListShowItem1Type;

    @BindView
    CustomTextView upCheckListShowItem1Version;

    @BindView
    RadioButton upCheckListShowRadio0;

    @BindView
    RadioButton upCheckListShowRadio1;

    @BindView
    RadioGroup upCheckListShowRadioGroup;

    @BindView
    EditText upCheckListShowReason;

    @BindView
    CustomTextView upCheckListShowStatus;

    @BindView
    CustomTextView upCheckPassShowNowStatus;

    @BindView
    RadioButton upCheckPassShowRadio0;

    @BindView
    RadioButton upCheckPassShowRadio1;

    @BindView
    RadioButton upCheckPassShowRadio2;

    @BindView
    RadioButton upCheckPassShowRadio3;

    @BindView
    RadioGroup upCheckPassShowRadioGroup;

    @BindView
    EditText upCheckPassShowReason;

    @BindView
    TextView upCheckPassShowReasonTipTv;

    @BindView
    CustomTextView upCheckPassShowSuggestion;

    @BindView
    TextView upCheckTopBack;

    @BindView
    LinearLayout upCheckTopLayout;

    @BindView
    TextView upCheckTopSubmit;
    private int v;
    private String w;
    private String x;
    private DialogForProgressTip y;
    private String z;
    private int A = 1;
    private int C = 0;
    Intent D = new Intent();
    Bundle E = new Bundle();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ UpApkDetailsBean.DataBean a;

        a(UpApkDetailsBean.DataBean dataBean) {
            this.a = dataBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.rtk.app.tool.t.C0(UpCheckPassOrListShowActivity.this.f147c, this.a.getSourcePic(), ((Integer) view.getTag()).intValue());
        }
    }

    private void M() {
        this.upCheckListShowAppName.setText(this.s.getData().getVarName());
        com.rtk.app.tool.t.c(this.f147c, this.s.getData().getSourceLogo(), this.upCheckListShowAppIcon, new boolean[0]);
        V(this.s.getData());
        this.upCheckListShowAppVersion.setText("V" + this.s.getData().getVersionName());
        this.upCheckListShowAppSizeAndPlayerNum.setText(com.rtk.app.tool.c0.q(this.s.getData().getDataPath()) ? this.s.getData().getSourceSize() : this.s.getData().getDataSize() + "(数据包)");
        this.upCheckListShowItem1GameIntro.setText(this.s.getData().getSourceDescription());
        this.upCheckListShowItem1Type.setText(this.s.getData().getTypeName());
        this.upCheckListShowItem1Language.setText(this.s.getData().getLang());
        this.upCheckListShowItem1Time.setText(this.s.getData().getAddtime());
        this.upCheckListShowItem1Author.setText(this.s.getData().getNickname());
        this.upCheckListShowItem1Author.getPaint().setFlags(8);
        this.upCheckListShowItem1Version.setText("V" + this.s.getData().getVersionName());
        this.upCheckListShowAppVersion.setText(this.s.getData().getVersionName());
        this.upCheckListShowItem1GameIntro.setText(this.s.getData().getSourceDescription());
        this.upCheckListShowFragment1Characteristic.setText(this.s.getData().getSourceCharacteristic());
        this.upCheckListShowItem1GameRewardLayout.setVisibility(8);
        this.upCheckListShowItem1GameRewardLv2.setVisibility(8);
        if (this.s.getData().getRewardList() != null) {
            this.upCheckListShowItem1GameRewardLv.removeAllViews();
            this.upCheckListShowItem1GameRewardLv2.setVisibility(this.s.getData().getRewardList().size() > 0 ? 0 : 8);
            this.upCheckListShowItem1GameRewardLayout.setVisibility(this.s.getData().getRewardList().size() > 0 ? 0 : 8);
            for (int i = 0; i < this.s.getData().getRewardList().size() && i < 6; i++) {
                View inflate = LayoutInflater.from(this.f147c).inflate(R.layout.post_details_reward_item_layout, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.post_details_reward_item_img);
                TextView textView = (TextView) inflate.findViewById(R.id.post_details_reward_item_num);
                com.rtk.app.tool.t.c(this.f147c, this.s.getData().getRewardList().get(i).getFace(), imageView, new boolean[0]);
                textView.setText(this.s.getData().getRewardList().get(i).getCoin());
                this.upCheckListShowItem1GameRewardLv.addView(inflate);
            }
            this.upCheckListShowItem1GameRewardLv.setVisibility(this.s.getData().getRewardList().size() <= 0 ? 8 : 0);
            this.upCheckListShowItem1GameRewardNum.setLeftText("共有" + this.s.getData().getRewardNum() + "人打赏了");
            this.upCheckListShowItem1GameRewardNum.setRightText("金币");
            this.upCheckListShowItem1GameRewardNum.setText(" " + this.s.getData().getCoinNum() + " ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(RadioGroup radioGroup, int i) {
        this.upCheckPassShowReason.setVisibility(8);
        this.upCheckPassShowReasonTipTv.setVisibility(8);
        switch (i) {
            case R.id.up_check_pass_show_radio0 /* 2131300791 */:
                this.q = 1;
                break;
            case R.id.up_check_pass_show_radio1 /* 2131300792 */:
                this.q = 2;
                this.upCheckPassShowReason.setVisibility(0);
                this.upCheckPassShowReasonTipTv.setVisibility(0);
                this.t.show();
                break;
            case R.id.up_check_pass_show_radio2 /* 2131300793 */:
                this.q = 3;
                break;
            case R.id.up_check_pass_show_radio3 /* 2131300794 */:
                this.q = 0;
                this.upCheckPassShowReason.setVisibility(0);
                this.upCheckPassShowReasonTipTv.setVisibility(0);
                this.t.show();
                break;
            default:
                this.q = this.v;
                break;
        }
        com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "当前被点击的是" + i + "  当前选择的状态是 " + this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.up_check_list_show_radio0 /* 2131300785 */:
                com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "列表展示");
                this.upCheckListShowReason.setVisibility(8);
                this.A = 1;
                return;
            case R.id.up_check_list_show_radio1 /* 2131300786 */:
                com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "列表不展示");
                this.upCheckListShowReason.setVisibility(0);
                this.A = 0;
                this.u.show();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(String[] strArr) {
        if (strArr.length > 0) {
            this.upCheckPassShowReason.setText(strArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String[] strArr) {
        if (strArr.length > 0) {
            this.upCheckListShowReason.setText(strArr[0]);
        }
    }

    @Override // com.rtk.app.base.BaseActivity
    protected void A() {
        com.rtk.app.tool.t.S1(this.f147c, this.upCheckTopLayout, null, null, ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0));
    }

    public void L(int... iArr) {
        String sb;
        this.C++;
        int i = iArr[0];
        if (i == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/examineSource");
            sb2.append(com.rtk.app.tool.y.u(this.f147c));
            sb2.append("&uid=");
            sb2.append(com.rtk.app.tool.y.I(this.f147c));
            sb2.append("&token=");
            sb2.append(com.rtk.app.tool.y.G(this.f147c));
            sb2.append("&sid=");
            sb2.append(this.z);
            sb2.append("&status=");
            sb2.append(this.q);
            sb2.append("&msg=");
            sb2.append(this.w);
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "sid=" + this.z, "status=" + this.q))));
            sb = sb2.toString();
        } else if (i != 2) {
            sb = "";
        } else {
            this.x = this.upCheckListShowReason.getText().toString().trim();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/sourceSetShow");
            sb3.append(com.rtk.app.tool.y.u(this.f147c));
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.I(this.f147c));
            sb3.append("&token=");
            sb3.append(com.rtk.app.tool.y.G(this.f147c));
            sb3.append("&sid=");
            sb3.append(this.z);
            sb3.append("&isshow=");
            sb3.append(this.A);
            sb3.append("&showMsg=");
            sb3.append(this.x);
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.f147c, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "sid=" + this.z))));
            sb = sb3.toString();
        }
        com.rtk.app.tool.o.h.l(this.f147c, this, iArr[0], com.rtk.app.tool.o.h.h(new String[0]).a(sb));
        com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "审核页面地址  " + com.rtk.app.tool.y.d + sb);
    }

    public void V(UpApkDetailsBean.DataBean dataBean) {
        ViewGroup.LayoutParams layoutParams = this.upCheckListShowItem1Lv.getLayoutParams();
        this.upCheckListShowItem1Lv.removeAllViews();
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
            recyclerImageView.setOnClickListener(new a(dataBean));
            this.upCheckListShowItem1Lv.addView(recyclerImageView);
        }
    }

    public void W() {
        int i = this.B;
        int i2 = this.A;
        if (i != i2) {
            if (i2 == 0) {
                this.x = this.upCheckListShowReason.getText().toString().trim();
            }
            L(2);
            this.upCheckTopSubmit.setEnabled(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        this.C--;
        if (i == 1) {
            com.rtk.app.tool.f.a(this.f147c, "修改成功", f.a.f);
            this.upCheckTopSubmit.setEnabled(true);
            this.E.putString("modifyStatus", "" + this.q);
            this.E.putString("msg", this.w);
            this.D.putExtras(this.E);
            setResult(1008, this.D);
            this.y.dismiss();
            W();
        } else if (i == 2) {
            com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "修改展示状态" + str);
            this.E.putString("isshow", "" + this.A);
            this.E.putString("showMsg", this.x);
            this.D.putExtras(this.E);
            setResult(1008, this.D);
            this.y.dismiss();
            this.upCheckTopSubmit.setEnabled(true);
            this.upCheckListShowStatus.setText(this.A == 0 ? "当前状态：不展示" : "当前状态：展示");
        }
        if (this.C == 0) {
            finish();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "请求失败  " + i2 + "   " + str);
        this.C = this.C - 1;
        if (i2 == 1) {
            com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
            this.upCheckTopSubmit.setEnabled(true);
            W();
        } else {
            if (i2 != 2) {
                return;
            }
            com.rtk.app.tool.f.a(this.f147c, str, f.a.f);
            this.upCheckTopSubmit.setEnabled(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.f
    public void initData() {
        Bundle extras = getIntent().getExtras();
        this.r = (UpSuguestBean) extras.getSerializable("suguestBean");
        this.s = (UpApkDetailsBean) extras.getSerializable("upApkDetailsBean");
        this.z = extras.getString("sid");
        int parseInt = Integer.parseInt(extras.getString("startStatus"));
        this.v = parseInt;
        this.q = parseInt;
        int parseInt2 = Integer.parseInt(this.s.getData().getIsshow());
        this.B = parseInt2;
        this.A = parseInt2;
        this.y = new DialogForProgressTip(this.f147c, "提交中，请稍后……");
        com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "originalIsshow   " + this.B);
    }

    @Override // com.rtk.app.base.f
    public void initListener() {
        this.upCheckPassShowRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.o0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                UpCheckPassOrListShowActivity.this.O(radioGroup, i);
            }
        });
        this.upCheckListShowRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.rtk.app.main.UpModule.m0
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                UpCheckPassOrListShowActivity.this.Q(radioGroup, i);
            }
        });
    }

    @Override // com.rtk.app.base.f
    public void initView() {
        this.upCheckListShowRadio0.setChecked(this.B == 1);
        this.upCheckListShowRadio1.setChecked(this.B == 0);
        this.upCheckListShowStatus.setText(this.B == 0 ? "当前状态：不展示" : "当前状态：展示");
        if (this.B == 0) {
            this.upCheckListShowReason.setVisibility(0);
            this.upCheckListShowReason.setText(this.s.getData().getShowmsg());
        } else {
            this.upCheckListShowReason.setText("");
            this.upCheckListShowReason.setVisibility(8);
        }
        UpSuguestBean upSuguestBean = this.r;
        if (upSuguestBean != null && upSuguestBean.getData() != null) {
            com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "审核建议" + this.r.getData().getIsSuguest() + "      " + this.q);
            this.upCheckPassShowSuggestion.setVisibility(0);
            this.upCheckPassShowSuggestion.setRightText("(" + this.r.getData().getDesc() + ")");
            String isSuguest = this.r.getData().getIsSuguest();
            isSuguest.hashCode();
            char c2 = 65535;
            switch (isSuguest.hashCode()) {
                case 48:
                    if (isSuguest.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 49:
                    if (isSuguest.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 50:
                    if (isSuguest.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.upCheckPassShowSuggestion.setText("不通过");
                    this.upCheckPassShowSuggestion.setTextColor(this.f147c.getResources().getColor(R.color.theme26));
                    int i = this.q;
                    if (i != 1) {
                        if (i == 3) {
                            this.upCheckPassShowRadio3.setChecked(true);
                            this.upCheckPassShowReason.setText(this.r.getData().getDesc());
                            this.upCheckPassShowReason.setVisibility(0);
                            this.q = 0;
                            break;
                        }
                    } else {
                        this.upCheckPassShowRadio1.setChecked(true);
                        this.upCheckPassShowReason.setText(this.r.getData().getDesc());
                        this.upCheckPassShowReason.setVisibility(0);
                        this.q = 2;
                        break;
                    }
                    break;
                case 1:
                    this.upCheckPassShowRadio2.setChecked(true);
                    this.upCheckPassShowSuggestion.setText("通过");
                    this.q = 3;
                    this.upCheckPassShowSuggestion.setTextColor(this.f147c.getResources().getColor(R.color.theme3));
                    break;
                case 2:
                    this.upCheckPassShowSuggestion.setText("不列表展示");
                    this.upCheckPassShowSuggestion.setTextColor(this.f147c.getResources().getColor(R.color.theme26));
                    this.q = 3;
                    this.A = 0;
                    this.upCheckPassShowRadio2.setChecked(true);
                    this.upCheckListShowRadio0.setChecked(false);
                    this.upCheckListShowRadio1.setChecked(true);
                    this.upCheckListShowReason.setVisibility(0);
                    this.upCheckListShowReason.setText(this.r.getData().getDesc());
                    break;
            }
        }
        int parseInt = Integer.parseInt(this.s.getData().getStatus());
        if (parseInt == 0) {
            this.upCheckPassShowNowStatus.setText("当前状态：已删除");
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio0);
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio1);
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio3);
        } else if (parseInt == 1) {
            this.upCheckPassShowNowStatus.setText("当前状态：待审核");
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio0);
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio3);
        } else if (parseInt == 2) {
            this.upCheckPassShowNowStatus.setText("当前状态：审核不通过");
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio0);
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio1);
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio3);
        } else if (parseInt == 3) {
            this.upCheckPassShowNowStatus.setText("当前状态：审核通过");
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio0);
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio1);
            this.upCheckPassShowRadioGroup.removeView(this.upCheckPassShowRadio2);
        }
        new com.rtk.app.main.dialogPack.b0(this.f147c);
        this.t = new com.rtk.app.main.dialogPack.v(this.f147c, R.array.audit_check_reason, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.l0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpCheckPassOrListShowActivity.this.S(strArr);
            }
        });
        this.u = new com.rtk.app.main.dialogPack.w(this.f147c, R.array.audit_show_reason, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.UpModule.n0
            @Override // com.rtk.app.tool.s
            public final void a(String[] strArr) {
                UpCheckPassOrListShowActivity.this.U(strArr);
            }
        });
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.rtk.app.tool.c0.u("UpCheckPassOrListShowActivity", "更新onActivityResult" + i + "   " + i2);
        if (i == 1011 && i2 == -1) {
            try {
                setResult(1011, this.D);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131300766) {
            com.rtk.app.tool.t.V0(this.f147c, this.z, 1008);
            return;
        }
        if (id == 2131300799) {
            finish();
            return;
        }
        if (id != 2131300801) {
            return;
        }
        LoginBean loginBean = MainActivity.p;
        if (loginBean != null && loginBean.getData().getAdmin() != null && MainActivity.p.getData().getAdmin().getAdmin() != 1 && !com.rtk.app.tool.t.q1(this.f147c, this.s.getData().getPackageName())) {
            com.rtk.app.tool.f.a(this.f147c, "请安装测试后再审核", f.a.f);
            return;
        }
        if (this.B == this.A && this.q == this.v) {
            com.rtk.app.tool.f.a(this.f147c, "状态未修改", f.a.f);
        }
        int i = this.q;
        if (i != this.v) {
            if (i != 0 && i != 2) {
                this.w = "";
            } else {
                String trim = this.upCheckPassShowReason.getText().toString().trim();
                this.w = trim;
                if (com.rtk.app.tool.c0.q(trim)) {
                    com.rtk.app.tool.f.a(this.f147c, "请输入删除原因", f.a.f);
                    return;
                }
            }
            this.y.show();
            L(1);
            this.upCheckTopSubmit.setEnabled(false);
            return;
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.rtk.app.base.BaseActivity, com.rtk.app.custom.SwipeBackActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_up_check_pass_or_list_show);
        ButterKnife.a(this);
    }
}
