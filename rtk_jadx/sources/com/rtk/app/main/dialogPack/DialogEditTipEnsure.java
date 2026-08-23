package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogEditTipEnsure extends o {

    @BindView
    TextView dialogEditTipEnsure;

    @BindView
    EditText dialogEditTipEv;

    @BindView
    TextView dialogTipForCallbackCancle;

    @BindView
    TextView dialogTipForCallbackOk;
    private Context k;
    private com.rtk.app.base.h l;
    private int m;
    private String n;

    public DialogEditTipEnsure(Context context, String str, com.rtk.app.base.h hVar) {
        super(context);
        this.m = 0;
        this.k = context;
        this.l = hVar;
        i(R.layout.dialog_edit_tip_ensure, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.dialogEditTipEnsure.setText(str);
        setCanceledOnTouchOutside(false);
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297373) {
            this.l.a(new String[0]);
            dismiss();
            return;
        }
        if (id != 2131297375) {
            return;
        }
        String obj = this.dialogEditTipEv.getText().toString();
        if (this.m <= 0 || obj.length() <= this.m) {
            this.l.b(obj);
            dismiss();
        } else {
            if (com.rtk.app.tool.c0.q(this.n)) {
                return;
            }
            com.rtk.app.tool.f.a(this.k, this.n, 5000);
        }
    }

    public void p() {
        this.dialogTipForCallbackOk.setOnClickListener(this);
        this.dialogTipForCallbackCancle.setOnClickListener(this);
    }

    public void q(String str) {
        this.dialogEditTipEv.setHint(str);
    }

    public void r(String str) {
        this.dialogEditTipEv.setText(str);
    }

    public void s(int i) {
        this.dialogEditTipEv.setInputType(i);
    }

    public void t(int i, String str) {
        this.m = i;
        this.n = str;
    }
}
