package com.rtk.app.main.coins;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.rtk.app.R;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public class QrCodePayActivity_ViewBinding implements Unbinder {
    private QrCodePayActivity b;

    @UiThread
    public QrCodePayActivity_ViewBinding(QrCodePayActivity qrCodePayActivity, View view) {
        this.b = qrCodePayActivity;
        qrCodePayActivity.img = (ImageView) butterknife.c.a.c(view, R.id.img, "field 'img'", ImageView.class);
        qrCodePayActivity.backTv = (TextView) butterknife.c.a.c(view, R.id.backTV, "field 'backTv'", TextView.class);
        qrCodePayActivity.layout = butterknife.c.a.b(view, 2131298916, "field 'layout'");
        qrCodePayActivity.coins = (TextView) butterknife.c.a.c(view, R.id.coins, "field 'coins'", TextView.class);
        qrCodePayActivity.option = (TextView) butterknife.c.a.c(view, R.id.option, "field 'option'", TextView.class);
        qrCodePayActivity.layoutQrcode = butterknife.c.a.b(view, R.id.layout_qrcode, "field 'layoutQrcode'");
    }

    @CallSuper
    public void a() {
        QrCodePayActivity qrCodePayActivity = this.b;
        if (qrCodePayActivity != null) {
            this.b = null;
            qrCodePayActivity.img = null;
            qrCodePayActivity.backTv = null;
            qrCodePayActivity.layout = null;
            qrCodePayActivity.coins = null;
            qrCodePayActivity.option = null;
            qrCodePayActivity.layoutQrcode = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
