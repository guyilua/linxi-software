package com.rtk.app.main.dialogPack;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForCommentOverAudit extends o {

    @BindView
    CheckBox dialogForCommentOverAuditCheck;

    @BindView
    TextView dialogForCommentOverAuditEnsure;
    private Context k;

    public DialogForCommentOverAudit(Context context) {
        super(context);
        this.k = context;
        i(R.layout.dialog_for_comment_over_audit_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297193) {
            return;
        }
        com.rtk.app.tool.v.e(this.k, com.rtk.app.tool.v.h, Boolean.valueOf(this.dialogForCommentOverAuditCheck.isChecked()));
        dismiss();
        ((Activity) this.k).finish();
    }

    public void p() {
        this.dialogForCommentOverAuditEnsure.setOnClickListener(this);
    }
}
