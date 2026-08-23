package com.qumeng.advlib.core;

import androidx.annotation.Keep;

@Keep
/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface IMultiAdRequest {
    String getBiddingToken(AdRequestParam adRequestParam);

    void invokeADV(AdRequestParam adRequestParam);
}
