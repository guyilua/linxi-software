package com.weigan.loopview;

import android.os.Handler;
import android.os.Message;
import com.weigan.loopview.LoopView;

/* compiled from: MessageHandler.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
final class c extends Handler {
    final LoopView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LoopView loopView) {
        this.a = loopView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.a.invalidate();
        } else if (i == 2000) {
            this.a.h(LoopView.a.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.a.e();
        }
    }
}
