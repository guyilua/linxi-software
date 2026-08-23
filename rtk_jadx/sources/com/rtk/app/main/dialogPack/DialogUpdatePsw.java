package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.custom.NoOOMEditText;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogUpdatePsw extends o implements h.j {

    @BindView
    NoOOMEditText dialogUpdatePswLastPsw;

    @BindView
    ImageView dialogUpdatePswLayoutEye;

    @BindView
    NoOOMEditText dialogUpdatePswNewPsw;

    @BindView
    NoOOMEditText dialogUpdatePswPswAgain;

    @BindView
    Button dialogUpdatePswSubmit;
    private Context k;
    private String l;
    private String m;
    private DialogForProgressTip n;

    public DialogUpdatePsw(Context context) {
        super(context);
        this.k = context;
        i(R.layout.dialog_update_psw_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
    }

    private void p() {
        int I = com.rtk.app.tool.y.I(this.k);
        Context context = this.k;
        com.rtk.app.tool.o.i h = com.rtk.app.tool.o.h.h(new String[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("member/updatePsw");
        sb.append(com.rtk.app.tool.y.u(this.k));
        sb.append("&uid=");
        sb.append(I);
        sb.append("&psw=");
        sb.append(this.m);
        sb.append("&cf_psw=");
        sb.append(this.m);
        sb.append("&old_psw=");
        sb.append(this.l);
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.G(this.k));
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "psw=" + this.m, "cf_psw=" + this.m, "old_psw=" + this.l, "uid=" + I))));
        com.rtk.app.tool.o.h.l(context, this, 1, h.a(sb.toString()));
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        com.rtk.app.tool.c0.u("DialogUpdatePsw", "修改密码" + str);
        com.rtk.app.tool.f.a(this.k, "修改成功", f.a.f);
        dismiss();
        this.n.dismiss();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        com.rtk.app.tool.f.a(this.k, str, f.a.f);
        this.n.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131297384) {
            if (id != 2131297387) {
                return;
            }
            this.l = this.dialogUpdatePswLastPsw.getText().toString().trim();
            this.m = this.dialogUpdatePswNewPsw.getText().toString().trim();
            p();
            this.n.show();
            return;
        }
        int i = !this.dialogUpdatePswLayoutEye.isSelected() ? TbsListener.ErrorCode.NEEDDOWNLOAD_5 : 129;
        this.dialogUpdatePswLastPsw.setInputType(i);
        this.dialogUpdatePswNewPsw.setInputType(i);
        this.dialogUpdatePswPswAgain.setInputType(i);
        this.dialogUpdatePswLayoutEye.setSelected(!r3.isSelected());
        try {
            AppCompatEditText appCompatEditText = this.dialogUpdatePswLastPsw;
            appCompatEditText.setSelection(appCompatEditText.getText().length());
            AppCompatEditText appCompatEditText2 = this.dialogUpdatePswNewPsw;
            appCompatEditText2.setSelection(appCompatEditText2.getText().length());
            AppCompatEditText appCompatEditText3 = this.dialogUpdatePswPswAgain;
            appCompatEditText3.setSelection(appCompatEditText3.getText().length());
        } catch (Exception e) {
            com.rtk.app.tool.c0.u("DialogUpdatePsw", "密码眼睛异常" + e.toString());
        }
    }

    public void q() {
        this.dialogUpdatePswSubmit.setOnClickListener(this);
        this.dialogUpdatePswLayoutEye.setOnClickListener(this);
        this.n = new DialogForProgressTip(this.k, "修改中请稍后...");
    }
}
