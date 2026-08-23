package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.custom.CustomTextView;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogForProgressHorizontal extends o {

    @BindView
    ImageView dialogForProgressHorizontalButton;

    @BindView
    CustomTextView dialogForProgressHorizontalPercent;

    @BindView
    ProgressBar dialogForProgressHorizontalProgress;

    @BindView
    TextView dialogForProgressHorizontalTipsTv;
    private com.rtk.app.tool.s k;
    private double l;
    private int m;
    private Handler n;
    private long o;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    DialogForProgressHorizontal.this.dialogForProgressHorizontalButton.setEnabled(true);
                    return;
                }
                if (i != 3) {
                    return;
                }
                DialogForProgressHorizontal.this.l -= DialogForProgressHorizontal.this.l / 10.0d;
                DialogForProgressHorizontal.this.dialogForProgressHorizontalPercent.setLeftText(com.rtk.app.tool.c0.k(DialogForProgressHorizontal.this.l) + "/s   ");
                DialogForProgressHorizontal.this.dialogForProgressHorizontalPercent.setText(DialogForProgressHorizontal.this.m + "%");
                return;
            }
            DialogForProgressHorizontal.this.m = (message.arg2 * 100) / message.arg1;
            DialogForProgressHorizontal dialogForProgressHorizontal = DialogForProgressHorizontal.this;
            dialogForProgressHorizontal.dialogForProgressHorizontalProgress.setProgress(dialogForProgressHorizontal.m);
            DialogForProgressHorizontal.this.dialogForProgressHorizontalProgress.setMax(100);
            long currentTimeMillis = System.currentTimeMillis();
            if (DialogForProgressHorizontal.this.o != 0 && currentTimeMillis != DialogForProgressHorizontal.this.o) {
                DialogForProgressHorizontal.this.l = com.rtk.app.tool.o.n.a / ((currentTimeMillis - r12.o) / 1000.0d);
                DialogForProgressHorizontal.this.dialogForProgressHorizontalPercent.setLeftText(com.rtk.app.tool.c0.k(DialogForProgressHorizontal.this.l) + "/s   ");
            }
            DialogForProgressHorizontal.this.dialogForProgressHorizontalPercent.setText(DialogForProgressHorizontal.this.m + "%");
            DialogForProgressHorizontal.this.o = currentTimeMillis;
        }
    }

    public DialogForProgressHorizontal(Context context, String str, com.rtk.app.tool.s sVar) {
        super(context);
        this.n = new a();
        this.o = 0L;
        this.k = sVar;
        i(R.layout.dialog_for_progress_horizontal_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.dialogForProgressHorizontalTipsTv.setText(str);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        v();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 2131297232) {
            return;
        }
        this.dialogForProgressHorizontalButton.setSelected(!r3.isSelected());
        this.k.a(new String[0]);
        this.dialogForProgressHorizontalButton.setEnabled(false);
    }

    public void v() {
        this.dialogForProgressHorizontalButton.setOnClickListener(this);
    }

    public void w(boolean z) {
        this.n.sendEmptyMessage(2);
    }

    public void x(int i, int i2) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i;
        message.arg2 = i2;
        this.n.sendMessage(message);
    }

    public void y() {
        this.n.sendEmptyMessage(3);
    }
}
