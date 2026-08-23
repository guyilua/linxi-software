package com.rtk.app.tool;

import android.os.CountDownTimer;

/* compiled from: TimeCount.java */
/* loaded from: /tmp/rtk_apk/classes3.dex */
public class a0 extends CountDownTimer {
    private a a;

    /* compiled from: TimeCount.java */
    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface a {
        void onFinish();

        void onTick(long j);
    }

    public a0(long j, long j2, a aVar) {
        super(j, j2);
        this.a = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.a.onFinish();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.a.onTick(j);
    }
}
