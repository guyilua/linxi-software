package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForAttention extends o {

    @BindView
    TextView dialogForAttentionExit;

    @BindView
    TextView dialogForAttentionOk;
    private com.rtk.app.tool.s k;

    public DialogForAttention(Context context, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        i(R.layout.for_attention_dialog_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131297152) {
            this.k.a(new String[0]);
        }
        dismiss();
    }

    public void p() {
        this.dialogForAttentionExit.setOnClickListener(this);
        this.dialogForAttentionOk.setOnClickListener(this);
    }
}
