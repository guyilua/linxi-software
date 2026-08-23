package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForToAccountSecurityActivity extends o {

    @BindView
    TextView dialogForToAccountSecurityBtuCancel;

    @BindView
    TextView dialogForToAccountSecurityBtuEnsure;

    @BindView
    TextView dialogForToAccountSecurityTips;
    private String k;
    private com.rtk.app.tool.s l;

    public DialogForToAccountSecurityActivity(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = str;
        this.l = sVar;
        i(R.layout.dialog_for_to_account_security_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
        q();
    }

    private void p() {
        this.dialogForToAccountSecurityTips.setText(this.k);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_to_account_security_btuEnsure /* 2131297255 */:
                dismiss();
                this.l.a(new String[0]);
                return;
            case R.id.dialog_for_to_account_security_btu_cancel /* 2131297256 */:
                dismiss();
                return;
            default:
                return;
        }
    }

    public void q() {
        this.dialogForToAccountSecurityBtuEnsure.setOnClickListener(this);
        this.dialogForToAccountSecurityBtuCancel.setOnClickListener(this);
    }
}
