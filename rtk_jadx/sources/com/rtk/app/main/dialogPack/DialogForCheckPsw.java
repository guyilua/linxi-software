package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.rtk.app.tool.o.h;
import com.sigmob.sdk.downloader.f;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForCheckPsw extends o implements h.j {

    @BindView
    ImageView dialogForCheckPswLayoutEye;

    @BindView
    EditText dialogForCheckPswLayoutPsw;

    @BindView
    TextView dialogForCheckPswLayoutSubmit;
    private Context k;
    private String l;
    private a m;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public DialogForCheckPsw(Context context, a aVar) {
        super(context);
        this.k = context;
        this.m = aVar;
        i(R.layout.dialog_for_check_psw_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        q();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void d(String str, int i) {
        if (i != 1) {
            return;
        }
        a aVar = this.m;
        if (aVar != null) {
            aVar.b();
        }
        dismiss();
    }

    @Override // com.rtk.app.tool.o.h.j
    public void g(int i, String str, int i2) {
        a aVar = this.m;
        if (aVar != null) {
            aVar.a();
        }
        com.rtk.app.tool.c0.u("DialogForCheckPsw", " 测试 " + str + "  " + i2);
        if (i2 != 1) {
            return;
        }
        com.rtk.app.tool.f.a(MyApplication.b(), str, f.a.f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297172) {
            this.dialogForCheckPswLayoutPsw.setInputType(!this.dialogForCheckPswLayoutEye.isSelected() ? TbsListener.ErrorCode.NEEDDOWNLOAD_5 : 129);
            this.dialogForCheckPswLayoutEye.setSelected(!r3.isSelected());
            try {
                EditText editText = this.dialogForCheckPswLayoutPsw;
                editText.setSelection(editText.getText().length());
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (id != 2131297174) {
            return;
        }
        String trim = this.dialogForCheckPswLayoutPsw.getText().toString().trim();
        this.l = trim;
        if (!com.rtk.app.tool.c0.q(trim)) {
            com.rtk.app.tool.t.s(this.dialogForCheckPswLayoutPsw, this.k);
            p();
        } else {
            com.rtk.app.tool.f.a(this.k, "请输入密码", f.a.f);
        }
    }

    public void p() {
        StringBuilder sb = new StringBuilder();
        sb.append("members/checkPassWord");
        sb.append(com.rtk.app.tool.y.u(this.k));
        sb.append("&uid=");
        sb.append(com.rtk.app.tool.y.I(this.k));
        sb.append("&token=");
        sb.append(com.rtk.app.tool.y.H());
        sb.append("&pwd=");
        sb.append(com.rtk.app.tool.n.b(this.l));
        sb.append("&key=");
        sb.append(com.rtk.app.tool.t.c0(com.rtk.app.tool.c0.e(com.rtk.app.tool.y.v(this.k, "uid=" + com.rtk.app.tool.y.K(), "token=" + com.rtk.app.tool.y.H(), "pwd=" + com.rtk.app.tool.n.b(this.l)))));
        com.rtk.app.tool.o.h.l(this.k, this, 1, com.rtk.app.tool.o.h.h(new String[0]).a(sb.toString()));
    }

    public void q() {
        this.dialogForCheckPswLayoutSubmit.setOnClickListener(this);
        this.dialogForCheckPswLayoutEye.setOnClickListener(this);
    }
}
