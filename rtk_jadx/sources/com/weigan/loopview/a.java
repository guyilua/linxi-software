package com.weigan.loopview;

import com.sigmob.sdk.downloader.f;

/* compiled from: InertiaTimerTask.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
final class a implements Runnable {
    float a = 2.1474836E9f;
    final float b;

    /* renamed from: c, reason: collision with root package name */
    final LoopView f1130c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LoopView loopView, float f) {
        this.f1130c = loopView;
        this.b = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a == 2.1474836E9f) {
            if (Math.abs(this.b) <= 2000.0f) {
                this.a = this.b;
            } else if (this.b > com.sigmob.sdk.base.blurkit.c.d) {
                this.a = 2000.0f;
            } else {
                this.a = -2000.0f;
            }
        }
        if (Math.abs(this.a) >= com.sigmob.sdk.base.blurkit.c.d && Math.abs(this.a) <= 20.0f) {
            this.f1130c.a();
            this.f1130c.f1128c.sendEmptyMessage(f.a.f);
            return;
        }
        int i = (int) ((this.a * 10.0f) / 1000.0f);
        LoopView loopView = this.f1130c;
        int i2 = loopView.u - i;
        loopView.u = i2;
        if (!loopView.r) {
            float f = loopView.q * loopView.m;
            int i3 = loopView.v;
            if (i2 <= ((int) ((-i3) * f))) {
                this.a = 40.0f;
                loopView.u = (int) ((-i3) * f);
            } else {
                int size = loopView.k.size() - 1;
                LoopView loopView2 = this.f1130c;
                if (i2 >= ((int) ((size - loopView2.v) * f))) {
                    loopView2.u = (int) (((loopView2.k.size() - 1) - this.f1130c.v) * f);
                    this.a = -40.0f;
                }
            }
        }
        float f2 = this.a;
        if (f2 < com.sigmob.sdk.base.blurkit.c.d) {
            this.a = f2 + 20.0f;
        } else {
            this.a = f2 - 20.0f;
        }
        this.f1130c.f1128c.sendEmptyMessage(1000);
    }
}
