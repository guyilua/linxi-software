package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogOtherInfoMore extends o {
    private Context k;
    private String l;
    private String m;
    private int n;

    @BindView
    View nickNameLine;

    @BindView
    TextView nickNameTv;
    private boolean o;

    @BindView
    TextView otherInfoBlacklist;

    @BindView
    TextView otherInfoCancel;

    @BindView
    TextView otherInfoReport;
    private com.rtk.app.tool.j p;
    private com.rtk.app.tool.s q;

    public DialogOtherInfoMore(Context context, String str, String str2, int i, boolean z, com.rtk.app.tool.j jVar, com.rtk.app.tool.s sVar) {
        super(context);
        this.o = false;
        this.l = str;
        this.m = str2;
        this.k = context;
        this.n = i;
        this.o = z;
        this.p = jVar;
        this.q = sVar;
        i(R.layout.dialog_other_info_more_layout, 80);
        ButterKnife.b(this, getWindow().getDecorView());
        this.otherInfoBlacklist.setText(this.n == 0 ? "加入黑名单" : "移出黑名单");
        p();
        this.nickNameTv.setVisibility(this.o ? 0 : 8);
        this.nickNameLine.setVisibility(this.o ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != 2131299609) {
            switch (id) {
                case R.id.dialog_oth_info_blacklist /* 2131297322 */:
                    if (this.n == 0) {
                        new DialogAddBlacklist(this.k, null, null, this.l, this.p).show();
                        break;
                    } else {
                        new DialogRemoveBlacklist(this.k, null, this.l, this.m, this.p).show();
                        break;
                    }
                case R.id.dialog_oth_info_cancel /* 2131297323 */:
                    dismiss();
                    break;
                case R.id.dialog_other_info_report /* 2131297324 */:
                    com.rtk.app.tool.t.S0(this.k, this.l);
                    break;
            }
        } else {
            this.q.a(new String[0]);
        }
        dismiss();
    }

    public void p() {
        this.otherInfoBlacklist.setOnClickListener(this);
        this.otherInfoReport.setOnClickListener(this);
        this.otherInfoCancel.setOnClickListener(this);
        this.nickNameTv.setOnClickListener(this);
    }
}
