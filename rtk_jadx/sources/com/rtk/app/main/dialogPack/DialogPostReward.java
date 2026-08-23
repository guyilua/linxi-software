package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.rtk.app.R;
import com.rtk.app.bean.Home5ImfromationBean;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogPostReward extends o implements h.j {

    @BindView
    RadioGroup dialogRewardRadioGroup1;

    @BindView
    RadioGroup dialogRewardRadioGroup2;
    private Context k;
    private String l;
    private String m;
    private long n;
    private String o;
    private String p;

    @BindView
    TextView postDialogRewardEnsure;

    @BindView
    TextView postDialogRewardNum;

    @BindView
    EditText postDialogRewardOther;

    @BindView
    RadioButton postDialogRewardRadio1;

    @BindView
    RadioButton postDialogRewardRadio2;

    @BindView
    RadioButton postDialogRewardRadio3;

    @BindView
    RadioButton postDialogRewardRadio4;

    @BindView
    RadioButton postDialogRewardRadio5;

    @BindView
    EditText postDialogRewardReason;

    @BindView
    RoundedImageView postDialogRewardUserIcon;

    @BindView
    TextView postDialogRewardUserName;
    private int[] q;
    private String r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogPostReward.this.dialogRewardRadioGroup2.clearCheck();
            DialogPostReward.this.postDialogRewardOther.setSelected(false);
            int intValue = ((Integer) view.getTag()).intValue();
            DialogPostReward.this.n = r0.q[intValue];
            DialogPostReward.this.postDialogRewardOther.setText("");
            DialogPostReward dialogPostReward = DialogPostReward.this;
            com.rtk.app.tool.t.s(dialogPostReward.postDialogRewardOther, dialogPostReward.k);
            DialogPostReward dialogPostReward2 = DialogPostReward.this;
            com.rtk.app.tool.t.s(dialogPostReward2.postDialogRewardReason, dialogPostReward2.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogPostReward.this.postDialogRewardOther.setSelected(false);
            DialogPostReward.this.dialogRewardRadioGroup1.clearCheck();
            int intValue = ((Integer) view.getTag()).intValue();
            DialogPostReward.this.n = r0.q[intValue];
            DialogPostReward.this.postDialogRewardOther.setText("");
            DialogPostReward dialogPostReward = DialogPostReward.this;
            com.rtk.app.tool.t.s(dialogPostReward.postDialogRewardOther, dialogPostReward.k);
            DialogPostReward dialogPostReward2 = DialogPostReward.this;
            com.rtk.app.tool.t.s(dialogPostReward2.postDialogRewardReason, dialogPostReward2.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogPostReward.this.n = 0L;
            DialogPostReward.this.dialogRewardRadioGroup2.clearCheck();
            DialogPostReward.this.dialogRewardRadioGroup1.clearCheck();
            DialogPostReward.this.postDialogRewardOther.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                DialogPostReward.this.dialogRewardRadioGroup1.clearCheck();
                DialogPostReward.this.dialogRewardRadioGroup2.clearCheck();
            }
            DialogPostReward.this.postDialogRewardOther.setSelected(z);
        }
    }

    public DialogPostReward(Context context, String str, String str2, String str3, String str4) {
        super(context);
        this.q = new int[]{2, 6, 9, 66, 99};
        this.k = context;
        this.l = str;
        this.m = str2;
        this.o = str3;
        this.p = str4;
        i(R.layout.post_dialog_reward, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        s(0);
        t();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        com.rtk.app.tool.c0.u("DialogPostReward", "  打赏  " + str);
        Gson create = new GsonBuilder().enableComplexMapKeySerialization().create();
        if (i == 0) {
            Home5ImfromationBean home5ImfromationBean = (Home5ImfromationBean) create.fromJson(str, Home5ImfromationBean.class);
            com.rtk.app.tool.t.c(this.k, home5ImfromationBean.getData().getFace(), this.postDialogRewardUserIcon, new boolean[0]);
            this.postDialogRewardUserName.setText(home5ImfromationBean.getData().getNickname());
        } else {
            if (i != 1) {
                return;
            }
            this.postDialogRewardEnsure.setEnabled(true);
            com.rtk.app.tool.f.a(this.k, "打赏成功", f.a.f);
            dismiss();
        }
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
        if (i2 != 1) {
            return;
        }
        this.postDialogRewardEnsure.setEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131299854) {
            return;
        }
        this.n = (com.rtk.app.tool.c0.q(this.postDialogRewardOther.getText().toString()) || Integer.parseInt(this.postDialogRewardOther.getText().toString()) <= 0) ? this.n : Integer.parseInt(this.postDialogRewardOther.getText().toString());
        this.r = this.postDialogRewardReason.getText().toString();
        if (this.n <= 0) {
            com.rtk.app.tool.f.a(this.k, "请选择金额", f.a.f);
            return;
        }
        this.postDialogRewardEnsure.setEnabled(false);
        if (this.l.equals(com.rtk.app.tool.y.K())) {
            com.rtk.app.tool.f.a(this.k, "你不可以打赏自己~", f.a.f);
        } else {
            s(1);
        }
        dismiss();
    }

    public void s(int i) {
        String sb;
        if (i == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("members/baseInfo");
            sb2.append(com.rtk.app.tool.y.u(this.k));
            sb2.append("&uid=");
            sb2.append(this.l);
            sb2.append("&fans=");
            sb2.append(com.rtk.app.tool.y.K());
            sb2.append("&key=");
            sb2.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "uid=" + this.l))));
            sb = sb2.toString();
        } else if (i != 1) {
            sb = "";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("members/postsReward");
            sb3.append(com.rtk.app.tool.y.u(this.k));
            sb3.append("&uid=");
            sb3.append(com.rtk.app.tool.y.K());
            sb3.append("&token=");
            sb3.append(com.rtk.app.tool.y.H());
            sb3.append("&toUser=");
            sb3.append(this.l);
            sb3.append("&type=");
            sb3.append(this.m);
            sb3.append("&sid=");
            sb3.append(this.o);
            sb3.append("&pid=");
            sb3.append(this.p);
            sb3.append("&coin=");
            sb3.append(this.n);
            sb3.append("&reason=");
            sb3.append(this.r);
            sb3.append("&key=");
            sb3.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "toUser=" + this.l, "type=" + this.m, "coin=" + this.n, "reason=" + this.r, "sid=" + this.o, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H()))));
            sb = sb3.toString();
        }
        com.rtk.app.tool.c0.u("DialogPostReward", "打赏地址" + com.rtk.app.tool.y.d + sb);
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(new String[0]).a(sb));
    }

    public void t() {
        for (int i = 0; i < this.dialogRewardRadioGroup1.getChildCount(); i++) {
            this.dialogRewardRadioGroup1.getChildAt(i).setTag(Integer.valueOf(i));
            this.dialogRewardRadioGroup1.getChildAt(i).setOnClickListener(new a());
            this.dialogRewardRadioGroup2.getChildAt(i).setTag(Integer.valueOf(i + 3));
            this.dialogRewardRadioGroup2.getChildAt(i).setOnClickListener(new b());
        }
        this.postDialogRewardOther.setOnClickListener(new c());
        this.postDialogRewardEnsure.setOnClickListener(this);
        this.postDialogRewardOther.setOnFocusChangeListener(new d());
    }
}
