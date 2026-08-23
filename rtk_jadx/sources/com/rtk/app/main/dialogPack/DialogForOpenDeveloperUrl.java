package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForOpenDeveloperUrl extends o {

    @BindView
    TextView dialogForOpenDeveloperUrlEnsure;
    private String k;
    private Context l;

    public DialogForOpenDeveloperUrl(Context context, String str) {
        super(context);
        this.l = context;
        this.k = str;
        i(R.layout.dialog_for_open_developer_url_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297223) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.k));
        this.l.startActivity(intent);
        dismiss();
    }

    public void p() {
        this.dialogForOpenDeveloperUrlEnsure.setOnClickListener(this);
    }
}
