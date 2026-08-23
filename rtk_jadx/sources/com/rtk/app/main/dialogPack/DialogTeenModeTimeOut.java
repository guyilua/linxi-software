package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogTeenModeTimeOut extends o {

    @BindView
    TextView OKTv;
    private Context k;
    private com.rtk.app.tool.s l;

    @BindView
    EditText passwordEv;

    @BindView
    TextView tipTv;

    @BindView
    TextView titleTv;

    public DialogTeenModeTimeOut(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = context;
        this.l = sVar;
        i(R.layout.dialog_teen_mode_time_out, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        setCancelable(false);
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297367) {
            return;
        }
        String obj = this.passwordEv.getText().toString();
        if (com.rtk.app.tool.c0.q(obj)) {
            com.rtk.app.tool.f.a(this.k, "请输入密码", 5000);
        } else if (obj.equals(com.rtk.app.tool.v.d(this.k, "TEEN_MODE_PASSWORD"))) {
            dismiss();
            this.l.a(obj);
        } else {
            com.rtk.app.tool.f.a(this.k, "密码输入错误", 5000);
        }
    }

    public void p() {
        this.OKTv.setOnClickListener(this);
    }

    public void q(String str) {
        this.tipTv.setText(str);
    }

    public void r(String str) {
        this.titleTv.setText(str);
    }
}
