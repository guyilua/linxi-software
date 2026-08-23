package com.qq.e.ads.nativ;

import android.view.View;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class NativeADEventListenerWithClickInfo implements NativeADEventListener {
    @Override // com.qq.e.ads.nativ.NativeADEventListener
    public final void onADClicked() {
    }

    public abstract void onADClicked(View view);
}
