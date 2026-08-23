package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForEditEnSure extends o {

    @BindView
    TextView dialogForEditEnsureBtuCancel;

    @BindView
    TextView dialogForEditEnsureBtuEnsure;

    @BindView
    EditText dialogForEditEnsureTips;
    private com.rtk.app.tool.s k;

    public DialogForEditEnSure(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_for_edit_ensure_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        if (!com.rtk.app.tool.c0.q(str)) {
            this.dialogForEditEnsureTips.setText(str);
        }
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_edit_ensure_btuCancel /* 2131297194 */:
                dismiss();
                return;
            case R.id.dialog_for_edit_ensure_btuEnsure /* 2131297195 */:
                this.k.a(this.dialogForEditEnsureTips.getText().toString().trim());
                dismiss();
                return;
            default:
                return;
        }
    }

    public void p() {
        this.dialogForEditEnsureBtuEnsure.setOnClickListener(this);
        this.dialogForEditEnsureBtuCancel.setOnClickListener(this);
    }
}
