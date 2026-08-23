package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForLoginProgressTip extends o {

    @BindView
    TextView dialogForProgressTipsTv;

    public DialogForLoginProgressTip(Context context, String str) {
        super(context);
        i(R.layout.dialog_for_progress_tips_layout, 80);
        ButterKnife.b(this, getWindow().getDecorView());
        this.dialogForProgressTipsTv.setText(str);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
