package com.qq.e.ads.interstitial2;

import com.qq.e.comm.util.AdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
