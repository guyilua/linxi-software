package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogTipsForCallBack extends o {

    @BindView
    TextView dialogTipForCallbackCancle;

    @BindView
    TextView dialogTipForCallbackLayout;

    @BindView
    TextView dialogTipForCallbackOk;

    @BindView
    TextView dialogTipForCallbackTip;
    private com.rtk.app.tool.s k;

    public DialogTipsForCallBack(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.dialog_tip_for_callback, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.dialogTipForCallbackTip.setText(str);
        setCanceledOnTouchOutside(false);
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131297373) {
            this.k.a("false");
        } else if (id == 2131297375) {
            this.k.a("true");
        }
        dismiss();
    }

    public void p() {
        this.dialogTipForCallbackOk.setOnClickListener(this);
        this.dialogTipForCallbackCancle.setOnClickListener(this);
    }
}
