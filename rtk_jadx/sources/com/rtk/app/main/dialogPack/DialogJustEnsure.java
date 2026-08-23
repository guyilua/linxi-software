package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogJustEnsure extends o {

    @BindView
    TextView dialogJustEnsureBtuEnsure;

    @BindView
    TextView dialogJustEnsureTips;
    private String k;
    private com.rtk.app.tool.s l;

    public DialogJustEnsure(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = str;
        this.l = sVar;
        i(R.layout.dialog_just_ensure_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
        q();
        setCanceledOnTouchOutside(false);
    }

    private void p() {
        this.dialogJustEnsureTips.setText(this.k);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297291) {
            return;
        }
        dismiss();
        com.rtk.app.tool.s sVar = this.l;
        if (sVar != null) {
            sVar.a(new String[0]);
        }
    }

    public void q() {
        this.dialogJustEnsureBtuEnsure.setOnClickListener(this);
    }
}
