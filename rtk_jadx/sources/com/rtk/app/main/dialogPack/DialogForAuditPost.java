package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.bean.UpSuguestBean;
import com.rtk.app.custom.CustomTextView;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.HashMap;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAuditPost extends o implements h.j {

    @BindView
    TextView dialogForAuditPostLayoutCancel;

    @BindView
    TextView dialogForAuditPostLayoutEnsure;

    @BindView
    RadioButton dialogForAuditPostLayoutRadio1;

    @BindView
    RadioButton dialogForAuditPostLayoutRadio2;

    @BindView
    RadioButton dialogForAuditPostLayoutRadio3;

    @BindView
    RadioButton dialogForAuditPostLayoutRadio4;

    @BindView
    RadioGroup dialogForAuditPostLayoutRadioGroup;

    @BindView
    EditText dialogForAuditPostLayoutReason;

    @BindView
    CustomTextView dialogForAuditPostLayoutSuggestion;
    private Context k;
    private String l;
    private String m;
    private int n;
    private int o;
    private UpSuguestBean p;
    private com.rtk.app.tool.s q;
    private String r;
    private boolean s;
    private int t;

    public DialogForAuditPost(Context context, int i, String str, String str2, int i2, UpSuguestBean upSuguestBean, com.rtk.app.tool.s sVar) {
        super(context);
        this.s = false;
        this.k = context;
        this.l = str;
        this.m = str2;
        this.t = i2;
        this.o = i;
        this.p = upSuguestBean;
        this.q = sVar;
        i(R.layout.dialog_for_audit_post_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        r();
        q();
    }

    private void r() {
        int i = this.o;
        if (i == 1) {
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio1);
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio4);
        } else if (i == 2) {
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio1);
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio2);
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio4);
        } else if (i == 3) {
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio1);
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio2);
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio3);
        } else if (i == 4) {
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio1);
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio2);
            this.dialogForAuditPostLayoutRadioGroup.removeView(this.dialogForAuditPostLayoutRadio4);
        }
        UpSuguestBean upSuguestBean = this.p;
        if (upSuguestBean != null && upSuguestBean.getData() != null) {
            this.dialogForAuditPostLayoutSuggestion.setVisibility(0);
            if (this.p.getData().getIsSuguest().equals("0")) {
                this.dialogForAuditPostLayoutSuggestion.setRightText("(" + this.p.getData().getDesc() + ")");
                this.dialogForAuditPostLayoutSuggestion.setText("不通过");
                this.dialogForAuditPostLayoutSuggestion.setTextColor(this.k.getResources().getColor(R.color.theme26));
                int i2 = this.o;
                if (i2 == 1) {
                    this.dialogForAuditPostLayoutRadio2.setChecked(true);
                    this.dialogForAuditPostLayoutRadio4.setChecked(true);
                    this.dialogForAuditPostLayoutReason.setVisibility(0);
                    this.dialogForAuditPostLayoutReason.setText(this.p.getData().getDesc());
                    this.n = 2;
                    this.r = this.p.getData().getDesc();
                    return;
                }
                if (i2 != 3) {
                    return;
                }
                this.dialogForAuditPostLayoutRadio2.setChecked(true);
                this.dialogForAuditPostLayoutRadio4.setChecked(true);
                this.dialogForAuditPostLayoutReason.setVisibility(0);
                this.dialogForAuditPostLayoutReason.setText(this.p.getData().getDesc());
                this.n = 4;
                this.r = this.p.getData().getDesc();
                return;
            }
            this.dialogForAuditPostLayoutSuggestion.setRightText("(" + this.p.getData().getDesc() + ")");
            this.dialogForAuditPostLayoutSuggestion.setText("通过");
            this.dialogForAuditPostLayoutSuggestion.setTextColor(this.k.getResources().getColor(R.color.theme3));
            this.dialogForAuditPostLayoutRadio3.setChecked(true);
            this.dialogForAuditPostLayoutReason.setText("");
            this.n = 3;
            this.r = "";
            return;
        }
        this.dialogForAuditPostLayoutSuggestion.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(String[] strArr) {
        this.dialogForAuditPostLayoutReason.setText(strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(String[] strArr) {
        this.dialogForAuditPostLayoutReason.setText(strArr[0]);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i == 1) {
            this.q.a(new String[0]);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFamily", this.s);
            bundle.putInt("state", this.n);
            bundle.putString("pid", this.m);
            intent.putExtras(bundle);
            ((Activity) this.k).setResult(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, intent);
            com.rtk.app.tool.f.a(this.k, "状态修改成功", f.a.f);
            dismiss();
        }
        com.rtk.app.tool.c0.u("DialogForAuditPost", "审核成功内容" + str);
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        if (i2 == 1) {
            com.rtk.app.tool.f.a(this.k, "审核失败", f.a.f);
        }
        com.rtk.app.tool.c0.u("DialogForAuditPost", "审核失败内容" + str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_audit_post_layout_cancel /* 2131297158 */:
                dismiss();
                return;
            case R.id.dialog_for_audit_post_layout_ensure /* 2131297159 */:
                String trim = this.dialogForAuditPostLayoutReason.getText().toString().trim();
                this.r = trim;
                if (trim.length() > 24) {
                    com.rtk.app.tool.f.a(this.k, "字数需要小于12字", f.a.f);
                    return;
                } else {
                    p(1);
                    return;
                }
            case R.id.dialog_for_audit_post_layout_radio1 /* 2131297160 */:
                this.n = 1;
                this.dialogForAuditPostLayoutReason.setVisibility(8);
                return;
            case R.id.dialog_for_audit_post_layout_radio2 /* 2131297161 */:
                this.n = 2;
                this.dialogForAuditPostLayoutReason.setVisibility(0);
                new DialogForBBsCheckReason(this.k, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.dialogPack.d
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        DialogForAuditPost.this.t(strArr);
                    }
                }).show();
                return;
            case R.id.dialog_for_audit_post_layout_radio3 /* 2131297162 */:
                this.n = 3;
                this.dialogForAuditPostLayoutReason.setVisibility(8);
                return;
            case R.id.dialog_for_audit_post_layout_radio4 /* 2131297163 */:
                this.n = 4;
                this.dialogForAuditPostLayoutReason.setVisibility(0);
                new DialogForBBsCheckReason(this.k, new com.rtk.app.tool.s() { // from class: com.rtk.app.main.dialogPack.e
                    @Override // com.rtk.app.tool.s
                    public final void a(String[] strArr) {
                        DialogForAuditPost.this.v(strArr);
                    }
                }).show();
                return;
            default:
                return;
        }
    }

    public void p(int i) {
        this.r = this.dialogForAuditPostLayoutReason.getText().toString().trim();
        if (i != 1) {
            return;
        }
        if (this.s) {
            HashMap<String, String> l = com.rtk.app.tool.y.l();
            l.put("pid", this.m);
            l.put("family_id", this.t + "");
            l.put("state3", this.n + "");
            l.put("key", com.rtk.app.tool.t.L(l));
            l.put("msg3", this.r);
            com.rtk.app.tool.o.h.j(this.k, this, com.rtk.app.tool.y.e + "family/bbs/check/operate", i, l);
            return;
        }
        HashMap<String, String> l2 = com.rtk.app.tool.y.l();
        l2.put("pid", this.m);
        l2.put("mid", this.l + "");
        l2.put("state", this.n + "");
        l2.put("key", com.rtk.app.tool.t.L(l2));
        l2.put("msg", this.r);
        com.rtk.app.tool.o.h.l(this.k, this, i, com.rtk.app.tool.o.h.h(com.rtk.app.tool.y.e).a(com.rtk.app.tool.y.w("bbs/examine/post", l2)));
    }

    public void q() {
        this.dialogForAuditPostLayoutCancel.setOnClickListener(this);
        this.dialogForAuditPostLayoutEnsure.setOnClickListener(this);
        this.dialogForAuditPostLayoutRadio1.setOnClickListener(this);
        this.dialogForAuditPostLayoutRadio2.setOnClickListener(this);
        this.dialogForAuditPostLayoutRadio3.setOnClickListener(this);
        this.dialogForAuditPostLayoutRadio4.setOnClickListener(this);
    }

    public void w(boolean z) {
        this.s = z;
    }
}
