package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForReadAllMessage extends o {

    @BindView
    TextView dialogForread_all_messageExit;

    @BindView
    TextView dialogForread_all_messageOk;
    private com.rtk.app.tool.s k;

    public DialogForReadAllMessage(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.for_read_all_message_dialog_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131297250) {
            this.k.a(new String[0]);
        }
        dismiss();
    }

    public void p() {
        this.dialogForread_all_messageExit.setOnClickListener(this);
        this.dialogForread_all_messageOk.setOnClickListener(this);
    }
}
