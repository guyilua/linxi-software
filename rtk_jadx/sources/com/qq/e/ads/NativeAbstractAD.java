package com.qq.e.ads;

import com.qq.e.comm.util.AdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public abstract class NativeAbstractAD<T> extends AbstractAD<T> {

    /* loaded from: /tmp/rtk_apk/classes3.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(T t) {
    }
}
