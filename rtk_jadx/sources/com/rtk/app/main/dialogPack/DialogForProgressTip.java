package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForProgressTip extends o {

    @BindView
    TextView dialogForProgressTipsTv;
    private int k;

    public DialogForProgressTip(Context context, String str) {
        super(context);
        this.k = -1;
        i(R.layout.dialog_for_progress_tips_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.dialogForProgressTipsTv.setText(str);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void p(int... iArr) {
        if (isShowing()) {
            int i = this.k;
            if (i == -1) {
                super.dismiss();
                return;
            }
            if (iArr.length > 0) {
                if (i == iArr[0]) {
                    com.rtk.app.tool.c0.u("DialogForProgressTip", "dismiss pid:" + this.k);
                    super.dismiss();
                    return;
                }
                return;
            }
            com.rtk.app.tool.c0.u("DialogForProgressTip", "dismiss");
            super.dismiss();
        }
    }

    public void q(String str) {
        this.dialogForProgressTipsTv.setText(str);
    }

    public void r(int... iArr) {
        super.show();
        if (iArr.length > 0) {
            this.k = iArr[0];
        }
    }
}
