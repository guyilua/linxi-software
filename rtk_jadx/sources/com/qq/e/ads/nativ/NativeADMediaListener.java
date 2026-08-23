package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

/* loaded from: /tmp/rtk_apk/classes3.dex */
public interface NativeADMediaListener {
    void onVideoClicked();

    void onVideoCompleted();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoaded(int i);

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady();

    void onVideoResume();

    void onVideoStart();

    void onVideoStop();
}
