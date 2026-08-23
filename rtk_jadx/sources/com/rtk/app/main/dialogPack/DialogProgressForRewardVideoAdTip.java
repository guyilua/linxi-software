package com.rtk.app.main.dialogPack;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.rtk.app.R;
import com.rtk.app.main.MyApplication;
import com.sigmob.sdk.downloader.f;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class DialogProgressForRewardVideoAdTip extends o {

    @BindView
    TextView dialogForProgressTipsTv;
    private Handler k;

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            com.rtk.app.tool.c0.u("DialogProgressForRewardVideoAdTip", "handleMessage");
            if (message.what == 0 && DialogProgressForRewardVideoAdTip.this.isShowing()) {
                com.rtk.app.tool.f.a(MyApplication.b(), "任务请求失败，您可直接下载~", f.a.f);
                DialogProgressForRewardVideoAdTip.this.dismiss();
            }
        }
    }

    public DialogProgressForRewardVideoAdTip(Context context, String str) {
        super(context);
        this.k = new a(Looper.getMainLooper());
        i(R.layout.dialog_for_progress_tips_layout, 17);
        ButterKnife.b(this, getWindow().getDecorView());
        this.dialogForProgressTipsTv.setText(str);
        setCanceledOnTouchOutside(false);
    }

    @Override // com.rtk.app.main.dialogPack.o, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.k.removeMessages(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.rtk.app.main.dialogPack.o, android.app.Dialog
    public void show() {
        super.show();
        Message message = new Message();
        message.what = 0;
        this.k.sendMessageDelayed(message, 10000L);
    }
}
