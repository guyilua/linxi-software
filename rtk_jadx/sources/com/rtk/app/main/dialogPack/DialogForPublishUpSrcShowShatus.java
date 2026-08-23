package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForPublishUpSrcShowShatus extends o {

    @BindView
    RadioGroup dialogForPublishUpSrcShowStatusGroup;

    @BindView
    RadioButton dialogForPublishUpSrcShowStatusNeedShare;

    @BindView
    RadioButton dialogForPublishUpSrcShowStatusPrivate;

    @BindView
    RadioButton dialogForPublishUpSrcShowStatusPublic;
    private com.rtk.app.tool.s k;
    private TextView l;

    public DialogForPublishUpSrcShowShatus(Context context, int i, TextView textView, com.rtk.app.tool.s sVar) {
        super(context);
        i(R.layout.dialog_for_publish_up_src_show_status, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.k = sVar;
        this.l = textView;
        if (i == 0) {
            this.dialogForPublishUpSrcShowStatusPublic.setChecked(true);
        } else if (i == 1) {
            this.dialogForPublishUpSrcShowStatusNeedShare.setChecked(true);
        } else if (i == 2) {
            this.dialogForPublishUpSrcShowStatusPrivate.setChecked(true);
        }
        p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_for_publish_up_src_show_status_need_share /* 2131297246 */:
                this.k.a("1");
                this.l.setText(this.dialogForPublishUpSrcShowStatusNeedShare.getText());
                break;
            case R.id.dialog_for_publish_up_src_show_status_private /* 2131297247 */:
                this.k.a("2");
                this.l.setText(this.dialogForPublishUpSrcShowStatusPrivate.getText());
                break;
            case R.id.dialog_for_publish_up_src_show_status_public /* 2131297248 */:
                this.k.a("0");
                this.l.setText(this.dialogForPublishUpSrcShowStatusPublic.getText());
                break;
        }
        dismiss();
    }

    public void p() {
        this.dialogForPublishUpSrcShowStatusPublic.setOnClickListener(this);
        this.dialogForPublishUpSrcShowStatusNeedShare.setOnClickListener(this);
        this.dialogForPublishUpSrcShowStatusPrivate.setOnClickListener(this);
    }
}
