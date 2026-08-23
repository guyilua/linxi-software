package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogDisagreeFirstPermission extends o {

    @BindView
    TextView dialogDisagreeFirstExit;

    @BindView
    TextView dialogDisagreeFirstShowAgain;
    private com.rtk.app.tool.s k;

    public DialogDisagreeFirstPermission(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        i(R.layout.dialog_disagree_first_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.k = sVar;
        p();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_disagree_first_exit /* 2131297125 */:
                this.k.a("NO");
                dismiss();
                return;
            case R.id.dialog_disagree_first_show_again /* 2131297126 */:
                this.k.a("YES");
                dismiss();
                return;
            default:
                return;
        }
    }

    public void p() {
        this.dialogDisagreeFirstShowAgain.setOnClickListener(this);
        this.dialogDisagreeFirstExit.setOnClickListener(this);
    }
}
