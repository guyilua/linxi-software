package com.weigan.loopview;

import com.qq.e.comm.constants.ErrorCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmoothScrollTimerTask.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public final class f implements Runnable {
    int a = Integer.MAX_VALUE;
    int b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f1131c;
    final LoopView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LoopView loopView, int i) {
        this.d = loopView;
        this.f1131c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a == Integer.MAX_VALUE) {
            this.a = this.f1131c;
        }
        int i = this.a;
        int i2 = (int) (i * 0.1f);
        this.b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.b = -1;
            } else {
                this.b = 1;
            }
        }
        if (Math.abs(i) <= 0) {
            this.d.a();
            this.d.f1128c.sendEmptyMessage(ErrorCode.NETWORK_UNKNOWN);
        } else {
            LoopView loopView = this.d;
            loopView.u += this.b;
            loopView.f1128c.sendEmptyMessage(1000);
            this.a -= this.b;
        }
    }
}
