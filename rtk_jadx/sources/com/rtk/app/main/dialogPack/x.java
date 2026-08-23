package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.rtk.app.R;

/* compiled from: DialogForUpdateMsgEnSure.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class x extends o {
    private com.rtk.app.tool.s k;
    private String l;
    private String m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;

    public x(Context context, String str, String str2, com.rtk.app.tool.s sVar) {
        super(context);
        this.k = sVar;
        this.l = str2;
        this.m = str;
        i(R.layout.dialog_for_update_ensure_layout, 17);
        p();
        q();
        r();
    }

    private void q() {
        this.n.setText(this.m);
        this.o.setText(this.l);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.rtk.app.tool.s sVar;
        if (view.getId() == 2131297267 && (sVar = this.k) != null) {
            sVar.a(new String[0]);
        }
        dismiss();
    }

    public void p() {
        this.n = (TextView) findViewById(R.id.dialog_for_update_ensure_title);
        this.o = (TextView) findViewById(R.id.dialog_for_update_ensure_tips);
        this.p = (TextView) findViewById(R.id.dialog_for_update_ensure_btuCancel);
        this.q = (TextView) findViewById(R.id.dialog_for_update_ensure_btuEnsure);
    }

    public void r() {
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
    }
}
